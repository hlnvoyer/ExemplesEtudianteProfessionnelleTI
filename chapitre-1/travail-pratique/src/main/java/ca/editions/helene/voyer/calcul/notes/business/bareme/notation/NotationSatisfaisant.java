package ca.editions.helene.voyer.calcul.notes.business.bareme.notation;

public class NotationSatisfaisant extends BaremeNotation {
    public NotationLitterale getNotationLitterale(double notePonderee) {
        NotationLitterale notationLiteraleEnum = NotationLitterale.AUCUN;
        if (notePonderee >= 60 && notePonderee < 70) { // Satisfaisant C
            notationLiteraleEnum = NotationLitterale.C;
        } else if (notePonderee >= 55 && notePonderee < 60) { // Satisfaisant C-
            notationLiteraleEnum = NotationLitterale.C_MINUS;
        }
        return notationLiteraleEnum;
    }
}
