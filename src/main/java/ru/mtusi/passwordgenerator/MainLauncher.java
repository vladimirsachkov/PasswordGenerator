package ru.mtusi.passwordgenerator;

import java.util.function.Predicate;
import java.util.regex.Pattern;

public class MainLauncher {
    public static void main(String[] args) {
        PasswordGeneratorImpl passwordGenerator = new PasswordGeneratorImpl("");
        passwordGenerator.passwordGenerator();
        System.out.println(passwordGenerator.getPassword() + "\n");

        PasswordGeneratorImpl passwordGenerator1 = new PasswordGeneratorImpl("2");
        passwordGenerator1.passwordGenerator();
        System.out.println(passwordGenerator1.getPassword() + "\n");

        PasswordGeneratorImpl passwordGenerator2 = new PasswordGeneratorImpl("31");
        passwordGenerator2.passwordGenerator();
        System.out.println(passwordGenerator2.getPassword() + "\n");
    }
}