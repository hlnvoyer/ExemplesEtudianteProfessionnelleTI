package ca.editions.helene.voyer.calcul.notes;
import ca.editions.helene.voyer.calcul.notes.modele.TravailPratique;
import ca.editions.helene.voyer.calcul.notes.modele.ExamenMiSession;
import ca.editions.helene.voyer.calcul.notes.modele.ExamenFinSession;
import java.util.ArrayList;
import java.util.Iterator;

import ca.editions.helene.voyer.calcul.notes.modele.Cours;
import ca.editions.helene.voyer.calcul.notes.modele.CoursPremierCycle;
import ca.editions.helene.voyer.calcul.notes.modele.Etudiant;
import ca.editions.helene.voyer.calcul.notes.modele.EtudiantPremierCycle;

public class TravailPratiqueObjetsModele {

   public enum NotationLitterale {
      A_PLUS,
      A,
      A_MINUS,
      B_PLUS,
      B,
      B_MINUS,
      C_PLUS,
      C,
      C_MINUS,
      D_PLUS,
      D,
      E
   }

   public static void main(String args[]) {
      // TP signifie Travail Pratique
      // Examen de mi-session
      // Examen de fin de session
      // Le tableau etudiant contient le nom de l'etudiant suivi de ses notes pour les
      // 3 TPs, l'examen de mi-session t l'examen de fin de session
      // d'abord créer un programme d'études
      Cours ceCours = new CoursPremierCycle("INF101", "Techniques de programmation I", 3, 3, 0.3, 0.4, 0.3);
      ArrayList<EtudiantPremierCycle> etudiants = new ArrayList<EtudiantPremierCycle>();
      etudiants.add(new EtudiantPremierCycle("Etudiant 1", 
            new TravailPratique(75), 
            new TravailPratique(55),
            new TravailPratique(88), 
            new ExamenMiSession(79), 
            new ExamenFinSession(85)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 2", 
            new TravailPratique(65), 
            new TravailPratique(75),
            new TravailPratique(78), 
            new ExamenMiSession(74), 
            new ExamenFinSession(81)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 3", 
            new TravailPratique(85), 
            new TravailPratique(90),
            new TravailPratique(80), 
            new ExamenMiSession(70), 
            new ExamenFinSession(95)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 4", 
            new TravailPratique(90), 
            new TravailPratique(85),
            new TravailPratique(75), 
            new ExamenMiSession(80), 
            new ExamenFinSession(88)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 5", 
            new TravailPratique(70), 
            new TravailPratique(80),
            new TravailPratique(85), 
            new ExamenMiSession(75), 
            new ExamenFinSession(84)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 6", 
            new TravailPratique(95), 
            new TravailPratique(85),
            new TravailPratique(88), 
            new ExamenMiSession(80), 
            new ExamenFinSession(85)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 7", 
            new TravailPratique(80), 
            new TravailPratique(71), 
            new TravailPratique(85),
            new ExamenMiSession(90),
            new ExamenFinSession(65)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 8", 
            new TravailPratique(65),
            new TravailPratique(60), 
            new TravailPratique(67), 
            new ExamenMiSession(65), 
            new ExamenFinSession(60)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 9", 
            new TravailPratique(71), 
            new TravailPratique(75), 
            new TravailPratique(70), 
            new ExamenMiSession(70), 
            new ExamenFinSession(75)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 10", 
            new TravailPratique(50), 
            new TravailPratique(58), 
            new TravailPratique(55), 
            new ExamenMiSession(55), 
            new ExamenFinSession(58)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 11", 
            new TravailPratique(78), 
            new TravailPratique(75), 
            new TravailPratique(80), 
            new ExamenMiSession(90), 
            new ExamenFinSession(92)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 12", 
            new TravailPratique(65),
            new TravailPratique(70),
            new TravailPratique(78),
            new ExamenMiSession(75),
            new ExamenFinSession(60)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 13", 
            new TravailPratique(65),
            new TravailPratique(62),
            new TravailPratique(60),
            new ExamenMiSession(68),
            new ExamenFinSession(70)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 14", 
            new TravailPratique(80),
            new TravailPratique(85),
            new TravailPratique(82),
            new ExamenMiSession(87),
            new ExamenFinSession(88)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 15", 
            new TravailPratique(85),
            new TravailPratique(80),
            new TravailPratique(84),
            new ExamenMiSession(90),
            new ExamenFinSession(92)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 16", 
            new TravailPratique(80), 
            new TravailPratique(82),
            new TravailPratique(85),
            new ExamenMiSession(88),
            new ExamenFinSession(90)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 17",
            new TravailPratique(85),
            new TravailPratique(85),
            new TravailPratique(80),
            new ExamenMiSession(90),
            new ExamenFinSession(95)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 18",
            new TravailPratique(80),
            new TravailPratique(80),
            new TravailPratique(85),
            new ExamenMiSession(85),
            new ExamenFinSession(90)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 19",
            new TravailPratique(85),
            new TravailPratique(82),
            new TravailPratique(80),
            new ExamenMiSession(88),
            new ExamenFinSession(90)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 20",
            new TravailPratique(80),
            new TravailPratique(85),
            new TravailPratique(82),
            new ExamenMiSession(87),
            new ExamenFinSession(88)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 21", 
            new TravailPratique(85), 
            new TravailPratique(80),
            new TravailPratique(84),
            new ExamenMiSession(90), 
            new ExamenFinSession(92)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 22", 
            new TravailPratique(80),
            new TravailPratique(82),
            new TravailPratique(85),
            new ExamenMiSession(88),
            new ExamenFinSession(90)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 23", 
            new TravailPratique(85),
            new TravailPratique(85),
            new TravailPratique(80),
            new ExamenMiSession(90),
            new ExamenFinSession(95)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 24", 
            new TravailPratique(80),
            new TravailPratique(80),
            new TravailPratique(85),
            new ExamenMiSession(85),
            new ExamenFinSession(90)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 25", 
            new TravailPratique(85),
            new TravailPratique(82),
            new TravailPratique(80),
            new ExamenMiSession(88),
            new ExamenFinSession(90)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 26", 
            new TravailPratique(80),
            new TravailPratique(85),
            new TravailPratique(82), 
            new ExamenMiSession(87),
            new ExamenFinSession(88)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 27", 
            new TravailPratique(85),
            new TravailPratique(80),
            new TravailPratique(84),
            new ExamenMiSession(90),
            new ExamenFinSession(92)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 28",
            new TravailPratique(80),
            new TravailPratique(82),
            new TravailPratique(85),
            new ExamenMiSession(88),
            new ExamenFinSession(90)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 29",
            new TravailPratique(85),
            new TravailPratique(85),
            new TravailPratique(80),
            new ExamenMiSession(90),
            new ExamenFinSession(95)));
      etudiants.add(new EtudiantPremierCycle("Etudiant 30", 
            new TravailPratique(80),
            new TravailPratique(80),
            new TravailPratique(85),
            new ExamenMiSession(85),
            new ExamenFinSession(90)));
      double totalNotes = 0;
      Iterator<EtudiantPremierCycle> iterator = (Iterator<EtudiantPremierCycle>) etudiants.iterator();
      // calculons la note ponderee d'un seul etudiant
      while (iterator.hasNext()) {
         Etudiant etudiant = (EtudiantPremierCycle) iterator.next();
         double notePondereeTP1 = ((EtudiantPremierCycle) etudiant).getTp1().getNote() * 0.1;
         double notePondereeTP2 = ((EtudiantPremierCycle) etudiant).getTp2().getNote() * 0.1;
         double notePondereeTP3 = ((EtudiantPremierCycle) etudiant).getTp3().getNote() * 0.1;
         double notePondereeMiSession = ((EtudiantPremierCycle) etudiant).getExamenMiSession().getNote() * 0.3;
         double notePondereeFinSession = ((EtudiantPremierCycle) etudiant).getExamenFinSession().getNote() * 0.4;
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