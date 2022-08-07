package nc.deveo.fitncbackend.controller.interfaces;

import nc.deveo.fitncbackend.service.interfaces.WithServiceDelete;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface WithControllerDelete<U extends WithServiceDelete> extends IGetService<U> {

    @DeleteMapping("/{id}")
    default ResponseEntity<Object> delete(@PathVariable Long id) {
        getService().delete(id);
        return ResponseEntity.noContent().build();
    }
}
