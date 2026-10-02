package ca.editions.helene.voyer.calcul.notes.business;

public class NotationPassable extends BaremeNotation {
    public NotationLitterale getNotationLitterale(double notePonderee) {
        NotationLitterale notationLiteraleEnum = NotationLitterale.AUCUN;
        if (notePonderee >= 50 && notePonderee < 55) { // Passable D
            notationLiteraleEnum = NotationLitterale.D;
        } else if (notePonderee >= 45 && notePonderee < 50) { // Passable D-
            notationLiteraleEnum = NotationLitterale.D_MINUS;
        }
        return notationLiteraleEnum;
    }
}