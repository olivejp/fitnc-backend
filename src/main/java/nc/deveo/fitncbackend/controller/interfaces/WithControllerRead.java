package nc.deveo.fitncbackend.controller.interfaces;

import nc.deveo.fitncbackend.service.interfaces.WithServiceRead;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public interface WithControllerRead<T, U extends WithServiceRead<T>> extends IGetService<U> {

    @GetMapping
    default Page<T> readAll(final Pageable pageable) {
        return getService().readPage(pageable);
    }

    @GetMapping("/{id}")
    default T read(@PathVariable Long id) {
        return getService().read(id);
    }
}
