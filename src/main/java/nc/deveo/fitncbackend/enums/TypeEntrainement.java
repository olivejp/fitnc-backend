package nc.deveo.fitncbackend.enums;

import lombok.Getter;

/**
 * Va permettre de conditionner les variables d'entrée de l'entrainement et les résultats de sortie de l'utilisateur sur cet entrainement.
 * Par exemple, pour un entrainement AMRAP, on voudra saisir le nombre de rounds fait au final par l'utilisateur.
 */
@Getter
public enum TypeEntrainement implements IEnumDto {
    DEFAUT("Par défaut", "Défaut", false),
    MUSCULATION("Musculation", "Musculation", false), // On regroupera les étapes par exercices.
    AMRAP("As Many Round As Possible", "AMRAP", true), // Pouvoir choisir la durée.
    FOR_TIME("For time", "For time",true), // Pouvoir rentrer un temps à la fin de l'entrainement
    ROUNDS("Rounds", "Rounds",true), // Pouvoir saisir un nombre de rounds.
    EMOM("Each Minute On the Minute", "EMOM",true); // Pouvoir saisir le nombre de minutes.

    private final String label;
    private final String friendlyValue;
    private final Boolean crossfit;

    TypeEntrainement(String label, String friendlyValue, Boolean crossfit) {
        this.label = label;
        this.crossfit = crossfit;
        this.friendlyValue = friendlyValue;
    }

    @Override
    public String getValue() {
        return this.name();
    }
}
