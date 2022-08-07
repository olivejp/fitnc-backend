package nc.deveo.fitncbackend.controller.interfaces;

import nc.deveo.fitncbackend.service.interfaces.WithServiceCreate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface WithControllerCreate<T, U extends WithServiceCreate<T>> extends IGetService<U> {

    @PostMapping
    default ResponseEntity<T> create(@Valid @RequestBody T entity) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(getService().create(entity));
    }
}
