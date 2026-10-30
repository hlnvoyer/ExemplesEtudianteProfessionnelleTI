package ca.editions.helene.voyer.calcul.notes;

import java.util.HashMap;

import ca.editions.helene.voyer.calcul.notes.business.GestionProgrammeEtudes;

import ca.editions.helene.voyer.calcul.notes.modele.CoursPremierCycle;
import ca.editions.helene.voyer.calcul.notes.modele.EtudiantCours;
import ca.editions.helene.voyer.calcul.notes.modele.ProgrammeEtudesPremierCycle;
import ca.editions.helene.voyer.calcul.notes.service.FichierAccesDirect;
import ca.editions.helene.voyer.calcul.notes.service.FichierAccesDirectCours;
import ca.editions.helene.voyer.calcul.notes.service.FichierSequentiel;
import ca.editions.helene.voyer.calcul.notes.service.FichierSequentielEtudiants;

public class TravailPratiqueFichiers {

      public enum NotationLitterale {
            A_PLUS, A, A_MINUS,
            B_PLUS, B, B_MINUS,
            C_PLUS, C, C_MINUS,
            D_PLUS, D,
            E
      }

      public static void main(String[] args) {
            // TP signifie Travail Pratique
            // Examen de mi-session
            // Examen de fin de session
            // Le tableau etudiant contient le nom de l'etudiant suivi de ses notes pour les
            // 3 TPs, l'examen de mi-session et l'examen de fin de session
            // Création d'un programme et d'une liste d'étudiants admis à ce programme
            initialiserProgramme();
            // on a un programme avec des cours
            // on veut le programme 7833
            ProgrammeEtudesPremierCycle baccInformatique = GestionProgrammeEtudes.getProgramme("7833");
            // obtenir les listes de cours de chaque type pour le programme bacc en
            // informatique
            // obtenir le cours obligatoire via le fichier à accès direct
            FichierAccesDirectCours fac = new FichierAccesDirectCours();
            String nomFichierAccesDirect = "C:\\dev_livre\\ExemplesManuscrit\\user-story-5\\ExemplesEtudianteProfessionnelleTI\\chapitre-5\\objets-service-2\\cours.dat";
            // on sait que le premier enregistrement est INF101
            CoursPremierCycle ceCours = fac.lireEnregistrement(nomFichierAccesDirect, 0);
            System.out.println(" bon cours du fichier accès direct ? " + ceCours.getCodeCours());
            // essayons d'obtenir le 4ième cours obligatoire
            CoursPremierCycle testCours = fac.lireEnregistrement(nomFichierAccesDirect, 3);
            System.out.println(" 4ième cours du fichier accès direct ? " + testCours.getCodeCours());
            // si c'est INF201 c'est bon car on a INF101, INF102, INF103 et INF201 ensuite.
            HashMap<String, CoursPremierCycle> obligatoires = baccInformatique.getCoursObligatoires();
            // on veut le cours Techniques de programmation I du programme 7833
            // CoursPremierCycle ceCours = obligatoires.get("INF101");
            // obtenir la liste des étudiants du cours Techniques de programmation I
            HashMap<String, EtudiantCours> etudiants = new HashMap<String, EtudiantCours>();
            // écrire les informations des étudiants dans le fichier "etudiants.txt"
            FichierSequentiel fichier = new FichierSequentielEtudiants();
            String nomFichierSequentiel = "C:\\dev_livre\\ExemplesManuscrit\\user-story-5\\ExemplesEtudianteProfessionnelleTI\\chapitre-5\\objets-service-2\\etudiants.txt";
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000001,Etudiant 1,7833,INF101,75,55,88,79,85");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000002,Etudiant 2,7833,INF101,65,75,78,74,81");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000003,Etudiant 3,7833,INF101,85,90,80,70,95");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000004,Etudiant 4,7833,INF101,90,85,75,80,88");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000005,Etudiant 5,7833,INF101,70,80,85,75,84");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000006,Etudiant 6,7833,INF101,95,85,88,80,85");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000007,Etudiant 7,7833,INF101,80,71,85,90,65");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000008,Etudiant 8,7833,INF101,65,60,67,65,60");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000009,Etudiant 9,7833,INF101,71,75,70,70,75");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000010,Etudiant 10,7833,INF101,50,58,55,55,58");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000011,Etudiant 11,7833,INF101,78,75,80,90,92");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000012,Etudiant 12,7833,INF101,65,70,78,75,60");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000013,Etudiant 13,7833,INF101,65,62,60,68,70");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000014,Etudiant 14,7833,INF101,80,85,82,87,88");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000015,Etudiant 15,7833,INF101,85,80,84,90,92");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000016,Etudiant 16,7833,INF101,80,82,85,88,90");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000017,Etudiant 17,7833,INF101,85,85,80,90,95");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000018,Etudiant 18,7833,INF101,80,80,85,85,90");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000019,Etudiant 19,7833,INF101,85,82,80,88,90");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000020,Etudiant 20,7833,INF101,80,85,82,87,88");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000021,Etudiant 21,7833,INF101,85,80,84,90,92");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000022,Etudiant 22,7833,INF101,80,82,85,88,90");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000023,Etudiant 23,7833,INF101,85,85,80,90,95");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000024,Etudiant 24,7833,INF101,80,80,85,85,90");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000025,Etudiant 25,7833,INF101,85,82,80,88,90");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000026,Etudiant 26,7833,INF101,80,85,82,87,88");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000027,Etudiant 27,7833,INF101,85,80,84,90,92");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000028,Etudiant 28,7833,INF101,80,82,85,88,90");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000029,Etudiant 29,7833,INF101,85,85,80,90,95");
            fichier.ecrireFichier(nomFichierSequentiel, "VOYH00000030,Etudiant 30,7833,INF101,80,80,85,85,90");
            fichier = null;
            // lire chaque ligne du fichier pour vérifier son contenu
            // fichier.lireFichier("etudiants.txt");
            System.out.println("Lecture du fichier : " + nomFichierSequentiel);
            fichier = new FichierSequentielEtudiants();
            HashMap<String, EtudiantCours> etudiantsCours = fichier.lireFichier(nomFichierSequentiel);
            System.out.println("Lecture du fichier terminée. grosseur de la HashMap : " + etudiantsCours.size());
            // initialiserEtudiants();
            double totalNotes = 0;
            // calculons la note ponderee d'un seul etudiant
            for (EtudiantCours etudiant : etudiantsCours.values()) {
                  double notePondereeTP1 = etudiant.getEtudiant().getTp1().getNote()
                              * etudiant.getEtudiant().getTp1().getPoids();

                  double notePondereeTP2 = etudiant.getEtudiant().getTp2().getNote()
                              * etudiant.getEtudiant().getTp2().getPoids();

                  double notePondereeTP3 = etudiant.getEtudiant().getTp3().getNote()
                              * etudiant.getEtudiant().getTp3().getPoids();

                  double notePondereeMiSession = etudiant.getEtudiant().getExamenMiSession().getNote()
                              * etudiant.getEtudiant().getExamenMiSession().getPoids();

                  double notePondereeFinSession = etudiant.getEtudiant().getExamenFinSession()
                              .getNote()
                              * etudiant.getEtudiant().getExamenFinSession().getPoids();

                  double notePonderee = notePondereeTP1 + notePondereeTP2 + notePondereeTP3 + notePondereeMiSession
                              + notePondereeFinSession;
                  /*
                   * Barème de conversion typique (Échelle de 4,3)
                   * • 90% – 100% : A+ (4,3) – Excellent
                   * • 85% – 89% : A (4,0) – Excellent
                   * • 80% – 84% : A- (3,7) – Excellent
                   * • 77% – 79% : B+ (3,3) – Très bien
                   * • 73% – 76% : B (3,0) – Bien
                   * • 70% – 72% : B- (2,7) – Bien
                   * • 65% – 69% : C+ (2,3) – Satisfaisant
                   * • 60% – 64% : C (2,0) – Satisfaisant
                   * • 57% – 59% : C- (1,7) – Passable
                   * • 54% – 56% : D+ (1,3) – Passable
                   * • 50% – 53% : D (1,0) – Passable (note de passage au 1er cycle)
                   * • 0% – 49% : F (0,0) – Échec
                   */

                  NotationLitterale notationLiteraleEnum;
                  if (notePonderee >= 90) { // Excellent A+
                        notationLiteraleEnum = NotationLitterale.A_PLUS;
                  } else if (notePonderee >= 85 && notePonderee < 90) { // Excellent A
                        notationLiteraleEnum = NotationLitterale.A;
                  } else if (notePonderee >= 80 && notePonderee < 85) { // Excellent A-
                        notationLiteraleEnum = NotationLitterale.A_MINUS;
                  } else if (notePonderee >= 77 && notePonderee < 80) { // Très bien B+
                        notationLiteraleEnum = NotationLitterale.B_PLUS;
                  } else if (notePonderee >= 73 && notePonderee < 77) { // Bien B
                        notationLiteraleEnum = NotationLitterale.B;
                  } else if (notePonderee >= 70 && notePonderee < 73) { // Bien B-
                        notationLiteraleEnum = NotationLitterale.B_MINUS;
                  } else if (notePonderee >= 65 && notePonderee < 70) { // Satisfaisant C+
                        notationLiteraleEnum = NotationLitterale.C_PLUS;
                  } else if (notePonderee >= 60 && notePonderee < 65) { // Satisfaisant C
                        notationLiteraleEnum = NotationLitterale.C;
                  } else if (notePonderee >= 57 && notePonderee < 60) { // Passable C-
                        notationLiteraleEnum = NotationLitterale.C_MINUS;
                  } else if (notePonderee >= 54 && notePonderee < 57) { // Passable D+
                        notationLiteraleEnum = NotationLitterale.D_PLUS;
                  } else if (notePonderee >= 50 && notePonderee < 54) { // Passable D
                        notationLiteraleEnum = NotationLitterale.D;
                  } else { // Échec E
                        notationLiteraleEnum = NotationLitterale.E;
                  }

                  System.out.println("La note ponderee de " + etudiant.getNom() + " est " + notePonderee
                              + " et la notation literale est : " + " " + notationLiteraleEnum);
                  totalNotes += notePonderee;
            }
            double moyenne = totalNotes / etudiantsCours.size();
            System.out.println("La moyenne des notes pour le cours " + ceCours.getTitreCours() + " est " + moyenne);
      }

      public static void initialiserProgramme() {
            GestionProgrammeEtudes gestionProgramme = GestionProgrammeEtudes.getInstance();
            HashMap<String, CoursPremierCycle> prerequis = gestionProgramme.getCoursPrerequis("7833");
            HashMap<String, CoursPremierCycle> coursObligatoires = gestionProgramme.getCoursObligatoires("7833");
            HashMap<String, CoursPremierCycle> coursOptionnels = gestionProgramme.getCoursOptionnels("7833");
            HashMap<String, CoursPremierCycle> coursLibres = gestionProgramme.getCoursLibres("7833");

            if (prerequis == null) {
                  prerequis = new HashMap<String, CoursPremierCycle>();
            }
            if (coursObligatoires == null) {
                  coursObligatoires = new HashMap<String, CoursPremierCycle>();
            }
            if (coursOptionnels == null) {
                  coursOptionnels = new HashMap<String, CoursPremierCycle>();
            }
            if (coursLibres == null) {
                  coursLibres = new HashMap<String, CoursPremierCycle>();
            }
            CoursPremierCycle mathématiques = new CoursPremierCycle("MAT101", "Mathématiques", 3);
            prerequis.put("MAT101", mathématiques);

            CoursPremierCycle techniquesProgrammationUn = new CoursPremierCycle("INF101",
                        "Techniques de programmation I", 3);
            coursObligatoires.put("INF101", techniquesProgrammationUn);
            CoursPremierCycle techniquesProgrammationDeux = new CoursPremierCycle("INF102",
                        "Techniques de programmation II", 3);
            coursObligatoires.put("INF102", techniquesProgrammationDeux);
            CoursPremierCycle techniquesProgrammationTrois = new CoursPremierCycle("INF103",
                        "Techniques de programmation III", 3);
            coursObligatoires.put("INF103", techniquesProgrammationTrois);
            CoursPremierCycle structuresDeDonnees = new CoursPremierCycle("INF201", "Structures de données", 3);
            coursObligatoires.put("INF201", structuresDeDonnees);
            CoursPremierCycle algorithmique = new CoursPremierCycle("INF202", "Algorithmique", 3);
            coursObligatoires.put("INF202", algorithmique);
            FichierAccesDirect fichier = new FichierAccesDirectCours();
            String nomFichier = "C:\\dev_livre\\ExemplesManuscrit\\user-story-5\\ExemplesEtudianteProfessionnelleTI\\chapitre-5\\objets-service-2\\cours.dat";
            fichier.ecrireEnregistrement(nomFichier, 0, ((CoursPremierCycle) coursObligatoires.get("INF101")));
            fichier.ecrireEnregistrement(nomFichier, 1, ((CoursPremierCycle) coursObligatoires.get("INF102")));
            fichier.ecrireEnregistrement(nomFichier, 2, ((CoursPremierCycle) coursObligatoires.get("INF103")));
            fichier.ecrireEnregistrement(nomFichier, 3, ((CoursPremierCycle) coursObligatoires.get("INF201")));
            fichier.ecrireEnregistrement(nomFichier, 4, ((CoursPremierCycle) coursObligatoires.get("INF202")));

            CoursPremierCycle gestionResourceInformation = new CoursPremierCycle("INF301",
                        "Gestion de la ressource information",
                        3);
            coursOptionnels.put("INF301", gestionResourceInformation);

            CoursPremierCycle espagnol = new CoursPremierCycle("ESP101", "Espagnol", 3);
            coursLibres.put("ESP101", espagnol);

            gestionProgramme.setCoursObligatoires("7833", coursObligatoires);
            gestionProgramme.setCoursOptionnels("7833", coursOptionnels);
            gestionProgramme.setCoursLibres("7833", coursLibres);
            gestionProgramme.setCoursPrerequis("7833", prerequis);

            gestionProgramme.ajouterProgramme("7833", "Baccalauréat en sciences appliquées (Informatique)",
                        "Informatique", GestionProgrammeEtudes.CycleEnum.PREMIER_CYCLE,
                        prerequis, coursObligatoires, coursOptionnels, coursLibres);

      }
}
