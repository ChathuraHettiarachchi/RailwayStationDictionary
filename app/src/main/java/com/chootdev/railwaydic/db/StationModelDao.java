package com.chootdev.railwaydic.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "STATION_MODEL".
*/
public class StationModelDao extends AbstractDao<StationModel, Long> {

    public static final String TABLENAME = "STATION_MODEL";

    /**
     * Properties of entity StationModel.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Station_code = new Property(1, String.class, "station_code", false, "STATION_CODE");
        public final static Property Name = new Property(2, String.class, "name", false, "NAME");
        public final static Property Telephone = new Property(3, String.class, "telephone", false, "TELEPHONE");
        public final static Property Distence_miles = new Property(4, String.class, "distence_miles", false, "DISTENCE_MILES");
        public final static Property Distence_km = new Property(5, String.class, "distence_km", false, "DISTENCE_KM");
        public final static Property Height_feet = new Property(6, String.class, "height_feet", false, "HEIGHT_FEET");
        public final static Property Height_meters = new Property(7, String.class, "height_meters", false, "HEIGHT_METERS");
        public final static Property Station_code_no = new Property(8, String.class, "station_code_no", false, "STATION_CODE_NO");
    }


    public StationModelDao(DaoConfig config) {
        super(config);
    }
    
    public StationModelDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"STATION_MODEL\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"STATION_CODE\" TEXT NOT NULL ," + // 1: station_code
                "\"NAME\" TEXT," + // 2: name
                "\"TELEPHONE\" TEXT," + // 3: telephone
                "\"DISTENCE_MILES\" TEXT," + // 4: distence_miles
                "\"DISTENCE_KM\" TEXT," + // 5: distence_km
                "\"HEIGHT_FEET\" TEXT," + // 6: height_feet
                "\"HEIGHT_METERS\" TEXT," + // 7: height_meters
                "\"STATION_CODE_NO\" TEXT);"); // 8: station_code_no
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"STATION_MODEL\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, StationModel entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getStation_code());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String telephone = entity.getTelephone();
        if (telephone != null) {
            stmt.bindString(4, telephone);
        }
 
        String distence_miles = entity.getDistence_miles();
        if (distence_miles != null) {
            stmt.bindString(5, distence_miles);
        }
 
        String distence_km = entity.getDistence_km();
        if (distence_km != null) {
            stmt.bindString(6, distence_km);
        }
 
        String height_feet = entity.getHeight_feet();
        if (height_feet != null) {
            stmt.bindString(7, height_feet);
        }
 
        String height_meters = entity.getHeight_meters();
        if (height_meters != null) {
            stmt.bindString(8, height_meters);
        }
 
        String station_code_no = entity.getStation_code_no();
        if (station_code_no != null) {
            stmt.bindString(9, station_code_no);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, StationModel entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getStation_code());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(3, name);
        }
 
        String telephone = entity.getTelephone();
        if (telephone != null) {
            stmt.bindString(4, telephone);
        }
 
        String distence_miles = entity.getDistence_miles();
        if (distence_miles != null) {
            stmt.bindString(5, distence_miles);
        }
 
        String distence_km = entity.getDistence_km();
        if (distence_km != null) {
            stmt.bindString(6, distence_km);
        }
 
        String height_feet = entity.getHeight_feet();
        if (height_feet != null) {
            stmt.bindString(7, height_feet);
        }
 
        String height_meters = entity.getHeight_meters();
        if (height_meters != null) {
            stmt.bindString(8, height_meters);
        }
 
        String station_code_no = entity.getStation_code_no();
        if (station_code_no != null) {
            stmt.bindString(9, station_code_no);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public StationModel readEntity(Cursor cursor, int offset) {
        StationModel entity = new StationModel( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // station_code
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // name
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // telephone
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // distence_miles
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // distence_km
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // height_feet
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // height_meters
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8) // station_code_no
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, StationModel entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setStation_code(cursor.getString(offset + 1));
        entity.setName(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTelephone(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDistence_miles(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setDistence_km(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setHeight_feet(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setHeight_meters(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setStation_code_no(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(StationModel entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(StationModel entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(StationModel entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}