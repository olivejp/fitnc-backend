package nc.deveo.fitncbackend.enums;

import lombok.Getter;

@Getter
public enum UniteTemps {
    HEURE("Heure", 60 * 60),
    MINUTE("Minute", 60),
    SECONDE("Seconde", 1);

    private final String label;
    private final Integer nombreSeconde;

    UniteTemps(String label, Integer nombreSeconde) {
        this.label = label;
        this.nombreSeconde = nombreSeconde;
    }
}
