package ru.mtusi.passwordgenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordGeneratorImplTest {

    PasswordGeneratorImpl passwordGenerator = new PasswordGeneratorImpl("24");

    //Тестирование метода randomLetterInTheAlphabet при входном параметре ""
    @org.junit.jupiter.api.Test
    void randomLetterInTheAlphabetWithEmptyArgument() {
        try {
            Method randomLetterInTheAlphabet = PasswordGeneratorImpl.class.getDeclaredMethod("randomLetterInTheAlphabet", String.class);
            randomLetterInTheAlphabet.setAccessible(true);
            assertEquals("", randomLetterInTheAlphabet.invoke(passwordGenerator, "").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Тестирование метода randomLetterInTheAlphabet при входном параметре null
    @org.junit.jupiter.api.Test
    void randomLetterInTheAlphabetWithNullArgument() {
        try {
            Method randomLetterInTheAlphabet = PasswordGeneratorImpl.class.getDeclaredMethod("randomLetterInTheAlphabet", String.class);
            randomLetterInTheAlphabet.setAccessible(true);
            assertEquals("", randomLetterInTheAlphabet.invoke(passwordGenerator, null).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Тестирование метода randomLetterInTheAlphabet при входном параметре "asd"
    @org.junit.jupiter.api.Test
    void randomLetterInTheAlphabetWithSomeAlphabet() {
        try {

            Method randomLetterInTheAlphabet = PasswordGeneratorImpl.class.getDeclaredMethod("randomLetterInTheAlphabet", String.class);
            randomLetterInTheAlphabet.setAccessible(true);
            String alphabet = "asd";
            boolean isExist = false;

            for (int i = 0; i < 15; i++){
                String randomCharacterFromTheAlphabet = randomLetterInTheAlphabet.invoke(passwordGenerator, "asdasd").toString();
                if (alphabet.contains(randomCharacterFromTheAlphabet)) {
                    isExist = true;
                } else {
                    isExist = false;
                    break;
                };
            }

            assertEquals(true, isExist);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //Проверка первого этапа генерирования пароля.
    @org.junit.jupiter.api.Test
    void passwordGeneratorStepOne() {
        try {
            Method randomLetterInTheAlphabet = PasswordGeneratorImpl.class.getDeclaredMethod("passwordGeneratorStepOne");
            randomLetterInTheAlphabet.setAccessible(true);
            randomLetterInTheAlphabet.invoke(passwordGenerator);
            Boolean isCorrect = false;

            if (passwordGenerator.getPassword().length() == 3){
                String b1 = Character.toString (passwordGenerator.getPassword().charAt(0));
                String b2 = Character.toString (passwordGenerator.getPassword().charAt(1));
                String b3 = Character.toString (passwordGenerator.getPassword().charAt(2));

                if (passwordGenerator.getEnglishAlphabetLow().contains(b1) &&
                    passwordGenerator.getEnglishAlphabetLow().contains(b2) &&
                    passwordGenerator.getEnglishAlphabetLow().contains(b3)) {
                    isCorrect = true;
                }
            }

            assertEquals(true, isCorrect);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //Проверка второго этапа генерирования пароля.
    @org.junit.jupiter.api.Test
    void passwordGeneratorStepTwo() {
        try {
            Method passwordGeneratorStepOne = PasswordGeneratorImpl.class.getDeclaredMethod("passwordGeneratorStepOne");
            Method passwordGeneratorStepTwo = PasswordGeneratorImpl.class.getDeclaredMethod("passwordGeneratorStepTwo");
            passwordGeneratorStepOne.setAccessible(true);
            passwordGeneratorStepOne.invoke(passwordGenerator);
            passwordGeneratorStepTwo.setAccessible(true);
            passwordGeneratorStepTwo.invoke(passwordGenerator);
            Boolean isCorrect = false;

            if (passwordGenerator.getPassword().length() == 5){
                String b4 = Character.toString (passwordGenerator.getPassword().charAt(3));
                String b5 = Character.toString (passwordGenerator.getPassword().charAt(4));

                if (passwordGenerator.getEnglishAlphabetUp().contains(b4) &&
                        passwordGenerator.getEnglishAlphabetUp().contains(b5)) {
                    isCorrect = true;
                }
            }

            assertEquals(true, isCorrect);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //Проверка третьего этапа пароля c индификатором ""
    @org.junit.jupiter.api.Test
    void passwordGeneratorStepThreeTestWithBlankIdentifier()  {
        try {
            PasswordGeneratorImpl passwordGenerator1 = new PasswordGeneratorImpl("");

            Method passwordGeneratorStepOne = PasswordGeneratorImpl.class.getDeclaredMethod("passwordGeneratorStepOne");
            Method passwordGeneratorStepTwo = PasswordGeneratorImpl.class.getDeclaredMethod("passwordGeneratorStepTwo");
            Method passwordGeneratorStepThree = PasswordGeneratorImpl.class.getDeclaredMethod("passwordGeneratorStepThree");

            passwordGeneratorStepOne.setAccessible(true);
            passwordGeneratorStepOne.invoke(passwordGenerator1);
            passwordGeneratorStepTwo.setAccessible(true);
            passwordGeneratorStepTwo.invoke(passwordGenerator1);
            passwordGeneratorStepThree.setAccessible(true);
            passwordGeneratorStepThree.invoke(passwordGenerator1);

            Boolean isCorrect = false;
            String b6 = Character.toString (passwordGenerator1.getPassword().charAt(5));
            String b7 = Character.toString (passwordGenerator1.getPassword().charAt(6))
                    + Character.toString (passwordGenerator1.getPassword().charAt(7));

            if (b6.equals("0") && b7.equals("00")) {
                isCorrect = true;
            }

            assertEquals(true, isCorrect);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void passwordGeneratorStepThreeTestWithBlankIdentifierWithOneSymbol()  {
        try {
            PasswordGeneratorImpl passwordGenerator1 = new PasswordGeneratorImpl("1");

            Method passwordGeneratorStepOne = PasswordGeneratorImpl.class.getDeclaredMethod("passwordGeneratorStepOne");
            Method passwordGeneratorStepTwo = PasswordGeneratorImpl.class.getDeclaredMethod("passwordGeneratorStepTwo");
            Method passwordGeneratorStepThree = PasswordGeneratorImpl.class.getDeclaredMethod("passwordGeneratorStepThree");

            passwordGeneratorStepOne.setAccessible(true);
            passwordGeneratorStepOne.invoke(passwordGenerator1);
            passwordGeneratorStepTwo.setAccessible(true);
            passwordGeneratorStepTwo.invoke(passwordGenerator1);
            passwordGeneratorStepThree.setAccessible(true);
            passwordGeneratorStepThree.invoke(passwordGenerator1);

            Boolean isCorrect = false;
            String b6 = Character.toString (passwordGenerator1.getPassword().charAt(5));
            String b7 = Character.toString (passwordGenerator1.getPassword().charAt(6))
                    + Character.toString (passwordGenerator1.getPassword().charAt(7));

            if (b6.equals("0") && b7.equals("01")) {
                isCorrect = true;
            }

            assertEquals(true, isCorrect);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void passwordGeneratorStepThreeTestWithBlankIdentifierWithTwoSymbol()  {
        try {
            PasswordGeneratorImpl passwordGenerator1 = new PasswordGeneratorImpl("12");

            Method passwordGeneratorStepOne = PasswordGeneratorImpl.class.getDeclaredMethod("passwordGeneratorStepOne");
            Method passwordGeneratorStepTwo = PasswordGeneratorImpl.class.getDeclaredMethod("passwordGeneratorStepTwo");
            Method passwordGeneratorStepThree = PasswordGeneratorImpl.class.getDeclaredMethod("passwordGeneratorStepThree");

            passwordGeneratorStepOne.setAccessible(true);
            passwordGeneratorStepOne.invoke(passwordGenerator1);
            passwordGeneratorStepTwo.setAccessible(true);
            passwordGeneratorStepTwo.invoke(passwordGenerator1);
            passwordGeneratorStepThree.setAccessible(true);
            passwordGeneratorStepThree.invoke(passwordGenerator1);

            Boolean isCorrect = false;
            String b6 = Character.toString (passwordGenerator1.getPassword().charAt(5))
                    + Character.toString (passwordGenerator1.getPassword().charAt(6));
            String b7 = Character.toString (passwordGenerator1.getPassword().charAt(7))
                    + Character.toString (passwordGenerator1.getPassword().charAt(8));

            if (b6.equals("16") && b7.equals("16")) {
                isCorrect = true;
            }

            assertEquals(true, isCorrect);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @org.junit.jupiter.api.Test
    void passwordGeneratorTest()  {
        try {
            PasswordGeneratorImpl passwordGenerator0 = new PasswordGeneratorImpl("");
            PasswordGeneratorImpl passwordGenerator1 = new PasswordGeneratorImpl("1");
            PasswordGeneratorImpl passwordGenerator2 = new PasswordGeneratorImpl("sd");
            PasswordGeneratorImpl passwordGenerator3 = new PasswordGeneratorImpl("sdd");

            Method passwordGenerator = PasswordGeneratorImpl.class.getDeclaredMethod("passwordGenerator");

            passwordGenerator.setAccessible(true);

            passwordGenerator.invoke(passwordGenerator0);
            passwordGenerator.invoke(passwordGenerator1);
            passwordGenerator.invoke(passwordGenerator2);
            passwordGenerator.invoke(passwordGenerator3);

            String regex = "[a-z]{3}[A-Z]{2}[0-9]{1,4}";

            Boolean isCorrect = false;

            if (Pattern.matches(regex, passwordGenerator0.getPassword()) &&
                Pattern.matches(regex, passwordGenerator1.getPassword()) &&
                Pattern.matches(regex, passwordGenerator2.getPassword()) &&
                Pattern.matches(regex, passwordGenerator3.getPassword())) {
                isCorrect = true;
            }

            assertEquals(true, isCorrect);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}