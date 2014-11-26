package ch.fihlon.jasmin.dao.mappers;

import ch.fihlon.jasmin.representations.Item;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemMapper implements ResultSetMapper<Item> {

    @Override
    public Item map(final int index, final ResultSet r, final StatementContext ctx) throws SQLException {
        return new Item(
                r.getLong("id"),
                r.getString("title"),
                r.getLong("team_id")
        );
    }
}
