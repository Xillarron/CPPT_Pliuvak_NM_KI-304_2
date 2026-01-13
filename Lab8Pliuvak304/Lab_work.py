"""
Програма обчислює вираз y = tan(x) / (sin(4x) - 2*cos(x)),
зчитує значення x від користувача, виводить результат,
записує його у текстовий та двійковий файли, а потім зчитує назад.

"""

import math
import struct

def calculate_expression(x):
    """
    Обчислює вираз y = tan(x) / (sin(4x) - 2*cos(x)).

    :param x: значення змінної x (радіани)
    :return: результат обчислення виразу
    :raises ValueError: якщо знаменник дорівнює нулю (вираз не визначений)
    """
    denominator = math.sin(4 * x) - 2 * math.cos(x)
    if abs(denominator) < 1e-10:  # Перевірка на близькість до нуля через похибку обчислень
        raise ValueError("Знаменник дорівнює нулю, вираз не визначений.")
    
    return math.tan(x) / denominator

def write_text(result, file_path):
    """
    Записує результат обчислення у текстовий файл.

    :param result: результат для запису (float)
    :param file_path: шлях до файлу
    :raises IOError: якщо виникає помилка при записі
    """
    try:
        with open(file_path, 'w', encoding='utf-8') as file:
            file.write(f"Результат обчислення: {result}\n")
    except IOError as e:
        raise IOError(f"Помилка запису у текстовий файл: {e}")

def read_text(file_path):
    """
    Зчитує результат з текстового файлу.

    :param file_path: шлях до файлу
    :return: зчитане значення результату (float)
    :raises IOError: якщо виникає помилка при читанні або файл некоректний
    """
    try:
        with open(file_path, 'r', encoding='utf-8') as file:
            line = file.readline().strip()
            if ':' in line:
                value_part = line.split(':')[1].strip()
                return float(value_part)
            else:
                raise IOError("Некоректний формат текстового файлу.")
    except IOError as e:
        raise IOError(f"Помилка читання з текстового файлу: {e}")

def write_binary(result, file_path):
    """
    Записує результат обчислення у двійковий файл.

    :param result: результат для запису (float)
    :param file_path: шлях до файлу
    :raises IOError: якщо виникає помилка при записі
    """
    try:
        with open(file_path, 'wb') as file:
            file.write(struct.pack('d', result))  # 'd' - формат для double (8 байт)
    except IOError as e:
        raise IOError(f"Помилка запису у двійковий файл: {e}")

def read_binary(file_path):
    """
    Зчитує результат з двійкового файлу.

    :param file_path: шлях до файлу
    :return: зчитане значення результату (float)
    :raises IOError: якщо виникає помилка при читанні
    """
    try:
        with open(file_path, 'rb') as file:
            data = file.read()
            if len(data) != 8:  # Перевірка розміру даних для double
                raise IOError("Некоректний розмір двійкового файлу.")
            return struct.unpack('d', data)[0]
    except IOError as e:
        raise IOError(f"Помилка читання з двійкового файлу: {e}")

def main():
    """
    Точка входу в програму.
    Зчитує x, обчислює, записує/зчитує файли.
    """
    try:
        user_input = input("Введіть значення x: ").strip()
        x = float(user_input)

        result = calculate_expression(x)
        print(f"Результат обчислення: {result}")

        text_file = "result.txt"
        write_text(result, text_file)
        print("Текстовий файл записано.")
        
        text_read = read_text(text_file)
        print(f"Зчитано з текстового файлу: {text_read}")

        binary_file = "result.dat"
        write_binary(result, binary_file)
        print("Двійковий файл записано.")
        
        binary_read = read_binary(binary_file)
        print(f"Зчитано з двійкового файлу: {binary_read}")

    except ValueError as e:
        print(f"Помилка введення або обчислення: {e}")
    except IOError as e:
        print(f"Помилка роботи з файлом: {e}")
    except Exception as e:
        print(f"Несподівана помилка: {e}")

if __name__ == "__main__":
    main()
