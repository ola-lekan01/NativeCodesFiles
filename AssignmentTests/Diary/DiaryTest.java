package Diary;

import Diary.Exceptions.InvalidDateErrorException;
import Diary.Exceptions.InvalidIDErrorException;
import Diary.Exceptions.InvalidTitleErrorException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {

    private Diary diary;

    @BeforeEach
    public void setThisUp(){
        diary = new Diary();
    }



    @Test
    public void testThatWeCanAddEntryToDiary(){
        diary.add("My Life", "Story Of My Life");
        assertEquals(1, diary.getSize());

    }

    @Test
    public void testThatWeCanFindEntriesInDiaryThroughID(){
        diary.add("My Life", "The First Day Of My Life");
        Entry entry = diary.searchById("1");
        assertEquals("My Life", entry.getTitle());
        assertEquals("The First Day Of My Life", entry.getBody());
    }

    @Test
    public void testThatWeCanFindEntryInDiaryByTitle(){
        diary.add("My Life", "The First Day Of My Life");
        Entry entry = diary.searchByTitle("My Life");
        assertEquals("My Life", entry.getTitle());
        assertEquals("The First Day Of My Life", entry.getBody());
    }

    @Test
    public void testThatWeCanDeleteElementByID(){
        diary.add("My Life", "The First Day Of My Life");
        diary.add("My Life II", "The First Day Of My Life II");
        diary.deleteEntry("1");
        assertEquals(1, diary.getSize());

        Entry entry = diary.searchByTitle("My Life II");
        assertNotNull(entry);

        Entry entry2 = diary.searchByTitle("My Life");
        assertNull(entry2);

    }

    @Test
    public void testThatWeCanUpdateEntryInTheDiary(){
        diary.add("My Life", "The First Day Of My Life");
        diary.add("My Life II", "The First Day Of My Life II");
        assertEquals(2, diary.getSize());
        Entry entry = diary.searchById("1");
        entry.Update("My Life Updated", "The Story Continues");
        assertEquals(2, diary.getSize());
        assertNull(diary.searchByTitle("My Life"));
        assertNotNull(diary.searchByTitle("My Life Updated"));
    }

    @Test
    public void testThatWeCanFindEntryByDate(){
        diary.add("My Life", "The First Day Of My Life");
        diary.add("My Life II", "The First Day Of My Life II");
        assertEquals(2, diary.getSize());

        String str = "2022-09-16";
        Entry entry = diary.searchByDate(str);
        assertEquals("My Life", entry.getTitle());
    }

    @Test
    public void testThatWrongIdThrowsAnException(){
        diary.add("My Life", "The First Day Of My Life");
        assertThrows(InvalidIDErrorException.class,  ()-> diary.searchById("2"));
    }

    @Test
    public void testThatWrongTitleThrowsAnException(){
        diary.add("My Life", "The First Day Of My Life");
        assertThrows(InvalidTitleErrorException.class,  ()-> diary.searchByTitle("My Life III"));
    }

    @Test
    public void testThatWrongDateThrowsAnException(){
        diary.add("My Life", "The First Day Of My Life");
        assertThrows(InvalidDateErrorException.class,  ()-> diary.searchByDate("2022-09-12"));
    }
}
