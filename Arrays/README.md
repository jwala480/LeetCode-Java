# 🔄 Permutations — Java

A Java solution for the **LeetCode Permutations** problem using **recursion, swapping, and backtracking**.

## 📌 Problem

Given an array of distinct integers, return all possible permutations.

### Example

Input:
```text
[1, 2, 3]
```

Output:
```text
[
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,2,1],
 [3,1,2]
]
```

---

## 🧠 Approach

The algorithm follows:

```text
SWAP → RECURSE → BACKTRACK
```

At each `index`:

1. Swap an element with the current index.
2. Recursively generate permutations for the next index.
3. Swap back to restore the original array.

---

## 🌳 Recursion Tree

For `[1,2,3]`:

```text
                         [1,2,3]
                       /    |    \
                      1     2     3
                     / \   / \   / \
                    2   3 1   3 1   2
                    |   | |   | |   |
                    3   2 3   1 2   1
                    ↓   ↓ ↓   ↓ ↓   ↓
                   123 132 213 231 321 312
```

### How to read the tree

```text
index = 0 → choose first element
index = 1 → choose second element
index = 2 → choose third element
index = 3 → permutation is complete
```

---

## 🔄 Swap & Backtracking

Example:

```text
Original
[1,2,3]

swap(0,1)
    ↓
[2,1,3]

Generate permutations...
    ↓

swap(0,1)   ← Backtrack
    ↓
[1,2,3]
```

Backtracking restores the array so that the next choice can be explored.

---

## 💻 Code

```java
import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        permutation(nums, 0, result);

        return result;
    }

    public void permutation(int[] nums, int index,
                            List<List<Integer>> result) {

        if (index == nums.length) {

            List<Integer> list = new ArrayList<>();

            for (int num : nums) {
                list.add(num);
            }

            result.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {

            swap(nums, index, i);

            permutation(nums, index + 1, result);

            // Backtracking
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int i, int j) {

        int temp = nums[i];

        nums[i] = nums[j];

        nums[j] = temp;
    }
}
```

---

## ⏱️ Complexity

```text
Time Complexity  : O(n × n!)
Space Complexity : O(n × n!)  → output
                    O(n)      → recursion stack
```

---

## ⭐ Key Pattern

```text
       Make Choice
           ↓
          Swap
           ↓
        Recurse
           ↓
     Complete Choice?
           ↓
        Backtrack
           ↓
      Try Next Choice
```

### Remember

> **Swap → Recursion → Backtracking**
