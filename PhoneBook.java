package ru.geekbrains.lesson_c;

import java.util.*;

public class PhoneBook {

    protected String surname;

    protected PhoneBook(String surname) {
        this.surname = surname;
    }

    static HashMap<String, List<String>> phoneBook = new HashMap<>();

    public static void main(String[] args) {

        createPhoneBook();
        addContact("Ivanov", "8-999-999-99-80");
        getContact("Ivanov");
        getContact("Volkov");
    }

    public static void createPhoneBook() {
        List<String> ivanov = new ArrayList<>();
        ivanov.add("8-999-999-99-99");
        ivanov.add("8-999-999-99-98");
        phoneBook.put("Ivanov",ivanov);

        List<String> petrov = new ArrayList<>();
        petrov.add("8-999-999-99-97");
        petrov.add("8-999-999-99-96");
        phoneBook.put("Petrov",petrov);

        List<String> sidorov = new ArrayList<>();
        sidorov.add("8-999-999-99-95");
        sidorov.add("8-999-999-99-94");
        phoneBook.put("Sidorov",sidorov);

        System.out.println(phoneBook);
    }
    
    public static void addContact(String surname, String phoneNumber) {
        if (phoneBook.containsKey(surname)) {

        } List<String> s = Collections.singletonList(surname);

    } // это не сделал
    public static void getContact(String surname) {
        if(phoneBook.containsKey(surname)) {
            for (Map.Entry<String, List<String>> o : phoneBook.entrySet()) {
                if(o.getKey().equals(surname)) {
                    String tempSurname = o.getKey();
                    List tempPhone = o.getValue();
                    System.out.println(tempSurname + ": " + tempPhone);
                }
            }
        } else {System.out.println("The PhoneBook hasn`t contact with surname " + surname);}
    }

}
