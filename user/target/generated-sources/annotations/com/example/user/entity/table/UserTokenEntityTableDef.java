package com.example.user.entity.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

// Auto generate by mybatis-flex, do not modify it.
public class UserTokenEntityTableDef extends TableDef {

    public static final UserTokenEntityTableDef USER_TOKEN_ENTITY = new UserTokenEntityTableDef();

    public final QueryColumn TOKEN = new QueryColumn(this, "token");

    public final QueryColumn USER_ID = new QueryColumn(this, "user_id");

    public final QueryColumn USERNAME = new QueryColumn(this, "username");

    public final QueryColumn EXPIRE_TIME = new QueryColumn(this, "expire_time");

    public final QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{TOKEN, USER_ID, USERNAME, EXPIRE_TIME, UPDATE_TIME};

    public UserTokenEntityTableDef() {
        super("", "user_token");
    }

}
