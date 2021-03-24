---
layout: default
title: OOP
permalink: /oop/
---

# What is OOP?

Object-oriented programming (OOP) is a way to solve programming problems by representing them as **objects**. An object is a structure defined by a programmer that includes **attributes** and **methods**. Attributes store an object's data as variables. Methods perform actions on an object, which may include modifying the object's attributes.

# Example: A to-do list task

Let's say we're building a to-do list application using Java. To model each task in a to-do list, we should use an object.

## Attributes
Here are some attributes which a task object should have:
- Name
- Duration (the amount of time required to complete the task)
- Priority
- Percentage complete

## Methods
Here are some methods that can be applied to a task object 
- Extend duration (increase the time required)
- Bump priority (increase the priority by one)
- Update completion (increase the percentage complete by a specific amount)

## Code
In Java, an object is created using a class. A class is a template for an object that specifies all of its attributes and defines all of its methods. For this example, here is what a basic Task class looks like in Java:

```java
public class Task {
    String name;
    int duration; // time required in seconds
    int priority; // on a scale from 1 to 10, 1 being the highest priority
    double percentageComplete;

    void extendDuration(int extensionAmount) {
        duration+=extensionAmount;
    }

    void bumpPriority() {
        ++priority;
    }

    void updateCompletion(double percentageIncrease) {
        percentageComplete+=percentageIncrease;
        if(percentageComplete>100) {
            percentageComplete=100;
        }
    }
}
```
