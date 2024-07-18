package by.digitalchief.library.utils;

import by.digitalchief.library.dto.PageRequestDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableUtils {

    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_SIZE = 10;
    private static final String DEFAULT_SORT = "id";
    private static final Sort.Direction DEFAULT_DIRECTION = Sort.Direction.ASC;

    public static Pageable validatePageable(PageRequestDto pageRequestDto) {

        int pageNumber = (pageRequestDto.getPage() != null && pageRequestDto.getPage() >= 1) ? pageRequestDto.getPage() : DEFAULT_PAGE;
        int pageSize = (pageRequestDto.getSize() != null
                && pageRequestDto.getSize() >= 1
                && pageRequestDto.getSize() <= 100) ? pageRequestDto.getSize() : DEFAULT_SIZE;
        String sortBy = (pageRequestDto.getSort() != null && !pageRequestDto.getSort().isEmpty()) ? pageRequestDto.getSort() : DEFAULT_SORT;
        Sort.Direction sortDirection = (pageRequestDto.getDirection() != null &&
                (pageRequestDto.getDirection().equalsIgnoreCase("asc")
                        || pageRequestDto.getDirection().equalsIgnoreCase("desc")))
                ? (pageRequestDto.getDirection().equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC)
                : DEFAULT_DIRECTION;
        return PageRequest.of(pageNumber - 1, pageSize, Sort.by(sortDirection, sortBy));
    }

}
