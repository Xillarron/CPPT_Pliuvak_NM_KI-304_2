package KI304.Pliuvak.Lab6;

/**
 * Ящик з набоями як елемент відсіку.
 */
public class AmmoCrate implements ArmoryItem {
    private String caliber;     // наприклад: "9x19", "5.56"
    private int rounds;         // кількість набоїв
    private int size;           // умовний розмір

    public AmmoCrate(String caliber, int rounds, int size) {
        this.caliber = caliber;
        this.rounds = rounds;
        this.size = size;
    }

    public String getCaliber() { return caliber; }
    public int getRounds() { return rounds; }

    public void setCaliber(String caliber) { this.caliber = caliber; }
    public void setRounds(int rounds) { this.rounds = rounds; }

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
        System.out.println("AmmoCrate: caliber=" + caliber + ", rounds=" + rounds + ", size=" + size);
    }
}
