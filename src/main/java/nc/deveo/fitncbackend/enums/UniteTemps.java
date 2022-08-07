package nc.deveo.fitncbackend.enums;

import lombok.Getter;

@Getter
public enum UniteTemps {
    HEURE(60 * 60),
    MINUTE(60),
    SECONDE(1);

    private final Integer nombreSeconde;

    UniteTemps(Integer nombreSeconde) {
        this.nombreSeconde = nombreSeconde;
    }
}
