package com.greendao;

import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class MyGenerator {
    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.chootdev.railwaydic.db");
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema,"./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        addStationEntities(schema);
        addRecentEntities(schema);
    }

    private static Entity addStationEntities(final Schema schema) {
        Entity station = schema.addEntity("StationModel");
        station.addIdProperty().primaryKey().autoincrement();
        station.addStringProperty("station_code").notNull();
        station.addStringProperty("name");
        station.addStringProperty("telephone");
        station.addStringProperty("distence_miles");
        station.addStringProperty("distence_km");
        station.addStringProperty("height_feet");
        station.addStringProperty("height_meters");
        station.addStringProperty("station_code_no");
        return station;
    }

    private static Entity addRecentEntities(final Schema schema) {
        Entity station = schema.addEntity("RecentModel");
        station.addIdProperty().primaryKey().autoincrement();
        station.addStringProperty("station_code").notNull();
        return station;
    }
}
