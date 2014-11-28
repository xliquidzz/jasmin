package ch.fihlon.jasmin.dao;

import ch.fihlon.jasmin.dao.mappers.ItemMapper;
import ch.fihlon.jasmin.representations.Item;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface ItemDAO {

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO item (id, title, team_id) VALUES (NULL, :title, :teamId)")
    @Nullable long createItem(
            @Bind("title") @Nonnull final String title,
            @Bind("teamId") @Nonnull final long teamId);

    @Mapper(ItemMapper.class)
    @SqlQuery("SELECT * FROM item WHERE id = :id")
    @Nullable Item readItemById(@Bind("id") @Nonnull final long id);

    @SqlUpdate("UPDATE item SET title=:title, team_id=:teamId WHERE id=:id")
    void updateItem(
            @Bind("id") @Nonnull final long id,
            @Bind("title") @Nonnull final String title,
            @Bind("teamId") @Nonnull final long teamId);

    @SqlUpdate("DELETE FROM item WHERE id = :id")
    void deleteItem(@Bind("id") @Nonnull final long id);
}
