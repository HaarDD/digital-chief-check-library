package by.digitalchief.library.service;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseCrudService<RequestDTO, ResponseDTO> {

    List<ResponseDTO> findAllByPageable(Pageable pageable);
    ResponseDTO findById(Long id);
    ResponseDTO save(RequestDTO requestDTO);
    ResponseDTO update(RequestDTO requestDTO, Long id);
    void delete(Long id);

}
