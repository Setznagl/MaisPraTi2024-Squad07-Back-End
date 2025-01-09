package com.maisprati.codifica.alucar.Util;

import com.maisprati.codifica.alucar.Models.Users.DriverUser;
import com.maisprati.codifica.alucar.Models.Users.RawUser;

public class TestSandbox {
    public static void main(String[] args) {

        RawUser Test01 = new RawUser("Elwan" , "1234e@gmail.com" , "sa3s21ara");
        System.out.println(Test01);

        DriverUser Test02 = new DriverUser("Caue" , "SAJOEAsa@gmail.com" , "as3a22s");
        System.out.println(Test02);
    }
}
