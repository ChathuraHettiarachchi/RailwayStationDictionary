package com.chootdev.railwaydic.models;

import com.google.gson.annotations.SerializedName;

public class StationSingle {

    @SerializedName("station_name")
    private String stationName;

    @SerializedName("distence_miles")
    private String distenceMiles;

    @SerializedName("height_feet")
    private String heightFeet;

    @SerializedName("height_meters")
    private String heightMeters;

    @SerializedName("distence_km")
    private String distenceKm;

    @SerializedName("station_code")
    private String stationCode;

    @SerializedName("telephone")
    private String telephone;

    @SerializedName("type")
    private String type;

    @SerializedName("station_code_no")
    private String stationCodeNo;

    public StationSingle() {
    }

    public StationSingle(String stationName, String distenceMiles, String heightFeet, String heightMeters, String distenceKm, String stationCode, String telephone, String type, String stationCodeNo) {
        this.stationName = stationName;
        this.distenceMiles = distenceMiles;
        this.heightFeet = heightFeet;
        this.heightMeters = heightMeters;
        this.distenceKm = distenceKm;
        this.stationCode = stationCode;
        this.telephone = telephone;
        this.type = type;
        this.stationCodeNo = stationCodeNo;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationName() {
        return stationName;
    }

    public void setDistenceMiles(String distenceMiles) {
        this.distenceMiles = distenceMiles;
    }

    public String getDistenceMiles() {
        return distenceMiles;
    }

    public void setHeightFeet(String heightFeet) {
        this.heightFeet = heightFeet;
    }

    public String getHeightFeet() {
        return heightFeet;
    }

    public void setHeightMeters(String heightMeters) {
        this.heightMeters = heightMeters;
    }

    public String getHeightMeters() {
        return heightMeters;
    }

    public void setDistenceKm(String distenceKm) {
        this.distenceKm = distenceKm;
    }

    public String getDistenceKm() {
        return distenceKm;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setStationCodeNo(String stationCodeNo) {
        this.stationCodeNo = stationCodeNo;
    }

    public String getStationCodeNo() {
        return stationCodeNo;
    }

    @Override
    public String toString() {
        return
                "StationSingle{" +
                        "station_name = '" + stationName + '\'' +
                        ",distence_miles = '" + distenceMiles + '\'' +
                        ",height_feet = '" + heightFeet + '\'' +
                        ",height_meters = '" + heightMeters + '\'' +
                        ",distence_km = '" + distenceKm + '\'' +
                        ",station_code = '" + stationCode + '\'' +
                        ",telephone = '" + telephone + '\'' +
                        ",type = '" + type + '\'' +
                        ",station_code_no = '" + stationCodeNo + '\'' +
                        "}";
    }
}