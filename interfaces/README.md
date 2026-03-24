# Contract Processing System (Interfaces & Dependency Injection)

This project is a Java application designed to demonstrate the power of **Interfaces** and **Loose Coupling**. It simulates a contract processing service that calculates monthly installments based on a specific payment provider's rules.

## Project Objective
The goal was to build a system where the business logic (`ContractService`) is completely independent of the payment provider (`PaypalService`). This allows for easy swapping of payment gateways without modifying the core service.

## Concepts Applied
* **Interfaces**: Used to define a contract for payment services (`OnlinePaymentService`).
* **Dependency Injection**: The service implementation is "injected" into the business logic, promoting decoupling.
* **Composition**: The `Contract` entity maintains a list of `Installment` objects.
* **Date Manipulation**: Using `java.time.LocalDate` and `plusMonths()` to calculate future due dates.
* **Data Formatting**: Using `DateTimeFormatter` for localized date input/output.

## How it Works
1. The user provides contract details (Number, Date, Total Value).
2. The user defines the number of installments.
3. The system calculates:
   - **Basic Quota**: Total Value / Months.
   - **Simple Interest**: 1% per month.
   - **Payment Fee**: 2% per installment.
4. Each installment is generated with its respective due date and total amount.

## Execution Example
```text
Enter contract data
Number: 8028
Date (dd/MM/yyyy): 25/06/2026
Contract value: $600.00

Enter installments: 3

Installments:
25/07/2026 - 206.04
25/08/2026 - 208.08
25/09/2026 - 210.12