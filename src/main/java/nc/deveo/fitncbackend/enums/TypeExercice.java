package nc.deveo.fitncbackend.enums;

import lombok.Getter;

/**
 * Le type d'exercice conditionne les variables à prendre en compte pour cet exercice.
 */
@Getter
public enum TypeExercice implements IEnumDto {
    ENDURANCE("Permet de définir un objectif de temps sur cet exercice", "Endurance"),
    REPETITION("Permet de définir un objectif de répétition", "Répétition"),
    POIDS("Permet de définir un objectif de poids", "Poids"),
    DISTANCE("Permet de définir un objectif de distance", "Distance"),
    REPETITION_POIDS("Permet de définir un objectif de répétition et de poids", "Répétition poids"),
    REPETITION_POIDS_TEMPS("Permet de définir un objectif de répétition, de poids et de temps", "Répétition poids & temps");

    private final String label;
    private final String friendlyValue;

    TypeExercice(String label, String friendlyValue) {
        this.label = label;
        this.friendlyValue = friendlyValue;
    }

    @Override
    public String getFriendlyValue() {
        return this.friendlyValue;
    }

    @Override
    public String getValue() {
        return this.name();
    }
}
