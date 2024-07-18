package by.digitalchief.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

@Value
public class AuthorDto implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;

    @NotNull
    @Size(min = 5, max = 100)
    String name;

    @Past
    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate birthDate;

    @Size(max = 5000)
    String biography;
}
