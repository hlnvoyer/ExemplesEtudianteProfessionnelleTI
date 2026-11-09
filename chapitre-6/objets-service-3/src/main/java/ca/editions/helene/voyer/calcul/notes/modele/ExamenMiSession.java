package ca.editions.helene.voyer.calcul.notes.modele;

public class ExamenMiSession {
    private double note;
    private double poids;

    public ExamenMiSession(double note, double poids) {
        this.note = note;
        this.poids = poids;
    }

    public double getNote() {
        return note;
    }

    public double getPoids() {
        return poids;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }
}