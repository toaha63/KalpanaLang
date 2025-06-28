# KalpanaLang Documentation

## Overview
KalpanaLang is a Bengali-script programming language interpreter written in Java. It supports multiple natural language inputs (English, Russian, Hindi, and Bengali) which are automatically translated to Bengali keywords before execution.

## Language Features

### Data Types
1. **Primitive Types**:
   - `পূর্ণসংখ্যা` (Integer)
   - `ভগ্নাংশ` (Float/Double)
   - `বাক্য` (String)
   - `বুলিয়ান` (Boolean: `সত্য`/true, `মিথ্যা`/false)

2. **Arrays**:
   - `পূর্ণসংখ্যার_অ্যারে` (Integer array)
   - `ভগ্নাংশের_অ্যারে` (Float array)
   - `বাক্যের_অ্যারে` (String array)
   - `বুলিয়ানের_অ্যারে` (Boolean array)

### Control Structures
1. **Conditionals**:
   - `যদি (condition) { ... }` (if)
   - `যদিবা (condition) { ... }` (else if)
   - `বা { ... }` (else)

2. **Loops**:
   - `লুপ (condition) { ... }` (while loop)
   - `লুপ (init; condition; increment) { ... }` (for loop)
   - `ভাঙো;` (break)
   - `এড়াও;` (continue)

3. **Functions**:
   - `ফাংশন returnType name(params) { ... }`
   - `ফেরত value;` (return)
   - `খালি` (void return type)

### I/O Operations
- `দেখাও(expression);` (print)
- `নাও(type, variable);` (input)

### Array Operations
- `অ্যারের_আকার(array)` (array size)
- `বাবল_সর্ট(array)` (bubble sort)
- `কুইক_সর্ট(array)` (quick sort)
- `বাইনারি_সার্চ(array, key)` (binary search)

### Special Commands
- `শুরুতে_যাও();` (restart program)
- `ভ্যারিয়েবল_মুছো(variable);` (delete variable)

## Syntax Examples

### Variable Declaration
```bn
পূর্ণসংখ্যা x = 10;
ভগ্নাংশ y = 3.14;
বাক্য name = "Kalpana";
বুলিয়ান isTrue = সত্য;
```

### Array Declaration
```bn
পূর্ণসংখ্যার_অ্যারে numbers[5];
ভগ্নাংশের_অ্যারে prices → {10.5, 20.3, 30.99};
```

### Conditional Statement
```bn
যদি (x > 5) {
    দেখাও("x is greater than 5");
} যদিবা (x == 5) {
    দেখাও("x is equal to 5");
} বা {
    দেখাও("x is less than 5");
}
```

### Loop
```bn
লুপ (i = 1; i <= 10; i++) {
    দেখাও(i);
}
```

### Function
```bn
ফাংশন পূর্ণসংখ্যা যোগফল(পূর্ণসংখ্যা a, পূর্ণসংখ্যা b) {
    ফেরত a + b;
}
```

### Input/Output
```bn
নাও(পূর্ণসংখ্যা, userInput);
দেখাও("You entered: " + userInput);
```

## Supported Natural Language Keywords

### English to Bengali
- `print` → `দেখাও`
- `int` → `পূর্ণসংখ্যা`
- `if` → `যদি`
- `function` → `ফাংশন`
- (See full mapping in code)

### Russian to Bengali
- `печать` → `দেখাও`
- `цел` → `পূর্ণসংখ্যা`
- `если` → `যদি`
- (See full mapping in code)

### Hindi to Bengali
- `प्रिंट` → `দেখাও`
- `पूर्णांक` → `পূর্ণসংখ্যা`
- `अगर` → `যদি`
- (See full mapping in code)

## Compilation and Execution

1. Save your code in a file with `.kls` extension
2. Run the interpreter:
   ```
   java Main filename.kls
   ```

## Error Handling
The interpreter provides detailed error messages for:
- Syntax errors
- Type mismatches
- Undefined variables
- Array index out of bounds
- Invalid operations

## Implementation Details

### Key Components
1. **Language Translator**: Translates keywords from multiple languages to Bengali
2. **Lexer**: Tokenizes source code
3. **Parser**: Builds abstract syntax tree
4. **Interpreter**: Executes the parsed code
5. **Environment**: Manages variables and scopes

### Built-in Algorithms
- Bubble sort
- Quick sort
- Binary search

## Limitations
- Currently single-threaded
- Limited standard library
- Basic error recovery

## Future Enhancement
- Multi Dimensional Array

This documentation provides a comprehensive overview of KalpanaLang. For more details, refer to the implementation code and example programs.
