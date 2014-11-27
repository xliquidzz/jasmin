package ch.fihlon.jasmin.dao;

import ch.fihlon.jasmin.dao.mappers.ItemMapper;
import ch.fihlon.jasmin.representations.Item;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface ItemDAO {

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO item (id, title, team_id) VALUES (NULL, :title, :teamId)")
    long createItem(@Bind("title") final String title, @Bind("teamId") final long teamId);

    @Mapper(ItemMapper.class)
    @SqlQuery("SELECT * FROM item WHERE id = :id")
    Item readItemById(@Bind("id") final long id);

    @SqlUpdate("UPDATE item SET title=:title, team_id=:teamId WHERE id=:id")
    void updateItem(@Bind("id") final long id, @Bind("title") final String title, @Bind("teamId") final long teamId);

    @SqlUpdate("DELETE FROM item WHERE id = :id")
    void deleteItem(@Bind("id") final long id);
}
