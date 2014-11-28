package ch.fihlon.jasmin.dao.mappers;

import ch.fihlon.jasmin.representations.Item;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements ResultSetMapper<Item> {

    @Override
    public @Nonnull Item map(@Nonnull final int index, @Nonnull final ResultSet r, @Nonnull final StatementContext ctx)
            throws SQLException {
        return new Item(
                r.getLong("id"),
                r.getString("title"),
                r.getLong("team_id")
        );
    }
}
