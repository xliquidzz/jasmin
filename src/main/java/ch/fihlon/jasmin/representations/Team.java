package ch.fihlon.jasmin.representations;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class Team {

    private final long id;

    @NotBlank
    @Length(min=1, max=100)
    private final String name;

    public Team() {
        this(0, null);
    }

    public Team(@Nonnull final long id, @Nonnull final String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public @Nullable long getId() {
        return id;
    }

    public @Nullable String getName() {
        return name;
    }
}
