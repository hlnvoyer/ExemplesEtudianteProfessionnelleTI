package ca.editions.helene.voyer.calcul.notes.business;

public class NotationExcellent extends BaremeNotation {
    public NotationExcellent() {
    }

    static final NotationExcellent INSTANCE = new NotationExcellent() {
    };

    public static NotationExcellent getInstance() {
        return INSTANCE;
    }

    public NotationLitterale getNotationLitterale(double notePonderee) {
        NotationLitterale notationLiteraleEnum = NotationLitterale.AUCUN;
        if (notePonderee >= 90) { // Excellent A+
            notationLiteraleEnum = NotationLitterale.A_PLUS;
        } else if (notePonderee >= 85 && notePonderee < 90) { // Excellent A
            notationLiteraleEnum = NotationLitterale.A;
        } else if (notePonderee >= 80 && notePonderee < 85) { // Excellent A-
            notationLiteraleEnum = NotationLitterale.A_MINUS;
        }
        return notationLiteraleEnum;
    }
}
