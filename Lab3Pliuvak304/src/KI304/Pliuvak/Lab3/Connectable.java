package KI304.Pliuvak.Lab3;

/**
 * Інтерфейс, який описує підключення пристроїв.
 */
public interface Connectable {
    void connectWiFi(String networkName);
    void disconnectWiFi();
}
