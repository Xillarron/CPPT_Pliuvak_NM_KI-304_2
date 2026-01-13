package KI304.Pliuvak.Lab5;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Клас для збереження та зчитування результатів
 * у текстовому та двійковому форматах.
 */
public class ExpressionCalculatorIO {

    private double result;

    public ExpressionCalculatorIO() {
    }

    public ExpressionCalculatorIO(double result) {
        this.result = result;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    /**
     * Запис результату у текстовий файл.
     * Формат: одне число типу double (з крапкою).
     */
    public void writeResTxt(String fileName) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(result);
        }
    }

    /**
     * Зчитування результату з текстового файлу.
     * Очікується одне число типу double (з крапкою).
     */
    public void readResTxt(String fileName) throws FileNotFoundException {
        File f = new File(fileName);
        if (!f.exists()) {
            throw new FileNotFoundException("Файл " + fileName + " не знайдено");
        }

        try (Scanner sc = new Scanner(f)) {
            sc.useLocale(Locale.US); // <<< ВАЖЛИВО

            if (sc.hasNextDouble()) {
                result = sc.nextDouble();
            } else {
                throw new IllegalArgumentException(
                        "У файлі немає коректного числа типу double"
                );
            }
        }
    }

    /**
     * Запис результату у двійковий файл.
     */
    public void writeResBin(String fileName) throws IOException {
        try (DataOutputStream out =
                     new DataOutputStream(new FileOutputStream(fileName))) {
            out.writeDouble(result);
        }
    }

    /**
     * Зчитування результату з двійкового файлу.
     */
    public void readResBin(String fileName) throws IOException {
        try (DataInputStream in =
                     new DataInputStream(new FileInputStream(fileName))) {
            result = in.readDouble();
        }
    }
}
