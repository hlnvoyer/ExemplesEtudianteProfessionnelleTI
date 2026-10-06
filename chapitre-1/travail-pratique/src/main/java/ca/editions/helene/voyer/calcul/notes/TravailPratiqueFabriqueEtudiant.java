package ca.editions.helene.voyer.calcul.notes;

import java.util.Iterator;
import java.util.LinkedList;

import ca.editions.helene.voyer.calcul.notes.business.bareme.notation.BaremeNotation;
import ca.editions.helene.voyer.calcul.notes.modele.Etudiant;
import ca.editions.helene.voyer.calcul.notes.modele.EtudiantPremierCycle;
import ca.editions.helene.voyer.calcul.notes.service.FabriqueListeChaineeEtudiant;
import ca.editions.helene.voyer.calcul.notes.business.note.NoteTravailPratique;
import ca.editions.helene.voyer.calcul.notes.business.note.NoteExamenMiSession;
import ca.editions.helene.voyer.calcul.notes.business.note.NoteExamenFinSession;
import ca.editions.helene.voyer.calcul.notes.modele.Cours;
import ca.editions.helene.voyer.calcul.notes.modele.CoursPremierCycle;
import ca.editions.helene.voyer.calcul.notes.service.FabriqueFichierCours;

public class TravailPratiqueFabriqueEtudiant {
   public static void main(String args[]) {
      // TP signifie Travail Pratique
      // Examen de mi-session
      // Examen de fin de session
      // Le tableau etudiant contient le nom de l'etudiant suivi de ses notes pour les
      // 3 TPs, l'examen de mi-session et l'examen de fin de session
      // FabriqueListeChaineeEtudiant crée une liste chaînée d'étudiants à partir des
      // données fournies
      FabriqueFichierCours.creerFichierCours(); // Création du fichier cours si nécessaire
      FabriqueListeChaineeEtudiant fabriqueListe = FabriqueListeChaineeEtudiant.getInstance();
      LinkedList<Etudiant> etudiants = fabriqueListe.createListeChaineeEtudiants();
      // Calcul des notes pondérées pour chaque étudiant
      BaremeNotation baremeNotation = BaremeNotation.getInstance();
      Iterator<Etudiant> etudiantsIterator = (Iterator<Etudiant>) etudiants.iterator();
      // lire fichier cours
      Cours structureDeDonnees = (CoursPremierCycle)FabriqueFichierCours.lireFichierCours();
      double totalNotes = 0;
      while (etudiantsIterator.hasNext()) {
         Etudiant cetEtudiant = (EtudiantPremierCycle) etudiantsIterator.next();
         // déplaçons le calcul des notes dans les classes business NoteTravailPratique,
         // NoteExamenMiSession et NoteExamenFinSession ainsi que CoursPremierCycle 
         NoteTravailPratique notePremierTravailPratique = new NoteTravailPratique(100, cetEtudiant.getTp1());
         NoteTravailPratique noteDeuxiemeTravailPratique = new NoteTravailPratique(100, cetEtudiant.getTp2());
         NoteTravailPratique noteTroisiemeTravailPratique = new NoteTravailPratique(100, cetEtudiant.getTp3());
         NoteExamenMiSession noteExamenMisession = new NoteExamenMiSession(100, cetEtudiant.getExamenMiSession());
         NoteExamenFinSession noteExamenFinSession = new NoteExamenFinSession(100, cetEtudiant.getExamenFinSession());
         double notePondereeTP = (notePremierTravailPratique.getNotePourcentage() +
                                 noteDeuxiemeTravailPratique.getNotePourcentage() +
                                 noteTroisiemeTravailPratique.getNotePourcentage()) / 100 * structureDeDonnees.getPonderationTravauxPratique();
         double notePondereeMiSession = noteExamenMisession.getNote() * structureDeDonnees.getPonderationExamenMiSession();
         double notePondereeFinSession = noteExamenFinSession.getNote() * structureDeDonnees.getPonderationExamenFinSession();
         double notePonderee = notePondereeTP + notePondereeMiSession + notePondereeFinSession;
         cetEtudiant.setNotePonderee(notePonderee);
         // récit utilisateur 2 : enlevons le calcul de la notation littérale dans un
         // objet business (BaremeNotation) car ce qui fonctionne au Québec peut ne pas
         // être pareil en Ontario, au Nouveau-Brunswick ou ailleurs dans la francophonie
         System.out.println("La note ponderee de " + cetEtudiant.getNotePonderee() + " est " + notePonderee
               + " et la notation literale est : " + baremeNotation.getNotationLitterale(notePonderee));
         totalNotes += notePonderee;
      }
      // Calcul de la moyenne des notes pondérées
      double moyenne = totalNotes / etudiants.size();
      System.out.println("La moyenne des notes ponderees est " + moyenne);
   }
}
