package ca.editions.helene.voyer.calcul.notes.business;

import java.util.HashMap;
import ca.editions.helene.voyer.calcul.notes.modele.CoursPremierCycle;

import ca.editions.helene.voyer.calcul.notes.modele.EtudiantCours;
import ca.editions.helene.voyer.calcul.notes.modele.ProgrammeEtudesPremierCycle;

public class Inscription {
    static Inscription instance = null;
    static HashMap<String, EtudiantCours> etudiantsInscrits = new HashMap<String, EtudiantCours>();

    private Inscription() {
    }

    public static Inscription getInstance() {
        if (instance == null) {
            instance = new Inscription();
        }
        return instance;
    }

    public EtudiantCours inscrire(String codeProgramme, String codeCours,
            EtudiantCours etudiant) {
        GestionProgrammeEtudes gestionProgramme = GestionProgrammeEtudes.getInstance();
        HashMap<String, CoursPremierCycle> coursObligatoires = (HashMap<String, CoursPremierCycle>) gestionProgramme
                .getCoursObligatoires(codeProgramme);
        HashMap<String, CoursPremierCycle> coursOptionnels = (HashMap<String, CoursPremierCycle>) gestionProgramme
                .getCoursOptionnels(codeProgramme);
        HashMap<String, CoursPremierCycle> coursLibres = (HashMap<String, CoursPremierCycle>) gestionProgramme
                .getCoursLibres(codeProgramme);
        HashMap<String, CoursPremierCycle> coursPrerequis = (HashMap<String, CoursPremierCycle>) gestionProgramme
                .getCoursPrerequis(codeProgramme);
        // Inscrire l'étudiant et retourner l'objet étudiant inscrit
        // manque la vérification que le code permanent de l'étudiant
        // est dans la liste des étudiants admis
        // si oui, mettre un message sur la console
        // si non, l'ajouter à la liste
        Admission admission = Admission.getInstance();
        HashMap<String, HashMap<String, EtudiantCours>> etudiantsAdmis = admission.getEtudiantsAdmis(codeProgramme);
        // vérifier si le programme existe, si oui vérifier si l'étudiant est admis au
        // programme
        // avant de l'inscrire au cours
        if (!etudiantsAdmis.containsKey(codeProgramme)
                || !etudiantsAdmis.get(codeProgramme).containsKey(etudiant.getCodePermanent())) {
            System.out.println("L'étudiant n'est pas admis. Donc on ne peut l'inscrire à ce cours.");
            // vérifier que le cours existe pour le programme

        } else {
            ProgrammeEtudesPremierCycle programme = (ProgrammeEtudesPremierCycle) GestionProgrammeEtudes
                    .getProgramme(codeProgramme);
            if (programme == null) {
                System.out.println("Le programme n'existe pas. Donc on ne peut l'inscrire à ce cours.");
                return etudiant;
            } else {
                if (!coursObligatoires.containsKey(codeCours) &&
                        !coursOptionnels.containsKey(codeCours) &&
                        !coursLibres.containsKey(codeCours) &&
                        !coursPrerequis.containsKey(codeCours)) {
                    System.out.println("Le cours n'existe pas pour ce programme.");
                }
            }

            System.out.println("L'étudiant est admis. + " + etudiant.getCodePermanent() + " " +
                    etudiant.getNom() + " On l'inscrit au cours : " + codeCours);
            etudiantsInscrits.put(etudiant.getCodePermanent(), etudiant);
        }
        return etudiant;
    }

    public HashMap<String, EtudiantCours> getEtudiantsInscrits() {
        return new HashMap<String, EtudiantCours>(etudiantsInscrits);
    }
}
