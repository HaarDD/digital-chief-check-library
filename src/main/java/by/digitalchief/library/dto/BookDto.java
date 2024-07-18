package by.digitalchief.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

@Value
public class BookDto implements Serializable {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;

    @NotNull
    @Size(max = 100)
    String title;

    @Size(max = 5000)
    String description;

    @Size(min = 1, max = 30000)
    Long pagesCount;

    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate publishDate;


    AuthorDto author;

    GenreDto genre;

}