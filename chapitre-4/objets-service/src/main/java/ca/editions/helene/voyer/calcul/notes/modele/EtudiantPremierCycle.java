package ca.editions.helene.voyer.calcul.notes.modele;

import ca.editions.helene.voyer.calcul.notes.modele.TravailPratique;
import ca.editions.helene.voyer.calcul.notes.modele.ExamenMiSession;
import ca.editions.helene.voyer.calcul.notes.modele.ExamenFinSession;

public class EtudiantPremierCycle extends Etudiant {
    public EtudiantPremierCycle(String nom, int tp1, int tp2, int tp3, int examenMiSession, int examenFinDeSession) {
        super(nom, new TravailPratique(tp1, 0.1), new TravailPratique(tp2, 0.1), new TravailPratique(tp3, 0.1),
                new ExamenMiSession(examenMiSession, 0.3), new ExamenFinSession(examenFinDeSession, 0.4));
    }
}