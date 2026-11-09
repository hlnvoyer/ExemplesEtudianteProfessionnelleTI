package ca.editions.helene.voyer.calcul.notes.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionBaseDeDonnees {
    private static final String URL_BDD = "jdbc:sqlite:chapitre6.db";
    private static Connection INSTANCE = null;
    private static final String CREATE_UTILISATEUR_TABLE = "CREATE TABLE IF NOT EXISTS utilisateur (id INTEGER PRIMARY KEY, nom TEXT);";
    private static final String CREATE_PROGRAMME_TABLE = "CREATE TABLE IF NOT EXISTS programme (id INTEGER PRIMARY KEY, code_programme TEXT, nom_programme TEXT);";
    private static final String CREATE_COURS_TABLE = "CREATE TABLE IF NOT EXISTS cours (id INTEGER PRIMARY KEY, code_programme TEXT, code_cours TEXT, titre_cours TEXT, type INTEGER);";
    private static final String CREATE_ETUDIANT_TABLE = "CREATE TABLE IF NOT EXISTS etudiant (id INTEGER PRIMARY KEY, code_programme TEXT, code_cours TEXT, code_permanent TEXT, nom TEXT, tp1 REAL, tp2 REAL, tp3 REAL, examen_mi_session REAL, examen_fin_session REAL);";
    private static final String CREATE_ETUDIANT_COURS_TABLE = "CREATE TABLE IF NOT EXISTS etudiant_cours (id INTEGER PRIMARY KEY, code_programme TEXT, code_cours TEXT, code_permanent TEXT, nom TEXT, tp1 REAL, tp2 REAL, tp3 REAL, examen_mi_session REAL, examen_fin_session REAL);";
    private static final String CREATE_ETUDIANTS_ADMIS_TABLE = "CREATE TABLE IF NOT EXISTS etudiant_admis (id INTEGER PRIMARY KEY, code_programme TEXT, code_permanent TEXT);";
    private static final String CREATE_ETUDIANTS_INSCRITS_TABLE = "CREATE TABLE IF NOT EXISTS etudiant_inscrits (id INTEGER PRIMARY KEY, code_programme TEXT, code_cours TEXT, code_permanent TEXT);";

    private static Connection obtenirConnexion() {
        try {
            if (INSTANCE == null) {
                INSTANCE = DriverManager.getConnection(URL_BDD);
            }
            return INSTANCE;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Connection getInstance() {
        return INSTANCE;
    }

    public static void initialiserBaseDeDonnees() {
        boolean init = false;
        Connection con = ConnexionBaseDeDonnees.obtenirConnexion();

        if (init) {
            try {
                Statement stmt = con.createStatement();
                // Crée la table directement en SQL sans configuration complexe
                stmt.execute(CREATE_UTILISATEUR_TABLE);
                new ConnexionBaseDeDonnees().ajouterUtilisateur("Helene Voyer");
                System.out.println("Utilisateur ajouté : " + new ConnexionBaseDeDonnees().obtenirUtilisateur());

                // instancier la table des programmes
                ProgrammeDAO programmeDAO = new ProgrammeDAO(con);
                // table des programmes
                stmt.execute(CREATE_PROGRAMME_TABLE);
                programmeDAO.ajouterProgramme("7833", "Informatique");
                System.out.println("Programme ajouté : " + programmeDAO.obtenirProgramme("7833"));

                // table des cours
                stmt.execute(CREATE_COURS_TABLE);
                stmt.execute(CREATE_ETUDIANTS_ADMIS_TABLE);
                stmt.execute(CREATE_ETUDIANTS_INSCRITS_TABLE);

                programmeDAO.ajouterCoursObligatoire("7833", "INF101", "Techniques de programmation I",
                        1);
                System.out.println("Cours ajouté : " + programmeDAO.obtenirCours("7833", "INF101", 1));
                programmeDAO.ajouterCoursObligatoire("7833", "INF102", "Techniques de programmation II",
                        1);
                System.out.println("Cours ajouté : " + programmeDAO.obtenirCours("7833", "INF102", 1));
                programmeDAO.ajouterCoursObligatoire("7833", "INF103",
                        "Techniques de programmation III",
                        1);
                System.out.println("Cours ajouté : " + programmeDAO.obtenirCours("7833", "INF103", 1));
                programmeDAO.ajouterCoursObligatoire("7833", "INF201", "Structures de donnée I", 1);
                System.out.println("Cours ajouté : " + programmeDAO.obtenirCours("7833", "INF201", 1));
                programmeDAO.ajouterCoursObligatoire("7833", "INF202", "Structures de donnée II", 1);
                System.out.println("Cours ajouté : " + programmeDAO.obtenirCours("7833", "INF202", 1));

                // Ajout des cours optionnels pour le programme 7833
                programmeDAO.ajouterCoursOptionnel("7833", "INF301", "Bases de données", 2);
                System.out.println("Cours ajouté : " + programmeDAO.obtenirCours("7833", "INF301", 2));
                programmeDAO.ajouterCoursOptionnel("7833", "INF302", "Réseaux informatiques", 2);
                System.out.println("Cours ajouté : " + programmeDAO.obtenirCours("7833", "INF302", 2));
                programmeDAO.ajouterCoursOptionnel("7833", "INF303", "Sécurité informatique", 2);
                System.out.println("Cours ajouté : " + programmeDAO.obtenirCours("7833", "INF303", 2));

                // Ajout des cours Libres pour le programme 7833
                programmeDAO.ajouterCoursLibre("6524", "ESP101", "Espagnol I", 3);
                System.out.println("Cours ajouté : " + programmeDAO.obtenirCours("6524", "ESP101", 3));

                // Création de la table Etudiant
                stmt.execute(CREATE_ETUDIANT_TABLE);

                // Création de la table etudiant_cours et initialisation du DAO
                stmt.execute(CREATE_ETUDIANT_COURS_TABLE);

                // Création de la table etudiant_admis
                stmt.execute(CREATE_ETUDIANTS_ADMIS_TABLE);

                // Création de la table etudiant_inscrits
                stmt.execute(CREATE_ETUDIANTS_INSCRITS_TABLE);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println(
                    "La base de données existe déjà avec programmes, cours obligatoires, cours optionnels cours libres.");

        }
    }

    private int ajouterUtilisateur(String nom) {
        String sql = "INSERT INTO utilisateur (nom) VALUES ('" + nom + "');";
        try (Connection conn = DriverManager.getConnection(URL_BDD);
                Statement stmt = conn.createStatement()) {
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

    private String obtenirUtilisateur() {
        String nomUtilisateur = "";
        String sql = "SELECT * FROM utilisateur;";
        try (Connection conn = DriverManager.getConnection(URL_BDD);
                Statement stmt = conn.createStatement()) {
            var rs = stmt.executeQuery(sql);
            if (rs.next()) {
                nomUtilisateur = rs.getString("nom");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nomUtilisateur;
    }

}
