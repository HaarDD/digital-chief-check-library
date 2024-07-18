package by.digitalchief.library.service.impl;

import by.digitalchief.library.dto.AuthorDto;
import by.digitalchief.library.entity.Author;
import by.digitalchief.library.mapper.AuthorMapper;
import by.digitalchief.library.repository.AuthorRepository;
import by.digitalchief.library.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    private final static String ENTITY_NAME = "Author";

    @Override
    public List<AuthorDto> findAllByPageable(Pageable pageable) {
        return authorMapper.toDtoList(authorRepository.findAll(pageable).toList());
    }

    @Override
    public AuthorDto findById(Long id) {
        return authorRepository.findById(id).map(authorMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException("%s not found by id: %d".formatted(ENTITY_NAME, id)));
    }

    @Override
    @Transactional
    public AuthorDto save(AuthorDto authorDto) {
        return authorMapper.toDto(authorRepository.save(authorMapper.toEntity(authorDto)));
    }

    @Override
    @Transactional
    public AuthorDto update(AuthorDto authorDto, Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("%s not found by id: %d".formatted(ENTITY_NAME, id)));
        return authorMapper.toDto(authorRepository.save(authorMapper.partialUpdate(authorDto, author)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        authorRepository.delete(authorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("%s not found by id: %d".formatted(ENTITY_NAME, id))));
    }
}
