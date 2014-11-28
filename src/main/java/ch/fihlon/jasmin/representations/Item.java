package ch.fihlon.jasmin.representations;

import ch.fihlon.jasmin.App;
import ch.fihlon.jasmin.dao.TeamDAO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.dropwizard.validation.ValidationMethod;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Item {

    private final long id;

    @NotBlank
    @Length(min=1, max=100)
    private final String title;

    private final long teamId;

    public Item() {
        this(0, null, 0);
    }

    public Item(@Nonnull final long id, @Nonnull final String title, @Nonnull final long teamId) {
        super();
        this.id = id;
        this.title = title;
        this.teamId = teamId;
    }

    public @Nullable long getId() {
        return id;
    }

    public @Nullable String getTitle() {
        return title;
    }

    public @Nullable long getTeamId() {
        return teamId;
    }

    @JsonIgnore
    @ValidationMethod(message = "team id is not valid")
    public @Nonnull boolean isValidTeamId() {
        // TODO #27 Architecture: Don't use DBI in representation classes
        return App.getDBI().onDemand(TeamDAO.class).readTeamById(teamId) != null;
    }
}
