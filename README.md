#Knapsack Brute Force Solution

## Description
This is a brute force solution to the Knapsack 0-1 problem, using recursion and implemented in Java as part of a university assignment. The Knapsack problem is an optimisation issue where the objective is to calculate for a set of items, each of specific values and weights, and for a knapsack of specific capacity, what items can fit inside the knapsack.

The project has 2 Java files and 5 testing files. The item class is a blueprint for an individual item, storing the name, value and weight of an item. The knapsack class stores the primary methods, including methods that read information from the test files as well as the brute force recursion method. In the main method, a knapsack object is created and the files are tested by calling the other methods. The 5 testing files can be tested by inputting their respective test number when prompted after running the knapsack file.

## How to run
There are 5 test files:

Test1.txt
- simple test case
- expected output: Items (1,2,5,6), number of items in the knapsack = 4, total weight = 9.7, maximum value = 2005.0

Test2.txt
- test where all items fit in the knapsack
- expected output: Items(1,2,3,4), number of items in the knapsack = 4, total weight = 40.0, maximum value = 100.0

Test3.txt
- test that processes a large list of items
- expected output: Items(1,2,3,4,5,6,8,10,11,12,13,14,15), number of items in the knapsack = 13, total weight = 398.0, maximum value = 613.0

Test4.txt
- test where only 1 of the items can fit in the knapsack
- expected output: Laptop, number of items in the knapsack = 1, total weight = 10.0, maximum value = 100.0

Test5.txt
- test where every items has the same weight
- expected output: (Banana, Mango, Peach), number of items in the knapsack = 3, total weight = 15.0, maximum value = 25.0
