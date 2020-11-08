package br.edu.uni.si.myactivities.conn;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String mDatabaseName = "activities.db";
    private static final int mVersion = 1;

    public DatabaseHelper(Context context) {
        super(context, mDatabaseName, null, mVersion);
    }

    public DatabaseHelper(@Nullable Context context, @Nullable String name,
                          @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(ScriptDLL.getCreateTablePessoa());
//        db.execSQL(ScriptDLL.getCreateTableAtividade());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
