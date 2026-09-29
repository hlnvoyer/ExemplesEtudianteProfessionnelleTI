package editions.helene.voyer.ca.modele;

public abstract class Cours {
  private String titreCours;
  private String codeCours;
  private String[] prerequis;
  private int unites;

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
}
