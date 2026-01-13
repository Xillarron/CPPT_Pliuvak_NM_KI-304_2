# -*- coding: utf-8 -*-
# Лабораторна робота №7
# Варіант 18

# matrix_module.py
# Модуль для генерації та виведення jagged матриці


def create_length_array(row):
    """
    Створює зубчастий список (jagged list), де кожен підсписок
    має довжину, що відповідає кількості заштрихованих елементів у рядку матриці.
    Заштрихована область: рамка (межі), з виїмками в рядках/стовпцях 1 та row-2 (внутрішні кути порожні).
    
    Args:
        row (int): Розмір квадратної матриці (n x n, n > 0).
    
    Returns:
        list: Зубчастий список списків з None (довжини різні для jagged-структури).
    
    Raises:
        ValueError: Якщо row <= 0.
    """
    if row <= 0:
        raise ValueError("Розмір матриці має бути позитивним!")
    
    arr = []

    for i in range(row):
        length = 0
        for j in range(row):
            if (
                i == 0 or i == row - 1 or j == 0 or j == row - 1 or
                (i != 1 and i != row - 2 and j != 1 and j != row - 2)
            ):
                length += 1

        arr.append([None] * length)  # Jagged: рядки різної довжини

    return arr

def print_matrix(arr, symbol, row, filename):
    """
    Заповнює зубчастий список символом у заштрихованих позиціях,
    виводить матрицю на екран (з пробілами для квадратного вигляду)
    і записує в файл.
    
    Args:
        arr (list): Зубчастий список з None (від create_length_array).
        symbol (str): Один символ для заповнення (довжина 1).
        row (int): Розмір матриці.
        filename (str): Ім'я файлу для запису (наприклад, 'Lab1.txt').
    
    Returns:
        None: Виводить на екран і в файл.
    
    Raises:
        ValueError: Якщо len(symbol) != 1.
    """
    if len(symbol) != 1:
        raise ValueError("Символ-заповнювач має бути рівно одним символом!")
    
    print("Результат матриці (заштрихована область):")

    with open(filename, "w", encoding="utf-8") as file:
        for i in range(row):
            index_j = 0
            line = ""

            for j in range(row):
                if (
                    i == 0 or i == row - 1 or j == 0 or j == row - 1 or
                    (i != 1 and i != row - 2 and j != 1 and j != row - 2)
                ):
                    arr[i][index_j] = symbol  
                    line += symbol + " "
                    index_j += 1
                else:
                    line += "  "  

            print(line.rstrip
            file.write(line + "\n")
