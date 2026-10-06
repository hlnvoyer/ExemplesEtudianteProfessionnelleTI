package ca.editions.helene.voyer.calcul.notes.business.note;

public class NoteExamenMiSession extends NotePonderee {
    private double maximumPoints;
    private double note;
    private double notePourcentage;

  public NoteExamenMiSession(double noteMaximale, double noteObtenue) {
        super(noteMaximale, noteObtenue);
        this.maximumPoints = noteMaximale;
        this.note = noteObtenue;
        this.notePourcentage = (noteObtenue / noteMaximale) * 100;
    }   

    public double getNotePourcentage() {
        return notePourcentage;
    }   

    public void setNotePourcentage(double notePourcentage) {
        this.notePourcentage = notePourcentage;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
        this.notePourcentage = (note / maximumPoints) * 100;
    }

    public double getMaximumPoints() {
        return maximumPoints;
    }   
    
    public void setMaximumPoints(double maximumPoints) {
        this.maximumPoints = maximumPoints;
        this.notePourcentage = (note / maximumPoints) * 100;
    }   
}
