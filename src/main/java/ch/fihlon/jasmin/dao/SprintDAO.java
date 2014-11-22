package ch.fihlon.jasmin.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.util.Date;

public interface SprintDAO {

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO sprint (id, title, start, end) VALUES (NULL, :title, :start, :end)")
    long createSprint(
            @Bind("title") final String title,
            @Bind("start") final Date start,
            @Bind("end") final Date end);
}
