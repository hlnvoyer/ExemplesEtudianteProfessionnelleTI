package ca.editions.helene.voyer.calcul.notes.modele;

public class TravailPratique {
    private double note;
    private double poids;

    public TravailPratique(double note, double poids) {
        this.note = note;
        this.poids = poids;
    }

    public double getNote() {
        return note;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setNote(double note) {
        this.note = note;
    }
}