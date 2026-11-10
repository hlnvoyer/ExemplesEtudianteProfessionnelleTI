package ca.editions.helene.voyer.calcul.notes.service;

import java.sql.Statement;
import java.sql.Connection;
import java.util.LinkedHashMap;

import ca.editions.helene.voyer.calcul.notes.modele.Etudiant;
import ca.editions.helene.voyer.calcul.notes.modele.EtudiantCours;
import ca.editions.helene.voyer.calcul.notes.modele.TravailPratique;
import ca.editions.helene.voyer.calcul.notes.modele.ExamenMiSession;
import ca.editions.helene.voyer.calcul.notes.modele.ExamenFinSession;

public class EtudiantCoursDAO extends ConnexionBaseDeDonnees {
    private Connection con;

    public EtudiantCoursDAO(Connection con) {
        super();
        this.con = con;
    }

    public int ajouterEtudiant(String codeProgramme, String codeCours, String codePermanent, String nom, double tp1,
            double tp2, double tp3,
            double examenMiSession, double examenFinSession) {
        String sql = "INSERT INTO etudiant (code_programme, code_cours, code_permanent, nom, tp1, tp2, tp3, examen_mi_session, examen_fin_session) VALUES ('"
                + codeProgramme + "', '"
                + codeCours + "', '"
                + codePermanent + "', '"
                + nom + "', "
                + tp1 + ", "
                + tp2 + ", "
                + tp3 + ", "
                + examenMiSession + ", "
                + examenFinSession + ");";
        try {
            Statement stmt = con.createStatement();
            stmt.execute(sql);
            var rs = stmt.executeQuery("SELECT last_insert_rowid() AS id;");
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public LinkedHashMap<String, EtudiantCours> obtenirListeEtudiantsCours() {
        LinkedHashMap<String, EtudiantCours> etudiants = new LinkedHashMap<String, EtudiantCours>();
        String sql = "SELECT * FROM etudiant ORDER BY code_programme, code_cours, code_permanent asc;";
        try {
            Statement stmt = con.createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String codeProgramme = rs.getString("code_programme");
                String codeCours = rs.getString("code_cours");
                String codePermanent = rs.getString("code_permanent");
                String nom = rs.getString("nom");
                double tp1 = rs.getDouble("tp1");
                double tp2 = rs.getDouble("tp2");
                double tp3 = rs.getDouble("tp3");
                double examenMiSession = rs.getDouble("examen_mi_session");
                double examenFinSession = rs.getDouble("examen_fin_session");
                // EtudiantCours etudiant = new EtudiantCours(codePermanent, nom, prenom);
                // etudiants.put(codePermanent, etudiant);
                EtudiantCours etudiantCours = new EtudiantCours(codeProgramme, codeCours, codePermanent, nom);
                Etudiant etudiant = new Etudiant(codePermanent, new TravailPratique(tp1, 0.1),
                        new TravailPratique(tp2, 0.1),
                        new TravailPratique(tp3, 0.1), new ExamenMiSession(examenMiSession, 0.3),
                        new ExamenFinSession(examenFinSession, 0.4));
                etudiantCours.setEtudiant(etudiant);
                etudiants.put(codePermanent, etudiantCours);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return etudiants;
    }
}