package usa.browntrask.utility.impl.tables;

import usa.browntrask.annotations.GuardedBy;
import usa.browntrask.annotations.ThreadSafe;
import usa.browntrask.utility.tables.IllegalTableException;
import usa.browntrask.utility.tables.Table;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of a Table.
 * <p>
 *
 * @author Ian Andrew Brown
 * @version Jul 26, 2018
 * @since V0.1.1 Nov 7, 2007
 */
@ThreadSafe(author = "Ian Andrew Brown", synopsis = "This class achieves its thread safety by protecting all update and read operations through synchronization. Values provided by the client or to the client are either primitives or strings.")
/* package */ final class TableImpl implements Table {

    /**
     * the name of the object.
     * <p>
     *
     * @author Ian Andrew Brown
     * @version Nov 11, 2007
     * @since V0.1.1 Nov 11, 2007
     */
    protected final String name;

    /**
     * the names of the columns mapped to their indexes.
     * <p>
     *
     * @author Ian Andrew Brown
     * @version May 10, 2008
     * @since V0.1.1 Nov 7, 2007
     */
    @GuardedBy("this")
    private final Map<String, Integer> columnNames = new LinkedHashMap<String, Integer>();
    /**
     * the names of the rows mapped to their indexes.
     * <p>
     *
     * @author Ian Andrew Brown
     * @version Mmay 10, 2008
     * @since V0.1.1 Nov 15, 2007
     */
    @GuardedBy("this")
    private final Map<String, Integer> rowNameIndexes = new LinkedHashMap<String, Integer>();
    /**
     * the name of the key column for the table.
     * <p>
     *
     * @author Ian Andrew Brown
     * @version Nov 30, 2007
     * @since V0.1.1 Nov 15, 2007
     */
    @GuardedBy("this")
    private String keyColumnName;
    /**
     * the number of columns in the table.
     * <p>
     *
     * @author Ian Andrew Brown
     * @version Nov 30, 2007
     * @since V0.1.1 Nov 7, 2007
     */
    @GuardedBy("this")
    private int numberOfColumnsPerRow = 0;
    /**
     * the values stored in the table.
     * <p>
     *
     * @author Ian Andrew Brown
     * @version Nov 30, 2007
     * @since V0.1.1 Nov 7, 2007
     */
    @GuardedBy("this")
    private String[][] values;

    /**
     * Constructs a table with the specified name.
     * <p>
     *
     * @param name the name of the table.
     * @author Ian Andrew Brown
     * @version Jul 26, 2018
     * @since V0.1.1 Nov 10, 2007
     */
    /* package */TableImpl(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int addColumn(final String columnName) {
        synchronized (this) {
            if (columnNames.get(columnName) != null) {
                throw new IllegalTableException("Cannot have multiple columns named " + columnName);
            }
            columnNames.put(columnName, numberOfColumnsPerRow);
            return numberOfColumnsPerRow++;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int addKeyColumn(final String columnName) {
        synchronized (this) {
            if (keyColumnName != null) {
                throw new IllegalTableException("Cannot change the key column name once it has been set");
            }
            keyColumnName = columnName;
            return addColumn(columnName);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int addRow(final String rowName) {
        synchronized (this) {
            if (rowNameIndexes.get(rowName) != null) {
                throw new IllegalTableException(
                        "Cannot have multiple rows named " + rowName);
            }
            final int rowIndex = (values == null) ? 0 : values.length;
            rowNameIndexes.put(rowName, rowIndex);
            setValue(rowIndex, keyColumnName, rowName);
            return rowIndex;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int columnIndex(final String columnName) {
        synchronized (this) {
            return columnNames.get(columnName);
        }
    }

    /**
     * @{InheritDoc}
     */
    @Override
    public List<String> columnNames() {
        synchronized (this) {
            final List<String> names = new ArrayList<>(columnNames.size());

            for (final Map.Entry<String, Integer> column : columnNames.entrySet()) {
                names.set(column.getValue(), column.getKey());
            }

            return names;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final boolean equals(final Object object) {
        if (getClass().isInstance(object)) {
            final Table other = (Table) object;

            return getName().equals(other.getName());
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getValue(final int rowIndex, final int columnIndex) {
        synchronized (this) {
            return values[rowIndex][columnIndex];
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getValue(final int rowIndex, final String columnName) {
        synchronized (this) {
            final int columnIndex = columnIndex(columnName);
            return getValue(rowIndex, columnIndex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String getValue(final String rowName, final String columnName) {
        synchronized (this) {
            final int rowIndex = rowIndex(rowName);
            return getValue(rowIndex, columnName);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int hashCode() {
        int result = 17;
        result = result * 37 + getName().hashCode();
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int numberOfColumns() {
        return numberOfColumnsPerRow;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int numberOfRows() {
        synchronized (this) {
            return (values == null) ? rowNameIndexes.size() : values.length;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final int rowIndex(final String rowName) {
        synchronized (this) {
            return rowNameIndexes.get(rowName);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final List<String> rowNames() {
        final List<String> names = new ArrayList<String>();
        synchronized (this) {
            for (final Map.Entry<String, Integer> nameEntry : rowNameIndexes
                    .entrySet()) {
                final int index = nameEntry.getValue();
                final String rowName = nameEntry.getKey();
                names.add(index, rowName);
            }
        }
        return names;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setValue(final int rowIndex, final int columnIndex,
                               final String value) {
        synchronized (this) {
            increaseTableRows(rowIndex + 1);

            if (values[rowIndex] == null) {
                values[rowIndex] = new String[numberOfColumnsPerRow + 1];
            } else if (values[rowIndex].length < numberOfColumnsPerRow) {
                final String[] oldRow = values[rowIndex];
                values[rowIndex] = new String[numberOfColumnsPerRow];
                System.arraycopy(oldRow, 0, values[rowIndex], 0, oldRow.length);
            }

            if (values[rowIndex][columnIndex] != null) {
                throw new IllegalTableException("Cannot change a cell @"
                                                + rowIndex + ", " + columnIndex
                                                + " once it has been set");
            }
            values[rowIndex][columnIndex] = value;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final void setValue(final int rowIndex, final String columnName,
                               final String value) {
        synchronized (this) {
            final int columnIndex = columnNames.get(columnName);
            setValue(rowIndex, columnIndex, value);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public final String toString() {
        final StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("Table ").append(getName());

        return stringBuffer.toString();
    }

    /**
     * Increases the number of rows in the table to the specified number.
     * <p>
     *
     * @param numberOfRows the new number of rows in the table.
     * @author Ian Andrew Brown
     * @version Nov 15, 2007
     * @since V0.1.1 Nov 15, 2007
     */
    private final void increaseTableRows(final int numberOfRows) {
        if (values == null) {
            values = new String[numberOfRows][];
        } else if (values.length < numberOfRows) {
            final String[][] oldValues = values;
            values = new String[numberOfRows][];
            System.arraycopy(oldValues, 0, values, 0, oldValues.length);
        }
    }
}
