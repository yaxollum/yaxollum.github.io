---
layout: default
title: ArrayList
---

In addition to arrays, Java offers the `ArrayList` data structure, which is basically an array that can grow and shrink dynamically. To see why this is useful, let's go back to the problem which we used to introduce arrays:
> Given 6 words, output them in reverse order.

Now, let's generalize this problem:
> Given an arbitrary number of words (reading until the word "STOP"), output them in reverse order.

## With an array

Here's the issue: now that the number of words has become arbitrary, what should the length of the `words` array be?

The answer is that `words` can initially be an array of length 0, and every time the `words` array runs out of space, we should extend it using the following technique:

1. Create a new array named `newWords` with a longer length
2. Copy all of the elements from `words` to `newWords`
3. Replace `words` with `newWords`

This is what the code looks like:

```java
public static void revInputWithArray() {
    String[] words = new String[0];
    int wordsRead = 0; // keep track of number of words read

    Scanner input = new Scanner(System.in);

    while (true) {
        String nextWord = input.next(); // read next word
        if (nextWord.equals("STOP")) {
            break; // stop reading
        } else {
            if (words.length <= wordsRead) {
                // create a new array of Strings with a larger capacity
                String[] newWords = new String[wordsRead + 5]; 
                for (int i = 0; i < wordsRead; ++i) {
                    newWords[i] = words[i]; // copy over all the words
                }
                // replace the old words array with the new array
                words = newWords; 
            }
            words[wordsRead] = nextWord; // append nextWord to words
            ++wordsRead;
        }
    }
    for (int i = wordsRead - 1; i >= 0; --i) {
        System.out.print(words[i] + ' ');
    }
    System.out.println();
}
```

This program is a lot more complex than the `revInputWithArray` program in the [previous arrays tutorial](/arrays#with-an-array), because we have to handle all of the growing, copying, and reassigning. Fortunately, Java provides the `ArrayList` data structure, which does this automatically.

## With an ArrayList

By using an `ArrayList` instead of an `Array`, we can simplify our program drastically:

```java
public static void revInputWithArrayList() {
    ArrayList<String> words = new ArrayList<String>();

    Scanner input = new Scanner(System.in);

    while (true) {
        String nextWord = input.next(); // read next word
        if (nextWord.equals("STOP")) {
            break; // stop reading
        } else {
            words.add(nextWord); // add nextWord to words
        }
    }
    for (int i = words.size() - 1; i >= 0; --i) {
        System.out.print(words.get(i) + ' ');
    }
    System.out.println();
}
```

In the function above, we used the following features of `ArrayList`:
- `ArrayList<String> words`: means that the variable `words` is an `ArrayList` of `String`s
- `new ArrayList<String>()`: constructs an `ArrayList` that is initially empty
- `words.add(nextWord)`: appends `nextWord` to `words` (this operation may cause the `ArrayList` to grow internally using a technique similar to the one demonstrated in the ["With an array"](#with-an-array) section of this tutorial.)
- `words.size()`: gets the size of `words`
- `words.get(i)`: gets the element of `words` at index `i` (like arrays, `ArrayLists` are also zero-indexed)

## Additional operations

`ArrayList` also supports the following operations:
- `clear()` removes all of the elements
- `isEmpty()` checks if the list is empty
- `remove(int index)` removes the element at position `index`
- `set(int index, E element)` sets position `index` of the list to `element`
