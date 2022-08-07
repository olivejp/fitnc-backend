package nc.deveo.fitncbackend.service.interfaces;

public interface WithServiceUpdate<T> {
    T update(Long id, T entity);
}
