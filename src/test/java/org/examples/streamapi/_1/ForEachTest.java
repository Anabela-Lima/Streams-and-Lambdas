package org.examples.streamapi._1;

import org.junit.jupiter.api.Test;

import static org.examples.streamapi.TestUtil.PEOPLE;

public class ForEachTest {

    // BASIC SYNTAX
    @Test
    void printOutNamesAllCaps_comments(){
        PEOPLE
                .forEach(
                      /*
                        To help you understand the lambda's syntax
                        You may start with this and use IntelliJ to simplify the expression.
                     */
                        (person) -> {
                            System.out.println(person.getName().toUpperCase());
                        }
                );
    }

//    // OPTIMIZED SYNTAX
//
//    // to get this, click  { in previous example) { in line 18,  option + enter, replace with lambda expression
//
//    // simplified 1
//    @Test
//    void printOutNamesAllCaps_comments(){
//        PEOPLE
//                .forEach(
//                      /*
//                        To help you understand the lambda's syntax
//                        You may start with this and use IntelliJ to simplify the expression.
//                     */
//                        (person) -> System.out.println(person.getName().toUpperCase())
//                );
//    }
//
//    // simplified 1.1
//    @Test
//    void printOutNamesAllCaps_comments(){
//        PEOPLE
//                .forEach(
//                      /*
//                        To help you understand the lambda's syntax
//                        You may start with this and use IntelliJ to simplify the expression.
//                     */
//                        (person) -> System.out.println(person)
//                );
//    }
//
//    // simplified 1.2
//    @Test
//    void printOutNamesAllCaps_comments(){
//        PEOPLE
//                .forEach(
//                      /*
//                        To help you understand the lambda's syntax
//                        You may start with this and use IntelliJ to simplify the expression.
//                     */
//                        System.out::println
//                );
//    }
//

    @Test
    void printOutAllCaps(){
        //same thing as List<Person>People
        PEOPLE.forEach(p -> System.out.println(p.getName().toUpperCase()));
        // start from forEach method- provided by JAVA- passing a method to forEach method.
        // for each p print out their name in uppercase
        // when using lambda we don't have to specify the object type E.G. Person p, we just need to write p or whatever.
        // lambda will figure this out


    }



    // PRACTICE--------------------------------------------------------------------------------------------------------

    // Time for some practice: print out, in separate tests: lastName, age, Gender.

//LAST NAME

    @Test
    void printOutLastName(){
        PEOPLE
                .forEach(

                        (person) -> {
                            System.out.println(person.getLastName().toUpperCase());
                        }
                );
    }

//AGE

    @Test
    void age(){
        PEOPLE
                .forEach(

                        (person) -> {
                            System.out.println(person.getAge());
                        }
                );
    }

//GENDER

    @Test
    void gender(){
        PEOPLE
                .forEach(

                        (person) -> {
                            System.out.println(person.getGender());
                        }
                );
    }



// FULL NAME
    @Test
    void nameLastName(){
        PEOPLE
                .forEach(

                        (person) -> {
                            System.out.println(person.getName() + person.getLastName());
                        }
                );
    }


    @Test
    void fullNameAndGender(){
        PEOPLE
                .forEach(

                        (person) -> {
                            System.out.println(person.getName() + person.getLastName() + person.getGender());
                        }
                );
    }

    @Test
    void fullNameAndAge(){
        PEOPLE
                .forEach(

                        (person) -> {
                            System.out.println(person.getName() + person.getLastName() + person.getAge());
                        }
                );
    }
}
