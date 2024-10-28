package ofofo.data.repositories;

import ofofo.data.models.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository {
    private List<Diary> diaries = new ArrayList<>();
    private long count = 0;


    public DiaryRepositoryImpl() {
        diaries = new ArrayList<>();
    }


    @Override
    public Diary save(Diary diary) {
        diaries.add(diary);
        count++;
        return null;
    }

    @Override
    public List<Diary> findByTitle(String title) {
        return List.of();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void delete(Diary userName) {
        for(int index = 0; index < diaries.size(); index++) {
            if(diaries.get(index).equals(userName)) {
                diaries.remove(index);
            }
        }
        count--;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public Diary findById(String userName) {
        for(Diary diary: diaries){
            if(diary.getUsername().equals(userName)){
                return diary;
            }
        }
        return null;
    }

    @Override
    public Diary findByPass(String password) {
        for(Diary diary: diaries){
            if(diary.getPassword().equals(password)){
                return diary;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public int getSize(){
        return diaries.size();
    }

    private List<Diary> getDiary(long id) {
        return diaries;
    }

    @Override
    public String toString() {
        return diaries.toString();
    }

}
