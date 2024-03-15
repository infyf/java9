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
        // 2 �������� 
        Queue<Food> foodOrderQueue = new LinkedList<>();

        foodOrderQueue.offer(new Food("Pizza", 12.99));
        foodOrderQueue.offer(new Food("Burger", 8.49));
        foodOrderQueue.offer(new Food("Salad", 6.99));


        System.out.println("������ ������� ����� (��� ���������): " + foodOrderQueue.peek());


        System.out.println("������ ������� ����� (�� ����������): " + foodOrderQueue.poll());


        System.out.println("ʳ������ �������� � ����: " + foodOrderQueue.size());
        // 1 �������� 

        LinkedList<Food> foodOrderList = new LinkedList<>();
        foodOrderList.add(new Food("Pizza", 12.99));
        foodOrderList.add(new Food("Burger", 8.49));
        foodOrderList.add(new Food("Salad", 6.99));

        // ���� �������� ������ � ������� ������� 1 �������� 
        System.out.println("������ �������:");
        for (Food food : foodOrderList) {
            System.out.println(food);
        }

        // ���� �������� ������ � ����������� �������
        System.out.println("\n�������� �������:");
        for (int i = foodOrderList.size() - 1; i >= 0; i--) {
            System.out.println(foodOrderList.get(i));
        }
        // 3 �������� 
        // ������������ ���������� ���� � ������������� �����������
        SortedSet<Food> sortedFoodSet = new TreeSet<>(new PriceComparator());

        // ������ �������� �� ����������� ������
        sortedFoodSet.add(new Food("Pizza", 12.99));
        sortedFoodSet.add(new Food("Burger", 8.49));
        sortedFoodSet.add(new Food("Salad", 6.99));

        // ������������ ������ ���������� SortedSet
        System.out.println("��������� ������� (�� �����): " + sortedFoodSet.first());
        System.out.println("��������� ������� (�� �����): " + sortedFoodSet.last());

        // ������������ ������ ���������� NavigableSet
        System.out.println("��������, ����� ��� ��� $10: " + sortedFoodSet.headSet(new Food("", 10)));
        System.out.println("��������, ����� ��� ��� $10: " + sortedFoodSet.tailSet(new Food("", 10)));
        
        // 4 ��������
        // ������������ ������������� �������
        TreeMap<String, Double> foodDictionary = new TreeMap<>();

  
        foodDictionary.put("Pizza", 12.99);
        foodDictionary.put("Burger", 8.49);
        foodDictionary.put("Salad", 6.99);

     
        System.out.println("\n������������� �������:");
        for (Map.Entry<String, Double> entry : foodDictionary.entrySet()) {
            System.out.println(entry.getKey() + " - $" + entry.getValue());
        }
    }
}
