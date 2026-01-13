"""
Абстрактний базовий клас Copyable визначає набір операцій для копіювального апарату.
До основних операцій належать створення копії документа, регулювання контрастності
та яскравості під час копіювання.
"""

from abc import ABC, abstractmethod
import io  # Для обробки помилок IO

class Copyable(ABC):
    """
    Абстрактний базовий клас для операцій копіювання.
    """

    @abstractmethod
    def make_copy(self, document_name):
        """
        Створює копію документа.

        :param document_name: назва документа для копіювання
        """
        pass

    @abstractmethod
    def adjust_contrast(self, level):
        """
        Регулює контрастність копії.

        :param level: рівень контрастності (від 0 до 100)
        """
        pass

    @abstractmethod
    def adjust_brightness(self, level):
        """
        Регулює яскравість копії.

        :param level: рівень яскравості (від 0 до 100)
        """
        pass
