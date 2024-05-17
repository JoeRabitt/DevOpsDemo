package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DoneTest {
    
    @Test
    void testDone() {
        var done1 = new Done(1, "title", "description");
        assertEquals("title", done1.getTitle());
        assertEquals("description", done1.getDescription());
        assertEquals(1, done1.getId());
    }

    @Test
    void testSetters() {
        var done2 = new Done();
        done2.setId(2);
        done2.setTitle("neuer Titel");
        done2.setDescription("neue Beschreibung");

        assertEquals(2, done2.getId(), "ID sollte aktualisiert werden");
        assertEquals("neuer Titel", done2.getTitle(), "Titel sollte aktualisiert werden");
        assertEquals("neue Beschreibung", done2.getDescription(), "Beschreibung sollte aktualisiert werden");
    }    
}
