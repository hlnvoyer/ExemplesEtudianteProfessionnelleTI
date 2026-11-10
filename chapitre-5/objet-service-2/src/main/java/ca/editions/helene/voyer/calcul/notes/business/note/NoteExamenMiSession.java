package ca.editions.helene.voyer.calcul.notes.business.note;

public class NoteExamenMiSession {
    private int note;

    public NoteExamenMiSession(int maximumPoints, int noteEtudiant) {
        note = (noteEtudiant * maximumPoints) / 100;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
