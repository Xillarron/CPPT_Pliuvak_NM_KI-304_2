package KI304.Pliuvak.Lab2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Абстрактний клас ScannerDevice моделює базову роботу сканера.
 */
public abstract class ScannerDevice {
    protected String model;
    protected int resolutionDPI;
    protected int paperSheets;
    protected boolean powerOn;
    protected FileWriter logWriter;

    public ScannerDevice(String model, int resolutionDPI, int paperSheets, boolean powerOn) throws IOException {
        this.model = model;
        this.resolutionDPI = resolutionDPI;
        this.paperSheets = paperSheets;
        this.powerOn = powerOn;
        this.logWriter = new FileWriter("scanner_log.txt", true);
        log("Сканер створено: " + model);
    }

    /** Абстрактний метод для виконання сканування */
    public abstract void startScan() throws IOException;

    public void powerOn() throws IOException {
        powerOn = true;
        log("Сканер увімкнено.");
    }

    public void powerOff() throws IOException {
        powerOn = false;
        log("Сканер вимкнено.");
    }

    public void addPaper(int sheets) throws IOException {
        paperSheets += sheets;
        log("Додано " + sheets + " аркушів. Усього: " + paperSheets);
    }

    public void showStatus() throws IOException {
        log("Стан: " + model + ", " + resolutionDPI + " DPI, аркушів: " + paperSheets);
        System.out.println("Модель: " + model + " | DPI: " + resolutionDPI + " | Аркушів: " + paperSheets);
    }

    protected void log(String message) throws IOException {
        logWriter.write(LocalDateTime.now() + " — " + message + "\n");
        logWriter.flush();
    }

    public void close() throws IOException {
        log("Закриття журналу.");
        logWriter.close();
    }
}
