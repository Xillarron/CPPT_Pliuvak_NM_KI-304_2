package KI304.Pliuvak.Lab4;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Клас для обчислення виразу:
 * y = tg(x) / (sin(4x) – 2cos(x))
 *
 * Реалізує механізм виключень для демонстрації роботи помилкових ситуацій.
 */
public class ExpressionCalculator {

    /**
     * Обчислює значення виразу.
     *
     * @param x значення x у радіанах
     * @return результат обчислення
     * @throws IllegalArgumentException якщо вираз не визначений
     */
    public double calculate(double x) throws IllegalArgumentException {

        // Перевірка: tg(x) не визначений, якщо cos(x) ≈ 0
        double cos = Math.cos(x);
        if (Math.abs(cos) < 1e-10) {
            throw new IllegalArgumentException(
                    "Тангенс не визначений при цьому значенні x (cos(x) = 0)."
            );
        }

        // Обчислення знаменника
        double denominator = Math.sin(4 * x) - 2 * Math.cos(x);

        // Перевірка знаменника
        if (Math.abs(denominator) < 1e-10) {
            throw new IllegalArgumentException(
                    "Знаменник дорівнює нулю (sin(4x) – 2cos(x) = 0), вираз не визначений."
            );
        }

        // Обчислення виразу
        double result = Math.tan(x) / denominator;

        // Перевірка на NaN та Infinity
        if (Double.isNaN(result) || Double.isInfinite(result)) {
            throw new IllegalArgumentException(
                    "Результат не є числом (NaN або Infinity)."
            );
        }

        return result;
    }

    /**
     * Записує результат у текстовий файл.
     */
    public void writeResultToFile(double result, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Результат обчислення: " + result);
        }
    }
}
