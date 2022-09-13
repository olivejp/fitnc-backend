package nc.deveo.fitncbackend.controller.interfaces;

import nc.deveo.fitncbackend.service.interfaces.WithServiceRead;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


public interface WithControllerRead<T, U extends WithServiceRead<T>> extends IGetService<U> {

    @GetMapping
    default Page<T> readAll(@RequestParam(name = "page", required = false, defaultValue = "0") final Integer page,
                            @RequestParam(name = "size", required = false, defaultValue = "20") final Integer size,
                            @RequestParam(name = "sort", required = false) Sort sort) {
        if (sort == null) {
            sort = Sort.unsorted();
        }
        final Pageable pageable = PageRequest.of(page, size, sort);
        return getService().readPage(pageable);
    }

    @GetMapping("/{id}")
    default T read(@PathVariable Long id) {
        return getService().read(id);
    }
}
