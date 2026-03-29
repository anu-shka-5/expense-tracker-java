# expense-tracker-java
# Personal Expense Tracker (Java CLI)

## Problem Statement
Many people do not keep track of their daily expenses, which leads to overspending and poor financial planning.

## Solution
This project is a simple command-line based Expense Tracker built using Java. It allows users to record, view, and manage their expenses efficiently.

## Features
- Add new expenses with description, amount, and category
- View all expenses
- Calculate total amount spent
- Set and update budget
- Warns when the budget is exceeded
- Save data to a file
- Load expenses automatically when the program starts

## Technologies Used
- Java
- ArrayList (Collections Framework)
- File Handling (BufferedReader, FileWriter)
- Scanner (for user input)

## Project Structure
ExpenseTracker/
│── Main.java
│── Expense.java
│── expenses.txt (created automatically)

## How to Run
1. Open the terminal and navigate to project folder.
   
3. Compile the program:
   javac Main.java Expense.java

4. Run the program:
   java Main

## File Storage
All expenses are stored in a file named `expenses.txt` in the same directory.

## Example
Expense format in file:
Lunch,150,Food

## Future Improvements
1. Add GUI using Java Swing
2. Add edit/delete expense feature
3. Add category-wise analysis
4. Add date tracking

## Author
Anushka Ranjan
