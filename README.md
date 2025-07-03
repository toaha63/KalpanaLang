
# KalpanaLang - Programming in Your Native Language🧑‍💻

KalpanaLang is an interpreter-based programming language designed to allow programmers to write code in their native language. The initial version supports Bengali (Bangla) as the primary language with translations from English, Russian, and Hindi.

## Features

- **Native Language Support**: Write code in Bengali (with English, Russian, and Hindi translations)
- **Rich Standard Library**: Includes common programming constructs and algorithms
- **Multi-language Input**: Automatically detects and translates from English, Russian, or Hindi to Bengali
- **Array Operations**: Built-in support for arrays with sorting and searching algorithms
- **Interactive Input**: Get user input with type checking

## Language Syntax

### Data Types
- `পূর্ণসংখ্যা` (Integer)
- `ভগ্নাংশ` (Float/Double)
- `বাক্য` (String)
- `বুলিয়ান` (Boolean)

### Control Structures
- `যদি` (if)
- `যদিবা` (else if)
- `বা` (else)
- `লুপ` (for/while loop)
- `ভাঙো` (break)
- `এড়াও` (continue)

### Functions
- `ফাংশন` (function)
- `ফেরত` (return)
- `খালি` (void)

### Arrays
- `পূর্ণসংখ্যার_অ্যারে` (Integer array)
- `ভগ্নাংশের_অ্যারে` (Float array)
- `বাক্যের_অ্যারে` (String array)
- `বুলিয়ানের_অ্যারে` (Boolean array)
- `অ্যারের_আকার` (Array size)
- `বাবল_সর্ট` (Bubble sort)
- `কুইক_সর্ট` (Quick sort)
- `বাইনারি_সার্চ` (Binary search)

### Built-in functions:
- `বন্ধ` (exit)
- `কনসোল_মুছো` (clearConsole)
- `ভ্যারিয়েবল_মুছো` (delete_var)
- `প্রেসে_থামো` (stopOnEnter)
- `প্রেসে_শেষ` (hold)
- `থামো` (sleep)

### Library support
- `math.klm`

## Getting Started

### Prerequisites
- Java 21 or higher

### Running the Interpreter
1. Clone this repository
2. Compile the Java files:
   ```sh
   javac *.java
   ```
3. Create a source file (e.g., `Demo.kls`) with your code
4. Run the interpreter:
   ```sh
   java Main Demo.kls
   ```
5. To run jar file directly:
    ```sh
    java -jar KalpanaLang.jar Demo.kls
    ```

## Example Programs

### Hello World
```KalpanaLang
দেখা("হ্যালো বিশ্ব!");
```

### Fibonacci Series
```KalpanaLang
পূর্ণসংখ্যা n = 10;
পূর্ণসংখ্যার_অ্যারে fib[n];

fib[1] = 1;
fib[2] = 1;

লুপ (পূর্ণসংখ্যা i = 3; i <= n; i++)
{
    fib[i] = fib[i-1] + fib[i-2];
}

লুপ (পূর্ণসংখ্যা i = 1; i <= n; i++)
{
    দেখাও(fib[i]);
}
```

### Function Example
```KalpanaLang
ফাংশন পূর্ণসংখ্যা factorial(পূর্ণসংখ্যা n)
{
    যদি (n == 0)
    {
        ফেরত 1;
    }
    ফেরত n * factorial(n - 1);
}

দেখাও(factorial(5));
```

## Supported Language Translations

| English | Bengali | Russian | Hindi |
|---------|---------|---------|-------|
| print | দেখাও | печать | प्रिंट |
| integer | পূর্ণসংখ্যা | цел | पूर्णांक |
| float | ভগ্নাংশ | дробь | भिन्न |
| string | বাক্য | строка | स्ट्रिंग |
| if | যদি | если | अगर |
| else | বা | иначе | और |
| function | ফাংশন | функция | फंक्शन |

## Project Structure

```
KalpanaLang/
├── Main.java               - Main entry point
├── KalpanaLang.jar         - jar file of interpreter
├── LICENSE                 - License file
├── Demo.kls                - An example of my language, kls means KalpanaLangSource
├── math.klm                - A math library for interpreter. klm means KalpanaLangModiule.
└── README.md               - This file
```

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Inspired by the need for native language programming tools.
- Built with Java for portability and performance.

### Project Team

**Core Development:**

# KalpanaLang - Programming in Your Native Language🧑‍💻

KalpanaLang is an interpreter-based programming language designed to allow programmers to write code in their native language. The initial version supports Bengali (Bangla) as the primary language with translations from English, Russian, and Hindi.

## Features

- **Native Language Support**: Write code in Bengali (with English, Russian, and Hindi translations)
- **Rich Standard Library**: Includes common programming constructs and algorithms
- **Multi-language Input**: Automatically detects and translates from English, Russian, or Hindi to Bengali
- **Array Operations**: Built-in support for arrays with sorting and searching algorithms
- **Interactive Input**: Get user input with type checking

## Language Syntax

### Data Types
- `পূর্ণসংখ্যা` (Integer)
- `ভগ্নাংশ` (Float/Double)
- `বাক্য` (String)
- `বুলিয়ান` (Boolean)

### Control Structures
- `যদি` (if)
- `যদিবা` (else if)
- `বা` (else)
- `লুপ` (for/while loop)
- `ভাঙো` (break)
- `এড়াও` (continue)

### Functions
- `ফাংশন` (function)
- `ফেরত` (return)
- `খালি` (void)

### Arrays
- `পূর্ণসংখ্যার_অ্যারে` (Integer array)
- `ভগ্নাংশের_অ্যারে` (Float array)
- `বাক্যের_অ্যারে` (String array)
- `বুলিয়ানের_অ্যারে` (Boolean array)
- `অ্যারের_আকার` (Array size)
- `বাবল_সর্ট` (Bubble sort)
- `কুইক_সর্ট` (Quick sort)
- `বাইনারি_সার্চ` (Binary search)

### Built-in functions:
- `বন্ধ` (exit)
- `কনসোল_মুছো` (clearConsole)
- `ভ্যারিয়েবল_মুছো` (delete_var)
- `প্রেসে_থামো` (stopOnEnter)
- `প্রেসে_শেষ` (hold)
- `থামো` (sleep)

### Library support
- `math.klm`

## Getting Started

### Prerequisites
- Java 21 or higher

### Running the Interpreter
1. Clone this repository
2. Compile the Java files:
   ```sh
   javac *.java
   ```
3. Create a source file (e.g., `Demo.kls`) with your code
4. Run the interpreter:
   ```sh
   java Main Demo.kls
   ```
5. To run jar file directly:
    ```sh
    java -jar KalpanaLang.jar Demo.kls
    ```

## Example Programs

### Hello World
```KalpanaLang
দেখা("হ্যালো বিশ্ব!");
```

### Fibonacci Series
```KalpanaLang
পূর্ণসংখ্যা n = 10;
পূর্ণসংখ্যার_অ্যারে fib[n];

fib[1] = 1;
fib[2] = 1;

লুপ (পূর্ণসংখ্যা i = 3; i <= n; i++)
{
    fib[i] = fib[i-1] + fib[i-2];
}

লুপ (পূর্ণসংখ্যা i = 1; i <= n; i++)
{
    দেখাও(fib[i]);
}
```

### Function Example
```KalpanaLang
ফাংশন পূর্ণসংখ্যা factorial(পূর্ণসংখ্যা n)
{
    যদি (n == 0)
    {
        ফেরত 1;
    }
    ফেরত n * factorial(n - 1);
}

দেখাও(factorial(5));
```

## Supported Language Translations

| English | Bengali | Russian | Hindi |
|---------|---------|---------|-------|
| print | দেখাও | печать | प्रिंट |
| integer | পূর্ণসংখ্যা | цел | पूर्णांक |
| float | ভগ্নাংশ | дробь | भिन्न |
| string | বাক্য | строка | स्ट्रिंग |
| if | যদি | если | अगर |
| else | বা | иначе | और |
| function | ফাংশন | функция | फंक्शन |

## Project Structure

```
KalpanaLang/
├── Main.java               - Main entry point
├── KalpanaLang.jar         - jar file of interpreter
├── LICENSE                 - License file
├── Demo.kls                - An example of my language, kls means KalpanaLangSource
├── math.klm                - A math library for interpreter. klm means KalpanaLangModiule.
└── README.md               - This file
```

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Inspired by the need for native language programming tools.
- Built with Java for portability and performance.

### Project Team

**Core Development:**
- Hasin Israk (Toaha) - Author, Main Programmer

**Documentation:**
- Fabiha Islam (Deeba).
- Hafsa Akter.
- Ritu Moni.

**Quality Assurance & Bug Fixing:**
- Akash Mitro (Nill).
- Sifat Hossen.
- Sojib Islam (Akash).

**Project Management:**
- Lamia Akter - Version Control.
- Sarmin Akter - Version Control.
- Siam Hossen - Class Manager, Mascot Designer.

**Research & Development:**
- Sahanaj Mim - JDK Selection.
- Avijit Dewry - Utility Function.

**Special Thanks To:**
- All beta testers and early adopters.
- The open source community for their invaluable resources.


### Known bugs:
1. Need to update language pack in class LanguageTranslator.


### Used Tools & Technologies
1. Termux.
2. OpenJDK 21.
3. QuickEdit.
4. Memory Card.

This project is the result of collaborative effort from all team members who contributed their time, skills, and creativity to make KalpanaLang a reality.

