package ch.fihlon.jasmin.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface ItemDAO {

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO item (id, title, team_id) VALUES (NULL, :title, :teamId)")
    long createItem(@Bind("title") final String title, @Bind("teamId") final long teamId);
}
