package ca.editions.helene.voyer.calcul.notes.modele;

public abstract class Cours {
  private String codeCours;
  private String titreCours;
  private String[] prerequis;
  private int unites;
  private int nombreDeTravauxPratiques;
  private double ponderationTravauxPratique;
  private double ponderationExamenMiSession;
  private double ponderationExamenFinSession;

  public Cours(String codeCours, String titreCours, int unites, int nombreDeTravauxPratiques, double ponderationTravauxPratique, double ponderationExamenMiSession, double ponderationExamenFinSession) {
    this.codeCours = codeCours;
    this.titreCours = titreCours;
    this.unites = unites;
    this.nombreDeTravauxPratiques = nombreDeTravauxPratiques;
    this.ponderationTravauxPratique = ponderationTravauxPratique;
    this.ponderationExamenMiSession = ponderationExamenMiSession;
    this.ponderationExamenFinSession = ponderationExamenFinSession;
  }

  public Cours() {
  } 
  
  public String getCodeCours() {
    return codeCours;
  }

  public void setCodeCours(String codeCours) {
    this.codeCours = codeCours;
  }

  public String[] getPrerequis() {
    return prerequis;
  }

  public void setPrerequis(String[] prerequis) {
    this.prerequis = prerequis;
  }

  public String getTitreCours() {
    return titreCours;
  }

  public void setTitreCours(String titreCours) {
    this.titreCours = titreCours;
  }

  public int getUnites() {
    return unites;
  }

  public void setUnites(int unites) {
    this.unites = unites;
  }

  public double getPonderationTravauxPratique() {
    return ponderationTravauxPratique;
  }

  public int getNombreDeTravauxPratiques() {
    return nombreDeTravauxPratiques;
  }

  public void setNombreDeTravauxPratiques(int nombreDeTravauxPratiques) {
    this.nombreDeTravauxPratiques = nombreDeTravauxPratiques;
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
