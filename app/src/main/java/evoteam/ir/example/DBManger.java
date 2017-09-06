package evoteam.ir.example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import evoteam.ir.example.DataBaseSchema.TaskDataBase ;

/**
 * Created by programmer on 05-Sep-17.
 */

public class DBManger {

    Context mContext ;
    SQLiteDatabase mDatabase ;

    public DBManger(Context context) {
        mContext = context.getApplicationContext();
        mDatabase = new DataBaseHelper(mContext).getWritableDatabase();
    }

    public void addTask (Task task) {
        ContentValues contentValues = getTaskData(task) ;
        mDatabase.insert(TaskDataBase.TABLE_NAME , null , contentValues) ;
    }

    private ContentValues getTaskData(Task task) {
        ContentValues values = new ContentValues() ;

        values.put(TaskDataBase.cols.NAME, task.getName());
        values.put(TaskDataBase.cols.DATE, task.getDate());
        values.put(TaskDataBase.cols.DAY, task.getDay());
        values.put(TaskDataBase.cols.DESC, task.getDesc());
        values.put(TaskDataBase.cols.TIME, task.getTime());
        values.put(TaskDataBase.cols.IMPORTANCE, task.getImportance());

        return values ;
    }

    public ArrayList<Task> getTasks () {
        ArrayList<Task> tasks = new ArrayList<>() ;

        TaskCursorWrapper mCursorWrapper = queryTasks();

        mCursorWrapper.moveToFirst() ;

        while ( ! mCursorWrapper.isAfterLast() ){
            tasks.add(mCursorWrapper.getTask()) ;
            mCursorWrapper.moveToNext() ;
        }
        return tasks ;
    }

    public TaskCursorWrapper queryTasks () {
        Cursor cursor = mDatabase.query(TaskDataBase.TABLE_NAME ,null ,
                null , null , null ,null , null , null );
        return new TaskCursorWrapper(cursor) ;
    }

    public void delet () {
        mDatabase.delete(TaskDataBase.TABLE_NAME, TaskDataBase.cols.DAY + "= friday" , null);
    }

}
