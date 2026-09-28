package editions.helene.voyer.ca.modele;

public abstract class Etudiant {
    public String nom;
    public int tp1;
    public int tp2;
    public int tp3;
    public int examenMiSession;
    public int examenFinDeSession;
    public double notePonderee;

    public Etudiant(String nom, int tp1, int tp2, int tp3, int examenMiSession, int examenFinDeSession) {
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

    public void setTp1(int unTp1) {
        this.tp1 = unTp1;
    }

    public int getTp1() {
        return this.tp1;
    }

    public void setTp2(int unTp2) {
        this.tp2 = unTp2;
    }

    public int getTp2() {
        return this.tp2;
    }

    public void setTp3(int unTp3) {
        this.tp3 = unTp3;
    }

    public int getTp3() {
        return this.tp3;
    }

    public void setExamenMiSession(int unExamenMiSession) {
        this.examenMiSession = unExamenMiSession;
    }

    public int getExamenMiSession() {
        return this.examenMiSession;
    }

    public void setExamenFinDeSession(int unExamenFinDeSession) {
        this.examenFinDeSession = unExamenFinDeSession;
    }

    public int getExamenFinDeSession() {
        return this.examenFinDeSession;
    }

    public double getNotePonderee() {
        return this.notePonderee;
    }

    public void setNotePonderee(double uneNotePonderee) {
        this.notePonderee = uneNotePonderee;
    }
}