package by.digitalchief.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PageRequestDto {

    Integer page;

    Integer size;

    String sort;

    String direction;

}
