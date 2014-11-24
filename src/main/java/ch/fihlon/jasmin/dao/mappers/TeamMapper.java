package ch.fihlon.jasmin.dao.mappers;

import ch.fihlon.jasmin.representations.Team;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamMapper implements ResultSetMapper<Team> {

    @Override
    public Team map(final int index, final ResultSet r, final StatementContext ctx) throws SQLException {
        return new Team(
                r.getLong("id"),
                r.getString("name")
        );
    }
}
