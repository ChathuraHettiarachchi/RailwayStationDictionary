package com.chootdev.railwaydic.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chootdev.csnackbar.Duration;
import com.chootdev.csnackbar.Snackbar;
import com.chootdev.csnackbar.Type;
import com.chootdev.railwaydic.R;
import com.chootdev.railwaydic.adapters.StationListAdapter;
import com.chootdev.railwaydic.db.StationModel;
import com.chootdev.railwaydic.helpers.FillDatabase;

import java.util.List;

public class MainActivity extends AppCompatActivity implements FillDatabase.FillDBCallback, StationListAdapter.StationFilterCallback {

    private StationListAdapter adapter;

    private EditText edtSearch;
    private Button btnClear;
    private RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        FillDatabase.init(MainActivity.this, this);
        FillDatabase.requestDataPopulation();
    }

    private void initView() {
        edtSearch = (EditText) findViewById(R.id.edtSearch);
        btnClear = (Button) findViewById(R.id.btnClear);
        rvList = (RecyclerView) findViewById(R.id.rvList);

        edtSearch.setEnabled(false);
        edtSearch.setCursorVisible(false);
    }

    private void populateList(List<StationModel> stations) {

        adapter = new StationListAdapter(MainActivity.this, this, stations);

        rvList.setHasFixedSize(true);
        rvList.setAdapter(adapter);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        rvList.setItemAnimator(new DefaultItemAnimator());

        setUpSearch();
    }

    private void setUpSearch() {
        edtSearch.setEnabled(true);
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s != null && s.length() > 0)
                    btnClear.setVisibility(View.VISIBLE);
                else
                    btnClear.setVisibility(View.INVISIBLE);

                adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch();
                    return true;
                }

                return false;
            }
        });

        edtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtSearch.setCursorVisible(true);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnClear.setVisibility(View.INVISIBLE);
                edtSearch.setText("");
            }
        });
    }

    private void performSearch() {
        edtSearch.clearFocus();
        edtSearch.setCursorVisible(false);
        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(edtSearch.getWindowToken(), 0);
    }

    @Override
    public void onPopulateFinished(boolean status, List<StationModel> stations) {
        if (status) {
            populateList(stations);
        } else {
            Snackbar.with(MainActivity.this, null)
                    .type(Type.ERROR)
                    .message("Something went wrong...")
                    .duration(Duration.LONG)
                    .show();
        }
    }

    @Override
    public void onStationFilter(boolean isHavingResults) {
        System.out.println(isHavingResults);
    }
}
