package org.examples.streamapi._4;

import org.examples.streamapi.model.Person;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;

import static org.examples.streamapi.TestUtil.PEOPLE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PredicateTest {
/*
    We used Predicates with the Stream's filter method.

    * A predicate is an interface

    In Java, each method must belong to a Type - there are no methods on their own.
    Every lambda we pass is an implementation of a functional interface - (a functional interface is an interface with one method only).

    We can assign a lambda to a reference which sometimes may be helpful write more reusable code.

 */


    @Test
    void filterUsingAPredicate() {
        // Use lambda expression and assign it to a variable
        // similar to when we did:
        // Vehicle vehicle              = new Vehicle
        Predicate<Person> ageMoreThan30 = person -> person.getAge() > 30;    // we have a lambda
        Predicate<Person> ageLessThan20 = person -> person.getAge() < 20;
        Predicate<Person> isMale = new IsMalePersonPredicate();     //assigning reference variable of type interface,
                                                                    // an object that implements this interface


        List<Person> peopleOlderThan30AndYoungerThen20 = PEOPLE
                .stream()
                // Time to use the predicates ?
                .filter(ageLessThan20.or(ageMoreThan30))
                .toList();


       // this is the same:






        assertEquals(5, peopleOlderThan30AndYoungerThen20.size());
    }

        /*
            Time for some practice:
             - create the same test but this time use IntelliJ to help you get rid of unnecessary code in the lambdas
             (e.g. return keyword)
             - use FilterTest exercises again, but this time with the help of predefined predicates

             - extras: define some predicates in Person class (public static) and use them in the test
         */
}



// Lambda is just an implementation of a Method


// class implementing an interface
class IsMalePersonPredicate implements Predicate<Person>{

    //asks class to implement methods of predicate<Person>
    // - but we only need to implement the one without a body

    @Override
    public boolean test(Person person) {
        return person.getGender() == Person.Gender.MALE;
    }
}

// a class implementing an interface must implement the abstract methods- methods without the body