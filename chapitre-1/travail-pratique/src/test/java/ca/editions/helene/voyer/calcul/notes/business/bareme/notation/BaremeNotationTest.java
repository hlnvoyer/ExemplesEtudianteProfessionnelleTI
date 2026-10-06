package ca.editions.helene.voyer.calcul.notes.business.bareme.notation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class BaremeNotationTest {

    @Test
    void mapsWeightedGradesAtEachLetterGradeBoundary() {
        BaremeNotation notation = BaremeNotation.getInstance();

        assertEquals(BaremeNotation.NotationLitterale.A_PLUS, notation.getNotationLitterale(90));
        assertEquals(BaremeNotation.NotationLitterale.A, notation.getNotationLitterale(85));
        assertEquals(BaremeNotation.NotationLitterale.A_MINUS, notation.getNotationLitterale(80));
        assertEquals(BaremeNotation.NotationLitterale.B_PLUS, notation.getNotationLitterale(77));
        assertEquals(BaremeNotation.NotationLitterale.B, notation.getNotationLitterale(73));
        assertEquals(BaremeNotation.NotationLitterale.B_MINUS, notation.getNotationLitterale(70));
        assertEquals(BaremeNotation.NotationLitterale.C_PLUS, notation.getNotationLitterale(65));
        assertEquals(BaremeNotation.NotationLitterale.C, notation.getNotationLitterale(60));
        assertEquals(BaremeNotation.NotationLitterale.C_MINUS, notation.getNotationLitterale(57));
        assertEquals(BaremeNotation.NotationLitterale.D_PLUS, notation.getNotationLitterale(54));
        assertEquals(BaremeNotation.NotationLitterale.D, notation.getNotationLitterale(50));
        assertEquals(BaremeNotation.NotationLitterale.E, notation.getNotationLitterale(49.99));
    }

    @Test
    void returnsTheSameDefaultInstance() {
        assertSame(BaremeNotation.getInstance(), BaremeNotation.getInstance());
    }

    @Test
    void mapsExcellentGradesAndReturnsNoneBelowItsRange() {
        NotationExcellent notation = NotationExcellent.getInstance();

        assertEquals(BaremeNotation.NotationLitterale.A_PLUS, notation.getNotationLitterale(90));
        assertEquals(BaremeNotation.NotationLitterale.A, notation.getNotationLitterale(85));
        assertEquals(BaremeNotation.NotationLitterale.A_MINUS, notation.getNotationLitterale(80));
        assertEquals(BaremeNotation.NotationLitterale.AUCUN, notation.getNotationLitterale(79.99));
        assertSame(notation, NotationExcellent.getInstance());
    }

    @Test
    void mapsVeryGoodGradesAndReturnsNoneBelowItsRange() {
        NotationTresBien notation = NotationTresBien.getInstance();

        assertEquals(BaremeNotation.NotationLitterale.B_PLUS, notation.getNotationLitterale(80));
        assertEquals(BaremeNotation.NotationLitterale.B, notation.getNotationLitterale(75));
        assertEquals(BaremeNotation.NotationLitterale.B_MINUS, notation.getNotationLitterale(70));
        assertEquals(BaremeNotation.NotationLitterale.AUCUN, notation.getNotationLitterale(69.99));
        assertSame(notation, NotationTresBien.getInstance());
    }

    @Test
    void mapsSatisfactoryGradesAndReturnsNoneBelowItsRange() {
        NotationSatisfaisant notation = new NotationSatisfaisant();

        assertEquals(BaremeNotation.NotationLitterale.C, notation.getNotationLitterale(60));
        assertEquals(BaremeNotation.NotationLitterale.C_MINUS, notation.getNotationLitterale(55));
        assertEquals(BaremeNotation.NotationLitterale.AUCUN, notation.getNotationLitterale(54.99));
    }

    @Test
    void mapsPassingGradesAndReturnsNoneBelowItsRange() {
        NotationPassable notation = new NotationPassable();

        assertEquals(BaremeNotation.NotationLitterale.D, notation.getNotationLitterale(50));
        assertEquals(BaremeNotation.NotationLitterale.D_MINUS, notation.getNotationLitterale(45));
        assertEquals(BaremeNotation.NotationLitterale.AUCUN, notation.getNotationLitterale(44.99));
    }

    @Test
    void mapsFailingGradesThroughThePassingBoundary() {
        NotationEchec notation = NotationEchec.getInstance();

        assertEquals(BaremeNotation.NotationLitterale.E, notation.getNotationLitterale(50));
        assertEquals(BaremeNotation.NotationLitterale.E, notation.getNotationLitterale(0));
        assertEquals(BaremeNotation.NotationLitterale.AUCUN, notation.getNotationLitterale(50.01));
        assertSame(notation, NotationEchec.getInstance());
    }
}