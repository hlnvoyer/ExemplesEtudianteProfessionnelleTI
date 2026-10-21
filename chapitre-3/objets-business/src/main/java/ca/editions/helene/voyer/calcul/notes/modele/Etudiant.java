package ca.editions.helene.voyer.calcul.notes.modele;

public class Etudiant {
    // le contenu de cette classe est appropriée pour le travail pratique mais pas
    // pour notre
    // solution logicielle professionnelle
    public String nom;
    public TravailPratique tp1;
    public TravailPratique tp2;
    public TravailPratique tp3;
    public ExamenMiSession examenMiSession;
    public ExamenFinSession examenFinDeSession;
    public double notePonderee;

    public Etudiant(String nom, TravailPratique tp1, TravailPratique tp2, 
        TravailPratique tp3, ExamenMiSession examenMiSession, ExamenFinSession examenFinDeSession) {
        this.nom = nom;
        this.tp1 = tp1;
        this.tp2 = tp2;
        this.tp3 = tp3;
        this.examenMiSession = examenMiSession;
        this.examenFinDeSession = examenFinDeSession;
    }

    public void setNom(String unNom) {
        this.nom = unNom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setTp1(TravailPratique unTp1) {
        this.tp1 = unTp1;
    }

    public TravailPratique getTp1() {
        return this.tp1;
    }

    public void setTp2(TravailPratique unTp2) {
        this.tp2 = unTp2;
    }

    public TravailPratique getTp2() {
        return this.tp2;
    }

    public void setTp3(TravailPratique unTp3) {
        this.tp3 = unTp3;
    }

    public TravailPratique getTp3() {
        return this.tp3;
    }

    public void setExamenMiSession(ExamenMiSession unExamenMiSession) {
        this.examenMiSession = unExamenMiSession;
    }

    public ExamenMiSession getExamenMiSession() {
        return this.examenMiSession;
    }

    public void setExamenFinSession(ExamenFinSession unExamenFinDeSession) {
        this.examenFinDeSession = unExamenFinDeSession;
    }

    public ExamenFinSession getExamenFinSession() {
        return this.examenFinDeSession;
    }

    public double getNotePonderee() {
        return this.notePonderee;
    }

    public void setNotePonderee(double uneNotePonderee) {
        this.notePonderee = uneNotePonderee;
    }
}