package KI304.Pliuvak.Lab6;

import java.util.ArrayList;
import java.util.List;

/**
 * Параметризований контейнер “Відсік для зброї” (варіант 18).
 * @param <T> тип елемента, який зберігається у відсіку
 */
public class Armory<T extends ArmoryItem> {

    private final List<T> items;

    public Armory() {
        this.items = new ArrayList<>();
    }

    /** 1) Розміщення елемента у відсіку */
    public void addItem(T item) {
        items.add(item);
    }

    /** 2) Виймання (видалення) елемента за індексом */
    public T removeItem(int index) {
        checkIndex(index);
        return items.remove(index);
    }

    /** 3) Виймання (отримання) елемента за індексом без видалення */
    public T getItem(int index) {
        checkIndex(index);
        return items.get(index);
    }

    /** 4) Заміна елемента (редагування) */
    public void setItem(int index, T newItem) {
        checkIndex(index);
        items.set(index, newItem);
    }

    /** Додатково: кількість елементів */
    public int count() {
        return items.size();
    }

    /**
     * Парний варіант: пошук мінімального елемента.
     * Мінімальний = той, у кого compareTo() дає найменше значення (за size).
     */
    public T findMin() {
        if (items.isEmpty()) return null;

        T min = items.get(0);
        for (int i = 1; i < items.size(); i++) {
            if (items.get(i).compareTo(min) < 0) {
                min = items.get(i);
            }
        }
        return min;
    }

    /** Додатково: друк усього вмісту (зручно для захисту) */
    public void printAll() {
        if (items.isEmpty()) {
            System.out.println("Armory is empty.");
            return;
        }
        System.out.println("Armory contents (" + items.size() + " items):");
        for (int i = 0; i < items.size(); i++) {
            System.out.print("#" + i + " -> ");
            items.get(i).print();
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " out of bounds for armory size " + items.size()
            );
        }
    }
}
