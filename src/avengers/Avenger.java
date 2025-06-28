package avengers;

//File: Avenger.java

import java.util.Objects;

public class Avenger {
 private String name;
 private String role;
 private int powerLevel;

 public Avenger(String name, String role, int powerLevel) {
     this.name = name;
     this.role = role;
     this.powerLevel = powerLevel;
 }

 // Getters
 public String getName() {
     return name;
 }

 public String getRole() {
     return role;
 }

 public int getPowerLevel() {
     return powerLevel;
 }

 // Override equals and hashCode for HashSet uniqueness by name
 @Override
 public boolean equals(Object o) {
     if (this == o) return true;
     if (!(o instanceof Avenger)) return false;
     Avenger avenger = (Avenger) o;
     return name.equalsIgnoreCase(avenger.name); // Case-insensitive name match
 }

 @Override
 public int hashCode() {
     return Objects.hash(name.toLowerCase());
 }

 @Override
 public String toString() {
     return name + " | Role: " + role + " | Power Level: " + powerLevel;
 }
}