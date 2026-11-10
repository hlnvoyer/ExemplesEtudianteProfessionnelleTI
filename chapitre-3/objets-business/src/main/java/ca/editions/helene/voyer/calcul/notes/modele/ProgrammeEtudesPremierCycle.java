package ca.editions.helene.voyer.calcul.notes.modele;

import java.util.HashMap;

import ca.editions.helene.voyer.calcul.notes.business.GestionProgrammeEtudes;

public class ProgrammeEtudesPremierCycle {
    // créé et géré par le processus métier GestionProgrammeEtudes
    private String codeProgramme;
    private String nomProgramme;
    private String domaineEtudes;
    private GestionProgrammeEtudes.CycleEnum cycle;

    private HashMap<String, CoursPremierCycle> prerequis;
    private HashMap<String, CoursPremierCycle> obligatoires;
    private HashMap<String, CoursPremierCycle> optionnels;
    private HashMap<String, CoursPremierCycle> libres;

    public ProgrammeEtudesPremierCycle(String codeProgramme, String nomProgramme,
            String domaineEtudes,
            GestionProgrammeEtudes.CycleEnum cycle,
            HashMap<String, CoursPremierCycle> prerequis,
            HashMap<String, CoursPremierCycle> obligatoires,
            HashMap<String, CoursPremierCycle> optionnels,
            HashMap<String, CoursPremierCycle> libres) {
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

    public HashMap<String, CoursPremierCycle> getCoursObligatoires() {
        return obligatoires;
    }

    public void setCoursObligatoires(HashMap<String, CoursPremierCycle> obligatoires) {
        this.obligatoires = obligatoires;
    }

    public HashMap<String, CoursPremierCycle> getCoursOptionnels() {
        return optionnels;
    }

    public void setCoursOptionnels(HashMap<String, CoursPremierCycle> optionnels) {
        this.optionnels = optionnels;
    }

    public HashMap<String, CoursPremierCycle> getCoursLibres() {
        return libres;
    }

    public void setCoursLibres(HashMap<String, CoursPremierCycle> libres) {
        this.libres = libres;
    }

    public HashMap<String, CoursPremierCycle> getCoursPrerequis() {
        return prerequis;
    }

    public void setCoursPrerequis(HashMap<String, CoursPremierCycle> prerequis) {
        this.prerequis = prerequis;
    }
}
