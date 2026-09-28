package editions.helene.voyer.ca.editions.helene.voyer.ca.business;

public abstract class BaremeNotation {

  public BaremeNotation() { }  

static final BaremeNotation INSTANCE = new BaremeNotation() { };

public static BaremeNotation getInstance() {
    return INSTANCE;
}   

public enum NotationLitterale {
    A_PLUS,
    A,
    A_MINUS,
    B_PLUS,
    B,
    B_MINUS,
    C_PLUS,
    C,
    C_MINUS,
    D_PLUS,
    D,
    E
   }

  /*         
   fonctionnement par défaut sera celui du Québec
  */
    public NotationLitterale getNotationLitterale(double notePonderee) {
        NotationLitterale notationLiteraleEnum;
        if (notePonderee >= 90) { // Excellent A+
           notationLiteraleEnum = NotationLitterale.A_PLUS;
        } else if (notePonderee >= 85 && notePonderee < 90) { // Excellent A
           notationLiteraleEnum = NotationLitterale.A;
        } else if (notePonderee >= 80 && notePonderee < 85) { // Excellent A-
           notationLiteraleEnum = NotationLitterale.A_MINUS;
        } else if (notePonderee >= 77 && notePonderee < 80) { // Très bien B+
           notationLiteraleEnum = NotationLitterale.B_PLUS;
        } else if (notePonderee >= 73 && notePonderee < 77) { // Bien B
           notationLiteraleEnum = NotationLitterale.B;
        } else if (notePonderee >= 70 && notePonderee < 73) { // Bien B-
           notationLiteraleEnum = NotationLitterale.B_MINUS;
        } else if (notePonderee >= 65 && notePonderee < 70) { // Satisfaisant C+
           notationLiteraleEnum = NotationLitterale.C_PLUS;
        } else if (notePonderee >= 60 && notePonderee < 65) { // Satisfaisant C
           notationLiteraleEnum = NotationLitterale.C;
        } else if (notePonderee >= 57 && notePonderee < 60) { // Passable C-
           notationLiteraleEnum = NotationLitterale.C_MINUS;
        } else if (notePonderee >= 54 && notePonderee < 57) { // Passable D+
           notationLiteraleEnum = NotationLitterale.D_PLUS;
        } else if (notePonderee >= 50 && notePonderee < 54) { // Passable D
           notationLiteraleEnum = NotationLitterale.D;
        } else { // Échec E
           notationLiteraleEnum = NotationLitterale.E;
        }
         return notationLiteraleEnum;
    }
}
