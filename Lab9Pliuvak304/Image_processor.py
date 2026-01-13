"""
Клас ImageProcessor представляє систему для обробки зображень,
яка має налаштовувану швидкість обробки.
"""

class ImageProcessor:
    """
    Клас для процесора зображень.
    """

    def __init__(self, processing_speed=5):
        """
        Конструктор за замовчуванням, який ініціалізує систему обробки зображень зі швидкістю 5.

        :param processing_speed: початкова швидкість обробки зображень
        """
        self.processing_speed = processing_speed

    def set_processing_speed(self, speed):
        """
        Встановлює нову швидкість обробки зображень.

        :param speed: нова швидкість обробки
        """
        self.processing_speed = speed

    def get_processing_speed(self):
        """
        Повертає поточну швидкість обробки зображень.

        :return: поточна швидкість обробки
        """
        return self.processing_speed

    def process_image(self, raw_image):
        """
        Обробляє зображення з використанням поточної швидкості обробки.

        :param raw_image: необроблене зображення
        :return: рядок, що представляє процес обробки з зазначенням швидкості
        """
        return f"Процес: {raw_image} з швидкістю {self.processing_speed}"
