# jETS (Java ETS) 💎

jETS ist eine moderne, hochperformante Java-Alternative zur KNX ETS, spezialisiert auf das Auslesen von Projektdateien, die Diagnose am Bus und die professionelle Konfiguration von KNX-Geräten.

## 🚀 Kern-Features

- **Vollständiger KNX-Secure Support**: Unterstützt Secure Tunneling (TCP & UDP) über Calimero 2.6.
- **Projekt-Management**: Laden von `.knxproj` (inkl. Passwortschutz) und Verwalten von Gebäudestrukturen.
- **Produktdatenbanken**: Import von `.knxprod`-Dateien zum Aufbau eines lokalen Hardware-Katalogs.
- **KO-Verknüpfung**: Kommunikationsobjekte einfach per Drag & Drop Gruppenadressen zuweisen.
- **Parameter-Konfiguration**: Vollständiger Editor für Geräteparameter basierend auf Herstellerdaten.
- **Geräte-Programmierung**: Programmieren der physikalischen Adresse und der Applikationslogik.
- **Profi-Busmonitor**: Echtzeit-Überwachung mit automatischer DPT-Übersetzung und APCI-Header-Bereinigung.
- **Intelligenter Workspace**: Speichern des gesamten Layouts und Zustands in `.etsws`-Dateien.

---

## 📖 Profi-Bedienungsanleitung

### 1. Kommunikationsobjekte (KO) verknüpfen
Um eine Logikverbindung herzustellen:
1. Öffne die **Buildings-** oder **Topology-Ansicht**.
2. Navigiere zu einem Gerät und öffne den Ordner **📡 Communication Objects**.
3. Öffne parallel das Fenster **Group Addresses**.
4. Ziehe das gewünschte KO einfach per **Drag & Drop** auf die Ziel-Gruppenadresse. jETS erstellt automatisch die interne Verknüpfung.

### 2. Geräte-Parameter einstellen
1. Öffne die Ansicht **View -> Devices**.
2. Klicke mit der **rechten Maustaste** auf das gewünschte Gerät.
3. Wähle **Edit Parameters**.
4. Im erscheinenden Fenster kannst du alle vom Hersteller definierten Einstellungen (z.B. Zeiten, Schwellwerte, Betriebsmodi) anpassen. Klicke auf **Apply**, um die Werte im Projekt zu übernehmen.

### 3. Programmierung (Download)
jETS unterstützt das Laden von Konfigurationen auf die physischen KNX-Geräte:
- **Physikalische Adresse**: In der **Topology-Ansicht** per Rechtsklick auf ein Gerät "Program Physical Address" wählen. Das Gerät muss sich dafür im Programmiermodus befinden.
- **Applikationsprogramm & Parameter**: In der **Devices-Liste** per Rechtsklick "Download Full" wählen. jETS überträgt dann die gesamte Logik und die eingestellten Parameter über den gesicherten Tunnel auf das Gerät.

---

## 🛠 Installation & Start

### Voraussetzungen
- **Java 21** oder neuer (JDK)
- **Maven 3.x**

### Bauen und Ausführen
Navigiere in den Ordner `java-openets` und führe folgende Befehle aus:

```bash
# Projekt bauen
mvn clean package

# jETS starten
mvn exec:java -Dexec.mainClass="de.sduni.jets.Jets"
```

---

## 🛡 Sicherheitshinweis
jETS nutzt für alle Schreibvorgänge und Programmierungen standardmäßig die sicherste verfügbare Verbindung (KNX IP Secure via TCP). Workspace-Dateien werden per **AES-256** verschlüsselt, um deine Projektschlüssel zu schützen.
