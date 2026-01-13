"""
Клас CopyingMachine представляє копіювальний апарат, який розширює функціонал класу Scanner
та реалізує операції, визначені абстрактним класом Copyable.

Клас дозволяє виконувати такі операції, як копіювання документів, регулювання контрасту
та яскравості, а також сканування з можливістю збереження результату. Всі операції
супроводжуються логуванням.
"""

from .scanner import Scanner
from .copyable import Copyable
import io  # Для обробки помилок IO

class CopyingMachine(Scanner, Copyable):
    """
    Похідний клас від Scanner, що реалізує Copyable.
    """

    def __init__(self):
        """
        Конструктор класу CopyingMachine. Ініціалізує базовий клас Scanner і налаштовує
        початкові параметри контрасту та яскравості.
        """
        super().__init__()
        self.contrast_level = 50
        self.brightness_level = 50
        try:
            self.logger.log("Копіювальний апарат створено.")
            print("Копіювальний апарат створено.")
        except IOError as e:
            raise IOError(f"Помилка при логуванні: {e}")

    def start_scan(self, document_name):
        """
        Починає процес сканування документа.

        :param document_name: назва документа для сканування
        """
        self.is_scanning = True
        self.current_document = document_name
        try:
            self.logger.log(f"Початок сканування документа: {document_name}")
            print(f"Початок сканування документа: {document_name}")
        except IOError as e:
            raise IOError(f"Помилка при логуванні: {e}")

    def finish_scan(self):
        """
        Завершує процес сканування документа.
        """
        if self.is_scanning:
            self.is_scanning = False
            scanned_image = self.image_processor.process_image(self.optical_system.capture_image())
            self.memory_unit.save_image(self.current_document, scanned_image)
            try:
                self.logger.log(f"Завершення сканування: {self.current_document}")
                print(f"Завершення сканування: {self.current_document}")
                self.current_document = ""
            except IOError as e:
                raise IOError(f"Помилка при логуванні: {e}")

    def make_copy(self, document_name):
        """
        Створює копію документа, спочатку скануючи його, а потім завершуючи процес сканування.

        :param document_name: назва документа для копіювання
        """
        self.start_scan(document_name)
        self.finish_scan()
        try:
            self.logger.log(f"Створено копію документа: {document_name}")
            print(f"Створено копію документа: {document_name}")
        except IOError as e:
            raise IOError(f"Помилка при логуванні: {e}")

    def adjust_contrast(self, level):
        """
        Налаштовує рівень контрасту для копіювального апарату.

        :param level: рівень контрасту (від 0 до 100)
        """
        if 0 <= level <= 100:
            self.contrast_level = level
            try:
                self.logger.log(f"Контраст налаштовано на рівень: {level}")
                print(f"Контраст налаштовано на рівень: {level}")
            except IOError as e:
                raise IOError(f"Помилка при логуванні: {e}")
        else:
            try:
                self.logger.log("Помилка: Недійсний рівень контрасту")
                print("Помилка: Недійсний рівень контрасту")
            except IOError as e:
                raise IOError(f"Помилка при логуванні: {e}")

    def adjust_brightness(self, level):
        """
        Налаштовує рівень яскравості для копіювального апарату.

        :param level: рівень яскравості (від 0 до 100)
        """
        if 0 <= level <= 100:
            self.brightness_level = level
            try:
                self.logger.log(f"Яскравість налаштовано на рівень: {level}")
                print(f"Яскравість налаштовано на рівень: {level}")
            except IOError as e:
                raise IOError(f"Помилка при логуванні: {e}")
        else:
            try:
                self.logger.log("Помилка: Недійсний рівень яскравості")
                print("Помилка: Недійсний рівень яскравості")
            except IOError as e:
                raise IOError(f"Помилка при логуванні: {e}")

    def get_contrast_level(self):
        """
        Метод для отримання поточного рівня контрасту.

        :return: поточний рівень контрасту
        """
        return self.contrast_level

    def get_brightness_level(self):
        """
        Метод для отримання поточного рівня яскравості.

        :return: поточний рівень яскравості
        """
        return self.brightness_level

    def get_status(self):
        """
        Повертає статус копіювального апарату, включаючи поточний стан сканера, рівень контрасту та яскравості.

        :return: рядок, що представляє поточний статус пристрою
        """
        status = super().get_status() + f", Контраст: {self.contrast_level}, Яскравість: {self.brightness_level}"
        return status
