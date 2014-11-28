package ch.fihlon.jasmin.dao.mappers;

import ch.fihlon.jasmin.representations.Sprint;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SprintMapper implements ResultSetMapper<Sprint> {

    @Override
    public @Nonnull Sprint map(@Nonnull final int index, @Nonnull final ResultSet r, @Nonnull final StatementContext ctx)
            throws SQLException {
        return new Sprint(
                r.getLong("id"),
                r.getString("title"),
                r.getDate("start").toLocalDate(),
                r.getDate("end").toLocalDate()
        );
    }
}
