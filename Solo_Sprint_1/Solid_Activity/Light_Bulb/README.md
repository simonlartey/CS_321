# Code Smells and Fixes

## Task 1 (Switch & LightBulb)

- **Tight Coupling (DIP violation):**  
  The Switch class directly created a LightBulb instance (new LightBulb()), which made it impossible to reuse with other devices.  
  This violated the **Dependency Inversion Principle**, because Switch depended on a concrete implementation rather than an abstraction.

- **Closed for Extension (OCP violation):**  
  Adding a new type of bulb (like an LEDLightBulb) would require modifying the Switch class.  
  This violated the **Open/Closed Principle**, since the class was not open to extension without modification.


**Fix:**  
I introduced the Switchable interface. Now Switch depends on the abstraction, and both LightBulb and LEDLightBulb implement it. This eliminated the tight coupling and respected the Dependency Inversion Principle.