package ca.editions.helene.voyer.calcul.notes.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.util.HashMap;

import ca.editions.helene.voyer.calcul.notes.modele.Etudiant;
import ca.editions.helene.voyer.calcul.notes.modele.EtudiantCours;
import ca.editions.helene.voyer.calcul.notes.modele.TravailPratique;
import ca.editions.helene.voyer.calcul.notes.modele.ExamenMiSession;
import ca.editions.helene.voyer.calcul.notes.modele.ExamenFinSession;

public class FichierSequentielEtudiants implements FichierSequentiel {

    public void ecrireFichier(String nomFichier, String contenu) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(nomFichier, true)); // ouvrir en mode ajout
            if (writer != null) {
                writer.write(contenu);
                writer.newLine(); // ajouter un saut de ligne après l'écriture du contenu
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public HashMap<String, EtudiantCours> lireFichier(String nomFichier) {
        HashMap<String, EtudiantCours> etudiantsCours = new HashMap<String, EtudiantCours>();
        String codeCours = "";
        try {
            String ligne;
            String codePermanent = "";
            String nomEtudiant = "";
            String codeProgramme = "";
            int doubleTp1 = 0;
            int doubleTp2 = 0;
            int doubleTp3 = 0;
            int doubleExamenMiSession = 0;
            int doubleExamenFinSession = 0;
            EtudiantCours etudiantCours = null;
            Etudiant etudiant = null;
            TravailPratique tp1 = null;
            TravailPratique tp2 = null;
            TravailPratique tp3 = null;
            ExamenMiSession examenMiSession = null;
            ExamenFinSession examenFinSession = null;
            BufferedReader br = new BufferedReader(new FileReader(nomFichier));
            ligne = br.readLine();
            System.out.println("Processing ligne : " + ligne);
            while (ligne != null) {
                // The limit -1 forces Java to include empty trailing values
                String[] values = ligne.split(",", -1);
                // Process the values
                for (int j = 0; j < 9; j++) {
                    String value = values[j];
                    System.out.println("Processing value: " + value + " at index: " + j);
                    switch (j) {
                        case 0:
                            // Code permanent
                            codePermanent = value.trim();
                            break;
                        case 1:
                            // Nom étudiant
                            nomEtudiant = value.trim();
                            break;
                        case 2:
                            // Code cours
                            codeProgramme = value.trim();
                            break;
                        case 3:
                            // Code cours
                            codeCours = value.trim();
                            break;
                        case 4:
                            // TP1
                            doubleTp1 = Integer.parseInt(value.trim());
                            break;
                        case 5:
                            // TP2
                            doubleTp2 = Integer.parseInt(value.trim());
                            break;
                        case 6:
                            // TP3
                            doubleTp3 = Integer.parseInt(value.trim());
                            break;
                        case 7:
                            // Examen mi-session
                            doubleExamenMiSession = Integer.parseInt(value.trim());
                            break;
                        case 8:
                            // Examen final
                            doubleExamenFinSession = Integer.parseInt(value.trim());
                            break;
                        default:
                            // Cas par défaut pour gérer les colonnes inattendues
                            System.out.println("Colonne inattendue : " + value);
                            break;
                    }
                }
                etudiantCours = new EtudiantCours(codePermanent, nomEtudiant, "7833", "INF101");
                tp1 = new TravailPratique(doubleTp1, 0.1);
                tp2 = new TravailPratique(doubleTp2, 0.1);
                tp3 = new TravailPratique(doubleTp3, 0.1);
                examenMiSession = new ExamenMiSession(doubleExamenMiSession, 0.3);
                examenFinSession = new ExamenFinSession(doubleExamenFinSession, 0.4);
                etudiant = new Etudiant(nomEtudiant, tp1, tp2, tp3, examenMiSession, examenFinSession);
                etudiantCours.setEtudiant(etudiant);
                etudiantsCours.put(codePermanent, etudiantCours);
                ligne = br.readLine();
                System.out.println("Processing ligne : " + ligne);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return etudiantsCours;
    }
}
