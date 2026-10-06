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
import ca.editions.helene.voyer.calcul.notes.service.FabriqueFichierCours;

public class TravailPratiqueFichierSequentiel {

   public static void main(String args[]) {
      // TP signifie Travail Pratique
      // Examen de mi-session
      // Examen de fin de session
      // Le tableau etudiant contient le nom de l'etudiant suivi de ses notes pour les
      // 3 TPs, l'examen de mi-session et l'examen de fin de session
      // FabriqueListeChaineeEtudiant crée une liste chaînée d'étudiants à partir des
      // données fournies
      FabriqueFichierCours.creerFichierCours(); // Création du fichier cours si nécessaire
      // fichier créé, là on peut le lire pour les cours
      FabriqueListeChaineeEtudiant fabriqueListe = FabriqueListeChaineeEtudiant.getInstance();
      LinkedList<Etudiant> etudiants = fabriqueListe.createListeChaineeEtudiants();
      // Calcul des notes pondérées pour chaque étudiant
      BaremeNotation baremeNotation = BaremeNotation.getInstance();
      Iterator<Etudiant> etudiantsIterator = (Iterator<Etudiant>) etudiants.iterator();
      // public Cours(String codeCours, String titreCours, double[] ponderationTravauxPratique, double ponderationExamenMiSession, double ponderationExamenFinSession) {
      Cours structureDeDonnees = FabriqueFichierCours.lireFichierCours();
      double totalNotes = 0;
      NoteTravailPratique notePremierTravailPratique = null;
      NoteTravailPratique noteDeuxiemeTravailPratique = null;
      NoteTravailPratique noteTroisiemeTravailPratique = null;
      NoteExamenMiSession noteExamenMiSession = null;
      NoteExamenFinSession noteExamenFinSession = null;
      double notePondereeTP = 0.0;
      double notePondereeMiSession = 0.0;
      double notePondereeFinSession = 0.0;
      double notePonderee = 0.0;
     while (etudiantsIterator.hasNext()) {
         Etudiant cetEtudiant = (EtudiantPremierCycle) etudiantsIterator.next();
         // déplaçons le calcul des notes dans les classes business NoteTravailPratique,
         // NoteExamenMiSession et NoteExamenFinSession ainsi que CoursPremierCycle 
         notePremierTravailPratique = new NoteTravailPratique(100, cetEtudiant.getTp1());
         System.out.println("Note du premier travail pratique pour " + cetEtudiant.getNom() + " : " + notePremierTravailPratique.getNotePourcentage());
         noteDeuxiemeTravailPratique = new NoteTravailPratique(100, cetEtudiant.getTp2());
         System.out.println("Note du deuxième travail pratique pour " + cetEtudiant.getNom() + " : " + noteDeuxiemeTravailPratique.getNotePourcentage());
         noteTroisiemeTravailPratique = new NoteTravailPratique(100, cetEtudiant.getTp3());
         System.out.println("Note du troisième travail pratique pour " + cetEtudiant.getNom() + " : " + noteTroisiemeTravailPratique.getNotePourcentage());
         noteExamenMiSession = new NoteExamenMiSession(100, cetEtudiant.getExamenMiSession());
         // pourquoi ça affiche 100.0 au lieu de la note réelle de l'étudiant?
         System.out.println("Note de l'examen de mi-session pour " + cetEtudiant.getNom() + " : " + noteExamenMiSession.getNotePourcentage());
         noteExamenFinSession = new NoteExamenFinSession(100, cetEtudiant.getExamenFinSession());
         // pourquoi ça affiche 100.0 au lieu de la note réelle de l'étudiant?
         System.out.println("Note de l'examen de fin de session pour " + cetEtudiant.getNom() + " : " + noteExamenFinSession.getNotePourcentage());
         notePondereeTP = notePremierTravailPratique.getNotePourcentage() +
                                 noteDeuxiemeTravailPratique.getNotePourcentage() +
                                 noteTroisiemeTravailPratique.getNotePourcentage();
         System.out.println("********** note ponderee de l''etudiant " + cetEtudiant.getNom() + " " + notePondereeTP);
         notePondereeTP = (notePondereeTP / (100 * structureDeDonnees.getNombreDeTravauxPratiques())) * structureDeDonnees.getPonderationTravauxPratique() * 100;
         System.out.println("Note pondérée des travaux pratiques pour " + cetEtudiant.getNom() + " : " + notePondereeTP);  
         notePondereeMiSession = noteExamenMiSession.getNote() * structureDeDonnees.getPonderationExamenMiSession();
         System.out.println("Note pondérée de l'examen de mi-session pour " + cetEtudiant.getNom() + " : " + notePondereeMiSession);
         notePondereeFinSession = noteExamenFinSession.getNote() * structureDeDonnees.getPonderationExamenFinSession();
         System.out.println("Note pondérée de l'examen de fin de session pour " + cetEtudiant.getNom() + " : " + notePondereeFinSession);
         notePonderee = notePondereeTP + notePondereeMiSession + notePondereeFinSession;
         cetEtudiant.setNotePonderee(notePonderee);
         // récit utilisateur 2 : enlevons le calcul de la notation littérale dans un
         // objet business (BaremeNotation) car ce qui fonctionne au Québec peut ne pas
         // être pareil en Ontario, au Nouveau-Brunswick ou ailleurs dans la francophonie
         System.out.println("La note ponderee de " + cetEtudiant.getNotePonderee() + " est " + notePonderee
               + " et la notation literale est : " + baremeNotation.getNotationLitterale(notePonderee));
         totalNotes += notePonderee;
         // oups besoin de remettre les valeurs à zéro pour le prochain étudiant
         notePonderee = 0.0;
         notePondereeTP = 0.0;
         notePondereeMiSession = 0.0;
         notePondereeFinSession = 0.0;
         notePremierTravailPratique = null;
         noteDeuxiemeTravailPratique = null;
         noteTroisiemeTravailPratique = null;
         noteExamenMiSession = null;
         noteExamenFinSession = null;
      }
      // Calcul de la moyenne des notes pondérées
      double moyenne = totalNotes / etudiants.size();
      System.out.println("La moyenne des notes ponderees est " + moyenne);
   }
}
