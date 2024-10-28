import ofofo.data.models.Diary;
import ofofo.data.repositories.DiaryRepositoryImpl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryRepositoryImplTest {
    DiaryRepositoryImpl diaryRepo;

    @BeforeEach
    public void setUp() {
        diaryRepo = new DiaryRepositoryImpl();
    }

    @Test
    public void test_That_New_Repository_Is_empty() {
        diaryRepo = new DiaryRepositoryImpl();
        assertEquals(0, diaryRepo.count());
    }

    @Test
    public void test_That_One_New_Entry_Is_Added_To_Repo() {
        assertEquals(0, diaryRepo.count());
        Diary diary = new Diary("Bravo", "myPassword");
        diaryRepo.save(diary);
        assertEquals(1, diaryRepo.count());
        assertEquals(1, diaryRepo.getSize());
    }

    @Test
    public void test_That_Two_Or_More_New_Entry_Is_Added_To_Repo() {
        assertEquals(0, diaryRepo.count());
        Diary diary01 = new Diary("TY", "myPassword");
        diaryRepo.save(diary01);
        assertEquals(1, diaryRepo.count());
        Diary diary02 = new Diary("Bravo", "myPassword");
        diaryRepo.save(diary02);
        assertEquals(2, diaryRepo.count());
        assertEquals(2, diaryRepo.getSize());
    }

    @Test
    public void test_That_One_Diary_Can_Be_Removed_From_Repo() {
        Diary diary = new Diary("TY", "myPassword");
        diaryRepo.save(diary);
        assertEquals(1, diaryRepo.count());
        diaryRepo.delete(diary);
        Assertions.assertEquals(0, diaryRepo.count());
    }

    @Test
    public void test_That_Two_Diaries_Added_Delete_One_And_Diary_Is_Not_Empty() {
        assertEquals(0, diaryRepo.count());
        Diary diary01 = new Diary("TY", "myPassword");
        diaryRepo.save(diary01);
        assertEquals(1, diaryRepo.count());
        Diary diary02 = new Diary("Bravo", "myPassword");
        diaryRepo.save(diary02);
        assertEquals(2, diaryRepo.count());
        diaryRepo.delete(diary02);
        assertEquals(1, diaryRepo.count());
        assertEquals(1, diaryRepo.getSize());
    }

    @Test
    public void test_That_Diary_Can_Be_Retrieved_From_Repo() {
        Diary diary = new Diary("TY", "myPassword");
        diaryRepo.save(diary);
        assertEquals(1, diaryRepo.count());
        assertEquals(1, diaryRepo.getSize());
        assertEquals("TY", diary.getUsername());
    }

    @Test
    public void test_To_Search_Entry_By_Id() {
        assertEquals(0, diaryRepo.count());
        Diary diary = new Diary("Bravo", "myPassword");
        diaryRepo.save(diary);
        assertEquals(1, diaryRepo.count());
        Diary diary2 = new Diary("Adetayo", "myPassword2");
        diaryRepo.save(diary2);
        assertEquals(2, diaryRepo.count());
        Diary fetchedUsername = diaryRepo.findById("Bravo");
        assertEquals("Bravo", fetchedUsername.getUsername());
    }

    @Test
    public void test_To_Delete_Existing_Repository_Diary(){
        assertEquals(0, diaryRepo.count());
        Diary diary = new Diary("Bravo", "myPassword");
        diaryRepo.save(diary);
        assertEquals(1, diaryRepo.getSize());
        diaryRepo.delete(diary);
        assertEquals(0, diaryRepo.count());
        assertEquals(0, diaryRepo.getSize());
    }

}