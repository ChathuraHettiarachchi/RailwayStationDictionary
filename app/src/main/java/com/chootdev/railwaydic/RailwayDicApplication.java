package com.chootdev.railwaydic;

import android.app.Application;

import com.chootdev.railwaydic.db.DaoMaster;
import com.chootdev.railwaydic.db.DaoSession;
import com.facebook.stetho.Stetho;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Choota on 10/1/17.
 * Email   : chathura93@yahoo.com
 * GitHub  : https://github.com/chathurahettiarachchi
 * Company : Fidenz Technologies
 */

public class RailwayDicApplication extends Application {

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "railwaydic-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

        Stetho.initializeWithDefaults(this);
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
