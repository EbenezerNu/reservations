package com.catalyst.reservations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@SpringBootApplication
@RestController
public class ReservationsApplication {
    //private static Scanner take = new Scanner(System.in);
    private static List <String> listName = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(ReservationsApplication.class, args);
        //List <String> listName
        listName.add("Eben");
        listName.add("Kofi");
        listName.add("Nuamah");
        listName.add("Catalyst");
        listName.add("Solomon");
        listName.add("Lystical");
    }

    //@GetMapping("/home")
    public String HelloWorld() {
        String readOut = "These are the names :";
        for (String i : listName)
            readOut += "<p>"+i+" ";
        return readOut;
    }

    @Override
    public String toString() {
        String readOut = "";
        for (String i : this.listName)
            readOut += i;
        return readOut;
    }



}
