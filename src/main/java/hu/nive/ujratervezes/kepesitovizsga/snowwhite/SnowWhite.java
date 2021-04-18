package hu.nive.ujratervezes.kepesitovizsga.snowwhite;

import java.util.*;

public class SnowWhite {
    List<Dwarf> dwarves;

    public SnowWhite(List<Dwarf> dwarves) {
        this.dwarves = dwarves;
    }

    public List<Dwarf> getSevenDwarfs() {
        List<Dwarf> copyOfDwarves = new ArrayList<>();
        for (Dwarf item : dwarves
        ) {
            copyOfDwarves.add(new Dwarf(item));

        }
        return copyOfDwarves;
    }


    public List<Dwarf> getSevenDwarfsOrderedByNames() {
        List<Dwarf> sortedList = getSevenDwarfs();
        sortedList.sort(Comparator.comparing(Dwarf::getName));
        return sortedList;
    }

    public List<Dwarf> getSevenDwarfsOrderedByAges() {
        List<Dwarf> sortedList = getSevenDwarfs();
        sortedList.sort(Comparator.comparing(Dwarf::getAge));
        return sortedList;
    }
}
