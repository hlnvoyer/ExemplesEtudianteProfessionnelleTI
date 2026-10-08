package ca.editions.helene.voyer.calcul.notes.business.note;

public class NoteTravailPratique {
    private int note;

    public NoteTravailPratique(int maximumPoints, int noteEtudiant) {
        note = (noteEtudiant * maximumPoints) / 100;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}