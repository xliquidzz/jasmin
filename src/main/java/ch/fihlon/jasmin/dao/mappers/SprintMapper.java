package ch.fihlon.jasmin.dao.mappers;

import ch.fihlon.jasmin.representations.Sprint;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SprintMapper implements ResultSetMapper<Sprint> {

    @Override
    public Sprint map(final int index, final ResultSet r, final StatementContext ctx) throws SQLException {
        return new Sprint(
                r.getLong("id"),
                r.getString("title"),
                r.getDate("start").toLocalDate(),
                r.getDate("end").toLocalDate()
        );
    }
}
