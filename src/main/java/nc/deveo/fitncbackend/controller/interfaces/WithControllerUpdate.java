package nc.deveo.fitncbackend.controller.interfaces;

import nc.deveo.fitncbackend.service.interfaces.WithServiceUpdate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface WithControllerUpdate<T, U extends WithServiceUpdate<T>> extends IGetService<U> {

    @PutMapping("/{id}")
    default T update(@PathVariable Long id, @Valid @RequestBody T entity) {
        return getService().update(id, entity);
    }
}
