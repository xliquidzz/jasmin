package ch.fihlon.jasmin.dao;

import ch.fihlon.jasmin.dao.mappers.TeamMapper;
import ch.fihlon.jasmin.representations.Team;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface TeamDAO {

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO team (id, name) VALUES (NULL, :name)")
    long createTeam(@Bind("name") final String name);

    @Mapper(TeamMapper.class)
    @SqlQuery("SELECT * FROM team WHERE id = :id")
    Team readTeamById(@Bind("id") final long id);
    
    @SqlUpdate("DELETE FROM team WHERE id = :id")
    void deleteTeamById(@Bind("id") final long id);
}
