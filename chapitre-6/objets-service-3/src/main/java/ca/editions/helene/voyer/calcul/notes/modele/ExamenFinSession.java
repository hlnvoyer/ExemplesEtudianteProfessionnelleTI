package ca.editions.helene.voyer.calcul.notes.modele;

public class ExamenFinSession {
    private double note;
    private double poids;

    public ExamenFinSession(double note, double poids) {
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
