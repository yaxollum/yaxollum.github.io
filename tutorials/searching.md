---
layout: default
title: Searching
---

# Introduction

When writing programs, you will frequently need to search for a value in a list, so it's beneficial to know how search algorithms work.

# Sequential search

**Sequential search** is the most basic searching algorithm. It iterates through the list starts from the beginning, checking whether each element is equal to the value being searched for. The algorithm terminates when a matching element is found, or it reaches the end of the list, in which case the list does not contain any matching elements.

## Code

Below is a program that implements sequential search in Java:

```java
{% include_relative programs/search/sequential/SequentialSearch.java %}
```

## Time complexity

The **time complexity** of an algorithm is a measure of how much time it takes an algorithm to run. Time complexity is usually written in **big O notation**, which describes the run time of an algorithm relative to the size of the input. 

For example, the run time of an algorithm with *O(N)* complexity will grow linearly relative to the input size, whereas the run time of an algorithm with *O(N<sup>2</sup>)* complexity will grow quadratically relative to the input size.

Big O notation describes the **worst case** time complexity of an algorithm, which is the scenario that would take the algorithm the longest time to finish for a given input size.

In the case of sequential search, the worst case is the case where the element being searched for is not present in the list. In this case, the algorithm iterates through the entire list. 

For a list of *N* elements, sequential search would take *N* iterations, so **the time complexity of sequential search is *O(N)***.

# Binary search

Wen an array is sorted, you can still use the sequential search algorithm to search for a value, but there is a more efficient algorithm: **binary search**.

Binary search works by repeatedly dividing the array into two halves, ruling out half of the elements each time. It can do this because the array is sorted. 

Assuming the array is sorted from least to greatest (reverse the rules if it's sorted from greatest to least):

- If a value is greater than the middle value of the array, then it can't be in the first half
- If a value is less than the middle value of the array, then it can't be in the second half
- If a value is equal to the middle value of the array, then the value has been found and the algorithm can terminate 

If binary search halves the array until there is only one element left, but that element is not equal to the target value, this means the target value is not present in the array.

## Code

Below is a program that implements binary search in Java:

```java
{% include_relative programs/search/binary/BinarySearch.java %}
```

The `binarySearch()` method is recursive. After determining which half of the array the value may fall in, the method calls itself on that half. Binary search is a great example of recursively reducing a problem into a smaller problem, stepping closer to the solution each time.

## Time complexity

Binary search works by repeatedly halving an array, so to calculate its time complexity, we need to calculate the number of times an array can be divided in half. In math, the **logarithm** function does exactly this. 

The number of times an array of *N* elements can be divided in half is written as *log<sub>2</sub>N*, where the *2* means "divide into 2 parts each time."

In big O notation, the time complexity for binary search is simply written as *O(log N)*. The base 2 of the logarithm is omitted in big O notation, because it is a constant factor, and big O notation does not include constant factors.

# Conclusion

The two most commonly used searching algorithms are sequential search and binary search. Sequential search can be used on any list of values. Binary search is more efficient than sequential search, but it can only be used on sorted lists. 

This tutorial also explained the concepts of time complexity and big O notation. It showed why the time complexity of sequential sort is *O(N)* and why the time complexity of binary search is *O(log N)*.
