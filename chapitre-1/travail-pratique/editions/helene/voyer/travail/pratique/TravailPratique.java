public class TravailPratique {




   public static void main(String args[])  {
        // TP signifie Travail Pratique
        // Examen de mi-session
        // Examen de fin de session
        // Le tableau etudiant contient le nom de l'etudiant suivi de ses notes pour les 3 TPs, l'examen de mi-session t l'examen de fin de session
        Object[][] etudiants = new Object[][] {{"Etudiant 1 ", 75, 55, 88, 79, 85}, {"Etudiant 2 ", 65, 75, 78, 74, 81}};
        
        // calculons la note ponderee d'un seul etudiant
        for(int i = 0; i < etudiants.length; i++) {
         double notePonderee = (int)etudiants[i][1] * 0.1 + (int)etudiants[i][2] * 0.1 + (int)etudiants[i][3] * 0.1 + (int)etudiants[i][4] * 0.3 + (int)etudiants[i][5] * 0.4;
         System.out.println("La note ponderee de " + etudiants[i][0] + " est " + notePonderee);

        }
   }   
}
