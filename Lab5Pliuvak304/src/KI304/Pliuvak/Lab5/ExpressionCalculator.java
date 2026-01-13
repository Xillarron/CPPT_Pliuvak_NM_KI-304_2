package KI304.Pliuvak.Lab5;

/**
 * Клас для обчислення виразу:
 * y = tg(x) / (sin(4x) – 2cos(x))
 *
 * Логіка з ЛР4 (варіант 18), з перевірками та винятками.
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

        double cos = Math.cos(x);
        if (Math.abs(cos) < 1e-10) {
            throw new IllegalArgumentException(
                    "Тангенс не визначений при цьому значенні x (cos(x) = 0)."
            );
        }

        double denominator = Math.sin(4 * x) - 2 * Math.cos(x);

        if (Math.abs(denominator) < 1e-10) {
            throw new IllegalArgumentException(
                    "Знаменник дорівнює нулю (sin(4x) – 2cos(x) = 0), вираз не визначений."
            );
        }

        double result = Math.tan(x) / denominator;

        if (Double.isNaN(result) || Double.isInfinite(result)) {
            throw new IllegalArgumentException(
                    "Результат не є числом (NaN або Infinity)."
            );
        }

        return result;
    }
}
