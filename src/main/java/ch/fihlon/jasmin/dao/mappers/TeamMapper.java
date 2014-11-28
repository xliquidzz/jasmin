package ch.fihlon.jasmin.dao.mappers;

import ch.fihlon.jasmin.representations.Team;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamMapper implements ResultSetMapper<Team> {

    @Override
    public @Nonnull Team map(@Nonnull final int index, @Nonnull final ResultSet r, @Nonnull final StatementContext ctx)
            throws SQLException {
        return new Team(
                r.getLong("id"),
                r.getString("name")
        );
    }
}
