package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Pet {

    private Long id;
    private String name;
    private String race;
    private int age;
    private int weight;
    private boolean isNeutered;
    private Owner owner;

    private ArrayList<Appointment> appointments;
    private ArrayList<Pet> pets;

    public void addPet(Pet pet) {
        if (pets == null) {
            pets = new ArrayList<>();
        }
        pets.add(pet);
        pet.setOwner(this.getOwner());
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

    public void addAppointment(Appointment appointment) {
        if (appointments == null) {
            appointments = new ArrayList<>();
        }
        appointments.add(appointment);
        appointment.setPet(this);
    }

    public void removeAppointment(Appointment appointment) {
        if (appointments != null) {
            appointments.remove(appointment);
        }
    }

    public ArrayList<Appointment> getNextAppointments() {
        ArrayList<Appointment> upcoming = new ArrayList<>();

        if (appointments != null) {
            for (Appointment a : appointments) {
                if (a.getDate().isAfter(java.time.LocalDateTime.now())) {
                    upcoming.add(a);
                }
            }
        }

        return upcoming;
    }
}
