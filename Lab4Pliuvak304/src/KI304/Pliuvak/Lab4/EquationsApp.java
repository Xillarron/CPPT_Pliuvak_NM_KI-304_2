package KI304.Pliuvak.Lab4;


import java.io.IOException;
import java.util.Scanner;

/**
 * Драйвер для запуску програми обчислення виразу.
 * <p>
 * Клас {@code EquationsApp} відповідає за взаємодію з користувачем через консоль:
 * отримання значення змінної {@code x}, обчислення значення виразу та
 * запис результату у файл.
 * </p>
 *

 * @version 1.0
 */
public class EquationsApp {

    /**
     * Точка входу до програми.
     * <p>
     * Виконується:
     * <ul>
     *     <li>зчитування значення {@code x} з консолі;</li>
     *     <li>обчислення значення виразу y = tg(x) / (sin(4x) – 2cos(x));</li>
     *     <li>виведення результату на екран;</li>
     *     <li>запис результату у файл {@code result.txt}.</li>
     * </ul>
     * </p>
     *
     * @param args аргументи командного рядка (не використовуються)
     */
    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator();
        Scanner scanner = new Scanner(System.in);

        try {
            // Отримання значення x від користувача
            System.out.print("Введіть значення x (у радіанах): ");
            double x = scanner.nextDouble();

            // Обчислення результату
            double result = calculator.calculate(x);
            System.out.println("Результат: " + result);

            // Запис результату у файл
            String filePath = "result.txt";
            calculator.writeResultToFile(result, filePath);
            System.out.println("Результат записано у файл: " + filePath);

        } catch (IllegalArgumentException e) {
            // Помилки, пов'язані з некоректними значеннями x або результатом
            System.out.println("Помилка обчислення: " + e.getMessage());
        } catch (IOException e) {
            // Помилки роботи з файлом
            System.out.println("Помилка запису у файл: " + e.getMessage());
        } finally {
            // Закриття сканера для уникнення витоку ресурсів
            scanner.close();
        }
    }
}
