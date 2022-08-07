package nc.deveo.fitncbackend.enums;

import lombok.Getter;

@Getter
public enum UniteDistance {
    KILOMETRE(true, 1_000.0),
    METRE(true, 1.0),
    MILE(false, 1_609.34),
    YARD(false, 0.9144);

    private final Double nombreMetre;
    private final Boolean metrique;

    UniteDistance(Boolean metrique, Double nombreMetre) {
        this.metrique = metrique;
        this.nombreMetre = nombreMetre;
    }
}
