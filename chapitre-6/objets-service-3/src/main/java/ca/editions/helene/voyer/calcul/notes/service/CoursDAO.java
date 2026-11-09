package ca.editions.helene.voyer.calcul.notes.service;

import java.sql.Connection;
import java.sql.Statement;

import ca.editions.helene.voyer.calcul.notes.modele.CoursPremierCycle;

public class CoursDAO extends ConnexionBaseDeDonnees {
    private Connection con;

    public CoursDAO(Connection con) {
        super();
        this.con = con;
    }

    public int ajouterEtudiantInscris(String codeCours, String codePermanent) {
        String sql = "INSERT INTO etudiant_inscrits (code_cours, code_permanent) VALUES ('" + codeCours + "', '"
                + codePermanent + "');";
        System.out.println("Ajout de l'étudiant inscrit avec la requête : " + sql);
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

    public CoursPremierCycle obtenirCours(String codeProgramme, String codeCours) {
        String sql = "SELECT titre_cours, code_cours, type FROM cours WHERE code_programme = '" + codeProgramme
                + "' AND code_cours = '" + codeCours
                + "';";
        try {
            Statement stmt = con.createStatement();
            var rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return new CoursPremierCycle(
                        rs.getString("code_cours"),
                        rs.getString("titre_cours"),
                        rs.getInt("type"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
