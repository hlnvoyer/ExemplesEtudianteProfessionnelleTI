public class TravailPratique {




   public static void main(String args[])  {
        // TP signifie Travail Pratique
        // Examen de mi-session
        // Examen de fin de session
        // Le tableau etudiant contient le nom de l'etudiant suivi de ses notes pour les 3 TPs, l'examen de mi-session t l'examen de fin de session
        Object[] etudiant = new Object[] {"Etudiant 1 ", 75, 55, 88, 79, 85};
        
        // calculons la note ponderee d'un seul etudiant
        double notePonderee = (int)etudiant[1] * 0.1 + (int)etudiant[2] * 0.1 + (int)etudiant[3] * 0.1 + (int)etudiant[4] * 0.3 + (int)etudiant[5] * 0.4;
        System.out.println("La note ponderee de " + etudiant[0] + " est " + notePonderee);
   }   
}
