package com.example.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class UserEntityTableDef extends TableDef {

    public static final UserEntityTableDef USER_ENTITY = new UserEntityTableDef();

    public final QueryColumn ID = new QueryColumn(this, "id");

    public final QueryColumn PASSWORD = new QueryColumn(this, "password");

    public final QueryColumn USERNAME = new QueryColumn(this, "username");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PASSWORD, USERNAME};

    public UserEntityTableDef() {
        super("", "user");
    }

}
