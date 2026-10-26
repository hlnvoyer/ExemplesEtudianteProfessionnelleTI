package ca.editions.helene.voyer.calcul.notes.modele;

public abstract class EtudiantCours {
    // créé et géré par le processus métier Inscription
    private String codePermanent;
    private String CodeCours;

    public String getCodePermanent() {
        return this.codePermanent;
    }

    public void setCodePermanent(String unCodePermanent) {
        this.codePermanent = unCodePermanent;
    }

    public String getCodeCours() {
        return this.CodeCours;
    }

    public void setCodeCours(String unCodeCours) {
        this.CodeCours = unCodeCours;
    }
}