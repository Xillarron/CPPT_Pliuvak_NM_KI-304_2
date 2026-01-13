package KI304.Pliuvak.Lab3;

import KI304.Pliuvak.Lab2.ScannerDevice;
import java.io.IOException;

/**
 * Клас SmartScanner розширює ScannerDevice і реалізує інтерфейс Connectable.
 */
public class SmartScanner extends ScannerDevice implements Connectable {
    private boolean connected;
    private String wifiNetwork;

    public SmartScanner(String model, int resolutionDPI, int paperSheets, boolean powerOn) throws IOException {
        super(model, resolutionDPI, paperSheets, powerOn);
    }

    @Override
    public void startScan() throws IOException {
        if (!powerOn) {
            System.out.println("⚠️ Сканування неможливе: пристрій вимкнений!");
            return;
        }
        if (paperSheets <= 0) {
            System.out.println("⚠️ Немає паперу!");
            return;
        }
        if (!connected) {
            System.out.println("⚠️ Сканер не підключений до Wi-Fi!");
            return;
        }

        paperSheets--;
        System.out.println("📄 Сканування виконано успішно через Wi-Fi!");
        log("Сканування виконано через Wi-Fi. Залишилось аркушів: " + paperSheets);
    }

    @Override
    public void connectWiFi(String networkName) {
        connected = true;
        wifiNetwork = networkName;
        System.out.println("📶 Підключено до Wi-Fi мережі: " + wifiNetwork);
    }

    @Override
    public void disconnectWiFi() {
        connected = false;
        System.out.println("📴 Відключено від Wi-Fi.");
    }
}
