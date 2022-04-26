package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.jooq.EnumType;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

import java.sql.Connection;
import java.sql.SQLException;

import static org.jooq.impl.SQLDataType.*;

public class V3__CreateProjectApplies extends BaseJavaMigration {
    private void execute(Connection conn, String sql) throws SQLException {
        conn.createStatement().execute(sql);
    }

    @Override
    public void migrate(Context context) throws Exception {
        Connection conn = context.getConnection();
        execute(conn, DSL.createTable("project_apply")
                .column("job_offer_id", VARCHAR.length(21).nullable(false))
                .column("apply_id", VARCHAR.length(21).nullable(false))
                .column("message", VARCHAR.length(2000).nullable(true))
                .column("quotation_amount", DECIMAL(10,2).nullable(false))
                .column("scheduled_completion_date", DATE.nullable(false))
                .getSQL());
    }
}
