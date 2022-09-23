package Diary;

import Diary.Exceptions.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Diary {
   List<Entry> entryList = new ArrayList<>();
   List<User> userList = new ArrayList<>();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String str = "2020-09-16";
    private int counter;
    boolean isValid;

    public void add(String title, String body) {
        if(isValid){
            Entry entry = new Entry((counter+1)+"", title, body, LocalDate.now());
            entryList.add(entry);
            counter += 1;
        }
    }

    public void createAccount( String firstName, String userName,String email, Gender gender, String password){
        User user = new User((counter+1)+"", firstName, userName, gender, email, password);
        userList.add(user);
        counter += 1;
    }

    public boolean logIn(String userName, String password){
        isValid = false;
        for (User user : userList){
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    public Entry searchById(String ID) {
        for (Entry entry : entryList){
            if(entry.getId().equals(ID))
                return entry;
        }
        throw new InvalidIDErrorException("Invalid ID, please try again");
    }

    public Entry searchByTitle(String title) {
        for (Entry entry : entryList){
            if(entry.getTitle().equals(title))
                return entry;
        }
        throw new InvalidTitleErrorException("Invalid ID, please try again");
    }

    public Entry searchByDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Entry entry : entryList){
            if (entry.getDate().equals(LocalDate.parse(date, formatter)))
                return entry;
        }
        throw new InvalidDateErrorException("Invalid ID, please try again");
    }

    public int getSize() {
        return counter;
    }

    public void deleteEntry(String ID) {
        for (Entry entry : entryList){
            if(entry.getId().equals(ID)) {
                entryList.remove(entry);
                counter--;
            }
            else throw new UnableToDeleteEntryException("Unable to delete Entry");
        }
    }

    @Override
    public String toString() {
        return "Diary{" +
                "entryList=" + entryList +
                ", formatter=" + formatter +
                ", str='" + str + '\'' +
                ", counter=" + counter +
                '}';
    }
}
