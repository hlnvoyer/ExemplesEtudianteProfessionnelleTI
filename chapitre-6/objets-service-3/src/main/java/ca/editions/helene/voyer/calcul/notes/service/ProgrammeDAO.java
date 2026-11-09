package ca.editions.helene.voyer.calcul.notes.service;

import java.sql.Connection;
import java.sql.Statement;

public class ProgrammeDAO extends ConnexionBaseDeDonnees {
    private Connection con;

    public ProgrammeDAO(Connection con) {
        super();
        this.con = con;
    }

    public int ajouterProgramme(String codeProgramme, String titre) {
        String sql = "INSERT INTO programme (code_programme, nom_programme) VALUES ('" + codeProgramme + "', '" + titre
                + "');";
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

    public String obtenirProgramme(String codeProgramme) {
        String nomProgramme = "";
        String sql = "SELECT nom_programme FROM programme WHERE code_programme = '" + codeProgramme + "';";
        try {
            Statement stmt = con.createStatement();
            var rs = stmt.executeQuery(sql);
            if (rs.next()) {
                nomProgramme = rs.getString("nom_programme");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nomProgramme;
    }

    public int ajouterCoursObligatoire(String codeProgramme, String codeCours, String titre, int type) {
        String sql = "INSERT INTO cours (code_programme, code_cours, titre_cours, type) VALUES ('" + codeProgramme
                + "', '"
                + codeCours + "', '" + titre + "', " + type + ");";
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

    public int ajouterCoursOptionnel(String codeProgramme, String codeCours, String titre, int type) {
        String sql = "INSERT INTO cours (code_programme, code_cours, titre_cours, type) VALUES ('" + codeProgramme
                + "', '"
                + codeCours + "', '" + titre + "', " + type + "  );";
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

    public int ajouterCoursLibre(String codeProgramme, String codeCours, String titre, int type) {
        String sql = "INSERT INTO cours (code_programme, code_cours, titre_cours, type) VALUES ('" + codeProgramme
                + "', '"
                + codeCours + "', '" + titre + "', " + type + "  );";
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

    public String obtenirCours(String codeProgramme, String codeCours, int type) {
        String nomCours = "";
        String sql = "SELECT * FROM cours WHERE code_programme = '" + codeProgramme + "' AND code_cours = '" + codeCours
                + "' AND type = " + type + ";";
        try {
            Statement stmt = con.createStatement();
            var rs = stmt.executeQuery(sql);
            if (rs.next()) {
                nomCours = rs.getString("titre_cours");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nomCours;
    }
}