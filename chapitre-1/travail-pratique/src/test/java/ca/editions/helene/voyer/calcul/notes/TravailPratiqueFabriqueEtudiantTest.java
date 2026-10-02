package ca.editions.helene.voyer.calcul.notes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class TravailPratiqueFabriqueEtudiantTest {

    @Test
    void mainCalculatesWeightedGradesAndAverage(@TempDir Path workingDirectory)
            throws IOException, InterruptedException {
        String executable = System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("win")
                ? "java.exe"
                : "java";
        Path java = Path.of(System.getProperty("java.home"), "bin", executable);
        Process process = new ProcessBuilder(
                java.toString(),
                "-cp",
                System.getProperty("java.class.path"),
                TravailPratiqueFabriqueEtudiant.class.getName())
                .directory(workingDirectory.toFile())
                .redirectErrorStream(true)
                .start();

        assertTrue(process.waitFor(10, TimeUnit.SECONDS), "The application should finish promptly");
        String output = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);

        assertEquals(0, process.exitValue());
        assertTrue(output.contains("La note ponderee de 58.354 est 58.354"), output);
        assertEquals(31, output.lines().count());
        assertTrue(output.contains("La moyenne des notes ponderees est "));
        assertTrue(Files.exists(workingDirectory.resolve("cours.txt")));
    }
}