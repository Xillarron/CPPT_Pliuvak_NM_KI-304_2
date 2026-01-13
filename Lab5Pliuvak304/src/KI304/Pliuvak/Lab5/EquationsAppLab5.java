package KI304.Pliuvak.Lab5;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Драйвер ЛР5: обчислення + запис/читання у TXT та BIN.
 */
public class EquationsAppLab5 {

    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator();
        ExpressionCalculatorIO io = new ExpressionCalculatorIO();

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US); // <<< ВАЖЛИВО

        try {
            System.out.print("Введіть значення x (у радіанах): ");
            double x = scanner.nextDouble(); // ВВОДИТИ 1.1

            double res = calculator.calculate(x);
            System.out.println("Результат: " + res);

            io.setResult(res);

            // TXT

            io.writeResTxt("result.txt");
            System.out.println("Записано у текстовий файл: result.txt");


            io.readResTxt("result.txt");
            System.out.println("Зчитано з текстового файла: " + io.getResult());


            // BIN
            String binFile = "result.bin";
            io.writeResBin(binFile);
            System.out.println("Записано у двійковий файл: " + binFile);

            io.setResult(0);
            io.readResBin(binFile);
            System.out.println("Зчитано з двійкового файла: " + io.getResult());

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка обчислення: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Помилка введення/виведення: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
