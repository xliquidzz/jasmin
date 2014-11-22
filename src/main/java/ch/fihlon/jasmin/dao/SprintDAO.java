package ch.fihlon.jasmin.dao;

import ch.fihlon.jasmin.dao.mappers.SprintMapper;
import ch.fihlon.jasmin.representations.Sprint;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import java.util.Date;

public interface SprintDAO {

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO sprint (id, title, start, end) VALUES (NULL, :title, :start, :end)")
    long createSprint(
            @Bind("title") final String title,
            @Bind("start") final Date start,
            @Bind("end") final Date end);

    @Mapper(SprintMapper.class)
    @SqlQuery("SELECT * FROM sprint WHERE id = :id")
    Sprint readSprintById(@Bind("id") final long id);
}
