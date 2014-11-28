package ch.fihlon.jasmin.dao;

import ch.fihlon.jasmin.dao.mappers.SprintMapper;
import ch.fihlon.jasmin.representations.Sprint;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Date;

public interface SprintDAO {

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO sprint (id, title, start, end) VALUES (NULL, :title, :start, :end)")
    @Nullable long createSprint(
            @Bind("title") @Nonnull final String title,
            @Bind("start") @Nonnull final Date start,
            @Bind("end") @Nonnull final Date end);

    @Mapper(SprintMapper.class)
    @SqlQuery("SELECT * FROM sprint WHERE id = :id")
    @Nullable Sprint readSprintById(@Bind("id") @Nonnull final long id);

    @SqlUpdate("UPDATE sprint SET title=:title, start=:start, end=:end WHERE id=:id")
    void updateSprint(
            @Bind("id") @Nonnull final long id,
            @Bind("title") @Nonnull final String title,
            @Bind("start") @Nonnull final Date start,
            @Bind("end") @Nonnull final Date end);

    @SqlUpdate("DELETE FROM sprint WHERE id = :id")
    void deleteSprint(@Bind("id") @Nonnull final long id);
}
