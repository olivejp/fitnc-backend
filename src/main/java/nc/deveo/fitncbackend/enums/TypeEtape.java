package nc.deveo.fitncbackend.enums;

import lombok.Getter;

@Getter
public enum TypeEtape implements IEnumDto {
    EXERCICE("Exercice"),
    REPOS("Repos");

    private final String label;

    TypeEtape(String label) {
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
