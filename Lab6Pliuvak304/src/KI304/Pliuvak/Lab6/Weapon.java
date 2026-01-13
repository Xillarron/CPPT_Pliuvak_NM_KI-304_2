package KI304.Pliuvak.Lab6;

/**
 * Зброя як елемент відсіку.
 */
public class Weapon implements ArmoryItem {
    private String name;
    private String type;     // наприклад: "Pistol", "Rifle"
    private int size;        // умовний розмір

    public Weapon(String name, String type, int size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public String getName() { return name; }
    public String getType() { return type; }

    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }

    @Override
    public int getSize() { return size; }

    public void setSize(int size) { this.size = size; }

    @Override
    public int compareTo(ArmoryItem other) {
        Integer s = this.size;
        return s.compareTo(other.getSize());
    }

    @Override
    public void print() {
        System.out.println("Weapon: " + name + " (" + type + "), size=" + size);
    }
}
