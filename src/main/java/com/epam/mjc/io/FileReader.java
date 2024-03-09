package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) {
        try (BufferedReader fileReader = new java.io.BufferedReader(new java.io.FileReader(file))) {
            StringBuilder text = new StringBuilder();
            String line;
            while ((line = fileReader.readLine()) != null) {
                text.append(line).append("\n");
            }
            return parseToObject(text.toString());
        } catch (IOException e) {
            System.out.println("File not found or input error ");
        }
        return null;
    }

    private Profile parseToObject(String text) {
        Profile profile = new Profile();
        String[] arr = text.split("\n");
        for (String line : arr) {
            String[] a = line.split(": ");
            switch (a[0]) {
                case "Name" -> profile.setName(a[1]);
                case "Age" -> profile.setAge(Integer.parseInt(a[1]));
                case "Email" -> profile.setEmail(a[1]);
                case "Phone" -> profile.setPhone(Long.parseLong(a[1]));

            }
        }
        return profile;
    }
}
