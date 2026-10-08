package ca.editions.helene.voyer.calcul.notes.business;

public class NotationTresBien extends BaremeNotation {
    public NotationTresBien() {
    }

    static final NotationTresBien INSTANCE = new NotationTresBien() {
    };

    public static NotationTresBien getInstance() {
        return INSTANCE;
    }

    public NotationLitterale getNotationLitterale(double notePonderee) {
        NotationLitterale notationLiteraleEnum = NotationLitterale.AUCUN;
        if (notePonderee >= 80 && notePonderee < 90) { // Très bien B+
            notationLiteraleEnum = NotationLitterale.B_PLUS;
        } else if (notePonderee >= 75 && notePonderee < 80) { // Très bien B
            notationLiteraleEnum = NotationLitterale.B;
        } else if (notePonderee >= 70 && notePonderee < 75) { // Très bien B-
            notationLiteraleEnum = NotationLitterale.B_MINUS;
        }
        return notationLiteraleEnum;
    }
}
