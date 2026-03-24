# Account Withdrawal System (Exceptions Handling)

This project is a Java application designed to practice **Custom Exceptions**. It simulates a bank account withdrawal process where specific business rules must be validated before completing a transaction.

## Project Objective
The main goal was to implement a robust error-handling mechanism that separates "System Errors" from "Business Rule Violations" using a custom exception class.

## Concepts Applied
* **Custom Exceptions**: Creation of `DomainException` extending `RuntimeException`.
* **Exception Propagation**: Using `throw new` to interrupt the flow when a rule is broken.
* **Defensive Programming**: Validating data (balance and limits) inside the entity before performing operations.
* **Try-Catch Blocks**: Handling specific errors in the main application to provide clear feedback to the user.

## Business Rules
The system prevents a withdrawal if:
1. The withdrawal amount exceeds the account's **Withdraw Limit**.
2. The withdrawal amount is greater than the available **Balance**.

## Sample Outputs

### Success Scenario
```text
Enter account data:
Number: 8018
Holder: Victor Hugo
Initial balance: 500.00
Withdraw limit: 300.00

Enter amount for withdraw: 100.00
New balance: 400.00