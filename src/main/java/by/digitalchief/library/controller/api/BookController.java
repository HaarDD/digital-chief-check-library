package by.digitalchief.library.controller.api;

import by.digitalchief.library.dto.BookCreateDto;
import by.digitalchief.library.utils.PageableUtils;
import by.digitalchief.library.dto.BookDto;
import by.digitalchief.library.dto.PageRequestDto;
import by.digitalchief.library.service.BookService;
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
@RequestMapping("/api/books")
@Tag(name = "Books Controller")
public class BookController implements BaseCrudController<BookCreateDto, BookDto> {

    private final BookService bookService;

    @Override
    @Operation(
            summary = "Get books by pageable",
            description = "Get all books by page number, page size, sort direction & field to sort"
    )
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getAllByPageable(@ParameterObject @Valid PageRequestDto pageRequest) {
        return bookService.findAllByPageable(PageableUtils.validatePageable(pageRequest));
    }

    @Override
    @Operation(
            summary = "Get book by id"
    )
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @Override
    @Operation(
            summary = "Create book by dto"
    )
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto create(@Valid @RequestBody BookCreateDto bookCreateDto) {
        return bookService.save(bookCreateDto);
    }

    @Override
    @Operation(
            summary = "Update book by dto"
    )
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto update(@Valid @RequestBody BookCreateDto bookCreateDto, @PathVariable Long id) {
        return bookService.update(bookCreateDto, id);
    }

    @Override
    @Operation(
            summary = "Delete book by id"
    )
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bookService.delete(id);
    }
}
