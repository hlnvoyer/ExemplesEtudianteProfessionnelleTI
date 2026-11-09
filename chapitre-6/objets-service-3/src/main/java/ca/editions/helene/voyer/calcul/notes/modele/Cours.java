package ca.editions.helene.voyer.calcul.notes.modele;

public abstract class Cours {
  // créer et géré par le processus métier GestionCours
  private String codeCours;
  private String titreCours;
  private Cours[] prerequis;
  private double unites;

  public Cours(String codeCours, String titreCours, double unites) {
    this.codeCours = codeCours;
    this.titreCours = titreCours;
    this.unites = unites;
  }

  public String getCodeCours() {
    return codeCours;
  }

  public void setCodeCours(String codeCours) {
    this.codeCours = codeCours;
  }

  public String getTitreCours() {
    return titreCours;
  }

  public void setTitreCours(String titreCours) {
    this.titreCours = titreCours;
  }

  public double getUnites() {
    return unites;
  }

  public void setUnites(double unites) {
    this.unites = unites;
  }

  public Cours[] getPrerequis() {
    return prerequis;
  }

  public void setPrerequis(Cours[] prerequis) {
    this.prerequis = prerequis;
  }
}
