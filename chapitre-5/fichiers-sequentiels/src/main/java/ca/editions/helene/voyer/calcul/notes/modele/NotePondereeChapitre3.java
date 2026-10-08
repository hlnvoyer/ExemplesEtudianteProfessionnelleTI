package ca.editions.helene.voyer.calcul.notes.modele;

public class NotePondereeChapitre3 {
    private double notePourcentage;
    private double poidsNoteFinale;

    public NotePondereeChapitre3(double notePourcentage, double poidsNoteFinale) {
        this.notePourcentage = notePourcentage;
        this.poidsNoteFinale = poidsNoteFinale;
    }
    
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
