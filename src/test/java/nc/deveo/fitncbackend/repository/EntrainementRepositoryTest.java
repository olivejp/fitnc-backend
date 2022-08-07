package nc.deveo.fitncbackend.repository;

import nc.deveo.fitncbackend.domain.Entrainement;
import nc.deveo.fitncbackend.domain.Exercice;
import nc.deveo.fitncbackend.domain.etape.Etape;
import nc.deveo.fitncbackend.domain.utilisateur.Utilisateur;
import nc.deveo.fitncbackend.enums.TypeEntrainement;
import nc.deveo.fitncbackend.enums.TypeEtape;
import nc.deveo.fitncbackend.enums.TypeExercice;
import nc.deveo.fitncbackend.enums.UniteTemps;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@DataJpaTest
@RunWith(SpringRunner.class)
public class EntrainementRepositoryTest {

    private EntrainementRepository entrainementRepository;


    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private EtapeRepository etapeRepository;

    @Autowired
    private ExerciceRepository exerciceRepository;

    private Utilisateur utilisateur;

    @Before
    public void setup() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("OLIVE");
        utilisateur.setPrenom("Jean Paul");
        utilisateur.setEmail("orlanth23@gmail.com");
        utilisateur.setDateNaissance(LocalDate.now());
        this.utilisateur = utilisateurRepository.save(utilisateur);
    }

    @After
    public void cleanUp() {
        etapeRepository.deleteAll();
        exerciceRepository.deleteAll();
        utilisateurRepository.deleteAll();
    }

    @Test
    public void testMethodeLafay() {
        final Exercice pompe = new Exercice();
        pompe.setNom("Pompe");
        pompe.setTypeExercice(TypeExercice.REPETITION_POIDS);
        pompe.setUtilisateur(this.utilisateur);
        exerciceRepository.save(pompe);

        final Exercice squat = new Exercice();
        squat.setNom("Squat");
        squat.setTypeExercice(TypeExercice.REPETITION_POIDS);
        squat.setUtilisateur(this.utilisateur);
        exerciceRepository.save(squat);

        final Entrainement roundsEntrainement = new Entrainement();
        roundsEntrainement.setTypeEntrainement(TypeEntrainement.ROUNDS);
        roundsEntrainement.setRounds(3);
        roundsEntrainement.setNom("Entrainement du Lundi 8 août 2022");
        roundsEntrainement.setUtilisateur(this.utilisateur);
        entrainementRepository.save(roundsEntrainement);

        final Etape etape1 = new Etape();
        etape1.setOrdre(1);
        etape1.setTypeEtape(TypeEtape.EXERCICE);
        etape1.setEntrainement(roundsEntrainement);
        etape1.setExercice(pompe);
        etapeRepository.save(etape1);

        final Etape etape2 = new Etape();
        etape2.setOrdre(2);
        etape2.setTypeEtape(TypeEtape.REPOS);
        etape2.setEntrainement(roundsEntrainement);
        etape2.setTempsRepos(30);
        etape2.setUniteTempsRepos(UniteTemps.SECONDE);
        etapeRepository.save(etape2);

        final Etape etape3 = new Etape();
        etape3.setOrdre(3);
        etape3.setTypeEtape(TypeEtape.EXERCICE);
        etape3.setEntrainement(roundsEntrainement);
        etape3.setExercice(squat);
        etapeRepository.save(etape3);

        final Etape etape4 = new Etape();
        etape4.setOrdre(4);
        etape4.setTypeEtape(TypeEtape.REPOS);
        etape4.setEntrainement(roundsEntrainement);
        etape4.setTempsRepos(30);
        etape4.setUniteTempsRepos(UniteTemps.SECONDE);
        etapeRepository.save(etape4);
    }

    @Test
    public void testMethodeGrandMere() {
        final Exercice marche = new Exercice();
        marche.setNom("Marche");
        marche.setTypeExercice(TypeExercice.ENDURANCE);
        marche.setUtilisateur(this.utilisateur);
        exerciceRepository.save(marche);

        final Exercice faireDesPas = new Exercice();
        faireDesPas.setNom("Faire des pas");
        faireDesPas.setTypeExercice(TypeExercice.REPETITION);
        faireDesPas.setUtilisateur(this.utilisateur);
        exerciceRepository.save(faireDesPas);

        final Entrainement defautEntrainement = new Entrainement();
        defautEntrainement.setTypeEntrainement(TypeEntrainement.DEFAUT);
        defautEntrainement.setNom("Entrainement du Mardi 9 août 2022");
        defautEntrainement.setUtilisateur(this.utilisateur);
        entrainementRepository.save(defautEntrainement);

        final Etape etape1 = new Etape();
        etape1.setOrdre(1);
        etape1.setTypeEtape(TypeEtape.EXERCICE);
        etape1.setEntrainement(defautEntrainement);
        etape1.setExercice(marche);
        etape1.setTemps(30);
        etape1.setUniteTemps(UniteTemps.MINUTE);
        etapeRepository.save(etape1);

        final Etape etape2 = new Etape();
        etape2.setOrdre(2);
        etape2.setTypeEtape(TypeEtape.EXERCICE);
        etape2.setEntrainement(defautEntrainement);
        etape2.setExercice(faireDesPas);
        etape2.setRepetition(10_000);
        etapeRepository.save(etape2);
    }
}
