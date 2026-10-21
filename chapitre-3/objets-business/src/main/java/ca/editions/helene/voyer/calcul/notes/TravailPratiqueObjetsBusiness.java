package ca.editions.helene.voyer.calcul.notes;

import java.util.Iterator;
import java.util.ArrayList;

import ca.editions.helene.voyer.calcul.notes.business.GestionProgrammeEtudes;

import ca.editions.helene.voyer.calcul.notes.modele.Cours;
import ca.editions.helene.voyer.calcul.notes.modele.CoursPremierCycle;
import ca.editions.helene.voyer.calcul.notes.modele.Etudiant;
import ca.editions.helene.voyer.calcul.notes.modele.TravailPratique;
import ca.editions.helene.voyer.calcul.notes.modele.ExamenMiSession;
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
            // FabriqueListeChaineeEtudiant crée une liste chaînée d'étudiants à partir des
            // données fournies
            // Création d'un programme et d'une liste d'étudiants admis à ce programme
            GestionProgrammeEtudes gestionProgramme = GestionProgrammeEtudes.getInstance();
            Cours ceCours = null;
            ArrayList<Cours> prerequis = new ArrayList<Cours> ();
            ArrayList<Cours> coursObligatoires = new ArrayList<Cours>();
            ArrayList<Cours> coursOptionnels = new ArrayList<Cours>();
            ArrayList<Cours> coursLibres = new ArrayList<Cours> ();
            
            Cours mathématiques = new CoursPremierCycle("MAT101", "Mathématiques", 3);
            prerequis.add(mathématiques);

            Cours techniquesProgrammationUn = new CoursPremierCycle("INF101", "Techniques de programmation I", 3);      
            coursObligatoires.add(techniquesProgrammationUn);
            Cours techniquesProgrammationDeux = new CoursPremierCycle("INF102", "Techniques de programmation II", 3);      
            coursObligatoires.add(techniquesProgrammationDeux);
            Cours techniquesProgrammationTrois = new CoursPremierCycle("INF103", "Techniques de programmation III", 3);   
            coursObligatoires.add(techniquesProgrammationTrois);
            Cours structuresDeDonnees = new CoursPremierCycle("INF201", "Structures de données", 3);  
            coursObligatoires.add(structuresDeDonnees);
            Cours algorithmique = new CoursPremierCycle("INF202", "Algorithmique", 3);  
            coursObligatoires.add(algorithmique);

            Cours gestionResourceInformation = new CoursPremierCycle("INF301", "Gestion des ressources informationnelles", 3);
            coursOptionnels.add(gestionResourceInformation);

            Cours espagnol = new CoursPremierCycle("ESP101", "Espagnol", 3);
            coursLibres.add(espagnol);

            gestionProgramme.ajouterProgramme("7833", "Baccalauréat en sciences appliquées (Informatique)", 
                  "Informatique", GestionProgrammeEtudes.CycleEnum.PREMIER_CYCLE, 
                  prerequis, coursObligatoires, coursOptionnels, coursLibres);           

            // on a un programme avec des cours
            ArrayList<Cours> obligatoires = GestionProgrammeEtudes.getInstance().getCoursObligatoires("7833");
            Cours valeurRetournee = null;
            // on veut le cours Techniques de programmation I
            Iterator<Cours> iteratorCours = obligatoires.iterator();
            while (iteratorCours.hasNext()) {
                Cours cours = iteratorCours.next();
                if(cours.getCodeCours().equals("INF101")) {
                    valeurRetournee = cours;
                }
                if(valeurRetournee != null) {
                    break;
                }
            }
            if(valeurRetournee != null) {
               ceCours = valeurRetournee;

            }                  
            ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
            etudiants.add(new Etudiant("Etudiant 1", 
                  new TravailPratique(75, 0.1), 
                  new TravailPratique(55, 0.1),
                  new TravailPratique(88, 0.1), 
                  new ExamenMiSession(79, 0.3), 
                  new ExamenFinSession(85, 0.4)));
            etudiants.add(new Etudiant("Etudiant 2", 
                  new TravailPratique(65, 0.1), 
                  new TravailPratique(75, 0.1),
                  new TravailPratique(78, 0.1), 
                  new ExamenMiSession(74, 0.3), 
                  new ExamenFinSession(81, 0.4)));
            etudiants.add(new Etudiant("Etudiant 3", 
                  new TravailPratique(85, 0.1), 
                  new TravailPratique(90, 0.1),
                  new TravailPratique(80, 0.1), 
                  new ExamenMiSession(70, 0.3), 
                  new ExamenFinSession(95, 0.4)));
            etudiants.add(new Etudiant("Etudiant 4", 
                  new TravailPratique(90, 0.1), 
                  new TravailPratique(85, 0.1),
                  new TravailPratique(75, 0.1), 
                  new ExamenMiSession(80, 0.3), 
                  new ExamenFinSession(88, 0.4)));
            etudiants.add(new Etudiant("Etudiant 5", 
                  new TravailPratique(70, 0.1), 
                  new TravailPratique(80, 0.1),
                  new TravailPratique(85, 0.1), 
                  new ExamenMiSession(75, 0.3), 
                  new ExamenFinSession(84, 0.4)));
            etudiants.add(new Etudiant("Etudiant 6", 
                  new TravailPratique(95, 0.1), 
                  new TravailPratique(85, 0.1),
                  new TravailPratique(88, 0.1), 
                  new ExamenMiSession(80, 0.3), 
                  new ExamenFinSession(85, 0.4)));
            etudiants.add(new Etudiant("Etudiant 7", 
                  new TravailPratique(80, 0.1), 
                  new TravailPratique(71, 0.1), 
                  new TravailPratique(85, 0.1),
                  new ExamenMiSession(90, 0.3),
                  new ExamenFinSession(65, 0.4)));
            etudiants.add(new Etudiant("Etudiant 8", 
                  new TravailPratique(65, 0.1),
                  new TravailPratique(60, 0.1), 
                  new TravailPratique(67, 0.1), 
                  new ExamenMiSession(65, 0.3), 
                  new ExamenFinSession(60, 0.4)));
            etudiants.add(new Etudiant("Etudiant 9", 
                  new TravailPratique(71, 0.1), 
                  new TravailPratique(75, 0.1), 
                  new TravailPratique(70, 0.1), 
                  new ExamenMiSession(70, 0.3), 
                  new ExamenFinSession(75, 0.4)));
            etudiants.add(new Etudiant("Etudiant 10", 
                  new TravailPratique(50, 0.1), 
                  new TravailPratique(58, 0.1), 
                  new TravailPratique(55, 0.1), 
                  new ExamenMiSession(55, 0.3), 
                  new ExamenFinSession(58, 0.4)));
            etudiants.add(new Etudiant("Etudiant 11", 
                  new TravailPratique(78, 0.1), 
                  new TravailPratique(75, 0.1), 
                  new TravailPratique(80, 0.1), 
                  new ExamenMiSession(90, 0.3), 
                  new ExamenFinSession(92, 0.4)));
            etudiants.add(new Etudiant("Etudiant 12", 
                  new TravailPratique(65, 0.1),
                  new TravailPratique(70, 0.1),
                  new TravailPratique(78, 0.1),
                  new ExamenMiSession(75, 0.3),
                  new ExamenFinSession(60, 0.4)));
            etudiants.add(new Etudiant("Etudiant 13", 
                  new TravailPratique(65, 0.1),
                  new TravailPratique(62, 0.1),
                  new TravailPratique(60, 0.1),
                  new ExamenMiSession(68, 0.3),
                  new ExamenFinSession(70, 0.4)));
            etudiants.add(new Etudiant("Etudiant 14", 
                  new TravailPratique(80, 0.1),
                  new TravailPratique(85, 0.1),
                  new TravailPratique(82, 0.1),
                  new ExamenMiSession(87, 0.3),
                  new ExamenFinSession(88, 0.4)));
            etudiants.add(new Etudiant("Etudiant 15", 
                  new TravailPratique(85, 0.1),
                  new TravailPratique(80, 0.1),
                  new TravailPratique(84, 0.1),
                  new ExamenMiSession(90, 0.3),
                  new ExamenFinSession(92, 0.4)));
            etudiants.add(new Etudiant("Etudiant 16", 
                  new TravailPratique(80, 0.1), 
                  new TravailPratique(82, 0.1),
                  new TravailPratique(85, 0.1),
                  new ExamenMiSession(88, 0.3),
                  new ExamenFinSession(90, 0.4)));
            etudiants.add(new Etudiant("Etudiant 17",
                  new TravailPratique(85, 0.1),
                  new TravailPratique(85, 0.1),
                  new TravailPratique(80, 0.1),
                  new ExamenMiSession(90, 0.3),
                  new ExamenFinSession(95, 0.4)));
            etudiants.add(new Etudiant("Etudiant 18",
                  new TravailPratique(80, 0.1),
                  new TravailPratique(80, 0.1),
                  new TravailPratique(85, 0.1),
                  new ExamenMiSession(85, 0.3),
                  new ExamenFinSession(90, 0.4)));
            etudiants.add(new Etudiant("Etudiant 19",
                  new TravailPratique(85, 0.1),
                  new TravailPratique(82, 0.1),
                  new TravailPratique(80, 0.1),
                  new ExamenMiSession(88, 0.3),
                  new ExamenFinSession(90, 0.4)));
            etudiants.add(new Etudiant("Etudiant 20",
                  new TravailPratique(80, 0.1),
                  new TravailPratique(85, 0.1),
                  new TravailPratique(82, 0.1),
                  new ExamenMiSession(87, 0.3),
                  new ExamenFinSession(88, 0.4)));
            etudiants.add(new Etudiant("Etudiant 21", 
                  new TravailPratique(85, 0.1), 
                  new TravailPratique(80, 0.1),
                  new TravailPratique(84, 0.1),
                  new ExamenMiSession(90, 0.3), 
                  new ExamenFinSession(92, 0.4)));
            etudiants.add(new Etudiant("Etudiant 22", 
                  new TravailPratique(80, 0.1),
                  new TravailPratique(82, 0.1),
                  new TravailPratique(85, 0.1),
                  new ExamenMiSession(88, 0.3),
                  new ExamenFinSession(90, 0.4)));
            etudiants.add(new Etudiant("Etudiant 23", 
                  new TravailPratique(85, 0.1),
                  new TravailPratique(85, 0.1),
                  new TravailPratique(80, 0.1),
                  new ExamenMiSession(90, 0.3),
                  new ExamenFinSession(95, 0.4)));
            etudiants.add(new Etudiant("Etudiant 24", 
                  new TravailPratique(80, 0.1),
                  new TravailPratique(80, 0.1),
                  new TravailPratique(85, 0.1),
                  new ExamenMiSession(85, 0.3),
                  new ExamenFinSession(90, 0.4)));
            etudiants.add(new Etudiant("Etudiant 25", 
                  new TravailPratique(85, 0.1),
                  new TravailPratique(82, 0.1),
                  new TravailPratique(80, 0.1),
                  new ExamenMiSession(88, 0.3),
                  new ExamenFinSession(90, 0.4)));
            etudiants.add(new Etudiant("Etudiant 26", 
                  new TravailPratique(80, 0.1),
                  new TravailPratique(85, 0.1),
                  new TravailPratique(82, 0.1), 
                  new ExamenMiSession(87, 0.3),
                  new ExamenFinSession(88, 0.4)));
            etudiants.add(new Etudiant("Etudiant 27", 
                  new TravailPratique(85, 0.1),
                  new TravailPratique(80, 0.1),
                  new TravailPratique(84, 0.1),
                  new ExamenMiSession(90, 0.3),
                  new ExamenFinSession(92, 0.4)));
            etudiants.add(new Etudiant("Etudiant 28",
                  new TravailPratique(80, 0.1),
                  new TravailPratique(82, 0.1),
                  new TravailPratique(85, 0.1),
                  new ExamenMiSession(88, 0.3),
                  new ExamenFinSession(90, 0.4)));
            etudiants.add(new Etudiant("Etudiant 29",
                  new TravailPratique(85, 0.1),
                  new TravailPratique(85, 0.1),
                  new TravailPratique(80, 0.1),
                  new ExamenMiSession(90, 0.3),
                  new ExamenFinSession(95, 0.4)));
            etudiants.add(new Etudiant("Etudiant 30", 
                  new TravailPratique(80, 0.1),
                  new TravailPratique(80, 0.1),
                  new TravailPratique(85, 0.1),
                  new ExamenMiSession(85, 0.3),
                  new ExamenFinSession(90, 0.4)));
            double totalNotes = 0;
            Iterator<Etudiant> iterator = (Iterator<Etudiant>) etudiants.iterator();
            // calculons la note ponderee d'un seul etudiant
            while (iterator.hasNext()) {
            Etudiant etudiant = (Etudiant) iterator.next();
            double notePondereeTP1 = ((Etudiant) etudiant).getTp1().getNote() * ((Etudiant) etudiant).getTp1().getPoids();
            double notePondereeTP2 = ((Etudiant) etudiant).getTp2().getNote() * ((Etudiant) etudiant).getTp2().getPoids();
            double notePondereeTP3 = ((Etudiant) etudiant).getTp3().getNote() * ((Etudiant) etudiant).getTp3().getPoids();
            double notePondereeMiSession = ((Etudiant) etudiant).getExamenMiSession().getNote() * ((Etudiant) etudiant).getExamenMiSession().getPoids();
            double notePondereeFinSession = ((Etudiant) etudiant).getExamenFinSession().getNote() * ((Etudiant) etudiant).getExamenFinSession().getPoids ();
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
}