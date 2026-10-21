package ca.editions.helene.voyer.calcul.notes.service;

public class AnalyseDossierEtudiant {
    static AnalyseDossierEtudiant instance = null;

    private AnalyseDossierEtudiant() {
    }

    public static AnalyseDossierEtudiant getInstance() {
        if (instance == null) {
            instance = new AnalyseDossierEtudiant();
        }
        return instance;
    }

    // écrire les données

    // lire les données

}
