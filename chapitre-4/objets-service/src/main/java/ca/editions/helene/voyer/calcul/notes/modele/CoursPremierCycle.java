package ca.editions.helene.voyer.calcul.notes.modele;

import java.util.ArrayList;

public class CoursPremierCycle extends Cours {
   private ArrayList<Etudiant> etudiants = new ArrayList<>();
   private int nombreDeTravauxPratiques;
   private double ponderationTravauxPratique;
   private double ponderationExamenMiSession;
   private double ponderationExamenFinSession;

   public CoursPremierCycle(String codeCours, String titreCours, int unites) {
       super(codeCours, titreCours, unites);
   }

   public ArrayList<Etudiant> getEtudiants() {   
       return etudiants;
   }

   public void ajouterEtudiant(Etudiant etudiant) {
    etudiants.add(etudiant);
   }

   public int getNombreDeTravauxPratiques() {
       return nombreDeTravauxPratiques;
   }

   public void setNombreDeTravauxPratiques(int nombreDeTravauxPratiques) {
       this.nombreDeTravauxPratiques = nombreDeTravauxPratiques;
   }

   public double getPonderationTravauxPratique() {
       return ponderationTravauxPratique;
   }

   public void setPonderationTravauxPratique(double ponderationTravauxPratique) {
       this.ponderationTravauxPratique = ponderationTravauxPratique;
   }

   public double getPonderationExamenMiSession() {
       return ponderationExamenMiSession;
   }

   public void setPonderationExamenMiSession(double ponderationExamenMiSession) {
       this.ponderationExamenMiSession = ponderationExamenMiSession;
   }

   public double getPonderationExamenFinSession() {
       return ponderationExamenFinSession;
   }

   public void setPonderationExamenFinSession(double ponderationExamenFinSession) {
       this.ponderationExamenFinSession = ponderationExamenFinSession;
   }
}