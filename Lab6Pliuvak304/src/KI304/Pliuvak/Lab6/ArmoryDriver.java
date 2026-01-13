package KI304.Pliuvak.Lab6;

/**
 * Драйвер для лабораторної №6 (варіант 18).
 * Демонструє роботу параметризованого контейнера Armory з різними типами елементів.
 */
public class ArmoryDriver {
    public static void main(String[] args) {
        // Контейнер з елементами типу ArmoryItem (можна додавати різні реалізації)
        Armory<ArmoryItem> armory = new Armory<>();

        // Мінімум 2 різні класи (Weapon і AmmoCrate)
        armory.addItem(new Weapon("Glock 17", "Pistol", 30));
        armory.addItem(new AmmoCrate("9x19", 150, 45));
        armory.addItem(new Weapon("AK-74", "Rifle", 80));
        armory.addItem(new AmmoCrate("5.45x39", 300, 60));

        System.out.println("=== After adding ===");
        armory.printAll();

        System.out.println("\n=== Get item #1 (without removing) ===");
        armory.getItem(1).print();

        System.out.println("\n=== Find MIN (парний варіант) ===");
        ArmoryItem min = armory.findMin();
        if (min != null) {
            System.out.print("Min element is: ");
            min.print();
        }

        System.out.println("\n=== Remove item #2 ===");
        ArmoryItem removed = armory.removeItem(2);
        System.out.print("Removed: ");
        removed.print();

        System.out.println("\n=== Replace item #0 ===");
        armory.setItem(0, new Weapon("CZ P-10", "Pistol", 25));

        System.out.println("\n=== Final contents ===");
        armory.printAll();
    }
}
