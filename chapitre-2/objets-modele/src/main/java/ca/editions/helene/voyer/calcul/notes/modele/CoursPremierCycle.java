package ca.editions.helene.voyer.calcul.notes.modele;

import java.util.ArrayList;

public class CoursPremierCycle extends Cours {
   private ArrayList<Etudiant> etudiants = new ArrayList<>();

   public CoursPremierCycle(String codeCours, String titreCours, int unites, int nombreDeTravauxPratiques, double ponderationTravauxPratique, double ponderationExamenMiSession, double ponderationExamenFinSession) {
       super(codeCours, titreCours, unites, nombreDeTravauxPratiques, ponderationTravauxPratique, ponderationExamenMiSession, ponderationExamenFinSession);
   }

   public ArrayList<Etudiant> getEtudiants() {   
       return etudiants;
   }

   public void ajouterEtudiant(Etudiant etudiant) {
    etudiants.add(etudiant);
   }
}