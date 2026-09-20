# Assignment 2: Logistics & GUI Application (Factory Method & Abstract Factory)

**Course:** ShP-2216 Software Design Patterns  
**Student:** Balymbetova Dilnaz  
**Group:** SE-2216  
**JDK Version:** JDK 17

## Project Purpose
This Java console application demonstrates the integration of two creational design patterns:
1. **Factory Method:** Handles transport selection (`Truck` or `Ship`) through creator subclasses (`RoadLogistics` and `SeaLogistics`) without coupling the delivery workflow to concrete transport classes.
2. **Abstract Factory:** Enforces platform-consistent UI rendering by providing matching families of UI components (`Button` and `Checkbox`) for Windows and macOS.

Both patterns are integrated in `DeliveryApplication`, allowing runtime selection of delivery modes and UI platforms without modifying the core delivery logic or component rendering.

## Package Structure
```text
src/
├── abstractfactory/
│   ├── Button.java
│   ├── Checkbox.java
│   ├── GUIFactory.java
│   ├── MacOSButton.java
│   ├── MacOSCheckbox.java
│   ├── MacOSFactory.java
│   ├── WindowsButton.java
│   ├── WindowsCheckbox.java
│   └── WindowsFactory.java
├── factorymethod/
│   ├── Logistics.java
│   ├── RoadLogistics.java
│   ├── SeaLogistics.java
│   ├── Ship.java
│   ├── Transport.java
│   └── Truck.java
├── DeliveryApplication.java
└── Main.java


Prerequisites
JDK: Java Development Kit 17 or higher

IDE/Tools: IntelliJ IDEA, Eclipse, or Command-line Terminal (javac/java)

Build and Run Instructions
Using Terminal / Command Prompt:
Navigate to the project root directory:

Bash
cd path/to/project
Compile all Java files into a bin directory:

Bash
javac -d bin src/factorymethod/*.java src/abstractfactory/*.java src/*.java
Run the application:

Bash
java -cp bin Main
Supported Input Values
Delivery Mode: ROAD, SEA

UI Platform: WINDOWS, MACOS

Cargo: Non-empty string (e.g., Laboratory Equipment)

Destination: Non-empty string (e.g., Aktau Warehouse)

Note on Validation: If an unsupported option or empty string is provided, the application displays a clear validation message and re-prompts the user until valid input is given.

Sample Run Output
Plaintext
Enter delivery type (ROAD/SEA): ROAD
Enter platform (WINDOWS/MACOS): WINDOWS
Enter cargo: Laboratory Equipment
Enter destination: Aktau Warehouse

Windows button is displayed.
Windows checkbox is displayed.
Truck delivers Laboratory Equipment to Aktau Warehouse by road.