package ch.fihlon.jasmin.resources;

import ch.fihlon.jasmin.dao.SprintDAO;
import ch.fihlon.jasmin.representations.Sprint;
import org.skife.jdbi.v2.DBI;

import javax.annotation.Nonnull;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
    public Response createSprint(@Valid final Sprint sprint) throws URISyntaxException {
        final long newSprintId = sprintDAO.createSprint(sprint.getTitle(), Date.valueOf(sprint.getStart()), Date.valueOf(sprint.getEnd()));
        return Response.created(new URI(String.valueOf(newSprintId))).build();
    }

    @GET
    @Path("/{id}")
    public Response readSprint(@PathParam("id") final long id) {
        return Response.ok(sprintDAO.readSprintById(id)).build();
    }
}
