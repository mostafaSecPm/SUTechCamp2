package evoteam.ir.example;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by programmer on 05-Sep-17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    final static int VERSION = 1 ;
    final static String DATABASE_NAME = "taks.db" ;

    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + DataBaseSchema.TaskDataBase.TABLE_NAME + "(" +
                " _id integer primary key autoincrement, " +
                DataBaseSchema.TaskDataBase.cols.NAME + ", " +
                DataBaseSchema.TaskDataBase.cols.DAY + ", " +
                DataBaseSchema.TaskDataBase.cols.DATE + ", " +
                DataBaseSchema.TaskDataBase.cols.TIME + ", " +
                DataBaseSchema.TaskDataBase.cols.DESC + ", " +
                DataBaseSchema.TaskDataBase.cols.IMPORTANCE +
                ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
