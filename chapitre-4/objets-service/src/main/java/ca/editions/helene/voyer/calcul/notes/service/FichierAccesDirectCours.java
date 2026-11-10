package ca.editions.helene.voyer.calcul.notes.service;

import java.io.IOException;
import java.io.RandomAccessFile;

import ca.editions.helene.voyer.calcul.notes.modele.CoursPremierCycle;

/*
"r"	    Read-Only	    Opens the file for reading. Any write attempt throws an IOException.
"rw"	Read & Write	Opens for both operations. Automatically creates the file if it doesn't already exist.
"rws"	Synchronous (Content + Metadata)	Requires every update to the file's content and metadata to flush synchronously to disk.
"rwd"	Synchronous (Content Only)	Requires only the file's content updates to flush synchronously to disk.
 */

/* longueurEnregistrement = longueur d'un enregistrement dans le fichier 
déterminant où les données commencent pour l'enregistrement choisi 
 variable parce que le nombre de prérequis peut changer entre chaque cours */

/**
 * Exemple d'utilisation :
 * FichierAccesDirectCours fac = new FichierAccesDirectCours();
 * CoursPremierCycle c = fac.lireEnregistrement("cours.dat", "premier", 100);
 * 
 * Enregistrement
 * Code de cours (6 caractères à 2 bytes chaque = 12 bytes) (on utilise
 * writeChars() )
 * Titre du cours (2 bytes par caractère)
 * Nombre de travaux pratique (un int donc 4 bytes)
 * Pondération de chaque travail pratique (un double donc 8 bytes)
 * y/n examen de mi-session (un boolean donc 1 byte)
 * Pondération de l'examen de mi-session (0.0 si pas d'examen de mi-session) (un
 * double donc 8 bytes)
 * Pondération de l'examen de fin de session (au moins un examen par cours) (un
 * double donc 8 bytes)
 * 
 */
public class FichierAccesDirectCours implements FichierAccesDirect {
    public CoursPremierCycle lireEnregistrement(String nomFichier, int cle) {
        CoursPremierCycle ceCours = new CoursPremierCycle(null, null, 0);
        try {
            RandomAccessFile raf = new RandomAccessFile(nomFichier, "r");
            long offset = cle * 141; // chaque enregistrement fait 141 bytes
            System.out.println("Offset: " + offset);
            raf.seek(offset);
            // le code du cours
            char[] codeCours = new char[6];
            for (int i = 0; i < 6; i++) {
                codeCours[i] = raf.readChar();
            }
            System.out.println("Code du cours lu: " + new String(codeCours));
            ceCours.setCodeCours(new String(codeCours));
            // le titre du cours
            char[] titreCours = new char[50];
            for (int i = 0; i < 50; i++) {
                titreCours[i] = raf.readChar();
            }
            System.out.println("Titre du cours lu: " + new String(titreCours));
            ceCours.setTitreCours(new String(titreCours));
            // le nombre de travaux pratique
            int nombreDeTravauxPratiques = raf.readInt();
            ceCours.setNombreDeTravauxPratiques(nombreDeTravauxPratiques);
            // la pondération de chaque travail pratique
            double ponderationsTravauxPratiques = 0.0;
            ceCours.setPonderationTravauxPratique(ponderationsTravauxPratiques);
            // la pondération de l'examen de mi-session
            double ponderationExamenMiSession = raf.readDouble();
            ceCours.setPonderationExamenMiSession(ponderationExamenMiSession);
            double ponderationExamenFinSession = raf.readDouble();
            ceCours.setPonderationExamenFinSession(ponderationExamenFinSession);
            raf.close();
            return ceCours;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void ecrireEnregistrement(String nomFichier, int cle, CoursPremierCycle contenu) {
        /*
         * enregistrement
         * Code du cours = 6 chars = 12 bytes (2 bytes par char)
         * Titre du cours = max 50 chars = 100 bytes (2 bytes par char)
         * Nombre de travaux pratique = 4 bytes (int)
         * Pondération de chaque travail pratique = 8 bytes (double)
         * Examen de mi-session = 1 byte (boolean)
         * Pondération de l'examen de mi-session = 8 bytes (double)
         * Pondération de l'examen de fin de session = 8 bytes (double)
         * Total est 12 + 100 + 4 + 8 + 1 + 8 + 8 = 141 bytes
         */
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(nomFichier, "rw");
            long offset = raf.getFilePointer();
            if (cle > 0) {
                // calculer l'offset pour la clé positive
                offset = (cle - 1) * 141;
            } else {
                // si la clé est 0 ou négative, on commence à l'offset 0
                offset = 0;
            }
            offset = cle * 141;
            System.out.println("Offset: " + offset);
            raf.seek(offset);
            // enregistrement 1 commence à offset 0
            // enregistrement 2 commencera à offset 141
            // calculer l'offset pour le prochain enregistrement
            // écrire le contenu à l'offset actuel et en bytes pas en texte comme pour le
            // fichier séquentiel
            // écrire le code du cours en bytes
            raf.writeChars(contenu.getCodeCours());
            // écrire le titre du cours en bytes
            raf.writeChars(contenu.getTitreCours());
            // écrire le nombre de travaux pratique en bytes
            raf.writeInt(contenu.getNombreDeTravauxPratiques());
            // écrire la pondération de chaque travail pratique en bytes
            raf.writeDouble(contenu.getPonderationTravauxPratique());
            // écrire l'examen de mi-session en bytes
            raf.writeDouble(contenu.getPonderationExamenMiSession());
            // écrire la pondération de l'examen de mi-session en bytes
            raf.writeDouble(contenu.getPonderationExamenMiSession());
            // écrire la pondération de l'examen de fin de session en bytes
            raf.writeDouble(contenu.getPonderationExamenFinSession());
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
