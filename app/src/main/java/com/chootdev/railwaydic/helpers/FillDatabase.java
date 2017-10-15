package com.chootdev.railwaydic.helpers;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;

import com.chootdev.railwaydic.R;
import com.chootdev.railwaydic.RailwayDicApplication;
import com.chootdev.railwaydic.db.DaoSession;
import com.chootdev.railwaydic.db.StationModel;
import com.chootdev.railwaydic.db.StationModelDao;
import com.chootdev.railwaydic.models.StationResponse;
import com.chootdev.railwaydic.models.StationSingle;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Choota on 10/15/17.
 * Email   : chathura93@yahoo.com
 * GitHub  : https://github.com/chathurahettiarachchi
 * Company : Fidenz Technologies
 */

public class FillDatabase {
    private static Context context;
    private static FillDatabase fillDatabase;

    private static FillDBCallback callback;
    private static ProgressDialog dialog;
    private static boolean isDBCreated;
    private static DaoSession daoSession;

    public static FillDatabase init(Context appContext, FillDBCallback appCallback) {
        if (fillDatabase == null)
            fillDatabase = new FillDatabase();

        context = appContext;
        callback = appCallback;

        dialog = new ProgressDialog(context);
        dialog.setCancelable(false);

        daoSession = ((RailwayDicApplication) context.getApplicationContext()).getDaoSession();
        isDBCreated = UserDefaults.isDBUpdated(context);

        return fillDatabase;
    }

    public static void requestDataPopulation() {
        if (!isDBCreated)
            dialog.setMessage("Initializing...");
        else
            dialog.setMessage("Loading...");

        dialog.show();
        new SetupDBWithDataAsync().execute();
    }

    private static void sendData(final List<StationModel> datalist) {
        dialog.setMessage("Populating...");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dialog.dismiss();
                callback.onPopulateFinished((datalist != null ? true : false), datalist);
            }
        }, 1000);
    }

    public interface FillDBCallback {
        void onPopulateFinished(boolean status, List<StationModel> stations);
    }

    private static class SetupDBWithDataAsync extends AsyncTask<Void, Void, List<StationModel>> {

        @Override
        protected List<StationModel> doInBackground(Void... params) {
            dialog.setMessage("Wait little more...");

            StationModelDao modelDao = daoSession.getStationModelDao();
            List<StationModel> dataList = new ArrayList<>();

            if (isDBCreated) {
                dataList = modelDao.loadAll();
            } else {
                String dataJSON= ReadJSON.jsonFileToString(context.getResources().openRawResource(R.raw.data));
                StationResponse dataResponce = new Gson().fromJson(dataJSON, StationResponse.class);

                modelDao.deleteAll();
                for (StationSingle st : dataResponce.getArray()) {
                    StationModel stationModel = new StationModel(null, st.getStationCode(), st.getStationName(),
                            st.getType(), st.getTelephone(), st.getDistenceMiles(), st.getDistenceKm(),
                            st.getHeightFeet(), st.getHeightMeters(), st.getStationCodeNo());

                    dataList.add(stationModel);
                    modelDao.insert(stationModel);
                }

                UserDefaults.updateInit(context, true);
            }

            return dataList;
        }

        @Override
        protected void onPostExecute(List<StationModel> data) {
            super.onPostExecute(data);
            sendData(data);
        }
    }
}
