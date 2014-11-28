package ch.fihlon.jasmin.resources;

import ch.fihlon.jasmin.dao.SprintDAO;
import ch.fihlon.jasmin.representations.Sprint;
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
import java.sql.Date;

@Path("/sprint")
@Produces(MediaType.APPLICATION_JSON)
public class SprintResource {

    private final SprintDAO sprintDAO;

    public SprintResource(@Nonnull final DBI dbi) {
        sprintDAO = dbi.onDemand(SprintDAO.class);
    }

    @POST
    public @Nonnull Response createSprint(@Valid @Nonnull final Sprint sprint) throws URISyntaxException {
        final long newSprintId = sprintDAO.createSprint(
                sprint.getTitle(), Date.valueOf(sprint.getStart()), Date.valueOf(sprint.getEnd()));
        return Response.created(new URI(String.valueOf(newSprintId))).build();
    }

    @GET
    @Path("/{id}")
    public @Nonnull Response readSprint(@PathParam("id") @Nonnull final long id) {
        final Sprint sprint = sprintDAO.readSprintById(id);
        if (sprint == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(sprint).build();
    }

    @PUT
    @Path("/{id}")
    public @Nonnull Response updateSprint(@PathParam("id") @Nonnull final long id, @Valid @Nonnull final Sprint sprint)
            throws URISyntaxException {
        if (sprintDAO.readSprintById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        sprintDAO.updateSprint(id, sprint.getTitle(), Date.valueOf(sprint.getStart()), Date.valueOf(sprint.getEnd()));
        return Response.ok(new Sprint(id, sprint.getTitle(), sprint.getStart(), sprint.getEnd())).build();
    }

    @DELETE
    @Path("/{id}")
    public @Nonnull Response deleteSprint(@PathParam("id") @Nonnull final long id) {
        if (sprintDAO.readSprintById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        sprintDAO.deleteSprint(id);
        return Response.noContent().build();
    }
}
