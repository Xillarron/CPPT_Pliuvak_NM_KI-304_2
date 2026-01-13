"""
Клас MemoryUnit представляє модуль пам'яті для зберігання зображень,
захоплених сканером. Він дозволяє зберігати, видаляти та отримувати список збережених зображень.
"""

from typing import List
from collections import defaultdict

class MemoryUnit:
    """
    Клас для модуля пам'яті.
    """

    def __init__(self, capacity=1000):
        """
        Конструктор за замовчуванням, який ініціалізує модуль пам'яті з місткістю 1000 одиниць.

        :param capacity: початкова місткість
        """
        self.capacity = capacity
        self.saved_images = {}  # Словник для зберігання: {name: image}

    def save_image(self, name, image):
        """
        Зберігає зображення в пам'ять під зазначеним іменем.

        :param name: ім'я зображення
        :param image: зображення у вигляді рядка
        """
        self.saved_images[name] = image

    def delete_image(self, name):
        """
        Видаляє зображення з пам'яті за вказаним ім'ям.

        :param name: ім'я зображення
        :return: True, якщо зображення було видалено, інакше False
        """
        return self.saved_images.pop(name, None) is not None

    def get_image_list(self) -> List[str]:
        """
        Повертає список імен всіх збережених зображень.

        :return: список імен збережених зображень
        """
        return list(self.saved_images.keys())

    def get_free_space(self):
        """
        Повертає кількість вільного місця в пам'яті.

        :return: кількість вільного місця
        """
        return self.capacity - len(self.saved_images)

    def clear_all(self):
        """
        Очищає всю пам'ять, видаляючи всі збережені зображення.
        """
        self.saved_images.clear()
