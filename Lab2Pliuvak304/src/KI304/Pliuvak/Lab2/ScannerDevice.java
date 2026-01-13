
package KI304.Pliuvak.Lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Клас ScannerDevice моделює роботу сканера.
 * Містить складові частини: що сканує головку, лоток для паперу та панель керування.
 * Усі дії сканера записуються у файл журналу.
 */
public class ScannerDevice {
    // === Поля класу ===
    private String model;
    private int resolutionDPI;
    private int paperSheets;
    private boolean powerOn;
    private FileWriter logWriter;

    // === Конструктори ===

    /**
     * Конструктор за замовчуванням.
     */
    public ScannerDevice() throws IOException {
        this("Canon L220", 600, 10, false);
    }

    /**
     * Конструктор із параметрами.
     * @param model модель сканера
     * @param resolutionDPI роздільна здатність (DPI)
     * @param paperSheets кількість аркушів
     * @param powerOn стан живлення
     */
    public ScannerDevice(String model, int resolutionDPI, int paperSheets, boolean powerOn) throws IOException {
        this.model = model;
        this.resolutionDPI = resolutionDPI;
        this.paperSheets = paperSheets;
        this.powerOn = powerOn;
        this.logWriter = new FileWriter("scanner_log.txt", true);
        log("Сканер створено: " + model + ", " + resolutionDPI + " DPI, аркушів: " + paperSheets);
    }

    // === Методи ===

    /**
     * Увімкнення сканера.
     */
    public void powerOn() throws IOException {
        if (!powerOn) {
            powerOn = true;
            log("Сканер увімкнено.");
        } else {
            log("Сканер уже увімкнений.");
        }
    }

    /**
     * Вимкнення сканера.
     */
    public void powerOff() throws IOException {
        if (powerOn) {
            powerOn = false;
            log("Сканер вимкнено.");
        } else {
            log("Сканер уже вимкнений.");
        }
    }

    /**
     * Перевірка наявності паперу.
     */
    public boolean hasPaper() throws IOException {
        log("Перевірка наявності паперу: " + (paperSheets > 0));
        return paperSheets > 0;
    }

    /**
     * Додати аркуші паперу.
     */
    public void addPaper(int sheets) throws IOException {
        paperSheets += sheets;
        log("Додано " + sheets + " аркушів. Тепер у лотку: " + paperSheets);
    }

    /**
     * Виконати сканування.
     */
    public void startScan() throws IOException {
        if (!powerOn) {
            log("Сканування неможливе: пристрій вимкнений!");
            return;
        }
        if (paperSheets <= 0) {
            log("Сканування неможливе: немає паперу!");
            return;
        }

        paperSheets--;
        log("Виконано сканування. Залишилось аркушів: " + paperSheets);
        System.out.println("📄 Сканування завершено успішно.");
    }

    /**
     * Змінити роздільну здатність.
     */
    public void setResolution(int dpi) throws IOException {
        this.resolutionDPI = dpi;
        log("Змінено роздільну здатність на " + dpi + " DPI.");
    }

    /**
     * Очистити сканер.
     */
    public void cleanScanner() throws IOException {
        log("Очищення сканера виконано.");
    }

    /**
     * Показати поточний стан пристрою.
     */
    public void showStatus() throws IOException {
        String status = "Модель: " + model +
                ", DPI: " + resolutionDPI +
                ", Аркушів: " + paperSheets +
                ", Увімкнено: " + (powerOn ? "так" : "ні");
        log("Перевірка стану: " + status);
        System.out.println(status);
    }

    /**
     * Закриття лог-файлу.
     */
    public void close() {
        try {
            log("Закриття журналу.");
            logWriter.close();
        } catch (IOException e) {
            System.out.println("Помилка при закритті файлу: " + e.getMessage());
        }
    }

    // === Приватний метод для логування ===
    private void log(String message) throws IOException {
        logWriter.write(LocalDateTime.now() + " — " + message + "\n");
        logWriter.flush();
    }

    // === Головний метод для тестування ===
    public static void main(String[] args) {
        try {
            ScannerDevice scanner = new ScannerDevice();
            scanner.powerOn();
            scanner.showStatus();
            scanner.startScan();
            scanner.addPaper(5);
            scanner.setResolution(1200);
            scanner.startScan();
            scanner.cleanScanner();
            scanner.powerOff();
            scanner.close();
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
