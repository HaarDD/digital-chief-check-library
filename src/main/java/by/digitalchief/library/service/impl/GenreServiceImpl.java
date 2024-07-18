package by.digitalchief.library.service.impl;

import by.digitalchief.library.dto.GenreDto;
import by.digitalchief.library.entity.Genre;
import by.digitalchief.library.mapper.GenreMapper;
import by.digitalchief.library.repository.GenreRepository;
import by.digitalchief.library.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    private final static String ENTITY_NAME = "Genre";

    @Override
    public List<GenreDto> findAllByPageable(Pageable pageable) {
        return genreMapper.toDtoList(genreRepository.findAll(pageable).toList());
    }

    @Override
    public GenreDto findById(Long id) {
        return genreRepository.findById(id).map(genreMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException("%s not found by id: %d".formatted(ENTITY_NAME, id)));
    }

    @Override
    @Transactional
    public GenreDto save(GenreDto genreDto) {
        return genreMapper.toDto(genreRepository.save(genreMapper.toEntity(genreDto)));
    }

    @Override
    @Transactional
    public GenreDto update(GenreDto genreDto, Long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("%s not found by id: %d".formatted(ENTITY_NAME, id)));
        return genreMapper.toDto(genreRepository.save(genreMapper.partialUpdate(genreDto, genre)));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        genreRepository.delete(genreRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("%s not found by id: %d".formatted(ENTITY_NAME, id))));
    }
}
