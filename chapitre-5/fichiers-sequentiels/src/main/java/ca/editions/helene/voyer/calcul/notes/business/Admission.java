package ca.editions.helene.voyer.calcul.notes.business;

import java.util.LinkedList;

import ca.editions.helene.voyer.calcul.notes.modele.EtudiantPremierCycle;

public class Admission {
    static LinkedList<EtudiantPremierCycle> etudiantAdmis = new LinkedList<EtudiantPremierCycle>();

    public Admission() {
    }

    static final Admission INSTANCE = new Admission();

    public static Admission getInstance() {
        return INSTANCE;
    }

    // code permanent ici au Québec ça identifie un étudiant du secondaire
    //     jusqu'au doctorat.
    public EtudiantPremierCycle admettre(String codePermanent, String codeProgramme) {
        return new EtudiantPremierCycle(codePermanent, codeProgramme);
        // Vérifier que le fichier sequentiel des étudiants admis n'existe pas encore et le créer si nécessaire
        //  en utilisant CreationFichierSequentiel.java
        // si le fichier existe, l'ouvrir en lecture
        // vérifier que l'étudiant n'a pas déjà été admis en lisant le fichier sequentiel existant
        // si non l'ajouter à la fin du fichier sequentiel existant
        // ajouter l'étudiant admis au fichier sequentiel en utlisant EcrireFichierSequentiel.java
        // fermer le fichier sequentiel des étudiants admis
    }
}
