package ca.editions.helene.voyer.calcul.notes.business.note;

public class NoteTravailPratique extends NotePonderee {
    // maximum de points = nombre de questions * poids de chaque question
    private double maximumPoints;
    private double note;
    private double notePourcentage;

//             double notePondereeTP = cetEtudiant.getTp1() * 0.1 + cetEtudiant.getTp2() * 0.1
//               + cetEtudiant.getTp3() * 0.1;

    public NoteTravailPratique(double maximumPoints, double note) {
        super(maximumPoints, note);
        notePourcentage = note * maximumPoints / 100;
    }

    public double getMaximumPoints() {
        return maximumPoints;
    }

    public void setMaximumPoints(double maximumPoints) {
        this.maximumPoints = maximumPoints;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public double getNotePourcentage() {
        return notePourcentage;
    }

    public void setNotePourcentage(double notePourcentage) {
        this.notePourcentage = notePourcentage;
    }
}