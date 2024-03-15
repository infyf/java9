import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map;

class Food {
    private String name;
    private double price;

    public Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}

class PriceComparator implements Comparator<Food> {
    @Override
    public int compare(Food food1, Food food2) {
        return Double.compare(food1.getPrice(), food2.getPrice());
    }
}

public class Main {
    public static void main(String[] args) {
        // 2 завдання 
        Queue<Food> foodOrderQueue = new LinkedList<>();

        foodOrderQueue.offer(new Food("Pizza", 12.99));
        foodOrderQueue.offer(new Food("Burger", 8.49));
        foodOrderQueue.offer(new Food("Salad", 6.99));


        System.out.println("Перший елемент черги (без видалення): " + foodOrderQueue.peek());


        System.out.println("Перший елемент черги (із видаленням): " + foodOrderQueue.poll());


        System.out.println("Кількість елементів у черзі: " + foodOrderQueue.size());
        // 1 завдання 

        LinkedList<Food> foodOrderList = new LinkedList<>();
        foodOrderList.add(new Food("Pizza", 12.99));
        foodOrderList.add(new Food("Burger", 8.49));
        foodOrderList.add(new Food("Salad", 6.99));

        // Вивід елементів списку в прямому порядку 1 завдання 
        System.out.println("Прямий порядок:");
        for (Food food : foodOrderList) {
            System.out.println(food);
        }

        // Вивід елементів списку в зворотньому порядку
        System.out.println("\nЗворотній порядок:");
        for (int i = foodOrderList.size() - 1; i >= 0; i--) {
            System.out.println(foodOrderList.get(i));
        }
        // 3 завдання 
        // Ініціалізувати сортований набір з використанням компаратора
        SortedSet<Food> sortedFoodSet = new TreeSet<>(new PriceComparator());

        // Додати елементи до сортованого набору
        sortedFoodSet.add(new Food("Pizza", 12.99));
        sortedFoodSet.add(new Food("Burger", 8.49));
        sortedFoodSet.add(new Food("Salad", 6.99));

        // Використання методу інтерфейсу SortedSet
        System.out.println("Найменший елемент (за ціною): " + sortedFoodSet.first());
        System.out.println("Найбільший елемент (за ціною): " + sortedFoodSet.last());

        // Використання методу інтерфейсу NavigableSet
        System.out.println("Елементи, менші або рівні $10: " + sortedFoodSet.headSet(new Food("", 10)));
        System.out.println("Елементи, більші або рівні $10: " + sortedFoodSet.tailSet(new Food("", 10)));
        
        // 4 завдання
        // Ініціалізувати впорядкований словник
        TreeMap<String, Double> foodDictionary = new TreeMap<>();

  
        foodDictionary.put("Pizza", 12.99);
        foodDictionary.put("Burger", 8.49);
        foodDictionary.put("Salad", 6.99);

     
        System.out.println("\nВпорядкований словник:");
        for (Map.Entry<String, Double> entry : foodDictionary.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }
}
