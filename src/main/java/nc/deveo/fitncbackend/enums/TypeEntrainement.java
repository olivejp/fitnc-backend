package nc.deveo.fitncbackend.enums;

import lombok.Getter;

/**
 * Va permettre de conditionner les variables d'entrée de l'entrainement et les résultats de sortie de l'utilisateur sur cet entrainement.
 * Par exemple, pour un entrainement AMRAP, on voudra saisir le nombre de rounds fait au final par l'utilisateur.
 */
@Getter
public enum TypeEntrainement {
    DEFAUT("Par défaut", false),
    MUSCULATION("Musculation", false), // On regroupera les étapes par exercices.
    AMRAP("As Many Round As Possible", true), // Pouvoir choisir la durée.
    FOR_TIME("For time", true), // Pouvoir rentrer un temps à la fin de l'entrainement
    ROUNDS("Rounds", true), // Pouvoir saisir un nombre de rounds.
    EMOM("Each Minute On the Minute", true); // Pouvoir saisir le nombre de minutes.

    private final String label;
    private final Boolean crossfit;

    TypeEntrainement(String label, Boolean crossfit) {
        this.label = label;
        this.crossfit = crossfit;
    }
}
