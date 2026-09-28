package editions.helene.voyer.ca.travail.pratique;

import java.util.Iterator;
import java.util.LinkedList;
import editions.helene.voyer.ca.modele.Etudiant;
import editions.helene.voyer.ca.service.FabriqueListeChaineeEtudiant;

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
      FabriqueListeChaineeEtudiant fabriqueListe = FabriqueListeChaineeEtudiant.getInstance();
      LinkedList etudiants = fabriqueListe.createListeChaineeEtudiants();
      double totalNotes = 0;
      Iterator etudiantsIterator = etudiants.iterator();
      while (etudiantsIterator.hasNext()) {
         Etudiant cetEtudiant = (Etudiant) etudiantsIterator.next();
         double notePondereeTP = cetEtudiant.getTp1() * 0.1 + cetEtudiant.getTp2() * 0.1
               + cetEtudiant.getTp3() * 0.1;
         double notePondereeMiSession = cetEtudiant.getExamenMiSession() * 0.3;
         double notePondereeFinSession = cetEtudiant.getExamenFinDeSession() * 0.4;
         double notePonderee = notePondereeTP + notePondereeMiSession + notePondereeFinSession;
         cetEtudiant.setNotePonderee(notePonderee);
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
         System.out.println("La note ponderee de " + cetEtudiant.getNotePonderee() + " est " + notePonderee
               + " et la notation literale est : " + notationLiterale + " " + notationLiteraleEnum);
         totalNotes += notePonderee;
      }
      double moyenne = totalNotes / etudiants.size();
      System.out.println("La moyenne des notes ponderees est " + moyenne);
   }
}
