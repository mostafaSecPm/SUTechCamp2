package evoteam.ir.example;

import android.database.Cursor;
import android.database.CursorWrapper;
import evoteam.ir.example.DataBaseSchema.TaskDataBase ;

/**
 * Created by programmer on 05-Sep-17.
 */

public class TaskCursorWrapper extends CursorWrapper {
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public TaskCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    public Task getTask () {
        Task task = new Task() ;
        task.setName(getString(getColumnIndex(TaskDataBase.cols.NAME)) );
        task.setDate(getString(getColumnIndex(TaskDataBase.cols.DATE)) );
        task.setDay(getString(getColumnIndex(TaskDataBase.cols.DAY)) );
        task.setDesc(getString(getColumnIndex(TaskDataBase.cols.DESC)) );
        task.setImportance(getString(getColumnIndex(TaskDataBase.cols.IMPORTANCE)) );
        task.setTime(getString(getColumnIndex(TaskDataBase.cols.TIME)) );

        return task ;
    }
}
