package ca.editions.helene.voyer.calcul.notes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class TravailPratiqueFichierSequentielTest {

    @Test
    void mainPrintsWeightedComponentsAndCourseAverage(@TempDir Path workingDirectory)
            throws IOException, InterruptedException {
        String executable = System.getProperty("os.name").toLowerCase(Locale.ROOT).contains("win")
                ? "java.exe"
                : "java";
        Path java = Path.of(System.getProperty("java.home"), "bin", executable);
        Path outputFile = workingDirectory.resolve("application-output.txt");
        Process process = new ProcessBuilder(
                java.toString(),
                "-cp",
                System.getProperty("java.class.path"),
                TravailPratiqueFichierSequentiel.class.getName())
                .directory(workingDirectory.toFile())
                .redirectErrorStream(true)
                .redirectOutput(outputFile.toFile())
                .start();

        boolean completed = process.waitFor(10, TimeUnit.SECONDS);
        if (!completed) {
            process.destroyForcibly().waitFor();
        }
        assertTrue(completed, "The application should finish promptly");
        Charset outputCharset = Charset.forName(
            System.getProperty("stdout.encoding", StandardCharsets.UTF_8.name()));
        String output = Files.readString(outputFile, outputCharset);

        assertEquals(0, process.exitValue());
        assertTrue(output.contains("Note du premier travail pratique pour Etudiant 1  : 75.0"));
        assertTrue(output.contains("La note ponderee de 79.5 est 79.5"), output);
        assertEquals(301, output.lines().count());
        assertTrue(output.contains("La moyenne des notes ponderees est "));
        assertTrue(Files.exists(workingDirectory.resolve("cours.txt")));
    }
}