package by.digitalchief.library.controller.api;

import by.digitalchief.library.dto.PageRequestDto;

import java.util.List;

public interface BaseCrudController<RequestDto, ResponseDto> {

    List<ResponseDto> getAllByPageable(PageRequestDto pageRequest);
    ResponseDto getById(Long id);
    ResponseDto create(RequestDto requestDto);
    ResponseDto update(RequestDto requestDto, Long id);
    void delete(Long id);

}
