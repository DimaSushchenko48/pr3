import java.io.File;
import java.util.Scanner;

class FileCounter {
    public static void main(String[] args) {
        // Створення сканера для введення
        Scanner scanner = new Scanner(System.in);

        // Введення директорії та формату файлів
        System.out.print("Введіть шлях до директорії: ");
        String directoryPath = scanner.nextLine();

        System.out.print("Введіть розширення файлів (наприклад, .pdf): ");
        String fileExtension = scanner.nextLine();

        // Створення об'єкта File для директорії
        File directory = new File(directoryPath);

        // Перевірка, чи існує директорія
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Вказана директорія не існує або не є директорією.");
            scanner.close();
            return;
        }

        // Виклик методу для пошуку файлів з певним розширенням
        int count = countFilesWithExtension(directory, fileExtension);

        // Виведення результату
        System.out.println("Кількість файлів з розширенням " + fileExtension + ": " + count);

        // Закриття сканера
        scanner.close();
    }

    // Метод для рекурсивного пошуку файлів з певним розширенням
    public static int countFilesWithExtension(File directory, String fileExtension) {
        int count = 0;

        // Отримуємо список файлів у директорії
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Якщо це підкаталог, рекурсивно викликаємо метод
                    count += countFilesWithExtension(file, fileExtension);
                } else {
                    // Якщо це файл, перевіряємо його розширення
                    if (file.getName().endsWith(fileExtension)) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}