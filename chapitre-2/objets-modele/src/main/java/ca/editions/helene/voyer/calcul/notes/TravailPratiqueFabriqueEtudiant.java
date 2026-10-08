package ca.editions.helene.voyer.calcul.notes;

public class TravailPratiqueFabriqueEtudiant {

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
      Object[][] etudiants = new Object[][] { { "Etudiant 1 ", 75, 55, 88, 79, 85 },
            { "Etudiant 2 ", 65, 75, 78, 74, 81 },
            { "Etudiant 3 ", 85, 90, 80, 70, 95 },
            { "Etudiant 4 ", 90, 85, 75, 80, 88 },
            { "Etudiant 5 ", 70, 80, 85, 75, 90 },
            { "Etudiant 6 ", 95, 85, 88, 80, 85 },
            { "Etudiant 7 ", 80, 71, 85, 90, 95 },
            { "Etudiant 8 ", 85, 80, 87, 85, 80 },
            { "Etudiant 9 ", 71, 85, 80, 90, 95 },
            { "Etudiant 10 ", 80, 78, 85, 75, 88 },
            { "Etudiant 11 ", 78, 75, 80, 90, 92 },
            { "Etudiant 12 ", 90, 80, 78, 85, 90 },
            { "Etudiant 13 ", 85, 82, 80, 88, 90 },
            { "Etudiant 14 ", 80, 85, 82, 87, 88 },
            { "Etudiant 15 ", 85, 80, 84, 90, 92 },
            { "Etudiant 16 ", 80, 82, 85, 88, 90 },
            { "Etudiant 17 ", 85, 85, 80, 90, 95 },
            { "Etudiant 18 ", 80, 80, 85, 85, 90 },
            { "Etudiant 19 ", 85, 82, 80, 88, 90 },
            { "Etudiant 20 ", 80, 85, 82, 87, 88 },
            { "Etudiant 21 ", 85, 80, 84, 90, 92 },
            { "Etudiant 22 ", 80, 82, 85, 88, 90 },
            { "Etudiant 23 ", 85, 85, 80, 90, 95 },
            { "Etudiant 24 ", 80, 80, 85, 85, 90 },
            { "Etudiant 25 ", 85, 82, 80, 88, 90 },
            { "Etudiant 26 ", 80, 85, 82, 87, 88 },
            { "Etudiant 27 ", 85, 80, 84, 90, 92 },
            { "Etudiant 28 ", 80, 82, 85, 88, 90 },
            { "Etudiant 29 ", 85, 85, 80, 90, 95 },
            { "Etudiant 30 ", 80, 80, 85, 85, 90 }
      };
      double totalNotes = 0;
      // calculons la note ponderee d'un seul etudiant
      for (int i = 0; i < etudiants.length; i++) {
         double notePondereeTP1 = (int) etudiants[i][1] * 0.1;
         double notePondereeTP2 = (int) etudiants[i][2] * 0.1;
         double notePondereeTP3 = (int) etudiants[i][3] * 0.1;
         double notePondereeMiSession = (int) etudiants[i][4] * 0.3;
         double notePondereeFinSession = (int) etudiants[i][5] * 0.4;
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
         String notationLiterale = "";
         NotationLitterale notationLiteraleEnum;
         if (notePonderee >= 90) { // Excellent A+
            notationLiterale = "A+";
            notationLiteraleEnum = NotationLitterale.A_PLUS;
         } else if (notePonderee >= 85 && notePonderee < 90) { // Excellent A
            notationLiterale = "A";
            notationLiteraleEnum = NotationLitterale.A;
         } else if (notePonderee >= 80 && notePonderee < 85) { // Excellent A-
            notationLiterale = "A-";
            notationLiteraleEnum = NotationLitterale.A_MINUS;
         } else if (notePonderee >= 77 && notePonderee < 80) { // Très bien B+
            notationLiterale = "B+";
            notationLiteraleEnum = NotationLitterale.B_PLUS;
         } else if (notePonderee >= 73 && notePonderee < 77) { // Bien B
            notationLiterale = "B";
            notationLiteraleEnum = NotationLitterale.B;
         } else if (notePonderee >= 70 && notePonderee < 73) { // Bien B-
            notationLiterale = "B-";
            notationLiteraleEnum = NotationLitterale.B_MINUS;
         } else if (notePonderee >= 65 && notePonderee < 70) { // Satisfaisant C+
            notationLiterale = "C+";
            notationLiteraleEnum = NotationLitterale.C_PLUS;
         } else if (notePonderee >= 60 && notePonderee < 65) { // Satisfaisant C
            notationLiterale = "C";
            notationLiteraleEnum = NotationLitterale.C;
         } else if (notePonderee >= 57 && notePonderee < 60) { // Passable C-
            notationLiterale = "C-";
            notationLiteraleEnum = NotationLitterale.C_MINUS;
         } else if (notePonderee >= 54 && notePonderee < 57) { // Passable D+
            notationLiterale = "D+";
            notationLiteraleEnum = NotationLitterale.D_PLUS;
         } else if (notePonderee >= 50 && notePonderee < 54) { // Passable D
            notationLiterale = "D";
            notationLiteraleEnum = NotationLitterale.D;
         } else { // Échec E
            notationLiterale = "E";
            notationLiteraleEnum = NotationLitterale.E;
         }

         System.out.println("La note ponderee de" + etudiants[i][0] + " est " + notePonderee
               + " et la notation literale est : " + " " + notationLiteraleEnum);
         totalNotes += notePonderee;
      }
      double moyenne = totalNotes / etudiants.length;
      System.out.println("La moyenne des notes ponderees est " + moyenne);
   }
}