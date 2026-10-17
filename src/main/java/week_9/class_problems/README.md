# Week 9 – S9 – Introduction to Data Structures
## Category B · Practice Problems
Branch: `feature/session_9`
Package: `week_9.class_problems`

## Part A — Coding Problems

### 1. Library Catalog Lookup
File: `LibraryCatalogLookup.java` (+ `BookRecord.java`)

Method: `findBook(List<BookRecord> catalog, String targetIsbn)`

Uses binary search over the catalog sorted by ISBN. ISBNs are compared as strings, which is appropriate for the fixed-width numeric-string examples and preserves leading zeroes.

- **Time:** `O(log n)`
- **Additional space:** `O(1)`

Expected demo output:
```text
Classic Mythology
Not Found
```

### 2. Warehouse Grid Summary
File: `WarehouseGridSummary.java`

Method: `warehouseSummary(int[][] grid)`

Visits each cell once, accumulating the total and updating the maximum coordinates only when a strictly larger value is found. This preserves the first maximum in row-major order.

- **Time:** `O(m × n)` for `m` rows and `n` columns
- **Additional space:** `O(1)` (the result stores a fixed number of values)

Expected demo output:
```text
(49, (2, 1))
```

### 3. Pair With Target Sum (Unsorted)
File: `PairWithTargetSum.java`

The file includes both approaches:
- Brute force checks all pairs: **`O(n²)` time, `O(1)` additional space**.
- HashSet complement search: **expected `O(n)` time, `O(n)` additional space**.

Expected demo output begins with `true` and `false`.

### 4. Pair With Target Sum (Unsorted Array)
File: `PairWithTargetSumUnsortedArray.java`

This is kept as a separate solution because the worksheet repeats the same problem in Question 4. It also includes brute-force and HashSet approaches with the same complexity trade-off.

- Brute force: `O(n²)` time, `O(1)` additional space
- HashSet: expected `O(n)` time, `O(n)` additional space

### 5. Maximize Area Between Two Boundaries
File: `MaximizeAreaBetweenTwoBoundaries.java`

Includes both the brute-force solution and the optimized two-pointer solution.

- Brute force checks every pair: **`O(n²)` time, `O(1)` additional space**
- Two pointers: **`O(n)` time, `O(1)` additional space**

At each step, move the pointer at the shorter wall because the shorter height limits the current container. This avoids checking every possible pair and is preferable for large arrays.

Expected demo output:
```text
49
Brute force: 49
```

## Compile all Week 9 practice Java files (PowerShell)

Run from the repository root:

```powershell
javac -d out (Get-ChildItem -Path src\main\java\week_9\class_problems -Filter *.java -Recurse | ForEach-Object { $_.FullName })
```

## Run each demo

```powershell
java -cp out week_9.class_problems.LibraryCatalogLookup
java -cp out week_9.class_problems.WarehouseGridSummary
java -cp out week_9.class_problems.PairWithTargetSum
java -cp out week_9.class_problems.PairWithTargetSumUnsortedArray
java -cp out week_9.class_problems.MaximizeAreaBetweenTwoBoundaries
```

## Part B — Quiz Answer Key

| Question | Answer | Explanation |
|---|---|---|
| Q1 | **B — O(1)** | Accessing an element at a known array index is constant time. |
| Q2 | **C — Insertion** | Adding a new element is insertion. |
| Q3 | **C** | Match required operations and constraints to the strengths of data structures. |
| Q4 | **C — Time vs space trade-offs** | Extra memory is used to avoid recomputing a result. |
| Q5 | **B — O(m + n)** | The two non-nested loops add their work. |
| Q6 | **C — Linear data structure** | Elements follow a sequential arrangement. |
| Q7 | **C — O(n)** | Big-O drops constant multipliers and lower-order constants. |
| Q8 | **D — Linked list** | A linked list is a non-primitive data structure. |
| Q9 | **B — O(m × n)** | Every cell in the 2D array is visited once. |
| Q10 | **C** | Data structures organize and store data for efficient operations. |

## Part C — Concept Question Guidance

### 1. Searching an unsorted versus sorted 1D array
Searching an unsorted array may require checking every element, so it takes `O(n)) time in the worst case. A sorted array can also be searched linearly in `O(n)), but binary search uses the order to discard half the remaining range at each step, achieving `O(log n)) time. Binary search requires the data to remain sorted and random access, as with an array.

### 2. Why `O(2n)` simplifies to `O(n)`
Big-O describes the growth rate as input size increases, ignoring constant factors. Twice as many operations still grow in direct proportion to `n`; multiplying by two changes the work's scale but not its asymptotic growth class. Therefore `O(2n)` is written as `O(n)).

### 3. Traversal in linear and non-linear data structures
A linear structure such as an array is typically traversed sequentially from one index to the next. A non-linear structure, such as a tree or graph, can branch into multiple paths, so traversal uses strategies such as depth-first search (DFS) or breadth-first search (BFS). Graph traversal often needs a visited set to avoid revisiting nodes or following cycles indefinitely.

**Source limitation:** The supplied text ends during Concept Question 3 and does not include any later concept questions, so this guide answers the questions visible in the provided text only.
