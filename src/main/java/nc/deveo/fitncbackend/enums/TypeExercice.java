package nc.deveo.fitncbackend.enums;

import lombok.Getter;

/**
 * Le type d'exercice conditionne les variables à prendre en compte pour cet exercice.
 */
@Getter
public enum TypeExercice {
    ENDURANCE("Permet de définir un objectif de temps sur cet exercice"),
    REPETITION("Permet de définir un objectif de répétition"),
    POIDS("Permet de définir un objectif de poids"),
    DISTANCE("Permet de définir un objectif de distance"),
    REPETITION_POIDS("Permet de définir un objectif de répétition et de poids"),
    REPETITION_POIDS_TEMPS("Permet de définir un objectif de répétition, de poids et de temps");

    private final String libelle;

    TypeExercice(String libelle) {
        this.libelle = libelle;
    }
}
