package ca.editions.helene.voyer.calcul.notes.service;

import java.io.BufferedReader;
import java.io.IOException;

public interface FichierSequentiel {
    public BufferedReader ouvrirFichier(String nomFichier, String cheminRelatif) throws IOException;
    
    public void fermerFichier(BufferedReader fichier) throws IOException;
}
