package ca.editions.helene.voyer.calcul.notes.modele;

public class TravailPratique {
    private int note;
    private double poids;

    public TravailPratique(int note, double poids) {
        this.note = note;
        this.poids = poids;
    }

    public int getNote() {
        return note;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public void setNote(int note) {
        this.note = note;
    }
}