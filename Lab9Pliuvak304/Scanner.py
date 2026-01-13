"""
Клас Scanner представляє базовий абстрактний клас для сканера, який здійснює сканування документів,
обробку зображень та управління пам'яттю для збережених зображень.
"""

from abc import ABC, abstractmethod
from .optical_system import OpticalSystem
from .image_processor import ImageProcessor
from .memory_unit import MemoryUnit
from .logger import Logger
import io  # Для обробки помилок IO

class Scanner(ABC):
    """
    Абстрактний базовий клас для сканера.
    """

    def __init__(self, optical_system=None, image_processor=None, memory_unit=None):
        """
        Конструктор для створення сканера з опціональними підсистемами.
        Якщо не передані, створюються дефолтні.
        """
        if optical_system is None:
            self.optical_system = OpticalSystem()
        else:
            self.optical_system = optical_system
        
        if image_processor is None:
            self.image_processor = ImageProcessor()
        else:
            self.image_processor = image_processor
        
        if memory_unit is None:
            self.memory_unit = MemoryUnit()
        else:
            self.memory_unit = memory_unit
        
        self.is_scanning = False
        self.current_document = ""

        try:
            self.logger = Logger("scanner_log.txt")
            self.logger.log(f"Сканер {self.__repr__()} створено.")
        except IOError as e:
            raise IOError(f"Помилка при створенні лог-файлу: {e}")

    @abstractmethod
    def start_scan(self, document_name):
        """
        Абстрактний метод для початку сканування документа.

        :param document_name: назва документа для сканування
        """
        pass

    @abstractmethod
    def finish_scan(self):
        """
        Абстрактний метод для завершення сканування.
        """
        pass

    def cancel_scan(self):
        """
        Метод для скасування сканування.
        """
        if self.is_scanning:
            self.is_scanning = False

            try:
                self.logger.log(f"Скасування сканування: {self.current_document}")
                print(f"Скасування сканування: {self.current_document}")
                self.current_document = ""
            except IOError as e:
                raise IOError(f"Помилка при логуванні: {e}")

    def change_resolution(self, resolution):
        """
        Метод для зміни роздільної здатності сканера.

        :param resolution: нове значення роздільної здатності
        """
        self.optical_system.set_resolution(resolution)

        try:
            self.logger.log(f"Зміна роздільної здатності на: {resolution}")
            print(f"Зміна роздільної здатності на: {resolution}")
        except IOError as e:
            raise IOError(f"Помилка при логуванні: {e}")

    def change_processing_speed(self, speed):
        """
        Метод для зміни швидкості обробки зображень.

        :param speed: нове значення швидкості обробки
        """
        self.image_processor.set_processing_speed(speed)

        try:
            self.logger.log(f"Зміна швидкості обробки на: {speed}")
            print(f"Зміна швидкості обробки на: {speed}")
        except IOError as e:
            raise IOError(f"Помилка при логуванні: {e}")

    def delete_image(self, image_name):
        """
        Метод для видалення зображення з пам'яті.

        :param image_name: назва зображення
        :return: True, якщо зображення видалено, інакше False
        """
        if self.memory_unit.delete_image(image_name):
            try:
                self.logger.log(f"Видалено зображення: {image_name}")
                print(f"Видалено зображення: {image_name}")
                return True
            except IOError as e:
                raise IOError(f"Помилка при логуванні: {e}")
        else:
            try:
                self.logger.log(f"Не вдалося видалити зображення: {image_name}")
                print(f"Не вдалося видалити зображення: {image_name}")
                return False
            except IOError as e:
                raise IOError(f"Помилка при логуванні: {e}")

    def get_saved_images(self):
        """
        Метод для отримання списку всіх збережених зображень.

        :return: список зображень
        """
        try:
            self.logger.log("Запит списку збережених зображень")
            print("Запит списку збережених зображень")
            return self.memory_unit.get_image_list()
        except IOError as e:
            raise IOError(f"Помилка при логуванні: {e}")

    def is_scanning(self):
        """
        Метод для перевірки стану сканування.

        :return: True, якщо сканування в процесі, інакше False
        """
        try:
            self.logger.log(f"Відбувається сканування: {self.is_scanning}")
            print(f"Відбувається сканування: {self.is_scanning}")
            return self.is_scanning
        except IOError as e:
            raise IOError(f"Помилка при логуванні: {e}")

    def get_status(self):
        """
        Метод для отримання інформації про поточний стан сканера.

        :return: рядок з інформацією про стан сканера
        """
        status = f"Стан сканера: {'Сканування' if self.is_scanning else 'Очікування'}, " \
                 f"Роздільна здатність: {self.optical_system.get_resolution()}, " \
                 f"Швидкість обробки: {self.image_processor.get_processing_speed()}, " \
                 f"Вільна пам'ять: {self.memory_unit.get_free_space()}"

        try:
            self.logger.log("Запит стану сканера")
            print("Запит стану сканера")
            print(status)  # Виводимо в консоль для аналогії з Java
            return status
        except IOError as e:
            raise IOError(f"Помилка при логуванні: {e}")

    def clear_memory(self):
        """
        Метод для очищення всієї пам'яті сканера.
        """
        self.memory_unit.clear_all()

        try:
            self.logger.log("Очищення всієї пам'яті сканера.")
            print("Очищення всієї пам'яті сканера.")
        except IOError as e:
            raise IOError(f"Помилка при логуванні: {e}")

    def close_logger(self):
        """
        Закриває логер для збереження даних у файл.
        """
        try:
            self.logger.close()
        except IOError as e:
            print(f"Виникла помилка при закритті логера: {e}")
