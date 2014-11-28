package ch.fihlon.jasmin.resources;

import ch.fihlon.jasmin.dao.BacklogItemDAO;
import ch.fihlon.jasmin.representations.BacklogItem;
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

@Path("/backlogItem")
@Produces(MediaType.APPLICATION_JSON)
public class BacklogItemResource {

    private final BacklogItemDAO backlogItemDAO;

    public BacklogItemResource(@Nonnull final DBI dbi) {
        backlogItemDAO = dbi.onDemand(BacklogItemDAO.class);
    }

    @POST
    public @Nonnull Response createItem(@Valid @Nonnull final BacklogItem backlogItem) throws URISyntaxException {
        final long newItemId = backlogItemDAO.createItem(backlogItem.getTitle(), backlogItem.getTeamId());
        return Response.created(new URI(String.valueOf(newItemId))).build();
    }

    @GET
    @Path("/{id}")
    public @Nonnull Response readItem(@PathParam("id") @Nonnull final long id) {
        final BacklogItem backlogItem = backlogItemDAO.readItemById(id);
        if (backlogItem == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(backlogItem).build();
    }

    @PUT
    @Path("/{id}")
    public @Nonnull Response updateItem(@PathParam("id") @Nonnull final long id, @Valid @Nonnull BacklogItem backlogItem) {
        if (backlogItemDAO.readItemById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        backlogItemDAO.updateItem(id, backlogItem.getTitle(), backlogItem.getTeamId());
        return Response.ok(new BacklogItem(id, backlogItem.getTitle(), backlogItem.getTeamId())).build();
    }

    @DELETE
    @Path("/{id}")
    public @Nonnull Response deleteItem(@PathParam("id") @Nonnull final long id) {
        if (backlogItemDAO.readItemById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        backlogItemDAO.deleteItem(id);
        return Response.noContent().build();
    }
}
