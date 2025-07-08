# Quantum Bookstore

Quantum Bookstore is a modular, object-oriented Java project that simulates an online book store capable of handling various types of books and purchase scenarios. Designed to be extensible and follow clean architecture practices.

##  Features

-  Add, remove, and retrieve books by ISBN
- Automatically remove outdated books by age
-  Purchase books (with email and shipping address support)
- Uses polymorphism to handle different book types
-  Handles business exceptions gracefully (Out of Stock, Not for Sale, Not Found)
- Clean separation between `model`, `service`, and `exception` layers

---

##  Project Structure

The project follows a clean, modular design using Java packages to separate responsibilities and support extensibility:

### `model`
Holds all core **book entities**:
- `Book` *(abstract)* – defines shared fields and behaviors.
- `PaperBook` – physical books with stock and shipping.
- `EBook` – digital books with file type and email delivery.
- `ShowcaseBook` – demo books not available for purchase.

### `service`
Handles all **business logic and operations**:
- `BookInventory` – manages book storage, lookup, and removal.
- `BookInventoryService` – processes book purchases.
- `MailService` – simulates sending EBooks via email.
- `ShippingService` – simulates shipping PaperBooks.

### `exception`
Contains **custom exceptions** for business rule enforcement:
- `BookNotFoundException`
- `OutOfStockException`
- `NotForPurchaseException`

### `test / main`
- `QuantumBookstoreFullTest.java` – main class for testing full system behavior including:
  - Adding books
  - Buying paper and eBooks
  - Handling error scenarios (unavailable/outdated books)

---

##  Design Goals

- **Extensible**: New book types can be added without modifying existing logic.
- **OOP Principles**: Polymorphism, abstraction, encapsulation, and separation of concerns.
- **Clean Output**: All messages are prefixed with `Quantum book store:` for consistency.
