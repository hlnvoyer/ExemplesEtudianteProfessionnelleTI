package ca.editions.helene.voyer.calcul.notes.business.note;

public abstract class NotePonderee {
    public double calculerNotePonderee(double note, double poids) {
        return note * poids;
    }
}
