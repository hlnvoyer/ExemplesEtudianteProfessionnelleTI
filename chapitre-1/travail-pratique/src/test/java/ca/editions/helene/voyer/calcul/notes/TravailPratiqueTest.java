package ca.editions.helene.voyer.calcul.notes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

class TravailPratiqueTest {

    @Test
    void mainPrintsWeightedGradesAndClassAverage() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOutput = System.out;

        try (PrintStream capturedOutput = new PrintStream(output, true, StandardCharsets.UTF_8)) {
            System.setOut(capturedOutput);
            TravailPratique.main(new String[0]);
        } finally {
            System.setOut(originalOutput);
        }

        String result = output.toString(StandardCharsets.UTF_8);
        assertTrue(result.contains(
                "La note ponderee deEtudiant 1  est 79.5 et la notation literale est : B+ B_PLUS"));
        assertEquals(31, result.lines().count());
        assertTrue(result.contains("La moyenne des notes ponderees est "));
    }
}