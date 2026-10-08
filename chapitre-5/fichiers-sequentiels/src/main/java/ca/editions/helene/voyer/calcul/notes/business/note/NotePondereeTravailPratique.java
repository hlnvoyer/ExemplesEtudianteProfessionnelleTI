package ca.editions.helene.voyer.calcul.notes.business.note;

public class NotePondereeTravailPratique extends NotePonderee {

    @Override
    public double calculerNotePonderee(double note, double poids) {
        return note * poids;
    }

}
