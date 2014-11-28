package ch.fihlon.jasmin.representations;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class Sprint {

    private final long id;

    @NotBlank
    @Length(min=1, max=100)
    private final String title;

    @NotNull
    private final LocalDate start;

    @NotNull
    private final LocalDate end;

    public Sprint() {
        this(0, null, null, null);
    }

    public Sprint(@Nonnull final long id, @Nonnull final String title,
                  @Nonnull final LocalDate start, @Nonnull final LocalDate end) {
        super();
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
    }

    public @Nullable long getId() {
        return id;
    }

    public @Nullable String getTitle() {
        return title;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)
    public @Nullable LocalDate getStart() {
        return start;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)
    public @Nullable LocalDate getEnd() {
        return end;
    }
}
