package ca.editions.helene.voyer.calcul.notes.modele;

public class EtudiantPremierCycle extends Etudiant {
    public String nom;

    // chaque cours n'a pas nécessairement 3 travail pratiques
    // comment on peut refactoriser pour permettre un nombre 
    // variable de travaux pratiques ?
    public TravailPratique tp1;
    public TravailPratique tp2;
    public TravailPratique tp3;
    public ExamenMiSession examenMiSession;
    public ExamenFinSession examenFinDeSession;
    public double notePonderee;

    public EtudiantPremierCycle(String nom, TravailPratique tp1, TravailPratique tp2, 
    TravailPratique tp3, ExamenMiSession examenMiSession, ExamenFinSession examenFinDeSession) {
        super(nom, tp1, tp2, tp3, examenMiSession, examenFinDeSession);
        this.nom = nom;
        this.tp1 = tp1;
        this.tp2 = tp2;
        this.tp3 = tp3;
        this.examenMiSession = examenMiSession;
        this.examenFinDeSession = examenFinDeSession;
    }

    public String getNom() {
        return nom;
    }

    public TravailPratique getTp1() {
        return tp1;
    }

    public TravailPratique getTp2() {
        return tp2;
    }

    public TravailPratique getTp3() {
        return tp3;
    }

    public ExamenMiSession getExamenMiSession() {
        return examenMiSession;
    }

    public ExamenFinSession getExamenFinDeSession() {
        return examenFinDeSession;
    }   
}