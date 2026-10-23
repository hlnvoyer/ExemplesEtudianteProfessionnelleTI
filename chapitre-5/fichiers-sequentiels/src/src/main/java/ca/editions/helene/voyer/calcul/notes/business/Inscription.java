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
        // Vérifier que le fichier sequantiel des étudiants inscrits n'existe pas encore et le créer si nécessaire
        // en utilisant CreationFichierSequentiel.java
        // Lire le fichier sequentiel des étudiants admis pour vérifier que l'étudiant a été admis
        // si l'étudiant n'a pas été admis, lever une exception
        // Lire le fichier sequentiel des étudiants inscrits pour vérifier que l'étudiant n'est pas déjà inscrit
        // si l'étudiant est déjà inscrit, lever une exception

        // Inscrire l'étudiant et retourner l'objet étudiant inscrit
        etudiantsInscrits.add(etudiant);

        // Créer le fichier sequentiel pour les étudiants inscrits en utilisant CreationFichierSequentiel.java s'il n'existe pas encore
        // Ajouter l'étudiant inscrit au fichier sequentiel en utilisant EcrireFichierSequentiel.java
        return etudiant;
    }

    public LinkedList<EtudiantCours> getEtudiantsInscrits() {
        return etudiantsInscrits;
    }
}
