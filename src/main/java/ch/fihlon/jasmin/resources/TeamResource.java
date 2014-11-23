package ch.fihlon.jasmin.resources;

import ch.fihlon.jasmin.dao.TeamDAO;
import ch.fihlon.jasmin.representations.Team;
import org.skife.jdbi.v2.DBI;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;

@Path("/team")
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {

    private final TeamDAO teamDAO;

    public TeamResource(@Nonnull final DBI dbi) {
        teamDAO = dbi.onDemand(TeamDAO.class);
    }

    @POST
    public Response createTeam(@Valid final Team team) throws URISyntaxException {
        final long newTeamId = teamDAO.createTeam(team.getName());
        return Response.created(new URI(String.valueOf(newTeamId))).build();
    }
}
