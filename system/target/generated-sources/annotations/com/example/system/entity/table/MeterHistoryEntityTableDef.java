package com.example.system.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class MeterHistoryEntityTableDef extends TableDef {

    public static final MeterHistoryEntityTableDef METER_HISTORY_ENTITY = new MeterHistoryEntityTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn METER_ID = new QueryColumn(this, "meter_id");

    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    public final QueryColumn HOST_NUMBER = new QueryColumn(this, "host_number");

    public final QueryColumn MAX_HUMIDITY = new QueryColumn(this, "min_humidity");

    public final QueryColumn METER_STATUS = new QueryColumn(this, "meter_status");

    public final QueryColumn MIN_HUMIDITY = new QueryColumn(this, "min_humidity");

    public final QueryColumn COMPANY_NUMBER = new QueryColumn(this, "company_number");

    public final QueryColumn MAX_TEMPERATURE = new QueryColumn(this, "max_temperature");

    public final QueryColumn MIN_TEMPERATURE = new QueryColumn(this, "min_temperature");

    public final QueryColumn CURRENT_HUMIDITY = new QueryColumn(this, "current_humidity");

    public final QueryColumn WAREHOUSE_NUMBER = new QueryColumn(this, "warehouse_number");

    public final QueryColumn CURRENT_TEMPERATURE = new QueryColumn(this, "current_temperature");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, METER_ID, CREATE_TIME, HOST_NUMBER, MAX_HUMIDITY, METER_STATUS, MIN_HUMIDITY, COMPANY_NUMBER, MAX_TEMPERATURE, MIN_TEMPERATURE, CURRENT_HUMIDITY, WAREHOUSE_NUMBER, CURRENT_TEMPERATURE};

    public MeterHistoryEntityTableDef() {
        super("", "meter_history");
    }

}
