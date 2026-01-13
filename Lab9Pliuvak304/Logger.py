"""
Клас Logger забезпечує логування повідомлень у файл.
Використовується для запису дій та подій, що відбуваються в програмі.
"""

import io

class Logger:
    """
    Клас для логування в файл.
    """

    def __init__(self, file_name):
        """
        Конструктор створює об'єкт Logger для запису повідомлень у вказаний файл.

        :param file_name: ім'я файлу для запису логів
        """
        try:
            self.file_handler = open(file_name, 'a', encoding='utf-8')
        except IOError as e:
            raise IOError(f"Помилка при створенні або відкритті файлу: {e}")

    def log(self, message):
        """
        Метод записує повідомлення у файл логу.

        :param message: повідомлення, яке потрібно записати у файл
        """
        if self.file_handler:
            try:
                self.file_handler.write(message + "\n")
                self.file_handler.flush()
            except IOError as e:
                raise IOError(f"Помилка при записі у файл: {e}")

    def close(self):
        """
        Метод закриває файл логу, звільняючи всі ресурси, пов'язані з ним.
        У разі виникнення помилки при закритті, повідомлення про помилку буде виведено в консоль.
        """
        if self.file_handler:
            try:
                self.file_handler.close()
            except IOError as e:
                print(f"Виникла помилка при закритті файлу: {e}")
