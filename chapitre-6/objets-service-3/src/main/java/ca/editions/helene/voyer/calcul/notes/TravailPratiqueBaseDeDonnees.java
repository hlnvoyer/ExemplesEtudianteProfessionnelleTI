package ca.editions.helene.voyer.calcul.notes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import ca.editions.helene.voyer.calcul.notes.modele.Etudiant;
import ca.editions.helene.voyer.calcul.notes.modele.EtudiantCours;
import ca.editions.helene.voyer.calcul.notes.modele.CoursPremierCycle;
import ca.editions.helene.voyer.calcul.notes.service.ConnexionBaseDeDonnees;
import ca.editions.helene.voyer.calcul.notes.service.EtudiantCoursDAO;
import ca.editions.helene.voyer.calcul.notes.service.EtudiantAdmisDAO;
import ca.editions.helene.voyer.calcul.notes.service.CoursDAO;
import ca.editions.helene.voyer.calcul.notes.service.ProgrammeDAO;

public class TravailPratiqueBaseDeDonnees {

      public enum NotationLitterale {
            A_PLUS, A, A_MINUS,
            B_PLUS, B, B_MINUS,
            C_PLUS, C, C_MINUS,
            D_PLUS, D,
            E
      }

      public static void main(String[] args) {
            // initialisation de la base de données
            ConnexionBaseDeDonnees.initialiserBaseDeDonnees();

            // Le fichier 'chapitre6.db' sera automatiquement créé à la racine de votre
            // projet
            // TP signifie Travail Pratique
            // Examen de mi-session
            // Examen de fin de session

            double totalNotes = 0;
            Connection con = ConnexionBaseDeDonnees.getInstance();
            EtudiantCoursDAO etudiantCoursDAO = new EtudiantCoursDAO(con);
            // { "Etudiant 1", 75, 55, 88, 79, 85 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000001", "Etudiant 1", 75, 55, 88,
                        79, 85);

            // { "Etudiant 2", 65, 75, 78, 74, 81 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000002", "Etudiant 2", 65, 75, 78,
                        74, 81);

            // { "Etudiant 3", 85, 90, 80, 70, 95 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000003", "Etudiant 3", 85, 90, 80,
                        70, 95);

            // { "Etudiant 4", 90, 85, 75, 80, 88 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000004", "Etudiant 4", 90, 85, 75,
                        80, 88);

            // { "Etudiant 5", 70, 80, 85, 75, 84 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000005", "Etudiant 5", 70, 80, 85,
                        75, 84);

            // { "Etudiant 6", 95, 85, 88, 80, 85 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000006", "Etudiant 6", 95, 85, 88,
                        80, 85);

            // { "Etudiant 7", 80, 71, 85, 90, 65 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000007", "Etudiant 7", 80, 71, 85,
                        90, 65);

            // { "Etudiant 8", 65, 60, 67, 65, 60 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000008", "Etudiant 8", 65, 60, 67,
                        65, 60);

            // { "Etudiant 9", 71, 75, 70, 70, 75 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000009", "Etudiant 9", 71, 75, 70,
                        70, 75);

            // { "Etudiant 10", 50, 58, 55, 55, 58 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000010", "Etudiant 10", 50, 58, 55,
                        55, 58);

            // { "Etudiant 11", 78, 75, 80, 90, 92 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000011", "Etudiant 11", 78, 75, 80,
                        90, 92);

            // { "Etudiant 12", 65, 70, 78, 75, 60 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000012", "Etudiant 12", 65, 70, 78,
                        75, 60);

            // { "Etudiant 13", 65, 62, 60, 68, 70 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000013", "Etudiant 13", 65, 62, 60,
                        68, 70);

            // { "Etudiant 14", 80, 85, 82, 87, 88 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000014", "Etudiant 14", 80, 85, 82,
                        87, 88);

            // { "Etudiant 15", 85, 80, 84, 90, 92 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000015", "Etudiant 15", 85, 80, 84,
                        90, 92);

            // { "Etudiant 16", 80, 82, 85, 88, 90 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000016", "Etudiant 16", 80, 82, 85,
                        88, 90);

            // { "Etudiant 17", 85, 85, 80, 90, 95 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000017", "Etudiant 17", 85, 85, 80,
                        90, 95);

            // { "Etudiant 18", 80, 80, 85, 85, 90 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000018", "Etudiant 18", 80, 80, 85,
                        85, 90);

            // { "Etudiant 19", 85, 82, 80, 88, 90 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000019", "Etudiant 19", 85, 82, 80,
                        88, 90);

            // { "Etudiant 20", 80, 85, 82, 87, 88 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000020", "Etudiant 20", 80, 85, 82,
                        87, 88);

            // { "Etudiant 21", 85, 80, 84, 90, 92 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000021", "Etudiant 21", 85, 80, 84,
                        90, 92);

            // { "Etudiant 22", 80, 82, 85, 88, 90 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000022", "Etudiant 22", 80, 82, 85,
                        88, 90);

            // { "Etudiant 23", 85, 85, 80, 90, 95 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000023", "Etudiant 23", 85, 85, 80,
                        90, 95);

            // { "Etudiant 24", 80, 80, 85, 85, 90 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000024", "Etudiant 24", 80, 80, 85,
                        85, 90);

            // { "Etudiant 25", 85, 82, 80, 88, 90 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000025", "Etudiant 25", 85, 82, 80,
                        88, 90);

            // { "Etudiant 26", 80, 85, 82, 87, 88 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000026", "Etudiant 26", 80, 85, 82,
                        87, 88);

            // { "Etudiant 27", 85, 80, 84, 90, 92 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000027", "Etudiant 27", 85, 80, 84,
                        90, 92);

            // { "Etudiant 28", 80, 82, 85, 88, 90 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000028", "Etudiant 28", 80, 82, 85,
                        88, 90);

            // { "Etudiant 29", 85, 85, 80, 90, 95 },
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000029", "Etudiant 29", 85, 85, 80,
                        90, 95);

            // { "Etudiant 30", 80, 80, 85, 85, 90 }
            etudiantCoursDAO.ajouterEtudiant("7833", "INF101", "VOYH00000030", "Etudiant 30", 80, 80, 85,
                        85, 90);

            HashMap<String, EtudiantCours> etudiants = etudiantCoursDAO.obtenirListeEtudiantsCours();
            CoursDAO coursDAO = new CoursDAO(con);
            CoursPremierCycle ceCours = (CoursPremierCycle) coursDAO.obtenirCours("7833", "INF101");

            // calculons la note ponderee d'un seul etudiant
            for (String entry : etudiants.keySet()) {
                  EtudiantCours etudiant = (EtudiantCours) etudiants.get(entry);
                  double notePondereeTP1 = etudiant.getEtudiant().getTp1().getNote()
                              * etudiant.getEtudiant().getTp1().getPoids();

                  double notePondereeTP2 = etudiant.getEtudiant().getTp2().getNote()
                              * etudiant.getEtudiant().getTp2().getPoids();

                  double notePondereeTP3 = etudiant.getEtudiant().getTp3().getNote()
                              * etudiant.getEtudiant().getTp3().getPoids();

                  double notePondereeMiSession = etudiant.getEtudiant().getExamenMiSession().getNote()
                              * etudiant.getEtudiant().getExamenMiSession().getPoids();

                  double notePondereeFinSession = etudiant.getEtudiant().getExamenFinSession()
                              .getNote() * etudiant.getEtudiant().getExamenFinSession().getPoids();

                  double notePonderee = notePondereeTP1 + notePondereeTP2 + notePondereeTP3 +
                              notePondereeMiSession + notePondereeFinSession;
                  /*
                   * // * Barème de conversion typique (Échelle de 4,3)
                   * // * • 90% – 100% : A+ (4,3) – Excellent
                   * // * • 85% – 89% : A (4,0) – Excellent
                   * // * • 80% – 84% : A- (3,7) – Excellent
                   * // * • 77% – 79% : B+ (3,3) – Très bien
                   * // * • 73% – 76% : B (3,0) – Bien
                   * // * • 70% – 72% : B- (2,7) – Bien
                   * // * • 65% – 69% : C+ (2,3) – Satisfaisant
                   * // * • 60% – 64% : C (2,0) – Satisfaisant
                   * // * • 57% – 59% : C- (1,7) – Passable
                   * // * • 54% – 56% : D+ (1,3) – Passable
                   * // * • 50% – 53% : D (1,0) – Passable (note de passage au 1er cycle)
                   * // * • 0% – 49% : F (0,0) – Échec
                   * //
                   */
                  NotationLitterale notationLiteraleEnum;
                  // NotationLitterale notationLiteraleEnum;
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

                  System.out.println("La note ponderee de " + etudiant.getNom() + " est " +
                              notePonderee
                              + " et la notation literale est : " + " " + notationLiteraleEnum);
                  totalNotes += notePonderee;
            }
            double moyenne = totalNotes / etudiants.size();
            System.out.println("La moyenne des notes pour le cours " +
                        ceCours.getTitreCours() + " est " + moyenne);
      }
}