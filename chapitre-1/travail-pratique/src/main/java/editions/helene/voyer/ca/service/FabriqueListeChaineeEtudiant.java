package editions.helene.voyer.ca.service;

import java.util.LinkedList;
import editions.helene.voyer.ca.modele.Etudiant;

public class FabriqueListeChaineeEtudiant {
    static FabriqueListeChaineeEtudiant instance = null;

    private FabriqueListeChaineeEtudiant() {
    }

    public static FabriqueListeChaineeEtudiant getInstance() {
        if (instance == null) {
            instance = new FabriqueListeChaineeEtudiant();
        }
        return instance;
    }

    public LinkedList<Etudiant> createListeChaineeEtudiants() {
        LinkedList<Etudiant> listeChaineeEtudiants = new LinkedList<>();
        FabriqueEtudiant fabrique = FabriqueEtudiant.getInstance();
        listeChaineeEtudiants.add(fabrique.create("Etudiant 1 ", 75, 55, 88, 79, 85));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 2 ", 65, 75, 78, 74, 81));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 3 ", 85, 90, 80, 70, 95));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 4 ", 90, 85, 75, 80, 88));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 5 ", 70, 80, 85, 75, 90));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 6 ", 95, 85, 88, 80, 85));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 7 ", 80, 71, 85, 90, 95));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 8 ", 85, 80, 87, 85, 80));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 9 ", 71, 85, 80, 90, 95));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 10 ", 80, 78, 85, 75, 88));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 11 ", 75, 55, 88, 79, 85));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 12 ", 90, 80, 78, 85, 90));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 13 ", 75, 55, 88, 79, 85));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 14 ", 80, 85, 82, 87, 88));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 15 ", 85, 80, 84, 90, 92));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 16 ", 80, 82, 85, 88, 90));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 17 ", 85, 85, 80, 90, 95));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 18 ", 80, 80, 85, 85, 90));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 19 ", 85, 82, 80, 88, 90));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 20 ", 80, 85, 82, 87, 88));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 21 ", 85, 80, 84, 90, 92));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 22 ", 80, 82, 85, 88, 90));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 23 ", 75, 55, 88, 79, 85));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 24 ", 80, 80, 85, 85, 90));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 25 ", 75, 55, 88, 79, 85));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 26 ", 80, 85, 82, 87, 88));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 27 ", 85, 80, 84, 90, 92));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 28 ", 80, 82, 85, 88, 90));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 29 ", 85, 85, 80, 90, 95));
        listeChaineeEtudiants.add(fabrique.create("Etudiant 30 ", 80, 80, 85, 85, 90));
        return listeChaineeEtudiants;
    }
}
