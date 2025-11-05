package com.Jdbcproject.controller;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.Jdbcproject.DAO.TrekkerDAO;
import com.Jdbcproject.bean.Trekker;

public class TrekkerController {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Trekker t = new Trekker();

        System.out.println("Enter your id:");
        t.setId(sc.nextInt());
        sc.nextLine(); 

        System.out.println("Enter your name:");
        t.setName(sc.nextLine());

        System.out.println("Enter your city:");
        t.setCity(sc.nextLine());

        System.out.println("Enter your address:");
        t.setAddress(sc.nextLine());

        System.out.println("Enter your adhar no:");
        t.setAdhar(sc.nextLine()); 

        System.out.println("Enter your contact:");
        t.setContact(sc.nextLine());

        System.out.println("Enter your email:");
        t.setEmail(sc.nextLine());

        System.out.println("Enter your pass:");
        t.setPass(sc.nextLine());

        TrekkerDAO td = new TrekkerDAO();

        try {
            boolean st = td.insert(t);

            if (st == true) {
                System.out.println("Trekker has been enrolled successfully...");
            } else {
                System.out.println("Please register again...");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
    }
}
