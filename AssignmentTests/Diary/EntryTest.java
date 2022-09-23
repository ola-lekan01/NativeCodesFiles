package Diary;

import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EntryTest {
    private Entry entry;

    @BeforeEach
    public void setThisUp(){
        entry = new Entry("1", "My Life", "The First Day Of My Life", LocalDate.now());
    }

    @Test
    public void testThatObjectExist(){
        assertNotNull(entry);
    }

    @Test
    public void testThatWeCanAddBodyAndTitleToEntry(){
        assertEquals("My Life", entry.getTitle());
        assertEquals("The First Day Of My Life", entry.getBody());
    }

    @Test
    public void testThatWeCanSetBodyAndTitleToEntry(){
        entry.addTitle("My Story");
        entry.addBody("This is Story Of The First Day of My life");
    }

    @Test
    public void testThatWeCanFindEntryById(){

        assertEquals("1", entry.getId());
    }

}
