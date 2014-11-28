package ch.fihlon.jasmin.resources;

import ch.fihlon.jasmin.dao.ItemDAO;
import ch.fihlon.jasmin.representations.Item;
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

@Path("/item")
@Produces(MediaType.APPLICATION_JSON)
public class ItemResource {

    private final ItemDAO itemDAO;

    public ItemResource(@Nonnull final DBI dbi) {
        itemDAO = dbi.onDemand(ItemDAO.class);
    }

    @POST
    public @Nonnull Response createItem(@Valid @Nonnull final Item item) throws URISyntaxException {
        final long newItemId = itemDAO.createItem(item.getTitle(), item.getTeamId());
        return Response.created(new URI(String.valueOf(newItemId))).build();
    }

    @GET
    @Path("/{id}")
    public @Nonnull Response readItem(@PathParam("id") @Nonnull final long id) {
        final Item item = itemDAO.readItemById(id);
        if (item == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(item).build();
    }
    @PUT
    @Path("/{id}")
    public @Nonnull Response updateItem(@PathParam("id") @Nonnull final long id, @Valid @Nonnull Item item) {
        if (itemDAO.readItemById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        itemDAO.updateItem(id, item.getTitle(), item.getTeamId());
        return Response.ok(new Item(id, item.getTitle(), item.getTeamId())).build();
    }

    @DELETE
    @Path("/{id}")
    public @Nonnull Response deleteItem(@PathParam("id") @Nonnull final long id) {
        if (itemDAO.readItemById(id) == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        itemDAO.deleteItem(id);
        return Response.noContent().build();
    }
}
