package ch.fihlon.jasmin.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface UserDAO {

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO user (id, firstname, lastname, email) VALUES (NULL, :firstname, :lastname, :email)")
    @Nullable long createUser(@Bind("firstname") @Nonnull final String firstname,
                              @Bind("lastname") @Nonnull final String lastname,
                              @Bind("email") @Nonnull final String email);
}
