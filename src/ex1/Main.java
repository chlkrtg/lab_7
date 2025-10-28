package ex1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("a) Создайте массив из N чисел.");
        Integer[] array = {1, 2, 7, 8, 1, 5, 9, 6, 4, 1};
        System.out.println("Массив: " + Arrays.toString(array));

        System.out.println("\nb) На основе массива создайте список List.");
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        System.out.println("Лист: " + list);

        System.out.println("\nc) Отсортируйте список в натуральном порядке.");
        Collections.sort(list);
        System.out.println("Отсортированный лист: " + list);

        System.out.println("\nd) Отсортируйте список в обратном порядке.");
        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Отсортированный в обратном порядке лист: " + list);

        System.out.println("\ne) Перемешайте список.");
        Collections.shuffle(list);
        System.out.println("После перемешивания: " + list);

        System.out.println("\nf) Выполните циклический сдвиг на 1 элемент.");
        System.out.println("До сдвига: " + list);
        Collections.rotate(list, 1);
        System.out.println("После сдвига вправо: " + list);

        System.out.println("\ng) Оставьте в списке только уникальные элементы.");
        Set<Integer> uniqueSet = new LinkedHashSet<>(list);
        System.out.println("Уникальные элементы: " + uniqueSet);

        System.out.println("\nh) Оставьте в списке только дублирующиеся элементы.");
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicatesSet = new HashSet<>();

        for (Integer num : list) {
            if (!seen.add(num)) { //элемент уже добавлен -> дубликат
                duplicatesSet.add(num);
            }
        }

        List<Integer> duplicates = new ArrayList<>(duplicatesSet);
        System.out.println("Дубликаты: " + duplicates);

        System.out.println("\ni) Из списка получите массив.");
        Integer[] newArray = list.toArray(new Integer[0]);
        System.out.println("Новый массив: " + Arrays.toString(newArray));
    }
}