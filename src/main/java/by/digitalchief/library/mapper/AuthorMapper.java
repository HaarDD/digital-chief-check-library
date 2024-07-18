package by.digitalchief.library.mapper;

import by.digitalchief.library.dto.AuthorDto;
import by.digitalchief.library.entity.Author;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorMapper {

    Author toEntity(AuthorDto authorDto);

    AuthorDto toDto(Author author);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Author partialUpdate(AuthorDto authorDto, @MappingTarget Author author);

    List<AuthorDto> toDtoList(List<Author> authorList);

    List<Author> toEntityList(List<AuthorDto> authorDtoList);
}