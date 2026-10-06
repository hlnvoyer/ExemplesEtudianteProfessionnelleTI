package ca.editions.helene.voyer.calcul.notes.business.note;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NotesPondereesTest {

    @Test
    void midtermExamCalculatesAndUpdatesPercentage() {
        NoteExamenMiSession exam = new NoteExamenMiSession(100, 75);

        assertEquals(100, exam.getMaximumPoints());
        assertEquals(75, exam.getNote());
        assertEquals(75, exam.getNotePourcentage());
        assertEquals(75, exam.getPoidsNoteFinale());

        exam.setNote(80);
        assertEquals(80, exam.getNotePourcentage());
        exam.setMaximumPoints(160);
        assertEquals(50, exam.getNotePourcentage());
        exam.setNotePourcentage(62.5);
        assertEquals(62.5, exam.getNotePourcentage());
        exam.setPoidsNoteFinale(0.3);
        assertEquals(0.3, exam.getPoidsNoteFinale());
    }

    @Test
    void finalExamCalculatesAndUpdatesPercentage() {
        NoteExamenFinSession exam = new NoteExamenFinSession(120, 90);

        assertEquals(120, exam.getMaximumPoints());
        assertEquals(90, exam.getNote());
        assertEquals(75, exam.getNotePourcentage());

        exam.setNote(60);
        assertEquals(50, exam.getNotePourcentage());
        exam.setMaximumPoints(100);
        assertEquals(60, exam.getNotePourcentage());
        exam.setNotePourcentage(64);
        assertEquals(64, exam.getNotePourcentage());
    }

    @Test
    void practicalWorkCalculatesPercentageForTheApplicationScale() {
        NoteTravailPratique practicalWork = new NoteTravailPratique(100, 72);

        assertEquals(72, practicalWork.getNotePourcentage());
        practicalWork.setNotePourcentage(68.5);
        assertEquals(68.5, practicalWork.getNotePourcentage());
        practicalWork.setMaximumPoints(100);
        practicalWork.setNote(68);
        assertEquals(100, practicalWork.getMaximumPoints());
        assertEquals(68, practicalWork.getNote());
    }
}