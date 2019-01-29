package com.example.anub.mvvmdemo.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;

import com.example.anub.mvvmdemo.model.PostResponse;

import static android.arch.persistence.room.ColumnInfo.TEXT;
import static android.graphics.PorterDuff.Mode.ADD;

@Database(entities = {PostResponse.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "postDatabase.db";
    private static volatile AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = create(context);
        }
        return instance;
    }

    private static AppDatabase create(final Context context) {
        return Room.databaseBuilder(
                context,
                AppDatabase.class,
                DB_NAME).allowMainThreadQueries()
                .addMigrations(FROM_1_TO_2)
                .build();
    }

    public abstract PostDao getpostDao();


    static final Migration FROM_1_TO_2 = new Migration(1, 2) {
        @Override
        public void migrate(final SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE postResponse ADD COLUMN createdAt TEXT");
        }
    };

}
