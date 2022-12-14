package nc.deveo.fitncbackend.config.security;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSecurity {
    private String name;
    private String photoUrl;
    private String uid;
    private String email;
    private Long expiration;
    private Boolean emailVerified;
}
