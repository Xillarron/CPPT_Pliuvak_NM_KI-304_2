"""
Клас Main є точкою входу в програму та демонструє роботу з копіювальним апаратом,
використовуючи різні методи класу CopyingMachine.
"""

from .copying_machine import CopyingMachine
import io  # Для обробки помилок IO

def main():
    """
    Точка входу в програму. Демонструє роботу з копіювальним апаратом шляхом виклику різних методів.
    """
    try:
        copier = CopyingMachine()

        copier.make_copy("Документ1")
        copier.adjust_contrast(30)
        copier.adjust_brightness(44)

        print(copier.get_status())
        print(f"Контраст: {copier.get_contrast_level()}")
        print(f"Яскравість: {copier.get_brightness_level()}")

        copier.close_logger()
    except IOError as e:
        raise RuntimeError(f"Сталася помилка при записі в файл: {e}")

if __name__ == "__main__":
    main()
