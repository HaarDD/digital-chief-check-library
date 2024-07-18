package by.digitalchief.library.service.impl;

import by.digitalchief.library.dto.BookCreateDto;
import by.digitalchief.library.dto.BookDto;
import by.digitalchief.library.entity.Book;
import by.digitalchief.library.mapper.BookMapper;
import by.digitalchief.library.repository.BookRepository;
import by.digitalchief.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    private final static String ENTITY_NAME = "Book";

    @Override
    public List<BookDto> findAllByPageable(Pageable pageable) {
        return bookMapper.toDtoList(bookRepository.findAll(pageable).toList());
    }

    @Override
    public BookDto findById(Long id) {
        return bookRepository.findById(id).map(bookMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException("%s not found by id: %d".formatted(ENTITY_NAME, id)));
    }

    @Override
    @Transactional
    public BookDto save(BookCreateDto bookCreateDto) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toEntity(bookCreateDto)));
    }

    @Override
    @Transactional
    public BookDto update(BookCreateDto bookCreateDto, Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("%s not found by id: %d".formatted(ENTITY_NAME, id)));
        return bookMapper.toDto(bookRepository.save(bookMapper.partialUpdate(bookCreateDto, book)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        bookRepository.delete(bookRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("%s not found by id: %d".formatted(ENTITY_NAME, id))));
    }
}
