package nc.deveo.fitncbackend.enums;

import lombok.Getter;

@Getter
public enum UnitePoids {
    POURCENTAGE("Pourcentage"),
    KILO("Kilos"),
    POUNDS("Pounds");

    private final String label;

    UnitePoids(String label) {
        this.label = label;
    }
}
