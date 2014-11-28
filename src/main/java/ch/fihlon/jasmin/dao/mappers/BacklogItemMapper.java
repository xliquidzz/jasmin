package ch.fihlon.jasmin.dao.mappers;

import ch.fihlon.jasmin.representations.BacklogItem;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BacklogItemMapper implements ResultSetMapper<BacklogItem> {

    @Override
    public @Nonnull BacklogItem map
            (@Nonnull final int index, @Nonnull final ResultSet r, @Nonnull final StatementContext ctx)
            throws SQLException {
        return new BacklogItem(
                r.getLong("id"),
                r.getString("title"),
                r.getLong("team_id")
        );
    }
}
