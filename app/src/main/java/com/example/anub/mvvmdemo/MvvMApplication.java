package com.example.anub.mvvmdemo;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.anub.mvvmdemo.room.AppDatabase;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MvvMApplication extends Application {


    private static final String DATABASE_NAME = "db_posts";
    public static MvvMApplication INSTANCE;
    AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name(Realm.DEFAULT_REALM_NAME)
                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        INSTANCE=this;

    }

    public static MvvMApplication getApplicationInstance() {
        return INSTANCE;
    }
}
