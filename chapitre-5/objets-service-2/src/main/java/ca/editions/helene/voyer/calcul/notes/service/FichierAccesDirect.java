package ca.editions.helene.voyer.calcul.notes.service;

import ca.editions.helene.voyer.calcul.notes.modele.CoursPremierCycle;

public interface FichierAccesDirect {
    public CoursPremierCycle lireEnregistrement(String nomFichier, int cle);

    public void ecrireEnregistrement(String nomFichier, int cle, CoursPremierCycle contenu);
}
