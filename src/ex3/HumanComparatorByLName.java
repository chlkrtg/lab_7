package ex3;

import java.util.Comparator;

class HumanComparatorByLName implements Comparator<Human> {

    @Override
    public int compare(Human h1, Human h2) {
        return h1.getLName().compareToIgnoreCase(h2.getLName());
    }
}