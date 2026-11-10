package ca.editions.helene.voyer.calcul.notes.business.note;

public class NoteExamenFinSession {
    private int note;

    public NoteExamenFinSession(int maximumPoints, int noteEtudiant) {
        this.note = (noteEtudiant * maximumPoints) / 100;
        System.out.println("Note calculée: " + this.note);
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}
