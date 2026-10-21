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
    }
}
