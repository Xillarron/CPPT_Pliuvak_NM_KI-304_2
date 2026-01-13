/**
 * Меню для керування класом ScannerDevice.
 * Демонструє можливості реалізованого класу.
 */

package KI304.Pliuvak.Lab2;

import java.io.IOException;
import java.util.Scanner;

public class ScannerMenu {
    public static void main(String[] args) {
        try {
            ScannerDevice scanner = new ScannerDevice();
            Scanner input = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n===== МЕНЮ СКАНЕРА =====");
                System.out.println("1. Увімкнути сканер");
                System.out.println("2. Вимкнути сканер");
                System.out.println("3. Сканувати документ");
                System.out.println("4. Додати папір");
                System.out.println("5. Очистити сканер");
                System.out.println("6. Змінити роздільну здатність");
                System.out.println("7. Переглянути стан пристрою");
                System.out.println("0. Вийти");
                System.out.print("Ваш вибір: ");

                choice = input.nextInt();

                switch (choice) {
                    case 1 -> scanner.powerOn();
                    case 2 -> scanner.powerOff();
                    case 3 -> scanner.startScan();
                    case 4 -> {
                        System.out.print("Скільки аркушів додати? ");
                        int sheets = input.nextInt();
                        scanner.addPaper(sheets);
                    }
                    case 5 -> scanner.cleanScanner();
                    case 6 -> {
                        System.out.print("Введіть нову роздільну здатність (DPI): ");
                        int dpi = input.nextInt();
                        scanner.setResolution(dpi);
                    }
                    case 7 -> scanner.showStatus();
                    case 0 -> {
                        scanner.close();
                        System.out.println("Програму завершено.");
                    }
                    default -> System.out.println("❌ Невірний вибір!");
                }

            } while (choice != 0);

            input.close();
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
