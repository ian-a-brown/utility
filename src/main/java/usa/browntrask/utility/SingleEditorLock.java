package usa.browntrask.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import usa.browntrask.annotations.GuardedBy;
import usa.browntrask.annotations.ThreadSafe;

/**
 * A locking class that uses a pair of locks to control access. One lock is a standard read/write lock. The second lock is an
 * exclusive lock that control access to the write side of the read/write lock. By taking control of the edit lock, a thread can
 * gain the exclusive right to modify the protected objects, without locking out read access except when absolutely necessary.
 * <p>
 * This locking class does not currently support the ability to try for a lock without blocking.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Dec 1, 2007
 * @version Dec 1, 2007
 */
@ThreadSafe(author = "Ian Andrew Brown", synopsis = "This class uses synchronization to control access to the state of the locks.")
public final class SingleEditorLock {

	/**
	 * the exclusive lock used to control edit access.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	@GuardedBy("this")
	private final Lock editLock;

	/**
	 * the thread that holds the edit lock.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	@GuardedBy("this")
	private Thread editThread;

	/**
	 * the read lock for the controlled object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	@GuardedBy("this")
	private final Lock readLock;

	/**
	 * the threads that have read locks.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	@GuardedBy("this")
	private final Map<Thread, Integer> readThreads = new HashMap<Thread, Integer>();

	/**
	 * the read/write lock used to control direct access to the object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	private final ReadWriteLock readWriteLock;

	/**
	 * the write lock for the controlled object. Access to this lock is controlled by the edit lock.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	@GuardedBy("editLock")
	private final Lock writeLock;

	/**
	 * the number of times that the write thread has locked the controlled object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	@GuardedBy("this")
	private int writeThreadLocks;

	/**
	 * Constructs a single editor lock.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	public SingleEditorLock() {
		editLock = new ReentrantLock();
		readWriteLock = new ReentrantReadWriteLock();
		writeLock = readWriteLock.writeLock();
		readLock = readWriteLock.readLock();
	}

	/**
	 * Does the current thread have the edit lock?
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return <code>true</code> if the current thread has the edit lock, <code>false</code> otherwise.
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	public final boolean haveEditLock() {
		synchronized (this) {
			return Thread.currentThread() == editThread;
		}
	}

	/**
	 * Does the current thread have a read lock?
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return <code>true</code> if the current thread has a read lock, <code>false</code> otherwise.
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	public final boolean haveReadLock() {
		synchronized (this) {
			return readThreads.get(Thread.currentThread()) != null;
		}
	}

	/**
	 * Does the current thread have the write lock?
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @return <code>true</code> if the current thread has the write lock, <code>false</code> otherwise.
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	public final boolean haveWriteLock() {
		synchronized (this) {
			return (Thread.currentThread() == editThread) && (writeThreadLocks > 0);
		}
	}

	/**
	 * Obtains exclusive access to edit the controlled object.
	 * <p>
	 * This lock is required by the <code>lockForWrite</code> method. Only the current thread will be able to use that method until
	 * the <code>unlockForEdit</code> method is called. No write lock is obtained at this time, leaving readers free to continue to
	 * access the controlled object.
	 * <p>
	 * Until the <code>unlockForEdit</code> method is called, no thread, including the current thread, is allowed to call this
	 * method.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws AlreadyLockedException
	 *             if a thread already has the edit lock.
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	public final void lockForEdit() throws AlreadyLockedException {
		synchronized (this) {
			if (editLock.tryLock()) {
				if (editThread == null) {
					editThread = Thread.currentThread();
				} else {
					editLock.unlock();
					throw new AlreadyLockedException("Cannot obtain edit lock; it is already held by " + editThread);
				}
			} else {
				throw new AlreadyLockedException("Cannot obtain edit lock; it is already held by " + editThread);
			}
		}
	}

	/**
	 * Acquires a read lock for the controlled object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	public final void lockForRead() {
		synchronized (this) {
			readLock.lock();
			if (haveReadLock()) {
				int count = readThreads.get(Thread.currentThread());
				++count;
				readThreads.put(Thread.currentThread(), count);
			} else {
				readThreads.put(Thread.currentThread(), 1);
			}
		}
	}

	/**
	 * Acquires a write lock for the controlled object. The write lock can only be obtained if the current thread already has the
	 * edit lock.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws IllegalLockException
	 *             if the current thread does not have the edit lock.
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	public final void lockForWrite() throws IllegalLockException {
		synchronized (this) {
			if (Thread.currentThread() == editThread) {
				writeLock.lock();
				++writeThreadLocks;
			} else {
				throw new IllegalLockException("Cannot obtain write lock without the edit lock; edit lock is held by " + editThread);
			}
		}
	}

	/**
	 * Releases the exclusive right to edit the controlled object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws IllegalLockException
	 *             if the current thread is not the owner of the edit lock.
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	public final void unlockForEdit() throws IllegalLockException {
		synchronized (this) {
			if (haveEditLock()) {
				editLock.unlock();
				editThread = null;
			} else {
				throw new IllegalLockException("Cannot release edit lock; it is held by " + editThread);
			}
		}
	}

	/**
	 * Releases a read lock for the current thread.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	public final void unlockForRead() {
		synchronized (this) {
			if (haveReadLock()) {
				readLock.unlock();
				int count = readThreads.get(Thread.currentThread());
				--count;
				if (count == 0) {
					readThreads.remove(Thread.currentThread());
				} else {
					readThreads.put(Thread.currentThread(), count);
				}
			}
		}
	}

	/**
	 * Releases the write lock on the controlled object.
	 * <p>
	 * 
	 * @author Ian Andrew Brown
	 * @throws IllegalLockException
	 *             if the current thread does not have the edit lock.
	 * @since V0.1.1 Dec 1, 2007
	 * @version Dec 1, 2007
	 */
	public final void unlockForWrite() throws IllegalLockException {
		synchronized (this) {
			if (haveEditLock()) {
				writeLock.unlock();
				--writeThreadLocks;
			} else {
				throw new IllegalLockException("Current thread does not have edit lock; it is held by " + editThread);
			}
		}
	}
}
