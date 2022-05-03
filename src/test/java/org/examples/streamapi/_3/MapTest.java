package org.examples.streamapi._3;


import org.examples.streamapi.model.Person;
import org.examples.streamapi.model.PersonDTO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.examples.streamapi.TestUtil.PEOPLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MapTest {

    @Test
    void mapPersonObjectsToStrings_comments() {
        List<String> names = PEOPLE                    // <string because thats the end thing we get>
                                                       // list of type person, stream it
                .stream()
                .map(                       //  A map Method that transforms object of type person to an object of type string
                        (person) -> {
                            return person.getName();
                        }
                )
                .toList();                   // convert it back to a list
        // Certainly not the best way to check the returned list, but it will do for this case ;)
        assertEquals("Alec", names.get(0));
        assertEquals("Alivia", names.get(19));
        assertEquals(20, names.size());
    }

    @Test
    void mapPersonObjectsToStrings() {

//        List<String> names = PEOPLE
//                .stream()
//                /*
//                    The syntax can get even crazier - but this is just a syntax sugar!
//                    It's the same as in the first example, so use the extended (the most obvious version)
//                    and then use IntelliJ to get to the most straightforward ( at the beginning, the craziest) syntax.
//                 */
//
//                /*
//
//                .map(Person::getName)
//
//                Note we can use intelli j to change to different syntax
//
//
//                 */
//
//                /*
//
//                  we have an object of type person e.g:
//
//                  new Person("Alec","Gunn", 20, MALE),
//
//                   . map returns get.name  i.e.
//
//                   -> "Alec"
//
//
//                   we can only pass Strings to map method e.g. cant do  .map(Person::getAge)
//                   because we defined  List<String> . TO get age change to List<Integer>
//
//                 */
//
//
//
//                .map(Person::getName)
//
//
//                .toList();


//        NOTE: all the above boils down to the code below:


        List<String> names = PEOPLE.stream().map(Person::getName).toList();

        // pass in strings of people, called names, stream it to get access to more methods, use map method
        // to get person name, and convert that back to a list

        assertEquals("Alec", names.get(0));
        assertEquals("Alivia", names.get(19));
        assertEquals(20, names.size());
    }

    // PRACTICE--------------------------------------------------------------------------------------------------------


/*
    Time for some practice:
     - map to List<Integers> (age)
     - map to List<String> (lastName)
     - map to List<Person.GENDER>

     extras: map List<Person> to List<PersonDTO>
 */

    // pass in Integer of people, called age, stream it to get access to more methods, use map method
    // to get person name, and convert that back to a list

//     - map to List<Integers> (age)
    @Test
    void mapPersonObjectsToInteger() {
        List<Integer> age = PEOPLE.stream().map(Person::getAge).toList();

        assertEquals(20, age.get(0));
        assertEquals(21, age.get(19));
        assertEquals(20, age.size());
    }

//    (0) means the position in list Alec is in first therefore 0

//  - map to List<String> (lastName)

    @Test
    void mapPersonObjectsToStringLastName() {
        List<String> lastname = PEOPLE.stream().map(Person::getLastName).toList();

        assertEquals("Gunn", lastname.get(0));
        assertEquals("Parrish", lastname.get(19));
        assertEquals(20, lastname.size());
    }


    //- map to List<Person.GENDER>
    @Test
    void mapPersonObjectsToStringGender() {



        // here I used Gender, because the data type for gender is not String but Gender
        List<Person.Gender> gender = PEOPLE.stream().map(Person::getGender).toList();

        assertEquals("Male", gender.get(0));
        assertEquals("Female", gender.get(19));
        assertEquals(20, gender.size());
    }

// extras: map List<Person> to List<PersonDTO>


    // USING BASIC LAMBDA SYNTAX

    @Test
    void mapPersonObjectsToPersonDTOobjects() {

        List<PersonDTO> names = PEOPLE                    // <PersonDTO because thats the end thing we get object of type personDTO
                // list of type person, stream it
                .stream()                                    // List : [person1,person2, person3...]
                .map(                                        // map according to lambda - recepi

                        // Recipe   //  A map Method that transforms object of type person to an object of type PersonDTO

                        (person) -> {  // person goes in
                            String name = person.getName();
                            String lastName = person.getLastName();
                            return new PersonDTO(name,lastName);
                        }

                )
                .toList();

        // convert it back to a list
        // Certainly not the best way to check the returned list, but it will do for this case ;)

        fail();
        assertEquals("Alec", names.get(0).getName());
        assertEquals("Alivia", names.get(19).getName());
        assertEquals(20, names.size());
    }







}





