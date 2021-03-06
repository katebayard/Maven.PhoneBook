package com.zipcodewilmington.phonebook;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private TreeMap<String, String[]> phoneBook;

    public PhoneBook() {
        this.phoneBook = new TreeMap<String, String[]>();
    }

    //methods
    public TreeMap<String, String[]> getPhoneBook() {
        return phoneBook;
    }

    public void addEntry(String name, String[] phoneNumbers) {
        phoneBook.put(name, phoneNumbers);
    }

    public void removeEntry(String name) {
        phoneBook.remove(name);
    }

    public String[] lookupEntry(String name){
        return phoneBook.get(name);
    }

    public String reverseLookupEntry(String phoneNumber) {
        for (Map.Entry<String, String[]> entry : phoneBook.entrySet()) {
            String[] numbers = entry.getValue();
            for (int i = 0; i < numbers.length; i++) {
                if (phoneNumber == numbers[i]) {
                    return entry.getKey();
                }
            }
        }
        return null;
        }


    public String displayPhoneBook() {
        String printPhoneBook = "";
        for (Map.Entry<String,String[]> entry : phoneBook.entrySet() ) {
            String currentName = entry.getKey();
            String[] currentNumbers = entry.getValue();
            printPhoneBook = printPhoneBook + currentName + " " + phoneNumbersToString(currentNumbers) + "\n";
        }
        return printPhoneBook;
    }

    private String phoneNumbersToString(String[] numbers) {
        String numberString = "numbers:";
        for (int i = 0; i < numbers.length; i++) {
            numberString += "\n   " + numbers[i];
        }
        return numberString;
    }

    public void addPhoneNumber(String name, String number) {
        String[] array = lookupEntry(name);
        int newCount = array.length + 1;
        String[] newArray = Arrays.copyOf(array, newCount);
        newArray[newCount-1] = number;
        phoneBook.replace(name, newArray);
        }

    public void removePhoneNumber(String name, String number) {
        String[] array = lookupEntry(name);
        for (int i = 0; i < array.length ; i++) {
            if(number.equals(array[i])) {
                array[i] = null;
            }
        }
        int newCount = array.length - 1;
        String[] newArray = Arrays.copyOf(array, newCount);
        phoneBook.replace(name, newArray);
    }

}


