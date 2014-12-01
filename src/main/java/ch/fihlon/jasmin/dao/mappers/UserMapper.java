package ch.fihlon.jasmin.dao.mappers;

import ch.fihlon.jasmin.representations.User;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import javax.annotation.Nonnull;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements ResultSetMapper<User> {

    @Override
    public @Nonnull User map(@Nonnull final int index, @Nonnull final ResultSet r, @Nonnull final StatementContext ctx)
            throws SQLException {
        return new User(
                r.getLong("id"),
                r.getString("firstname"),
                r.getString("lastname"),
                r.getString("email")
        );
    }
}
