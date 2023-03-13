package ru.mtusi.passwordgenerator;

import java.util.Random;

public class PasswordGeneratorImpl implements PasswordGenerational {

    //Английский алфавит ниженего регистра
    private String englishAlphabetLow = "abcdefghijklmnopqrstuvwxyz";
    //Английский алфавит верхнего регистра
    private String englishAlphabetUp = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //Индификатор
    private String identifier;
    //Сгенерированный пароль
    private String password = "";

    //Конструктор
    public PasswordGeneratorImpl(String identifier) {
        this.identifier = identifier;
    }

    //Генерация пароля
    public void passwordGenerator() {
        System.out.println("Entered identifier: " + getIdentifier());
        passwordGeneratorStepOne();
        passwordGeneratorStepTwo();
        passwordGeneratorStepThree();
    }

    //Этап первый. Генерация b1, b2, b3
    private void passwordGeneratorStepOne() {
        for (int i = 0; i < 3; i++) {
            password = password + randomLetterInTheAlphabet(englishAlphabetLow);
        }
        System.out.println("Password generator step one: " + password);
    }

    //Этап второй. Генерация b4, b5
    private void passwordGeneratorStepTwo() {
        for (int i = 0; i < 2; i++) {
            password = password + randomLetterInTheAlphabet(englishAlphabetUp);
        }
        System.out.println("Password generator step two: " + password);
    }

    //Этап второй. Генерация b6, b7
    private void passwordGeneratorStepThree() {
        int lengthOfI = identifier.length();
        System.out.println("Length of identifier: " + lengthOfI);
        int lengthOfIdentifier4 = lengthOfI * lengthOfI * lengthOfI * lengthOfI;
        System.out.println("Identifier to the fourth power: " + lengthOfIdentifier4);
        String lengthOfIdentifier4Mod100 = String.valueOf(lengthOfIdentifier4 % 100);
        System.out.println("Identifier to the fourth power mod100: " + lengthOfIdentifier4Mod100);
        String b6 = "";
        String b7 = "";
        //Если остаток однозначное число то b6 = 0
        if (lengthOfIdentifier4Mod100.length() == 1) {
            b6 = "0";
        } else {
            b6 = Character.toString(lengthOfIdentifier4Mod100.charAt(0))+Character.toString(lengthOfIdentifier4Mod100.charAt(1));
        }
        System.out.println("B6 equals: " + b6);
        //Если остаток однозначное число то перед числом будет стоять 0 в b7;
        if (lengthOfIdentifier4Mod100.length() == 1) {
            b7 = "0" + Character.toString(lengthOfIdentifier4Mod100.charAt(0));
        } else {
            b7 = Character.toString(lengthOfIdentifier4Mod100.charAt(0))+Character.toString(lengthOfIdentifier4Mod100.charAt(1));
        }
        System.out.println("B7 equals: " + b7);
        password = password + b6 + b7;
    }

    //Получение случайного символа из алфавита
    private String randomLetterInTheAlphabet (String alphabet) {

        if (alphabet == null || alphabet == "") {
            return "";
        }
        Random random = new Random();
        String a = Character.toString (alphabet.charAt(random.nextInt(alphabet.length())));
        return a;
    }

    public String getEnglishAlphabetLow() {
        return englishAlphabetLow;
    }

    public String getEnglishAlphabetUp() {
        return englishAlphabetUp;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getPassword() {
        return password;
    }
}
