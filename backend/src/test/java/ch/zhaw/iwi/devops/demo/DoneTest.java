package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DoneTest {
    
    @Test
    public void testDone() {
        var done1 = new Done(1, "title", "description");
        assertEquals("title", done1.getTitle());
        assertEquals("description", done1.getDescription());
        assertEquals(1, done1.getId());
    }
}
