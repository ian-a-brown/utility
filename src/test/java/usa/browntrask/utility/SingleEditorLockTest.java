package usa.browntrask.utility;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

/**
 * Test for {@link usa.browntrask.utility.SingleEditorLock}.
 * <p>
 * 
 * @author Ian Andrew Brown
 * @since V0.1.1 Dec 1, 2007
 * @version Dec 1, 2007
 */
public final class SingleEditorLockTest {

    /**
     * Test method for
     * {@link usa.browntrask.utility.SingleEditorLock#lockForEdit()} for the
     * case where the thread gets the lock.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @throws AlreadyLockedException
     *                 if the edit lock is already locked.
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    @Test
    public final void testLockForEdit() throws AlreadyLockedException {
	final SingleEditorLock singleEditorLock = new SingleEditorLock();

	singleEditorLock.lockForEdit();

	assertTrue("Current thread should have obtained lock", singleEditorLock
		.haveEditLock());
    }

    /**
     * Test method for
     * {@link usa.browntrask.utility.SingleEditorLock#lockForEdit()} for the
     * case where the lock is held by some other thread.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @throws InterruptedException
     *                 if the operation is interrupted.
     * @throws ExecutionException
     *                 if the execution throws an exception other than the
     *                 already locked exception.
     * @throws AlreadyLockedException
     *                 if the edit lock is already locked by another thread.
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    @Test(expected = AlreadyLockedException.class)
    public final void testLockForEdit_lockedByAnotherThread()
	    throws InterruptedException, ExecutionException,
	    AlreadyLockedException {
	final ExecutorService executor = Executors.newFixedThreadPool(1);
	final SingleEditorLock singleEditorLock = new SingleEditorLock();

	try {
	    singleEditorLock.lockForEdit();
	} catch (AlreadyLockedException e) {
	    fail("Failed to obtain initial lock");
	}

	final Callable<Boolean> secondTry = new Callable<Boolean>() {

	    @Override
	    public Boolean call() throws AlreadyLockedException {

		singleEditorLock.lockForEdit();
		return Boolean.FALSE;
	    }

	};
	final Future<Boolean> future = executor.submit(secondTry);

	try {
	    future.get();
	} catch (ExecutionException e) {
	    if (e.getCause() instanceof AlreadyLockedException) {
		throw (AlreadyLockedException) e.getCause();
	    } else {
		throw e;
	    }
	}
    }

    /**
     * Test method for
     * {@link usa.browntrask.utility.SingleEditorLock#lockForEdit()} for the
     * case where the lock is held by the current thread.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @throws AlreadyLockedException
     *                 if the edit lock is already locked.
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    @Test(expected = AlreadyLockedException.class)
    public final void testLockForEdit_lockedByCurrentThread()
	    throws AlreadyLockedException {
	final SingleEditorLock singleEditorLock = new SingleEditorLock();

	try {
	    singleEditorLock.lockForEdit();
	} catch (AlreadyLockedException e) {
	    fail("Failed to obtain initial lock");
	}

	singleEditorLock.lockForEdit();
    }

    /**
     * Test method for
     * {@link usa.browntrask.utility.SingleEditorLock#lockForRead()}.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    @Test
    public final void testLockForRead() {
	final SingleEditorLock singleEditorLock = new SingleEditorLock();

	singleEditorLock.lockForRead();

	assertTrue("Current thread should have read lock", singleEditorLock
		.haveReadLock());
    }

    /**
     * Test method for
     * {@link usa.browntrask.utility.SingleEditorLock#lockForWrite()} for the
     * case where the current thread does not have the edit lock.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @throws IllegalLockException
     *                 if the current thread does not have the edit lock.
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    @Test(expected = IllegalLockException.class)
    public final void testLockForWrite_doesNotHaveEditLock()
	    throws IllegalLockException {
	final SingleEditorLock singleEditorLock = new SingleEditorLock();

	singleEditorLock.lockForWrite();
    }

    /**
     * Test method for
     * {@link usa.browntrask.utility.SingleEditorLock#lockForWrite()} for the
     * case where the current thread does have the edit lock.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @throws IllegalLockException
     *                 if the current thread does not have the edit lock.
     * @throws AlreadyLockedException
     *                 if the edit lock was owned by something else.
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    @Test
    public final void testLockForWrite_hasEditLock()
	    throws IllegalLockException, AlreadyLockedException {
	final SingleEditorLock singleEditorLock = new SingleEditorLock();

	singleEditorLock.lockForEdit();
	singleEditorLock.lockForWrite();

	assertTrue("Should have obtained write lock", singleEditorLock
		.haveWriteLock());
    }

    /**
     * Test method for
     * {@link usa.browntrask.utility.SingleEditorLock#unlockForEdit()} for the
     * case where the current thread owns the lock.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @throws IllegalLockException
     *                 if the current thread is not the owner of the edit lock.
     * @throws AlreadyLockedException
     *                 if there is a problem obtaining the edit lock.
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    @Test
    public final void testUnlockForEdit_isOwner() throws IllegalLockException,
	    AlreadyLockedException {
	final SingleEditorLock singleEditorLock = new SingleEditorLock();
	singleEditorLock.lockForEdit();

	singleEditorLock.unlockForEdit();

	assertFalse("Current thread should no longer hold the edit lock",
		singleEditorLock.haveEditLock());
    }

    /**
     * Test method for
     * {@link usa.browntrask.utility.SingleEditorLock#unlockForEdit()} for the
     * case where the current thread does not own the lock.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @throws IllegalLockException
     *                 if the current thread is not the owner of the edit lock.
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    @Test(expected = IllegalLockException.class)
    public final void testUnlockForEdit_notOwner() throws IllegalLockException {
	final SingleEditorLock singleEditorLock = new SingleEditorLock();

	singleEditorLock.unlockForEdit();
    }

    /**
     * Test method for
     * {@link usa.browntrask.utility.SingleEditorLock#unlockForRead()}.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    @Test
    public final void testUnlockForRead() {
	final SingleEditorLock singleEditorLock = new SingleEditorLock();
	singleEditorLock.lockForRead();

	singleEditorLock.unlockForRead();

	assertFalse("Should not have read lock", singleEditorLock
		.haveReadLock());
    }

    /**
     * Test method for
     * {@link usa.browntrask.utility.SingleEditorLock#unlockForRead()} for the
     * case where read lock was obtained multiple times.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    @Test
    public final void testUnlockForRead_multipleLocks() {
	final SingleEditorLock singleEditorLock = new SingleEditorLock();
	singleEditorLock.lockForRead();
	singleEditorLock.lockForRead();

	singleEditorLock.unlockForRead();

	assertTrue("Should still have read lock", singleEditorLock
		.haveReadLock());

	singleEditorLock.unlockForRead();

	assertFalse("Should no longer have read lock", singleEditorLock
		.haveReadLock());
    }

    /**
     * Test method for
     * {@link usa.browntrask.utility.SingleEditorLock#unlockForWrite()} for the
     * case where the current thread does not have the edit lock.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @throws IllegalLockException
     *                 if the current thread does not have the edit lock.
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    @Test(expected = IllegalLockException.class)
    public final void testUnlockForWrite_doesNotHaveEditLock()
	    throws IllegalLockException {
	final SingleEditorLock singleEditorLock = new SingleEditorLock();

	singleEditorLock.unlockForWrite();
    }

    /**
     * Test method for
     * {@link usa.browntrask.utility.SingleEditorLock#unlockForWrite()}.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @throws IllegalLockException
     *                 if the current thread does not have the edit lock.
     * @throws AlreadyLockedException
     *                 if the edit lock is owned by another thread.
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    @Test
    public final void testUnlockForWrite() throws IllegalLockException,
	    AlreadyLockedException {
	final SingleEditorLock singleEditorLock = new SingleEditorLock();
	singleEditorLock.lockForEdit();
	singleEditorLock.lockForWrite();

	singleEditorLock.unlockForWrite();

	assertFalse("Should no longer have write lock", singleEditorLock
		.haveWriteLock());
    }

    /**
     * Test method for
     * {@link usa.browntrask.utility.SingleEditorLock#unlockForWrite()} for the
     * case where the write lock was obtained multiple times.
     * <p>
     * 
     * @author Ian Andrew Brown
     * @throws IllegalLockException
     *                 if the current thread does not have the edit lock.
     * @throws AlreadyLockedException
     *                 if the edit lock is owned by another thread.
     * @since V0.1.1 Dec 1, 2007
     * @version Dec 1, 2007
     */
    @Test
    public final void testUnlockForWrite_multipleLocks()
	    throws IllegalLockException, AlreadyLockedException {
	final SingleEditorLock singleEditorLock = new SingleEditorLock();
	singleEditorLock.lockForEdit();
	singleEditorLock.lockForWrite();
	singleEditorLock.lockForWrite();

	singleEditorLock.unlockForWrite();

	assertTrue("Should still have write lock", singleEditorLock
		.haveWriteLock());

	singleEditorLock.unlockForWrite();

	assertFalse("Should no longer have write lock", singleEditorLock
		.haveWriteLock());
    }

}
