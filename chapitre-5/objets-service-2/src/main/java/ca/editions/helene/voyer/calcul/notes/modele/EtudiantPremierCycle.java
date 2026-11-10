package ca.editions.helene.voyer.calcul.notes.modele;

public class EtudiantPremierCycle {
    //  créé et géré par le processus métier Admission
    private String codePermanent;
    private String codeProgramme;

    public EtudiantPremierCycle(String leCodePermanent, String leCodeProgramme) {
        this.codePermanent = leCodePermanent;
        this.codeProgramme = leCodeProgramme;
    }

    public String getCodePermanent() { 
        return codePermanent;
    }

    public void setCodePermanent(String codePermanent) {
        this.codePermanent = codePermanent;
    }
    public String getCodeProgramme() {
        return codeProgramme;
    }

    public void setCodeProgramme(String codeProgramme) {
        this.codeProgramme = codeProgramme;
    }
}   