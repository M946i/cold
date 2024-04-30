package com.example.system.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class MeterEntityTableDef extends TableDef {

    public static final MeterEntityTableDef METER_ENTITY = new MeterEntityTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    public final QueryColumn HOST_NUMBER = new QueryColumn(this, "host_number");

    public final QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");

    public final QueryColumn MAX_HUMIDITY = new QueryColumn(this, "max_humidity");

    public final QueryColumn METER_NUMBER = new QueryColumn(this, "meter_number");

    public final QueryColumn METER_STATUS = new QueryColumn(this, "meter_status");

    public final QueryColumn MIN_HUMIDITY = new QueryColumn(this, "min_humidity");

    public final QueryColumn COMPANY_NUMBER = new QueryColumn(this, "company_number");

    public final QueryColumn MAX_TEMPERATURE = new QueryColumn(this, "max_temperature");

    public final QueryColumn MIN_TEMPERATURE = new QueryColumn(this, "min_temperature");

    public final QueryColumn WAREHOUSE_NUMBER = new QueryColumn(this, "warehouse_number");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, CREATE_TIME, HOST_NUMBER, UPDATE_TIME, MAX_HUMIDITY, METER_NUMBER, METER_STATUS, MIN_HUMIDITY, COMPANY_NUMBER, MAX_TEMPERATURE, MIN_TEMPERATURE, WAREHOUSE_NUMBER};

    public MeterEntityTableDef() {
        super("", "meter");
    }

}
