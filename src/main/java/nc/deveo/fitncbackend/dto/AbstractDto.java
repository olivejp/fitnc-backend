package nc.deveo.fitncbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@SuperBuilder
@NoArgsConstructor
public abstract class AbstractDto {
    private Integer version;
    private String createdBy;
    private Instant createdDate;
    private String updatedBy;
    private Instant updatedDate;
}
