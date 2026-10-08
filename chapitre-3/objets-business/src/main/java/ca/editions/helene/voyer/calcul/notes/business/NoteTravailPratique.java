package ca.editions.helene.voyer.calcul.notes.business;

public class NoteTravailPratique extends NotePonderee {
    // maximum de points = nombre de questions * poids de chaque question
    private int maximumPoints;
    private int note;
    private double notePourcentage;

    public NoteTravailPratique(int maximumPoints, int note) {
        notePourcentage = note * maximumPoints / 100;
    }

    public int getMaximumPoints() {
        return maximumPoints;
    }

    public void setMaximumPoints(int maximumPoints) {
        this.maximumPoints = maximumPoints;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public double getNotePourcentage() {
        return notePourcentage;
    }

    public void setNotePourcentage(double notePourcentage) {
        this.notePourcentage = notePourcentage;
    }
}