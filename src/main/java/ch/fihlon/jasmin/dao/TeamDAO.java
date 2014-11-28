package ch.fihlon.jasmin.dao;

import ch.fihlon.jasmin.dao.mappers.TeamMapper;
import ch.fihlon.jasmin.representations.Team;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface TeamDAO {

    @GetGeneratedKeys
    @SqlUpdate("INSERT INTO team (id, name) VALUES (NULL, :name)")
    @Nullable long createTeam(@Bind("name") @Nonnull final String name);

    @Mapper(TeamMapper.class)
    @SqlQuery("SELECT * FROM team WHERE id = :id")
    @Nullable Team readTeamById(@Bind("id") @Nonnull final long id);

    @SqlUpdate("UPDATE team SET name=:name WHERE id=:id")
    void updateTeam(@Bind("id") @Nonnull final long id, @Bind("name") @Nonnull final String name);
    
    @SqlUpdate("DELETE FROM team WHERE id = :id")
    void deleteTeam(@Bind("id") @Nonnull final long id);
}
