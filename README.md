
```markdown
# Prospecta Assignment

## Coding Challenge

### Features

- **Fetch API Data by Category**: Retrieve a list of public APIs filtered by a specific category.
- **Add New API Entries**: Simulate adding new API entries to the system. (Note: This feature does not actually post data to the public APIs database).

#### 1. Fetching APIs by Category

To get a list of APIs by a specific category, use this endpoint:

```
GET http://localhost:8080/byCategory?category=Anime
```

#### 2. Adding a New API Entry

To simulate adding a new API entry, use this endpoint:

```
POST http://localhost:8080/AddEntry
```

Note: It runs on port 8080, so adjust accordingly if needed.

## Theoretical Challenge

### CSV Calculator

This program reads data from a CSV file, calculates formulas, and produces CSV output with the results.

#### Usage

1. Compile the `Main.java` file using a Java compiler:
   ```
   javac Main.java
   ```
2. Run the compiled program:
   ```
   java Main
   ```
3. Provide the input CSV file named `Prospecta.csv` located in the `src` directory.
4. The program will calculate the formulas and generate an output CSV file named `Output.csv` in the `src` directory.
5. The calculated results will be printed to the console.

#### Input CSV Format

The input CSV file should contain two columns: cell references and their corresponding values or formulas.

Example:
```
A1,5
A2,7
A3,9
B1,3
B2,8
B3,=4+5
C1,=5+A1
C2,=A2+B2
C3,=C2+B3
```

#### Error Handling

- The program handles errors such as invalid file paths, unreadable files, and incorrectly formatted CSV data.

#### Dependencies

```
(No specific dependencies mentioned)
```
```

This should present your assignment instructions in a clear and organized manner. Adjustments can be made according to your preferences or specific requirements.
