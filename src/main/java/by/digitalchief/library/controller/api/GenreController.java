package by.digitalchief.library.controller.api;

import by.digitalchief.library.utils.PageableUtils;
import by.digitalchief.library.dto.GenreDto;
import by.digitalchief.library.dto.PageRequestDto;
import by.digitalchief.library.service.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/genres")
@Tag(name = "Genres Controller")
public class GenreController implements BaseCrudController<GenreDto, GenreDto> {

    private final GenreService genreService;

    @Override
    @Operation(
            summary = "Get genres by pageable",
            description = "Get all genres by page number, page size, sort direction & field to sort"
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GenreDto> getAllByPageable(@ParameterObject @Valid PageRequestDto pageRequest) {
        return genreService.findAllByPageable(PageableUtils.validatePageable(pageRequest));
    }

    @Override
    @Operation(
            summary = "Get genre by id"
    )
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GenreDto getById(@PathVariable Long id) {
        return genreService.findById(id);
    }

    @Override
    @Operation(
            summary = "Create genre by dto"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GenreDto create(@Valid @RequestBody GenreDto genreDto) {
        return genreService.save(genreDto);
    }

    @Override
    @Operation(
            summary = "Update genre by dto"
    )
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GenreDto update(@Valid @RequestBody GenreDto genreDto, @PathVariable Long id) {
        return genreService.update(genreDto, id);
    }

    @Override
    @Operation(
            summary = "Delete genre by id"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        genreService.delete(id);
    }
}
