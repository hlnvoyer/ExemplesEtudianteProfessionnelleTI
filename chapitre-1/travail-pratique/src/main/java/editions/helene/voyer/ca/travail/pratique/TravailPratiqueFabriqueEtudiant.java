package editions.helene.voyer.ca.travail.pratique;

import java.util.Iterator;
import java.util.LinkedList;
import editions.helene.voyer.ca.modele.Etudiant;
import editions.helene.voyer.ca.service.FabriqueListeChaineeEtudiant;
import editions.helene.voyer.ca.business.BaremeNotation;
/*
 Finalement avec les fabriques, les services et les objets model et business le monolithe est pas mal plus court.
 Il ne reste que le calcul des notes pondérée et naviguer dans la liste chaînée. 
 Les pourcentages des items à calculer et leurs nombres varient pour chaque cours. 
 Donc une classe abstraite cours avec des implémentations différentes pour premier cycle, 
 deuxième cycle, troisième cycle, mais aussi dépendant si le cours est libre, obligatoire ou choisi. 
 Il y aura des cours dont l'horaire est fin de semaine, d'autres avec horaire réduit comme durant la 
 session d'été et ceux pour une session complète. 
Le nombre de crédits / unités varient de cours en cours aussi. */

public class TravailPratiqueFabriqueEtudiant {
   public static void main(String args[]) {
      // TP signifie Travail Pratique
      // Examen de mi-session
      // Examen de fin de session
      // Le tableau etudiant contient le nom de l'etudiant suivi de ses notes pour les
      // 3 TPs, l'examen de mi-session t l'examen de fin de session
      FabriqueListeChaineeEtudiant fabriqueListe = FabriqueListeChaineeEtudiant.getInstance();
      LinkedList<Etudiant> etudiants = fabriqueListe.createListeChaineeEtudiants();
      BaremeNotation baremeNotation = BaremeNotation.getInstance();
      Iterator<Etudiant> etudiantsIterator = (Iterator<Etudiant>)etudiants.iterator();
      double totalNotes = 0;
      while (etudiantsIterator.hasNext()) {
         Etudiant cetEtudiant = (Etudiant) etudiantsIterator.next();
         double notePondereeTP = cetEtudiant.getTp1() * 0.1 + cetEtudiant.getTp2() * 0.1
               + cetEtudiant.getTp3() * 0.1;
         double notePondereeMiSession = cetEtudiant.getExamenMiSession() * 0.3;
         double notePondereeFinSession = cetEtudiant.getExamenFinDeSession() * 0.4;
         double notePonderee = notePondereeTP + notePondereeMiSession + notePondereeFinSession;
         cetEtudiant.setNotePonderee(notePonderee);
         // récit utilisateur 2 : enlevons le calcul de la notation littérale dans un objet business (BaremeNotation)
         // car ce qui fonctionne au Québec peut ne pas être pareil en Ontario, au Nouveau-Brunswick ou ailleurs dans la francophonie
         System.out.println("La note ponderee de " + cetEtudiant.getNotePonderee() + " est " + notePonderee
               + " et la notation literale est : " + baremeNotation.getNotationLitterale(notePonderee));
         totalNotes += notePonderee;
      }
      double moyenne = totalNotes / etudiants.size();
      System.out.println("La moyenne des notes ponderees est " + moyenne);
   }
}
