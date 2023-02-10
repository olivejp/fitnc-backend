package nc.deveo.fitncbackend.enums;

import lombok.Getter;

@Getter
public enum UnitePoids implements IEnumDto {
    POURCENTAGE("Pourcentage"),
    KILO("Kilos"),
    POUNDS("Pounds");

    private final String label;

    UnitePoids(String label) {
        this.label = label;
    }

    @Override
    public String getFriendlyValue() {
        return this.label;
    }

    @Override
    public String getValue() {
        return this.name();
    }
}
