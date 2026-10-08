package ca.editions.helene.voyer.calcul.notes.business;

public abstract class NotePonderee {
    private double notePourcentage;
    private double poidsNoteFinale;

    public double getPoidsNoteFinale() {
        return poidsNoteFinale;
    }

    public void setPoidsNoteFinale(double poidsNoteFinale) {
        this.poidsNoteFinale = poidsNoteFinale;
    }

    public double getNotePourcentage() {
        return notePourcentage;
    }

    public void setNotePourcentage(double notePourcentage) {
        this.notePourcentage = notePourcentage;
    }
}
