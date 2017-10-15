package com.chootdev.railwaydic.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.chootdev.csnackbar.Duration;
import com.chootdev.csnackbar.Snackbar;
import com.chootdev.csnackbar.Type;
import com.chootdev.railwaydic.R;
import com.chootdev.railwaydic.db.StationModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Choota on 10/15/17.
 * Email   : chathura93@yahoo.com
 * GitHub  : https://github.com/chathurahettiarachchi
 * Company : Fidenz Technologies
 */

public class StationListAdapter extends RecyclerView.Adapter<StationListAdapter.Holder> {
    private Context context;
    private StationFilterCallback callback;

    private List<StationModel> items;
    private List<StationModel> orig;

    public StationListAdapter(Context context, StationFilterCallback callback,List<StationModel> items) {
        this.context = context;
        this.callback = callback;
        this.orig = items;
        this.items = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(context).inflate(R.layout.widget_station, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        final StationModel item = items.get(position);

        holder.name.setText((item.getName() != null ? item.getName() : "N/A"));
        holder.nameCode.setText("Name: "+(item.getStation_code() != null ? item.getStation_code() : "N/A"));
        holder.code.setText("Code: "+(item.getStation_code_no() != null ? item.getStation_code_no() : "N/A"));

        holder.btnCall.setBackgroundResource((item.getTelephone() != null) ? R.drawable.icon_call:R.drawable.icon_call_dis);
        holder.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String phone = item.getTelephone();
                    if (phone != null && phone.length() != 0) {
                        makeCall(phone, (item.getName() != null ? item.getName() : ""));
                    } else {
                        Snackbar.with(context, null)
                                .type(Type.ERROR)
                                .message("No number found...")
                                .duration(Duration.SHORT)
                                .show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void makeCall(final String number, final String stationName) {

        Snackbar.with(context, null)
                .type(Type.SUCCESS)
                .message("Calling " + stationName + " station...")
                .duration(Duration.SHORT)
                .show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                context.startActivity(intent);
            }
        }, 500);

    }

    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final List<StationModel> results = new ArrayList<>();
                if (orig == null)
                    orig = items;
                if (constraint != null) {
                    if (orig != null && orig.size() > 0) {
                        for (final StationModel g : orig) {
                            if (g.getName().toLowerCase().contains(constraint.toString().toLowerCase()))
                                results.add(g);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                items = (List<StationModel>) results.values;

                if (items == null || items.size() == 0)
                    callback.onStationFilter(false);
                else
                    callback.onStationFilter(true);

                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getItemCount() {
        return (items != null ? items.size() : 0);
    }

    public class Holder extends RecyclerView.ViewHolder {

        public TextView name, nameCode, code;
        public ImageButton btnCall;

        public Holder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.tvStationName);
            nameCode = (TextView) itemView.findViewById(R.id.tvStationCodeName);
            code = (TextView) itemView.findViewById(R.id.tvStationCode);
            btnCall = (ImageButton) itemView.findViewById(R.id.btnCall);
        }
    }

    public interface StationFilterCallback{
        void onStationFilter(boolean isHavingResults);
    }
}
