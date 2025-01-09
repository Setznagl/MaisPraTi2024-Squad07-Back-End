package com.maisprati.codifica.alucar.Util;

import com.maisprati.codifica.alucar.Models.Users.DriverUser;
import com.maisprati.codifica.alucar.Models.Users.RawUser;

public class TestSandbox{
    public static void main(String[] args) {
        RawUser Teste01 = new RawUser("Iorvet","iov@gmail.com","Huheaisj21");
        DriverUser Teste02 = new DriverUser("Vernon Roche","bluestripes@gmail.com","Hxzisj21");

        System.out.println(Teste01);
        System.out.println(Teste02);
    }
}
