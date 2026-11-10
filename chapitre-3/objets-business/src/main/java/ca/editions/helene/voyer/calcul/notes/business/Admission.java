package ca.editions.helene.voyer.calcul.notes.business;

import java.util.HashMap;

import ca.editions.helene.voyer.calcul.notes.modele.EtudiantCours;

public class Admission {
    static HashMap<String, HashMap<String, EtudiantCours>> etudiantsAdmis = new HashMap<String, HashMap<String, EtudiantCours>>();

    public Admission() {
    }

    static final Admission INSTANCE = new Admission();

    public static Admission getInstance() {
        return INSTANCE;
    }

    // code permanent ici au Québec ça identifie un étudiant du secondaire
    // jusqu'au doctorat.
    public EtudiantCours admettre(String codeProgramme, EtudiantCours etudiant) {
        // manque la vérification que le code permanent de l'étudiant est déjà dans la
        // liste
        // si oui, message sur la console
        // si non, on l'ajoute à la liste
        Admission admission = Admission.getInstance();
        HashMap<String, HashMap<String, EtudiantCours>> etudiantsAdmis = (HashMap<String, HashMap<String, EtudiantCours>>) admission
                .getEtudiantsAdmis(codeProgramme);
        if (!etudiantsAdmis.containsKey(codeProgramme)) {
            etudiantsAdmis.put(codeProgramme, new HashMap<String, EtudiantCours>());
        }
        HashMap<String, EtudiantCours> etudiantsProgramme = etudiantsAdmis.get(codeProgramme);
        if (!etudiantsProgramme.containsKey(etudiant.getCodePermanent())) {
            etudiantsProgramme.put(etudiant.getCodePermanent(), etudiant);
        } else {
            System.out.println("L'étudiant est déjà admis.");
        }
        return etudiant;
    }

    public HashMap<String, HashMap<String, EtudiantCours>> getEtudiantsAdmis(String codeProgramme) {
        return etudiantsAdmis;
    }

    public void setEtudiantsAdmis(HashMap<String, HashMap<String, EtudiantCours>> etudiantsAdmis) {
        Admission.etudiantsAdmis = etudiantsAdmis;
    }
}
