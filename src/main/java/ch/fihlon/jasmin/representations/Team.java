package ch.fihlon.jasmin.representations;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

public class Team {

    private final long id;

    @NotBlank
    @Length(min=1, max=100)
    private final String name;

    public Team() {
        this(0, null);
    }

    public Team(final long id, final String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
