# File System Processing (CSV Summary)

A Java application that automates the generation of sales summaries by reading data from a source file and writing processed results to a new directory.

## Functionality
The program reads a `.csv` file containing product data (Name, Price, Quantity), calculates the total value for each item, and generates a new file called `summary.csv` inside an automatically created `/out` folder.

## Technical Highlights
* **File I/O**: Efficient reading and writing using `BufferedReader` and `BufferedWriter`.
* **Resource Management**: Implementation of `try-with-resources` for safe stream handling.
* **String Manipulation**: Data parsing using `.split()` and `.trim()`.
* **Path Management**: Dynamic folder creation using the `File` class.

## Sample Input (source.csv)
```text
iPhone 15, 5800.00, 1
Monitor Gamer, 1450.50, 3