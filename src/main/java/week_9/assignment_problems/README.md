# Week 9 – S9 – Introduction to Data Structures
## Category B · Coding Assignment
Branch: `feature/session_9`
Package: `week_9.assignment_problems`

Each problem is implemented as one Java class with a public static method and a `main()` demo.

## 1. Class Topper Finder
File: `ClassTopperFinder.java`

Method: `findTopper(List<List<Integer>> marks)`  
Returns an `int[]` containing `{rowIndex, total}`.

Example output: `(1, 259)`

**Complexity**
- Time: `O(m × n)`, where `m` is students and `n` is subjects.
- Additional space: `O(1)` (the returned pair has constant size).
- A strict `total > bestTotal` check preserves the smallest row index on ties.

## 2. Merging Two Token Queues
File: `MergingTwoTokenQueues.java`

Method: `mergeTokens(List<Integer> counterA, List<Integer> counterB)`

Example output:
`[3, 5, 8, 8, 12, 15, 20]`  
`[4, 9]`

**Complexity**
- Two-pointer merge time: `O(m + n)`.
- Additional space: `O(m + n)` for the returned merged list.
- Joining and sorting instead takes `O((m + n) log(m + n))` time and typically `O(m + n)` additional space.

## 3. Most Popular Canteen Order
File: `MostPopularCanteenOrder.java`

Method: `mostPopular(List<String> orders)`  
Returns an `Object[]` containing `{itemName, count}`.

Example outputs: `("dosa", 3)` and `("tea", 2)`.

**Complexity**
- Recounting the entire list for each item takes `O(n²)` time in the straightforward implementation and `O(1)` additional space.
- Hash-map counting plus a second scan takes expected `O(n)` time and `O(u)` additional space, where `u` is the number of distinct item names.
- Scanning the original list and updating only when the count is strictly higher keeps the first item in the event of a tie.

## 4. Hot Weather Alert Windows
File: `HotWeatherAlertWindows.java`

Method: `countAlerts(List<Integer> readings, int k, int threshold)`

Example output: `3`.

**Complexity**
- Recalculating every window from scratch: `O((n - k + 1) × k)`, commonly bounded by `O(nk)`; additional space `O(1)`.
- Sliding window: `O(n)` time and `O(1)` additional space.
- Uses `windowSum >= (long) k * threshold` to avoid floating-point division.

## 5. Ticket Price Slot Finder
File: `TicketPriceSlotFinder.java`

Method: `findSlot(List<Integer> prices, int newPrice)`

Example outputs: `1`, `3`, `4`.

**Complexity**
- Linear scan: `O(n)` time and `O(1)` additional space.
- Binary search: `O(log n)` time and `O(1)` additional space.
- If the price is absent, the final `low` index is its correct insertion position.

## Compile all Week 9 Java files (PowerShell)

Run from the repository root:

```powershell
javac -d out (Get-ChildItem -Path src\main\java\week_9\assignment_problems -Filter *.java -Recurse | ForEach-Object { $_.FullName })
```

## Run each demo

```powershell
java -cp out week_9.assignment_problems.ClassTopperFinder
java -cp out week_9.assignment_problems.MergingTwoTokenQueues
java -cp out week_9.assignment_problems.MostPopularCanteenOrder
java -cp out week_9.assignment_problems.HotWeatherAlertWindows
java -cp out week_9.assignment_problems.TicketPriceSlotFinder
```
