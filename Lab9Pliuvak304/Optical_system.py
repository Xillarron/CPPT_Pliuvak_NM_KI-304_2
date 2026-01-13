"""
Клас OpticalSystem представляє оптичну систему сканера, яка відповідає за захоплення зображень
з заданою роздільною здатністю.
"""

class OpticalSystem:
    """
    Клас для оптичної системи.
    """

    def __init__(self, resolution=300):
        """
        Конструктор за замовчуванням, який ініціалізує оптичну систему з роздільною здатністю 300 DPI.

        :param resolution: початкова роздільна здатність в DPI
        """
        self.resolution = resolution

    def set_resolution(self, resolution):
        """
        Встановлює нову роздільну здатність для оптичної системи.

        :param resolution: нова роздільна здатність в DPI
        """
        self.resolution = resolution

    def get_resolution(self):
        """
        Повертає поточну роздільну здатність оптичної системи.

        :return: поточна роздільна здатність в DPI
        """
        return self.resolution

    def capture_image(self):
        """
        Захоплює зображення з використанням поточної роздільної здатності.

        :return: рядок з інформацією про захоплене зображення та роздільну здатність
        """
        return f"Captured image at {self.resolution} DPI"
