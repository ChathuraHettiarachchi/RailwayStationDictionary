package com.chootdev.railwaydic.alerts;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chootdev.railwaydic.R;
import com.chootdev.railwaydic.db.StationModel;

/**
 * Created by Choota on 10/15/17.
 * Email   : chathura93@yahoo.com
 * GitHub  : https://github.com/chathurahettiarachchi
 * Company : Fidenz Technologies
 */

public class StationDataAlert {
    private Context context;
    private Dialog dialog;
    private StationDataAlertCallback callback;
    private TextView tvName;
    private TextView tvCodeName;
    private TextView tvCode;
    private TextView tvType;
    private TextView tvMiles;
    private TextView tvKm;
    private TextView tvFeets;
    private TextView tvMeters;
    private Button btnContacat;
    private Button btnCancel;

    public StationDataAlert(Context context, StationDataAlertCallback callback) {
        this.context = context;
        this.callback = callback;

        this.dialog = new Dialog(context, R.style.ActionSheet);
    }

    public void show(final StationModel model) {
        dialog.setContentView(R.layout.dialog_station_info);
        initView();

        tvName.setText((model.getName() != null) ? model.getName():"N/A");
        tvCode.setText((model.getStation_code_no() != null) ? model.getStation_code_no():"N/A");
        tvCodeName.setText((model.getStation_code() != null) ? model.getStation_code():"N/A");
        tvType.setText((model.getType() != null) ? model.getType():"N/A");
        tvMiles.setText((model.getDistence_miles() != null) ? model.getDistence_miles():"N/A");
        tvKm.setText((model.getDistence_km() != null) ? model.getDistence_km():"N/A");
        tvFeets.setText((model.getHeight_feet() != null) ? model.getHeight_feet():"N/A");
        tvMeters.setText((model.getHeight_meters() != null) ? model.getHeight_meters():"N/A");

        btnContacat.setText("Contact "+((model.getName() != null) ? (("\""+model.getName()+"\" "+model.getType())) : model.getType()));
        btnContacat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onCallPressed(model);
                dialog.dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = ((displayMetrics.widthPixels / displayMetrics.density));
        int width = (int) (dpWidth * displayMetrics.scaledDensity * 0.8);

        dialog.show();
        dialog.setCancelable(false);
        dialog.getWindow().setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#00ffffff")));
    }

    private void initView() {
        tvName = (TextView) dialog.findViewById(R.id.tvName);
        tvCodeName = (TextView) dialog.findViewById(R.id.tvCodeName);
        tvCode = (TextView) dialog.findViewById(R.id.tvCode);
        tvType = (TextView) dialog.findViewById(R.id.tvType);
        tvMiles = (TextView) dialog.findViewById(R.id.tvMiles);
        tvKm = (TextView) dialog.findViewById(R.id.tvKm);
        tvFeets = (TextView) dialog.findViewById(R.id.tvFeets);
        tvMeters = (TextView) dialog.findViewById(R.id.tvMeters);
        btnContacat = (Button) dialog.findViewById(R.id.btnContacat);
        btnCancel = (Button) dialog.findViewById(R.id.btnCancel);
    }

    public interface StationDataAlertCallback {
        void onCallPressed(StationModel model);
    }
}
