package ch.fihlon.jasmin.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface TeamDAO {

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO team (id, name) VALUES (NULL, :name)")
    long createTeam(@Bind("name") final String name);
}
