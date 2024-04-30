package com.example.system.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class WarehouseEntityTableDef extends TableDef {

    public static final WarehouseEntityTableDef WAREHOUSE_ENTITY = new WarehouseEntityTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn LATITUDE = new QueryColumn(this, "latitude");

    public final QueryColumn LONGITUDE = new QueryColumn(this, "longitude");

    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    public final QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");

    public final QueryColumn COMPANY_NUMBER = new QueryColumn(this, "company_number");

    public final QueryColumn WAREHOUSE_NAME = new QueryColumn(this, "warehouse_name");

    public final QueryColumn WAREHOUSE_SIZE = new QueryColumn(this, "warehouse_size");

    public final QueryColumn WAREHOUSE_TYPE = new QueryColumn(this, "warehouse_type");

    public final QueryColumn WAREHOUSE_NUMBER = new QueryColumn(this, "warehouse_number");

    public final QueryColumn WAREHOUSE_STATUS = new QueryColumn(this, "warehouse_status");

    public final QueryColumn WAREHOUSE_ADDRESS = new QueryColumn(this, "warehouse_address");

    public final QueryColumn WAREHOUSE_MANAGER_NAME = new QueryColumn(this, "warehouse_manager_name");

    public final QueryColumn WAREHOUSE_MANAGER_PHONE = new QueryColumn(this, "warehouse_manager_phone");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, LATITUDE, LONGITUDE, CREATE_TIME, UPDATE_TIME, COMPANY_NUMBER, WAREHOUSE_NAME, WAREHOUSE_SIZE, WAREHOUSE_TYPE, WAREHOUSE_NUMBER, WAREHOUSE_STATUS, WAREHOUSE_ADDRESS, WAREHOUSE_MANAGER_NAME, WAREHOUSE_MANAGER_PHONE};

    public WarehouseEntityTableDef() {
        super("", "warehouse");
    }

}
