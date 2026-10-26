package ca.editions.helene.voyer.calcul.notes.service;

import java.util.HashMap;

import ca.editions.helene.voyer.calcul.notes.modele.EtudiantCours;

public interface FichierSequentiel {
    public HashMap<String, EtudiantCours> lireFichier(String nomFichier);

    public void ecrireFichier(String nomFichier, String contenu);
}