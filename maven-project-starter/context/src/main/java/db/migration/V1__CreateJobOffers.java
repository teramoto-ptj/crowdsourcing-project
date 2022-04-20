package db.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.jooq.EnumType;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;

import java.sql.Connection;
import java.sql.SQLException;

import static org.jooq.impl.SQLDataType.*;

public class V1__CreateJobOffers extends BaseJavaMigration {
    private void execute(Connection conn, String sql) throws SQLException {
        conn.createStatement().execute(sql);
    }

    @Override
    public void migrate(Context context) throws Exception {
        Connection conn = context.getConnection();
        execute(conn, DSL.createTable("job_offers")
                .column("id", VARCHAR.length(21).nullable(false))
                .column("title", VARCHAR.length(200).nullable(false))
                .column("description", VARCHAR.length(2000).nullable(false))
                .column("required_skill", VARCHAR.length(2000).nullable(false))
                .column("budget_amount", DECIMAL(10,2).nullable(false))
                .column("budget_currency", VARCHAR.length(3).nullable(false))
                .column("contract_hope_number", INTEGER.nullable(false))
                .column("job_offer_type", VARCHAR.length(10).nullable(false))
                .column("due_date", DATE.nullable(false))
                .getSQL());
    }
}
