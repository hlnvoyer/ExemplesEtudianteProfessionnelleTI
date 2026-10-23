package ca.editions.helene.voyer.calcul.notes.business;

import java.util.HashMap;

import ca.editions.helene.voyer.calcul.notes.modele.ProgrammeEtudesPremierCycle;
import ca.editions.helene.voyer.calcul.notes.modele.CoursPremierCycle;

public class GestionProgrammeEtudes {
    // pour gérer les programmes d'études et leurs cours associés
    static GestionProgrammeEtudes instance = null;
    static HashMap<String, ProgrammeEtudesPremierCycle> programmes = new HashMap<String, ProgrammeEtudesPremierCycle>();
    HashMap<String, CoursPremierCycle> coursObligatoires = new HashMap<String, CoursPremierCycle>();
    HashMap<String, CoursPremierCycle> coursOptionnels = new HashMap<String, CoursPremierCycle>();
    HashMap<String, CoursPremierCycle> coursLibres = new HashMap<String, CoursPremierCycle>();
    HashMap<String, CoursPremierCycle> coursPrerequis = new HashMap<String, CoursPremierCycle>();

    public static enum CycleEnum {
        PREMIER_CYCLE,
        DEUXIEME_CYCLE,
        TROISIEME_CYCLE
    }

    private GestionProgrammeEtudes() {
    }

    public static GestionProgrammeEtudes getInstance() {
        if (instance == null) {
            instance = new GestionProgrammeEtudes();
        }
        return instance;
    }

    // Implémentation pour ajouter un programme d'études avec ses cours
    // obligatoires, optionnels et libres
    public void ajouterProgramme(String codeProgramme, String nomProgramme, String domaineEtudes,
            CycleEnum cycle,
            HashMap<String, CoursPremierCycle> prerequis,
            HashMap<String, CoursPremierCycle> coursObligatoires,
            HashMap<String, CoursPremierCycle> coursOptionnels,
            HashMap<String, CoursPremierCycle> coursLibres) {
        ProgrammeEtudesPremierCycle programme = new ProgrammeEtudesPremierCycle(codeProgramme, nomProgramme,
                domaineEtudes, cycle, prerequis, coursObligatoires, coursOptionnels, coursLibres);
        programmes.put(codeProgramme, programme);
    }

    public static ProgrammeEtudesPremierCycle getProgramme(String codeProgramme) {
        if (programmes.containsKey(codeProgramme)) {
            return programmes.get(codeProgramme);
        }
        return null;
    }

    public HashMap<String, CoursPremierCycle> getCoursObligatoires(String codeProgramme) {
        if (programmes.containsKey(codeProgramme)) {
            return programmes.get(codeProgramme).getCoursObligatoires();
        }
        return null;
    }

    public void setCoursObligatoires(String codeProgramme, HashMap<String, CoursPremierCycle> coursObligatoires) {
        if (programmes.containsKey(codeProgramme)) {
            programmes.get(codeProgramme).setCoursObligatoires(coursObligatoires);
        }
    }

    public HashMap<String, CoursPremierCycle> getCoursOptionnels(String codeProgramme) {
        if (programmes.containsKey(codeProgramme)) {
            return programmes.get(codeProgramme).getCoursOptionnels();
        }
        return null;
    }

    public void setCoursOptionnels(String codeProgramme, HashMap<String, CoursPremierCycle> coursOptionnels) {
        if (programmes.containsKey(codeProgramme)) {
            programmes.get(codeProgramme).setCoursOptionnels(coursOptionnels);
        }
    }

    public HashMap<String, CoursPremierCycle> getCoursLibres(String codeProgramme) {
        if (programmes.containsKey(codeProgramme)) {
            return programmes.get(codeProgramme).getCoursLibres();
        }
        return null;
    }

    public void setCoursLibres(String codeProgramme, HashMap<String, CoursPremierCycle> coursLibres) {
        if (programmes.containsKey(codeProgramme)) {
            programmes.get(codeProgramme).setCoursLibres(coursLibres);
        }
    }

    public HashMap<String, CoursPremierCycle> getCoursPrerequis(String codeProgramme) {
        if (programmes.containsKey(codeProgramme)) {
            return programmes.get(codeProgramme).getCoursPrerequis();
        }
        return null;
    }

    public void setCoursPrerequis(String codeProgramme, HashMap<String, CoursPremierCycle> coursPrerequis) {
        if (programmes.containsKey(codeProgramme)) {
            programmes.get(codeProgramme).setCoursPrerequis(coursPrerequis);
        }
    }
}