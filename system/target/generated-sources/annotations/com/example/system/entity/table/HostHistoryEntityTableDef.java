package com.example.system.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class HostHistoryEntityTableDef extends TableDef {

    public static final HostHistoryEntityTableDef HOST_HISTORY_ENTITY = new HostHistoryEntityTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn HOST_ID = new QueryColumn(this, "host_id");

    public final QueryColumn HOST_NAME = new QueryColumn(this, "host_name");

    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    public final QueryColumn HOST_NUMBER = new QueryColumn(this, "host_number");

    public final QueryColumn HOST_STATUS = new QueryColumn(this, "host_status");

    public final QueryColumn COMPANY_NUMBER = new QueryColumn(this, "company_number");

    public final QueryColumn WAREHOUSE_NUMBER = new QueryColumn(this, "warehouse_number");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, HOST_ID, HOST_NAME, CREATE_TIME, HOST_NUMBER, HOST_STATUS, COMPANY_NUMBER, WAREHOUSE_NUMBER};

    public HostHistoryEntityTableDef() {
        super("", "host_history");
    }

}
