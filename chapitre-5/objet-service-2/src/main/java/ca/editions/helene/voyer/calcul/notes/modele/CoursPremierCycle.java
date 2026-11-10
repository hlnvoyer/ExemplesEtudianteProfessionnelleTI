package ca.editions.helene.voyer.calcul.notes.modele;

public class CoursPremierCycle extends Cours{
   public CoursPremierCycle(String codeCours, String titreCours, int unites, int nombreDeTravauxPratiques, double ponderationTravauxPratique, double ponderationExamenMiSession, double ponderationExamenFinSession) {
       super(codeCours, titreCours, unites, nombreDeTravauxPratiques, ponderationTravauxPratique, ponderationExamenMiSession, ponderationExamenFinSession);
   }
}