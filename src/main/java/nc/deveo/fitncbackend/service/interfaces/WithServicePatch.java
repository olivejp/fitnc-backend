package nc.deveo.fitncbackend.service.interfaces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;

public interface WithServicePatch<T> {
    T patch(Long id, JsonPatch entity) throws JsonPatchException, JsonProcessingException;

    Class<T> getClazz();

    ObjectMapper getObjectMapper();

    default T applyPatch(JsonPatch patch, T utilisateur) throws JsonPatchException, JsonProcessingException {
        final JsonNode patched = patch.apply(getObjectMapper().convertValue(utilisateur, JsonNode.class));
        return getObjectMapper().treeToValue(patched, getClazz());
    }
}
