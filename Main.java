
import java.io.*;
import java.math.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

class LanguageTranslator
{
    public static final Map<String, String> englishToBangla = new LinkedHashMap<String, String>();

    public static final Map<String, String> russianToBangla = new LinkedHashMap<String, String>();

    public static final Map<String, String> hindiToBangla = new LinkedHashMap<String, String>();

    public static final Map<String, String> banglaToBangla = new LinkedHashMap<String, String>();

    static
    {
        // BN -> BN
        banglaToBangla.put("আকার_বাড়াও", "আকার_বাড়াও");
        banglaToBangla.put("দেখা", "দেখা");
        banglaToBangla.put("দেখাও", "দেখাও");
        banglaToBangla.put("থামো", "থামো");
        banglaToBangla.put("শুরুতে_যাও", "শুরুতে_যাও");
        banglaToBangla.put("পূর্ণসংখ্যা", "পূর্ণসংখ্যা");
        banglaToBangla.put("ভগ্নাংশ", "ভগ্নাংশ");
        banglaToBangla.put("বাক্য", "বাক্য");
        banglaToBangla.put("বুলিয়ান", "বুলিয়ান");
        banglaToBangla.put("সত্য", "সত্য");
        banglaToBangla.put("মিথ্যা", "মিথ্যা");
        banglaToBangla.put("নাও", "নাও");
        banglaToBangla.put("যদিবা", "যদিবা");
        banglaToBangla.put("যদি", "যদি");
        banglaToBangla.put("বা", "বা");
        banglaToBangla.put("এড়াও", "এড়াও");
        banglaToBangla.put("ভাঙো", "ভাঙো");
        banglaToBangla.put("লুপ", "লুপ");
        banglaToBangla.put("ফাংশন", "ফাংশন");
        banglaToBangla.put("খালি", "খালি");
        banglaToBangla.put("ফেরত", "ফেরত");
        banglaToBangla.put("পূর্ণসংখ্যার_অ্যারে", "পূর্ণসংখ্যার_অ্যারে");
        banglaToBangla.put("ভগ্নাংশের_অ্যারে", "ভগ্নাংশের_অ্যারে");
        banglaToBangla.put("বাক্যের_অ্যারে", "বাক্যের_অ্যারে");
        banglaToBangla.put("অ্যারের_আকার", "অ্যারের_আকার");
        banglaToBangla.put("বাবল_সর্ট", "বাবল_সর্ট");
        banglaToBangla.put("কুইক_সর্ট", "কুইক_সর্ট");
        banglaToBangla.put("বাইনারি_সার্চ", "বাইনারি_সার্চ");
        banglaToBangla.put("বুলিয়ানের_অ্যারে", "বুলিয়ানের_অ্যারে");
        banglaToBangla.put("ভ্যারিয়েবল_মুছো", "ভ্যারিয়েবল_মুছো");
        banglaToBangla.put("বন্ধ", "বন্ধ");
        banglaToBangla.put("প্রেসে_থামো", "প্রেসে_থামো");
        banglaToBangla.put("প্রেসে_শেষ", "প্রেসে_শেষ");
        banglaToBangla.put("০", "0");
        banglaToBangla.put("১", "1");
        banglaToBangla.put("২", "2");
        banglaToBangla.put("৩", "3");
        banglaToBangla.put("৪", "4");
        banglaToBangla.put("৫", "5");
        banglaToBangla.put("৬", "6");
        banglaToBangla.put("৭", "7");
        banglaToBangla.put("৮", "8");
        banglaToBangla.put("৯", "9");

        // EN -> BN
        englishToBangla.put("increase_size", "আকার_বাড়াও");
        englishToBangla.put("resize_array", "আকার_বাড়াও");
        englishToBangla.put("gotoStart", "শুরুতে_যাও");
        englishToBangla.put("restart", "শুরুতে_যাও");
        englishToBangla.put("println", "দেখা");
        englishToBangla.put("print", "দেখাও");
        englishToBangla.put("show", "দেখাও");
        englishToBangla.put("int", "পূর্ণসংখ্যা");
        englishToBangla.put("integer", "পূর্ণসংখ্যা");
        englishToBangla.put("double", "ভগ্নাংশ");
        englishToBangla.put("float", "ভগ্নাংশ");
        englishToBangla.put("string", "বাক্য");
        englishToBangla.put("bool", "বুলিয়ান");
        englishToBangla.put("boolean", "বুলিয়ান");
        englishToBangla.put("true", "সত্য");
        englishToBangla.put("false", "মিথ্যা");
        englishToBangla.put("input", "নাও");
        englishToBangla.put("read", "নাও");
        englishToBangla.put("elseif", "যদিবা");
        englishToBangla.put("else if", "যদিবা");
        englishToBangla.put("if", "যদি");
        englishToBangla.put("else", "বা");
        englishToBangla.put("continue", "এড়াও");
        englishToBangla.put("break", "ভাঙো");
        englishToBangla.put("for", "লুপ");
        englishToBangla.put("loop", "লুপ");
        englishToBangla.put("function", "ফাংশন");
        englishToBangla.put("func", "ফাংশন");
        englishToBangla.put("void", "খালি");
        englishToBangla.put("return", "ফেরত");
        englishToBangla.put("int_array", "পূর্ণসংখ্যার_অ্যারে");
        englishToBangla.put("float_array", "ভগ্নাংশের_অ্যারে");
        englishToBangla.put("string_array", "বাক্যের_অ্যারে");
        englishToBangla.put("array_size", "অ্যারের_আকার");
        englishToBangla.put("bubble_sort", "বাবল_সর্ট");
        englishToBangla.put("quick_sort", "কুইক_সর্ট");
        englishToBangla.put("binary_search", "বাইনারি_সার্চ");
        englishToBangla.put("boolean_array", "বুলিয়ানের_অ্যারে");
        englishToBangla.put("delete_var", "ভ্যারিয়েবল_মুছো");
        englishToBangla.put("remove_var", "ভ্যারিয়েবল_মুছো");
        englishToBangla.put("exit", "বন্ধ");
        englishToBangla.put("terminate", "বন্ধ");
        englishToBangla.put("close", "বন্ধ");
        englishToBangla.put("stopOnEnter", "প্রেসে_থামো");
        englishToBangla.put("clearConsole", "কনসোল_মুছো");

        // Russian to Bangla
        russianToBangla.put("печать", "দেখাও");
        russianToBangla.put("показать", "দেখাও");
        russianToBangla.put("цел", "পূর্ণসংখ্যা");
        russianToBangla.put("целое", "পূর্ণসংখ্যা");
        russianToBangla.put("дробь", "ভগ্নাংশ");
        russianToBangla.put("двойной", "ভগ্নাংশ");
        russianToBangla.put("строка", "বাক্য");
        russianToBangla.put("булево", "বুলিয়ান");
        russianToBangla.put("истина", "সত্য");
        russianToBangla.put("правда", "সত্য");
        russianToBangla.put("ложь", "মিথ্যা");
        russianToBangla.put("ввод", "নাও");
        russianToBangla.put("читать", "নাও");
        russianToBangla.put("иначеесли", "যদিবা");
        russianToBangla.put("иначе если", "যদিবা");
        russianToBangla.put("если", "যদি");
        russianToBangla.put("иначе", "বা");
        russianToBangla.put("продолжить", "এড়াও");
        russianToBangla.put("прервать", "ভাঙো");
        russianToBangla.put("для", "লুপ");
        russianToBangla.put("цикл", "লুপ");
        russianToBangla.put("функция", "ফাংশন");
        russianToBangla.put("пустота", "খালি");
        russianToBangla.put("возврат", "ফেরত");
        russianToBangla.put("массив_целых", "পূর্ণসংখ্যার_অ্যারে");
        russianToBangla.put("массив_дробей", "ভগ্নাংশের_অ্যারে");
        russianToBangla.put("массив_строк", "বাক্যের_অ্যারে");
        russianToBangla.put("размер_массива", "অ্যারের_আকার");
        russianToBangla.put("пузырьковая_сортировка", "বাবল_সর্ট");
        russianToBangla.put("быстрая_сортировка", "কুইক_সর্ট");
        russianToBangla.put("бинарный_поиск", "বাইনারি_সার্চ");
        russianToBangla.put("массив_булевых", "বুলিয়ানের_অ্যারে");
        russianToBangla.put("удалить_переменную", "ভ্যারিয়েবল_মুছো");
        russianToBangla.put("вернуться_в_начало", "শুরুতে_যাও");
        russianToBangla.put("закрыть", "বন্ধ");
        russianToBangla.put("выход", "বন্ধ");
        // Hindi to Bangla
        hindiToBangla.put("प्रिंट", "দেখাও");
        hindiToBangla.put("दिखाएं", "দেখাও");
        hindiToBangla.put("पूर्णांक", "পূর্ণসংখ্যা");
        hindiToBangla.put("अंक", "পূর্ণসংখ্যা");
        hindiToBangla.put("दशमलव", "ভগ্নাংশ");
        hindiToBangla.put("भिन्न", "ভগ্নাংশ");
        hindiToBangla.put("स्ट्रिंग", "বাক্য");
        hindiToBangla.put("बूलियन", "বুলিয়ান");
        hindiToBangla.put("सही", "সত্য");
        hindiToBangla.put("गलत", "মিথ্যা");
        hindiToBangla.put("इनपुट", "নাও");
        hindiToBangla.put("पढ़ें", "নাও");
        hindiToBangla.put("अन्यथा यदि", "যদিবা");
        hindiToBangla.put("अगर", "যদি");
        hindiToBangla.put("और", "বা");
        hindiToBangla.put("जारी", "এড়াও");
        hindiToBangla.put("तोड़", "ভাঙো");
        hindiToBangla.put("लूप", "লুপ");
        hindiToBangla.put("फंक्शन", "ফাংশন");
        hindiToBangla.put("खाली", "খালি");
        hindiToBangla.put("वापसी", "ফেরত");
        hindiToBangla.put("पूर्णांक_सरणी", "পূর্ণসংখ্যার_অ্যারে");
        hindiToBangla.put("अंश_सरणी", "ভগ্নাংশের_অ্যারে");
        hindiToBangla.put("स्ट्रिंग_सरणी", "বাক্যের_অ্যারে");
        hindiToBangla.put("सरणी_आकार", "অ্যারের_আকার");
        hindiToBangla.put("बबल_क्रमबद्ध", "বাবল_সর্ট");
        hindiToBangla.put("त्वरित_क्रमबद्ध", "কুইক_সর্ট");
        hindiToBangla.put("द्विआधारी_खोज", "বাইনারি_সার্চ");
        hindiToBangla.put("चर_हटाएं", "ভ্যারিয়েবল_মুছো");
        hindiToBangla.put("बूलियन_सरणी", "বুলিয়ানের_অ্যারে");
        hindiToBangla.put("शुरू_पर_जाएं", "শুরুতে_যাও");
        hindiToBangla.put("बंद", "বন্ধ");
        hindiToBangla.put("समाप्त", "বন্ধ");
    }

    public static synchronized String translateToBangla(String sourceCode)
    {
        if (sourceCode == null || sourceCode.trim().isEmpty())
        {
            return sourceCode;
        }

        String translatedCode = sourceCode;
        String detectedLanguage = detectLanguage(sourceCode);

        // Translate based on detected language
        switch (detectedLanguage)
        {
        case "russian":
            translatedCode = translateLanguage(translatedCode, russianToBangla);
            break;
        case "english":
            translatedCode = translateLanguage(translatedCode, englishToBangla);
            break;
        case "hindi":
            translatedCode = translateLanguage(translatedCode, hindiToBangla);
            break;
        case "bangla":
            translatedCode = translateLanguage(translatedCode, banglaToBangla);
            break;
        case "mixed":
            // For mixed code, translate in order: Russian -> English -> Hindi
            translatedCode = translateLanguage(translatedCode, russianToBangla);
            translatedCode = translateLanguage(translatedCode, englishToBangla);
            translatedCode = translateLanguage(translatedCode, hindiToBangla);
            break;
        }

        return translatedCode;
    }

    private static synchronized String translateLanguage(String code, Map<String, String> translationMap)
    {
        StringBuilder result = new StringBuilder();
        int currentPos = 0;

        // Handle string literals first
        Pattern stringPattern = Pattern.compile("\"(?:\\\\\"|[^\"])*\"");
        Matcher matcher = stringPattern.matcher(code);

        while (currentPos < code.length())
        {
            if (matcher.find(currentPos))
            {
                // Translate non-string part
                String nonString = code.substring(currentPos, matcher.start());
                result.append(translateNonStringPart(nonString, translationMap));

                // Keep string literal as-is
                result.append(matcher.group());
                currentPos = matcher.end();
            }
            else
            {
                // Translate remaining code
                String remaining = code.substring(currentPos);
                result.append(translateNonStringPart(remaining, translationMap));
                break;
            }
        }

        return result.toString();
    }

    private static synchronized String translateNonStringPart(String text, Map<String, String> translationMap)
    {
        String result = text;

        // Process longer keywords first
        List<String> keywords = new Vector<>(translationMap.keySet());
        keywords.sort((a, b) -> b.length() - a.length());

        for (String keyword : keywords)
        {
            String replacement = translationMap.get(keyword);
            if (translationMap == englishToBangla)
            {
                // Case-insensitive for English
                result = Pattern.compile("\\b" + Pattern.quote(keyword) + "\\b", Pattern.CASE_INSENSITIVE)
                         .matcher(result)
                         .replaceAll(replacement);
            }
            else
            {
                // Exact match for other languages
                result = result.replace(keyword, replacement);
            }
        }

        return result;
    }

    public static synchronized String detectLanguage(String code)
    {
        if (code == null || code.trim().isEmpty())
        {
            return "unknown";
        }

        int banglaCount = 0;
        int englishCount = 0;
        int russianCount = 0;
        int hindiCount = 0;

        // Count Bangla keywords
        for (String keyword : banglaToBangla.keySet())
        {
            if (code.contains(keyword))
            {
                banglaCount++;
            }
        }

        // Count English keywords
        for (String keyword : englishToBangla.keySet())
        {
            if (Pattern.compile("\\b" + Pattern.quote(keyword) + "\\b", Pattern.CASE_INSENSITIVE)
                    .matcher(code)
                    .find())
            {
                englishCount++;
            }
        }

        // Count Russian keywords
        for (String keyword : russianToBangla.keySet())
        {
            if (code.contains(keyword))
            {
                russianCount++;
            }
        }

        // Count Hindi keywords
        for (String keyword : hindiToBangla.keySet())
        {
            if (code.contains(keyword))
            {
                hindiCount++;
            }
        }

        // Decision logic
        if (banglaCount > 0 && englishCount == 0 && russianCount == 0 && hindiCount == 0)
        {
            return "bangla";
        } else if (russianCount > 0 && englishCount == 0 && hindiCount == 0)
        {
            return "russian";
        } else if (englishCount > 0 && russianCount == 0 && hindiCount == 0)
        {
            return "english";
        } else if (hindiCount > 0 && englishCount == 0 && russianCount == 0)
        {
            return "hindi";
        } else if (banglaCount > 0 || englishCount > 0 || russianCount > 0 || hindiCount > 0)
        {
            return "mixed";
        }

        return "unknown";
    }
}

enum TokenType
{
    // Keywords
    INTEGER_ARRAY("পূর্ণসংখ্যার_অ্যারে"),
    FLOAT_ARRAY("ভগ্নাংশের_অ্যারে"),
    STRING_ARRAY("বাক্যের_অ্যারে"),
    ARRAY_SIZE("অ্যারের_আকার"),
    BUBBLE_SORT("বাবল_সর্ট"),
    QUICK_SORT("কুইক_সর্ট"),
    BINARY_SEARCH("বাইনারি_সার্চ"),
    INTEGER("পূর্ণসংখ্যা"),
    FLOAT("ভগ্নাংশ"),
    STRING("বাক্য"),
    BOOLEAN("বুলিয়ান"),
    PRINTLN("দেখা"),
    PRINT("দেখাও"),
    TRUE("সত্য"),
    FALSE("মিথ্যা"),
    NIL("null"),
    IF("যদি"),
    ELSE_IF("যদিবা"),
    ELSE("বা"),
    LOOP("লুপ"),
    BREAK("ভাঙ"),
    CONTINUE("এড়াও"),
    INPUT("নাও"),
    FUNCTION("ফাংশন"),
    RETURN("ফেরত"),
    VOID("খালি"),
    GO_TO_START("শুরুতে_যাও"),
    DELETE_VAR("ভ্যারিয়েবল_মুছো"),
    BOOLEAN_ARRAY("বুলিয়ানের_অ্যারে"),
    BANDH("বন্ধ"),
    SLEEP("থামো"),
    WAIT_FOR_ENTER("প্রেসে_থামো"),
    WAIT_FOR_END("প্রেসে_শেষ"),
    INCREASE_SIZE("আকার_বাড়াও"),
    // Literals
    IDENTIFIER,
    INTEGER_LITERAL,
    FLOAT_LITERAL,
    STRING_LITERAL,
    BOOLEAN_LITERAL,

    // Operators
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    EQUAL_EQUAL("=="),
    BANG_EQUAL("!="),
    BANG("!"),
    BITWISE_AND("&"),
    BITWISE_OR("|"),
    BITWISE_XOR("^"),
    BITWISE_NOT("~"),
    LEFT_SHIFT("<<"),
    RIGHT_SHIFT(">>"),
    UNSIGNED_RIGHT_SHIFT(">>>"),
    LESS("<"),
    LESS_EQUAL("<="),
    GREATER(">"),
    GREATER_EQUAL(">="),
    AND("&&"),
    OR("||"),
    ASSIGN("="),
    INCREMENT("++"),
    DECREMENT("--"),
    ARROW("→"),
    MODULO("%"),

    // Punctuation
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACE("{"),
    RIGHT_BRACE("}"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    SEMICOLON(";"),
    COMMA(","),

    // Special
    EOF;

    final String bangla;

    TokenType()
    {
        this.bangla = null;
    }

    TokenType(String bangla)
    {
        this.bangla = bangla;
    }
}

class Token
{
    TokenType type;
    TokenType varType;
    final String lexeme;
    final Object literal;
    final int line;

    Token(TokenType type, String lexeme, Object literal, int line)
    {
        this.type = type;
        this.lexeme = lexeme;
        this.literal = literal;
        this.line = line;
        this.varType = null;
    }


    @Override
    public String toString()
    {
        return type + " " + lexeme + " " + literal;
    }

}

class Lexer
{
    private final String source;
    private final List<Token> tokens = new Vector<>();
    private int start = 0;
    private int current = 0;
    private int line = 1;

    Lexer(String source)
    {
        // Translate the source code to Bangla first
        String translatedSource = LanguageTranslator.translateToBangla(source);
        this.source = translatedSource;
    }

    List<Token> scanTokens()
    {
        while (!isAtEnd())
        {
            start = current;
            scanToken();
        }
        tokens.add(new Token(TokenType.EOF, "", null, line));
        return tokens;
    }

    private synchronized void  scanToken()
    {
        char c;
        c = advance();

        switch (c)
        {
        case '(':
            addToken(TokenType.LEFT_PAREN);
            break;
        case ')':
            addToken(TokenType.RIGHT_PAREN);
            break;
        case '{':
            addToken(TokenType.LEFT_BRACE);
            break;
        case '}':
            addToken(TokenType.RIGHT_BRACE);
            break;
        case '[':
            addToken(TokenType.LEFT_BRACKET);
            break;
        case ']':
            addToken(TokenType.RIGHT_BRACKET);
            break;
        case ';':
            addToken(TokenType.SEMICOLON);
            break;
        case ',':
            addToken(TokenType.COMMA);
            break;
        case '+':
            if (match('+'))
            {
                addToken(TokenType.INCREMENT);
            }
            else
            {
                addToken(TokenType.PLUS);
            }
            break;
        case '-':
            if (match('-'))
            {
                addToken(TokenType.DECREMENT);
            } else if (peek() == '>')
            {
                advance(); // consume the '>'
                addToken(TokenType.ARROW);
            }
            else
            {
                addToken(TokenType.MINUS);
            }
            break;
        case '*':
            addToken(TokenType.MULTIPLY);
            break;
        case '%':
            addToken(TokenType.MODULO);
            break;
        case '/':
            if (match('/'))
            {
                // Single-line comment
                while (peek() != '\n' && !isAtEnd()) advance();
            } else if (match('*'))
            {
                // Multi-line comment
                multiLineComment();
            } else
            {
                addToken(TokenType.DIVIDE);
            }
            break;

        case '!':
            addToken(match('=') ? TokenType.BANG_EQUAL : TokenType.BANG);
            break;
        case '=':
            addToken(match('=') ? TokenType.EQUAL_EQUAL : TokenType.ASSIGN);
            break;
        case '<':
            if (match('<'))
            {
                addToken(TokenType.LEFT_SHIFT);
            } else
            {
                addToken(match('=') ? TokenType.LESS_EQUAL : TokenType.LESS);
            }
            break;
        case '>':
            if (match('>'))
            {
                if (match('>'))
                {
                    addToken(TokenType.UNSIGNED_RIGHT_SHIFT);
                } else
                {
                    addToken(TokenType.RIGHT_SHIFT);
                }
            } else
            {
                addToken(match('=') ? TokenType.GREATER_EQUAL : TokenType.GREATER);
            }
            break;


        case '&':
            addToken(match('&') ? TokenType.AND : TokenType.BITWISE_AND);
            break;
        case '|':
            addToken(match('|') ? TokenType.OR : TokenType.BITWISE_OR);
            break;
        case '^':
            addToken(TokenType.BITWISE_XOR);
            break;
        case '~':
            addToken(TokenType.BITWISE_NOT);
            break;
        case ' ':
        case '\r':
        case '\t':
            break;
        case '\n':
            line++;
            break;
        case '"':
            string();
            break;
        default:
            // It will Handle Unicode arrow character (→) to initialize array.
            if (c == '→')
            {
                addToken(TokenType.ARROW);
            }
            else if (isDigit(c))
            {
                number();
            }
            else if (isAlpha(c))
            {
                identifier();
            }
            else
            {
                throw new RuntimeException("Unexpected character '" + c + "' at line " + line);
            }
            break;
        }
    }

    private void multiLineComment()
    {
        while (!isAtEnd())
        {
            if (peek() == '*' && peekNext() == '/')
            {
                advance(); // consume the '*'
                advance(); // consume the '/'
                break;
            }
            if (peek() == '\n') line++;
            advance();
        }

        if (isAtEnd())
        {
            throw new RuntimeException("Unterminated multi-line comment at line " + line);
        }
    }

    private void identifier()
    {
        while (isAlphaNumeric(peek())) advance();

        String text = source.substring(start, current);

        for (TokenType type : TokenType.values())
        {
            if (type.bangla != null && type.bangla.equals(text))
            {
                addToken(type);
                return;
            }
        }

        addToken(TokenType.IDENTIFIER);
    }

    private void number()
    {
        while (isDigit(peek())) advance();

        if (peek() == '.' && isDigit(peekNext()))
        {
            advance();
            while (isDigit(peek())) advance();
            try
            {
                addToken(TokenType.FLOAT_LITERAL, new BigDecimal(source.substring(start, current)));
            }
            catch (NumberFormatException e)
            {
                throw new RuntimeException("Invalid number format at line " + line);
            }
        }
        else
        {
            try
            {
                addToken(TokenType.INTEGER_LITERAL, new BigDecimal(source.substring(start, current)));
            }
            catch (NumberFormatException e)
            {
                throw new RuntimeException("Invalid number format at line " + line);
            }
        }
    }

    private void string()
    {
        StringBuilder value = new StringBuilder();

        while (peek() != '"' && !isAtEnd())
        {
            if (peek() == '\n') line++;

            if (peek() == '\\')
            {
                advance(); // consume the backslash
                char escapeChar = advance();
                switch (escapeChar)
                {
                case '"':
                    value.append('"');
                    break;
                case '\\':
                    value.append('\\');
                    break;
                case '/':
                    value.append('/');
                    break;
                case 'b':
                    value.append('\b');
                    break;
                case 'f':
                    value.append('\f');
                    break;
                case 'n':
                    value.append('\n');
                    break;
                case 'r':
                    value.append('\r');
                    break;
                case 't':
                    value.append('\t');
                    break;
                case 'u':
                    // Unicode escape sequence
                    if (current + 4 > source.length())
                    {
                        throw new RuntimeException("Incomplete Unicode escape sequence at line " + line);
                    }
                    String hex = source.substring(current, current + 4);
                    try
                    {
                        int codePoint = Integer.parseInt(hex, 16);
                        value.append((char)codePoint);
                        current += 4;
                    }
                    catch (NumberFormatException e)
                    {
                        throw new RuntimeException("Invalid Unicode escape sequence at line " + line);
                    }
                    break;
                default:
                    throw new RuntimeException("Invalid escape sequence \\" + escapeChar + " at line " + line);
                }
            }
            else
            {
                value.append(advance());
            }
        }

        if (isAtEnd())
        {
            throw new RuntimeException("Unterminated string at line " + line);
        }

        advance(); // consume the closing quote
        addToken(TokenType.STRING_LITERAL, value.toString());
    }
    private boolean match(char expected)
    {
        if (isAtEnd()) return false;
        if (source.charAt(current) != expected) return false;
        current++;
        return true;
    }

    private char peek()
    {
        if (isAtEnd()) return '\0';
        return source.charAt(current);
    }

    private char peekNext()
    {
        if (current + 1 >= source.length()) return '\0';
        return source.charAt(current + 1);
    }

    private boolean isAlpha(char c)
    {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_' ||
               Character.UnicodeBlock.of(c) == Character.UnicodeBlock.BENGALI || Character.UnicodeBlock.of(c) == Character.UnicodeBlock.CYRILLIC || Character.UnicodeBlock.of(c) ==Character.UnicodeBlock.MATHEMATICAL_OPERATORS;
    }

    private boolean isAlphaNumeric(char c)
    {
        return isAlpha(c) || isDigit(c);
    }

    private boolean isDigit(char c)
    {
        return c >= '0' && c <= '9';
    }

    private boolean isAtEnd()
    {
        return current >= source.length();
    }

    private char advance()
    {
        return source.charAt(current++);
    }

    private void addToken(TokenType type)
    {
        addToken(type, null);
    }

    private void addToken(TokenType type, Object literal)
    {
        String text = source.substring(start, current);
        tokens.add(new Token(type, text, literal, line));
    }
}

interface Expr
{
    <R> R accept(ExprVisitor<R> visitor);
}

interface ExprVisitor<R>
{
    R visitBinaryExpr(Binary expr);
    R visitGroupingExpr(Grouping expr);
    R visitLiteralExpr(Literal expr);
    R visitUnaryExpr(Unary expr);
    R visitVariableExpr(Variable expr);
    R visitArrayExpr(Array expr);
    R visitArrayAccessExpr(ArrayAccess expr);
    R visitArrayAssignmentExpr(ArrayAssignment expr);
    R visitArraySizeExpr(ArraySize expr);
    R visitCallExpr(Call expr);
}

record Binary(Expr left, Token operator, Expr right) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitBinaryExpr(this);
    }
}

record Grouping(Expr expression) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitGroupingExpr(this);
    }
}

record Literal(Object value) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitLiteralExpr(this);
    }
}

record Unary(Token operator, Expr right) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitUnaryExpr(this);
    }
}

record Variable(Token name) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitVariableExpr(this);
    }
}

record Array(Token name, Expr size, List<Expr> initialValues) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitArrayExpr(this);
    }
}

record ArrayAccess(Expr array, Expr index) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitArrayAccessExpr(this);
    }
}

record ArrayAssignment(Expr array, Expr index, Expr value) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitArrayAssignmentExpr(this);
    }
}
record ArraySize(Expr array) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitArraySizeExpr(this);
    }
}
record Call(Expr callee, List<Expr> arguments) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitCallExpr(this);
    }
}

interface Stmt
{
    <R> R accept(StmtVisitor<R> visitor);
}

interface StmtVisitor<R>
{
    R visitBlockStmt(Block stmt);
    R visitExpressionStmt(Expression stmt);
    R visitIfStmt(If stmt);
    R visitPrintlnStmt(Println stmt);
    R visitPrintStmt(Print stmt);
    R visitVarStmt(Var stmt);
    R visitWhileStmt(While stmt);
    R visitBreakStmt(Break stmt);
    R visitContinueStmt(Continue stmt);
    R visitArrayStmt(ArrayStmt stmt);
    R visitSortStmt(SortStmt stmt);
    R visitSearchStmt(SearchStmt stmt);
    R visitInputStmt(Input stmt);
    R visitFunctionStmt(Function stmt);
    R visitReturnStmt(Return stmt);
    R visitSleepStmt(Sleep stmt);
    R visitWaitForEnterStmt(WaitForEnter stmt);
    R visitWaitForEndStmt(WaitForEnd stmt);
}

record Block(List<Stmt> statements) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitBlockStmt(this);
    }
}

record Break() implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitBreakStmt(this);
    }
}

record Expression(Expr expression) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitExpressionStmt(this);
    }
}

record If(Expr condition, Stmt thenBranch, List<ElseIf> elseIfBranches, Stmt elseBranch) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitIfStmt(this);
    }
}

record ElseIf(Expr condition, Stmt statement)
{
}

record Println(Expr expression) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitPrintlnStmt(this);
    }
}
record Print(Expr expression) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitPrintStmt(this);
    }
}
record Sleep(Expr expression) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitSleepStmt(this);
    }
}

record Var(Token name, Expr initializer) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitVarStmt(this);
    }
    public TokenType type()
    {
        return name.type;
    }
}

record While(Expr condition, Stmt body, Expr increment) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitWhileStmt(this);
    }
}

record Continue() implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitContinueStmt(this);
    }
}

record ArrayStmt(Token name, TokenType type, Expr size, List<Expr> initialValues) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitArrayStmt(this);
    }
}

record SortStmt(Expr array, String sortType) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitSortStmt(this);
    }
}

record SearchStmt(Expr array, Expr key) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitSearchStmt(this);
    }
}
record Input(TokenType expectedType, Token variable) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitInputStmt(this);
    }
}

record Function(Token name, Token returnType, List<Token> parameters, List<Stmt> body) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitFunctionStmt(this);
    }

    // Helper method to get parameter types
    public TokenType[] getParameterTypes()
    {
        return parameters.stream().map(t -> t.type).toArray(TokenType[]::new);
    }
}

record WaitForEnter() implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitWaitForEnterStmt(this);
    }
}

record WaitForEnd() implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitWaitForEndStmt(this);
    }
}

record Return(Token keyword, Expr value) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitReturnStmt(this);
    }
}

class Parser
{
    private final List<Token> tokens;
    private int current = 0;
    private boolean hadError = false;

    Parser(List<Token> tokens)
    {
        this.tokens = tokens;
    }

    List<Stmt> parse()
    {
        List<Stmt> statements = new Vector<>();
        while (!isAtEnd())
        {
            Stmt stmt = declaration();
            if (stmt != null) statements.add(stmt);
        }

        if (hadError)
        {
            System.exit(1);
        }

        return statements;
    }

    private Stmt declaration()
    {
        try
        {
            if (match(TokenType.INTEGER, TokenType.FLOAT, TokenType.STRING, TokenType.BOOLEAN))
            {
                return varDeclaration();
            }
            if (match(TokenType.FUNCTION))
            {
                return functionDeclaration();
            }
            if (match(TokenType.INTEGER_ARRAY, TokenType.FLOAT_ARRAY, TokenType.STRING_ARRAY, TokenType.BOOLEAN_ARRAY))
            {
                return arrayDeclaration();
            }
            return statement();
        }
        catch (RuntimeException error)
        {
            System.err.println("Parse error: " + error.getMessage());
            hadError = true;
            synchronize();
            return null;
        }
    }

    private Stmt functionDeclaration()
    {
        // Parse return type (either VOID or a type)
        Token returnType;
        if (match(TokenType.VOID))
        {
            returnType = previous();
            returnType.type = TokenType.VOID;
        }
        else if(match(TokenType.INTEGER, TokenType.FLOAT, TokenType.STRING, TokenType.BOOLEAN,
                      TokenType.INTEGER_ARRAY, TokenType.FLOAT_ARRAY,
                      TokenType.STRING_ARRAY, TokenType.BOOLEAN_ARRAY))
        {
            returnType = previous();
        }
        else
        {
            throw new RuntimeException("Expect return type after 'ফাংশন'");
        }

        // Parse function name
        Token name = consume(TokenType.IDENTIFIER, "Expect function name.");

        // Parse parameters
        consume(TokenType.LEFT_PAREN, "Expect '(' after function name.");
        List<Token> parameters = new Vector<>();
        if (!check(TokenType.RIGHT_PAREN))
        {
            do
            {
                if (parameters.size() >= 30000)
                {
                    throw new RuntimeException("Can't have more than 30000 parameters.");
                }

                if (match(TokenType.INTEGER, TokenType.FLOAT, TokenType.STRING, TokenType.BOOLEAN,
                          TokenType.INTEGER_ARRAY, TokenType.FLOAT_ARRAY,
                          TokenType.STRING_ARRAY, TokenType.BOOLEAN_ARRAY))
                {
                    Token type = previous();
                    Token param = consume(TokenType.IDENTIFIER, "Expect parameter name.");
                    param.type = type.type;
                    parameters.add(param);
                }
                else
                {
                    throw new RuntimeException("Expect parameter type");
                }
            } while (match(TokenType.COMMA));
        }
        consume(TokenType.RIGHT_PAREN, "Expect ')' after parameters.");

        // Parse function body
        consume(TokenType.LEFT_BRACE, "Expect '{' before function body.");
        List<Stmt> body = block();

        return new Function(name, returnType, parameters, body);
    }


    private Stmt arrayDeclaration()
    {
        Token type = previous();
        Token name = consume(TokenType.IDENTIFIER, "Expect array name.");
        name.type = type.type;

        Expr size = null;
        List<Expr> initialValues = new Vector<>();

        // Handle array size if specified
        if (match(TokenType.LEFT_BRACKET))
        {
            if (!check(TokenType.RIGHT_BRACKET))
            {
                size = expression();
            }
            consume(TokenType.RIGHT_BRACKET, "Expect ']' after array size.");
        }

        // Handle array initialization
        if (match(TokenType.ARROW))
        {
            consume(TokenType.LEFT_BRACE, "Expect '{' after '→'");
            if (!check(TokenType.RIGHT_BRACE))
            {
                do
                {
                    initialValues.add(expression());
                }
                while (match(TokenType.COMMA));
            }
            consume(TokenType.RIGHT_BRACE, "Expect '}' after array initializers.");
        }

        consume(TokenType.SEMICOLON, "Expect ';' after array declaration.");
        return new ArrayStmt(name, type.type, size, initialValues);
    }

    private Stmt varDeclaration()
    {
        Token type = previous();
        Token name = consume(TokenType.IDENTIFIER, "Expect variable name.");
        name.type = type.type;
        Expr initializer = null;
        if (match(TokenType.ASSIGN))
        {
            initializer = expression();
        }
        consume(TokenType.SEMICOLON, "Expect ';' after variable declaration.");
        return new Var(name, initializer);
    }

    private Stmt inputStatement()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'নাও'.");

        // First argument is the expected type
        TokenType expectedType = null;
        if (match(TokenType.INTEGER))
        {
            expectedType = TokenType.INTEGER;
        }
        else if (match(TokenType.FLOAT))
        {
            expectedType = TokenType.FLOAT;
        }
        else if (match(TokenType.STRING))
        {
            expectedType = TokenType.STRING;
        }
        else if (match(TokenType.BOOLEAN))
        {
            expectedType = TokenType.BOOLEAN;
        }
        else
        {
            throw new RuntimeException("Expect type (পূর্ণসংখ্যা, ভগ্নাংশ, বাক্য, or বুলিয়ান) after 'নাও'");
        }

        consume(TokenType.COMMA, "Expect ',' after type");

        // Second argument is the variable name
        Token variable = consume(TokenType.IDENTIFIER, "Expect variable name");
        variable.type = expectedType;  // Set the type on the token

        consume(TokenType.RIGHT_PAREN, "Expect ')' after input arguments");
        consume(TokenType.SEMICOLON, "Expect ';' after statement");

        return new Input(expectedType, variable);
    }
    private Stmt statement()
    {
        if (match(TokenType.IF)) return ifStatement();
        if (match(TokenType.PRINTLN)) return printlnStatement();
        if (match(TokenType.PRINT)) return printStatement();
        if (match(TokenType.LEFT_BRACE)) return new Block(block());
        if (match(TokenType.LOOP)) return loopStatement();
        if (match(TokenType.BREAK)) return breakStatement();
        if (match(TokenType.CONTINUE)) return continueStatement();
        if (match(TokenType.BUBBLE_SORT)) return sortStatement("bubble");
        if (match(TokenType.QUICK_SORT)) return sortStatement("quick");
        if (match(TokenType.BINARY_SEARCH)) return searchStatement();
        if (match(TokenType.INPUT)) return inputStatement();
        if (match(TokenType.RETURN)) return returnStatement();
        if (match(TokenType.SLEEP)) return sleepStatement();
        if (match(TokenType.WAIT_FOR_ENTER)) return waitForEnterStatement();
        if (match(TokenType.WAIT_FOR_END)) return waitForEndStatement();

        if (peek().type == TokenType.LEFT_PAREN)
        {
            throw new RuntimeException("Standalone condition without keyword  'যদি'(if) or  'লুপ' (loop).");
        }

        if (match(TokenType.ELSE_IF))
        {
            throw new RuntimeException("'যদিবা' (else-if) found without preceding 'যদি' (if) statement");
        }
        if (match(TokenType.ELSE))
        {
            throw new RuntimeException("'বা' (else) found without preceding 'যদি' (if) statement");
        }

        return expressionStatement();
    }
    private Stmt waitForEnterStatement()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'প্রেসে_থামো'");
        consume(TokenType.RIGHT_PAREN, "Expect ')'");
        consume(TokenType.SEMICOLON, "Expect ';' after statement");
        return new WaitForEnter();
    }
    private Stmt waitForEndStatement()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'প্রেসে_থামো'");
        consume(TokenType.RIGHT_PAREN, "Expect ')'");
        consume(TokenType.SEMICOLON, "Expect ';' after statement");
        return new WaitForEnd();
    }
    private Stmt sortStatement(String sortType)
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after sort function");
        Expr array = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after array expression");
        consume(TokenType.SEMICOLON, "Expect ';' after statement");
        return new SortStmt(array, sortType);
    }

    private Stmt searchStatement()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after binary search function");
        Expr array = expression();
        consume(TokenType.COMMA, "Expect ',' after array expression");
        Expr key = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after key expression");
        consume(TokenType.SEMICOLON, "Expect ';' after statement");
        return new SearchStmt(array, key);
    }

    private Stmt breakStatement()
    {
        consume(TokenType.SEMICOLON, "Expect ';' after 'ভাঙ'.");
        return new Break();
    }

    private Stmt continueStatement()
    {
        consume(TokenType.SEMICOLON, "Expect ';' after 'এড়াও'.");
        return new Continue();
    }

    private Stmt loopStatement()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'লুপ'.");

        boolean isForLoop = false;
        int savedPosition = current;

        while (!check(TokenType.RIGHT_PAREN) && !isAtEnd())
        {
            if (match(TokenType.SEMICOLON))
            {
                isForLoop = true;
                break;
            }
            advance();
        }

        current = savedPosition;

        if (isForLoop)
        {
            return forLoop();
        } else
        {
            return whileLoop();
        }
    }

    private Stmt forLoop()
    {
        Stmt initializer;
        if (match(TokenType.SEMICOLON))
        {
            initializer = null;
        } else if (match(TokenType.INTEGER, TokenType.FLOAT, TokenType.STRING, TokenType.BOOLEAN))
        {
            initializer = varDeclaration();
        } else
        {
            initializer = expressionStatement();
        }

        Expr condition = null;
        if (!check(TokenType.SEMICOLON))
        {
            condition = expression();
        }
        consume(TokenType.SEMICOLON, "Expect ';' after loop condition.");

        Expr increment = null;
        if (!check(TokenType.RIGHT_PAREN))
        {
            increment = expression();
        }
        consume(TokenType.RIGHT_PAREN, "Expect ')' after loop clauses.");

        Stmt body = statement();

        Stmt whileLoop = new While(condition != null ? condition : new Literal(true), body, increment);

        if (initializer != null)
        {
            return new Block(Arrays.asList(initializer, whileLoop));
        }

        return whileLoop;
    }

    private Stmt whileLoop()
    {
        Expr condition = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after condition.");
        Stmt body = statement();

        return new While(condition, body, null);
    }

    private Stmt ifStatement()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'যদি'.");
        Expr condition = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after if condition.");

        Stmt thenBranch = statement();

        List<ElseIf> elseIfBranches = new Vector<>();
        while (match(TokenType.ELSE_IF))
        {
            consume(TokenType.LEFT_PAREN, "Expect '(' after 'যদিবা'.");
            Expr elseIfCondition = expression();
            consume(TokenType.RIGHT_PAREN, "Expect ')' after else-if condition.");
            Stmt elseIfStatement = statement();
            elseIfBranches.add(new ElseIf(elseIfCondition, elseIfStatement));
        }

        Stmt elseBranch = null;
        if (match(TokenType.ELSE))
        {
            elseBranch = statement();
        }

        return new If(condition, thenBranch, elseIfBranches, elseBranch);
    }

    private List<Stmt> block()
    {
        List<Stmt> statements = new Vector<>();

        while (!check(TokenType.RIGHT_BRACE) && !isAtEnd())
        {
            Stmt stmt = declaration();
            if (stmt != null) statements.add(stmt);
        }

        consume(TokenType.RIGHT_BRACE, "Expect '}' after block.");
        return statements;
    }

    private Stmt printStatement()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'দেখাও'.");
        Expr value = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after expression.");
        consume(TokenType.SEMICOLON, "Expect ';' after value.");
        return new Print(value);
    }
    private Stmt printlnStatement()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'দেখাও'.");
        Expr value = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after expression.");
        consume(TokenType.SEMICOLON, "Expect ';' after value.");
        return new Println(value);
    }
    private Stmt sleepStatement()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'দেখাও'.");
        Expr value = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after expression.");
        consume(TokenType.SEMICOLON, "Expect ';' after value.");
        return new Sleep(value);
    }

    private Stmt expressionStatement()
    {
        Expr expr = expression();
        consume(TokenType.SEMICOLON, "Expect ';' after expression.");
        return new Expression(expr);
    }

    public Expr expression()
    {
        return assignment();
    }

    private Expr assignment()
    {
        Expr expr = or();

        if (match(TokenType.ASSIGN))
        {
            Token equals = previous();
            Expr value = assignment();

            if (expr instanceof Variable)
            {
                Token name = ((Variable)expr).name();
                return new Binary(expr, equals, value);
            } else if (expr instanceof ArrayAccess)
            {
                ArrayAccess access = (ArrayAccess)expr;
                return new ArrayAssignment(access.array(), access.index(), value);
            }

            throw new RuntimeException("Invalid assignment target.");
        }

        return expr;
    }

    private Expr or()
    {
        Expr expr = and();
        while (match(TokenType.OR))
        {
            Token operator = previous();
            Expr right = and();
            expr = new Binary(expr, operator, right);
        }
        return expr;
    }

    private Expr and()
    {
        Expr expr = equality();
        while (match(TokenType.AND))
        {
            Token operator = previous();
            Expr right = equality();
            expr = new Binary(expr, operator, right);
        }
        return expr;
    }

    private Expr equality()
    {
        Expr expr = bitwiseAnd();
        while (match(TokenType.EQUAL_EQUAL, TokenType.BANG_EQUAL))
        {
            Token operator = previous();
            Expr right = bitwiseAnd();
            expr = new Binary(expr, operator, right);
        }
        return expr;
    }

    private Expr bitwiseAnd()
    {
        Expr expr = bitwiseXor();
        while (match(TokenType.BITWISE_AND))
        {
            Token operator = previous();
            Expr right = bitwiseXor();
            expr = new Binary(expr, operator, right);
        }
        return expr;
    }

    private Expr bitwiseXor()
    {
        Expr expr = bitwiseOr();
        while (match(TokenType.BITWISE_XOR))
        {
            Token operator = previous();
            Expr right = bitwiseOr();
            expr = new Binary(expr, operator, right);
        }
        return expr;
    }

    private Expr bitwiseOr()
    {
        Expr expr = shift();
        while (match(TokenType.BITWISE_OR))
        {
            Token operator = previous();
            Expr right = shift();
            expr = new Binary(expr, operator, right);
        }
        return expr;
    }

    private Expr shift()
    {
        Expr expr = comparison();
        while (match(TokenType.LEFT_SHIFT, TokenType.RIGHT_SHIFT, TokenType.UNSIGNED_RIGHT_SHIFT))
        {
            Token operator = previous();
            Expr right = comparison();
            expr = new Binary(expr, operator, right);
        }
        return expr;
    }

    private Expr comparison()
    {
        Expr expr = term();
        while (match(TokenType.LESS, TokenType.LESS_EQUAL, TokenType.GREATER, TokenType.GREATER_EQUAL))
        {
            Token operator = previous();
            Expr right = term();
            expr = new Binary(expr, operator, right);
        }
        return expr;
    }

    private Expr term()
    {
        Expr expr = factor();
        while (match(TokenType.PLUS, TokenType.MINUS))
        {
            Token operator = previous();
            Expr right = factor();
            expr = new Binary(expr, operator, right);
        }
        return expr;
    }

    private Expr factor()
    {
        Expr expr = unary();
        while (match(TokenType.MULTIPLY, TokenType.DIVIDE, TokenType.MODULO))
        {
            Token operator = previous();
            Expr right = unary();
            expr = new Binary(expr, operator, right);
        }
        return expr;
    }

    private Expr unary()
    {
        if (match(TokenType.MINUS, TokenType.BANG, TokenType.INCREMENT,
                  TokenType.DECREMENT, TokenType.BITWISE_NOT))
        {
            Token operator = previous();
            Expr right = unary();
            return new Unary(operator, right);
        }

        Expr expr = primary();

        while (match(TokenType.INCREMENT, TokenType.DECREMENT))
        {
            Token operator = previous();
            expr = new Unary(operator, expr);
        }

        return expr;
    }


    private Expr finishCall(Expr callee)
    {
        List<Expr> arguments = new Vector<>();
        if (!check(TokenType.RIGHT_PAREN))
        {
            do
            {
                if (arguments.size() >= 255)
                {
                    throw new RuntimeException("Can't have more than 255 arguments.");
                }
                arguments.add(expression());
            } while (match(TokenType.COMMA));
        }
        Token paren = consume(TokenType.RIGHT_PAREN, "Expect ')' after arguments.");
        return new Call(callee, arguments);
    }

// Add return statement parsing
    private Stmt returnStatement()
    {
        Token keyword = previous();
        Expr value = null;
        if (!check(TokenType.SEMICOLON))
        {
            value = expression();
        }
        consume(TokenType.SEMICOLON, "Expect ';' after return value.");
        return new Return(keyword, value);
    }


    private Expr primary()
    {
        if (match(TokenType.FALSE)) return new Literal(false);
        if (match(TokenType.TRUE)) return new Literal(true);
        if (match(TokenType.NIL)) return new Literal(null);
        if (match(TokenType.INCREASE_SIZE))
        {
            return increaseSizeCall();
        }
        if (match(TokenType.GO_TO_START))
        {
            return goToStartCall();
        }
        if (match(TokenType.DELETE_VAR))
        {
            return deleteVarCall();
        }

        if (match(TokenType.BANDH))
        {
            return bandhCall();
        }

        if (match(TokenType.INTEGER_LITERAL, TokenType.FLOAT_LITERAL, TokenType.STRING_LITERAL))
        {
            Object value = previous().literal;
            // Convert to BigDecimal if it's a number
            if (value instanceof Integer)
            {
                value = new BigDecimal((Integer)value);
            } else if (value instanceof Double)
            {
                value = BigDecimal.valueOf((Double)value);
            }
            return new Literal(value);
        }

        if (match(TokenType.ARRAY_SIZE))
        {
            consume(TokenType.LEFT_PAREN, "Expect '(' after 'অ্যারের_আকার'");
            Expr array = expression();
            consume(TokenType.RIGHT_PAREN, "Expect ')' after array expression");
            return new ArraySize(array);
        }

        // Handle built-in functions
        if (match(TokenType.BINARY_SEARCH))
        {
            return binarySearchCall();
        }
        if (match(TokenType.BUBBLE_SORT))
        {
            return bubbleSortCall();
        }
        if (match(TokenType.QUICK_SORT))
        {
            return quickSortCall();
        }

        if (match(TokenType.IDENTIFIER))
        {
            Token name = previous();
            // Handle function calls
            if (match(TokenType.LEFT_PAREN))
            {
                return finishCall(new Variable(name));
            }
            // Check for array access
            if (match(TokenType.LEFT_BRACKET))
            {
                Expr index = expression();
                consume(TokenType.RIGHT_BRACKET, "Expect ']' after array index.");
                return new ArrayAccess(new Variable(name), index);
            }
            return new Variable(name);
        }

        if (match(TokenType.LEFT_PAREN))
        {
            Expr expr = expression();
            consume(TokenType.RIGHT_PAREN, "Expect ')' after expression.");
            return new Grouping(expr);
        }

        throw new RuntimeException("Expect expression.");
    }

    private Expr increaseSizeCall()
    {
        Token functionToken = previous(); // Get the INCREASE_SIZE token
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'আকার_বাড়াও'");
        Expr array = expression();
        consume(TokenType.COMMA, "Expect ',' after array expression");
        Expr size = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after size expression");
        return new Call(new Variable(new Token(TokenType.IDENTIFIER, "আকার_বাড়াও", null, functionToken.line)),
                        Arrays.asList(array, size));
    }
    private Expr bandhCall()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'বন্ধ'");
        Expr errorCode = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after error code");
        return new Call(new Variable(new Token(TokenType.IDENTIFIER, "বন্ধ", null, previous().line)),
                        Collections.singletonList(errorCode));
    }

    private Expr goToStartCall()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'শুরুতে_যাও'");
        consume(TokenType.RIGHT_PAREN, "Expect ')' after 'শুরুতে_যাও'");
        return new Call(new Variable(new Token(TokenType.IDENTIFIER, "শুরুতে_যাও", null, previous().line)),
                        Collections.emptyList());
    }
    private Expr deleteVarCall()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'ভ্যারিয়েবল_মুছো'");
        Expr variable = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after variable name");

        if (!(variable instanceof Variable))
        {
            throw new RuntimeException("Only variable names can be passed to 'ভ্যারিয়েবল_মুছো'");
        }

        return new Call(new Variable(new Token(TokenType.IDENTIFIER, "ভ্যারিয়েবল_মুছো", null, previous().line)),
                        Collections.singletonList(variable));
    }

    private Expr binarySearchCall()
    {
        Token functionToken = previous(); // Get the BINARY_SEARCH token
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'বাইনারি_সার্চ'");
        Expr array = expression();
        consume(TokenType.COMMA, "Expect ',' after array expression");
        Expr key = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after key expression");
        return new Call(new Variable(new Token(TokenType.IDENTIFIER, "বাইনারি_সার্চ", null, functionToken.line)),
                        Arrays.asList(array, key));
    }

    private Expr bubbleSortCall()
    {
        Token functionToken = previous(); // Get the BUBBLE_SORT token
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'বাবল_সর্ট'");
        Expr array = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after array expression");
        return new Call(new Variable(new Token(TokenType.IDENTIFIER, "বাবল_সর্ট", null, functionToken.line)),
                        Collections.singletonList(array));
    }

    private Expr quickSortCall()
    {
        Token functionToken = previous(); // Get the QUICK_SORT token
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'কুইক_সর্ট'");
        Expr array = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after array expression");
        return new Call(new Variable(new Token(TokenType.IDENTIFIER, "কুইক_সর্ট", null, functionToken.line)),
                        Collections.singletonList(array));
    }


    private boolean match(TokenType... types)
    {
        for (TokenType type : types)
        {
            if (check(type))
            {
                advance();
                return true;
            }
        }
        return false;
    }

    private Token consume(TokenType type, String message)
    {
        if (check(type)) return advance();
        throw new RuntimeException(message);
    }

    private boolean check(TokenType type)
    {
        if (isAtEnd()) return false;
        return peek().type == type;
    }

    private Token advance()
    {
        if (!isAtEnd()) current++;
        return previous();
    }

    private boolean isAtEnd()
    {
        return peek().type == TokenType.EOF;
    }

    private Token peek()
    {
        return tokens.get(current);
    }

    private Token previous()
    {
        return tokens.get(current - 1);
    }

    private void synchronize()
    {
        advance();
        while (!isAtEnd())
        {
            if (previous().type == TokenType.SEMICOLON) return;
            switch (peek().type)
            {
            case INTEGER:
            case FLOAT:
            case STRING:
            case BOOLEAN:
            case INTEGER_ARRAY:
            case FLOAT_ARRAY:
            case STRING_ARRAY:
            case BOOLEAN_ARRAY:
            case PRINT:
            case PRINTLN:
            case SLEEP:
            case IF:
                return;
            }
            advance();
        }
    }
}

class Environment
{
    public final Environment enclosing;
    private final Map<String, Object> values = new LinkedHashMap<>();
    public final Map<String, Object[]> arrays = new LinkedHashMap<>();
    private final Map<String, Function> functions = new LinkedHashMap<>();
    private final Map<String, TokenType> arrayTypes = new HashMap<>();

    Environment()
    {
        enclosing = null;
    }

    Environment(Environment enclosing)
    {
        this.enclosing = enclosing;
    }

    void defineFunction(String name, Function function)
    {
        functions.put(name, function);
    }

    public Environment deepCopy()
    {
        Environment copy = new Environment(this.enclosing != null ? this.enclosing.deepCopy() : null);

        // Deep copy variables
        for (Map.Entry<String, Object> entry : this.values.entrySet())
        {
            Object value = entry.getValue();
            if (value instanceof BigDecimal)
            {
                // BigDecimal is immutable, so we can share the reference
                copy.values.put(entry.getKey(), value);
            } else if (value instanceof String)
            {
                // Strings are immutable
                copy.values.put(entry.getKey(), value);
            } else if (value instanceof Boolean)
            {
                // Booleans are immutable
                copy.values.put(entry.getKey(), value);
            } else
            {
                // For other types, we might need to handle them specially
                copy.values.put(entry.getKey(), value);
            }
        }

        // Deep copy arrays
        for (Map.Entry<String, Object[]> entry : this.arrays.entrySet())
        {
            Object[] originalArray = entry.getValue();
            Object[] copiedArray = new Object[originalArray.length];
            System.arraycopy(originalArray, 0, copiedArray, 0, originalArray.length);
            copy.arrays.put(entry.getKey(), copiedArray);
        }

        // Copy functions (they can be shared as they're immutable once defined)
        copy.functions.putAll(this.functions);

        return copy;
    }

    Function getFunction(Token name)
    {
        if (functions.containsKey(name.lexeme))
        {
            return functions.get(name.lexeme);
        }
        if (enclosing != null) return enclosing.getFunction(name);
        throw new RuntimeException("Undefined function '" + name.lexeme + "'");
    }
    void deleteVariable(Token name)
    {
        if (values.containsKey(name.lexeme))
        {
            values.remove(name.lexeme);
            return;
        }
        if (arrays.containsKey(name.lexeme))
        {
            arrays.remove(name.lexeme);
            return;
        }

        if (enclosing != null)
        {
            enclosing.deleteVariable(name);
            return;
        }

        throw new RuntimeException("Undefined variable '" + name.lexeme + "' cannot be deleted");
    }



    void define(String name, Object value)
    {
        values.put(name, value);
    }

    void defineArray(String name, TokenType type, Object[] array)
    {
        arrays.put(name, array);
        arrayTypes.put(name, type);
    }

    Object get(Token name)
    {
        // First check if it's a function
        if (functions.containsKey(name.lexeme))
        {
            return functions.get(name.lexeme);
        }

        // Then check regular variables
        if (values.containsKey(name.lexeme))
        {
            return values.get(name.lexeme);
        }

        if (arrays.containsKey(name.lexeme))
        {
            return arrays.get(name.lexeme);
        }

        if (enclosing != null) return enclosing.get(name);

        throw new RuntimeException("Undefined variable '" + name.lexeme + "'");
    }
    int getArraySize(Token name)
    {
        if (arrays.containsKey(name.lexeme))
        {
            return arrays.get(name.lexeme).length;
        }

        if (enclosing != null) return enclosing.getArraySize(name);

        throw new RuntimeException("Undefined array '" + name.lexeme + "'");
    }
    Object getArrayElement(Token name, int index)
    {
        if (arrays.containsKey(name.lexeme))
        {
            Object[] array = arrays.get(name.lexeme);
            if (index < 1 || index > array.length)
            {
                throw new RuntimeException("Array index out of bounds for '" + name.lexeme + "'");
            }
            return array[index - 1]; // Convert from 1-based to 0-based
        }

        if (enclosing != null) return enclosing.getArrayElement(name, index);

        throw new RuntimeException("Undefined array '" + name.lexeme + "'");
    }

    void assign(Token name, Object value)
    {
        if (values.containsKey(name.lexeme))
        {
            values.put(name.lexeme, value);
            return;
        }

        if (enclosing != null)
        {
            enclosing.assign(name, value);
            return;
        }

        throw new RuntimeException("Undefined variable '" + name.lexeme + "'");
    }
    TokenType getArrayType(String name)
    {
        if (arrayTypes.containsKey(name))
        {
            return arrayTypes.get(name);
        }
        if (enclosing != null) return enclosing.getArrayType(name);
        return null;
    }



    void assignArrayElement(Token name, int index, Object value)
    {
        if (arrays.containsKey(name.lexeme))
        {
            Object[] array = arrays.get(name.lexeme);
            if (index < 1 || index > array.length)
            {
                throw new RuntimeException("Array index out of bounds for '" + name.lexeme + "'");
            }

            // Convert value type if needed
            if (array instanceof Integer[] && value instanceof Double)
            {
                value = ((Double)value).intValue();
            } else if (array instanceof Double[] && value instanceof Integer)
            {
                value = ((Integer)value).doubleValue();
            }

            array[index - 1] = value; // Convert from 1-based to 0-based
            return;
        }

        if (enclosing != null)
        {
            enclosing.assignArrayElement(name, index, value);
            return;
        }

        throw new RuntimeException("Undefined array '" + name.lexeme + "'");
    }
}
class GoToStartException extends RuntimeException
{
    public GoToStartException()
    {

    }
}
class ClearScreenException extends RuntimeException
{
    public ClearScreenException()
    {

    }
}
class BreakException extends RuntimeException
{
    }
class ContinueException extends RuntimeException
{
    }

class Interpreter implements ExprVisitor<Object>, StmtVisitor<Void>
{
    public Environment environment = new Environment();
    private List<Stmt> statements; // Store the parsed statements
    private Environment originalEnvironment; //Store original environment data
    private String sourceCode; // Store the original source code

    void interpret(List<Stmt> statements)
    {
        this.statements = statements;
        this.originalEnvironment = environment.deepCopy(); // Store initial environment

        try
        {
            while (true)
            {
                try
                {
                    for (Stmt statement : statements)
                    {
                        execute(statement);
                    }
                    break;
                }
                catch (GoToStartException e)
                {
                    // Create a new environment that's a deep copy of the original
                    environment = originalEnvironment.deepCopy();
                    //System.out.println("Restarting interpretation with initial environment..."); //For Debug only
                    continue;
                }
            }
        } catch (RuntimeException error)
        {
            System.err.println("Runtime error: " + error.getMessage());
            System.exit(1);
        }
    }



    private void execute(Stmt stmt)
    {
        stmt.accept(this);
    }

    private void executeBlock(List<Stmt> statements, Environment environment)
    {
        Environment previous = this.environment;
        try
        {
            this.environment = environment;
            for (Stmt statement : statements)
            {
                execute(statement);
            }
        }
        finally
        {
            this.environment = previous;
        }
    }



    @Override
    public Void visitFunctionStmt(Function stmt)
    {
        // Store the function with its parameter types
        environment.defineFunction(stmt.name().lexeme, stmt);
        return null;
    }

    @Override
    public Void visitReturnStmt(Return stmt)
    {
        Object value = null;
        if (stmt.value() != null)
        {
            value = evaluate(stmt.value());
        }
        throw new ReturnException(value);
    }

    @Override
    public Void visitWaitForEndStmt(WaitForEnd stmt)
    {
        try
        {
            System.in.read(); // Wait for any key press
            System.in.skip(System.in.available()); // Clear any remaining input
            System.gc();
        }
        catch(Exception ex)
        {
            System.err.println("Error reading input: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Void visitWaitForEnterStmt(WaitForEnter stmt)
    {
        // Using anonymous inner class
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    System.in.read();
                    System.gc();
                    System.exit(0);
                }
                catch (Exception e)
                {
                    System.err.println("Error monitoring input: " + e.getMessage());
                }
            }
        }).start();

        return null;
    }

    @Override
    public Object visitCallExpr(Call expr)
    {
        // Handle built-in functions
        if (expr.callee() instanceof Variable)
        {
            String functionName = ((Variable)expr.callee()).name().lexeme;

            // Handle বন্ধ function
            if (functionName.equals("বন্ধ"))
            {
                if (expr.arguments().size() != 1)
                {
                    throw new RuntimeException("'বন্ধ' expects exactly 1 argument (error code)");
                }
                Object errorCode = evaluate(expr.arguments().get(0));
                if (!(errorCode instanceof BigDecimal))
                {
                    throw new RuntimeException("Error code must be an integer");
                }
                int code = ((BigDecimal)errorCode).intValue();
                System.exit(code);
                return null;
            }

            // Handle আকার_বাড়াও function
            if (functionName.equals("আকার_বাড়াও"))
            {
                if (expr.arguments().size() != 2)
                {
                    throw new RuntimeException("'আকার_বাড়াও' expects exactly 2 arguments (array, new size)");
                }
                Token arrayName = null;
                if (expr.arguments().get(0) instanceof Variable)
                {
                    arrayName = ((Variable)expr.arguments().get(0)).name();
                }
                Object array = evaluate(expr.arguments().get(0));
                Object sizeObj = evaluate(expr.arguments().get(1));
                if (!(array instanceof Object[]))
                {
                    throw new RuntimeException("First argument must be an array");
                }
                if (!(sizeObj instanceof BigDecimal))
                {
                    throw new RuntimeException("Second argument must be an integer");
                }
                int additionalSize = ((BigDecimal)sizeObj).intValue();
                if (additionalSize < 0)
                {
                    throw new RuntimeException("Size increase cannot be negative");
                }
                Object[] resizedArray = (Object[])resizeArray(array, additionalSize);
                if (arrayName != null)
                {
                    Environment env = environment;
                    while (env != null)
                    {
                        if (env.arrays.containsKey(arrayName.lexeme))
                        {
                            env.defineArray(arrayName.lexeme, env.getArrayType(arrayName.lexeme), resizedArray);

                            break;
                        }
                        env = env.enclosing;
                    }
                }
                return resizedArray;
            }

            // Handle delete variable
            if (functionName.equals("ভ্যারিয়েবল_মুছো"))
            {
                if (expr.arguments().size() != 1)
                {
                    throw new RuntimeException("'ভ্যারিয়েবল_মুছো' expects exactly 1 argument");
                }
                Expr arg = expr.arguments().get(0);
                if (!(arg instanceof Variable))
                {
                    throw new RuntimeException("'ভ্যারিয়েবল_মুছো' can only delete variables, not expressions");
                }
                Token varName = ((Variable)arg).name();
                environment.deleteVariable(varName);
                return null;
            }

            // Handle go to start
            if (functionName.equals("শুরুতে_যাও"))
            {
                if (!expr.arguments().isEmpty())
                {
                    throw new RuntimeException("'শুরুতে_যাও' takes no arguments");
                }
                throw new GoToStartException();
            }

            if (functionName.equals("কনসোল_মুছো"))
            {
                if (!expr.arguments().isEmpty())
                {
                    throw new RuntimeException("'কনসোল_মুছো' takes no arguments");
                }
                try
                {
                    if (System.getProperty("os.name").toLowerCase().contains("win"))
                    {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    } else
                    {
                        new ProcessBuilder("clear").inheritIO().start().waitFor();
                    }
                } catch (Exception exception)
                {
                    System.err.println("Something went wrong to clear screen");
                }
                return null;
            }

            // Handle binary search
            if (functionName.equals("বাইনারি_সার্চ"))
            {
                if (expr.arguments().size() != 2)
                {
                    throw new RuntimeException("Expected 2 arguments for binary search");
                }
                Object array = evaluate(expr.arguments().get(0));
                Object key = evaluate(expr.arguments().get(1));
                if (!(array instanceof Object[]))
                {
                    throw new RuntimeException("First argument must be an array");
                }
                return ArrayManipulator.binarySearch((Object[])array, key);
            }

            // Handle bubble sort
            if (functionName.equals("বাবল_সর্ট"))
            {
                if (expr.arguments().size() != 1)
                {
                    throw new RuntimeException("Expected 1 argument for bubble sort");
                }
                Object array = evaluate(expr.arguments().get(0));
                if (!(array instanceof Object[]))
                {
                    throw new RuntimeException("Argument must be an array");
                }
                ArrayManipulator.bubbleSort((Object[])array);
                return null;
            }

            // Handle quick sort
            if (functionName.equals("কুইক_সর্ট"))
            {
                if (expr.arguments().size() != 1)
                {
                    throw new RuntimeException("Expected 1 argument for quick sort");
                }
                Object array = evaluate(expr.arguments().get(0));
                if (!(array instanceof Object[]))
                {
                    throw new RuntimeException("Argument must be an array");
                }
                ArrayManipulator.quickSort((Object[])array);
                return null;
            }
        }

        // Handle user-defined functions
        Object callee = evaluate(expr.callee());
        if (!(callee instanceof Function))
        {
            throw new RuntimeException("Can only call functions.");
        }

        Function function = (Function)callee;
        List<Object> arguments = new Vector<>();

        // Check argument count matches parameter count
        if (expr.arguments().size() != function.parameters().size())
        {
            throw new RuntimeException("Expected " + function.parameters().size() +
                                       " arguments but got " + expr.arguments().size() + ".");
        }

        // Evaluate arguments with strict type checking
        for (int i = 0; i < expr.arguments().size(); i++)
        {
            Expr argument = expr.arguments().get(i);
            Object value = evaluate(argument);
            Token param = function.parameters().get(i);

            // Strict type checking
            switch (param.type)
            {
            case INTEGER:
                if (!(value instanceof BigDecimal))
                {
                    throw new RuntimeException("Parameter " + (i+1) + " must be an integer");
                }
                if (((BigDecimal)value).scale() > 0)
                {
                    throw new RuntimeException("Parameter " + (i+1) + " must be an integer (no decimal places)");
                }
                value = ((BigDecimal)value).setScale(0, RoundingMode.DOWN);
                break;

            case FLOAT:
                if (!(value instanceof BigDecimal))
                {
                    throw new RuntimeException("Parameter " + (i+1) + " must be a float");
                }
                break;

            case STRING:
                if (!(value instanceof String))
                {
                    throw new RuntimeException("Parameter " + (i+1) + " must be a string");
                }
                break;

            case BOOLEAN:
                if (!(value instanceof Boolean))
                {
                    throw new RuntimeException("Parameter " + (i+1) + " must be a boolean");
                }
                break;

            case INTEGER_ARRAY:
                if (!(value instanceof Object[]))
                {
                    throw new RuntimeException("Parameter " + (i+1) + " must be an integer array");
                }
                for (Object element : (Object[])value)
                {
                    if (!(element instanceof BigDecimal))
                    {
                        throw new RuntimeException("All elements in integer array must be integers");
                    }
                    if (((BigDecimal)element).scale() > 0)
                    {
                        throw new RuntimeException("All elements in integer array must be integers (no decimal places)");
                    }
                }
                break;

            case FLOAT_ARRAY:
                if (!(value instanceof Object[]))
                {
                    throw new RuntimeException("Parameter " + (i+1) + " must be a float array");
                }
                for (Object element : (Object[])value)
                {
                    if (!(element instanceof BigDecimal))
                    {
                        throw new RuntimeException("All elements in float array must be numbers");
                    }
                }
                break;

            case STRING_ARRAY:
                if (!(value instanceof Object[]))
                {
                    throw new RuntimeException("Parameter " + (i+1) + " must be a string array");
                }
                for (Object element : (Object[])value)
                {
                    if (!(element instanceof String))
                    {
                        throw new RuntimeException("All elements in string array must be strings");
                    }
                }
                break;

            case BOOLEAN_ARRAY:
                if (!(value instanceof Object[]))
                {
                    throw new RuntimeException("Parameter " + (i+1) + " must be a boolean array");
                }
                for (Object element : (Object[])value)
                {
                    if (!(element instanceof Boolean))
                    {
                        throw new RuntimeException("All elements in boolean array must be booleans");
                    }
                }
                break;
            }
            arguments.add(value);
        }

        // Create new environment for function call
        Environment environment = new Environment(this.environment);
        for (int i = 0; i < function.parameters().size(); i++)
        {
            String paramName = function.parameters().get(i).lexeme;
            Object value = arguments.get(i);

            // Handle array parameters specially
            switch (function.parameters().get(i).type)
            {
            case INTEGER_ARRAY:
            case FLOAT_ARRAY:
            case STRING_ARRAY:
            case BOOLEAN_ARRAY:
                environment.defineArray(paramName, function.parameters().get(i).type, (Object[])value);
                break;
            default:
                environment.define(paramName, value);
            }
        }

        try
        {
            executeBlock(function.body(), environment);
        } catch (ReturnException returnValue)
        {
            // Return type checking
            if (function.returnType().type == TokenType.VOID && returnValue.value != null)
            {
                throw new RuntimeException("Void function cannot return a value");
            }
            if (function.returnType().type != TokenType.VOID)
            {
                if (returnValue.value == null)
                {
                    throw new RuntimeException("Function must return a value");
                }
                // Check return type matches declared type
                switch (function.returnType().type)
                {
                case INTEGER:
                    if (!(returnValue.value instanceof BigDecimal))
                    {
                        throw new RuntimeException("Function must return an integer");
                    }
                    return ((BigDecimal)returnValue.value).setScale(0, RoundingMode.DOWN);

                case FLOAT:
                    if (!(returnValue.value instanceof BigDecimal))
                    {
                        throw new RuntimeException("Function must return a float");
                    }
                    break;

                case STRING:
                    if (!(returnValue.value instanceof String))
                    {
                        throw new RuntimeException("Function must return a string");
                    }
                    break;

                case BOOLEAN:
                    if (!(returnValue.value instanceof Boolean))
                    {
                        throw new RuntimeException("Function must return a boolean");
                    }
                    break;

                case INTEGER_ARRAY:
                    if (!(returnValue.value instanceof Object[]))
                    {
                        throw new RuntimeException("Function must return an integer array");
                    }
                    for (Object element : (Object[])returnValue.value)
                    {
                        if (!(element instanceof BigDecimal))
                        {
                            throw new RuntimeException("All elements in returned integer array must be integers");
                        }
                        if (((BigDecimal)element).scale() > 0)
                        {
                            throw new RuntimeException("All elements in returned integer array must be integers (no decimal places)");
                        }
                    }
                    break;

                case FLOAT_ARRAY:
                    if (!(returnValue.value instanceof Object[]))
                    {
                        throw new RuntimeException("Function must return a float array");
                    }
                    for (Object element : (Object[])returnValue.value)
                    {
                        if (!(element instanceof BigDecimal))
                        {
                            throw new RuntimeException("All elements in returned float array must be numbers");
                        }
                    }
                    break;

                case STRING_ARRAY:
                    if (!(returnValue.value instanceof Object[]))
                    {
                        throw new RuntimeException("Function must return a string array");
                    }
                    for (Object element : (Object[])returnValue.value)
                    {
                        if (!(element instanceof String))
                        {
                            throw new RuntimeException("All elements in returned string array must be strings");
                        }
                    }
                    break;

                case BOOLEAN_ARRAY:
                    if (!(returnValue.value instanceof Object[]))
                    {
                        throw new RuntimeException("Function must return a boolean array");
                    }
                    for (Object element : (Object[])returnValue.value)
                    {
                        if (!(element instanceof Boolean))
                        {
                            throw new RuntimeException("All elements in returned boolean array must be booleans");
                        }
                    }
                    break;
                }
            }
            return returnValue.value;
        }

        if (function.returnType().type != TokenType.VOID)
        {
            throw new RuntimeException("Function must return a value");
        }
        return null;
    }

    private Object resizeArray(Object array, int additionalSize)
    {
        Object[] oldArray = (Object[])array;
        int oldSize = oldArray.length;
        int newSize = oldSize + additionalSize;

        // Create new array of the same type
        Object[] newArray = (Object[])java.lang.reflect.Array.newInstance(
                                oldArray.getClass().getComponentType(), newSize);

        // Copy old elements
        System.arraycopy(oldArray, 0, newArray, 0, Math.min(oldSize, newSize));

        // Initialize new elements with default values
        if (newSize > oldSize)
        {
            Object defaultValue = getDefaultValue(oldArray.getClass().getComponentType());
            for (int i = oldSize; i < newSize; i++)
            {
                newArray[i] = defaultValue;
            }
        }

        return newArray;
    }
    private Object getDefaultValue(Class<?> componentType)
    {
        if (componentType == BigDecimal.class)
        {
            return BigDecimal.ZERO;
        } else if (componentType == String.class)
        {
            return "";
        } else if (componentType == Boolean.class)
        {
            return false;
        }
        return null;
    }

    private static class ReturnException extends RuntimeException
    {
        final Object value;
        ReturnException(Object value)
        {
            this.value = value;
        }
    }


    @Override
    public Void visitBlockStmt(Block stmt)
    {
        Environment previous = this.environment;
        try
        {
            this.environment = new Environment(environment);
            for (Stmt statement : stmt.statements())
            {
                try
                {
                    execute(statement);
                } catch (ContinueException e)
                {
                    throw e;
                } catch (BreakException e)
                {
                    throw e;
                }
            }
        }
        finally
        {
            this.environment = previous;
        }
        return null;
    }

    @Override
    public Void visitBreakStmt(Break stmt)
    {
        throw new BreakException();
    }

    @Override
    public Void visitContinueStmt(Continue stmt)
    {
        throw new ContinueException();
    }

    @Override
    public Void visitExpressionStmt(Expression stmt)
    {
        evaluate(stmt.expression());
        return null;
    }

    @Override
    public Void visitIfStmt(If stmt)
    {
        Object conditionValue = evaluate(stmt.condition());
        if (isTruthy(conditionValue))
        {
            execute(stmt.thenBranch());
            return null;
        }

        for (ElseIf elseIf : stmt.elseIfBranches())
        {
            Object elseIfConditionValue = evaluate(elseIf.condition());
            if (isTruthy(elseIfConditionValue))
            {
                execute(elseIf.statement());
                return null;
            }
        }

        if (stmt.elseBranch() != null)
        {
            execute(stmt.elseBranch());
        }

        return null;
    }
    @Override
    public Void visitPrintlnStmt(Println stmt)
    {
        Object value = evaluate(stmt.expression());
        System.out.print(stringify(value) + "\n");
        return null;
    }

    @Override
    public Void visitSleepStmt(Sleep stmt)
    {
        Object value = evaluate(stmt.expression());
        if(value instanceof BigDecimal)
        {
            BigDecimal a = (BigDecimal)value;
            try
            {
                if(a.longValue() < 0)
                {
                    throw new RuntimeException("Negative number isnot allowed here.");
                }
                Thread.sleep(a.longValue());
            }
            catch (Exception e)
            {
                System.err.println("Something went wrong in function sleep(): " + e.getMessage());
            }

        }
        else
        {
            System.err.println("Argument needs an integer.");
        }

        return null;
    }

    @Override
    public Void visitPrintStmt(Print stmt)
    {
        Object value = evaluate(stmt.expression());
        System.out.print(stringify(value));
        return null;
    }

    @Override
    public Void visitWhileStmt(While stmt)
    {
        while (isTruthy(evaluate(stmt.condition())))
        {
            try
            {
                execute(stmt.body());
            } catch (BreakException e)
            {
                break;
            } catch (ContinueException e)
            {
                if (stmt.increment() != null)
                {
                    evaluate(stmt.increment());
                }
                continue;
            }

            if (stmt.increment() != null)
            {
                evaluate(stmt.increment());
            }
        }
        return null;
    }

    @Override
    public Void visitVarStmt(Var stmt)
    {
        Object value = null;
        if (stmt.initializer() != null)
        {
            value = evaluate(stmt.initializer());

            // Convert to appropriate type based on variable declaration
            if (value instanceof BigDecimal)
            {
                if (stmt.name().type == TokenType.INTEGER)
                {
                    // For পূর্ণসংখ্যা, remove decimal part
                    value = ((BigDecimal)value).setScale(0, RoundingMode.DOWN);
                }
            } else if (value instanceof String || value instanceof Boolean)
            {
                // Keep as is for strings and booleans
            } else
            {
                // Convert other numbers to BigDecimal
                if (value instanceof Integer)
                {
                    value = new BigDecimal((Integer)value);
                } else if (value instanceof Double)
                {
                    value = BigDecimal.valueOf((Double)value);
                }
            }
        }

        // Set default values if no initializer
        if (value == null)
        {
            if (stmt.name().type == TokenType.INTEGER || stmt.name().type == TokenType.FLOAT)
            {
                value = BigDecimal.ZERO;
            } else if (stmt.name().type == TokenType.STRING)
            {
                value = "";
            } else if (stmt.name().type == TokenType.BOOLEAN)
            {
                value = false;
            }
        }

        environment.define(stmt.name().lexeme, value);
        return null;
    }

    @Override
    public Void visitArrayStmt(ArrayStmt stmt)
    {


        Object[] array = null;
        int size = 0;

        // Determine array size
        if (stmt.size() != null)
        {
            Object sizeValue = evaluate(stmt.size());
            if (!(sizeValue instanceof BigDecimal))
            {
                throw new RuntimeException("Array size must be an integer");
            }
            size = ((BigDecimal)sizeValue).intValue();
        } else if (!stmt.initialValues().isEmpty())
        {
            size = stmt.initialValues().size();
        } else
        {
            throw new RuntimeException("Array size must be specified or initial values provided");
        }

        // Initialize with default values based on type
        switch (stmt.type())
        {
        case INTEGER_ARRAY:
            array = new BigDecimal[size];
            for (int i = 0; i < size; i++)
            {
                array[i] = BigDecimal.ZERO;
            }
            break;
        case FLOAT_ARRAY:
            array = new BigDecimal[size];
            for (int i = 0; i < size; i++)
            {
                array[i] = BigDecimal.ZERO;
            }
            break;
        case STRING_ARRAY:
            array = new String[size];
            for (int i = 0; i < size; i++)
            {
                array[i] = "";
            }
            break;
        case BOOLEAN_ARRAY:
            array = new Boolean[size];
            for (int i = 0; i < size; i++)
            {
                array[i] = false;
            }
            break;
        default:
            throw new RuntimeException("Unknown array type");
        }

        // Apply initial values with strict type checking
        for (int i = 0; i < stmt.initialValues().size(); i++)
        {
            if (i >= array.length)
            {
                throw new RuntimeException("Too many initial values for array");
            }

            Object value = evaluate(stmt.initialValues().get(i));


            // Strict type checking and conversion
            switch (stmt.type())
            {
            case INTEGER_ARRAY:
                if (value instanceof BigDecimal)
                {
                    BigDecimal bd = (BigDecimal)value;
                    array[i] = bd.setScale(0, RoundingMode.DOWN);

                } else if (value instanceof Integer || value instanceof Double)
                {
                    BigDecimal bd = new BigDecimal(value.toString());
                    array[i] = bd.setScale(0, RoundingMode.DOWN);

                } else
                {
                    throw new RuntimeException("Integer array can only contain numbers");
                }
                break;
            case FLOAT_ARRAY:
                if (value instanceof BigDecimal)
                {
                    array[i] = (BigDecimal)value;
                } else if (value instanceof Number)
                {
                    array[i] = new BigDecimal(value.toString());
                } else
                {
                    throw new RuntimeException("Float array can only contain numbers");
                }

                break;
            case STRING_ARRAY:
                array[i] = stringify(value);

                break;
            case BOOLEAN_ARRAY:
                if (value instanceof Boolean)
                {
                    array[i] = value;
                } else
                {
                    throw new RuntimeException("Boolean array can only contain true/false values");
                }

                break;
            }
        }

        environment.defineArray(stmt.name().lexeme, stmt.type(), array);


        return null;
    }
    @Override
    public Object visitArraySizeExpr(ArraySize expr)
    {
        Object array = evaluate(expr.array());

        if (array instanceof Object[])
        {
            return ((Object[])array).length;
        }

        throw new RuntimeException("Operand must be an array");
    }
    @Override
    public Void visitSortStmt(SortStmt stmt)
    {
        Object array = evaluate(stmt.array());

        if (!(array instanceof Object[]))
        {
            throw new RuntimeException("Operand must be an array for sorting");
        }

        Object[] arr = (Object[])array;

        switch (stmt.sortType())
        {
        case "bubble":
            ArrayManipulator.bubbleSort(arr);
            break;
        case "quick":
            ArrayManipulator.quickSort(arr);
            break;
        default:
            throw new RuntimeException("Unknown sort type: " + stmt.sortType());
        }

        return null;
    }

    @Override
    public Void visitSearchStmt(SearchStmt stmt)
    {
        Object array = evaluate(stmt.array());
        Object key = evaluate(stmt.key());

        if (!(array instanceof Object[]))
        {
            throw new RuntimeException("First operand must be an array for binary search");
        }

        int result = ArrayManipulator.binarySearch((Object[])array, key);
        System.out.println(result); // Print the 1-based index or -1 if not found

        return null;
    }

    @Override
    public Void visitInputStmt(Input stmt)
    {
        Scanner scanner = new Scanner(System.in);
        Object value = null;
        boolean validInput = false;

        while (!validInput)
        {
            try
            {
                String input = scanner.nextLine().trim();

                if (input.matches(".*[+\\-*/].*"))
                {
                    Lexer lexer = new Lexer(input);
                    List<Token> tokens = lexer.scanTokens();
                    Parser parser = new Parser(tokens);
                    Expr expr = parser.expression();
                    value = evaluate(expr);
                } else
                {
                    switch (stmt.expectedType())
                    {
                    case INTEGER:
                        value = new BigDecimal(input).setScale(0, RoundingMode.DOWN);
                        break;
                    case FLOAT:
                        value = new BigDecimal(input);
                        break;
                    case STRING:
                        value = input;
                        break;
                    case BOOLEAN:
                        if (input.equalsIgnoreCase("সত্য") || input.equalsIgnoreCase("true"))
                        {
                            value = true;
                        } else if (input.equalsIgnoreCase("মিথ্যা") || input.equalsIgnoreCase("false"))
                        {
                            value = false;
                        } else
                        {
                            throw new RuntimeException("Invalid boolean value");
                        }
                        break;
                    }
                }

                // Ensure value is BigDecimal for numbers
                if (stmt.expectedType() == TokenType.INTEGER || stmt.expectedType() == TokenType.FLOAT)
                {
                    if (!(value instanceof BigDecimal))
                    {
                        if (value instanceof Integer)
                        {
                            value = new BigDecimal((Integer)value);
                        } else if (value instanceof Double)
                        {
                            value = BigDecimal.valueOf((Double)value);
                        }
                    }
                    // For পূর্ণসংখ্যা, remove decimal part
                    if (stmt.expectedType() == TokenType.INTEGER)
                    {
                        value = ((BigDecimal)value).setScale(0, RoundingMode.DOWN);
                    }
                }

                validInput = true;
            } catch (Exception e)
            {
                System.out.println("Invalid input for type " + stmt.expectedType().bangla + ". Please try again:");
            }
        }

        environment.assign(stmt.variable(), value);
        return null;
    }

    @Override
    public Object visitBinaryExpr(Binary expr)
    {
        Object left = evaluate(expr.left());
        Object right = evaluate(expr.right());
        if (left instanceof Integer) left = new BigDecimal((Integer)left);
        if (right instanceof Integer) right = new BigDecimal((Integer)right);
        if (left instanceof Double) left = BigDecimal.valueOf((Double)left);
        if (right instanceof Double) right = BigDecimal.valueOf((Double)right);


        switch (expr.operator().type)
        {
        case PLUS:
            if (left instanceof String || right instanceof String)
            {
                return stringify(left) + stringify(right);
            }
            if (left instanceof BigDecimal && right instanceof BigDecimal)
            {
                return ((BigDecimal)left).add((BigDecimal)right);
            }
            throw new RuntimeException("Operands must be numbers");

        case MINUS:
            if (left instanceof BigDecimal && right instanceof BigDecimal)
            {
                return ((BigDecimal)left).subtract((BigDecimal)right);
            }
            throw new RuntimeException("Operands must be numbers");

        case MULTIPLY:
            if (left instanceof BigDecimal && right instanceof BigDecimal)
            {
                return ((BigDecimal)left).multiply((BigDecimal)right);
            }
            throw new RuntimeException("Operands must be numbers");

        case DIVIDE:
            if (left instanceof BigDecimal && right instanceof BigDecimal)
            {
                try
                {
                    return ((BigDecimal)left).divide((BigDecimal)right, MathContext.DECIMAL128);
                } catch (ArithmeticException e)
                {
                    // For non-terminating decimal expansion
                    return ((BigDecimal)left).divide((BigDecimal)right, 20, RoundingMode.HALF_UP);
                }
            }
            throw new RuntimeException("Operands must be numbers");

        case MODULO:
            if (left instanceof BigDecimal && right instanceof BigDecimal)
            {
                return ((BigDecimal)left).remainder((BigDecimal)right);
            }
            throw new RuntimeException("Operands must be numbers");

        case EQUAL_EQUAL:
            return isEqual(left, right);
        case BANG_EQUAL:
            return !isEqual(left, right);

        case LESS:
            if (left instanceof BigDecimal && right instanceof BigDecimal)
            {
                return ((BigDecimal)left).compareTo((BigDecimal)right) < 0;
            }
            throw new RuntimeException("Operands must be numbers");

        case LESS_EQUAL:
            if (left instanceof BigDecimal && right instanceof BigDecimal)
            {
                return ((BigDecimal)left).compareTo((BigDecimal)right) <= 0;
            }
            throw new RuntimeException("Operands must be numbers");

        case GREATER:
            if (left instanceof BigDecimal && right instanceof BigDecimal)
            {
                return ((BigDecimal)left).compareTo((BigDecimal)right) > 0;
            }
            throw new RuntimeException("Operands must be numbers");

        case GREATER_EQUAL:
            if (left instanceof BigDecimal && right instanceof BigDecimal)
            {
                return ((BigDecimal)left).compareTo((BigDecimal)right) >= 0;
            }
            throw new RuntimeException("Operands must be numbers");
        case AND:
            return isTruthy(left) && isTruthy(right);
        case OR:
            return isTruthy(left) || isTruthy(right);
        case BITWISE_AND:
            return performBitwiseOperation(left, right, (a, b) -> a & b);
        case BITWISE_OR:
            return performBitwiseOperation(left, right, (a, b) -> a | b);
        case BITWISE_XOR:
            return performBitwiseOperation(left, right, (a, b) -> a ^ b);
        case LEFT_SHIFT:
            return performBitwiseOperation(left, right, (a, b) -> a << b);
        case RIGHT_SHIFT:
            return performBitwiseOperation(left, right, (a, b) -> a >> b);
        case UNSIGNED_RIGHT_SHIFT:
            return performBitwiseOperation(left, right, (a, b) -> a >>> b);
        case ASSIGN:
            if (expr.left() instanceof Variable)
            {
                Token name = ((Variable)expr.left()).name();
                // Convert to integer if variable is পূর্ণসংখ্যা
                if (name.type == TokenType.INTEGER && right instanceof BigDecimal)
                {
                    right = ((BigDecimal)right).setScale(0, RoundingMode.DOWN);
                }
                environment.assign(name, right);
                return right;
            }
            throw new RuntimeException("Invalid assignment target.");
        }
        throw new RuntimeException("Unknown operator");
    }

    @FunctionalInterface
    private interface BitwiseOperation
    {
        int apply(int a, int b);
    }

    // Helper method to perform bitwise operations
    private Object performBitwiseOperation(Object left, Object right, BitwiseOperation operation)
    {
        if (left instanceof BigDecimal && right instanceof BigDecimal)
        {
            int leftInt = ((BigDecimal)left).intValue();
            int rightInt = ((BigDecimal)right).intValue();
            return new BigDecimal(operation.apply(leftInt, rightInt));
        }
        throw new RuntimeException("Operands must be integers for bitwise operations");
    }
    @Override
    public Object visitGroupingExpr(Grouping expr)
    {
        return evaluate(expr.expression());
    }

    @Override
    public Object visitLiteralExpr(Literal expr)
    {
        if (expr.value() instanceof BigDecimal)
        {
            return expr.value();
        }
        // Handle other literal types (strings, booleans, null)
        return expr.value();
    }



    @Override
    public Object visitUnaryExpr(Unary expr)
    {
        Object right = evaluate(expr.right());

        switch (expr.operator().type)
        {
        case MINUS:
            if (right instanceof BigDecimal)
            {
                return ((BigDecimal)right).negate();
            }
            throw new RuntimeException("Operand must be a number");

        case BANG:
            return !isTruthy(right);
        case BITWISE_NOT:
            if (right instanceof BigDecimal)
            {
                int value = ((BigDecimal)right).intValue();
                return new BigDecimal(~value);
            }
            throw new RuntimeException("Operand must be an integer for bitwise NOT");

        case INCREMENT:
            if (right instanceof BigDecimal)
            {
                if (expr.right() instanceof Variable)
                {
                    Token name = ((Variable)expr.right()).name();
                    BigDecimal newValue = ((BigDecimal)right).add(BigDecimal.ONE);
                    // For পূর্ণসংখ্যা, keep it as integer
                    if (name.type == TokenType.INTEGER)
                    {
                        newValue = newValue.setScale(0, RoundingMode.DOWN);
                    }
                    environment.assign(name, newValue);
                    if (expr.operator().lexeme.equals(expr.right().toString() + "++"))
                    {
                        return right;
                    }
                    return newValue;
                } else if (expr.right() instanceof ArrayAccess)
                {
                    // Handle array element increment
                    ArrayAccess access = (ArrayAccess)expr.right();
                    Object array = evaluate(access.array());
                    Object indexObj = evaluate(access.index());

                    if (!(indexObj instanceof BigDecimal))
                    {
                        throw new RuntimeException("Array index must be an integer");
                    }

                    int index = ((BigDecimal)indexObj).intValue();

                    if (array instanceof Object[])
                    {
                        Object[] arr = (Object[])array;
                        if (index < 1 || index > arr.length)
                        {
                            throw new RuntimeException("Array index out of bounds");
                        }

                        if (!(arr[index - 1] instanceof BigDecimal))
                        {
                            throw new RuntimeException("Can only increment numeric array elements");
                        }

                        BigDecimal currentValue = (BigDecimal)arr[index - 1];
                        BigDecimal newValue = currentValue.add(BigDecimal.ONE);

                        // Check if the array is declared as integer array
                        if (access.array() instanceof Variable)
                        {
                            Token arrayName = ((Variable)access.array()).name();
                            if (arrayName.type == TokenType.INTEGER_ARRAY)
                            {
                                newValue = newValue.setScale(0, RoundingMode.DOWN);
                            }
                        }

                        arr[index - 1] = newValue;

                        if (expr.operator().lexeme.endsWith("++"))
                        {
                            return currentValue; // post-increment returns original value
                        }
                        return newValue; // pre-increment returns new value
                    }
                    throw new RuntimeException("Variable is not an array");
                }
                throw new RuntimeException("Can only increment variables or array elements");
            }
            throw new RuntimeException("Operand must be a number");

        case DECREMENT:
            if (right instanceof BigDecimal)
            {
                if (expr.right() instanceof Variable)
                {
                    Token name = ((Variable)expr.right()).name();
                    BigDecimal newValue = ((BigDecimal)right).subtract(BigDecimal.ONE);
                    // For পূর্ণসংখ্যা, keep it as integer
                    if (name.type == TokenType.INTEGER)
                    {
                        newValue = newValue.setScale(0, RoundingMode.DOWN);
                    }
                    environment.assign(name, newValue);
                    if (expr.operator().lexeme.equals(expr.right().toString() + "--"))
                    {
                        return right;
                    }
                    return newValue;
                } else if (expr.right() instanceof ArrayAccess)
                {
                    // Handle array element decrement
                    ArrayAccess access = (ArrayAccess)expr.right();
                    Object array = evaluate(access.array());
                    Object indexObj = evaluate(access.index());

                    if (!(indexObj instanceof BigDecimal))
                    {
                        throw new RuntimeException("Array index must be an integer");
                    }

                    int index = ((BigDecimal)indexObj).intValue();

                    if (array instanceof Object[])
                    {
                        Object[] arr = (Object[])array;
                        if (index < 1 || index > arr.length)
                        {
                            throw new RuntimeException("Array index out of bounds");
                        }

                        if (!(arr[index - 1] instanceof BigDecimal))
                        {
                            throw new RuntimeException("Can only decrement numeric array elements");
                        }

                        BigDecimal currentValue = (BigDecimal)arr[index - 1];
                        BigDecimal newValue = currentValue.subtract(BigDecimal.ONE);

                        // Check if the array is declared as integer array
                        if (access.array() instanceof Variable)
                        {
                            Token arrayName = ((Variable)access.array()).name();
                            if (arrayName.type == TokenType.INTEGER_ARRAY)
                            {
                                newValue = newValue.setScale(0, RoundingMode.DOWN);
                            }
                        }

                        arr[index - 1] = newValue;

                        if (expr.operator().lexeme.endsWith("--"))
                        {
                            return currentValue; // post-decrement returns original value
                        }
                        return newValue; // pre-decrement returns new value
                    }
                    throw new RuntimeException("Variable is not an array");
                }
                throw new RuntimeException("Can only decrement variables or array elements");
            }
            throw new RuntimeException("Operand must be a number");

        default:
            throw new RuntimeException("Unknown operator");
        }
    }

    @Override
    public Object visitVariableExpr(Variable expr)
    {
        // Firstly, I try to get as a regular variable
        try
        {
            Object value = environment.get(expr.name());
            // If it's a string, return it directly
            if (value instanceof String)
            {
                return value;
            }
            // For arrays, return the array object
            if (value instanceof Object[])
            {
                return value;
            }
            // For other types, return as is
            return value;
        }
        catch (RuntimeException e)
        {
            // When not found as variable, we should try as function.
            try
            {
                return environment.getFunction(expr.name());
            }
            catch (RuntimeException e2)
            {
                // If neither exists, throw the original variable not found error
                throw e;
            }
        }
    }
    @Override
    public Object visitArrayExpr(Array expr)
    {
        throw new RuntimeException("Array expressions should be handled by ArrayStmt");
    }

    @Override
    public Object visitArrayAccessExpr(ArrayAccess expr)
    {
        Object array = evaluate(expr.array());
        Object indexObj = evaluate(expr.index());

        if (!(indexObj instanceof BigDecimal))
        {
            throw new RuntimeException("Array index must be an integer");
        }

        int index = ((BigDecimal)indexObj).intValue();

        if (array instanceof Object[])
        {
            Object[] arr = (Object[])array;
            if (index < 1 || index > arr.length)
            {
                throw new RuntimeException("Array index out of bounds");
            }
            return arr[index - 1]; // Convert from 1-based to 0-based
        }
        else if (array instanceof String)
        {
            String str = (String)array;
            if (index < 1 || index > str.length())
            {
                throw new RuntimeException("String index out of bounds");
            }
            return String.valueOf(str.charAt(index - 1)); // Convert from 1-based to 0-based
        }

        throw new RuntimeException("Variable is not an array or string");
    }


    @Override
    public Object visitArrayAssignmentExpr(ArrayAssignment expr)
    {
        // Evaluate the array, index, and value
        Object array = evaluate(expr.array());
        Object indexObj = evaluate(expr.index());
        Object value = evaluate(expr.value());

        // Verify index is a number
        if (!(indexObj instanceof BigDecimal))
        {
            throw new RuntimeException("Array index must be an integer");
        }

        // Convert index to 1-based integer
        int index = ((BigDecimal)indexObj).intValue();

        if (!(array instanceof Object[]))
        {
            throw new RuntimeException("Variable is not an array");
        }

        Object[] arr = (Object[])array;

        // Check bounds
        if (index < 1 || index > arr.length)
        {
            throw new RuntimeException("Array index out of bounds (valid: 1-" + arr.length + ")");
        }

        // Get array type from environment
        TokenType arrayType = null;
        if (expr.array() instanceof Variable)
        {
            Token arrayName = ((Variable)expr.array()).name();
            arrayType = environment.getArrayType(arrayName.lexeme);
        }

        // Convert value based on array type
        Object convertedValue = value;

        if (arr instanceof BigDecimal[])
        {
            // Handle numeric arrays (both integer and float)
            if (value instanceof BigDecimal)
            {
                convertedValue = value;
            } else if (value instanceof Integer)
            {
                convertedValue = new BigDecimal((Integer)value);
            } else if (value instanceof Double)
            {
                convertedValue = BigDecimal.valueOf((Double)value);
            } else
            {
                throw new RuntimeException("Numeric array can only contain numbers");
            }

            // Special handling for integer arrays
            if (arrayType == TokenType.INTEGER_ARRAY)
            {
                // Convert to integer by truncating decimals
                convertedValue = ((BigDecimal)convertedValue).setScale(0, RoundingMode.DOWN);
            }
        }
        else if (arr instanceof String[])
        {
            convertedValue = stringify(value);
        }
        else if (arr instanceof Boolean[])
        {
            if (!(value instanceof Boolean))
            {
                throw new RuntimeException("Boolean array can only contain true/false values");
            }
        }
        else
        {
            throw new RuntimeException("Unknown array type");
        }

        // Store the converted value
        arr[index - 1] = convertedValue;

        return convertedValue;
    }
    
    private Object evaluate(Expr expr)
    {
        return expr.accept(this);
    }

    private String stringify(Object object)
    {
        if (object == null) return "null";
        if (object instanceof BigDecimal)
        {
            BigDecimal bd = (BigDecimal)object;
            // Remove .0 for integer values
            if (bd.scale() <= 0 || bd.stripTrailingZeros().scale() <= 0)
            {
                return bd.toBigInteger().toString();
            }
            return bd.stripTrailingZeros().toPlainString();
        }
        if (object instanceof Object[])
        {
            return Arrays.toString((Object[])object);
        }
        return object.toString();
    }

    private boolean isEqual(Object a, Object b)
    {
        if (a == null && b == null) return true;
        if (a == null) return false;
        return a.equals(b);
    }

    private boolean isTruthy(Object object)
    {
        if (object == null) return false;
        if (object instanceof Boolean) return (Boolean)object;
        if (object instanceof Number) return ((Number)object).doubleValue() != 0;
        return true;
    }
}

class ArrayManipulator
{
    public static Object[] resizeArray(Object[] array, int newSize)
    {
        Object[] newArray = (Object[])java.lang.reflect.Array.newInstance(
                                array.getClass().getComponentType(), newSize);
        System.arraycopy(array, 0, newArray, 0, Math.min(array.length, newSize));

        // Initialize new elements
        if (newSize > array.length)
        {
            Object defaultValue = getDefaultValue(array.getClass().getComponentType());
            for (int i = array.length; i < newSize; i++)
            {
                newArray[i] = defaultValue;
            }
        }

        return newArray;
    }

    private static Object getDefaultValue(Class<?> componentType)
    {
        if (componentType == BigDecimal.class)
        {
            return BigDecimal.ZERO;
        } else if (componentType == String.class)
        {
            return "";
        } else if (componentType == Boolean.class)
        {
            return false;
        }
        return null;
    }

    // Bubble sort for comparable arrays
    public static void bubbleSort(Object[] array)
    {

        while(!isComparableArray(array))
        {
            throw new RuntimeException("Array elements must be comparable for sorting");
        }

        int n = array.length;
        for (int i = 0; i < n-1; i++)
        {
            for (int j = 0; j < n-i-1; j++)
            {
                if (compare(array[j], array[j+1]) > 0)
                {
                    // Swap elements
                    Object temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    // Quick sort for comparable arrays
    public static void quickSort(Object [] array)
    {
        if (!isComparableArray(array))
        {
            throw new RuntimeException("Array elements must be comparable for sorting");
        }
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(Object [] array, int low, int high)
    {
        if (low < high)
        {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(Object[] array, int low, int high)
    {
        Object pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++)
        {
            if (compare(array[j], pivot) <= 0)
            {
                i++;
                Object temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        Object temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // Binary search in sorted array
    public static int binarySearch(Object[] array, Object key)
    {
        if (!isComparableArray(array))
        {
            throw new RuntimeException("Array elements must be comparable for binary search");
        }

        int low = 0;
        int high = array.length - 1;

        while (low <= high)
        {
            int mid = low + (high - low) / 2;
            int cmp = compare(array[mid], key);

            if (cmp == 0)
            {
                return mid + 1; // Return 1-based index
            }
            else if (cmp < 0)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }

        return -1; // Not found
    }

    // Helper method to compare two objects
    private static int compare(Object a, Object b)
    {
        if (a instanceof BigDecimal && b instanceof BigDecimal)
        {
            return ((BigDecimal)a).compareTo((BigDecimal)b);
        }
        else if (a instanceof String && b instanceof String)
        {
            return ((String)a).compareTo((String)b);
        }
        else if (a instanceof Boolean && b instanceof Boolean)
        {
            return ((Boolean)a).compareTo((Boolean)b);
        }
        throw new RuntimeException("Cannot compare elements of different types");
    }


    // Check if array elements are comparable
    private static boolean isComparableArray(Object[] array)
    {
        if (array.length == 0) return true;

        Object first = array[0];
        if (first == null) return false; // or true, depending on needs.

        for (int i = 1; i < array.length; i++)
        {
            if (array[i] == null || !first.getClass().equals(array[i].getClass()))
            {
                return false;
            }
        }
        return true;
    }
}

public class Main
{
    public static void main(String [] args)
    {
        // Check if filename is provided
        if (args.length == 0)
        {
            System.err.println("Usage: java Main <filename.kls>");
            System.err.println("Example: java Main source.kls");
            System.exit(1);
        }

        String filename = new String(args[0]);

        // Validate file extension
        if (!filename.toLowerCase().endsWith(".kls"))
        {
            System.err.println("Error: File must have .kls extension");
            System.err.println("Provided file: " + filename);
            System.exit(1);
        }

        try
        {
            // Read source code from the provided file path
            Path path = Paths.get(filename);

            if (!Files.exists(path))
            {
                System.err.println("Error: File not found - " + filename);
                System.gc();
                System.exit(1);
            }

            String source = new String(Files.readString(path));

            // Process library imports before the main source
            List<String> libraryImports = extractLibraryImports(source);
            Interpreter interpreter = new Interpreter();

            // Process each library file
            for (String libPath : libraryImports)
            {
                processLibraryFile(libPath, interpreter);
            }

            // Remove library import lines from source
            String cleanedSource = new String(removeLibraryImports(source));

            // Process main source file
            String translatedSource = new String(LanguageTranslator.translateToBangla(cleanedSource));

            // Lexical analysis
            Lexer lexer = new Lexer(translatedSource);
            List<Token> tokens = lexer.scanTokens();

            // Parsing
            Parser parser = new Parser(tokens);
            List<Stmt> statements = parser.parse();

            // Interpretation
            interpreter.interpret(statements);

            System.gc();
        } catch (IOException e)
        {
            System.err.println("Error reading file '" + filename + "': " + e.getMessage());
            System.exit(1);
        } catch (RuntimeException e)
        {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

// Helper method to extract library imports
    private static List<String> extractLibraryImports(String source)
    {
        List<String> imports = new Vector<>();
        String[] lines = source.split("\\r?\\n");

        // Pattern to match: লাইব্রেরী "path/to/library.klm";
        Pattern importPattern = Pattern.compile("^\\s*লাইব্রেরী\\s*\"([^\"]+\\.klm)\"\\s*;\\s*$");

        for (String line : lines)
        {
            Matcher matcher = importPattern.matcher(line);
            if (matcher.matches())
            {
                imports.add(matcher.group(1));
            } else if (!line.trim().isEmpty() && !line.trim().startsWith("//"))
            {
                // Stop at first non-import, non-comment, non-empty line
                break;
            }
        }
        return imports;
    }

// Helper method to process a library file
    private static Path getInterpreterDirectory()
    {
        try
        {
            // This gets the path to the Main.class file
            String classPath = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            Path path = Paths.get(classPath);

            // If running from a JAR, get the parent directory
            if (classPath.endsWith(".jar"))
            {
                return path.getParent();
            } else
            {
                // If running from class files, get the directory containing the class files
                return path;
            }
        } catch (Exception e)
        {
            // Fallback to current directory if there's any error
            return Paths.get("").toAbsolutePath();
        }
    }

    // processLibraryFile method
    private static void processLibraryFile(String libPath, Interpreter interpreter) throws IOException
    {
        Path libFilePath;

        // If the path is absolute or contains directory separators, use as-is
        if (libPath.startsWith("/") || libPath.startsWith("\\") || libPath.contains("/") || libPath.contains("\\"))
        {
            libFilePath = Paths.get(libPath);
        } else
        {
            // For simple filenames, look in the interpreter directory first
            Path interpreterDir = getInterpreterDirectory();
            libFilePath = interpreterDir.resolve(libPath);

            // If not found in interpreter directory, try current working directory
            if (!Files.exists(libFilePath))
            {
                libFilePath = Paths.get(libPath);
            }
        }

        if (!Files.exists(libFilePath))
        {
            throw new RuntimeException("Library file not found: " + libFilePath);
        }

        if (!libPath.toLowerCase().endsWith(".klm"))
        {
            throw new RuntimeException("Library file must have .klm extension: " + libPath);
        }

        String libSource = Files.readString(libFilePath);
        String translatedSource = LanguageTranslator.translateToBangla(libSource);

        // Process library file
        Lexer lexer = new Lexer(translatedSource);
        List<Token> tokens = lexer.scanTokens();

        Parser parser = new Parser(tokens);
        List<Stmt> statements = parser.parse();

        // Interpret the library
        interpreter.interpret(statements);
    }

// Helper method to remove library imports from source
    private static String removeLibraryImports(String source)
    {
        String[] lines = source.split("\\r?\\n");
        StringBuilder cleaned = new StringBuilder();
        boolean importsEnded = false;

        Pattern importPattern = Pattern.compile("^\\s*লাইব্রেরী\\s*\".+\\.klm\"\\s*;\\s*$");

        for (String line : lines)
        {
            if (!importsEnded && importPattern.matcher(line).matches())
            {
                continue; // Skip import lines
            }

            if (!line.trim().isEmpty() && !line.trim().startsWith("//"))
            {
                importsEnded = true;
            }

            if (importsEnded || !line.trim().isEmpty())
            {
                cleaned.append(line).append("\n");
            }
        }

        return new String(cleaned.toString());
    }
}
