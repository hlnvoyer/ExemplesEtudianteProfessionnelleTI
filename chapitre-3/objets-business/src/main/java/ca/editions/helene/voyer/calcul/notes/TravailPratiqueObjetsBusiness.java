package ca.editions.helene.voyer.calcul.notes;

import java.util.HashMap;

import ca.editions.helene.voyer.calcul.notes.business.Admission;
import ca.editions.helene.voyer.calcul.notes.business.Inscription;
import ca.editions.helene.voyer.calcul.notes.business.GestionProgrammeEtudes;

import ca.editions.helene.voyer.calcul.notes.modele.CoursPremierCycle;
import ca.editions.helene.voyer.calcul.notes.modele.Etudiant;
import ca.editions.helene.voyer.calcul.notes.modele.EtudiantCours;
import ca.editions.helene.voyer.calcul.notes.modele.TravailPratique;
import ca.editions.helene.voyer.calcul.notes.modele.ExamenMiSession;
import ca.editions.helene.voyer.calcul.notes.modele.ProgrammeEtudesPremierCycle;
import ca.editions.helene.voyer.calcul.notes.modele.ExamenFinSession;

public class TravailPratiqueObjetsBusiness {

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
            HashMap<String, CoursPremierCycle> obligatoires = baccInformatique.getCoursObligatoires();
            // on veut le cours Techniques de programmation I du programme 7833
            CoursPremierCycle ceCours = obligatoires.get("INF101");
            // obtenir la liste des étudiants du cours Techniques de programmation I
            HashMap<String, EtudiantCours> etudiants = new HashMap<String, EtudiantCours>();
            initialiserEtudiants(etudiants);
            double totalNotes = 0;
            // calculons la note ponderee d'un seul etudiant
            for (EtudiantCours etudiant : etudiants.values()) {
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
            double moyenne = totalNotes / etudiants.size();
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

      public static void initialiserEtudiants(HashMap<String, EtudiantCours> etudiants) {
            Admission admission = Admission.getInstance();
            // admettre chaque étudiant
            EtudiantCours etudiant1 = new EtudiantCours("VOYH00000001", "Etudiant 1", "7833", "INF101");
            admission.admettre("7833", etudiant1);
            EtudiantCours etudiant2 = new EtudiantCours("VOYH00000002", "Etudiant 2", "7833", "INF101");
            admission.admettre("7833", etudiant2);
            EtudiantCours etudiant3 = new EtudiantCours("VOYH00000003", "Etudiant 3", "7833", "INF101");
            admission.admettre("7833", etudiant3);
            EtudiantCours etudiant4 = new EtudiantCours("VOYH00000004", "Etudiant 4", "7833", "INF101");
            admission.admettre("7833", etudiant4);
            EtudiantCours etudiant5 = new EtudiantCours("VOYH00000005", "Etudiant 5", "7833", "INF101");
            admission.admettre("7833", etudiant5);
            EtudiantCours etudiant6 = new EtudiantCours("VOYH00000006", "Etudiant 6", "7833", "INF101");
            admission.admettre("7833", etudiant6);
            EtudiantCours etudiant7 = new EtudiantCours("VOYH00000007", "Etudiant 7", "7833", "INF101");
            admission.admettre("7833", etudiant7);
            EtudiantCours etudiant8 = new EtudiantCours("VOYH00000008", "Etudiant 8", "7833", "INF101");
            admission.admettre("7833", etudiant8);
            EtudiantCours etudiant9 = new EtudiantCours("VOYH00000009", "Etudiant 9", "7833", "INF101");
            admission.admettre("7833", etudiant9);
            EtudiantCours etudiant10 = new EtudiantCours("VOYH00000010", "Etudiant 10", "7833", "INF101");
            admission.admettre("7833", etudiant10);
            EtudiantCours etudiant11 = new EtudiantCours("VOYH00000011", "Etudiant 11", "7833", "INF101");
            admission.admettre("7833", etudiant11);
            EtudiantCours etudiant12 = new EtudiantCours("VOYH00000012", "Etudiant 12", "7833", "INF101");
            admission.admettre("7833", etudiant12);
            EtudiantCours etudiant13 = new EtudiantCours("VOYH00000013", "Etudiant 13", "7833", "INF101");
            admission.admettre("7833", etudiant13);
            EtudiantCours etudiant14 = new EtudiantCours("VOYH00000014", "Etudiant 14", "7833", "INF101");
            admission.admettre("7833", etudiant14);
            EtudiantCours etudiant15 = new EtudiantCours("VOYH00000015", "Etudiant 15", "7833", "INF101");
            admission.admettre("7833", etudiant15);
            EtudiantCours etudiant16 = new EtudiantCours("VOYH00000016", "Etudiant 16", "7833", "INF101");
            admission.admettre("7833", etudiant16);
            EtudiantCours etudiant17 = new EtudiantCours("VOYH00000017", "Etudiant 17", "7833", "INF101");
            admission.admettre("7833", etudiant17);
            EtudiantCours etudiant18 = new EtudiantCours("VOYH00000018", "Etudiant 18", "7833", "INF101");
            admission.admettre("7833", etudiant18);
            EtudiantCours etudiant19 = new EtudiantCours("VOYH00000019", "Etudiant 19", "7833", "INF101");
            admission.admettre("7833", etudiant19);
            EtudiantCours etudiant20 = new EtudiantCours("VOYH00000020", "Etudiant 20", "7833", "INF101");
            admission.admettre("7833", etudiant20);
            EtudiantCours etudiant21 = new EtudiantCours("VOYH00000021", "Etudiant 21", "7833", "INF101");
            admission.admettre("7833", etudiant21);
            EtudiantCours etudiant22 = new EtudiantCours("VOYH00000022", "Etudiant 22", "7833", "INF101");
            admission.admettre("7833", etudiant22);
            EtudiantCours etudiant23 = new EtudiantCours("VOYH00000023", "Etudiant 23", "7833", "INF101");
            admission.admettre("7833", etudiant23);
            EtudiantCours etudiant24 = new EtudiantCours("VOYH00000024", "Etudiant 24", "7833", "INF101");
            admission.admettre("7833", etudiant24);
            EtudiantCours etudiant25 = new EtudiantCours("VOYH00000025", "Etudiant 25", "7833", "INF101");
            admission.admettre("7833", etudiant25);
            EtudiantCours etudiant26 = new EtudiantCours("VOYH00000026", "Etudiant 26", "7833", "INF101");
            admission.admettre("7833", etudiant26);
            EtudiantCours etudiant27 = new EtudiantCours("VOYH00000027", "Etudiant 27", "7833", "INF101");
            admission.admettre("7833", etudiant27);
            EtudiantCours etudiant28 = new EtudiantCours("VOYH00000028", "Etudiant 28", "7833", "INF101");
            admission.admettre("7833", etudiant28);
            EtudiantCours etudiant29 = new EtudiantCours("VOYH00000029", "Etudiant 29", "7833", "INF101");
            admission.admettre("7833", etudiant29);
            EtudiantCours etudiant30 = new EtudiantCours("VOYH00000030", "Etudiant 30", "7833", "INF101");
            admission.admettre("7833", etudiant30);

            // inscrire chaque étudiant
            Inscription inscription = Inscription.getInstance();
            inscription.inscrire("7833", "INF101", etudiant1);
            // ajouter les notes de l'étudiant pour le cours
            etudiant1.setEtudiant(new Etudiant("Etudiant 1",
                        new TravailPratique(75, 0.1),
                        new TravailPratique(55, 0.1),
                        new TravailPratique(88, 0.1),
                        new ExamenMiSession(79, 0.3),
                        new ExamenFinSession(85, 0.4)));
            etudiants.put("Etudiant 1", etudiant1);

            inscription.inscrire("7833", "INF101", etudiant2);
            etudiant2.setEtudiant(new Etudiant("Etudiant 2",
                        new TravailPratique(65, 0.1),
                        new TravailPratique(75, 0.1),
                        new TravailPratique(78, 0.1),
                        new ExamenMiSession(74, 0.3),
                        new ExamenFinSession(81, 0.4)));
            etudiants.put("Etudiant 2", etudiant2);

            inscription.inscrire("7833", "INF101", etudiant3);
            etudiant3.setEtudiant(new Etudiant(
                        "Etudiant 3",
                        new TravailPratique(85, 0.1),
                        new TravailPratique(90, 0.1),
                        new TravailPratique(80, 0.1),
                        new ExamenMiSession(70, 0.3),
                        new ExamenFinSession(95, 0.4)));
            etudiants.put("Etudiant 3", etudiant3);

            inscription.inscrire("7833", "INF101", etudiant4);
            etudiant4.setEtudiant(new Etudiant("Etudiant 4",
                        new TravailPratique(90, 0.1),
                        new TravailPratique(85, 0.1),
                        new TravailPratique(75, 0.1),
                        new ExamenMiSession(80, 0.3),
                        new ExamenFinSession(88, 0.4)));
            etudiants.put("Etudiant 4", etudiant4);

            inscription.inscrire("7833", "INF101", etudiant5);
            etudiant5.setEtudiant(new Etudiant("Etudiant 5",
                        new TravailPratique(70, 0.1),
                        new TravailPratique(80, 0.1),
                        new TravailPratique(85, 0.1),
                        new ExamenMiSession(75, 0.3),
                        new ExamenFinSession(84, 0.4)));
            etudiants.put("Etudiant 5", etudiant5);

            inscription.inscrire("7833", "INF101", etudiant6);
            etudiant6.setEtudiant(new Etudiant("Etudiant 6",
                        new TravailPratique(95, 0.1),
                        new TravailPratique(85, 0.1),
                        new TravailPratique(88, 0.1),
                        new ExamenMiSession(80, 0.3),
                        new ExamenFinSession(85, 0.4)));
            etudiants.put("Etudiant 6", etudiant6);

            inscription.inscrire("7833", "INF101", etudiant7);
            etudiant7.setEtudiant(new Etudiant("Etudiant 7",
                        new TravailPratique(80, 0.1),
                        new TravailPratique(71, 0.1),
                        new TravailPratique(85, 0.1),
                        new ExamenMiSession(90, 0.3),
                        new ExamenFinSession(65, 0.4)));
            etudiants.put("Etudiant 7", etudiant7);

            inscription.inscrire("7833", "INF101", etudiant8);
            etudiant8.setEtudiant(new Etudiant("Etudiant 8",
                        new TravailPratique(65, 0.1),
                        new TravailPratique(60, 0.1),
                        new TravailPratique(67, 0.1),
                        new ExamenMiSession(65, 0.3),
                        new ExamenFinSession(60, 0.4)));
            etudiants.put("Etudiant 8", etudiant8);

            inscription.inscrire("7833", "INF101", etudiant9);
            etudiant9.setEtudiant(new Etudiant("Etudiant 9",
                        new TravailPratique(71, 0.1),
                        new TravailPratique(75, 0.1),
                        new TravailPratique(70, 0.1),
                        new ExamenMiSession(70, 0.3),
                        new ExamenFinSession(75, 0.4)));
            etudiants.put("Etudiant 9", etudiant9);

            inscription.inscrire("7833", "INF101", etudiant10);
            etudiant10.setEtudiant(new Etudiant("Etudiant 10",
                        new TravailPratique(50, 0.1),
                        new TravailPratique(58, 0.1),
                        new TravailPratique(55, 0.1),
                        new ExamenMiSession(55, 0.3),
                        new ExamenFinSession(58, 0.4)));
            etudiants.put("Etudiant 10", etudiant10);

            inscription.inscrire("7833", "INF101", etudiant11);
            etudiant11.setEtudiant(new Etudiant("Etudiant 11",
                        new TravailPratique(78, 0.1),
                        new TravailPratique(75, 0.1),
                        new TravailPratique(80, 0.1),
                        new ExamenMiSession(90, 0.3),
                        new ExamenFinSession(92, 0.4)));
            etudiants.put("Etudiant 11", etudiant11);

            inscription.inscrire("7833", "INF101", etudiant12);
            etudiant12.setEtudiant(new Etudiant("Etudiant 12",
                        new TravailPratique(65, 0.1),
                        new TravailPratique(70, 0.1),
                        new TravailPratique(78, 0.1),
                        new ExamenMiSession(75, 0.3),
                        new ExamenFinSession(60, 0.4)));
            etudiants.put("Etudiant 12", etudiant12);

            inscription.inscrire("7833", "INF101", etudiant13);
            etudiant13.setEtudiant(new Etudiant("Etudiant 13",
                        new TravailPratique(65, 0.1),
                        new TravailPratique(62, 0.1),
                        new TravailPratique(60, 0.1),
                        new ExamenMiSession(68, 0.3),
                        new ExamenFinSession(70, 0.4)));
            etudiants.put("Etudiant 13", etudiant13);

            inscription.inscrire("7833", "INF101", etudiant14);
            etudiant14.setEtudiant(new Etudiant("Etudiant 14",
                        new TravailPratique(80, 0.1),
                        new TravailPratique(85, 0.1),
                        new TravailPratique(82, 0.1),
                        new ExamenMiSession(87, 0.3),
                        new ExamenFinSession(88, 0.4)));
            etudiants.put("Etudiant 14", etudiant14);

            inscription.inscrire("7833", "INF101", etudiant15);
            etudiant15.setEtudiant(new Etudiant("Etudiant 15",
                        new TravailPratique(85, 0.1),
                        new TravailPratique(80, 0.1),
                        new TravailPratique(84, 0.1),
                        new ExamenMiSession(90, 0.3),
                        new ExamenFinSession(92, 0.4)));
            etudiants.put("Etudiant 15", etudiant15);

            inscription.inscrire("7833", "INF101", etudiant16);
            etudiant16.setEtudiant(new Etudiant("Etudiant 16",
                        new TravailPratique(80, 0.1),
                        new TravailPratique(82, 0.1),
                        new TravailPratique(85, 0.1),
                        new ExamenMiSession(88, 0.3),
                        new ExamenFinSession(90, 0.4)));
            etudiants.put("Etudiant 16", etudiant16);

            inscription.inscrire("7833", "INF101", etudiant17);
            etudiant17.setEtudiant(new Etudiant("Etudiant 17",
                        new TravailPratique(85, 0.1),
                        new TravailPratique(85, 0.1),
                        new TravailPratique(80, 0.1),
                        new ExamenMiSession(90, 0.3),
                        new ExamenFinSession(95, 0.4)));
            etudiants.put("Etudiant 17", etudiant17);

            inscription.inscrire("7833", "INF101", etudiant18);
            etudiant18.setEtudiant(new Etudiant("Etudiant 18",
                        new TravailPratique(80, 0.1),
                        new TravailPratique(80, 0.1),
                        new TravailPratique(85, 0.1),
                        new ExamenMiSession(85, 0.3),
                        new ExamenFinSession(90, 0.4)));
            etudiants.put("Etudiant 18", etudiant18);

            inscription.inscrire("7833", "INF101", etudiant19);
            etudiant19.setEtudiant(new Etudiant("Etudiant 19",
                        new TravailPratique(85, 0.1),
                        new TravailPratique(82, 0.1),
                        new TravailPratique(80, 0.1),
                        new ExamenMiSession(88, 0.3),
                        new ExamenFinSession(90, 0.4)));
            etudiants.put("Etudiant 19", etudiant19);

            inscription.inscrire("7833", "INF101", etudiant20);
            etudiant20.setEtudiant(new Etudiant("Etudiant 20",
                        new TravailPratique(80, 0.1),
                        new TravailPratique(85, 0.1),
                        new TravailPratique(82, 0.1),
                        new ExamenMiSession(87, 0.3),
                        new ExamenFinSession(88, 0.4)));
            etudiants.put("Etudiant 20", etudiant20);

            inscription.inscrire("7833", "INF101", etudiant21);
            etudiant21.setEtudiant(new Etudiant("Etudiant 21",
                        new TravailPratique(85, 0.1),
                        new TravailPratique(80, 0.1),
                        new TravailPratique(84, 0.1),
                        new ExamenMiSession(90, 0.3),
                        new ExamenFinSession(92, 0.4)));
            etudiants.put("Etudiant 21", etudiant21);

            inscription.inscrire("7833", "INF101", etudiant22);
            etudiant22.setEtudiant(new Etudiant("Etudiant 22",
                        new TravailPratique(80, 0.1),
                        new TravailPratique(82, 0.1),
                        new TravailPratique(85, 0.1),
                        new ExamenMiSession(88, 0.3),
                        new ExamenFinSession(90, 0.4)));
            etudiants.put("Etudiant 22", etudiant22);

            inscription.inscrire("7833", "INF101", etudiant23);
            etudiant23.setEtudiant(new Etudiant("Etudiant 23",
                        new TravailPratique(85, 0.1),
                        new TravailPratique(85, 0.1),
                        new TravailPratique(80, 0.1),
                        new ExamenMiSession(90, 0.3),
                        new ExamenFinSession(95, 0.4)));
            etudiants.put("Etudiant 23", etudiant23);

            inscription.inscrire("7833", "INF101", etudiant24);
            etudiant24.setEtudiant(new Etudiant("Etudiant 24",
                        new TravailPratique(80, 0.1),
                        new TravailPratique(80, 0.1),
                        new TravailPratique(85, 0.1),
                        new ExamenMiSession(85, 0.3),
                        new ExamenFinSession(90, 0.4)));
            etudiants.put("Etudiant 24", etudiant24);

            inscription.inscrire("7833", "INF101", etudiant25);
            etudiant25.setEtudiant(new Etudiant("Etudiant 25",
                        new TravailPratique(85, 0.1),
                        new TravailPratique(82, 0.1),
                        new TravailPratique(80, 0.1),
                        new ExamenMiSession(88, 0.3),
                        new ExamenFinSession(90, 0.4)));
            etudiants.put("Etudiant 25", etudiant25);

            inscription.inscrire("7833", "INF101", etudiant26);
            etudiant26.setEtudiant(new Etudiant("Etudiant 26",
                        new TravailPratique(80, 0.1),
                        new TravailPratique(85, 0.1),
                        new TravailPratique(82, 0.1),
                        new ExamenMiSession(87, 0.3),
                        new ExamenFinSession(88, 0.4)));
            etudiants.put("Etudiant 26", etudiant26);

            inscription.inscrire("7833", "INF101", etudiant27);
            etudiant27.setEtudiant(new Etudiant("Etudiant 27",
                        new TravailPratique(85, 0.1),
                        new TravailPratique(80, 0.1),
                        new TravailPratique(84, 0.1),
                        new ExamenMiSession(90, 0.3),
                        new ExamenFinSession(92, 0.4)));
            etudiants.put("Etudiant 27", etudiant27);

            inscription.inscrire("7833", "INF101", etudiant28);
            etudiant28.setEtudiant(new Etudiant("Etudiant 28",
                        new TravailPratique(80, 0.1),
                        new TravailPratique(82, 0.1),
                        new TravailPratique(85, 0.1),
                        new ExamenMiSession(88, 0.3),
                        new ExamenFinSession(90, 0.4)));
            etudiants.put("Etudiant 28", etudiant28);

            inscription.inscrire("7833", "INF101", etudiant29);
            etudiant29.setEtudiant(new Etudiant("Etudiant 29",
                        new TravailPratique(85, 0.1),
                        new TravailPratique(85, 0.1),
                        new TravailPratique(80, 0.1),
                        new ExamenMiSession(90, 0.3),
                        new ExamenFinSession(95, 0.4)));
            etudiants.put("Etudiant 29", etudiant29);

            inscription.inscrire("7833", "INF101", etudiant30);
            etudiant30.setEtudiant(new Etudiant("Etudiant 30",
                        new TravailPratique(80, 0.1),
                        new TravailPratique(80, 0.1),
                        new TravailPratique(85, 0.1),
                        new ExamenMiSession(85, 0.3),
                        new ExamenFinSession(90, 0.4)));
            etudiants.put("Etudiant 30", etudiant30);
      }
}