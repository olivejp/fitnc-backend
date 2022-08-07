package nc.deveo.fitncbackend.enums;

import lombok.Getter;

@Getter
public enum TypeEtape {
    EXERCICE("Exercice"),
    REPOS("Repos");

    private final String libelle;

    TypeEtape(String libelle) {
        this.libelle = libelle;
    }
}
