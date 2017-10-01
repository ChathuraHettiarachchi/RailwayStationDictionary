package com.chootdev.railwaydic.db;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "RECENT_MODEL".
 */
@Entity
public class RecentModel {

    @Id(autoincrement = true)
    private Long id;

    @NotNull
    private String station_code;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public RecentModel() {
    }

    public RecentModel(Long id) {
        this.id = id;
    }

    @Generated
    public RecentModel(Long id, String station_code) {
        this.id = id;
        this.station_code = station_code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    public String getStation_code() {
        return station_code;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setStation_code(@NotNull String station_code) {
        this.station_code = station_code;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}