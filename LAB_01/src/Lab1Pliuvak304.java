import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lab1Pliuvak304 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть розмір матриці: ");
        int row = sc.nextInt();

        System.out.print("Введіть символ заповнювач: ");
        String symbol = sc.next();

        if (symbol.length() != 1) {
            System.out.println("Введіть коректний символ заповнювач!");
            return;
        }

        String[][] arr = createLengthOfEachSubArr(row);
        String fileName = "Lab1.txt";

        try {
            printMatrix(arr, symbol, row, fileName);
        } catch (IOException e) {
            throw new RuntimeException("Сталася помилка під час запису у файл: " + e.getMessage());
        }
    }

    //  Нова функція: перевірка, чи комірка є на рамці
    public static boolean isBorderCell(int i, int j, int n) {
        return (i == 0 || i == n - 1 || j == 0 || j == n - 1);
    }

    //  Нова функція: перевірка, чи комірка всередині фігури (крім меж)
    public static boolean isInnerPatternCell(int i, int j, int n) {
        return (i != 1 && i != n - 2 && j != 1 && j != n - 2);
    }
10
    //  Основний метод побудови матриці
    public static void printMatrix(String[][] arr, String symbol, int row, String file) throws IOException {
        System.out.println("Результат матриці:");

        try (FileWriter writer = new FileWriter(file)) {

            for (int i = 0; i < row; i++) {
                int indexJ = 0;

                for (int j = 0; j < row; j++) {

                    // 💡 Замість громіздкої умови — два зрозумілих виклики
                    if (isBorderCell(i, j, row) || isInnerPatternCell(i, j, row)) {
                        arr[i][indexJ] = symbol;
                        writer.write(symbol + " ");
                        System.out.print(symbol + " ");
                        if(i==0){
                            arr[0][indexJ] = "o";
                        }
                        indexJ++;


                    } else {
                        writer.write("  ");
                        System.out.print("  ");
                    }
                }

                writer.write("\n");
                System.out.println();
            }
        }
    }

    //  Залишаємо створення зубчастого масиву як є
    public static String[][] createLengthOfEachSubArr(int row) {
        String[][] arr = new String[row][];

        for (int i = 0; i < row; i++) {
            int length = 0;

            for (int j = 0; j < row; j++) {
                if (isBorderCell(i, j, row) || isInnerPatternCell(i, j, row)) {
                    length++;
                }
            }
            arr[i] = new String[length];
        }

        return arr;
    }
}
