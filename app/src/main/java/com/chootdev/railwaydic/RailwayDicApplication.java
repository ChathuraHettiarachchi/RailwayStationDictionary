package com.chootdev.railwaydic;

import android.app.Application;

import com.chootdev.railwaydic.db.DaoMaster;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Choota on 10/1/17.
 * Email   : chathura93@yahoo.com
 * GitHub  : https://github.com/chathurahettiarachchi
 * Company : Fidenz Technologies
 */

public class RailwayDicApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "railwaydic-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }
}
