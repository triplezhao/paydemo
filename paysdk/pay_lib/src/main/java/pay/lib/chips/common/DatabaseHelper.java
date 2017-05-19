package pay.lib.chips.common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import com.potato.library.PotatoConfig;

import pay.lib.data.db.DemoDAO;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static String DB_NAME = PotatoConfig.DB_NAME;
    ;
    private static DatabaseHelper sInstance;

    private DatabaseHelper(Context context) {
        this(context, DB_NAME, null, DB_VERSION);
    }

    private DatabaseHelper(Context context, String name, CursorFactory factory,
                           int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        DemoDAO.createTable(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public static DatabaseHelper getInstance(Context context) {
        if (sInstance == null)
            sInstance = new DatabaseHelper(context);
        return sInstance;
    }
}
