package ca.editions.helene.voyer.calcul.notes.business;

import java.util.ArrayList;

import ca.editions.helene.voyer.calcul.notes.modele.Cours;
import ca.editions.helene.voyer.calcul.notes.modele.ProgrammeEtudesPremierCycle;

public class GestionProgrammeEtudes {
    static GestionProgrammeEtudes instance = null;
    static ArrayList<ProgrammeEtudesPremierCycle> programmes = new ArrayList<ProgrammeEtudesPremierCycle>();
    
    
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

    // Implémentation pour ajouter un programme d'études avec ses cours obligatoires, optionnels et libres
    public void ajouterProgramme(String codeProgramme, String nomProgramme, String domaineEtudes, 
            CycleEnum cycle, 
            ArrayList<Cours> prerequis,
            ArrayList<Cours> coursObligatoires, 
            ArrayList<Cours> coursOptionnels,
            ArrayList<Cours> coursLibres) {
        ProgrammeEtudesPremierCycle programme = new ProgrammeEtudesPremierCycle(codeProgramme, nomProgramme, 
            domaineEtudes, cycle, prerequis, coursObligatoires, coursOptionnels, coursLibres);
        programmes.add(programme);
    }

    public ArrayList<Cours> getCoursObligatoires(String codeProgramme) {
        ArrayList<Cours> obligatoires = new ArrayList<Cours>();
        for (ProgrammeEtudesPremierCycle programme : programmes) {
            if (programme.getCodeProgramme().equals(codeProgramme)) {
                obligatoires = programme.getCoursObligatoires();
                break;
            }
        }
        return obligatoires;
    }

    public void setCoursObligatoires(String codeProgramme, ArrayList<Cours> coursObligatoires) {
        for (ProgrammeEtudesPremierCycle programme : programmes) {
            if (programme.getCodeProgramme().equals(codeProgramme)) {
                programme.setCoursObligatoires(coursObligatoires);
                break;
            }
        }   
    }

    public ArrayList<Cours> getCoursOptionnels(String codeProgramme) {
        return new ArrayList<Cours>();
    }   

    public ArrayList<Cours> getCoursLibres(String codeProgramme) {
        return new ArrayList<Cours>();
    }
    
    public ArrayList<Cours> getCoursPrerequis(String codeProgramme) {
        return new ArrayList<Cours>();
    }




}
