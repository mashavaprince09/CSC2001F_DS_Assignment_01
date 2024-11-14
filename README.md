# Knowledge Base Application

This application allows users to load a knowledge base into a data structure of their choice and interact with the data. The knowledge base consists of terms, sentences, and associated confidence levels. Users can choose between two data structures for storing the knowledge base: an Array or a Binary Search Tree (BST). The application also supports searching and manipulating the knowledge base.

## Features
- **Knowledge Base Entry Format**: Each entry in the knowledge base consists of:
  - A term (string)
  - A sentence (string)
  - A confidence level (double, ranging from 0 to 1)
  
- **Data Structures**: 
  - **Array**: Stores the knowledge base as an array of `Kb` objects.
  - **Binary Search Tree (BST)**: Stores the knowledge base in a binary search tree, allowing faster searching based on terms.

- **Searching and Matching**: 
  - **Exact Matching**: You can match terms or sentences to specific items.
  - **Partial Matching**: Search for partial terms or sentences, ignoring case.

- **Dynamic Updates**: The application allows modifying the knowledge base, including updating terms, sentences, and confidence levels.

## How It Works

### Classes and Methods:
1. **`Kb` Class**:
   - Represents a knowledge base entry with a `term`, `sentence`, and `confidence`.
   - Includes methods to get and set the term, sentence, and confidence.
   - Supports matching against terms and sentences (both exact and partial matches).
   - Implements `Comparable<Kb>` for sorting by term.

2. **Main Application (`main` class)**:
   - Prompts the user to choose which data structure to use for the knowledge base: an array or a binary search tree.
   - Calls either `GenericsKbArrayApp.main(null)` or `GenericsKbBSTApp.main(null)` depending on the user's choice.

3. **`GenericsKbArrayApp` and `GenericsKbBSTApp` Classes**:
   - These classes handle the logic for managing the knowledge base in an array or binary search tree, respectively.
   - They are called when the user selects the appropriate option in the main menu.

### Example of a Knowledge Base Entry:
```
T_BANGER    This is a test sentence.    0.9
```
This entry consists of:
- `T_BANGER`: The term.
- `This is a test sentence.`: The sentence.
- `0.9`: The confidence level.

## How to Run

1. Clone this repository or download the files.
2. Compile the classes using your preferred Java IDE or command line:
   ```bash
   javac *.java
   ```
3. Run the main application:
   ```bash
   java Main
   ```

4. Follow the prompts to select the data structure (Array or Binary Search Tree).

## Example Output

```
Select a data structure to load the knowledge base into:
1. Array
2. Binary Search Tree
Choose your data structure (1 or 2): 1

[Loading knowledge base into Array...]
```

## Requirements

- Java 8 or later.
- A basic understanding of data structures (Array, Binary Search Tree).
