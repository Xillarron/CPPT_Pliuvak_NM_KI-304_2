# -*- coding: utf-8 -*-
# Лабораторна робота №7
# Варіант 18

# main.py
# Основний модуль: ввід даних, перевірки, виклик функцій з matrix_module.

import sys
from matrix_module import create_length_array, print_matrix

def main():
    try:
        row = int(input("Введіть розмір матриці: "))
        if row <= 0:
            raise ValueError("Розмір має бути позитивним!")
    except ValueError:
        print("Помилка: розмір має бути додатним цілим числом.")
        sys.exit(1)  # Коректне переривання з кодом помилки

    symbol = input("Введіть символ заповнювач: ").strip()

    if len(symbol) != 1:
        print("Помилка: потрібно ввести рівно один символ.")
        sys.exit(1)  # Коректне переривання

    arr = create_length_array(row)  # Генеруємо jagged list

    
    file_name = "Lab1.txt"
    print_matrix(arr, symbol, row, file_name)

    print("\n--- Фрагмент документації (help для функції): ---")
    help(create_length_array)  
    help(print_matrix)

if __name__ == "__main__":
    main()

