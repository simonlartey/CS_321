# Code Smells and Fixes

## Task 2 (Discount Calculator)

- **Long if-else chain (OCP violation):**  
  Discounts were calculated with multiple if/else blocks.  
  This violated the **Open/Closed Principle**, since every time a new customer type was added, the class had to be modified.

- **Mixed responsibilities (SRP violation):**  
  The DiscountCalculator handled both the discount logic and the decision-making for customer types.  
  This violated the **Single Responsibility Principle**, because it did more than one thing.

- **String-based logic (DIP violation):**  
  Customer types were identified by string values ("Regular", "VIP", etc.).  
  This violated the **Dependency Inversion Principle**, because the calculator was coupled to concrete string values instead of abstractions.

- **Magic Numbers:**  
  Hardcoded discount rates (0.05, 0.10, 0.20) reduced readability and maintainability.  
  Although not a direct SOLID principle violation, this was a **code smell**.

- **Duplicated Code in Output:**  
  Each customer’s discount logic was repeated in the main method.  
  This was another **code smell** (duplication).

**Fix:**  
I introduced a Customer interface with separate classes for each customer type, each defining its own discount constant. I replaced if/else with polymorphism, removed magic numbers by naming them as constants, and refactored the main method into a loop to avoid duplication. We also separated printing into DiscountApp to respect the Single Responsibility Principle.
