package by.digitalchief.library.mapper;

import by.digitalchief.library.dto.GenreDto;
import by.digitalchief.library.entity.Genre;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface GenreMapper {
    Genre toEntity(GenreDto genreDto);

    GenreDto toDto(Genre genre);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Genre partialUpdate(GenreDto genreDto, @MappingTarget Genre genre);

    List<GenreDto> toDtoList(List<Genre> genreList);

    List<Genre> toEntityList(List<GenreDto> genreDtoList);
}