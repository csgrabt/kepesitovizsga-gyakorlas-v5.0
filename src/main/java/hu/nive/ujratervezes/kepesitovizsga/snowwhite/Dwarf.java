package hu.nive.ujratervezes.kepesitovizsga.snowwhite;

import java.util.Objects;

public class Dwarf {
    String name;
    int age;

    public Dwarf(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public Dwarf(Dwarf dwarf) {
        this.name = dwarf.name;
        this.age = dwarf.age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dwarf dwarf = (Dwarf) o;
        return age == dwarf.age && Objects.equals(name, dwarf.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
