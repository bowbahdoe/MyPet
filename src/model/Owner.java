package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Owner {

    private Long id;

    private  String name;
    private String email;
    private int phoneNumber;
    private ArrayList<Pet> pets;


    public void addPet(Pet pet) {
        if (pets == null) {
            pets = new ArrayList<>();
        }
        pets.add(pet);
        pet.setOwner(this);
    }

    public void removePet(Pet pet) {
        if (pets != null) {
            pets.remove(pet);
            pet.setOwner(null);
        }
    }

    public Pet findPetByName(String name) {
        if (pets == null) return null;

        for (Pet p : pets) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
}
