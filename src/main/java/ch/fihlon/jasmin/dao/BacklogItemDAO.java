package ch.fihlon.jasmin.dao;

import ch.fihlon.jasmin.dao.mappers.BacklogItemMapper;
import ch.fihlon.jasmin.representations.BacklogItem;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public interface BacklogItemDAO {

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO backlog_item (id, title, team_id) VALUES (NULL, :title, :teamId)")
    @Nullable long createItem(
            @Bind("title") @Nonnull final String title,
            @Bind("teamId") @Nonnull final long teamId);

    @Mapper(BacklogItemMapper.class)
    @SqlQuery("SELECT * FROM backlog_item WHERE id = :id")
    @Nullable BacklogItem readItemById(@Bind("id") @Nonnull final long id);

    @Mapper(BacklogItemMapper.class)
    @SqlQuery("SELECT * FROM backlog_item WHERE team_id = :teamId")
    @Nonnull List<BacklogItem> readBacklogItemsByTeamId(@Bind("teamId") @Nonnull final long teamId);

    @SqlUpdate("UPDATE backlog_item SET title=:title, team_id=:teamId WHERE id=:id")
    void updateItem(
            @Bind("id") @Nonnull final long id,
            @Bind("title") @Nonnull final String title,
            @Bind("teamId") @Nonnull final long teamId);

    @SqlUpdate("DELETE FROM backlog_item WHERE id = :id")
    void deleteItem(@Bind("id") @Nonnull final long id);

    @Mapper(BacklogItemMapper.class)
    @SqlQuery("SELECT * FROM backlog_item WHERE sprint_id = :sprintId")
    @Nonnull List<BacklogItem> readBacklogItemsBySprintId(@Bind("sprintId") @Nonnull final long id);
}
