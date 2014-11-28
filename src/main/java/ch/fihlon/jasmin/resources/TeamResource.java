package ch.fihlon.jasmin.resources;

import ch.fihlon.jasmin.App;
import ch.fihlon.jasmin.dao.ItemDAO;
import ch.fihlon.jasmin.dao.TeamDAO;
import ch.fihlon.jasmin.representations.Team;
import io.dropwizard.jersey.errors.ErrorMessage;
import org.skife.jdbi.v2.DBI;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/team")
@Produces(MediaType.APPLICATION_JSON)
public class TeamResource {

    private final TeamDAO teamDAO;

    public TeamResource(@Nonnull final DBI dbi) {
        teamDAO = dbi.onDemand(TeamDAO.class);
    }

    @POST
    public @Nonnull Response createTeam(@Valid @Nonnull final Team team) throws URISyntaxException {
        final long newTeamId = teamDAO.createTeam(team.getName());
        return Response.created(new URI(String.valueOf(newTeamId))).build();
    }

    @GET
    @Path("/{id}")
    public @Nonnull Response readTeam(@PathParam("id") @Nonnull final long id) {
        final Team team = teamDAO.readTeamById(id);
        if (team == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(team).build();
    }

    @PUT
    @Path("/{id}")
    public @Nonnull Response updateTeam(@PathParam("id") @Nonnull final long id, @Valid @Nonnull final Team team) {
        if (teamDAO.readTeamById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        teamDAO.updateTeam(id, team.getName());
        return Response.ok(new Team(id, team.getName())).build();
    }

    @DELETE
    @Path("/{id}")
    public @Nonnull Response deleteTeam(@PathParam("id") @Nonnull final long id) {
        if (teamDAO.readTeamById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        // TODO #27 Architecture: Don't use DBI in resource classes
        if (!App.getDBI().onDemand(ItemDAO.class).readItemsByTeamId(id).isEmpty()) {
            return  Response.status(Response.Status.PRECONDITION_FAILED)
                    .entity(new ErrorMessage("Teams with assigned items can't be deleted!")).build();
        }

        teamDAO.deleteTeam(id);
        return Response.noContent().build();
    }
}
