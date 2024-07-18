package by.digitalchief.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

@Value
public class BookCreateDto implements Serializable {

    @NotNull
    @Size(max = 100)
    String title;

    @Size(max = 5000)
    String description;

    @Min(1)
    @Max(30000)
    Long pagesCount;

    @JsonFormat(pattern="yyyy-MM-dd")
    LocalDate publishDate;

    @Min(value = 1)
    Long authorId;

    @Min(value = 1)
    Long genreId;

}