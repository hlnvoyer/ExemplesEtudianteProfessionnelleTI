package ca.editions.helene.voyer.calcul.notes.modele;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ModeleTest {

    @Test
    void studentStoresConstructorValuesAndUpdatesThroughAccessors() {
        EtudiantPremierCycle student = new EtudiantPremierCycle("Ada", 81, 82, 83, 84, 85);

        assertEquals("Ada", student.getNom());
        assertEquals(81, student.getTp1());
        assertEquals(82, student.getTp2());
        assertEquals(83, student.getTp3());
        assertEquals(84, student.getExamenMiSession());
        assertEquals(85, student.getExamenFinSession());
        assertEquals(0.0, student.getNotePonderee());

        student.setNom("Grace");
        student.setTp1(91);
        student.setTp2(92);
        student.setTp3(93);
        student.setExamenMiSession(94);
        student.setExamenFinSession(95);
        student.setNotePonderee(89.5);

        assertEquals("Grace", student.getNom());
        assertEquals(91, student.getTp1());
        assertEquals(92, student.getTp2());
        assertEquals(93, student.getTp3());
        assertEquals(94, student.getExamenMiSession());
        assertEquals(95, student.getExamenFinSession());
        assertEquals(89.5, student.getNotePonderee());
    }

    @Test
    void courseStoresConstructorValuesAndUpdatesThroughAccessors() {
        CoursPremierCycle course = new CoursPremierCycle("INF101", "Programmation", 3, 3, 0.3, 0.3, 0.4);

        assertEquals("INF101", course.getCodeCours());
        assertEquals("Programmation", course.getTitreCours());
        assertEquals(3, course.getUnites());
        assertEquals(3, course.getNombreDeTravauxPratiques());
        assertEquals(0.3, course.getPonderationTravauxPratique());
        assertEquals(0.3, course.getPonderationExamenMiSession());
        assertEquals(0.4, course.getPonderationExamenFinSession());

        String[] prerequisites = {"INF100"};
        course.setCodeCours("INF102");
        course.setTitreCours("Structures de donnees");
        course.setUnites(4);
        course.setNombreDeTravauxPratiques(2);
        course.setPonderationTravauxPratique(0.2);
        course.setPonderationExamenMiSession(0.35);
        course.setPonderationExamenFinSession(0.45);
        course.setPrerequis(prerequisites);

        assertEquals("INF102", course.getCodeCours());
        assertEquals("Structures de donnees", course.getTitreCours());
        assertEquals(4, course.getUnites());
        assertEquals(2, course.getNombreDeTravauxPratiques());
        assertEquals(0.2, course.getPonderationTravauxPratique());
        assertEquals(0.35, course.getPonderationExamenMiSession());
        assertEquals(0.45, course.getPonderationExamenFinSession());
        assertArrayEquals(prerequisites, course.getPrerequis());
    }

    @Test
    void defaultCourseStartsWithUnsetValues() {
        Cours course = new Cours() {
        };

        assertNull(course.getCodeCours());
        assertNull(course.getTitreCours());
        assertNull(course.getPrerequis());
        assertEquals(0, course.getUnites());
        assertEquals(0, course.getNombreDeTravauxPratiques());
        assertEquals(0.0, course.getPonderationTravauxPratique());
        assertEquals(0.0, course.getPonderationExamenMiSession());
        assertEquals(0.0, course.getPonderationExamenFinSession());
    }
}