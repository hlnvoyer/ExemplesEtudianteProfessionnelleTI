public class TravailPratique {

   public static void main(String args[])  {
        // TP signifie Travail Pratique
        // Examen de mi-session
        // Examen de fin de session
        // Le tableau etudiant contient le nom de l'etudiant suivi de ses notes pour les 3 TPs, l'examen de mi-session t l'examen de fin de session
        Object[][] etudiants = new Object[][] {{"Etudiant 1 ", 75, 55, 88, 79, 85}, 
        {"Etudiant 2 ", 65, 75, 78, 74, 81},
        {"Etudiant 3 ", 85, 90, 80, 70, 95},  
        {"Etudiant 4 ", 90, 85, 75, 80, 88},
        {"Etudiant 5 ", 70, 80, 85, 75, 90},
        {"Etudiant 6 ", 95, 85, 88, 80, 85},
        {"Etudiant 7 ", 80, 71, 85, 90, 95},
        {"Etudiant 8 ", 85, 80, 87, 85, 80},
        {"Etudiant 9 ", 71, 85, 80, 90, 95},
        {"Etudiant 10 ", 80, 78, 85, 75, 88},
        {"Etudiant 11 ", 78, 75, 80, 90, 92},
        {"Etudiant 12 ", 90, 80, 78, 85, 90},
        {"Etudiant 13 ", 85, 82, 80, 88, 90},
        {"Etudiant 14 ", 80, 85, 82, 87, 88},
        {"Etudiant 15 ", 85, 80, 84, 90, 92},
        {"Etudiant 16 ", 80, 82, 85, 88, 90},
        {"Etudiant 17 ", 85, 85, 80, 90, 95},
        {"Etudiant 18 ", 80, 80, 85, 85, 90},
        {"Etudiant 19 ", 85, 82, 80, 88, 90},
        {"Etudiant 20 ", 80, 85, 82, 87, 88},
        {"Etudiant 21 ", 85, 80, 84, 90, 92},
        {"Etudiant 22 ", 80, 82, 85, 88, 90},
        {"Etudiant 23 ", 85, 85, 80, 90, 95},
        {"Etudiant 24 ", 80, 80, 85, 85, 90},
        {"Etudiant 25 ", 85, 82, 80, 88, 90},
        {"Etudiant 26 ", 80, 85, 82, 87, 88},
        {"Etudiant 27 ", 85, 80, 84, 90, 92},
        {"Etudiant 28 ", 80, 82, 85, 88, 90},
        {"Etudiant 29 ", 85, 85, 80, 90, 95},
        {"Etudiant 30 ", 80, 80, 85, 85, 90}
      };
        
        // calculons la note ponderee d'un seul etudiant
        for(int i = 0; i < etudiants.length; i++) {
         double notePonderee = (int)etudiants[i][1] * 0.1 + (int)etudiants[i][2] * 0.1 + (int)etudiants[i][3] * 0.1 + (int)etudiants[i][4] * 0.3 + (int)etudiants[i][5] * 0.4;
         System.out.println("La note ponderee de " + etudiants[i][0] + " est " + notePonderee);

        }
   }   
}
