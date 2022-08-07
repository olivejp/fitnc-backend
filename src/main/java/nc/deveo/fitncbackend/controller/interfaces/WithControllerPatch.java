package nc.deveo.fitncbackend.controller.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import nc.deveo.fitncbackend.exception.NotFoundException;
import nc.deveo.fitncbackend.service.interfaces.WithServicePatch;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface WithControllerPatch<T, U extends WithServicePatch<T>> extends IGetService<U> {

    String APPLICATION_JSON_PATCH_JSON = "application/json-patch+json";

    @PatchMapping(path = "/{id}", consumes = APPLICATION_JSON_PATCH_JSON)
    default ResponseEntity<T> patch(@PathVariable Long id, @RequestBody JsonPatch patch) {
        try {
            return ResponseEntity.ok(getService().patch(id, patch));
        } catch (JsonPatchException | JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
