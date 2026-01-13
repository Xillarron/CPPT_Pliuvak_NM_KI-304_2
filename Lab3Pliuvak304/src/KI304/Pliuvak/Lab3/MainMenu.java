package KI304.Pliuvak.Lab3;

import java.io.IOException;
import java.util.Scanner;

/**
 * Клас MainMenu забезпечує взаємодію користувача з об'єктом SmartScanner.
 */
public class MainMenu {
    public static void main(String[] args) {
        try {
            SmartScanner scanner = new SmartScanner("Canon SmartX", 1200, 5, false);
            Scanner input = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n===== МЕНЮ SMART СКАНЕРА =====");
                System.out.println("1. Увімкнути сканер");
                System.out.println("2. Вимкнути сканер");
                System.out.println("3. Підключитись до Wi-Fi");
                System.out.println("4. Відключитись від Wi-Fi");
                System.out.println("5. Сканувати документ");
                System.out.println("6. Додати папір");
                System.out.println("7. Переглянути стан");
                System.out.println("0. Вийти");
                System.out.print("Ваш вибір: ");
                choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1 -> scanner.powerOn();
                    case 2 -> scanner.powerOff();
                    case 3 -> {
                        System.out.print("Назва Wi-Fi мережі: ");
                        String wifi = input.nextLine();
                        scanner.connectWiFi(wifi);
                    }
                    case 4 -> scanner.disconnectWiFi();
                    case 5 -> scanner.startScan();
                    case 6 -> {
                        System.out.print("Кількість аркушів: ");
                        int sheets = input.nextInt();
                        scanner.addPaper(sheets);
                    }
                    case 7 -> scanner.showStatus();
                    case 0 -> {
                        scanner.close();
                        System.out.println("✅ Програму завершено.");
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
