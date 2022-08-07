package nc.deveo.fitncbackend.service.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface WithServiceRead<T> {

    Page<T> readPage(Pageable pageable);

    T read(Long id);
}
