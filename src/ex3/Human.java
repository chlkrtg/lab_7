package ex3;

import java.util.Objects;

public class Human implements Comparable<Human> {
    private String fName;
    private String lName;
    private int age;

    public Human(String fName, String lName, int age) {
        this.fName = fName;
        this. lName = lName;
        this.age = age;
    }

    public String getFName() {
        return fName; }
    public String getLName() {
        return lName; }
    public int getAge() {
        return age; }

    public void setFName(String fName) {
        this.fName = fName; }
    public void setLName(String lName) {
        this.lName = lName; }
    public void setAge(int age) {
        this.age = age; }

    @Override
    public int compareTo(Human o) {
        if (this.equals(o))
            return 0;

        int rez = fName.compareToIgnoreCase(o.getFName());
        if (rez != 0)
            return rez;

        rez = lName.compareToIgnoreCase(o.getLName());
        if (rez != 0)
            return rez;

        return age - o.getAge();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Human human = (Human) obj;
        return age == human.age &&
                Objects.equals(fName.toLowerCase(), human.fName.toLowerCase()) &&
                Objects.equals(lName.toLowerCase(), human.lName.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(fName.toLowerCase(), lName.toLowerCase(), age);
    }

    @Override
    public String toString() {
        return String.format("%s %s, %d лет", fName, lName, age);
    }
}
