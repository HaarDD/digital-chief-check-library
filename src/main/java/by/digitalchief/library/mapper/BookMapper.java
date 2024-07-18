package by.digitalchief.library.mapper;

import by.digitalchief.library.dto.BookCreateDto;
import by.digitalchief.library.dto.BookDto;
import by.digitalchief.library.entity.Author;
import by.digitalchief.library.entity.Book;
import by.digitalchief.library.entity.Genre;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BookMapper {

    @Mapping(target = "author", source = "authorId", qualifiedByName = "mapAuthor")
    @Mapping(target = "genre", source = "genreId", qualifiedByName = "mapGenre")
    Book toEntity(BookCreateDto bookCreateDto);

    BookDto toDto(Book book);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "author", source = "authorId", qualifiedByName = "mapAuthor")
    @Mapping(target = "genre", source = "genreId", qualifiedByName = "mapGenre")
    Book partialUpdate(BookCreateDto bookCreateDto, @MappingTarget Book book);

    List<BookDto> toDtoList(List<Book> bookList);

    List<Book> toEntityList(List<BookCreateDto> bookCreateDtoList);

    @Named("mapAuthor")
    default Author mapAuthor(Long authorId) {
        if (authorId == null) {
            return null;
        }
        Author author = new Author();
        author.setId(authorId);
        return author;
    }

    @Named("mapGenre")
    default Genre mapGenre(Long genreId) {
        if (genreId == null) {
            return null;
        }
        Genre genre = new Genre();
        genre.setId(genreId);
        return genre;
    }
}