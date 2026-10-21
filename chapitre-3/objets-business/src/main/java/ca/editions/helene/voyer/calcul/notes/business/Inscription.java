package ca.editions.helene.voyer.calcul.notes.business;

import java.util.LinkedList;

import ca.editions.helene.voyer.calcul.notes.modele.EtudiantCours;

public class Inscription {
    static Inscription instance = null;
    static LinkedList<EtudiantCours> etudiantsInscrits = new LinkedList<EtudiantCours>();

    private Inscription() {
    }

    public static Inscription getInstance() {
        if (instance == null) {
            instance = new Inscription();
        }
        return instance;
    }

    public EtudiantCours inscrire(EtudiantCours etudiant) {
        // Inscrire l'étudiant et retourner l'objet étudiant inscrit
        etudiantsInscrits.add(etudiant);
        return etudiant;
    }

    public LinkedList<EtudiantCours> getEtudiantsInscrits() {
        return etudiantsInscrits;
    }
}
