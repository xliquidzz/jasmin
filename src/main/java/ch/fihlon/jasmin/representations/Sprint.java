package ch.fihlon.jasmin.representations;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

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

    public Sprint(final long id, final String title, final LocalDate start, final LocalDate end) {
        super();
        this.id = id;
        this.title = title;
        this.start = start;
        this.end = end;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate getStart() {
        return start;
    }

    @JsonDeserialize(using = LocalDateDeserializer.class)
    public LocalDate getEnd() {
        return end;
    }
}
