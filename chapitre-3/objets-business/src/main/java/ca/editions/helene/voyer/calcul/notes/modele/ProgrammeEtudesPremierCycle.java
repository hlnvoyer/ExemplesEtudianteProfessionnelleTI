package ca.editions.helene.voyer.calcul.notes.modele;

import java.util.ArrayList;

import ca.editions.helene.voyer.calcul.notes.business.GestionProgrammeEtudes;

public class ProgrammeEtudesPremierCycle {
    // créé et géré par le processus métier GestionProgrammeEtudes
    private String codeProgramme;
    private String nomProgramme;
    private String domaineEtudes;
    private GestionProgrammeEtudes.CycleEnum cycle;
    
    private ArrayList<Cours> prerequis;
    private ArrayList<Cours> obligatoires;
    private ArrayList<Cours> optionnels;
    private ArrayList<Cours> libres;

    public ProgrammeEtudesPremierCycle(String codeProgramme, String nomProgramme, String domaineEtudes, 
        GestionProgrammeEtudes.CycleEnum cycle,
        ArrayList<Cours> prerequis,
        ArrayList<Cours> obligatoires, 
        ArrayList<Cours> optionnels, 
        ArrayList<Cours> libres) {
        this.codeProgramme = codeProgramme; 
        this.nomProgramme = nomProgramme;
        this.domaineEtudes = domaineEtudes;
        this.cycle = cycle;
        this.prerequis = prerequis;
        this.obligatoires = obligatoires;
        this.optionnels = optionnels;
        this.libres = libres;
    } 

    public String getCodeProgramme() {
        return codeProgramme;
    }

    public void setCodeProgramme(String codeProgramme) {
        this.codeProgramme = codeProgramme;
    }

    public String getNomProgramme() {
        return nomProgramme;
    }

    public void setNomProgramme(String nomProgramme) {
        this.nomProgramme = nomProgramme;
    }
    
    public String getDomaineEtudes() {
        return domaineEtudes;
    }

    public void setDomaineEtudes(String domaineEtudes) {
        this.domaineEtudes = domaineEtudes;
    }

    public GestionProgrammeEtudes.CycleEnum getCycle() {
        return cycle;
    }

    public void setCycle(GestionProgrammeEtudes.CycleEnum cycle) {
        this.cycle = cycle;
    }

    public ArrayList<Cours> getCoursObligatoires() {
        return obligatoires;
    }

    public void setCoursObligatoires(ArrayList<Cours> obligatoires) {
        this.obligatoires = obligatoires;
    }

    public ArrayList<Cours> getCoursOptionnels() {
        return optionnels;
    }

    public void setCoursOptionnels(ArrayList<Cours> optionnels) {
        this.optionnels = optionnels;
    }

    public ArrayList<Cours> getCoursLibres() {
        return libres;
    }   

    public void setLibres(ArrayList<Cours> libres) {
        this.libres = libres;
    }

    public ArrayList<Cours> getCoursPrerequis() {
        return prerequis;
    }   

    public void setCoursPrerequis(ArrayList<Cours> prerequis) {
        this.prerequis = prerequis;
    }
}
