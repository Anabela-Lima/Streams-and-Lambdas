package org.examples.streamapi._2_filter;

import org.examples.streamapi.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.examples.streamapi.TestUtil.PEOPLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterTest {

    // old approach would be to use a for loop,with stream api we use lambdas
    @Test
    void filterPeopleYoungerThan20_comments(){
        List<Person> filteredPeople = PEOPLE
                // Change collection in this case list into a stream to have access to Stream
                // (gives us access to richer API- methods when we do dot e.g. now we can do filter based on a specific condition)
                .stream()
                .filter(
                        // Let's pass lambda (again, a more extended version to be more similar to a method
                        (person) -> {
                            return person.getAge() < 20;                     // gray return tells me that is redundant
                        }
                )
                // Now it's time to go back to a List - when job is done i.e. we have filtered PEOPLE
                .toList();

        assertEquals(4, filteredPeople.size());
    }


    //OPTIMIZED VERSION

    @Test
    void filterPeopleYoungerThan20(){
        List<Person> filteredPeople = PEOPLE
                .stream()
                .filter(person -> person.getAge() < 20)
                .toList();

        assertEquals(4, filteredPeople.size());
    }

    // PRACTICE--------------------------------------------------------------------------------------------------------

/*
    Time for some practice:
     - filter by: age < 20 or age > 30
     - filter by: firstName starts with "Z" and age < 20
     - filter by: Gender: non-binary and  age > 30
     - filter by lastName starts with "B" and age > 50
 */

    // using optimized version :

    @Test
    void filterPeopleYounger20Greater30(){
        List<Person> filteredPeople = PEOPLE
                .stream()
                .filter(person -> person.getAge() <20  || person.getAge() >30)
                .toList();

        assertEquals( 11 ,filteredPeople.size());
    }

//- filter by: age < 20 or age > 30
    @Test
    void filterPeopleZandAge30(){
        List<Person> filteredPeople = PEOPLE
                .stream()
                .filter(person -> person.getName().startsWith("Z") && person.getAge()<20)
                .toList();

        assertEquals(1, filteredPeople.size());
    }



//- filter by: Gender: non-binary and  age > 30

    @Test
    void filterPeopleNonbinaryAndAgeGreater30(){
        List<Person> filteredPeople = PEOPLE
                .stream()
                .filter(person -> person.getGender().equals(Person.Gender.NON_BINARY)  && person.getAge() >30)
                .toList();

        assertEquals( 2,filteredPeople.size());
    }

// - filter by lastName starts with "B" and age > 50


    @Test
    void lastNameStartsBandAgeGreater50(){
        List<Person> filteredPeople = PEOPLE
                .stream()
                .filter(person -> person.getLastName().startsWith("B") && person.getAge() >50)
                .toList();

        assertEquals( 1 ,filteredPeople.size());
    }

// we could also do this - filter nested
//
//    @Test
//    void lastNameStartsBandAgeGreater50_2(){
//        List<Person> filteredPeople = PEOPLE
//                .stream()
//                .filter(person -> person.getLastName().startsWith("B"))
//                        .filter( person.getAge>50)
//
//                .toList();
//
//        assertEquals( 1 ,filteredPeople.size());
//    }


}
