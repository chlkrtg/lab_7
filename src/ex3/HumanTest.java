package ex3;

import java.util.*;

public class HumanTest {
    public static void main(String[] args) {

        System.out.println("Создание коллекции людей");
        Human h1 = new Human("Иван", "Петров", 25);
        Human h2 = new Human("Анна", "Иванова", 30);
        Human h3 = new Human("Петр", "Сидоров", 22);
        Human h4 = new Human("Мария", "Петрова", 25);
        Human h5 = new Human("ивАн", "пеТров", 25);

        System.out.println("\na) HashSet");
        Set<Human> hashSet = new HashSet<>();
        hashSet.add(h1);
        hashSet.add(h2);
        hashSet.add(h3);
        hashSet.add(h4);
        hashSet.add(h5);

        System.out.println("HashSet размер: " + hashSet.size());
        for (Human human : hashSet) {
            System.out.println("  " + human);
        }

        System.out.println("\nb) LinkedHashSet");
        Set<Human> linkedHashSet = new LinkedHashSet<>(hashSet);
        System.out.println("LinkedHashSet (сохраняет порядок добавления):");
        for (Human human : linkedHashSet) {
            System.out.println("  " + human);
        }

        System.out.println("\nc) TreeSet (натуральный порядок)");
        Set<Human> treeSet = new TreeSet<>(hashSet);
        System.out.println("TreeSet (сортировка по имени->фамилии->возрасту):");
        for (Human human : treeSet) {
            System.out.println("  " + human);
        }

        System.out.println("\nd) TreeSet с компаратором по фамилии");
        Set<Human> treeSetByLName = new TreeSet<>(new HumanComparatorByLName());
        treeSetByLName.addAll(hashSet);
        System.out.println("TreeSet (сортировка только по фамилии):");
        for (Human human : treeSetByLName) {
            System.out.println("  " + human);
        }

        System.out.println("\ne) TreeSet с анонимным компаратором по возрасту");
        Set<Human> treeSetByAge = new TreeSet<>(new Comparator<Human>() {
            @Override
            public int compare(Human h1, Human h2) {
                return Integer.compare(h1.getAge(), h2.getAge());
            }
        });
        treeSetByAge.addAll(hashSet);
        System.out.println("TreeSet (сортировка по возрасту):");
        for (Human human : treeSetByAge) {
            System.out.println("  " + human);
        }

        System.out.println("\nПроверка сравнения");
        System.out.println("h1.compareTo(h2): " + h1.compareTo(h2));
        System.out.println("h1.compareTo(h4): " + h1.compareTo(h4));
        System.out.println("h1.compareTo(h5): " + h1.compareTo(h5));

        HumanComparatorByLName byLName = new HumanComparatorByLName();
        System.out.println("byLName.compare(h1, h4): " + byLName.compare(h1, h4));
    }
}
