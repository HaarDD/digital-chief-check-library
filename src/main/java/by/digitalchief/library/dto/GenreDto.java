package by.digitalchief.library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

@Value
public class GenreDto implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;

    @NotNull
    @Size(min = 3, max = 50)
    String name;
}
