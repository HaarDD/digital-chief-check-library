package by.digitalchief.library.controller.api;

import by.digitalchief.library.utils.PageableUtils;
import by.digitalchief.library.dto.AuthorDto;
import by.digitalchief.library.dto.PageRequestDto;
import by.digitalchief.library.service.AuthorService;
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
@RequestMapping("/api/authors")
@Tag(name = "Authors Controller")
public class AuthorController implements BaseCrudController<AuthorDto, AuthorDto> {

    private final AuthorService authorService;

    @Override
    @Operation(
            summary = "Get authors by pageable",
            description = "Get all authors by page number, page size, sort direction & field to sort"
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDto> getAllByPageable(@ParameterObject @Valid PageRequestDto pageRequest) {
        return authorService.findAllByPageable(PageableUtils.validatePageable(pageRequest));
    }

    @Override
    @Operation(
            summary = "Get author by id"
    )
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDto getById(@PathVariable Long id) {
        return authorService.findById(id);
    }

    @Override
    @Operation(
            summary = "Create author by dto"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDto create(@Valid @RequestBody AuthorDto authorDto) {
        return authorService.save(authorDto);
    }

    @Override
    @Operation(
            summary = "Update author by dto"
    )
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDto update(@Valid @RequestBody AuthorDto authorDto, @PathVariable Long id) {
        return authorService.update(authorDto, id);
    }

    @Override
    @Operation(
            summary = "Delete author by id"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        authorService.delete(id);
    }
}
