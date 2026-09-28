package editions.helene.voyer.ca.service;

import editions.helene.voyer.ca.modele.EtudiantPremierCycle;

public class FabriqueEtudiant {
    public FabriqueEtudiant() {
    }

    static final FabriqueEtudiant INSTANCE = new FabriqueEtudiant();

    public static FabriqueEtudiant getInstance() {
        return INSTANCE;
    }

    public EtudiantPremierCycle create(String nom, int tp1, int tp2, int tp3, int examenMiSession,
            int examenFinSession) {
        return new EtudiantPremierCycle(nom, tp1, tp2, tp3, examenMiSession, examenFinSession);
    }
}
