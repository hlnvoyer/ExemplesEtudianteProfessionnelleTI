package ca.editions.helene.voyer.calcul.notes.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Statement;
import java.sql.Connection;

public class EtudiantAdmisDAO {
    private Connection con;

    public EtudiantAdmisDAO(Connection con) {
        this.con = con;
    }

    public int ajouterEtudiantsAdmis(String codeProgramme, String codePermanent) {
        String sql = "INSERT INTO etudiant_admis (code_programme, code_permanent) VALUES ('"
                + codeProgramme
                + "', '"
                + codePermanent + "');";
        System.out.println("Ajout de l'étudiant admis avec la requête : " + sql);
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

    public ArrayList<String> obtenirListeEtudiantAdmis(String codeProgramme) {
        HashMap<String, String> etudiantsAdmis = new HashMap<String, String>();
        String sql = "SELECT * FROM etudiant_admis WHERE code_programme = '" + codeProgramme + "';";
        try {
            Statement stmt = con.createStatement();
            var rs = stmt.executeQuery(sql);
            while (rs.next()) {
                etudiantsAdmis.put(rs.getString("code_permanent"), rs.getString("nom") + " " + rs.getString("prenom"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>(etudiantsAdmis.values());
    }

    public int obtenirEtudiantAdmis(String codeProgramme, String codePermanent) {
        String sql = "SELECT * FROM etudiant_admis WHERE code_programme = '" + codeProgramme
                + "' AND code_permanent = '"
                + codePermanent + "';";
        try {
            Statement stmt = con.createStatement();
            var rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}