package org.examples.streamapi.model;
//DTO= data transfer object- sending data from one object to another system- only necessary ones
public class PersonDTO {
    private String name;
    private String lastName;

    public PersonDTO(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
