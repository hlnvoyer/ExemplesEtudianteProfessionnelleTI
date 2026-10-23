package ca.editions.helene.voyer.calcul.notes.modele;

public class EtudiantCours {
    // créé et géré par le processus métier Inscription
    private String codePermanent;
    public String nom;
    private String codeProgramme;
    private String codeCours;
    private Etudiant etudiant;

    public EtudiantCours(String codePermanent, String nom, String codeProgramme, String codeCours) {
        this.codePermanent = codePermanent;
        this.nom = nom;
        this.codeProgramme = codeProgramme;
        this.codeCours = codeCours;
    }

    public Etudiant getEtudiant() {
        return this.etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public String getCodePermanent() {
        return this.codePermanent;
    }

    public void setCodePermanent(String unCodePermanent) {
        this.codePermanent = unCodePermanent;
    }

    public void setNom(String unNom) {
        this.nom = unNom;
    }

    public String getNom() {
        return this.nom;
    }

    public String getCodeProgramme() {
        return this.codeProgramme;
    }

    public void setCodeProgramme(String unCodeProgramme) {
        this.codeProgramme = unCodeProgramme;
    }

    public String getCodeCours() {
        return this.codeCours;
    }

    public void setCodeCours(String unCodeCours) {
        this.codeCours = unCodeCours;
    }
}