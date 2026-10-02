package ca.editions.helene.voyer.calcul.notes;

import java.util.Iterator;
import java.util.LinkedList;

import ca.editions.helene.voyer.calcul.notes.business.BaremeNotation;
import ca.editions.helene.voyer.calcul.notes.modele.Etudiant;
import ca.editions.helene.voyer.calcul.notes.service.FabriqueListeChaineeEtudiant;

public class TravailPratiqueFabriqueEtudiant {
   public static void main(String args[]) {
      // TP signifie Travail Pratique
      // Examen de mi-session
      // Examen de fin de session
      // Le tableau etudiant contient le nom de l'etudiant suivi de ses notes pour les
      // 3 TPs, l'examen de mi-session et l'examen de fin de session
      // FabriqueListeChaineeEtudiant crée une liste chaînée d'étudiants à partir des données fournies
      FabriqueListeChaineeEtudiant fabriqueListe = FabriqueListeChaineeEtudiant.getInstance();
      LinkedList<Etudiant> etudiants = fabriqueListe.createListeChaineeEtudiants();
      // Calcul des notes pondérées pour chaque étudiant
      BaremeNotation baremeNotation = BaremeNotation.getInstance();
      Iterator<Etudiant> etudiantsIterator = (Iterator<Etudiant>) etudiants.iterator();
      double totalNotes = 0;
      while (etudiantsIterator.hasNext()) {
         Etudiant cetEtudiant = (Etudiant) etudiantsIterator.next();
         double notePondereeTP = cetEtudiant.getTp1() * 0.1 + cetEtudiant.getTp2() * 0.1
               + cetEtudiant.getTp3() * 0.1;
         double notePondereeMiSession = cetEtudiant.getExamenMiSession() * 0.3;
         double notePondereeFinSession = cetEtudiant.getExamenFinDeSession() * 0.4;
         double notePonderee = notePondereeTP + notePondereeMiSession + notePondereeFinSession;
         cetEtudiant.setNotePonderee(notePonderee);
         // récit utilisateur 2 : enlevons le calcul de la notation littérale dans un
         // objet business (BaremeNotation) car ce qui fonctionne au Québec peut ne pas être pareil 
         // en Ontario, au Nouveau-Brunswick ou ailleurs dans la francophonie
         System.out.println("La note ponderee de " + cetEtudiant.getNotePonderee() + " est " + notePonderee
               + " et la notation literale est : " + baremeNotation.getNotationLitterale(notePonderee));
         totalNotes += notePonderee;
      }
      // Calcul de la moyenne des notes pondérées
      double moyenne = totalNotes / etudiants.size();
      System.out.println("La moyenne des notes ponderees est " + moyenne);
   }
}
