package ca.editions.helene.voyer.calcul.notes.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import ca.editions.helene.voyer.calcul.notes.modele.Etudiant;
import ca.editions.helene.voyer.calcul.notes.modele.EtudiantPremierCycle;

class FabriquesTest {

    @Test
    void studentFactoryIsSingletonAndCreatesStudentsFromArguments() {
        FabriqueEtudiant factory = FabriqueEtudiant.getInstance();
        EtudiantPremierCycle student = factory.create("Ada", 81, 82, 83, 84, 85);

        assertSame(factory, FabriqueEtudiant.getInstance());
        assertEquals("Ada", student.getNom());
        assertEquals(81, student.getTp1());
        assertEquals(82, student.getTp2());
        assertEquals(83, student.getTp3());
        assertEquals(84, student.getExamenMiSession());
        assertEquals(85, student.getExamenFinSession());
    }

    @Test
    void linkedListFactoryCreatesThirtyOrderedStudents() {
        FabriqueListeChaineeEtudiant factory = FabriqueListeChaineeEtudiant.getInstance();
        LinkedList<Etudiant> students = factory.createListeChaineeEtudiants();

        assertSame(factory, FabriqueListeChaineeEtudiant.getInstance());
        assertEquals(30, students.size());
        assertEquals("Etudiant 1 ", students.getFirst().getNom());
        assertEquals(75, students.getFirst().getTp1());
        assertEquals("Etudiant 30 ", students.getLast().getNom());
        assertNotSame(students, factory.createListeChaineeEtudiants());
    }

    @Test
    void fileStudentFactoryCreatesThirtyOrderedStudents() {
        FabriqueFichierEtudiant factory = FabriqueFichierEtudiant.getInstance();
        LinkedList<Etudiant> students = factory.createListeChaineeEtudiants();

        assertSame(factory, FabriqueFichierEtudiant.getInstance());
        assertEquals(30, students.size());
        assertEquals("Etudiant 1 ", students.getFirst().getNom());
        assertEquals("Etudiant 30 ", students.getLast().getNom());
        assertNotSame(students, factory.createListeChaineeEtudiants());
    }

    @Test
    void courseFileFactoryIsSingleton() {
        assertSame(FabriqueFichierCours.getInstance(), FabriqueFichierCours.getInstance());
    }
}