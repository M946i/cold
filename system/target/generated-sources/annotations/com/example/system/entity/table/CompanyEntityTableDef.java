package com.example.system.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class CompanyEntityTableDef extends TableDef {

    public static final CompanyEntityTableDef COMPANY_ENTITY = new CompanyEntityTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    public final QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");

    public final QueryColumn COMPANY_NAME = new QueryColumn(this, "company_name");

    public final QueryColumn COMPANY_TYPE = new QueryColumn(this, "company_type");

    public final QueryColumn COMPANY_NUMBER = new QueryColumn(this, "company_number");

    public final QueryColumn COMPANY_ADDRESS = new QueryColumn(this, "company_address");

    public final QueryColumn COMPANY_MANAGER_NAME = new QueryColumn(this, "company_manager_name");

    public final QueryColumn COMPANY_MANAGER_PHONE = new QueryColumn(this, "company_manager_phone");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, CREATE_TIME, UPDATE_TIME, COMPANY_NAME, COMPANY_TYPE, COMPANY_NUMBER, COMPANY_ADDRESS, COMPANY_MANAGER_NAME, COMPANY_MANAGER_PHONE};

    public CompanyEntityTableDef() {
        super("", "company");
    }

}
