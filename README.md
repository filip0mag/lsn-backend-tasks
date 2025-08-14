# Backend Tasks - Solutions

This repo contains my solutions to the three backend tasks described in the assignment.

Each task is implemented as a **plain Java 8+ console application** that:
- Reads input from stdin
- Writes output to stdout
- Handles very large inputs efficiently

## Task1 - Distinct Sorted List + Stats
### Input format:
Single line containing integers separated by spaces.

### Output format:
By lines:
List of distinct elements in ascending order, separated by spaces

Count: total number of elements in the input

Distinct: number of unique elements

Min: smallest value

Max: largest value

### Example:
```bash
Input:
1 10 20 20 2 5

Output:
1 2 5 10 20
count: 6
distinct: 5
min: 1
max: 20
```
### Complexity:
Time: O(n log n)

Space: O(n)

## Task2 - Pairs Summing to 13
### Input format:
Single line containing integers separated by spaces.

### Output format:
All pairs such that num1 + num2 = 13 where:
- num1 < num2 
- Pairs are sorted in ascending order by first element

### Example:
```bash
Input:
1 2 10 7 5 3 6 6 13 0

Output:
0 13
3 10
6 7
6 7
```
### Complexity:
Time: O(n)

Space: O(n)

## Task3 - Counting Separate Graphs
### Input format:
First line: integer n (number of edges)

Next n lines: each contains two integers u v defining a connection between vertices
### Output format:
A single integer which equals to the number of separate graphs

### Example:
```bash
Input:
3
4 3
1 4
5 6

Output:
2
```
### Complexity:
Time: O(n)

Space: O(n)

## Testing
I have also included JUnit tests to verify:
- Empty Inputs
- Large Datasets
- Edge Cases

## Running the Applications
You can either:
- Redirect input from a file (as shown below)
- Or run the program and type the input manually in the console
```bash
javac Task1.java
java Task1 < input.txt

javac Task2.java
java Task2 < input.txt

javac Task3.java
java Task3 < input.txt
```