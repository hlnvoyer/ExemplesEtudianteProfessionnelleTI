package ca.editions.helene.voyer.calcul.notes.business;

import java.util.LinkedList;
import ca.editions.helene.voyer.calcul.notes.modele.EtudiantCours;
import ca.editions.helene.voyer.calcul.notes.modele.Cours;

public class GestionCours {
    static GestionCours instance = null;
    static LinkedList<EtudiantCours> etudiantsInscrits = new LinkedList<EtudiantCours>();
    
    private GestionCours() {
    }

    public static GestionCours getInstance() {
        if (instance == null) {
            instance = new GestionCours();
        }
        return instance;
    }

    public void ajouter(String codeCours, Cours[] prerequis) {
        // Implémentation pour ajouter un cours avec ses prérequis


    }
 }
