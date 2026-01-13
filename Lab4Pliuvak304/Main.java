package IPZ23.Plyuvak.Lab4;

import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Драйвер програми: вводить x, обчислює y, записує у файл.
 */
public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Введіть x (радіани): ");
            double x = in.nextDouble();

            System.out.print("Введіть ім'я файлу: ");
            String file = in.next();

            PrintWriter fout = new PrintWriter(file);

            try {
                Equation eq = new Equation();
                double y = eq.calculate(x);

                fout.println("x = " + x);
                fout.println("y = " + y);

                System.out.println("Результат записано у файл.");
            }
            finally {
                fout.flush();
                fout.close();
            }

        } catch (CalcException ex) {
            System.out.println("Помилка обчислення: " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.out.println("Помилка: файл не знайдено");
        }
    }
}
