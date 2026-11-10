package ca.editions.helene.voyer.calcul.notes.business.bareme.notation;

public class NotationEchec extends BaremeNotation {
    public NotationEchec() {
    }

    static final NotationEchec INSTANCE = new NotationEchec() {
    };

    public static NotationEchec getInstance() {
        return INSTANCE;
    }

    public NotationLitterale getNotationLitterale(double notePonderee) {
        NotationLitterale notationLiteraleEnum = NotationLitterale.AUCUN;
        // ?? Une note de 50 est un échec il manquait le = dans la condition, je l'ai
        // ajouté manuellement
        if (notePonderee <= 50) { // Échec E
            notationLiteraleEnum = NotationLitterale.E;
        }
        return notationLiteraleEnum;
    }
}
