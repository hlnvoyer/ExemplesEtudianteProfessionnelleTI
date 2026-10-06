package ca.editions.helene.voyer.calcul.notes.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.Double;

import ca.editions.helene.voyer.calcul.notes.modele.Cours;
import ca.editions.helene.voyer.calcul.notes.modele.CoursPremierCycle;

public class FabriqueFichierCours {
    public FabriqueFichierCours() {
    }

    static final FabriqueFichierCours INSTANCE = new FabriqueFichierCours();

    public static FabriqueFichierCours getInstance() {
        return INSTANCE;
    }

    
    // écrire les données pour les cours
    public static void creerFichierCours() {
        try {
            BufferedWriter coursSauvegarde = new BufferedWriter(new FileWriter("cours.txt"));
            coursSauvegarde.write("CodeCours,TitreCours,PonderationTP1,PonderationTP2,PonderationTP3,PonderationExamenMiSession,PonderationExamenFinSession\n");
            coursSauvegarde.write("str101,Structure de Données 1,3,3,0.1,0.1,0.1,0.3,0.4\n");
            coursSauvegarde.write("str102,Structure de Données 2,3,2,0.1,0.1,0.4,0.4\n");
            coursSauvegarde.write("str103,Structure de Données 3,3,2,0.1,0.1,0.4,0.4\n");
            coursSauvegarde.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   // lire le fichier
   // 2 options retourner un objet cours seulement ce qui permet de changer le code pour
   // un fichier à accès direct (fichier .dat) ou retourner une liste chainée de cours 
   // (demande des changements pour utiliser un fichier à accès direct)
   // faire les deux pour démontrer les différentes approches de gestion des fichiers
   public static Cours lireFichierCours() {
        try {
            Cours cours = null;
            BufferedReader coursLecture = new BufferedReader(new FileReader("cours.txt"));
            String ligne = coursLecture.readLine(); // lire l'en-tête
            String codeCours = null;
            String titreCours = null;
            int nombreDeTravauxPratiques = 0;
            double ponderationTP = 0;
            double ponderationExamenMiSession = 0.0;
            double ponderationExamenFinSession = 0.0;
            ligne = coursLecture.readLine(); // lire la première ligne de données
            if (ligne != null) {
                String[] parties = ligne.split(",");
                codeCours = parties[0];
                titreCours = parties[1];
                int nombreUnites = Integer.parseInt(parties[2]);
                nombreDeTravauxPratiques = Integer.parseInt(parties[3]);
                // ajuster les indices pour les pondérations en fonction du nombre de travaux pratiques
                for(int i = 0; i < nombreDeTravauxPratiques; i++) {
                    ponderationTP = ponderationTP + Double.parseDouble(parties[4 + i]);
                    // mettre la pondération dans un tableau ou une liste
                    // par exemple, ajouter à une liste temporaire
                    // listePonderationsTP.add(ponderationTP);
                }
                // + 2 puisque le code de cours et le titre du cours sont avant les travaux pratiques
                int positionExamenMiSession = nombreDeTravauxPratiques + 4;
                ponderationExamenMiSession = Double.parseDouble(parties[positionExamenMiSession]);
                ponderationExamenFinSession = Double.parseDouble(parties[positionExamenMiSession + 1]);
                cours = new CoursPremierCycle(codeCours, titreCours, nombreUnites, nombreDeTravauxPratiques, ponderationTP, ponderationExamenMiSession, ponderationExamenFinSession);
                ponderationExamenMiSession = 0.0;
                ponderationExamenFinSession = 0.0;
            }
            coursLecture.close();
            return cours;
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
