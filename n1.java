import java.util.Random;
import java.util.Scanner;

class PairwiseSum {
    public static void main(String[] args) {
        // Створення об'єкту для сканера
        Scanner scanner = new Scanner(System.in);

        // Введення розміру масиву та діапазону
        System.out.print("Введіть кількість елементів масиву: ");
        int n = scanner.nextInt();

        System.out.print("Введіть мінімальне значення для елементів масиву: ");
        int minValue = scanner.nextInt();

        System.out.print("Введіть максимальне значення для елементів масиву: ");
        int maxValue = scanner.nextInt();

        // Створення масиву
        int[] array = new int[n];
        Random random = new Random();

        // Заповнення масиву випадковими числами в діапазоні [minValue, maxValue]
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }

        // Виведення згенерованого масиву
        System.out.println("Згенерований масив:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // Обчислення попарної суми
        long startTime = System.nanoTime(); // Час початку виконання

        long sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += array[i] + array[i + 1];
        }

        long endTime = System.nanoTime(); // Час завершення виконання

        // Виведення результату
        System.out.println("Попарна сума всіх елементів масиву: " + sum);
        System.out.println("Час виконання програми: " + (endTime - startTime) + " наносекунд");

        // Закриття сканера
        scanner.close();
    }
}