import java.io.*;
import java.util.*;
import java.net.*;
import java.time.*;
import java.math.*;
import java.nio.file.*;
import java.security.*;
import java.util.regex.*;
import java.nio.charset.*;
import java.time.format.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import jdk.jshell.*;

class LanguageTranslator
{
    public static final Map<String, String> englishToBangla = new LinkedHashMap<>();
    public static final Map<String, String> russianToBangla = new LinkedHashMap<>();
    public static final Map<String, String> hindiToBangla = new LinkedHashMap<>();
    public static final Map<String, String> banglaToBangla = new LinkedHashMap<>();
    static
    {
        // BN -> BN
        banglaToBangla.put("ক্লাস", "ক্লাস");
        banglaToBangla.put("ক্লাসের", "ক্লাসের");
        banglaToBangla.put("বের", "বের");
        banglaToBangla.put("সব", "সব");
        banglaToBangla.put("অবজেক্ট", "অবজেক্ট");
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
        banglaToBangla.put("অন্যলুপ", "অন্যলুপ");
        banglaToBangla.put("$ফাংশন", "$ফাংশন");
        banglaToBangla.put("ফাংশন", "ফাংশন");
        banglaToBangla.put("খালি", "খালি");
        banglaToBangla.put("ফাইল", "ফাইল");
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
        banglaToBangla.put(";", ";"); //U+037E to U+003B
        banglaToBangla.put("⮕", "→"); //User can use "⮕" for array initialize also.
        // Replace the non-printable Unicode characters with empty string
        banglaToBangla.put(" ", ""); // U+2000 - EN QUAD
        banglaToBangla.put(" ", ""); // U+2001 - EM QUAD
        banglaToBangla.put(" ", ""); // U+2002 - EN SPACE
        banglaToBangla.put(" ", ""); // U+2003 - EM SPACE
        banglaToBangla.put(" ", ""); // U+2004 - THREE-PER-EM SPACE
        banglaToBangla.put(" ", ""); // U+2005 - FOUR-PER-EM SPACE
        banglaToBangla.put(" ", ""); // U+2006 - SIX-PER-EM SPACE
        banglaToBangla.put(" ", ""); // U+2007 - FIGURE SPACE
        banglaToBangla.put(" ", ""); // U+2008 - PUNCTUATION SPACE
        banglaToBangla.put(" ", ""); // U+2009 - THIN SPACE
        banglaToBangla.put(" ", ""); // U+200A - HAIR SPACE
        banglaToBangla.put("​", ""); // U+200B - ZERO WIDTH SPACE
        banglaToBangla.put("‌", ""); // U+200C - ZERO WIDTH NON-JOINER
        banglaToBangla.put("‍", ""); // U+200D - ZERO WIDTH JOINER
        banglaToBangla.put("‎", ""); // U+200E - LEFT-TO-RIGHT MARK
        banglaToBangla.put("‏", ""); // U+200F - RIGHT-TO-LEFT MARK
        banglaToBangla.put("‪", ""); // U+202A - LEFT-TO-RIGHT EMBEDDING
        banglaToBangla.put("‫", ""); //U + 202B
        banglaToBangla.put("‬", ""); // U+202C - POP DIRECTIONAL FORMATTING
        banglaToBangla.put("‭", ""); // U+202D - LEFT-TO-RIGHT OVERRIDE
        banglaToBangla.put("‮", ""); //U+202E
        banglaToBangla.put(" ", ""); // U+202F - NARROW NO-BREAK SPACE
        banglaToBangla.put(" ", ""); // U+205F - MEDIUM MATHEMATICAL SPACE
        banglaToBangla.put("⁠", ""); // U+2060 - WORD JOINER
        banglaToBangla.put("⁡", ""); // U+2061 - FUNCTION APPLICATION
        banglaToBangla.put("⁢", ""); // U+2062 - INVISIBLE TIMES
        banglaToBangla.put("⁣", ""); // U+2063 - INVISIBLE SEPARATOR
        banglaToBangla.put("⁤", ""); // U+2064 - INVISIBLE PLUS
        banglaToBangla.put("⁦", ""); // U+2066 - LEFT-TO-RIGHT ISOLATE
        banglaToBangla.put("⁧", ""); // U+2067 - RIGHT-TO-LEFT ISOLATE
        banglaToBangla.put("⁨", ""); // U+2068 - FIRST STRONG ISOLATE
        banglaToBangla.put("⁩", ""); // U+2069 - POP DIRECTIONAL ISOLATE
        banglaToBangla.put("⁪", ""); // U+206A - INHIBIT SYMMETRIC SWAPPING
        banglaToBangla.put("⁫", ""); // U+206B - ACTIVATE SYMMETRIC SWAPPING
        banglaToBangla.put("⁬", ""); // U+206C - INHIBIT ARABIC FORM SHAPING
        banglaToBangla.put("⁭", ""); // U+206D - ACTIVATE ARABIC FORM SHAPING
        banglaToBangla.put("⁮", ""); // U+206E - NATIONAL DIGIT SHAPES
        banglaToBangla.put("⁯", ""); // U+206F - NOMINAL DIGIT SHAPES
        // EN -> BN
        englishToBangla.put("class", "ক্লাস");
        englishToBangla.put("list", "লিস্ট");
        englishToBangla.put("this", "ক্লাসের");
        englishToBangla.put("each", "বের");
        englishToBangla.put("var", "সব");
        englishToBangla.put("object", "অবজেক্ট");
        englishToBangla.put("type", "ধরণ");
        englishToBangla.put("array_generator", "অ্যারে_জেনারেটর");
        englishToBangla.put("increase_size", "আকার_বাড়াও");
        englishToBangla.put("resize_array", "আকার_বাড়াও");
        englishToBangla.put("gotoStart", "শুরুতে_যাও");
        englishToBangla.put("restart", "শুরুতে_যাও");
        englishToBangla.put("println", "দেখা");
        englishToBangla.put("print", "দেখাও");
        englishToBangla.put("show", "দেখাও");
        englishToBangla.put("int", "পূর্ণসংখ্যা");
        englishToBangla.put("integer", "পূর্ণসংখ্যা");
        englishToBangla.put("FILE", "ফাইল");
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
        englishToBangla.put("break", "ভাঙ");
        englishToBangla.put("for", "লুপ");
        englishToBangla.put("loop", "লুপ");
        englishToBangla.put("exLoop", "অন্যলুপ");
        englishToBangla.put("$function", "$ফাংশন");
        englishToBangla.put("$func", "$ফাংশন");
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
        englishToBangla.put("argument", "আর্গুমেন্ট");
        englishToBangla.put("exit", "বন্ধ");
        englishToBangla.put("terminate", "বন্ধ");
        englishToBangla.put("close", "বন্ধ");
        englishToBangla.put("stopOnEnter", "প্রেসে_থামো");
        englishToBangla.put("clearConsole", "কনসোল_মুছো");
        englishToBangla.put("re_match", "রেজেক্স_মিল");
        englishToBangla.put("re_find", "রেজেক্স_খুঁজ");
        englishToBangla.put("re_find_all", "রেজেক্স_সব_খুঁজ");
        englishToBangla.put("re_replace", "রেজেক্স_বদল");
        englishToBangla.put("re_split", "রেজেক্স_বিভক্ত");
        englishToBangla.put("safe", "নিরাপদ");

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

    public static  String translateToBangla(String sourceCode)
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
            translatedCode = translateLanguage(translatedCode, russianToBangla);
            translatedCode = translateLanguage(translatedCode, englishToBangla);
            translatedCode = translateLanguage(translatedCode, hindiToBangla);
            break;
        }
        //Transform loop function call to normal
        translatedCode = processForLoopFunctionCalls(translatedCode);

        // Convert অন্যলুপ to standard for loop syntax
        translatedCode = convertOnnoLoopToForLoop(translatedCode);
    
        translatedCode = fixArraySyntax(translatedCode);

        translatedCode = processDollarDefines(translatedCode);
        return translatedCode;
    }

    private static String convertOnnoLoopToForLoop(String code)
    {
        if (code.contains("hidden_") && Pattern.compile("hidden_\\d+_\\d+").matcher(code).find())
        {
            return code; // Already processed, skip
        }
        
        String onnoLoopKeyword = TokenType.OTHER_LOOP.bangla;
        StringBuilder result = new StringBuilder();
        int lastIndex = 0;
        
        while (lastIndex < code.length())
        {
            int onnoLoopStart = code.indexOf(onnoLoopKeyword, lastIndex);
            if (onnoLoopStart == -1)
            {
                result.append(code.substring(lastIndex));
                break;
            }
            
            // Append the text before the keyword
            result.append(code.substring(lastIndex, onnoLoopStart));
            
            // Find the opening parenthesis after the keyword
            int parenStart = onnoLoopStart + onnoLoopKeyword.length();
            while (parenStart < code.length() && Character.isWhitespace(code.charAt(parenStart)))
            {
                parenStart++;
            }
            
            if (parenStart >= code.length() || code.charAt(parenStart) != '(')
            {
                // Not a valid অন্যলুপ syntax, append and continue
                result.append(code.substring(onnoLoopStart, parenStart));
                lastIndex = parenStart;
                continue;
            }
            
            // Find the matching closing parenthesis for the অন্যলুপ parameters
            int parenDepth = 1;
            int parenEnd = -1;
            for (int i = parenStart + 1; i < code.length(); i++)
            {
                char c = code.charAt(i);
                if (c == '(') parenDepth++;
                else if (c == ')') parenDepth--;
                
                if (parenDepth == 0)
                {
                    parenEnd = i;
                    break;
                }
            }
            if (parenEnd == -1)
            {
                throw new RuntimeException("Unmatched parentheses in অন্যলুপ at position " + parenStart);
            }
            
            // Extract the content inside parentheses
            String paramsContent = code.substring(parenStart + 1, parenEnd).trim();
            
            // Split parameters properly, handling nested parentheses and function calls
            List<String> params = new Vector<>();
            StringBuilder currentParam = new StringBuilder();
            int paramParenDepth = 0;
            boolean inString = false;
            char stringChar = '\0';
            
            for (int i = 0; i < paramsContent.length(); i++)
            {
                char c = paramsContent.charAt(i);
                char prevChar = i > 0 ? paramsContent.charAt(i - 1) : '\0';
                
                // Handle strings
                if (!inString && (c == '"' || c == '\''))
                {
                    inString = true;
                    stringChar = c;
                }
                else if (inString && c == stringChar && prevChar != '\\')
                {
                    inString = false;
                }
                
                // Handle parentheses
                if (!inString)
                {
                    if (c == '(') paramParenDepth++;
                    else if (c == ')') paramParenDepth--;
                }
                
                // Split on comma only when not in string and at top level parentheses
                if (c == ',' && paramParenDepth == 0 && !inString)
                {
                    params.add(currentParam.toString().trim());
                    currentParam = new StringBuilder();
                }
                else
                {
                    currentParam.append(c);
                }
            }
            
            // Add the last parameter
            if (currentParam.length() > 0)
            {
                params.add(currentParam.toString().trim());
            }
            
            // Changed: Accept 2 or 3 parameters instead of exactly 2
            if (params.size() < 2 || params.size() > 3)
            {
                throw new RuntimeException("অন্যলুপ expects 2 or 3 parameters, got " + params.size());
            }
            
            String startExpr = params.get(0).trim();
            String endExpr = params.get(1).trim();
            // Added: Get step expression (default is 1 if not provided)
            String stepExpr = params.size() == 3 ? params.get(2).trim() : "1";
            
            String theHiddenVariableForLoop = "hidden_" + System.nanoTime() + "_" + (int)(Math.random() * 1000);
            
            // Check if start expression contains function call
            boolean startExprHasFunctionCall = startExpr.contains("(") && startExpr.contains(")");
            
            // Build the replacement based on whether start expression has function call
            String replacement;
            if (startExprHasFunctionCall)
            {
                // If start expression has function call, move it to separate assignment
                // Changed: Use step expression instead of fixed "++"
                replacement = "পূর্ণসংখ্যা " + theHiddenVariableForLoop + " = " + startExpr + ";লুপ( ; " +
                           theHiddenVariableForLoop + " <= " + endExpr + " ; " + 
                           theHiddenVariableForLoop + " = " + theHiddenVariableForLoop + " + " + stepExpr + ")\n";
            } else {
                // Normal case - no function call in start expression
                // Changed: Use step expression instead of fixed "++"
                replacement = "পূর্ণসংখ্যা " + theHiddenVariableForLoop + ";লুপ(" + 
                           theHiddenVariableForLoop + " = " + startExpr + " ; " +
                           theHiddenVariableForLoop + " <= " + endExpr + " ; " + 
                           theHiddenVariableForLoop + " = " + theHiddenVariableForLoop + " + " + stepExpr + ")\n";
            }
            
            result.append(replacement);
            
            // Find the loop body and add cleanup
            int bodyStart = parenEnd + 1;
            while (bodyStart < code.length() && Character.isWhitespace(code.charAt(bodyStart)))
            {
                bodyStart++;
            }
            
            if (bodyStart >= code.length() || code.charAt(bodyStart) != '{')
            {
                throw new RuntimeException("Expect '{' after অন্যলুপ parameters");
            }
            
            // Find matching brace for loop body
            int bodyDepth = 1;
            int bodyEnd = -1;
            boolean bodyInString = false;
            char bodyStringChar = '\0';
            
            for (int i = bodyStart + 1; i < code.length(); i++)
            {
                char c = code.charAt(i);
                char prevChar = i > 0 ? code.charAt(i - 1) : '\0';
                
                // Handle strings
                if (!bodyInString && (c == '"' || c == '\''))
                {
                    bodyInString = true;
                    bodyStringChar = c;
                }
                else if (bodyInString && c == bodyStringChar && prevChar != '\\')
                {
                    bodyInString = false;
                }
                
                if (bodyInString) continue;
                
                // Count braces
                if (c == '{') bodyDepth++;
                else if (c == '}') bodyDepth--;
                
                if (bodyDepth == 0)
                {
                    bodyEnd = i;
                    break;
                }
            }
            
            if (bodyEnd == -1)
            {
                throw new RuntimeException("Unmatched braces in অন্যলুপ body");
            }
            
            // Append the loop body
            result.append(code.substring(bodyStart, bodyEnd + 1));
            
            // Add cleanup after the loop body
            result.append("ভ্যারিয়েবল_মুছো(").append(theHiddenVariableForLoop).append(");");
            
            lastIndex = bodyEnd + 1;
        }
        return result.toString();
    }

    private static String translateLanguage(String code, Map<String, String> translationMap)
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

    private static String translateNonStringPart(String text, Map<String, String> translationMap)
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
                result = Pattern.compile("\\b" + Pattern.quote(keyword) + "\\b").matcher(result).replaceAll(replacement);
            }
            else
            {
                // Exact match for other languages
                result = result.replace(keyword, replacement);
            }
        }

        return result;
    }

    public static String detectLanguage(String code)
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
        } else if (banglaCount > 0 || englishCount > 0 || russianCount > 0 || hindiCount > 0 )
        {
            return "mixed";
        }

        return "unknown";
    }

    private static String processForLoopFunctionCalls(String code)
    {
        // If the code already contains processed loops (has hidden_ variables), skip processing
        if (code.contains("hidden_") && Pattern.compile("hidden_\\d+_\\d+").matcher(code).find())
        {
            return code; // Already processed, I can skip now.
        }
        
        // Pattern for both cases: with and without type declaration
        Pattern pattern = Pattern.compile(
            "লুপ\\s*\\(" + "\\s*((পূর্ণসংখ্যা|ভগ্নাংশ|বাক্য|বুলিয়ান)\\s+)?(\\w+)\\s*=\\s*(\\w+)\\s*\\([^)]*\\)\\s*;"
        );
        
        StringBuilder result = new StringBuilder();
        int lastIndex = 0;
        Matcher matcher = pattern.matcher(code);
    
        while (matcher.find())
        {
            // Append the text before the match
            result.append(code.substring(lastIndex, matcher.start()));
            
            String typePart = matcher.group(1) != null ? matcher.group(2) + " " : "";
            String typeForHidden = matcher.group(1) != null ? matcher.group(2) : "সব";
            String varName = matcher.group(3);
            String funcName = matcher.group(4);
            
            String functionCall = funcName + code.substring(
                matcher.start(4) + funcName.length(), 
                matcher.end()
            ).split(";")[0];
            
            String hiddenVar = "hidden_" + System.nanoTime() + "_" + (int)(Math.random() * 1000);
            
            String replacement = typeForHidden + " " + hiddenVar + " = " + functionCall + ";লুপ(" + typePart + varName + " = " + hiddenVar + ";";
            
            // Append the replacement
            result.append(replacement);
            lastIndex = matcher.end();
            
            // Find the matching closing brace for this loop
            String remainingCode = code.substring(lastIndex);
            int braceCount = 0;
            boolean inString = false;
            int loopEnd = -1;
            
            for (int i = 0; i < remainingCode.length(); i++)
            {
                char c = remainingCode.charAt(i);
                char prevChar = i > 0 ? remainingCode.charAt(i - 1) : '\0';
                
                // Handle strings
                if (c == '"' && prevChar != '\\')
                 {
                    inString = !inString;
                    continue;
                }
                if (inString) continue;
                
                // Count braces
                if (c == '{') braceCount++;
                else if (c == '}')
                {
                    braceCount--;
                    if (braceCount == 0)
                    {
                        loopEnd = i;
                        break;
                    }
                }
            }
            
            if (loopEnd != -1)
            {
                // Insert cleanup AFTER the closing brace (loopEnd + 1)
                result.append(remainingCode.substring(0, loopEnd + 1)); // Include the '}'
                result.append("ভ্যারিয়েবল_মুছো(").append(hiddenVar).append(");");
                
                // Update lastIndex to the position after the processed loop
                lastIndex = lastIndex + loopEnd + 1 + ("ভ্যারিয়েবল_মুছো(" + hiddenVar + ");").length();
            }
        }
        
        // Append any remaining code that wasn't processed
        if (lastIndex < code.length())
        {
            result.append(code.substring(lastIndex));
        }
        return result.toString();
    }

    private static String fixArraySyntax(String code)
    {
        // Fix: পূর্ণসংখ্যার_অ্যারে y -> {1,2}; to use proper unlimited array syntax
        Pattern invalidArrayPattern = Pattern.compile(
            "(পূর্ণসংখ্যার_অ্যারে|ভগ্নাংশের_অ্যারে|বাক্যের_অ্যারে|বুলিয়ানের_অ্যারে)\\s+(\\w+)\\s*→\\s*\\{"
        );
        
        Matcher matcher = invalidArrayPattern.matcher(code);
        StringBuffer sb = new StringBuffer();
        
        while (matcher.find())
        {
            // Use empty brackets to indicate unlimited array
            String replacement = matcher.group(1) + " " + matcher.group(2) + "[] → {";
            matcher.appendReplacement(sb, Matcher.quoteReplacement(replacement));
        }
        matcher.appendTail(sb);
        
        return sb.toString();
    }

    private static String processDollarDefines(String code)
    {
        Map<String, String> dollarDefines = new LinkedHashMap<>();
        Map<String, MacroDefinition> macroDefines = new LinkedHashMap<>();
        StringBuilder result = new StringBuilder();
        String[] lines = code.split("\\r?\\n");
        
        for (String line : lines)
        {
            String trimmedLine = line.trim();
            
            // Check for $ definitions (but not $function variants)
            if (trimmedLine.startsWith("$") && 
                !trimmedLine.startsWith("$ফাংশন") && 
                !trimmedLine.startsWith("$function") && 
                !trimmedLine.startsWith("$func") &&
                !trimmedLine.startsWith("$ফাংশনের"))
            {
                String defineLine = trimmedLine.substring(1).trim();
                
                if (defineLine.isEmpty())
                {
                    result.append(line).append("\n");
                    continue;
                }
                
                // Check if this is a function-like macro (has parentheses)
                if (defineLine.contains("(") && defineLine.contains(")"))
                {
                    // Parse function-like macro
                    int parenStart = defineLine.indexOf('(');
                    int parenEnd = defineLine.indexOf(')', parenStart);
                    
                    if (parenStart != -1 && parenEnd != -1 && parenStart < parenEnd)
                    {
                        // Extract macro name
                        String macroName = defineLine.substring(0, parenStart).trim();
                        
                        // Simple identifier validation
                        boolean validIdentifier = !macroName.isEmpty();
                        char firstChar = macroName.charAt(0);
                        validIdentifier = validIdentifier && (Character.isLetter(firstChar) || firstChar == '_' || 
                            Character.UnicodeBlock.of(firstChar).equals(Character.UnicodeBlock.BENGALI));
                        
                        for (int i = 1; i < macroName.length() && validIdentifier; i++)
                        {
                            char c = macroName.charAt(i);
                            if (!Character.isLetterOrDigit(c) && c != '_' && 
                                !Character.UnicodeBlock.of(c).equals(Character.UnicodeBlock.BENGALI))
                            {
                                validIdentifier = false;
                            }
                        }
                        
                        if (validIdentifier)
                        {
                            // Extract parameters
                            String paramsStr = defineLine.substring(parenStart + 1, parenEnd).trim();
                            List<String> parameters = new Vector<>();
                            
                            if (!paramsStr.isEmpty())
                            {
                                String[] paramArray = paramsStr.split("\\s*,\\s*");
                                for (String param : paramArray)
                                {
                                    param = param.trim();
                                    if (!param.isEmpty())
                                    {
                                        parameters.add(param);
                                    }
                                }
                            }
                            
                            // Extract macro body
                            String body = defineLine.substring(parenEnd + 1).trim();
                            
                            // Store macro definition
                            macroDefines.put(macroName, new MacroDefinition(macroName, parameters, body));
                            continue;
                        }
                    }
                }
                
                // Handle simple variable definition (your existing code)
                String[] parts = defineLine.split("\\s+", 2);
                
                if (parts.length >= 1)
                {
                    String identifier = parts[0].trim();
                    
                    // Simple identifier validation
                    boolean validIdentifier = !identifier.isEmpty();
                    char firstChar = identifier.charAt(0);
                    validIdentifier = validIdentifier && (Character.isLetter(firstChar) || firstChar == '_' || 
                        Character.UnicodeBlock.of(firstChar).equals(Character.UnicodeBlock.BENGALI));
                    
                    for (int i = 1; i < identifier.length() && validIdentifier; i++)
                    {
                        char c = identifier.charAt(i);
                        if (!Character.isLetterOrDigit(c) && c != '_' && 
                            !Character.UnicodeBlock.of(c).equals(Character.UnicodeBlock.BENGALI))
                        {
                            validIdentifier = false;
                        }
                    }
                    
                    if (!validIdentifier)
                    {
                        result.append(line).append("\n");
                        continue;
                    }
                    
                    String value = parts.length > 1 ? parts[1].trim() : "";
                    
                    if (value.contains("//"))
                    {
                        value = value.substring(0, value.indexOf("//")).trim();
                    }
                    if (value.contains("/*"))
                    {
                        value = value.substring(0, value.indexOf("/*")).trim();
                    }
                    
                    dollarDefines.put(identifier, value);
                    continue;
                }
            }
            
            String processedLine = line;
            
            // First process function-like macros
            for (Map.Entry<String, MacroDefinition> entry : macroDefines.entrySet())
            {
                String macroName = entry.getKey();
                MacroDefinition macro = entry.getValue();
                
                // Pattern to match macro calls: MACRO_NAME(arguments)
                String pattern = "\\b" + Pattern.quote(macroName) + "\\s*\\(";
                Pattern macroPattern = Pattern.compile(pattern);
                Matcher matcher = macroPattern.matcher(processedLine);
                
                StringBuffer lineBuffer = new StringBuffer();
                
                while (matcher.find())
                {
                    int macroStart = matcher.start();
                    int parenStart = matcher.end() - 1; // Position of '('
                    
                    // Find matching closing parenthesis
                    int parenEnd = findMatchingParen(processedLine, parenStart);
                    if (parenEnd == -1)
                    {
                        // No matching closing paren, skip
                        matcher.appendReplacement(lineBuffer, matcher.group());
                        continue;
                    }
                    
                    // Extract arguments
                    String argsStr = processedLine.substring(parenStart + 1, parenEnd).trim();
                    List<String> arguments = parseMacroArguments(argsStr);
                    
                    // Validate argument count
                    if (arguments.size() != macro.parameters.size())
                    {
                        // Argument count mismatch, skip expansion
                        matcher.appendReplacement(lineBuffer, matcher.group());
                        continue;
                    }
                    
                    // Perform macro expansion
                    String expansion = expandMacro(macro, arguments);
                    
                    // Replace the macro call with expansion
                    String beforeMacro = processedLine.substring(0, macroStart);
                    String afterMacro = processedLine.substring(parenEnd + 1);
                    processedLine = beforeMacro + expansion + afterMacro;
                    
                    // Reset matcher for the modified line
                    matcher = macroPattern.matcher(processedLine);
                    lineBuffer = new StringBuffer();
                }
                
                matcher.appendTail(lineBuffer);
                processedLine = lineBuffer.toString();
            }
            
            // Then process simple defines (your existing replacement logic)
            for (Map.Entry<String, String> entry : dollarDefines.entrySet())
            {
                String identifier = entry.getKey();
                String value = entry.getValue();
                
                // Manual word boundary replacement without regex (your existing code)
                StringBuilder lineBuilder = new StringBuilder();
                int lastIndex = 0;
                int identifierLen = identifier.length();
                
                while (lastIndex < processedLine.length())
                {
                    int index = processedLine.indexOf(identifier, lastIndex);
                    
                    if (index == -1)
                    {
                        lineBuilder.append(processedLine.substring(lastIndex));
                        break;
                    }
                    
                    boolean leftBoundary = (index == 0) || !Character.isLetterOrDigit(processedLine.charAt(index - 1));
                    boolean rightBoundary = (index + identifierLen >= processedLine.length()) || 
                                           !Character.isLetterOrDigit(processedLine.charAt(index + identifierLen));
                    
                    if (leftBoundary && rightBoundary)
                    {
                        lineBuilder.append(processedLine.substring(lastIndex, index));
                        lineBuilder.append(value);
                        lastIndex = index + identifierLen;
                    }
                    else
                    {
                        lineBuilder.append(processedLine.substring(lastIndex, index + identifierLen));
                        lastIndex = index + identifierLen;
                    }
                }
                
                processedLine = lineBuilder.toString();
            }
            
            result.append(processedLine).append("\n");
        }
        
        return result.toString();
    }
    
    // Helper methods needed for macro functionality
    private static int findMatchingParen(String str, int startPos)
    {
        int depth = 1;
        for (int i = startPos + 1; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (c == '(') depth++;
            else if (c == ')') depth--;
            
            if (depth == 0) return i;
        }
        return -1; // No matching closing paren found
    }
    
    private static List<String> parseMacroArguments(String argsStr)
    {
        List<String> arguments = new Vector<>();
        if (argsStr.isEmpty()) return arguments;
        
        StringBuilder currentArg = new StringBuilder();
        int parenDepth = 0;
        boolean inString = false;
        char stringChar = '\0';
        
        for (int i = 0; i < argsStr.length(); i++)
        {
            char c = argsStr.charAt(i);
            
            if (!inString)
            {
                if (c == '"' || c == '\'')
                {
                    inString = true;
                    stringChar = c;
                    currentArg.append(c);
                }
                else if (c == '(')
                {
                    parenDepth++;
                    currentArg.append(c);
                }
                else if (c == ')')
                {
                    parenDepth--;
                    currentArg.append(c);
                }
                else if (c == ',' && parenDepth == 0)
                {
                    arguments.add(currentArg.toString().trim());
                    currentArg = new StringBuilder();
                }
                else
                {
                    currentArg.append(c);
                }
            }
            else
            {
                // Inside string literal
                currentArg.append(c);
                if (c == stringChar && (i == 0 || argsStr.charAt(i - 1) != '\\'))
                {
                    inString = false;
                }
            }
        }
        
        // Add the last argument
        if (currentArg.length() > 0)
        {
            arguments.add(currentArg.toString().trim());
        }
        
        return arguments;
    }
    
    private static String expandMacro(MacroDefinition macro, List<String> arguments)
    {
        String expansion = macro.body;
        
        // Replace each parameter with its corresponding argument
        for (int i = 0; i < macro.parameters.size(); i++)
        {
            String param = macro.parameters.get(i);
            String arg = arguments.get(i);
            
            // Use word boundaries to avoid partial replacements
            StringBuilder expanded = new StringBuilder();
            int lastIndex = 0;
            int paramLen = param.length();
            
            while (lastIndex < expansion.length())
            {
                int index = expansion.indexOf(param, lastIndex);
                
                if (index == -1)
                {
                    expanded.append(expansion.substring(lastIndex));
                    break;
                }
                
                boolean leftBoundary = (index == 0) || !Character.isLetterOrDigit(expansion.charAt(index - 1));
                boolean rightBoundary = (index + paramLen >= expansion.length()) || 
                                       !Character.isLetterOrDigit(expansion.charAt(index + paramLen));
                
                if (leftBoundary && rightBoundary)
                {
                    expanded.append(expansion.substring(lastIndex, index));
                    expanded.append(arg);
                    lastIndex = index + paramLen;
                }
                else
                {
                    expanded.append(expansion.substring(lastIndex, index + paramLen));
                    lastIndex = index + paramLen;
                }
            }
            
            expansion = expanded.toString();
        }
        
        return expansion;
    }
    
    // Inner class for macro definitions
    static class MacroDefinition
    {
        String name;
        List<String> parameters;
        String body;
        
        MacroDefinition(String name, List<String> parameters, String body)
        {
            this.name = name;
            this.parameters = parameters;
            this.body = body;
        }
    }
}
enum FileOperation
{
    OPEN, READ, WRITE, CLOSE, DELETE, CUT, COPY
}
enum FileMode 
{
    // Text modes (existing)
    READ("r", "পড়ার জন্য"),
    WRITE("w", "ফাইল বানিয়ে লিখ"),
    APPEND("a", "যোগ করে লিখ"),
    READ_WRITE("r+", "পড়া ও লিখার জন্য"),
    WRITE_READ("w+", "ফাইল বানিয়ে পড়া ও লিখার জন্য"),
    APPEND_READ("a+", "যোগ করে পড়া ও লিখার জন্য"),
    
    // Binary modes (new)
    READ_BINARY("rb", "বাইনারি পড়ার জন্য"),
    WRITE_BINARY("wb", "বাইনারি ফাইল বানিয়ে লিখ"),
    APPEND_BINARY("ab", "বাইনারি যোগ করে লিখ"),
    READ_WRITE_BINARY("r+b", "বাইনারি পড়া ও লিখার জন্য"),
    WRITE_READ_BINARY("w+b", "বাইনারি ফাইল বানিয়ে পড়া ও লিখার জন্য"),
    APPEND_READ_BINARY("a+b", "বাইনারি যোগ করে পড়া ও লিখার জন্য");

    final String cMode;
    final String banglaMode;

    FileMode(String cMode, String banglaMode) 
    {
        this.cMode = cMode;
        this.banglaMode = banglaMode;
    }

    static FileMode fromString(String mode)
    {
        for (FileMode fm : values())
        {
            if (fm.cMode.equalsIgnoreCase(mode) || fm.banglaMode.equalsIgnoreCase(mode))
            {
                return fm;
            }
        }
        return WRITE; // Default mode
    }
    
    // Helper method to check if mode is binary
    public boolean isBinary()
    {
        return this.cMode.contains("b");
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
    TO_INT("পূর্ণসংখ্যায়"),
    TO_FLOAT("ভগ্নাংশে"),
    TO_STRING("বাক্যে"),
    TO_BOOLEAN("বুলিয়ানে"),
    ALL("সব"),
    PRIVATE("প্রাইভেট"),
    PUBLIC("পাবলিক"),
    CLASS_SELF("ক্লাসের"),
    CLASS("ক্লাস"),
    OBJECT("অবজেক্ট"),
    AT_SYMBOL("@"),
    DOT("."),
    PRINTLN("দেখা"),
    PRINT("দেখাও"),
    TRUE("সত্য"),
    REGEX("রেজেক্স_মিল"),
    REGEX_FIND("রেজেক্স_খুঁজ"),
    REGEX_FIND_ALL("রেজেক্স_সব_খুঁজ"),
    REGEX_REPLACE("রেজেক্স_বদল"),
    REGEX_SPLIT("রেজেক্স_বিভক্ত"),
    FALSE("মিথ্যা"),
    NIL("null"),
    IF("যদি"),
    ELSE_IF("যদিবা"),
    ELSE("বা"),
    FOR_EACH("বের"),
    LOOP("লুপ"),
    OTHER_LOOP("অন্যলুপ"),
    BREAK("ভাঙ"),
    CONTINUE("এড়াও"),
    DATATYPE("ধরণ"),
    INPUT("নাও"),
    TEMPORARY_FUNCTION("$ফাংশন"),
    FUNCTION("ফাংশন"),
    ARGUMENT("আর্গুমেন্ট"),
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
    FILE("ফাইল"),
    STREAM("স্ট্রিম"),
    OPEN_FILE("খোলো"),
    READ_FILE("পড়"),
    WRITE_FILE("লিখ"),
    CLOSE_FILE("ফাইল_বন্ধ"),
    DELETE_FILE("ফাইল_মুছ"),
    FILE_CUT("ফাইল_কাট"),
    FILE_COPY("ফাইল_কপি"),
    BINARY_READ("বাইনারি_পড়"),
    BINARY_WRITE("বাইনারি_লিখ"), 
    FILE_SEEK("ফাইল_সিক"),
    FILE_POSITION("ফাইল_অবস্থান"),
    FILE_SIZE("ফাইল_আকার"),
    LIST("লিস্ট"),
    SET("সেট"),
    NIRAPOD("নিরাপদ"),
    // Literals
    IDENTIFIER,
    INTEGER_LITERAL,
    FLOAT_LITERAL,
    STRING_LITERAL,
    BOOLEAN_LITERAL,
    FILE_HANDLE,
    // Operators
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    EQUAL_EQUAL("=="),
    BANG_EQUAL("!="),
    BANG("!"),
    LIST_ACCESS("¥"), 
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
    HASH("#"),

    // Punctuation
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACE("{"),
    RIGHT_BRACE("}"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    COLON(":"),
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
     String lexeme;
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
        String translatedSource = new String(LanguageTranslator.translateToBangla(source));
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

    private void  scanToken()
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
            case ':':
                addToken(TokenType.COLON);
                break;
            case '@':
                addToken(TokenType.AT_SYMBOL);
                break;
            case '.':
                addToken(TokenType.DOT);
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

            case '¥':
                addToken(TokenType.LIST_ACCESS);
                break;
            case '#':
                addToken(TokenType.HASH);
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

        // Handle $ফাংশন as a special case
        if (text.equals("$ফাংশন"))
        {
            addToken(TokenType.TEMPORARY_FUNCTION);
            return;
        }
        if (text.equals("ক্লাসের"))
        {
            addToken(TokenType.CLASS_SELF);
            return;
        }
        if (text.equals("ক্লাস"))
       {
            addToken(TokenType.CLASS);
            return;
        }
        if (text.equals("অবজেক্ট"))
        {
            addToken(TokenType.OBJECT);
            return;
        }
        if (text.equals("লিস্ট"))
        {
            addToken(TokenType.LIST);
            return;
        }
        if (text.equals("ফাইল"))
        {
            addToken(TokenType.FILE);
            return;
        }
        if (text.equals("খোলো"))
        {
            addToken(TokenType.OPEN_FILE);
            return;
        }
        if (text.equals("পড়"))
        {
            addToken(TokenType.READ_FILE);
            return;
        }
        if (text.equals("স্ট্রিম"))
        {
            addToken(TokenType.STREAM);
            return;
        }
        if (text.equals("লিখ"))
        {
            addToken(TokenType.WRITE_FILE);
            return;
        }
        if (text.equals("ফাইল_মুছ"))
        {
            addToken(TokenType.DELETE_FILE);
            return;
        }

        // Check other keywords
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
        // Read the whole number including underscores
        while (isDigit(peek()) || peek() == '_') advance();
        
        // Check for decimal point
        if (peek() == '.' && isDigit(peekNext()))
        {
            advance(); // consume the '.'
            while (isDigit(peek()) || peek() == '_') advance();
        }
        
        // Extract the text
        String numberText = source.substring(start, current);
        
        // Validate underscore usage
        if (numberText.startsWith("_") || numberText.endsWith("_") || numberText.contains("__"))
        {
            throw new RuntimeException("Invalid underscore usage in number '" + numberText + "' at line " + line);
        }
        
        // Remove underscores for parsing
        String cleanNumberText = numberText.replace("_", "");
        
        try
        {
            if (numberText.contains("."))
            {
                addToken(TokenType.FLOAT_LITERAL, new BigDecimal(cleanNumberText));
            }
            else
            {
                addToken(TokenType.INTEGER_LITERAL, new BigDecimal(cleanNumberText));
            }
        }
        catch (NumberFormatException e)
        {
            throw new RuntimeException("Invalid number format '" + numberText + "' at line " + line);
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
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == '_' || c == '$'||
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

    //For debugging perpose.
    @Override
    public String toString()
    {
        return tokens.toString();
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
    R visitFileReadExpr(FileReadExpr expr);
    R visitCloseFilesExpr(CloseFilesExpr expr);
    R visitDeleteFilesExpr(DeleteFilesExpr expr);
    R visitFileCutExpr(FileCutExpr expr);
    R visitFileCopyExpr(FileCopyExpr expr);
    R visitRegexExpr(RegexExpr expr);
    R visitRegexFindExpr(RegexFindExpr expr);
    R visitRegexFindAllExpr(RegexFindAllExpr expr);
    R visitRegexReplaceExpr(RegexReplaceExpr expr);
    R visitRegexSplitExpr(RegexSplitExpr expr);
    R visitObjectExpr(ObjectExpr expr);
    R visitDotExpr(DotExpr expr);
    R visitMethodCallExpr(MethodCallExpr expr);
    R visitClassSelfExpr(ClassSelfExpr expr);
    R visitClassSelfAssignment(ClassSelfAssignment expr);
    R visitClassSelfMethodCall(ClassSelfMethodCall expr);
    R visitListLiteralExpr(ListLiteral expr);
    R visitListAccessExpr(ListAccess expr);
    R visitMultiDimAccessExpr(MultiDimAccess expr);
    R visitListMethodCallExpr(ListMethodCall expr);
    R visitStreamExpr(StreamExpr expr);
    R visitBinaryReadExpr(BinaryReadExpr expr);
    R visitBinaryWriteExpr(BinaryWriteExpr expr);
    R visitFileSeekExpr(FileSeekExpr expr);
    R visitFilePositionExpr(FilePositionExpr expr);
    R visitFileSizeExpr(FileSizeExpr expr);
    R visitSetLiteralExpr(SetLiteral expr);
}

record Binary(Expr left, Token operator, Expr right) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitBinaryExpr(this);
    }
}

record FileReadExpr(Expr fileHandle, List<Expr> arguments) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitFileReadExpr(this);
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
record CloseFilesExpr(List<Expr> fileHandles) implements Expr
{
    @Override
    public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitCloseFilesExpr(this);
    }
}

record DeleteFilesExpr(List<Expr> fileHandles) implements Expr
{
    @Override
    public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitDeleteFilesExpr(this);
    }
}

record FileCutExpr(Expr sourcePath, Expr destPath) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitFileCutExpr(this);
    }
}

record FileCopyExpr(Expr sourcePath, Expr destPath) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitFileCopyExpr(this);
    }
}

record RegexExpr(Expr sourceString, Expr regexString) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitRegexExpr(this);
    }
}
record RegexFindExpr(Expr sourceString, Expr regexString) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitRegexFindExpr(this);
    }
}

record RegexFindAllExpr(Expr sourceString, Expr regexString) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitRegexFindAllExpr(this);
    }
}

record RegexReplaceExpr(Expr sourceString, Expr regexString, Expr replacement) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitRegexReplaceExpr(this);
    }
}

record RegexSplitExpr(Expr sourceString, Expr regexString) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitRegexSplitExpr(this);
    }
}

// Class-related AST nodes
record ObjectExpr(Token className, List<Expr> arguments) implements Expr
{
    // Constructor for no arguments
    public ObjectExpr(Token className)
    {
        this(className, new Vector<>());
    }
    
    @Override 
    public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitObjectExpr(this);
    }
}

record DotExpr(Expr object, Token name) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitDotExpr(this);
    }
}

record MethodCallExpr(Expr object, Token method, List<Expr> arguments) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitMethodCallExpr(this);
    }
}

record ClassSelfExpr(Token keyword) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitClassSelfExpr(this);
    }
}

record ClassSelfAssignment(Token fieldName, Expr value) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitClassSelfAssignment(this);
    }
}

record ClassSelfMethodCall(Token methodName, List<Expr> arguments) implements Expr
{
    @Override public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitClassSelfMethodCall(this);
    }
}

record ListLiteral(List<Expr> elements) implements Expr
{
    @Override 
    public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitListLiteralExpr(this);
    }
}

record ListAccess(Expr list, Expr index) implements Expr
{
    @Override 
    public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitListAccessExpr(this);
    }
}
// Represents multi-dimensional access with comma-separated indices
record MultiDimAccess(Expr array, List<Expr> indices) implements Expr
{
    @Override 
    public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitMultiDimAccessExpr(this);
    }
}

record ListMethodCall(Expr list, Token method, List<Expr> arguments) implements Expr
{
    @Override 
    public <R> R accept(ExprVisitor<R> visitor) 
    {
        return visitor.visitListMethodCallExpr(this);
    }
}

// Add this record to your existing Expr records
record StreamExpr(Expr list) implements Expr 
{
    @Override 
    public <R> R accept(ExprVisitor<R> visitor)
    {
        return visitor.visitStreamExpr(this);
    }
}

// Add these records to your Expr records

record BinaryReadExpr(Expr fileHandle, Expr bytesToRead) implements Expr {
    @Override public <R> R accept(ExprVisitor<R> visitor) {
        return visitor.visitBinaryReadExpr(this);
    }
}

record BinaryWriteExpr(Expr fileHandle, Expr data, Expr offset, Expr length) implements Expr {
    @Override public <R> R accept(ExprVisitor<R> visitor) {
        return visitor.visitBinaryWriteExpr(this);
    }
}

record FileSeekExpr(Expr fileHandle, Expr position) implements Expr {
    @Override public <R> R accept(ExprVisitor<R> visitor) {
        return visitor.visitFileSeekExpr(this);
    }
}

record FilePositionExpr(Expr fileHandle) implements Expr {
    @Override public <R> R accept(ExprVisitor<R> visitor) {
        return visitor.visitFilePositionExpr(this);
    }
}

record FileSizeExpr(Expr fileHandle) implements Expr {
    @Override public <R> R accept(ExprVisitor<R> visitor) {
        return visitor.visitFileSizeExpr(this);
    }
}

record SetLiteral(List<Expr> elements) implements Expr {
    @Override 
    public <R> R accept(ExprVisitor<R> visitor) {
        return visitor.visitSetLiteralExpr(this);
    }
}

@FunctionalInterface
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
    R visitFileStmt(FileStmt stmt);
    R visitFileWriteStmt(FileWriteStmt stmt);
    R visitClassStmt(ClassStmt stmt);
    R visitForEachStmt(ForEach stmt);
    R visitVarWithAccessStmt(VarWithAccess stmt);
    R visitArrayStmtWithAccessStmt(ArrayStmtWithAccess stmt);
    R visitFunctionWithAccessStmt(FunctionWithAccess stmt);
    R visitSafeScopeStmt(SafeScope stmt);
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

record Function(Token name, Token returnType, List<Token> parameters, 
                List<Stmt> body, boolean isTemporary, Environment environment,
                List<Expr> defaultValues) implements Stmt {
    
    // Constructor for functions with default values but no environment
    public Function(Token name, Token returnType, List<Token> parameters, 
                   List<Stmt> body, boolean isTemporary, List<Expr> defaultValues) {
        this(name, returnType, parameters, body, isTemporary, new Environment(), defaultValues);
    }
    
    // Constructor for regular functions (without default values)
    public Function(Token name, Token returnType, List<Token> parameters, 
                   List<Stmt> body, boolean isTemporary) {
        this(name, returnType, parameters, body, isTemporary, new Environment(), new Vector<>());
    }
    
    // Constructor with environment (for method binding)
    public Function(Token name, Token returnType, List<Token> parameters,
                   List<Stmt> body, boolean isTemporary, Environment environment) {
        this(name, returnType, parameters, body, isTemporary, environment, new Vector<>());
    }
 
    
    public Function bind(ClassInstance instance) {
        Environment boundEnvironment = new Environment(this.environment);
        boundEnvironment.define("this", instance);
        
        return new Function(this.name, this.returnType, this.parameters, 
                           this.body, this.isTemporary, boundEnvironment, this.defaultValues);
    }
    
    // Helper method to get parameter types
    public TokenType[] getParameterTypes() {
        return parameters.stream().map(t -> t.type).toArray(TokenType[]::new);
    }
    
    // Helper method to check if parameter has default value
    public boolean hasDefaultValue(int paramIndex) {
        return defaultValues != null && 
               paramIndex < defaultValues.size() && 
               defaultValues.get(paramIndex) != null;
    }
    
    @Override 
    public <R> R accept(StmtVisitor<R> visitor) {
        return visitor.visitFunctionStmt(this);
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

record FileStmt(Token name, Expr path, FileOperation operation,  FileMode defaultMode, Expr modeExpr) implements Stmt
{
    @Override 
    public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitFileStmt(this);
    }
}

record FileWriteStmt(Expr fileHandle, Expr content) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitFileWriteStmt(this);
    }
}

record ClassStmt(Token name, List<Stmt> members) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitClassStmt(this);
    }
}
record ForEach(Token variable, Expr collection, Stmt body) implements Stmt
{
    @Override 
    public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitForEachStmt(this);
    }
}

record VarWithAccess(Token name, Expr initializer, boolean isPublic) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitVarWithAccessStmt(this);
    }
    
    public TokenType type()
    {
        return name.type;
    }
}

record ArrayStmtWithAccess(Token name, TokenType type, Expr size, List<Expr> initialValues, boolean isPublic) implements Stmt
{
    @Override public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitArrayStmtWithAccessStmt(this); // Fixed method name
    }
}

record FunctionWithAccess(Token name, Token returnType, List<Token> parameters, 
                         List<Stmt> body, boolean isTemporary, Environment environment, 
                         boolean isPublic) implements Stmt
{
    // Constructors for regular functions (without environment)
    public FunctionWithAccess(Token name, Token returnType, List<Token> parameters, 
                             List<Stmt> body, boolean isTemporary, boolean isPublic)
    {
        this(name, returnType, parameters, body, isTemporary, new Environment(), isPublic);
    }
    
    public FunctionWithAccess bind(ClassInstance instance)
    {
        Environment boundEnvironment = new Environment(this.environment);
        boundEnvironment.define("this", instance);
        
        return new FunctionWithAccess(this.name, this.returnType, this.parameters, 
                                   this.body, this.isTemporary, boundEnvironment, this.isPublic);
    }
    
    @Override 
    public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitFunctionWithAccessStmt(this);
    }
    
    // Helper method to get parameter types
    public TokenType[] getParameterTypes()
    {
        return parameters.stream().map(t -> t.type).toArray(TokenType[]::new);
    }
}

// Add to Stmt records
record SafeScope(Stmt body) implements Stmt
{
    @Override 
    public <R> R accept(StmtVisitor<R> visitor)
    {
        return visitor.visitSafeScopeStmt(this);
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
            if (match(TokenType.INTEGER, TokenType.FLOAT, TokenType.STRING, TokenType.BOOLEAN, TokenType.OBJECT, TokenType.ALL, TokenType.LIST, TokenType.STREAM, TokenType.SET))
            {
                return varDeclaration();
            }
            if (match(TokenType.FUNCTION, TokenType.TEMPORARY_FUNCTION))
            {
                return functionDeclaration();
            }
            if (match(TokenType.FILE))
            {
                return fileDeclaration();
            }
    
            if (match(TokenType.CLASS))
            {
                return classDeclaration();
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

    private Stmt classDeclaration()
    {
        Token name = consume(TokenType.IDENTIFIER, "Expect class name.");
        consume(TokenType.ASSIGN, "Expect '=' after class name.");
        consume(TokenType.LEFT_BRACE, "Expect '{' before class body.");
    
        List<Stmt> members = new Vector<>();
        while (!check(TokenType.RIGHT_BRACE) && !isAtEnd())
        {
            members.add(classMember());
        }
    
        consume(TokenType.RIGHT_BRACE, "Expect '}' after class body.");
        return new ClassStmt(name, members);
    }
    
    private Stmt classMember()
    {
        // Parse access modifier (default to public)
        boolean isPublic = true;
        if (match(TokenType.PRIVATE, TokenType.PUBLIC))
        {
            isPublic = previous().type == TokenType.PUBLIC;
        }

        // Class members can be variables, arrays, functions, or constructors
        if (match(TokenType.INTEGER, TokenType.FLOAT, TokenType.STRING, TokenType.BOOLEAN, TokenType.ALL, TokenType.OBJECT, TokenType.FILE, TokenType.LIST, TokenType.STREAM))
        {
            Var varStmt = (Var)varDeclaration();
            // Store access modifier information
            return new VarWithAccess(varStmt.name(), varStmt.initializer(), isPublic);
        }
        if (match(TokenType.INTEGER_ARRAY, TokenType.FLOAT_ARRAY, TokenType.STRING_ARRAY, TokenType.BOOLEAN_ARRAY))
        {
            ArrayStmt arrayStmt = (ArrayStmt)arrayDeclaration();
            // Store access modifier information
            return new ArrayStmtWithAccess(arrayStmt.name(), arrayStmt.type(), arrayStmt.size(), 
                                         arrayStmt.initialValues(), isPublic);
        }
        if (match(TokenType.FUNCTION))
        {
            // Check if this is a constructor
            if (check(TokenType.IDENTIFIER) && peek().lexeme.equals("constructor"))
            {
                Function constructor = (Function)constructorDeclaration();
                return new FunctionWithAccess(constructor.name(), constructor.returnType(), 
                                           constructor.parameters(), constructor.body(), 
                                           constructor.isTemporary(), constructor.environment(), 
                                           isPublic);
            }
            Function func = (Function)functionDeclaration();
            return new FunctionWithAccess(func.name(), func.returnType(), func.parameters(), 
                                       func.body(), func.isTemporary(), func.environment(), 
                                       isPublic);
        }
        throw new RuntimeException("Expect variable, array or function declaration in class");
    }
 
    
    private Stmt constructorDeclaration()
    {
        // Parse constructor name (should be "constructor")
        Token name = consume(TokenType.IDENTIFIER, "Expect 'constructor' as method name");
        if (!name.lexeme.equals("constructor"))
        {
            throw new RuntimeException("Constructor must be named 'constructor'");
        }
    
        // Parse parameters
        consume(TokenType.LEFT_PAREN, "Expect '(' after constructor name");
        List<Token> parameters = new Vector<>();
        if (!check(TokenType.RIGHT_PAREN))
        {
            do
            {
                if (parameters.size() >= 30000)
                {
                    throw new RuntimeException("Can't have more than 30000 parameters");
                }
    
                if (match(TokenType.INTEGER, TokenType.FLOAT, TokenType.STRING, TokenType.BOOLEAN))
                {
                    Token type = previous();
                    Token param = consume(TokenType.IDENTIFIER, "Expect parameter name");
                    param.type = type.type;
                    parameters.add(param);
                } else
                {
                    throw new RuntimeException("Expect parameter type");
                }
            } while (match(TokenType.COMMA));
        }
        consume(TokenType.RIGHT_PAREN, "Expect ')' after parameters");
    
        // Parse constructor body
        consume(TokenType.LEFT_BRACE, "Expect '{' before constructor body");
        List<Stmt> body = block();
    
        // Create a special constructor function (return type is the class itself)
        Token returnType = new Token(TokenType.CLASS, "constructor_return", null, name.line);
        return new Function(name, returnType, parameters, body, false);
    }

    private Stmt fileDeclaration()
    {
        Token name = consume(TokenType.IDENTIFIER, "Expect file handle name.");
        
        // Check if there's an immediate assignment
        if (match(TokenType.ASSIGN))
        {
            // Handle immediate assignment: ফাইল f = খোলো("path"); OR ফাইল f = 2;
            Expr initializer = expression();
            consume(TokenType.SEMICOLON, "Expect ';' after file assignment.");
            
            // Create a special file variable declaration that maintains the FILE type
            // We'll create a Var statement but with FILE type preserved
            name.type = TokenType.FILE; // Ensure the token type is set to FILE
            return new Var(name, initializer);
        }
        else
        {
            // No assignment - just declaration: ফাইল f;
            // Set initializer to null to indicate unassigned file
            consume(TokenType.SEMICOLON, "Expect ';' after file declaration.");
            name.type = TokenType.FILE; // Ensure the token type is set to FILE
            return new Var(name, new Literal(null));
        }
    }

    private Stmt functionDeclaration()
    {
        boolean isTemporary = previous().type == TokenType.TEMPORARY_FUNCTION;
    
        // Parse return type (either VOID or a type)
        Token returnType;
        if (match(TokenType.VOID))
        {
            returnType = previous();
            returnType.type = TokenType.VOID;
        }
        else if(match(TokenType.INTEGER, TokenType.FLOAT, TokenType.STRING, TokenType.BOOLEAN,TokenType.INTEGER_ARRAY, TokenType.FLOAT_ARRAY,TokenType.STRING_ARRAY, TokenType.BOOLEAN_ARRAY, TokenType.ALL, TokenType.LIST, TokenType.STREAM))
        {
            returnType = previous();
        }
        else
        {
            throw new RuntimeException("Expect return type after 'ফাংশন' or 'অস্থায়ী_ফাংশন'");
        }
    
        // Parse function name
        Token name = consume(TokenType.IDENTIFIER, "Expect function name.");
    
        // Parse parameters WITH DEFAULT VALUES SUPPORT
        consume(TokenType.LEFT_PAREN, "Expect '(' after function name.");
        List<Token> parameters = new Vector<>();
        List<Expr> defaultValues = new Vector<>(); // Store default values
        
        if (!check(TokenType.RIGHT_PAREN))
        {
            do
            {
                if (parameters.size() >= 30000)
                {
                    throw new RuntimeException("Can't have more than 30000 parameters.");
                }
    
                if (match(TokenType.INTEGER, TokenType.FLOAT, TokenType.STRING, TokenType.BOOLEAN,TokenType.INTEGER_ARRAY, TokenType.FLOAT_ARRAY,TokenType.STRING_ARRAY, TokenType.BOOLEAN_ARRAY, TokenType.ALL, TokenType.LIST, TokenType.STREAM))
                {
                    Token type = previous();
                    Token param = consume(TokenType.IDENTIFIER, "Expect parameter name.");
                    param.type = type.type;
                    
                    // Check for default value
                    Expr defaultValue = null;
                    if (match(TokenType.ASSIGN)) {
                        defaultValue = expression();
                    }
                    
                    parameters.add(param);
                    defaultValues.add(defaultValue);
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
    
        //Create function with default values
        return new Function(name, returnType, parameters, body, isTemporary, defaultValues);
    }


    private Stmt arrayDeclaration()
    {
    Token type = previous();
    Token name = consume(TokenType.IDENTIFIER, "Expect array name.");
    name.type = type.type;

    Expr size = null;
    List<Expr> initialValues = new Vector<>();
    boolean hasBrackets = false;

    // Handle array size if specified with brackets
    if (match(TokenType.LEFT_BRACKET))
    {
        hasBrackets = true;
        if (!check(TokenType.RIGHT_BRACKET))
        {
            size = expression();
        }
        consume(TokenType.RIGHT_BRACKET, "Expect ']' after array size.");
    }

    // Handle array initialization
    if (match(TokenType.ARROW))
    {
        // Check for আর্গুমেন্ট() function call
        if (match(TokenType.ARGUMENT))
        {
            consume(TokenType.LEFT_PAREN, "Expect '(' after 'আর্গুমেন্ট'");
            consume(TokenType.RIGHT_PAREN, "Expect ')' after 'আর্গুমেন্ট'");
            initialValues.add(new Call(new Variable(new Token(TokenType.IDENTIFIER, "আর্গুমেন্ট", null, previous().line)), Collections.emptyList()));
        }
        // Normal array initialization - either with or without braces
        else
        {
            // Check if next token is LEFT_BRACE (traditional initialization)
            if (check(TokenType.LEFT_BRACE))
            {
                consume(TokenType.LEFT_BRACE, "Expect '{' after '→'");
                if (!check(TokenType.RIGHT_BRACE))
                {
                    do
                    {
                        initialValues.add(expression());
                    } while (match(TokenType.COMMA));
                }
                consume(TokenType.RIGHT_BRACE, "Expect '}' after array initializers.");
            } 
            // No braces - single value initialization
            else
            {
                initialValues.add(expression());
            }
        }
    }
    else if (!hasBrackets)
    {
        // REQUIRE brackets for array declaration if no arrow initialization
        throw new RuntimeException("Array declaration must include size in brackets [] or use arrow initialization");
    }

    consume(TokenType.SEMICOLON, "Expect ';' after array declaration.");
    return new ArrayStmt(name, type.type, size, initialValues);
}

    private Stmt varDeclaration()
    {
        // Check for access modifiers in global scope (should not be allowed)
        if (match(TokenType.PRIVATE, TokenType.PUBLIC))
        {
            throw new RuntimeException("Access modifiers can only be used inside classes");
        }
        
        Token type = previous();
        Token name = consume(TokenType.IDENTIFIER, "Expect variable name");
        name.type = type.type;
        
        Expr initializer = null;
        
    if (type.type == TokenType.SET)
    {
        if (match(TokenType.ASSIGN))
        {
            // Check for set literal
            if (check(TokenType.HASH))
            {
                // Parse set literal: #1,2,3#
                consume(TokenType.HASH, "Expect '#' at start of set literal");
                
                List<Expr> elements = new Vector<>();
                // Parse elements until we see the closing #
                while (!check(TokenType.HASH) && !isAtEnd()) {
                    elements.add(expression());
                    if (!check(TokenType.HASH)) {
                        match(TokenType.COMMA); // Optional comma
                    }
                }
                
                // Consume the closing #
                consume(TokenType.HASH, "Expect '#' at end of set literal");
                
                initializer = new SetLiteral(elements);
            }
            else
            {
                // Regular expression assignment
                initializer = expression();
            }
        }
        else
        {
            // No initializer - create empty set
            initializer = new SetLiteral(new Vector<>());
        }
    }


        if (type.type == TokenType.STREAM)
        {
            if (match(TokenType.ASSIGN))
            {
                // Stream can be initialized from a list or another stream
                initializer = expression();
            }
            else
            {
                // No initializer - create empty stream
                initializer = new Literal(null);
            }
        }
    
        // Handle LIST type specifically
        if (type.type == TokenType.LIST)
        {
            if (match(TokenType.ASSIGN))
            {
                // Check for list literal
                if (check(TokenType.LEFT_BRACKET))
                {
                    // Parse the list literal but then check for method calls
                    match(TokenType.LEFT_BRACKET); // Consume the '['
                    List<Expr> elements = new Vector<>();
                    if (!check(TokenType.RIGHT_BRACKET))
                    {
                        do
                        {
                            elements.add(expression());
                        } while (match(TokenType.COMMA));
                    }
                    consume(TokenType.RIGHT_BRACKET, "Expect ']' after list elements");
                    
                    // Create list literal expression
                    Expr listExpr = new ListLiteral(elements);
                    
                    // Check if there are method calls after the list literal
                    if (check(TokenType.DOT) || check(TokenType.LIST_ACCESS)) {
                        // Parse method calls on the list literal
                        initializer = finishPrimary(listExpr);
                    } else {
                        // No method calls - just use the list literal
                        initializer = listExpr;
                    }
                }
                else
                {
                    // Regular expression assignment
                    initializer = expression();
                }
            }
            else
            {
                // No initializer - create empty list
                initializer = new ListLiteral(new Vector<>());
            }
        }
        else
        {
            // Existing logic for other types
            if (match(TokenType.ASSIGN))
            {
                if (match(TokenType.AT_SYMBOL))
                {
                    // Handle object creation: অবজেক্ট t = @className or অবজেক্ট t = @className(args);
                    Token classRef = consume(TokenType.IDENTIFIER, "Expect class name after '@'");
                    
                    List<Expr> arguments = new Vector<>();
                    // Check for constructor arguments
                    if (match(TokenType.LEFT_PAREN))
                    {
                        if (!check(TokenType.RIGHT_PAREN))
                        {
                            do
                            {
                                arguments.add(expression());
                            } while (match(TokenType.COMMA));
                        }
                        consume(TokenType.RIGHT_PAREN, "Expect ')' after constructor arguments");
                    }
                    
                    initializer = new ObjectExpr(classRef, arguments);
                } else
                {
                    initializer = expression();
                }
            }
            else
            {
                // No initializer provided - set default value based on type
                if (type.type == TokenType.OBJECT)
                {
                    // For objects, set default to null
                    initializer = new Literal(null);
                }
                // For other types, the existing logic in visitVarStmt will handle defaults
            }
        }
        
        consume(TokenType.SEMICOLON, "Expect ';' after variable declaration");
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
        if (match(TokenType.WRITE_FILE))return writeFileStatement();
        if (match(TokenType.FOR_EACH)) return forEachStatement();
        if (match(TokenType.NIRAPOD)) return safeScopeStatement();
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

    private Stmt safeScopeStatement()
    {
        consume(TokenType.LEFT_BRACE, "Expect '{' after 'নিরাপদ'");
        List<Stmt> statements = new Vector<>();
        
        while (!check(TokenType.RIGHT_BRACE) && !isAtEnd()) {
            statements.add(declaration());
        }
        
        consume(TokenType.RIGHT_BRACE, "Expect '}' after safe scope body");
        return new SafeScope(new Block(statements));
    }
    private Stmt forEachStatement()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'বের'");
        
        // Parse variable declaration: সব x or বাক্য x
        TokenType varType;
        if (match(TokenType.ALL, TokenType.INTEGER, TokenType.FLOAT, TokenType.STRING, TokenType.BOOLEAN))
        {
            varType = previous().type;
        }
        else
        {
            throw new RuntimeException("Expect variable type in foreach loop");
        }
        
        Token variable = consume(TokenType.IDENTIFIER, "Expect variable name");
        variable.type = varType;
        
        consume(TokenType.COLON, "Expect ':' after variable name");
        
        Expr collection = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after collection");
        
        Stmt body = statement();
        
        return new ForEach(variable, collection, body);
    }
    private Stmt writeFileStatement()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'লিখ'.");
        Expr fileHandle = expression();
        consume(TokenType.COMMA, "Expect ',' after file handle.");
        Expr content = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after content.");
        consume(TokenType.SEMICOLON, "Expect ';' after statement.");
        return new FileWriteStmt(fileHandle, content);
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
                
                // Handle file assignment: f = খোলো("path");
                if (value instanceof Call)
                {
                    Call call = (Call)value;
                    if (call.callee() instanceof Variable)
                    {
                        Variable callee = (Variable)call.callee();
                        if (callee.name().lexeme.equals("খোলো"))
                        {
                            // This is a file assignment
                            return new Binary(expr, equals, value);
                        }
                    }
                }
                
                // Handle object assignment: o = @NewClass;
                if (value instanceof ObjectExpr)
                {
                    return new Binary(expr, equals, value);
                }
                
                return new Binary(expr, equals, value);
            } 
            else if (expr instanceof ArrayAccess)
            {
                ArrayAccess access = (ArrayAccess)expr;
                return new ArrayAssignment(access.array(), access.index(), value);
            } 
            else if (expr instanceof DotExpr)
            {
                // Handle object field assignment: obj.v = value
                DotExpr dotExpr = (DotExpr)expr;
                return new Binary(expr, equals, value);
            }
            else if (expr instanceof ClassSelfExpr)
            {
                // Handle class self assignment: ক্লাসের(name) = value
                ClassSelfExpr selfExpr = (ClassSelfExpr)expr;
                return new ClassSelfAssignment(selfExpr.keyword(), value);
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
        Expr expr = null;
        
        if (match(TokenType.FALSE))
        {
            expr = new Literal(false);
        }
        else if (match(TokenType.TRUE))
        {
            expr = new Literal(true);
        }
        else if (match(TokenType.NIL))
        {
            expr = new Literal(null);
        }
        else if (match(TokenType.CLASS_SELF))
        {
            expr = classSelfExpr();
        }
        else if (match(TokenType.INCREASE_SIZE))
        {
            expr = increaseSizeCall();
        }
        else if (match(TokenType.OBJECT))
        {
            expr = objectCreation();
        }
        else if (match(TokenType.AT_SYMBOL))
        {
            expr = objectCreation();
        }
        else if (match(TokenType.GO_TO_START))
        {
            expr = goToStartCall();
        }
        else if (match(TokenType.DELETE_VAR))
        {
            expr = deleteVarCall();
        }
        else if (match(TokenType.HASH))
        {
         expr = parseSetLiteral();
        }
        else if (match(TokenType.FILE_CUT))
        {
            expr = fileCutCall();
        }
        else if (match(TokenType.FILE_COPY))
        {
            expr = fileCopyCall();
        }
        else if (match(TokenType.BINARY_READ)) {
            expr = binaryReadCall();
        }
        else if (match(TokenType.BINARY_WRITE)) {
            expr = binaryWriteCall();
        }
        else if (match(TokenType.FILE_SEEK)) {
            expr = fileSeekCall();
        }
        else if (match(TokenType.FILE_POSITION)) {
            expr = filePositionCall();
        }
        else if (match(TokenType.FILE_SIZE))
        {
            expr = fileSizeCall();
        }
      
        else if (match(TokenType.REGEX))
        {
            expr = regexCall();
        }
        else if (match(TokenType.REGEX_FIND))
        {
            expr = regexFindCall();
        }
        else if (match(TokenType.REGEX_FIND_ALL))
        {
            expr = regexFindAllCall();
        }
        else if (match(TokenType.REGEX_REPLACE))
        {
            expr = regexReplaceCall();
        }
        else if (match(TokenType.REGEX_SPLIT))
        {
            expr = regexSplitCall();
        }
        else if (match(TokenType.INTEGER, TokenType.FLOAT, TokenType.STRING, TokenType.BOOLEAN, TokenType.LIST, TokenType.OBJECT, TokenType.FILE, TokenType.STREAM, TokenType.ALL))
          {
                    // This is a type token like পূর্ণসংখ্যা, ভগ্নাংশ, etc.
                    Token typeToken = previous();
                    return new Literal(typeToken.type);  // Return the TokenType as literal value
           }
        else if (match(TokenType.BANDH))
        {
            expr = bandhCall();
        }
        else if (match(TokenType.READ_FILE))
        {
            consume(TokenType.LEFT_PAREN, "Expect '(' after 'পড়'.");
            Expr fileHandle = expression();
            
            List<Expr> arguments = new Vector<>();
            if (match(TokenType.COMMA))
            {
                // First argument
                arguments.add(expression());
                if (match(TokenType.COMMA))
                {
                    // Second argument
                    arguments.add(expression());
                }
            }
            consume(TokenType.RIGHT_PAREN, "Expect ')' after arguments.");
            expr = new FileReadExpr(fileHandle, arguments);
        }
        else if (match(TokenType.CLOSE_FILE))
        {
            expr = closeFilesCall();
        }
        else if (match(TokenType.OPEN_FILE))
        {
            expr = openFileCall();
        }
        else if (match(TokenType.DELETE_FILE))
        {
            expr = deleteFilesCall();
        }
        // LIST LITERAL PARSING
        else if (match(TokenType.LEFT_BRACKET))
        {
            expr = parseListLiteral();
        }
        else if (match(TokenType.INTEGER_LITERAL, TokenType.FLOAT_LITERAL, TokenType.STRING_LITERAL))
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
            expr = new Literal(value);
        }
        else if (match(TokenType.TO_INT, TokenType.TO_FLOAT, TokenType.TO_STRING, TokenType.TO_BOOLEAN))
        {
            Token operator = previous();
            consume(TokenType.LEFT_PAREN, "Expect '(' after conversion function");
            Expr value = expression();
            consume(TokenType.RIGHT_PAREN, "Expect ')' after value");
            expr = new Unary(operator, value);
        }
        else if (match(TokenType.ARRAY_SIZE))
        {
            consume(TokenType.LEFT_PAREN, "Expect '(' after 'অ্যারের_আকার'");
            Expr array = expression();
            consume(TokenType.RIGHT_PAREN, "Expect ')' after array expression");
            expr = new ArraySize(array);
        }
        else if (match(TokenType.DATATYPE))
        {
            expr = datatypeCall();
        }
        else if (match(TokenType.BINARY_SEARCH))
        {
            expr = binarySearchCall();
        }
        else if (match(TokenType.BUBBLE_SORT))
        {
            expr = bubbleSortCall();
        }
        else if (match(TokenType.QUICK_SORT))
        {
            expr = quickSortCall();
        }
        else if (match(TokenType.IDENTIFIER))
        {
            Token name = previous();
            // Handle function calls
            if (match(TokenType.LEFT_PAREN))
            {
                expr = finishCall(new Variable(name));
            } 
            // Check for array/list access with comma-separated indices
            else if (match(TokenType.LEFT_BRACKET))
            {
                // Parse first index
                Expr firstIndex = expression();
                List<Expr> indices = new Vector<>();
                indices.add(firstIndex);
                
                // Parse additional indices separated by commas
                while (match(TokenType.COMMA))
                {
                    indices.add(expression());
                }
                
                consume(TokenType.RIGHT_BRACKET, "Expect ']' after indices.");
                
                if (indices.size() == 1)
                {
                    // Single index - use existing ArrayAccess for backwards compatibility
                    expr = new ArrayAccess(new Variable(name), indices.get(0));
                }
                else
                {
                    // Multiple indices - use new MultiDimAccess
                    expr = new MultiDimAccess(new Variable(name), indices);
                }
                
                // Allow chaining with ¥ for mixed syntax
                while (match(TokenType.LIST_ACCESS))
                {
                    if (match(TokenType.LEFT_BRACKET))
                    {
                        Expr nextIndex = expression();
                        consume(TokenType.RIGHT_BRACKET, "Expect ']' after list index.");
                        expr = new ListAccess(expr, nextIndex);
                    }
                    else
                    {
                        throw new RuntimeException("Expect '[' after '¥'");
                    }
                }
            } else
            {
                expr = new Variable(name);
            }
        }
        else if (match(TokenType.LEFT_PAREN))
        {
            Expr innerExpr = expression();
            consume(TokenType.RIGHT_PAREN, "Expect ')' after expression.");
            expr = new Grouping(innerExpr);
        }
        else
        {
            throw new RuntimeException("Expect expression.");
        }
        
        // Now process dot operators and method calls
        return finishPrimary(expr);
    }
    
    private Expr parseSetLiteral() {
        List<Expr> elements = new Vector<>();
        
        // Parse elements until we see the closing #
        while (!check(TokenType.HASH) && !isAtEnd()) {
            elements.add(expression());
            if (!check(TokenType.HASH)) {
                match(TokenType.COMMA); // Optional comma
            }
        }
        
        // Consume the closing #
        consume(TokenType.HASH, "Expect '#' after set elements");
        return new SetLiteral(elements);
    }
        
    // Binary read: বাইনারি_পড়(fileHandle, [bytes])
    private Expr binaryReadCall() {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'বাইনারি_পড়'");
        Expr fileHandle = expression();
        Expr bytesToRead = null;
        if (match(TokenType.COMMA)) {
            bytesToRead = expression();
        }
        consume(TokenType.RIGHT_PAREN, "Expect ')' after arguments");
        return new BinaryReadExpr(fileHandle, bytesToRead);
    }
    
    // Binary write: বাইনারি_লিখ(fileHandle, data, [offset, length])
    private Expr binaryWriteCall() {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'বাইনারি_লিখ'");
        Expr fileHandle = expression();
        consume(TokenType.COMMA, "Expect ',' after file handle");
        Expr data = expression();
        Expr offset = null;
        Expr length = null;
        if (match(TokenType.COMMA)) {
            offset = expression();
            consume(TokenType.COMMA, "Expect ',' after offset");
            length = expression();
        }
        consume(TokenType.RIGHT_PAREN, "Expect ')' after arguments");
        return new BinaryWriteExpr(fileHandle, data, offset, length);
    }
    
    // File seek: ফাইল_সিক(fileHandle, position)
    private Expr fileSeekCall() {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'ফাইল_সিক'");
        Expr fileHandle = expression();
        consume(TokenType.COMMA, "Expect ',' after file handle");
        Expr position = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after arguments");
        return new FileSeekExpr(fileHandle, position);
    }
    
    // File position: ফাইল_অবস্থান(fileHandle)
    private Expr filePositionCall() {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'ফাইল_অবস্থান'");
        Expr fileHandle = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after file handle");
        return new FilePositionExpr(fileHandle);
    }
    
    // File size: ফাইল_আকার(fileHandle)
    private Expr fileSizeCall() {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'ফাইল_আকার'");
        Expr fileHandle = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after file handle");
        return new FileSizeExpr(fileHandle);
    }
        
    private Expr parseListLiteral()
    {
        List<Expr> elements = new Vector<>();
        
        if (!check(TokenType.RIGHT_BRACKET))
        {
            do
            {
                elements.add(expression());
            } while (match(TokenType.COMMA));
        }
        
        consume(TokenType.RIGHT_BRACKET, "Expect ']' after list elements.");
        return new ListLiteral(elements);
    }
    private Expr objectCreation()
    {
        // If we're coming from AT_SYMBOL case, we already consumed '@'
        // If we're coming from OBJECT case, we need to consume '@'
        if (previous().type != TokenType.AT_SYMBOL)
        {
            consume(TokenType.AT_SYMBOL, "Expect '@' before class name");
        }
        
        Token classRef = consume(TokenType.IDENTIFIER, "Expect class name after '@'");
        
        List<Expr> arguments = new Vector<>();
        
        // Check for constructor arguments
        if (match(TokenType.LEFT_PAREN))
        {
            if (!check(TokenType.RIGHT_PAREN))
            {
                do
                {
                    if (arguments.size() >= 255)
                    {
                        throw new RuntimeException("Can't have more than 255 arguments");
                    }
                    arguments.add(expression());
                } while (match(TokenType.COMMA));
            }
            consume(TokenType.RIGHT_PAREN, "Expect ')' after constructor arguments");
        }
        
        return new ObjectExpr(classRef, arguments);
    }
        // Method to handle dot expressions after primary expressions
    private Expr finishPrimary(Expr expr)
    {
        while (true)
        {
            if (match(TokenType.DOT))
            {
                // Allow identifiers AND file operation keywords as method names
                Token name;
                if (check(TokenType.IDENTIFIER)) {
                    name = advance();
                }
                // Allow file operation keywords as method names
               else if (match(TokenType.WRITE_FILE,TokenType.READ_FILE,TokenType.CLOSE_FILE,TokenType.DELETE_FILE, TokenType.OPEN_FILE,TokenType.BINARY_READ,TokenType.BINARY_WRITE, TokenType.FILE_SEEK)) {
                    name = previous();
                }
                else {
                    throw new RuntimeException("Expect property name after '.'.");
                }
    
                // Check if it's a method call
                if (match(TokenType.LEFT_PAREN))
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
                    
                    // For method calls, use ListMethodCall to support both lists and classes
                
                    expr = new ListMethodCall(expr, name, arguments);
                } else
                {
                    // For property access WITHOUT parentheses, use DotExpr (for assignment compatibility)
                    expr = new DotExpr(expr, name);
                }
            }
            // LIST ACCESS HANDLING
            else if (match(TokenType.LIST_ACCESS))
            {
                if (match(TokenType.LEFT_BRACKET))
                {
                    Expr index = expression();
                    consume(TokenType.RIGHT_BRACKET, "Expect ']' after list index.");
                    expr = new ListAccess(expr, index);
                    
                    // DON'T allow immediate chaining of ¥ after another ¥
                    break;
                }
                else
                {
                    throw new RuntimeException("Expect '[' after '¥'");
                }
            }
            // ARRAY ACCESS HANDLING FOR CHAINING
            else if (match(TokenType.LEFT_BRACKET))
            {
                Expr index = expression();
                consume(TokenType.RIGHT_BRACKET, "Expect ']' after array index.");
                expr = new ArrayAccess(expr, index);
                
                while (match(TokenType.LIST_ACCESS))
                {
                    if (match(TokenType.LEFT_BRACKET))
                    {
                        Expr nextIndex = expression();
                        consume(TokenType.RIGHT_PAREN, "Expect ']' after list index.");
                        expr = new ListAccess(expr, nextIndex);
                    }
                    else
                    {
                        throw new RuntimeException("Expect '[' after '¥'");
                    }
                }
            }
            else
            {
                break;
            }
        }
        return expr;
    }
        
    private Expr classSelfExpr()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'ক্লাসের'");
        
        Token identifier = consume(TokenType.IDENTIFIER, "Expect field or method name after 'ক্লাসের('");
        
        // Check if this is an array access: ক্লাসের(arrayName[index])
        if (match(TokenType.LEFT_BRACKET))
        {
            // It's an array access: ক্লাসের(arrayName[index])
            Expr index = expression();
            consume(TokenType.RIGHT_BRACKET, "Expect ']' after array index");
            consume(TokenType.RIGHT_PAREN, "Expect ')' after 'ক্লাসের'");
            
            // For array access, we still need to validate the array field exists
            // This will be handled in visitArrayAccessExpr when it encounters ClassSelfExpr
            
            return new ArrayAccess(new ClassSelfExpr(identifier), index);
        }
        // Check if this is a method call (has parentheses after identifier)
        else if (match(TokenType.LEFT_PAREN))
        {
            // It's a method call: ক্লাসের(methodName(args))
            List<Expr> arguments = new Vector<>();
            if (!check(TokenType.RIGHT_PAREN))
            {
                do
                {
                    if (arguments.size() >= 255)
                    {
                        throw new RuntimeException("Can't have more than 255 arguments");
                    }
                    arguments.add(expression());
                } while (match(TokenType.COMMA));
            }
            consume(TokenType.RIGHT_PAREN, "Expect ')' after method arguments");
            consume(TokenType.RIGHT_PAREN, "Expect ')' after 'ক্লাসের'");
            
            return new ClassSelfMethodCall(identifier, arguments);
        }
        else
        {
            // It's a field access: ক্লাসের(fieldName)
            consume(TokenType.RIGHT_PAREN, "Expect ')' after field name");
            return new ClassSelfExpr(identifier);
        }
    }
    private Expr regexFindCall()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'রেজেক্স_খুঁজ'");
        Expr sourceString = expression();
        consume(TokenType.COMMA, "Expect ',' after argument");
        Expr regexString = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after argument");
        return new RegexFindExpr(sourceString, regexString);
    }
    
    private Expr regexFindAllCall()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'রেজেক্স_সব_খুঁজ'");
        Expr sourceString = expression();
        consume(TokenType.COMMA, "Expect ',' after argument");
        Expr regexString = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after argument");
        return new RegexFindAllExpr(sourceString, regexString);
    }
    
    private Expr regexReplaceCall()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'রেজেক্স_বদল'");
        Expr sourceString = expression();
        consume(TokenType.COMMA, "Expect ',' after argument");
        Expr regexString = expression();
        consume(TokenType.COMMA, "Expect ',' after regex");
        Expr replacement = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after argument");
        return new RegexReplaceExpr(sourceString, regexString, replacement);
    }
    
    private Expr regexSplitCall()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'রেজেক্স_বিভক্ত'");
        Expr sourceString = expression();
        consume(TokenType.COMMA, "Expect ',' after argument");
        Expr regexString = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after argument");
        return new RegexSplitExpr(sourceString, regexString);
    }
    
    
    private Expr fileCutCall()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'ফাইল_কাট'");
        Expr sourcePath = expression();
        consume(TokenType.COMMA, "Expect ',' after source path");
        Expr destPath = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after destination path");
        return new FileCutExpr(sourcePath, destPath);
    }
    
    private Expr fileCopyCall()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'ফাইল_কপি'");
        Expr sourcePath = expression();
        consume(TokenType.COMMA, "Expect ',' after source path");
        Expr destPath = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after destination path");
        return new FileCopyExpr(sourcePath, destPath);
    }
    
    private Expr regexCall()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'রেজেক্স'");
        Expr sourceString = expression();
        consume(TokenType.COMMA, "Expect ',' after argument");
        Expr regexString = expression();
        consume(TokenType.RIGHT_PAREN, "Expect ')' after argument");
        return new RegexExpr(sourceString, regexString);
    }

    private Expr openFileCall()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'খোলো'.");
        Expr path = expression();
        
        List<Expr> arguments = new Vector<>();
        arguments.add(path);
        
        // Handle optional mode parameter
        if (match(TokenType.COMMA))
        {
            Expr modeExpr = expression();
            arguments.add(modeExpr);
        }
        
        consume(TokenType.RIGHT_PAREN, "Expect ')' after file parameters.");
        
        // Create a call expression for খোলো
        return new Call(new Variable(new Token(TokenType.IDENTIFIER, "খোলো", null, previous().line)), arguments);
    }

    private Expr closeFilesCall()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'ফাইল_বন্ধ'.");
        
        List<Expr> fileHandles = new Vector<>();
        if (!check(TokenType.RIGHT_PAREN))
        {
            do
            {
                fileHandles.add(expression());
            } while (match(TokenType.COMMA));
        }
        
        consume(TokenType.RIGHT_PAREN, "Expect ')' after arguments.");
        return new CloseFilesExpr(fileHandles);
    }
    private Expr deleteFilesCall()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'ফাইল_মুছ'.");
        
        List<Expr> fileHandles = new Vector<>();
        if (!check(TokenType.RIGHT_PAREN))
        {
            do
            {
                fileHandles.add(expression());
            } while (match(TokenType.COMMA));
        }
        
        consume(TokenType.RIGHT_PAREN, "Expect ')' after arguments.");
        return new DeleteFilesExpr(fileHandles);
    }

    private Expr datatypeCall()
    {
        consume(TokenType.LEFT_PAREN, "Expect '(' after 'ধরণ'");
        
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
        
        consume(TokenType.RIGHT_PAREN, "Expect ')' after arguments");
        
        return new Call(new Variable(new Token(TokenType.IDENTIFIER, "ধরণ", null, previous().line)),
                       arguments);
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
    // I made all LinkedHashMap thread safe for future use.
    public final Map<String, Object> values = Collections.synchronizedMap(new LinkedHashMap<>());
    public final Map<String, Object[]> arrays = Collections.synchronizedMap(new LinkedHashMap<>());
    public final Map<String, Function> functions = Collections.synchronizedMap(new LinkedHashMap<>());
    public final Map<String, TokenType> arrayTypes = Collections.synchronizedMap(new LinkedHashMap<>());
    public final Map<String, Boolean> unlimitedArrays = Collections.synchronizedMap(new LinkedHashMap<>());
    public final Map<String, TokenType> variableTypes = Collections.synchronizedMap(new LinkedHashMap<>());

    Environment()
    {
        enclosing = null;
    }

    Environment(Environment enclosing)
    {
        this.enclosing = enclosing;
    }
    void defineArray(String name, TokenType type, Object[] array, boolean isUnlimited)
    {
        arrays.put(name, array);
        arrayTypes.put(name, type);
        if (isUnlimited)
        {
            unlimitedArrays.put(name, true);
        }
    }

    boolean isArrayUnlimited(String name)
    {
        if (unlimitedArrays.containsKey(name))
        {
            return unlimitedArrays.get(name);
        }
        if (enclosing != null) return enclosing.isArrayUnlimited(name);
        return false;
    }

    void assignArray(Token name, Object[] array)
    {
        if (arrays.containsKey(name.lexeme))
         {
            arrays.put(name.lexeme, array);
            return;
        }
        if (enclosing != null)
        {
            enclosing.assignArray(name, array);
            return;
        }
        throw new RuntimeException("Undefined array '" + name.lexeme + "'");
    }

    void defineFunction(String name, Function function)
    {
        functions.put(name, function);
    }

    void defineVariableType(String name, TokenType type)
    {
        variableTypes.put(name, type);
    }

    //  method to get variable type
    TokenType getVariableType(String name)
    {
        if (variableTypes.containsKey(name))
        {
            return variableTypes.get(name);
        }
        if (enclosing != null) return enclosing.getVariableType(name);
        return null;
    }

    //  method to delete variable type
    void deleteVariableType(String name)
    {
        variableTypes.remove(name);
        if (enclosing != null) enclosing.deleteVariableType(name);
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
    
        // Copy variable types
        copy.variableTypes.putAll(this.variableTypes);
    
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
            variableTypes.remove(name.lexeme);
            return;
        }
        if (arrays.containsKey(name.lexeme))
        {
            arrays.remove(name.lexeme);
            arrayTypes.remove(name.lexeme);
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
    public GoToStartException(){}
}
class ClearScreenException extends RuntimeException
{
    public ClearScreenException(){}
}
class BreakException extends RuntimeException{}
class ContinueException extends RuntimeException{}
class ClassDefinition
{
    public final String name;
    public final Map<String, Function> methods;
    private final Map<String, Boolean> methodAccess; // true = public, false = private
    public final Map<String, TokenType> fieldTypes;
    private final Map<String, Boolean> fieldAccess; // true = public, false = private

    private final String classHash;

    public ClassDefinition(String name, Map<String, Function> methods, Map<String, TokenType> fieldTypes,
                          Map<String, Boolean> methodAccess, Map<String, Boolean> fieldAccess)
    {
        this.name = name;
        this.methods = methods != null ? methods : new LinkedHashMap<>();
        this.fieldTypes = fieldTypes != null ? fieldTypes : new LinkedHashMap<>();
        this.methodAccess = methodAccess != null ? methodAccess : new LinkedHashMap<>();
        this.fieldAccess = fieldAccess != null ? fieldAccess : new LinkedHashMap<>();
        this.classHash = generateClassHash();
    }

    private String generateClassHash() {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            
            // Add class name
            digest.update(name.getBytes());
            
            // Add method information
            List<String> methodNames = new Vector<>(methods.keySet());
            Collections.sort(methodNames);
            for (String methodName : methodNames) {
                digest.update(methodName.getBytes());
                Function method = methods.get(methodName);
                
                // Add method parameter types
                for (Token param : method.parameters()) {
                    digest.update(param.type.name().getBytes());
                }
                
                // Add return type
                if (method.returnType() != null) {
                    digest.update(method.returnType().type.name().getBytes());
                }
                
                // Add access modifier
                digest.update((methodAccess.getOrDefault(methodName, true) ? "public" : "private").getBytes());
            }
            
            // Add field information
            List<String> fieldNames = new Vector<>(fieldTypes.keySet());
            Collections.sort(fieldNames);
            for (String fieldName : fieldNames) {
                digest.update(fieldName.getBytes());
                digest.update(fieldTypes.get(fieldName).name().getBytes());
                digest.update((fieldAccess.getOrDefault(fieldName, true) ? "public" : "private").getBytes());
            }
            
            // Generate hash and encode as Base64
            byte[] hashBytes = digest.digest();
            return Base64.getEncoder().encodeToString(hashBytes);
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-512 algorithm not available");
        }
    }

    public String getClassHash() {
        return classHash;
    }
    

    
    public Function findMethod(String name)
    {
        return methods.get(name);
    } 
    
    public TokenType getFieldType(String name)
    {
        return fieldTypes.get(name);
    }
    
    public boolean isMethodPublic(String name)
    {
        return methodAccess.getOrDefault(name, true); // Default to public
    }

    public boolean isFieldPublic(String name)
    {
        return fieldAccess.getOrDefault(name, true); // Default to public
    }

    public boolean hasMethod(String name)
    {
        return methods.containsKey(name);
    }
    
    public boolean hasField(String name)
    {
        return fieldTypes.containsKey(name);
    }
    public boolean hasConstructor()
    {
        return methods.containsKey("constructor");
    }
    
    public boolean hasConstructorWithParams(int paramCount)
    {
        Function constructor = methods.get("constructor");
        return constructor != null && constructor.parameters().size() == paramCount;
    }
    
    @Override
    public String toString()
    {
        return "<class " + name + ">";
    }
}

class ClassInstance
{
    private final ClassDefinition klass;
    private final Map<String, Object> fields;
    private final long creationTimeNanos;
    private final String creationTimestamp;
    private final String objectHash;
    private final Interpreter interpreter; //Added it to get file objects
    
    public ClassInstance(ClassDefinition klass, Map<String, Object> initialFieldValues, Interpreter interpreter)
    {
        this.klass = klass;
        this.fields = new LinkedHashMap<>();
        this.creationTimeNanos = System.nanoTime();
        this.creationTimestamp = formatCreationTime();
        this.objectHash = generateObjectHash(initialFieldValues);
        this.interpreter = interpreter;
        // Initialize fields with values from class definition
        for (Map.Entry<String, TokenType> fieldEntry : klass.fieldTypes.entrySet())
        {
            String fieldName = fieldEntry.getKey();
            TokenType fieldType = fieldEntry.getValue();
            
            // Use initial value if provided, otherwise use default
            if (initialFieldValues != null && initialFieldValues.containsKey(fieldName))
            {
                Object value = initialFieldValues.get(fieldName);
                // Ensure the value matches the field type
                fields.put(fieldName, convertToType(value, fieldType));
            } else
            {
                fields.put(fieldName, getDefaultValue(fieldType));
            }
        }
    }


    private String generateObjectHash(Map<String, Object> initialFieldValues) {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            
            // Add class hash
            digest.update(klass.getClassHash().getBytes());
            
            // Add field values information
            List<String> fieldNames = new Vector<>(fields.keySet());
            Collections.sort(fieldNames);
            for (String fieldName : fieldNames)
            {
                digest.update(fieldName.getBytes());
                Object value = fields.get(fieldName);
                if (value != null)
                {
                    // Add value type and string representation
                    digest.update(value.getClass().getSimpleName().getBytes());
                    digest.update(stringifyValueForHash(value).getBytes());
                } else {
                    digest.update("null".getBytes());
                }
            }
            
            // Add initial field values if any
            if (initialFieldValues != null)
            {
                List<String> initialFieldNames = new Vector<>(initialFieldValues.keySet());
                Collections.sort(initialFieldNames);
                for (String fieldName : initialFieldNames)
                {
                    digest.update(fieldName.getBytes());
                    Object value = initialFieldValues.get(fieldName);
                    if (value != null)
                    {
                        digest.update(value.getClass().getSimpleName().getBytes());
                        digest.update(stringifyValueForHash(value).getBytes());
                    } else {
                        digest.update("null".getBytes());
                    }
                }
            }
            
            // Generate hash and encode as Base64
            byte[] hashBytes = digest.digest();
            return Base64.getEncoder().encodeToString(hashBytes).substring(0, 16); // Use first 16 chars for readability
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-512 algorithm not available");
        }
    }

    private String stringifyValueForHash(Object value)
    {
        if (value == null) return "null";
        if (value instanceof BigDecimal) {
            return ((BigDecimal)value).toPlainString();
        }
        if (value instanceof String) {
            return (String)value;
        }
        if (value instanceof Boolean) {
            return value.toString();
        }
        if (value instanceof KalpanaList) {
            return "list_size:" + ((KalpanaList)value).size();
        }
        if (value instanceof Object[])
        {
            return "array_size:" + ((Object[])value).length;
        }
        if (value instanceof ClassInstance)
        {
            return "object:" + ((ClassInstance)value).getClassName();
        }
        return value.toString();
    }

    public String getObjectHash()
    {
        return objectHash;
    }

    public boolean equals(Object other)
    {
        if (this == other) return true;
        if (!(other instanceof ClassInstance)) return false;
        ClassInstance otherInstance = (ClassInstance) other;
        return this.objectHash.equals(otherInstance.objectHash);
    }

    public int hashCode()
    {
        return objectHash.hashCode();
    }

    private String formatCreationTime()
    {
        Instant now = Instant.now();
        LocalDateTime dateTime = LocalDateTime.ofInstant(now, ZoneId.systemDefault());
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String timePart = dateTime.format(formatter);
        
        int nanoseconds = now.getNano();
        String nanoPart = String.format("%09d", nanoseconds);
        
        return timePart + "." + nanoPart;
    }
    
    public boolean isAlive()
    {
        return true; // Since we're referencing it, it's alive
    }
    
    public long getAgeInNanoseconds()
    {
        return System.nanoTime() - creationTimeNanos;
    }
    
    public String getAgeReadable()
    {
        long ageNanos = getAgeInNanoseconds();
        
        if (ageNanos < 1_000)
        {
            return ageNanos + " nanoseconds";
        }
        else if (ageNanos < 1_000_000)
        {
            return (ageNanos / 1_000) + " microseconds";
        }
        else if (ageNanos < 1_000_000_000)
        {
            return (ageNanos / 1_000_000) + " milliseconds";
        }
        else
        {
            double seconds = ageNanos / 1_000_000_000.0;
            return String.format("%.3f seconds", seconds);
        }
    }
    
    private long estimateMemoryUsage()
    {
        long size = 0;
        
        // Estimate memory for each field
        for (Map.Entry<String, Object> entry : fields.entrySet())
        {
            // Field name overhead
            size += entry.getKey().length() * 2L;
            
            Object value = entry.getValue();
            if (value instanceof String)
            {
                size += ((String)value).length() * 2L + 16; // String overhead
            }
            else if (value instanceof BigDecimal)
            {
                size += 32; // BigDecimal size
            }
            else if (value instanceof Boolean)
            {
                size += 16; // Boolean object size
            }
            else if (value instanceof Object[])
            {
                Object[] array = (Object[])value;
                size += 16; // Array header
                for (Object element : array)
                {
                    if (element instanceof String)
                    {
                        size += ((String)element).length() * 2L + 16;
                    }
                    else if (element instanceof BigDecimal)
                    {
                        size += 32;
                    }
                    else if (element instanceof Boolean)
                    {
                        size += 16;
                    }
                    else
                    {
                        size += 16; // Default object size
                    }
                }
            }
            else if (value == null)
            {
                size += 8; // Null reference
            }
            else
            {
                size += 16; // Default object size
            }
        }
        
        size += 64; // ClassInstance base overhead
        size += klass.name.length() * 2L; // Class name
        
        return Math.max(16, size); // Minimum object size
    }
    
    private String formatMemory(long bytes)
    {
        if (bytes < 1024)
        {
            return bytes + " bytes";
        }
        else if (bytes < 1024 * 1024)
        {
            double kb = bytes / 1024.0;
            return String.format("%.1f KB", kb);
        }
        else
        {
            double mb = bytes / (1024.0 * 1024.0);
            return String.format("%.1f MB", mb);
        }
    }
    
    private Object getDefaultValue(TokenType type)
    {
        switch (type)
        {
            case INTEGER:
                return BigDecimal.ZERO;
            case FLOAT:
                return new BigDecimal("0.0");
            case STRING:
                return "";
            case BOOLEAN:
                return false;
            default:
                return null;
        }
    }
    
    // I made this method public and static so it can be used elsewhere.
    public static Object convertToType(Object value, TokenType expectedType)
    {
        if (value == null) return getDefaultValueStatic(expectedType);
        
        // Handle array types
        if (expectedType == TokenType.INTEGER_ARRAY || 
            expectedType == TokenType.FLOAT_ARRAY || 
            expectedType == TokenType.STRING_ARRAY || 
            expectedType == TokenType.BOOLEAN_ARRAY)
        {
            if (!(value instanceof Object[]))
            {
                throw new RuntimeException("Expected array type for " + expectedType);
            }
            return value; // Arrays are passed as-is for now
        }
        
        // Handle scalar types
        switch (expectedType)
        {
            case INTEGER:
                if (value instanceof BigDecimal)
                {
                    return ((BigDecimal)value).setScale(0, RoundingMode.DOWN);
                } else if (value instanceof Number)
                {
                    return new BigDecimal(value.toString()).setScale(0, RoundingMode.DOWN);
                } else if (value instanceof String)
                {
                    try
                    {
                        return new BigDecimal((String)value).setScale(0, RoundingMode.DOWN);
                    } catch (NumberFormatException e)
                    {
                        return getDefaultValueStatic(expectedType);
                    }
                }
                break;
                
            case FLOAT:
                if (value instanceof BigDecimal)
                {
                    return value;
                } else if (value instanceof Number)
                {
                    return new BigDecimal(value.toString());
                } else if (value instanceof String)
                {
                    try
                    {
                        return new BigDecimal((String)value);
                    } catch (NumberFormatException e)
                    {
                        return getDefaultValueStatic(expectedType);
                    }
                }
                break;
                
            case STRING:
                return value.toString();
                
            case BOOLEAN:
                if (value instanceof Boolean)
                {
                    return value;
                } else if (value instanceof BigDecimal)
                {
                    return !((BigDecimal)value).equals(BigDecimal.ZERO);
                } else if (value instanceof Number)
                {
                    return ((Number)value).doubleValue() != 0;
                } else if (value instanceof String)
                {
                    String str = ((String)value).toLowerCase();
                    return str.equals("true") || str.equals("সত্য");
                }
                break;
        }
        
        return value; // Return as-is if conversion fails
    }
    
    // Helper method for the static convertToType
    private static Object getDefaultValueStatic(TokenType type)
    {
        switch (type)
        {
            case INTEGER:
                return BigDecimal.ZERO;
            case FLOAT:
                return new BigDecimal("0.0");
            case STRING:
                return "";
            case BOOLEAN:
                return false;
            default:
                return null;
        }
    }
    
    public Object get(Token name)
    {
        String fieldName = name.lexeme;
        
        // First check instance fields
        if (fields.containsKey(fieldName))
        {
            return fields.get(fieldName);
        }
        
        // Then check methods
        Function method = klass.findMethod(fieldName);
        if (method != null)
        {
            // Create a new function with 'this' bound to the current instance
            Function boundMethod = method.bind(this);
            
            // Also make sure the bound method has access to the class environment
            Environment methodEnv = new Environment(boundMethod.environment());
            
            // Set up parameter names in the environment (with null values for now)
            for (Token param : boundMethod.parameters())
            {
                methodEnv.define(param.lexeme, null);
            }
            
            // Return a new function with the updated environment
            return new Function(boundMethod.name(), boundMethod.returnType(), 
                              boundMethod.parameters(), boundMethod.body(), 
                              boundMethod.isTemporary(), methodEnv);
        }
        
        throw new RuntimeException("Undefined property '" + fieldName + "' in class '" + klass.name + "'");
    }
    
    public void set(Token name, Object value)
    {
        String fieldName = name.lexeme;
        
        // Type checking for field assignment
        if (klass.hasField(fieldName))
        {
            TokenType expectedType = klass.getFieldType(fieldName);
            value = convertToType(value, expectedType);
        }
        
        fields.put(fieldName, value);
    }
    
    public ClassDefinition getClassDefinition()
    {
        return klass;
    }

    public String getClassName()
    {
        return klass.name;
    }


    public String getDetailedMetadata()
    {
        long memoryBytes = estimateMemoryUsage();
        String memory = formatMemory(memoryBytes);
        String status = isAlive() ? "active" : "inactive";
        String age = getAgeReadable();
        
        // Count fields by declared type only (including uninitialized)
        int intFields = 0, floatFields = 0, stringFields = 0, boolFields = 0;
        int listFields = 0, arrayFields = 0, objectFields = 0, fileFields = 0;
        
        for (TokenType declaredType : klass.fieldTypes.values())
        {
            switch (declaredType)
            {
                case INTEGER:
                    intFields++;
                    break;
                case FLOAT:
                    floatFields++;
                    break;
                case STRING:
                    stringFields++;
                    break;
                case BOOLEAN:
                    boolFields++;
                    break;
                case LIST:
                    listFields++;
                    break;
                case INTEGER_ARRAY:
                case FLOAT_ARRAY:
                case STRING_ARRAY:
                case BOOLEAN_ARRAY:
                    arrayFields++;
                    break;
                case OBJECT:
                    objectFields++;
                    break;
                case FILE:
                    fileFields++; // This will count FILE type even if uninitialized
                    break;
                case ALL:
                    stringFields++; // Default to string for ALL type
                    break;
            }
        }
        
        StringBuilder metadata = new StringBuilder();
        metadata.append(klass.name).append(" object [");
        metadata.append("created: ").append(creationTimestamp).append(", ");
        metadata.append("age: ").append(age).append(", ");
        metadata.append("status: ").append(status).append(", ");
        metadata.append("memory: ").append(memory).append(", ");
        metadata.append("fields: {int:").append(intFields);
        metadata.append(", float:").append(floatFields);
        metadata.append(", string:").append(stringFields);
        metadata.append(", bool:").append(boolFields);
        metadata.append(", list:").append(listFields);
        metadata.append(", array:").append(arrayFields);
        metadata.append(", object:").append(objectFields);
        metadata.append(", file:").append(fileFields).append("}, ");
        metadata.append("methods: ").append(klass.methods.size()).append(", ");
        metadata.append("hash: ").append(objectHash).append("]");
        
        return metadata.toString();
    }
    
    @Override
    public String toString()
    {
        return getDetailedMetadata();
    }

    
/*
    @Override
    public String toString()
    {
        String status = isAlive() ? "active" : "inactive";
        String age = getAgeReadable();
        long memoryBytes = estimateMemoryUsage();
        String memory = formatMemory(memoryBytes);
        
        return klass.name + " object [created: " + creationTimestamp + 
               ", age: " + age + 
               ", status: " + status + 
               ", memory: " + memory + "]";
    }
*/

}

// Stream Operation Base Class
abstract class StreamOperation {
    protected Interpreter interpreter;
    
    StreamOperation(Interpreter interpreter) {
        this.interpreter = interpreter;
    }
    
    abstract KalpanaList execute(KalpanaList list);
}

// Filter Operation
class FilterOperation extends StreamOperation {
    private final String predicate;
    private final Function functionRef;
    
    FilterOperation(String predicate, Interpreter interpreter) {
        super(interpreter);
        this.predicate = predicate;
        this.functionRef = null;
    }
    
    FilterOperation(Function functionRef, Interpreter interpreter) {
        super(interpreter);
        this.predicate = null;
        this.functionRef = functionRef;
    }
    
    @Override
    KalpanaList execute(KalpanaList list) {
        KalpanaList result = new KalpanaList();
        for (int i = 0; i < list.size(); i++) {
            Object element = list.get(i + 1);
            if (evaluatePredicate(element)) {
                result.add(element);
            }
        }
        return result;
    }
    
    private boolean evaluatePredicate(Object element) {
        try {
            if (functionRef != null) {
                return evaluateWithFunction(element, functionRef);
            } else {
                // Replace all underscores with the actual element
                String expressionWithElement = replaceUnderscoresWithElement(predicate, element);
                
                // Create a new interpreter instance with the same function definitions
                Interpreter tempInterpreter = new Interpreter();
                tempInterpreter.environment.functions.putAll(interpreter.environment.functions);
                
                // Parse and evaluate the entire expression
                Lexer lexer = new Lexer(expressionWithElement);
                List<Token> tokens = lexer.scanTokens();
                Parser parser = new Parser(tokens);
                Expr expr = parser.expression();
                
                Object result = tempInterpreter.evaluate(expr);
                return isTruthy(result);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error evaluating predicate: " + predicate + " with element: " + element + " - " + e.getMessage());
        }
    }
    
    private String replaceUnderscoresWithElement(String expression, Object element) {
        String elementString = stringifyForExpression(element);
        
        // Replace all standalone underscores with the element
        // We need to be careful to only replace underscores that are identifiers, not parts of other tokens
        StringBuilder result = new StringBuilder();
        int i = 0;
        int n = expression.length();
        
        while (i < n) {
            char c = expression.charAt(i);
            
            if (c == '_') {
                // Check if it's a standalone underscore (not part of a larger identifier)
                boolean isStandalone = true;
                
                // Check character before (if exists)
                if (i > 0) {
                    char prev = expression.charAt(i - 1);
                    if (isIdentifierChar(prev)) {
                        isStandalone = false;
                    }
                }
                
                // Check character after (if exists)  
                if (i < n - 1) {
                    char next = expression.charAt(i + 1);
                    if (isIdentifierChar(next)) {
                        isStandalone = false;
                    }
                }
                
                if (isStandalone) {
                    result.append(elementString);
                    i++; // Skip the underscore
                } else {
                    result.append(c);
                    i++;
                }
            } else {
                result.append(c);
                i++;
            }
        }
        
        return result.toString();
    }
    
    private boolean isIdentifierChar(char c) {
        return Character.isLetterOrDigit(c) || c == '_' || 
               Character.UnicodeBlock.of(c) == Character.UnicodeBlock.BENGALI;
    }
    
    private String stringifyForExpression(Object element) {
        if (element instanceof String) {
            return "\"" + element.toString().replace("\"", "\\\"") + "\"";
        } else if (element instanceof BigDecimal) {
            return ((BigDecimal)element).toPlainString();
        } else if (element instanceof Boolean) {
            return element.toString();
        } else if (element instanceof KalpanaList) {
            return element.toString();
        } else if (element == null) {
            return "null";
        } else {
            return element.toString();
        }
    }
    
    private boolean evaluateWithFunction(Object element, Function function) {
        try {
            Environment tempEnv = new Environment(interpreter.environment);
            tempEnv.define("_", element);
            
            Environment previousEnv = interpreter.environment;
            try {
                interpreter.environment = tempEnv;
                
                List<Object> args = Collections.singletonList(element);
                Object functionResult = interpreter.callFunction(function, args);
                
                if (functionResult instanceof Boolean) {
                    return (Boolean)functionResult;
                } else if (functionResult instanceof BigDecimal) {
                    return !((BigDecimal)functionResult).equals(BigDecimal.ZERO);
                } else {
                    return isTruthy(functionResult);
                }
            } finally {
                interpreter.environment = previousEnv;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error in filter function: " + e.getMessage());
        }
    }
    
    private String stringify(Object object) {
        if (object == null) return "null";
        if (object instanceof String) return "\"" + object.toString().replace("\"", "\\\"") + "\"";
        return object.toString();
    }
    
    private boolean isTruthy(Object object) {
        if (object == null) return false;
        if (object instanceof Boolean) return (Boolean)object;
        if (object instanceof BigDecimal) return !((BigDecimal)object).equals(BigDecimal.ZERO);
        return true;
    }
}

class FilterTypeOperation extends StreamOperation {
    private final TokenType targetType;
    
    FilterTypeOperation(TokenType targetType, Interpreter interpreter) {
        super(interpreter);
        this.targetType = targetType;
    }
    
    @Override
    KalpanaList execute(KalpanaList list) {
        KalpanaList result = new KalpanaList();
        for (int i = 0; i < list.size(); i++) {
            Object element = list.get(i + 1);
            if (matchesType(element, targetType)) {
                result.add(element);
            }
        }
        return result;
    }
    
    private boolean matchesType(Object element, TokenType type) {
        if (element == null) return false;
        
        switch (type) {
            case INTEGER:
                return element instanceof BigDecimal && 
                       ((BigDecimal)element).scale() <= 0;
            case FLOAT:
                return element instanceof BigDecimal;
            case STRING:
                return element instanceof String;
            case BOOLEAN:
                return element instanceof Boolean;
            case LIST:
                return element instanceof KalpanaList;
            case OBJECT:
                return element instanceof ClassInstance;
            case FILE:
                // Files are stored as strings in fileHandles
                return element instanceof String && 
                       interpreter.fileHandles.containsKey(element);
            case ALL:
                return true; // ALL type matches everything
            case STREAM:
                return element instanceof KalpanaStream;
            default:
                return false;
        }
    }
}

// Map Operation
class MapOperation extends StreamOperation {
    private final String mapper;
    private final Function functionRef;
    
    MapOperation(String mapper, Interpreter interpreter) {
        super(interpreter);
        this.mapper = mapper;
        this.functionRef = null;
    }
    
    MapOperation(Function functionRef, Interpreter interpreter) {
        super(interpreter);
        this.mapper = null;
        this.functionRef = functionRef;
    }
    
    @Override
    KalpanaList execute(KalpanaList list) {
        KalpanaList result = new KalpanaList();
        for (int i = 0; i < list.size(); i++) {
            Object element = list.get(i + 1);
            Object mapped = evaluateMapper(element);
            result.add(mapped);
        }
        return result;
    }
    
    private Object evaluateMapper(Object element) {
        try {
            if (functionRef != null) {
                return evaluateWithFunction(element, functionRef);
            } else {
                // Replace all underscores with the actual element
                String expressionWithElement = replaceUnderscoresWithElement(mapper, element);
                
                // Create a new interpreter instance with the same function definitions
                Interpreter tempInterpreter = new Interpreter();
                tempInterpreter.environment.functions.putAll(interpreter.environment.functions);
                
                // Parse and evaluate the entire expression
                Lexer lexer = new Lexer(expressionWithElement);
                List<Token> tokens = lexer.scanTokens();
                Parser parser = new Parser(tokens);
                Expr expr = parser.expression();
                
                return tempInterpreter.evaluate(expr);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error evaluating mapper: " + mapper + " with element: " + element + " - " + e.getMessage());
        }
    }
   
    private String replaceUnderscoresWithElement(String expression, Object element) {
        String elementString = stringifyForExpression(element);
        
        // Replace all standalone underscores with the element
        StringBuilder result = new StringBuilder();
        int i = 0;
        int n = expression.length();
        
        while (i < n) {
            char c = expression.charAt(i);
            
            if (c == '_') {
                // Check if it's a standalone underscore (not part of a larger identifier)
                boolean isStandalone = true;
                
                // Check character before (if exists)
                if (i > 0) {
                    char prev = expression.charAt(i - 1);
                    if (isIdentifierChar(prev)) {
                        isStandalone = false;
                    }
                }
                
                // Check character after (if exists)  
                if (i < n - 1) {
                    char next = expression.charAt(i + 1);
                    if (isIdentifierChar(next)) {
                        isStandalone = false;
                    }
                }
                
                if (isStandalone) {
                    result.append(elementString);
                    i++; // Skip the underscore
                } else {
                    result.append(c);
                    i++;
                }
            } else {
                result.append(c);
                i++;
            }
        }
        
        return result.toString();
    }
    
    private boolean isIdentifierChar(char c) {
        return Character.isLetterOrDigit(c) || c == '_' || 
               Character.UnicodeBlock.of(c) == Character.UnicodeBlock.BENGALI;
    }
    
    private String stringifyForExpression(Object element) {
        if (element instanceof String) {
            return "\"" + element.toString().replace("\"", "\\\"") + "\"";
        } else if (element instanceof BigDecimal) {
            return ((BigDecimal)element).toPlainString();
        } else if (element instanceof Boolean) {
            return element.toString();
        } else if (element instanceof KalpanaList) {
            return element.toString();
        } else if (element == null) {
            return "null";
        } else {
            return element.toString();
        }
    }
    
    private Object evaluateWithFunction(Object element, Function function) {
        try {
            Environment tempEnv = new Environment(interpreter.environment);
            tempEnv.define("_", element);
            
            Environment previousEnv = interpreter.environment;
            try {
                interpreter.environment = tempEnv;
                
                List<Object> args = Collections.singletonList(element);
                return interpreter.callFunction(function, args);
            } finally {
                interpreter.environment = previousEnv;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error in map function: " + e.getMessage());
        }
    }
    
    // Keep your existing stringify method for other uses
    private String stringify(Object object) {
        if (object == null) return "null";
        if (object instanceof String) return "\"" + object.toString().replace("\"", "\\\"") + "\"";
        return object.toString();
    }
}

// Limit Operation
class LimitOperation extends StreamOperation {
    private final int limit;
    
    LimitOperation(int limit, Interpreter interpreter) {
        super(interpreter);
        this.limit = limit;
    }
    
    @Override
    KalpanaList execute(KalpanaList list) {
        KalpanaList result = new KalpanaList();
        int count = Math.min(limit, list.size());
        for (int i = 1; i <= count; i++) {
            result.add(list.get(i));
        }
        return result;
    }
}

class SkipOperation extends StreamOperation {
    private final int skip;
    
    SkipOperation(int skip, Interpreter interpreter) {
        super(interpreter);
        this.skip = skip;
    }
    
    @Override
    KalpanaList execute(KalpanaList list) {
        KalpanaList result = new KalpanaList();
        for (int i = skip + 1; i <= list.size(); i++) {
            result.add(list.get(i));
        }
        return result;
    }
}

class DistinctOperation extends StreamOperation {
    DistinctOperation(Interpreter interpreter) {
        super(interpreter);
    }
    
    @Override
    KalpanaList execute(KalpanaList list) {
        KalpanaList result = new KalpanaList();
        Set<Object> seen = new HashSet<>();
        
        for (int i = 0; i < list.size(); i++) {
            Object element = list.get(i + 1);
            if (!seen.contains(element)) {
                seen.add(element);
                result.add(element);
            }
        }
        return result;
    }
}

class SortOperation extends StreamOperation {
    private final String comparator;
    private final Function functionRef;
    
    SortOperation(Interpreter interpreter) {
        super(interpreter);
        this.comparator = null;
        this.functionRef = null;
    }
    
    SortOperation(String comparator, Interpreter interpreter) {
        super(interpreter);
        this.comparator = comparator;
        this.functionRef = null;
    }
    
    SortOperation(Function functionRef, Interpreter interpreter) {
        super(interpreter);
        this.comparator = null;
        this.functionRef = functionRef;
    }
    
    @Override
    KalpanaList execute(KalpanaList list) {
        KalpanaList result = list.copy();
        
        if (functionRef != null) {
            // Sort using comparator function
            result.elements().sort((a, b) -> {
                try {
                    Environment tempEnv = new Environment(interpreter.environment);
                    tempEnv.define("a", a);
                    tempEnv.define("b", b);
                    
                    Environment previousEnv = interpreter.environment;
                    try {
                        interpreter.environment = tempEnv;
                        
                        List<Object> args = Arrays.asList(a, b);
                        Object functionResult = interpreter.callFunction(functionRef, args);
                        
                        if (functionResult instanceof BigDecimal) {
                            return ((BigDecimal)functionResult).intValue();
                        } else if (functionResult instanceof Integer) {
                            return (Integer)functionResult;
                        } else {
                            throw new RuntimeException("Comparator function must return a number");
                        }
                    } finally {
                        interpreter.environment = previousEnv;
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Error in sort comparator function: " + e.getMessage());
                }
            });
        } else if (comparator != null) {
            // Sort using string expression
            result.elements().sort((a, b) -> {
                try {
                    String expression = comparator.replace("a", stringify(a)).replace("b", stringify(b));
                    Lexer lexer = new Lexer(expression);
                    List<Token> tokens = lexer.scanTokens();
                    Parser parser = new Parser(tokens);
                    Expr expr = parser.expression();
                    Object resultVal = interpreter.evaluate(expr);
                    
                    if (resultVal instanceof BigDecimal) {
                        return ((BigDecimal)resultVal).intValue();
                    } else if (resultVal instanceof Integer) {
                        return (Integer)resultVal;
                    } else {
                        throw new RuntimeException("Comparator expression must return a number");
                    }
                } catch (Exception e) {
                    throw new RuntimeException("Error in sort comparator expression: " + e.getMessage());
                }
            });
        } else {
            // Default sort
            result.sort();
        }
        
        return result;
    }
    
    private String stringify(Object object) {
        if (object == null) return "null";
        if (object instanceof String) return "\"" + object.toString().replace("\"", "\\\"") + "\"";
        return object.toString();
    }
}

class ReverseOperation extends StreamOperation {
    ReverseOperation(Interpreter interpreter) {
        super(interpreter);
    }
    
    @Override
    KalpanaList execute(KalpanaList list) {
        KalpanaList result = new KalpanaList();
        for (int i = list.size(); i >= 1; i--) {
            result.add(list.get(i));
        }
        return result;
    }
}

class TakeWhileOperation extends StreamOperation {
    private final String condition;
    private final Function functionRef;
    
    TakeWhileOperation(String condition, Interpreter interpreter) {
        super(interpreter);
        this.condition = condition;
        this.functionRef = null;
    }
    
    TakeWhileOperation(Function functionRef, Interpreter interpreter) {
        super(interpreter);
        this.condition = null;
        this.functionRef = functionRef;
    }
    
    @Override
    KalpanaList execute(KalpanaList list) {
        KalpanaList result = new KalpanaList();
        boolean foundFirstTrue = false;
        boolean taking = true;
        
        for (int i = 0; i < list.size(); i++) {
            Object element = list.get(i + 1);
            boolean conditionResult = evaluateCondition(element);
            
            if (taking && conditionResult) {
                // Condition is true, add element to result
                result.add(element);
                foundFirstTrue = true;
            } else if (foundFirstTrue && !conditionResult) {
                // We found at least one true before, and now condition is false - stop taking
                taking = false;
                break;
            }
            // If we haven't found any true yet and condition is false, continue checking
            // Don't add the element, but don't stop the loop either
        }
        return result;
    }
    
    private boolean evaluateCondition(Object element) {
        try {
            if (functionRef != null) {
                return evaluateWithFunction(element, functionRef);
            } else {
                String expression = condition.replace("_", stringify(element));
                Lexer lexer = new Lexer(expression);
                List<Token> tokens = lexer.scanTokens();
                Parser parser = new Parser(tokens);
                Expr expr = parser.expression();
                Object result = interpreter.evaluate(expr);
                return isTruthy(result);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error in takeWhile condition: " + e.getMessage());
        }
    }
    
    private boolean evaluateWithFunction(Object element, Function function) {
        try {
            Environment tempEnv = new Environment(interpreter.environment);
            tempEnv.define("_", element);
            
            Environment previousEnv = interpreter.environment;
            try {
                interpreter.environment = tempEnv;
                
                List<Object> args = Collections.singletonList(element);
                Object functionResult = interpreter.callFunction(function, args);
                
                if (functionResult instanceof Boolean) {
                    return (Boolean)functionResult;
                } else if (functionResult instanceof BigDecimal) {
                    return !((BigDecimal)functionResult).equals(BigDecimal.ZERO);
                } else {
                    return isTruthy(functionResult);
                }
            } finally {
                interpreter.environment = previousEnv;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error in takeWhile function: " + e.getMessage());
        }
    }
    
    private String stringify(Object object) {
        if (object == null) return "null";
        if (object instanceof String) return "\"" + object.toString().replace("\"", "\\\"") + "\"";
        return object.toString();
    }
    
    private boolean isTruthy(Object object) {
        if (object == null) return false;
        if (object instanceof Boolean) return (Boolean)object;
        if (object instanceof BigDecimal) return !((BigDecimal)object).equals(BigDecimal.ZERO);
        return true;
    }
}

class DropWhileOperation extends StreamOperation {
    private final String condition;
    private final Function functionRef;
    
    DropWhileOperation(String condition, Interpreter interpreter) {
        super(interpreter);
        this.condition = condition;
        this.functionRef = null;
    }
    
    DropWhileOperation(Function functionRef, Interpreter interpreter) {
        super(interpreter);
        this.condition = null;
        this.functionRef = functionRef;
    }
    
    @Override
    KalpanaList execute(KalpanaList list) {
        KalpanaList result = new KalpanaList();
        boolean dropping = true;
        
        for (int i = 0; i < list.size(); i++) {
            Object element = list.get(i + 1);
            if (dropping && evaluateCondition(element)) {
                continue;
            }
            dropping = false;
            result.add(element);
        }
        return result;
    }
    
    private boolean evaluateCondition(Object element) {
        try {
            if (functionRef != null) {
                return evaluateWithFunction(element, functionRef);
            } else {
                String expression = condition.replace("_", stringify(element));
                Lexer lexer = new Lexer(expression);
                List<Token> tokens = lexer.scanTokens();
                Parser parser = new Parser(tokens);
                Expr expr = parser.expression();
                Object result = interpreter.evaluate(expr);
                return isTruthy(result);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error in dropWhile condition: " + e.getMessage());
        }
    }
    
    private boolean evaluateWithFunction(Object element, Function function) {
        try {
            Environment tempEnv = new Environment(interpreter.environment);
            tempEnv.define("_", element);
            
            Environment previousEnv = interpreter.environment;
            try {
                interpreter.environment = tempEnv;
                
                List<Object> args = Collections.singletonList(element);
                Object functionResult = interpreter.callFunction(function, args);
                
                if (functionResult instanceof Boolean) {
                    return (Boolean)functionResult;
                } else if (functionResult instanceof BigDecimal) {
                    return !((BigDecimal)functionResult).equals(BigDecimal.ZERO);
                } else {
                    return isTruthy(functionResult);
                }
            } finally {
                interpreter.environment = previousEnv;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error in dropWhile function: " + e.getMessage());
        }
    }
    
    private String stringify(Object object) {
        if (object == null) return "null";
        if (object instanceof String) return "\"" + object.toString().replace("\"", "\\\"") + "\"";
        return object.toString();
    }
    
    private boolean isTruthy(Object object) {
        if (object == null) return false;
        if (object instanceof Boolean) return (Boolean)object;
        if (object instanceof BigDecimal) return !((BigDecimal)object).equals(BigDecimal.ZERO);
        return true;
    }
}

class FlatMapOperation extends StreamOperation {
    FlatMapOperation(Interpreter interpreter) {
        super(interpreter);
    }
    
    @Override
    KalpanaList execute(KalpanaList list) {
        KalpanaList result = new KalpanaList();
        for (int i = 0; i < list.size(); i++) {
            Object element = list.get(i + 1);
            if (element instanceof KalpanaList) {
                KalpanaList subList = (KalpanaList) element;
                for (int j = 0; j < subList.size(); j++) {
                    result.add(subList.get(j + 1));
                }
            } else if (element instanceof Object[]) {
                Object[] array = (Object[]) element;
                for (Object item : array) {
                    result.add(item);
                }
            } else {
                result.add(element);
            }
        }
        return result;
    }
}

// Stream Class
class KalpanaStream {
    private final KalpanaList source;
    private final List<StreamOperation> operations;
    private final Interpreter interpreter;
    
    public KalpanaStream(KalpanaList source, Interpreter interpreter) {
        this.source = source;
        this.operations = new Vector<>();
        this.interpreter = interpreter;
    }
    
    private KalpanaStream(KalpanaList source, List<StreamOperation> operations, Interpreter interpreter) {
        this.source = source;
        this.operations = new Vector<>(operations);
        this.interpreter = interpreter;
    }
    
    public KalpanaStream ফিল্টার(Object predicate) {
        List<StreamOperation> newOps = new Vector<>(this.operations);
        
        if (predicate instanceof String) {
            newOps.add(new FilterOperation((String)predicate, interpreter));
        } else if (predicate instanceof Function) {
            newOps.add(new FilterOperation((Function)predicate, interpreter));
        } else {
            throw new RuntimeException("ফিল্টার() expects a string expression or function reference");
        }
        
        return new KalpanaStream(this.source, newOps, interpreter);
    }
    
    public KalpanaStream ফিল্টার_টাইপ(TokenType type) {
        List<StreamOperation> newOps = new Vector<>(this.operations);
        newOps.add(new FilterTypeOperation(type, interpreter));
        return new KalpanaStream(this.source, newOps, interpreter);
    }
    
    // English alias
    public KalpanaStream filterType(TokenType type) {
        return ফিল্টার_টাইপ(type);
    }
    public KalpanaStream ম্যাপ(Object mapper) {
        List<StreamOperation> newOps = new Vector<>(this.operations);
        
        if (mapper instanceof String) {
            newOps.add(new MapOperation((String)mapper, interpreter));
        } else if (mapper instanceof Function) {
            newOps.add(new MapOperation((Function)mapper, interpreter));
        } else {
            throw new RuntimeException("ম্যাপ() expects a string expression or function reference");
        }
        
        return new KalpanaStream(this.source, newOps, interpreter);
    }
    
    public KalpanaStream সীমা(int limit) {
        List<StreamOperation> newOps = new Vector<>(this.operations);
        newOps.add(new LimitOperation(limit, interpreter));
        return new KalpanaStream(this.source, newOps, interpreter);
    }
    
    public KalpanaStream এড়িয়ে(int skip) {
        List<StreamOperation> newOps = new Vector<>(this.operations);
        newOps.add(new SkipOperation(skip, interpreter));
        return new KalpanaStream(this.source, newOps, interpreter);
    }
    
    public KalpanaStream অনন্য() {
        List<StreamOperation> newOps = new Vector<>(this.operations);
        newOps.add(new DistinctOperation(interpreter));
        return new KalpanaStream(this.source, newOps, interpreter);
    }
    
    public KalpanaStream সাজানো() {
        List<StreamOperation> newOps = new Vector<>(this.operations);
        newOps.add(new SortOperation(interpreter));
        return new KalpanaStream(this.source, newOps, interpreter);
    }
    
    public KalpanaStream সাজানো(String comparator) {
        List<StreamOperation> newOps = new Vector<>(this.operations);
        newOps.add(new SortOperation(comparator, interpreter));
        return new KalpanaStream(this.source, newOps, interpreter);
    }
    
    public KalpanaStream সাজানো(Object comparator) {
        List<StreamOperation> newOps = new Vector<>(this.operations);
        
        if (comparator == null) {
            newOps.add(new SortOperation(interpreter));
        } else if (comparator instanceof String) {
            newOps.add(new SortOperation((String)comparator, interpreter));
        } else if (comparator instanceof Function) {
            newOps.add(new SortOperation((Function)comparator, interpreter));
        } else {
            throw new RuntimeException("সাজানো() expects a string expression or function reference");
        }
        
        return new KalpanaStream(this.source, newOps, interpreter);
    }
    public KalpanaStream উল্টাও() {
        List<StreamOperation> newOps = new Vector<>(this.operations);
        newOps.add(new ReverseOperation(interpreter));
        return new KalpanaStream(this.source, newOps, interpreter);
    }
    
    public KalpanaStream পাতানো(Object condition) {
        List<StreamOperation> newOps = new Vector<>(this.operations);
        
        if (condition instanceof String) {
            newOps.add(new TakeWhileOperation((String)condition, interpreter));
        } else if (condition instanceof Function) {
            newOps.add(new TakeWhileOperation((Function)condition, interpreter));
        } else {
            throw new RuntimeException("পাতানো() expects a string expression or function reference");
        }
        
        return new KalpanaStream(this.source, newOps, interpreter);
    }
    
    public KalpanaStream বাদদেওয়া(Object condition) {
        List<StreamOperation> newOps = new Vector<>(this.operations);
        
        if (condition instanceof String) {
            newOps.add(new DropWhileOperation((String)condition, interpreter));
        } else if (condition instanceof Function) {
            newOps.add(new DropWhileOperation((Function)condition, interpreter));
        } else {
            throw new RuntimeException("বাদদেওয়া() expects a string expression or function reference");
        }
        
        return new KalpanaStream(this.source, newOps, interpreter);
    }
    
    public KalpanaStream সমতল() {
        List<StreamOperation> newOps = new Vector<>(this.operations);
        newOps.add(new FlatMapOperation(interpreter));
        return new KalpanaStream(this.source, newOps, interpreter);
    }
    
    public KalpanaList লিস্টে() {
        KalpanaList result = source.copy();
        for (StreamOperation operation : operations) {
            result = operation.execute(result);
        }
        return result;
    }
    
    public BigDecimal গণনা() {
        return new BigDecimal(লিস্টে().size());
    }
    
    public BigDecimal যোগফল() {
        KalpanaList result = লিস্টে();
        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 0; i < result.size(); i++) {
            Object element = result.get(i + 1);
            if (element instanceof BigDecimal) {
                sum = sum.add((BigDecimal)element);
            }
        }
        return sum;
    }
    
    public BigDecimal গড়() {
        KalpanaList result = লিস্টে();
        if (result.isEmpty()) {
            return BigDecimal.ZERO;
        }
        BigDecimal sum = যোগফল();
        return sum.divide(new BigDecimal(result.size()), 10, RoundingMode.HALF_UP);
    }
    
    public BigDecimal ন্যূনতম() {
        KalpanaList result = লিস্টে();
        if (result.isEmpty()) {
            throw new RuntimeException("Cannot find minimum of empty stream");
        }
        BigDecimal min = null;
        for (int i = 0; i < result.size(); i++) {
            Object element = result.get(i + 1);
            if (element instanceof BigDecimal) {
                BigDecimal num = (BigDecimal)element;
                if (min == null || num.compareTo(min) < 0) {
                    min = num;
                }
            }
        }
        return min != null ? min : BigDecimal.ZERO;
    }
    
    public BigDecimal সর্বোচ্চ() {
        KalpanaList result = লিস্টে();
        if (result.isEmpty()) {
            throw new RuntimeException("Cannot find maximum of empty stream");
        }
        BigDecimal max = null;
        for (int i = 0; i < result.size(); i++) {
            Object element = result.get(i + 1);
            if (element instanceof BigDecimal) {
                BigDecimal num = (BigDecimal)element;
                if (max == null || num.compareTo(max) > 0) {
                    max = num;
                }
            }
        }
        return max != null ? max : BigDecimal.ZERO;
    }
    
    public Object প্রথম() {
        KalpanaList result = লিস্টে();
        if (result.isEmpty()) {
            throw new RuntimeException("Cannot get first element of empty stream");
        }
        return result.get(1);
    }
    
    public Object শেষ() {
        KalpanaList result = লিস্টে();
        if (result.isEmpty()) {
            throw new RuntimeException("Cannot get last element of empty stream");
        }
        return result.get(result.size());
    }
    
    public Object যেকোনো() {
        KalpanaList result = লিস্টে();
        if (result.isEmpty()) {
            throw new RuntimeException("Cannot get any element of empty stream");
        }
        int randomIndex = (int)(Math.random() * result.size()) + 1;
        return result.get(randomIndex);
    }
    
    public Boolean যেকোনো_মিল(Object predicate) {
        KalpanaList result = লিস্টে();
        for (int i = 0; i < result.size(); i++) {
            Object element = result.get(i + 1);
            if (evaluatePredicate(predicate, element)) {
                return true;
            }
        }
        return false;
    }
    
    public Boolean সব_মিল(Object predicate) {
        KalpanaList result = লিস্টে();
        for (int i = 0; i < result.size(); i++) {
            Object element = result.get(i + 1);
            if (!evaluatePredicate(predicate, element)) {
                return false;
            }
        }
        return true;
    }
    
    public Boolean কোনটাই_মিলেনা(Object predicate) {
        return !যেকোনো_মিল(predicate);
    }
    
    public Object খুঁজ(Object predicate) {
        KalpanaList result = লিস্টে();
        for (int i = 0; i < result.size(); i++) {
            Object element = result.get(i + 1);
            if (evaluatePredicate(predicate, element)) {
                return element;
            }
        }
        return null;
    }
    
    public Object খুঁজ_প্রথম(Object predicate) {
        return খুঁজ(predicate);
    }
    
    public String একত্রিত() {
        return একত্রিত("");
    }
    
    public String একত্রিত(String separator) {
        KalpanaList result = লিস্টে();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) sb.append(separator);
            Object element = result.get(i + 1);
            sb.append(joinStringify(element));
        }
        return sb.toString();
    }
 
    public KalpanaSet সংগ্রহ_সেট() {
        KalpanaList result = লিস্টে();
        KalpanaSet setResult = new KalpanaSet();
        for (int i = 0; i < result.size(); i++) {
            Object element = result.get(i + 1);
            setResult.add(element);
        }
        return setResult;
    }
    
    public KalpanaList সংগ্রহ_লিস্ট() {
        return লিস্টে();
    }
    
    public KalpanaList সংগ্রহ_অনন্য() {
        return this.অনন্য().লিস্টে();
    }
    
    public Object হ্রাস(String reducer) {
        KalpanaList result = লিস্টে();
        if (result.isEmpty()) {
            return null;
        }
        
        Object accumulator = result.get(1);
        for (int i = 1; i < result.size(); i++) {
            Object current = result.get(i + 1);
            try {
                String expression = reducer.replace("a", stringify(accumulator)).replace("b", stringify(current));
                Lexer lexer = new Lexer(expression);
                List<Token> tokens = lexer.scanTokens();
                Parser parser = new Parser(tokens);
                Expr expr = parser.expression();
                accumulator = interpreter.evaluate(expr);
            } catch (Exception e) {
                throw new RuntimeException("Error in reducer: " + e.getMessage());
            }
        }
        return accumulator;
    }
    
    public Object হ্রাস(String reducer, Object initialValue) {
        KalpanaList result = লিস্টে();
        Object accumulator = initialValue;
        
        for (int i = 0; i < result.size(); i++) {
            Object current = result.get(i + 1);
            try {
                String expression = reducer.replace("a", stringify(accumulator)).replace("b", stringify(current));
                Lexer lexer = new Lexer(expression);
                List<Token> tokens = lexer.scanTokens();
                Parser parser = new Parser(tokens);
                Expr expr = parser.expression();
                accumulator = interpreter.evaluate(expr);
            } catch (Exception e) {
                throw new RuntimeException("Error in reducer: " + e.getMessage());
            }
        }
        return accumulator;
    }
    
    public Boolean খালি() {
        return লিস্টে().isEmpty();
    }
    
    private boolean evaluatePredicate(Object predicate, Object element) {
        try {
            if (predicate instanceof String) {
                String expression = ((String)predicate).replace("_", stringify(element));
                Lexer lexer = new Lexer(expression);
                List<Token> tokens = lexer.scanTokens();
                Parser parser = new Parser(tokens);
                Expr expr = parser.expression();
                Object result = interpreter.evaluate(expr);
                return isTruthy(result);
            } else if (predicate instanceof Function) {
                Function function = (Function)predicate;
                
                Environment tempEnv = new Environment(interpreter.environment);
                tempEnv.define("_", element);
                
                Environment previousEnv = interpreter.environment;
                try {
                    interpreter.environment = tempEnv;
                    
                    List<Object> args = Collections.singletonList(element);
                    Object functionResult = interpreter.callFunction(function, args);
                    
                    if (functionResult instanceof Boolean) {
                        return (Boolean)functionResult;
                    } else if (functionResult instanceof BigDecimal) {
                        return !((BigDecimal)functionResult).equals(BigDecimal.ZERO);
                    } else {
                        return isTruthy(functionResult);
                    }
                } finally {
                    interpreter.environment = previousEnv;
                }
            } else {
                throw new RuntimeException("Predicate must be string expression or function reference");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error evaluating predicate: " + e.getMessage());
        }
    }
    
    private String stringify(Object object) {
        if (object == null) return "null";
        if (object instanceof String) return "\"" + object.toString().replace("\"", "\\\"") + "\"";
        return object.toString();
    }

    private String joinStringify(Object object)
     {
        if (object == null) return "null";
        return object.toString();  // No quotes for join operation
    }
    
    private boolean isTruthy(Object object) {
        if (object == null) return false;
        if (object instanceof Boolean) return (Boolean)object;
        if (object instanceof BigDecimal) return !((BigDecimal)object).equals(BigDecimal.ZERO);
        return true;
    }
    
    @Override
    public String toString() {
        return "<stream size=" + source.size() + " operations=" + operations.size() + ">";
    }
}

class Interpreter implements ExprVisitor<Object>, StmtVisitor<Void>
{
    public Environment environment = new Environment();
    private List<Stmt> statements; // Store the parsed statements
    private Environment originalEnvironment; //Store original environment data
    private String sourceCode; // Store the original source code
    //Let's make hashmaps thread safe for future use.
    private final Map<Object, BufferedReader> fileReaders = Collections.synchronizedMap(new LinkedHashMap<>());
    private final Map<Object, BufferedWriter> fileWriters = Collections.synchronizedMap(new LinkedHashMap<>());
    public final Map<String, FileHandle> fileHandles = new LinkedHashMap<>();
    private String currentFileMode;
    private boolean inSafeScope = false;

    // Helper class to store function + arguments for thread execution
    private static class FunctionTask
    {
        final Function function;
        final List<Object> arguments;
        
        FunctionTask(Function function, List<Object> arguments)
        {
            this.function = function;
            this.arguments = arguments;
        }
    }
    private static class FileHandle
    {
        private RandomAccessFile raf;
        private BufferedReader reader;
        private BufferedWriter writer;
        private FileInputStream fis;
        private FileOutputStream fos;
        public final String path;
        private final FileMode mode;
        private final Charset charset = StandardCharsets.UTF_8;
        private final Object lock = new Object();
        private boolean isDeleted = false;
    
        FileHandle(String path, FileMode mode) throws IOException
        {
            this.path = path;
            this.mode = mode;
            
            File file = new File(path);
            
            // Only try to create parent directories if they don't exist
            File parent = file.getParentFile();
            if (parent != null && !parent.exists())
            {
                parent.mkdirs();
            }
            
            if (mode.isBinary()) {
                // Binary file handling
                switch (mode)
                {
                    case READ_BINARY:
                        if (!file.exists()) throw new FileNotFoundException(path);
                        this.fis = new FileInputStream(file);
                        break;
                        
                    case WRITE_BINARY:
                        this.fos = new FileOutputStream(file, false);
                        break;
                        
                    case APPEND_BINARY:
                        this.fos = new FileOutputStream(file, true);
                        break;
                        
                    case READ_WRITE_BINARY:
                        if (!file.exists()) throw new FileNotFoundException(path);
                        this.raf = new RandomAccessFile(file, "rw");
                        break;
                        
                    case WRITE_READ_BINARY:
                        this.raf = new RandomAccessFile(file, "rw");
                        this.raf.setLength(0); // Truncate file
                        break;
                        
                    case APPEND_READ_BINARY:
                        this.raf = new RandomAccessFile(file, "rw");
                        this.raf.seek(this.raf.length()); // Seek to end
                        break;
                        
                    default:
                        // Fall back to text mode for binary modes not explicitly handled
                        setupTextMode(file);
                        break;
                }
            } else {
                // Text file handling (existing code)
                setupTextMode(file);
            }
        }
        
        private void setupTextMode(File file) throws IOException {
            switch (mode)
            {
                case READ:
                    if (!file.exists()) throw new FileNotFoundException(path);
                    this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
                    break;
                    
                case WRITE:
                    this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), charset));
                    break;
                    
                case APPEND:
                    this.writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), charset));
                    break;
                    
                case READ_WRITE:
                    if (!file.exists()) throw new FileNotFoundException(path);
                    this.raf = new RandomAccessFile(file, "rw");
                    break;
                    
                case WRITE_READ:
                    this.raf = new RandomAccessFile(file, "rw");
                    this.raf.setLength(0); // Truncate file
                    break;
                    
                case APPEND_READ:
                    this.raf = new RandomAccessFile(file, "rw");
                    this.raf.seek(this.raf.length()); // Seek to end
                    break;
            }
        }
               
        // Binary read methods
        byte[] readBinary(int bytesToRead) throws IOException {
            synchronized (lock) {
                if (isDeleted) throw new IOException("File already deleted");
                
                if (fis != null) {
                    byte[] buffer = new byte[bytesToRead];
                    int bytesRead = fis.read(buffer);
                    if (bytesRead == -1) return new byte[0];
                    if (bytesRead < bytesToRead) {
                        return Arrays.copyOf(buffer, bytesRead);
                    }
                    return buffer;
                } else if (raf != null && mode.isBinary()) {
                    byte[] buffer = new byte[bytesToRead];
                    int bytesRead = raf.read(buffer);
                    if (bytesRead == -1) return new byte[0];
                    if (bytesRead < bytesToRead) {
                        return Arrays.copyOf(buffer, bytesRead);
                    }
                    return buffer;
                }
                throw new IOException("File not open for binary reading");
            }
        }
        
        byte[] readAllBinary() throws IOException {
            synchronized (lock) {
                if (isDeleted) throw new IOException("File already deleted");
                
                if (fis != null) {
                    return fis.readAllBytes();
                } else if (raf != null && mode.isBinary()) {
                    long currentPos = raf.getFilePointer();
                    raf.seek(0);
                    byte[] content = new byte[(int)raf.length()];
                    raf.readFully(content);
                    raf.seek(currentPos);
                    return content;
                }
                throw new IOException("File not open for binary reading");
            }
        }
        
        // Binary write methods
        void writeBinary(byte[] data) throws IOException {
            synchronized (lock) {
                if (isDeleted) throw new IOException("File already deleted");
                
                if (fos != null) {
                    fos.write(data);
                    fos.flush();
                } else if (raf != null && mode.isBinary()) {
                    raf.write(data);
                } else {
                    throw new IOException("File not opened for binary writing");
                }
            }
        }
        
        void writeBinary(byte[] data, int offset, int length) throws IOException {
            synchronized (lock) {
                if (isDeleted) throw new IOException("File already deleted");
                
                if (fos != null) {
                    fos.write(data, offset, length);
                    fos.flush();
                } else if (raf != null && mode.isBinary()) {
                    raf.write(data, offset, length);
                } else {
                    throw new IOException("File not opened for binary writing");
                }
            }
        }
        
        // Seek in binary file
        public boolean supportsSeek() {
            return raf != null;
        }
        
        // Update seek method with better error message
        void seek(long position) throws IOException {
            synchronized (lock) {
                if (isDeleted) throw new IOException("File already deleted");
                
                if (raf != null) {
                    raf.seek(position);
                } else {
                    throw new IOException("Seek operation only supported for random access files. " +
                                        "Use modes like 'r+b', 'w+b', or 'a+b' instead of 'rb' or 'wb'.");
                }
            }
        }
        
        long getPosition() throws IOException {
            synchronized (lock) {
                if (isDeleted) throw new IOException("File already deleted");
                
                if (raf != null) {
                    return raf.getFilePointer();
                } else if (fis != null) {
                    // For input streams, we can't easily get position
                    throw new IOException("Position not available for input streams");
                } else {
                    throw new IOException("Position not available for this file type");
                }
            }
        }
        
        long getSize() throws IOException {
            synchronized (lock) {
                if (isDeleted) throw new IOException("File already deleted");
                
                if (raf != null) {
                    return raf.length();
                } else {
                    File file = new File(path);
                    return file.length();
                }
            }
        }
        
         void delete() throws IOException
         {
        synchronized (lock)
        {
            if (isDeleted)
            {
                throw new IOException("File already deleted");
            }
            
            // Close resources first
            close();
            
            // Delete the file
            File file = new File(path);
            if (!file.delete())
            {
                throw new IOException("Failed to delete file");
            }
            isDeleted = true;
        }
    }
        boolean canDelete()
        {
                // Can't delete files opened in read mode
                return mode != FileMode.READ && mode != FileMode.READ_WRITE;
        }
    
            String fileHash(String algorithm)
           {    
                try{
                        algorithm = algorithm.replace("-", "").toUpperCase();
                        switch (algorithm)
                        {
                            case "MD5":
                                algorithm = "MD5";
                                break;
                            case "SHA1":
                                algorithm = "SHA-1";
                                break;
                            case "SHA256":
                                algorithm = "SHA-256";
                                break;
                            case "SHA512":
                                algorithm = "SHA-512";
                                break;
                            case "SHA384":
                                algorithm = "SHA-384";
                                break;
                            default:
                                throw new RuntimeException("Unsupported hash algorithm: " + algorithm + ". Supported: MD5, SHA-1, SHA-256, SHA-384, SHA-512");
                        }
                    MessageDigest md = MessageDigest.getInstance(algorithm);
                    try (InputStream is = Files.newInputStream(Paths.get(path)))
                    {
                        byte[] buffer = new byte[8192];  //2¹³ is perfect for me.
                        int read;
                        while ((read = is.read(buffer)) > 0)
                        {
                            md.update(buffer, 0, read);
                        }
                    }
                    
                    // Convert to hex string
                    byte[] digest = md.digest();
                    StringBuffer hexString = new StringBuffer();
                    for (byte b : digest)
                    {
                        hexString.append(String.format("%02x", b));
                    }
                    
                    return hexString.toString();
                }catch(Exception ex){}
                    return "";
           }
            void write(String content) throws IOException
            {
                if (writer != null)
                {
                    // BufferedWriter mode
                    writer.write(content);
                    writer.flush();
                } 
                else if (raf != null)
                {
                    // RandomAccessFile mode - write as UTF-8 bytes
                    raf.write(content.getBytes(charset));
                }
                else
                {
                    throw new IOException("File not opened for writing");
                }
            }

    void close() throws IOException {
            synchronized (lock) {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
                if (raf != null) raf.close();
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            }
        }
}

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
    public Void visitFileStmt(FileStmt stmt)
    {
        // Handle both cases: declaration only and declaration with assignment
        Object path = evaluate(stmt.path());
        
        // If path is null, this is just a declaration without assignment
        if (path == null)
        {
            // Define the file variable with null value
            environment.define(stmt.name().lexeme, null);
            return null;
        }
        
        if (!(path instanceof String))
        {
            throw new RuntimeException("File path must be a string");
        }
        
        FileMode mode = stmt.defaultMode();
        // Evaluate mode expression if present
        if (stmt.modeExpr() != null)
        {
            Object modeValue = evaluate(stmt.modeExpr());
            if (modeValue instanceof String)
            {
                mode = FileMode.fromString((String)modeValue);
            }
        }
        
        try
        {
            FileHandle handle = new FileHandle((String)path, mode);
            fileHandles.put(stmt.name().lexeme, handle);
            environment.define(stmt.name().lexeme, stmt.name().lexeme);
        } catch (IOException e)
        {
            throw new RuntimeException("File operation failed: " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public Void visitFileWriteStmt(FileWriteStmt stmt)
    {
        Object handleName = evaluate(stmt.fileHandle());
        Object content = evaluate(stmt.content());
        
        if (!(handleName instanceof String))
        {
            throw new RuntimeException("File handle must be a string");
        }
        
        FileHandle handle = fileHandles.get(handleName);
        if (handle == null)
        {
            throw new RuntimeException("Invalid file handle");
        }
        
        try
        {
            // Ensure content is properly converted to String
            String textContent;
            if (content instanceof String)
            {
                textContent = (String)content;
            } else
            {
                textContent = stringify(content);
            }
            handle.write(textContent);
            return null;
        } catch (IOException e)
        {
            throw new RuntimeException("Failed to write to file: " + e.getMessage());
        }
    }

    public boolean isFileHandle(Object value)
    {
        if (value instanceof String)return fileHandles.containsKey(value);
        return false;
    }
    @Override
    public Object visitFileReadExpr(FileReadExpr expr)
    {
        // Validate file handle
        Object handleName = evaluate(expr.fileHandle());
        if (!(handleName instanceof String))
        {
            throw new RuntimeException("File handle must be a string");
        }
        
        FileHandle handle = fileHandles.get(handleName);
        if (handle == null)
        {
            throw new RuntimeException("Invalid file handle '" + handleName + "'");
        }
    
        try
        {
            // Determine line range based on arguments
            int startLine = 1;
            int endLine = Integer.MAX_VALUE;
            int totalLines = countLines(handle); // First count total lines in file
            
            if (!expr.arguments().isEmpty())
            {
                // Validate first argument
                Object firstArg = evaluate(expr.arguments().get(0));
                if (!(firstArg instanceof BigDecimal))
                {
                    throw new RuntimeException("Line number must be an integer");
                }
                int firstLine = ((BigDecimal)firstArg).intValue();
                
                // Handle negative line numbers
                if (firstLine < 1)
                {
                    throw new RuntimeException("Line number must be positive (got " + firstLine + ")");
                }
    
                if (expr.arguments().size() == 1)
                {
                    // Case: পড়(fileHandler, 4) - read first 4 lines
                    startLine = 1;
                    endLine = firstLine;
                    
                    // Check if requested lines exceed file size
                    if (endLine > totalLines)
                    {
                        throw new RuntimeException("File only has " + totalLines + 
                            " lines (requested up to line " + endLine + ")");
                    }
                } else if (expr.arguments().size() == 2)
                {
                    // Case: পড়(fileHandler, 10, 20) - read lines 10-20
                    startLine = firstLine;
                    
                    // Validate second argument
                    Object secondArg = evaluate(expr.arguments().get(1));
                    if (!(secondArg instanceof BigDecimal))
                    {
                        throw new RuntimeException("Line number must be an integer");
                    }
                    endLine = ((BigDecimal)secondArg).intValue();
                    
                    // Validate line range
                    if (endLine < 1)
                    {
                        throw new RuntimeException("Line number must be positive (got " + endLine + ")");
                    }
                    if (startLine > endLine)
                    {
                        throw new RuntimeException("Start line (" + startLine + 
                            ") cannot be greater than end line (" + endLine + ")");
                    }
                    if (startLine > totalLines)
                    {
                        throw new RuntimeException("File only has " + totalLines + 
                            " lines (requested start at line " + startLine + ")");
                    }
                    if (endLine > totalLines)
                    {
                        throw new RuntimeException("File only has " + totalLines + 
                            " lines (requested up to line " + endLine + ")");
                    }
                } else
                {
                    throw new RuntimeException("পড়() function accepts 1-3 arguments (got " + 
                        expr.arguments().size() + ")");
                }
            }
    
            // Read the specified lines
            StringBuilder content = new StringBuilder();
            int currentLine = 0;
            
            if (handle.reader != null)
            {
                // BufferedReader mode
                String line;
                while ((line = handle.reader.readLine()) != null)
                {
                    currentLine++;
                    if (currentLine >= startLine && currentLine <= endLine)
                    {
                        content.append(line).append("\n");
                    }
                    if (currentLine > endLine) break;
                }
                // Reset reader
                handle.reader.close();
                handle.reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(handle.path), handle.charset));
            } else if (handle.raf != null)
            {
                // RandomAccessFile mode
                handle.raf.seek(0);
                String line;
                while ((line = handle.raf.readLine()) != null)
                {
                    currentLine++;
                    if (currentLine >= startLine && currentLine <= endLine)
                    {
                        content.append(new String(line.getBytes(StandardCharsets.ISO_8859_1), 
                            handle.charset)).append("\n");
                    }
                    if (currentLine > endLine) break;
                }
                // Reset position based on mode
                if (handle.mode == FileMode.APPEND || handle.mode == FileMode.APPEND_READ)
                {
                    handle.raf.seek(handle.raf.length());
                } else
                {
                    handle.raf.seek(0);
                }
            }
            
            return content.toString().trim();
        } catch (IOException e)
        {
            throw new RuntimeException("Failed to read file: " + e.getMessage());
        }
    }

    private int countLines(FileHandle handle) throws IOException
    {
        int lines = 0;
        
        if (handle.reader != null)
        {
            // Count lines using BufferedReader
            while (handle.reader.readLine() != null)
            {
                lines++;
            }
            // Reset reader
            handle.reader.close();
            handle.reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(handle.path), handle.charset));
        } else if (handle.raf != null)
        {
            // Count lines using RandomAccessFile
            handle.raf.seek(0);
            while (handle.raf.readLine() != null)
            {
                lines++;
            }
            // Reset position
            if (handle.mode == FileMode.APPEND || handle.mode == FileMode.APPEND_READ)
            {
                handle.raf.seek(handle.raf.length());
            } else
            {
                handle.raf.seek(0);
            }
        }
        
        return lines;
    }
       
    public void closeAllFiles()
    {
        try
        {
            for (FileHandle handle : fileHandles.values())
            {
                handle.close();
            }
            fileHandles.clear();
        } catch (IOException e)
        {
            System.err.println("\u001b[33mWarning: Failed to close some files: " + e.getMessage() + "\u001b[0m");
        }
    }

    @Override
    public Object visitCloseFilesExpr(CloseFilesExpr expr)
    {
        List<Object> handles = new Vector<>();
        for (Expr handleExpr : expr.fileHandles())
        {
            handles.add(evaluate(handleExpr));
        }
    
        AtomicInteger successCount = new AtomicInteger(0);
        AtomicInteger failureCount = new AtomicInteger(0);
    
        try (var executor = Executors.newVirtualThreadPerTaskExecutor())
        {
            List<Future<?>> futures = new Vector<>();
    
            for (Object handle : handles)
            {
                futures.add(executor.submit(() ->
                {
                    try
                    {
                        if (!(handle instanceof String))
                        {
                            failureCount.incrementAndGet();
                            return;
                        }
    
                        FileHandle fileHandle = fileHandles.get((String) handle);
                        if (fileHandle != null)
                        {
                            fileHandle.close();
                            fileHandles.remove((String) handle);
                            successCount.incrementAndGet();
                        }
                    } catch (Exception e)
                    {
                        System.err.println("Error closing file " + handle + ": " + e.getMessage());
                        failureCount.incrementAndGet();
                    }
                }));
            }
    
            // Wait for all tasks to complete
            for (Future<?> future : futures)
             {
                try
                {
                    future.get();
                } catch (Exception e)
                {
                    System.err.println("Error waiting for file closure: " + e.getMessage());
                }
            }
        } catch (Exception e)
        {
            System.err.println("Executor service error: " + e.getMessage());
        }
    
        return failureCount.get() == 0 ? 0 : -1;
    }

    @Override
    public Object visitDeleteFilesExpr(DeleteFilesExpr expr)
    {
        List<Object> handles = new Vector<>();
        for (Expr handleExpr : expr.fileHandles())
        {
            handles.add(evaluate(handleExpr));
        }
    
        AtomicInteger successCount = new AtomicInteger(0);
        AtomicInteger failureCount = new AtomicInteger(0);
        List<String> errorMessages = Collections.synchronizedList(new Vector<>());
    
        try (var executor = Executors.newVirtualThreadPerTaskExecutor())
        {
            List<Future<?>> futures = new Vector<>();
    
            for (Object handle : handles)
            {
                futures.add(executor.submit(() ->
                {
                    try
                    {
                        if (!(handle instanceof String))
                        {
                            throw new RuntimeException("File reference must be a string");
                        }
    
                        String fileRef = (String)handle;
                        
                        // Case 1: It's a registered file handle
                        if (fileHandles.containsKey(fileRef))
                        {
                            FileHandle fileHandle = fileHandles.get(fileRef);
                            if (!fileHandle.canDelete())
                            {
                                throw new RuntimeException("Cannot delete file opened in read mode: " + fileRef);
                            }
                            fileHandle.delete();
                            fileHandles.remove(fileRef);
                        } 
                        // Case 2: It's a direct file path
                        else
                        {
                            File file = new File(fileRef);
                            if (!file.exists())
                            {
                                throw new RuntimeException("File not found: " + fileRef);
                            }
                            if (!file.delete())
                            {
                                throw new RuntimeException("Failed to delete file: " + fileRef);
                            }
                        }
                        successCount.incrementAndGet();
                    } catch (Exception e)
                    {
                        errorMessages.add("Error deleting file " + handle + ": " + e.getMessage());
                        failureCount.incrementAndGet();
                    }
                }));
            }
    
            // Wait for all tasks to complete
            for (Future<?> future : futures)
            {
                try
                {
                    future.get();
                } catch (Exception e)
                {
                    errorMessages.add("Error waiting for file deletion: " + e.getMessage());
                }
            }
        } catch (Exception e)
        {
            errorMessages.add("Executor service error: " + e.getMessage());
        }
    
        // Print all error messages
        if (!errorMessages.isEmpty())
        {
            for (String error : errorMessages)
            {
                System.err.println(error);
            }
        }
    
        return failureCount.get() == 0 ? 0 : -1;
    }

    @Override
    public Object visitFileCutExpr(FileCutExpr expr)
    {
        Object sourceObj = evaluate(expr.sourcePath());
        Object destObj = evaluate(expr.destPath());
        
        if (!(sourceObj instanceof String) || !(destObj instanceof String))
        {
            throw new RuntimeException("File paths must be strings");
        }
        
        String sourcePath = (String)sourceObj;
        String destPath = (String)destObj;
        
        try
        {
            Path source = Paths.get(sourcePath);
            Path dest = Paths.get(destPath);
            
            // If destination is a directory, keep the original filename
            if (Files.isDirectory(dest))
            {
                dest = dest.resolve(source.getFileName());
            }
            
            // First copy
            Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
            
            // Then delete original
            Files.delete(source);
            
            return 0; // Success
        } catch (IOException e)
        {
            return -1; // Error
        }
    }

    @Override
    public Object visitFileCopyExpr(FileCopyExpr expr)
    {
        Object sourceObj = evaluate(expr.sourcePath());
        Object destObj = evaluate(expr.destPath());
        
        if (!(destObj instanceof String))
        {
            throw new RuntimeException("Destination path must be a string");
        }
        
        String destPath = (String)destObj;
        
        try
        {
            Path dest = Paths.get(destPath);
            
            // Handle case where source is a file handle
            if (sourceObj instanceof String && fileHandles.containsKey(sourceObj))
            {
                FileHandle sourceHandle = fileHandles.get(sourceObj);
                
                // If destination is a directory, keep the original filename
                if (Files.isDirectory(dest))
                {
                    dest = dest.resolve(Paths.get(sourceHandle.path).getFileName());
                }
                
                // Close the file if it's open (to prevent locking issues)
                sourceHandle.close();
                
                // Perform the copy
                Files.copy(Paths.get(sourceHandle.path), dest, StandardCopyOption.REPLACE_EXISTING);
                
                // Reopen the file if it was open
                if (sourceHandle.reader != null || sourceHandle.writer != null || sourceHandle.raf != null)
                {
                    fileHandles.put((String)sourceObj, new FileHandle(sourceHandle.path, sourceHandle.mode));
                }
                
                return 0;
            }
            // Handle case where source is a direct path
            else if (sourceObj instanceof String)
            {
                Path source = Paths.get((String)sourceObj);
                
                // If destination is a directory, keep the original filename
                if (Files.isDirectory(dest))
                {
                    dest = dest.resolve(source.getFileName());
                }
                
                Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
                return 0;
            } else
            {
                throw new RuntimeException("Source must be either a file path or file handle");
            }
        } catch (IOException e)
        {
            return -1;
        }
    }

// Add these methods to your Interpreter class

// Binary read operation
    @Override
    public Object visitBinaryReadExpr(BinaryReadExpr expr)
    {
        Object handleName = evaluate(expr.fileHandle());
        if (!(handleName instanceof String))throw new RuntimeException("File handle must be a string");
        
        
        FileHandle handle = fileHandles.get(handleName);
        if (handle == null)throw new RuntimeException("Invalid file handle '" + handleName + "'");

        try {
            byte[] byteData;
            
            if (expr.bytesToRead() != null) {
                Object bytesObj = evaluate(expr.bytesToRead());
                if (!(bytesObj instanceof BigDecimal)) {
                    throw new RuntimeException("Bytes to read must be an integer");
                }
                int bytes = ((BigDecimal)bytesObj).intValue();
                byteData = handle.readBinary(bytes);
            } else {
                byteData = handle.readAllBinary();
            }
            
            // Convert byte array to KalpanaList
            KalpanaList resultList = new KalpanaList();
            for (byte b : byteData) {
                // Convert signed byte to unsigned int (0-255)
                int unsignedByte = b & 0xFF;
                resultList.add(new BigDecimal(unsignedByte));
            }
            
            return resultList;
        } catch (IOException e) {
            throw new RuntimeException("Failed to read binary file: " + e.getMessage());
        }
    }
    
    // Binary write operation  
    @Override
    public Object visitBinaryWriteExpr(BinaryWriteExpr expr) {
        Object handleName = evaluate(expr.fileHandle());
        Object dataObj = evaluate(expr.data());
        
        if (!(handleName instanceof String)) {
            throw new RuntimeException("File handle must be a string");
        }
        
        FileHandle handle = fileHandles.get(handleName);
        if (handle == null) {
            throw new RuntimeException("Invalid file handle '" + handleName + "'");
        }
        
        try {
            byte[] byteData;
            
            // Handle both arrays and lists
            if (dataObj instanceof Object[]) {
                // Convert from array
                Object[] dataArray = (Object[])dataObj;
                byteData = new byte[dataArray.length];
                for (int i = 0; i < dataArray.length; i++) {
                    if (!(dataArray[i] instanceof BigDecimal)) {
                        throw new RuntimeException("Byte array must contain numbers (0-255)");
                    }
                    int byteValue = ((BigDecimal)dataArray[i]).intValue();
                    if (byteValue < 0 || byteValue > 255) {
                        throw new RuntimeException("Byte value must be between 0 and 255");
                    }
                    byteData[i] = (byte)byteValue;
                }
            } else if (dataObj instanceof KalpanaList) {
                // Convert from list
                KalpanaList dataList = (KalpanaList)dataObj;
                byteData = new byte[dataList.size()];
                for (int i = 0; i < dataList.size(); i++) {
                    Object element = dataList.get(i + 1); // KalpanaList uses 1-based indexing
                    if (!(element instanceof BigDecimal)) {
                        throw new RuntimeException("Byte list must contain numbers (0-255)");
                    }
                    int byteValue = ((BigDecimal)element).intValue();
                    if (byteValue < 0 || byteValue > 255) {
                        throw new RuntimeException("Byte value must be between 0 and 255");
                    }
                    byteData[i] = (byte)byteValue;
                }
            } else {
                throw new RuntimeException("Data must be a byte array or list");
            }
            
            if (expr.offset() != null && expr.length() != null) {
                Object offsetObj = evaluate(expr.offset());
                Object lengthObj = evaluate(expr.length());
                if (!(offsetObj instanceof BigDecimal) || !(lengthObj instanceof BigDecimal)) {
                    throw new RuntimeException("Offset and length must be integers");
                }
                int offset = ((BigDecimal)offsetObj).intValue();
                int length = ((BigDecimal)lengthObj).intValue();
                handle.writeBinary(byteData, offset, length);
            } else {
                handle.writeBinary(byteData);
            }
            return 0; // Success
        } catch (IOException e) {
            throw new RuntimeException("Failed to write binary file: " + e.getMessage());
        }
    }
    
    // File seek operation
    @Override
    public Object visitFileSeekExpr(FileSeekExpr expr) {
        Object handleName = evaluate(expr.fileHandle());
        Object positionObj = evaluate(expr.position());
        
        if (!(handleName instanceof String)) {
            throw new RuntimeException("File handle must be a string");
        }
        
        if (!(positionObj instanceof BigDecimal)) {
            throw new RuntimeException("Position must be an integer");
        }
        
        FileHandle handle = fileHandles.get(handleName);
        if (handle == null) {
            throw new RuntimeException("Invalid file handle '" + handleName + "'");
        }
        
        // Check if file supports seeking
        if (!handle.supportsSeek()) {
            throw new RuntimeException("File '" + handleName + "' does not support seeking. " +
                                     "Open file with 'r+b', 'w+b', or 'a+b' mode for seek support.");
        }
        
        try {
            long position = ((BigDecimal)positionObj).longValue();
            handle.seek(position);
            return 0; // Success
        } catch (IOException e) {
            throw new RuntimeException("Failed to seek in file: " + e.getMessage());
        }
    }
        
    // File position operation
    @Override
    public Object visitFilePositionExpr(FilePositionExpr expr) {
        Object handleName = evaluate(expr.fileHandle());
        
        if (!(handleName instanceof String)) {
            throw new RuntimeException("File handle must be a string");
        }
        
        FileHandle handle = fileHandles.get(handleName);
        if (handle == null) {
            throw new RuntimeException("Invalid file handle '" + handleName + "'");
        }
        
        try {
            long position = handle.getPosition();
            return new BigDecimal(position);
        } catch (IOException e) {
            throw new RuntimeException("Failed to get file position: " + e.getMessage());
        }
    }
    
    // File size operation
    @Override
    public Object visitFileSizeExpr(FileSizeExpr expr) {
        Object handleName = evaluate(expr.fileHandle());
        
        if (!(handleName instanceof String)) {
            throw new RuntimeException("File handle must be a string");
        }
        
        FileHandle handle = fileHandles.get(handleName);
        if (handle == null) {
            throw new RuntimeException("Invalid file handle '" + handleName + "'");
        }
        
        try {
            long size = handle.getSize();
            return new BigDecimal(size);
        } catch (IOException e) {
            throw new RuntimeException("Failed to get file size: " + e.getMessage());
        }
    }

    @Override
    public Object visitRegexExpr(RegexExpr expr)
    {
        Object inputObj = evaluate(expr.sourceString());
        Object patternObj = evaluate(expr.regexString());
        
        if (!(inputObj instanceof String)) throw new RuntimeException("First argument must be a string");
        if (!(patternObj instanceof String)) throw new RuntimeException("Regex pattern must be a string");
        
        String input = (String)inputObj;
        String regex = (String)patternObj;
        
        try
        {
            // compile the regex pattern and match against input string
            return Pattern.compile(regex, Pattern.UNICODE_CASE).matcher(input).matches();
        } catch (Exception e)
        {
            throw new RuntimeException("Invalid regex pattern: " + e.getMessage());
        }
    }
    @Override
    public Object visitRegexFindExpr(RegexFindExpr expr)
    {
        Object sourceObj = evaluate(expr.sourceString());
        Object regexObj = evaluate(expr.regexString());
        
        if (!(sourceObj instanceof String)) throw new RuntimeException("Source must be a string");
        if (!(regexObj instanceof String)) throw new RuntimeException("Regex pattern must be a string");
        
        String source = (String)sourceObj;
        String regex = (String)regexObj;
        
        try
        {
            Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(source);
            if (matcher.find())
            {
                return matcher.group();
            }
            return ""; // Return empty string if no match found
        } catch (Exception e)
        {
            throw new RuntimeException("Invalid regex pattern: " + e.getMessage());
        }
    }
    
    @Override
    public Object visitRegexFindAllExpr(RegexFindAllExpr expr)
    {
        Object sourceObj = evaluate(expr.sourceString());
        Object regexObj = evaluate(expr.regexString());
        
        if (!(sourceObj instanceof String)) throw new RuntimeException("Source must be a string");
        if (!(regexObj instanceof String)) throw new RuntimeException("Regex pattern must be a string");
        
        String source = (String)sourceObj;
        String regex = (String)regexObj;
        
        try
        {
            Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(source);
            List<String> matches = new Vector<>();
            
            while (matcher.find())
            {
                matches.add(matcher.group());
            }
            
            return matches.toArray(new String[0]);
        } catch (Exception e)
        {
            throw new RuntimeException("Invalid regex pattern: " + e.getMessage());
        }
    }
    
    @Override
    public Object visitRegexReplaceExpr(RegexReplaceExpr expr)
    {
        Object sourceObj = evaluate(expr.sourceString());
        Object regexObj = evaluate(expr.regexString());
        Object replacementObj = evaluate(expr.replacement());
        
        if (!(sourceObj instanceof String)) throw new RuntimeException("Source must be a string");
        if (!(regexObj instanceof String)) throw new RuntimeException("Regex pattern must be a string");
        if (!(replacementObj instanceof String)) throw new RuntimeException("Replacement must be a string");
        
        String source = (String)sourceObj;
        String regex = (String)regexObj;
        String replacement = (String)replacementObj;
        
        try
        {
            Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CASE);
            Matcher matcher = pattern.matcher(source);
            return matcher.replaceAll(replacement);
        } catch (Exception e)
        {
            throw new RuntimeException("Invalid regex pattern: " + e.getMessage());
        }
    }
    
    @Override
    public Object visitRegexSplitExpr(RegexSplitExpr expr)
    {
        Object sourceObj = evaluate(expr.sourceString());
        Object regexObj = evaluate(expr.regexString());
        
        if (!(sourceObj instanceof String)) throw new RuntimeException("Source must be a string");
        if (!(regexObj instanceof String)) throw new RuntimeException("Regex pattern must be a string");
        
        String source = (String)sourceObj;
        String regex = (String)regexObj;
        
        try
        {
            Pattern pattern = Pattern.compile(regex, Pattern.UNICODE_CASE);
            return pattern.split(source);
        } catch (Exception e)
        {
            throw new RuntimeException("Invalid regex pattern: " + e.getMessage());
        }
    }

    @Override
    public Void visitForEachStmt(ForEach stmt)
    {
        Object collection = evaluate(stmt.collection());
        
        if (!(collection instanceof Object[]))
        {
            throw new RuntimeException("Foreach loop requires an array");
        }
        
        Object[] array = (Object[])collection;
        
        for (Object element : array)
        {
            // Convert element to variable type if needed
            Object value = convertToExpectedType(element, stmt.variable().type);
            environment.define(stmt.variable().lexeme, value);
            
            try
            {
                execute(stmt.body());
            }
            catch (BreakException e)
            {
                break;
            }
            catch (ContinueException e)
            {
                continue;
            }
        }
        
        return null;
    }

    @Override
    public Void visitVarWithAccessStmt(VarWithAccess stmt)
    {
        // This is handled during class creation, so we can just return null
        return null;
    }
    
    @Override
    public Void visitArrayStmtWithAccessStmt(ArrayStmtWithAccess stmt)
    {
        // This is handled during class creation, so we can just return null
        return null;
    }
    
    @Override
    public Void visitFunctionWithAccessStmt(FunctionWithAccess stmt)
    {
        // Store the function with access information
        environment.defineFunction(stmt.name().lexeme, new Function(stmt.name(), stmt.returnType(), 
                                                                  stmt.parameters(), stmt.body(), 
                                                                  stmt.isTemporary(), stmt.environment()));
        return null;
    }

    @Override
    public Void visitClassStmt(ClassStmt stmt)
    {
        Map<String, Function> methods = new LinkedHashMap<>();
        Map<String, Boolean> methodAccess = new LinkedHashMap<>();
        Map<String, TokenType> fieldTypes = new LinkedHashMap<>();
        Map<String, Boolean> fieldAccess = new LinkedHashMap<>();
        Map<String, Object> initialFieldValues = new LinkedHashMap<>();
        
        // Extract methods and fields from class members with access modifiers
        for (Stmt member : stmt.members())
        {
            if (member instanceof FunctionWithAccess)
            {
                FunctionWithAccess func = (FunctionWithAccess) member;
                methods.put(func.name().lexeme, new Function(func.name(), func.returnType(), 
                                                           func.parameters(), func.body(), 
                                                           func.isTemporary(), func.environment()));
                methodAccess.put(func.name().lexeme, func.isPublic());
            } 
            else if (member instanceof Function)
            {
                // Handle functions without explicit access modifier (default to public)
                Function func = (Function) member;
                methods.put(func.name().lexeme, func);
                methodAccess.put(func.name().lexeme, true);
            }
            else if (member instanceof VarWithAccess)
            {
                VarWithAccess var = (VarWithAccess) member;
                String fieldName = var.name().lexeme;
                TokenType fieldType = var.name().type;
                fieldTypes.put(fieldName, fieldType);
                fieldAccess.put(fieldName, var.isPublic());
                
                // Evaluate and store the initial value if provided
                if (var.initializer() != null)
                {
                    try
                    {
                        Object initialValue = evaluate(var.initializer());
                        initialFieldValues.put(fieldName, initialValue);
                    } 
                    catch (Exception e)
                    {
                        System.err.println("Warning: Could not evaluate initial value for field '" + 
                                         fieldName + "': " + e.getMessage());
                        initialFieldValues.put(fieldName, getDefaultValueForType(fieldType));
                    }
                } 
                else
                {
                    initialFieldValues.put(fieldName, getDefaultValueForType(fieldType));
                }
            }
            else if (member instanceof ArrayStmtWithAccess)
            {
                ArrayStmtWithAccess arrayStmt = (ArrayStmtWithAccess) member;
                String fieldName = arrayStmt.name().lexeme;
                TokenType fieldType = arrayStmt.type();
                fieldTypes.put(fieldName, fieldType);
                fieldAccess.put(fieldName, arrayStmt.isPublic());
                
                // Evaluate and store the initial array value if provided
                if (!arrayStmt.initialValues().isEmpty())
                {
                    try
                    {
                        // Use a temporary environment with global scope to evaluate the initializer
                        Environment tempEnv = new Environment(getGlobalEnvironment());
                        
                        // Store the current environment and switch to temp environment
                        Environment previousEnv = this.environment;
                        this.environment = tempEnv;
                        
                        try
                        {
                            Object[] array = createArrayFromInitialValues(arrayStmt);
                            initialFieldValues.put(fieldName, array);
                        }
                        finally
                        {
                            // Restore the original environment
                            this.environment = previousEnv;
                        }
                    } 
                    catch (Exception e)
                    {
                        System.err.println("Warning: Could not evaluate initial array value for field '" + 
                                         fieldName + "': " + e.getMessage());
                        initialFieldValues.put(fieldName, getDefaultArrayForType(fieldType));
                    }
                } 
                else
                {
                    initialFieldValues.put(fieldName, getDefaultArrayForType(fieldType));
                }
            }
            else if (member instanceof Var)
            {
                // Handle variables without explicit access modifier (default to public)
                Var var = (Var) member;
                String fieldName = var.name().lexeme;
                TokenType fieldType = var.name().type;
                fieldTypes.put(fieldName, fieldType);
                fieldAccess.put(fieldName, true);
                
                // Evaluate and store the initial value if provided
                if (var.initializer() != null)
                {
                    try
                    {
                        Object initialValue = evaluate(var.initializer());
                        initialFieldValues.put(fieldName, initialValue);
                    } 
                    catch (Exception e)
                    {
                        System.err.println("Warning: Could not evaluate initial value for field '" + 
                                         fieldName + "': " + e.getMessage());
                        initialFieldValues.put(fieldName, getDefaultValueForType(fieldType));
                    }
                } 
                else
                {
                    initialFieldValues.put(fieldName, getDefaultValueForType(fieldType));
                }
            }
            else if (member instanceof ArrayStmt)
            {
                // Handle arrays without explicit access modifier (default to public)
                ArrayStmt arrayStmt = (ArrayStmt) member;
                String fieldName = arrayStmt.name().lexeme;
                TokenType fieldType = arrayStmt.type();
                fieldTypes.put(fieldName, fieldType);
                fieldAccess.put(fieldName, true);
                
                // Evaluate and store the initial array value if provided
                if (!arrayStmt.initialValues().isEmpty())
                {
                    try
                    {
                        // Use a temporary environment with global scope to evaluate the initializer
                        Environment tempEnv = new Environment(getGlobalEnvironment());
                        
                        // Store the current environment and switch to temp environment
                        Environment previousEnv = this.environment;
                        this.environment = tempEnv;
                        
                        try
                        {
                            Object[] array = createArrayFromInitialValues(arrayStmt);
                            initialFieldValues.put(fieldName, array);
                        }
                        finally
                        {
                            // Restore the original environment
                            this.environment = previousEnv;
                        }
                    } 
                    catch (Exception e)
                    {
                        System.err.println("Warning: Could not evaluate initial array value for field '" + 
                                         fieldName + "': " + e.getMessage());
                        initialFieldValues.put(fieldName, getDefaultArrayForType(fieldType));
                    }
                } 
                else
                {
                    initialFieldValues.put(fieldName, getDefaultArrayForType(fieldType));
                }
            }
        }
        
        ClassDefinition classDef = new ClassDefinition(stmt.name().lexeme, methods, fieldTypes, 
                                                     methodAccess, fieldAccess);
        
        // Store class definition and initial values in environment
        Token classDefToken = new Token(TokenType.IDENTIFIER, stmt.name().lexeme + "_class", null, stmt.name().line);
        Token fieldValuesToken = new Token(TokenType.IDENTIFIER, stmt.name().lexeme + "_fields", null, stmt.name().line);
        Token fieldAccessToken = new Token(TokenType.IDENTIFIER, stmt.name().lexeme + "_access", null, stmt.name().line);
        
        environment.define(classDefToken.lexeme, classDef);
        environment.define(fieldValuesToken.lexeme, initialFieldValues);
        environment.define(fieldAccessToken.lexeme, fieldAccess);
        
        return null;
    }
    
    // Helper method for visitClassStmt
    private Object getDefaultValueForType(TokenType type)
    {
        switch (type)
        {
            case INTEGER:
                return BigDecimal.ZERO;
            case FLOAT:
                return new BigDecimal("0.0");
            case STRING:
                return "";
            case BOOLEAN:
                return false;
            default:
                return null;
        }
    }

    // Helper method to create array from initial values in class.
    private Object[] createArrayFromInitialValues(Stmt arrayStmt)
    {
        TokenType arrayType;
        List<Expr> initialValues;
        
        if (arrayStmt instanceof ArrayStmt)
        {
            ArrayStmt stmt = (ArrayStmt) arrayStmt;
            arrayType = stmt.type();
            initialValues = stmt.initialValues();
        } 
        else if (arrayStmt instanceof ArrayStmtWithAccess)
        {
            ArrayStmtWithAccess stmt = (ArrayStmtWithAccess) arrayStmt;
            arrayType = stmt.type();
            initialValues = stmt.initialValues();
        } 
        else
        {
            throw new RuntimeException("Expected array statement");
        }
        
        // Handle the case where there's only one initial value that might be an array
        if (initialValues.size() == 1)
        {
            Object singleValue = evaluate(initialValues.get(0));
            
            // If the single value is already an array (from array generator or function return)
            if (singleValue instanceof Object[])
            {
                Object[] sourceArray = (Object[])singleValue;
                
                // Convert to the appropriate array type based on the declared type
                switch (arrayType)
                {
                    case INTEGER_ARRAY:
                        BigDecimal[] intArray = new BigDecimal[sourceArray.length];
                        for (int i = 0; i < sourceArray.length; i++)
                        {
                            Object element = sourceArray[i];
                            if (element instanceof BigDecimal)
                            {
                                intArray[i] = ((BigDecimal)element).setScale(0, RoundingMode.DOWN);
                            }
                            else
                            {
                                throw new RuntimeException("Integer array can only contain numbers");
                            }
                        }
                        return intArray;
                        
                    case FLOAT_ARRAY:
                        BigDecimal[] floatArray = new BigDecimal[sourceArray.length];
                        for (int i = 0; i < sourceArray.length; i++)
                        {
                            Object element = sourceArray[i];
                            if (element instanceof BigDecimal)
                            {
                                floatArray[i] = (BigDecimal)element;
                            }
                            else
                            {
                                throw new RuntimeException("Float array can only contain numbers");
                            }
                        }
                        return floatArray;
                        
                    case STRING_ARRAY:
                        String[] stringArray = new String[sourceArray.length];
                        for (int i = 0; i < sourceArray.length; i++)
                        {
                            stringArray[i] = stringify(sourceArray[i]);
                        }
                        return stringArray;
                        
                    case BOOLEAN_ARRAY:
                        Boolean[] boolArray = new Boolean[sourceArray.length];
                        for (int i = 0; i < sourceArray.length; i++)
                        {
                            Object element = sourceArray[i];
                            if (element instanceof Boolean)
                            {
                                boolArray[i] = (Boolean)element;
                            }
                            else if (element instanceof BigDecimal)
                            {
                                boolArray[i] = !((BigDecimal)element).equals(BigDecimal.ZERO);
                            }
                            else
                            {
                                throw new RuntimeException("Boolean array can only contain booleans or numbers");
                            }
                        }
                        return boolArray;
                        
                    default:
                        throw new RuntimeException("Unknown array type");
                }
            }
        }
        
        // Original logic for multiple initial values
        List<Object> values = new Vector<>();
        
        for (Expr initialValue : initialValues)
        {
            Object value = evaluate(initialValue);
            values.add(value);
        }
        
        // Convert to appropriate array type
        switch (arrayType)
        {
            case INTEGER_ARRAY:
                BigDecimal[] intArray = new BigDecimal[values.size()];
                for (int i = 0; i < values.size(); i++)
                {
                    Object val = values.get(i);
                    if (val instanceof BigDecimal)
                    {
                        intArray[i] = ((BigDecimal)val).setScale(0, RoundingMode.DOWN);
                    }
                    else
                    {
                        throw new RuntimeException("Integer array can only contain numbers");
                    }
                }
                return intArray;
                
            case FLOAT_ARRAY:
                BigDecimal[] floatArray = new BigDecimal[values.size()];
                for (int i = 0; i < values.size(); i++)
                {
                    Object val = values.get(i);
                    if (val instanceof BigDecimal)
                    {
                        floatArray[i] = (BigDecimal)val;
                    }
                    else
                    {
                        throw new RuntimeException("Float array can only contain numbers");
                    }
                }
                return floatArray;
                
            case STRING_ARRAY:
                String[] stringArray = new String[values.size()];
                for (int i = 0; i < values.size(); i++)
                {
                    stringArray[i] = stringify(values.get(i));
                }
                return stringArray;
                
            case BOOLEAN_ARRAY:
                Boolean[] boolArray = new Boolean[values.size()];
                boolean showedWarning = false;
                
                for (int i = 0; i < values.size(); i++)
                {
                    Object val = values.get(i);
                    
                    if (val instanceof BigDecimal)
                    {
                        if (!showedWarning)
                        {
                            System.out.println( "Warning: Auto-converting numbers to booleans (0=false, non-zero=true)" );
                            showedWarning = true;
                        }
                        boolArray[i] = !((BigDecimal)val).equals(BigDecimal.ZERO);
                    } 
                    else if (val instanceof Boolean)
                    {
                        boolArray[i] = (Boolean)val;
                    }
                    else if (val instanceof String)
                    {
                        throw new RuntimeException("Cannot convert string to boolean in array");
                    }
                    else
                    {
                        throw new RuntimeException("Boolean array elements must be numbers or booleans");
                    }
                }
                return boolArray;
                
            default:
                throw new RuntimeException("Unknown array type");
        }
    }
    
    // Helper method to get default array for a type
    private Object[] getDefaultArrayForType(TokenType type)
    {
        switch (type)
        {
            case INTEGER_ARRAY:
                return new BigDecimal[0];
            case FLOAT_ARRAY:
                return new BigDecimal[0];
            case STRING_ARRAY:
                return new String[0];
            case BOOLEAN_ARRAY:
                return new Boolean[0];
            default:
                return new Object[0];
        }
    }

    @Override
    public Object visitObjectExpr(ObjectExpr expr)
    {
        String className = expr.className().lexeme;
        
        // Get class definition
        Token classDefToken = new Token(TokenType.IDENTIFIER, className + "_class", null, expr.className().line);
        Object classDefObj = environment.get(classDefToken);
        if (!(classDefObj instanceof ClassDefinition))
        {
            throw new RuntimeException("Undefined class '" + className + "'");
        }
        ClassDefinition classDef = (ClassDefinition) classDefObj;
        
        // Get initial field values
        Token fieldValuesToken = new Token(TokenType.IDENTIFIER, className + "_fields", null, expr.className().line);
        Object fieldValuesObj = environment.get(fieldValuesToken);
        Map<String, Object> initialFieldValues = null;
        
        if (fieldValuesObj instanceof Map)
        {
            try
            {
                @SuppressWarnings("unchecked")
                Map<String, Object> fieldValues = (Map<String, Object>) fieldValuesObj;
                initialFieldValues = new LinkedHashMap<>(fieldValues); // Start with default values
            } catch (ClassCastException e)
            {
                System.err.println("Warning: Invalid field values for class '" + className + "'");
            }
        }
        
        // Evaluate constructor arguments
        List<Object> constructorArgs = new Vector<>();
        for (Expr argExpr : expr.arguments())
        {
            constructorArgs.add(evaluate(argExpr));
        }
        
        // Create class instance
        ClassInstance instance = new ClassInstance(classDef, initialFieldValues, this);
        
        // Look for constructor method
        Function constructor = classDef.findMethod("constructor");
        if (constructor != null)
        {
            // Validate argument count
            if (constructorArgs.size() != constructor.parameters().size())
            {
                throw new RuntimeException("Expected " + constructor.parameters().size() + 
                                         " arguments for constructor but got " + constructorArgs.size());
            }
            
            // Call constructor
            callConstructor(constructor, instance, constructorArgs);
        } else if (!expr.arguments().isEmpty())
        {
            throw new RuntimeException("Class '" + className + "' has no constructor that takes " + 
                                     expr.arguments().size() + " arguments");
        }
        
        return instance;
    }
    
    private void callConstructor(Function constructor, ClassInstance instance, List<Object> arguments)
    {
        // Create environment for constructor
        Environment constructorEnv = new Environment();
        constructorEnv.define("this", instance);
        
        // Set up parameters in the environment
        for (int i = 0; i < constructor.parameters().size(); i++)
        {
            Token param = constructor.parameters().get(i);
            Object value = arguments.get(i);
            
            // Convert value to the correct parameter type using the static method
            value = ClassInstance.convertToType(value, param.type);
            constructorEnv.define(param.lexeme, value);
        }
        
        // Execute constructor body
        Environment previous = this.environment;
        try
        {
            this.environment = constructorEnv;
            executeBlock(constructor.body(), this.environment);
        } catch (ReturnException returnValue)
        {
            // Constructors shouldn't return values, but if they do, ignore it
            System.err.println("Warning: Constructor should not return a value");
        } finally
        {
            this.environment = previous;
        }
    }
    
    @Override
    public Object visitDotExpr(DotExpr expr)
    {
        Object object = evaluate(expr.object());

        // Handle FILE properties
        if (object instanceof String && fileHandles.containsKey(object)) {
            String fileHandle = (String) object;
            FileHandle file = fileHandles.get(fileHandle);
            String propertyName = expr.name().lexeme;
            
            // Handle file properties
            switch (propertyName) {
                case "পথ":
                case "path":
                    return file.path;
                    
                case "মোড":
                case "mode":
                    return file.mode.toString();
                    
                case "খোলা":
                case "is_open":
                    try {
                        file.getPosition(); // This will throw if file is closed
                        return true;
                    } catch (IOException e) {
                        return false;
                    }
                    
                case "বাইনারি_মোড":
                case "is_binary":
                    return file.mode.isBinary();
                    
                case "সমর্থন_সিক":
                case "supports_seek":
                    return file.supportsSeek();
                    
                default:
                    throw new RuntimeException("Unknown file property: '" + propertyName + "'");
            }
        }

        if (object instanceof ClassInstance)
        {
            ClassInstance instance = (ClassInstance)object;
            ClassDefinition classDef = instance.getClassDefinition();
            String fieldName = expr.name().lexeme;
            
            // Check if field is private and we're accessing from outside the class
            if (classDef.hasField(fieldName) && !classDef.isFieldPublic(fieldName))
            {
                // Check if we're inside a method of the same class
                boolean insideSameClass = false;
                try
                {
                    Token thisToken = new Token(TokenType.IDENTIFIER, "this", null, expr.name().line);
                    Object thisObj = environment.get(thisToken);
                    if (thisObj instanceof ClassInstance)
                    {
                        ClassInstance currentInstance = (ClassInstance)thisObj;
                        if (currentInstance.getClassDefinition().name.equals(classDef.name))
                        {
                            insideSameClass = true;
                        }
                    }
                }
                catch (RuntimeException e)
                {
                    // No "this" reference found, so we're outside the class
                }
                
                if (!insideSameClass)
                {
                    throw new RuntimeException("Cannot access private field '" + fieldName + "' from outside class '" + classDef.name + "'");
                }
            }
            
            return instance.get(expr.name());
        }
        throw new RuntimeException("Only class instances have properties");
    }
    

    
    @Override
    public Object visitMethodCallExpr(MethodCallExpr expr)
    {
        Object object = evaluate(expr.object());
        if (!(object instanceof ClassInstance))
        {
            throw new RuntimeException("Only class instances have methods");
        }
        
        ClassInstance instance = (ClassInstance)object;
        ClassDefinition classDef = instance.getClassDefinition();
        String methodName = expr.method().lexeme;
        
        // keep access control checking
        if (classDef.hasMethod(methodName) && !classDef.isMethodPublic(methodName))
        {
            // Check if we're inside a method of the same class
            boolean insideSameClass = false;
            try
            {
                Token thisToken = new Token(TokenType.IDENTIFIER, "this", null, expr.method().line);
                Object thisObj = environment.get(thisToken);
                if (thisObj instanceof ClassInstance)
                {
                    ClassInstance currentInstance = (ClassInstance)thisObj;
                    if (currentInstance.getClassDefinition().name.equals(classDef.name))
                    {
                        insideSameClass = true;
                    }
                }
            }
            catch (RuntimeException e)
            {
                // No "this" reference found, so we're outside the class
            }
            
            if (!insideSameClass)
            {
                throw new RuntimeException("Cannot access private method '" + methodName + "' from outside class '" + classDef.name + "'");
            }
        }
        
        Object method = instance.get(expr.method());
        
        if (!(method instanceof Function))
        {
            throw new RuntimeException("Undefined method '" + expr.method().lexeme + "'");
        }
        
        Function function = (Function)method;
        
        // Get the global environment
        Environment globalEnv = getGlobalEnvironment();
        
        // Create a new environment that chains to global scope
        Environment methodEnv = new Environment(globalEnv);
        
        // Copy the function's bound environment (which includes 'this')
        if (function.environment() != null)
        {
            for (Map.Entry<String, Object> entry : function.environment().values.entrySet())
            {
                methodEnv.define(entry.getKey(), entry.getValue());
            }
            for (Map.Entry<String, Object[]> entry : function.environment().arrays.entrySet())
            {
                methodEnv.defineArray(entry.getKey(), function.environment().getArrayType(entry.getKey()), entry.getValue());
            }
        }
        
        // Ensure "this" is available
        if (!methodEnv.values.containsKey("this"))
        {
            methodEnv.define("this", instance);
        }
        
        List<Object> arguments = new Vector<>();
        for (Expr argument : expr.arguments())
        {
            arguments.add(evaluate(argument));
        }
        
        // Validate argument count
        if (arguments.size() != function.parameters().size())
        {
            throw new RuntimeException("Expected " + function.parameters().size() + 
                                     " arguments but got " + arguments.size() + 
                                     " for method '" + expr.method().lexeme + "'");
        }
        
        // Call the method with the new environment that has global scope access
        Environment previous = this.environment;
        try
        {
            this.environment = methodEnv;
            
            // Set up parameters in the environment
            for (int i = 0; i < function.parameters().size(); i++)
            {
                Token param = function.parameters().get(i);
                Object value = arguments.get(i);
                value = ClassInstance.convertToType(value, param.type);
                this.environment.define(param.lexeme, value);
            }
            
            executeBlock(function.body(), this.environment);
            return null;
        } catch (ReturnException returnValue)
        {
            return returnValue.value;
        } finally
        {
            this.environment = previous;
        }
    }
    
    // Add this helper method to the Interpreter class
    private Environment getGlobalEnvironment()
    {
        Environment current = this.environment;
        while (current.enclosing != null)
        {
            current = current.enclosing;
        }
        return current;
    }
    
    
    @Override
    public Object visitClassSelfExpr(ClassSelfExpr expr)
    {
        // Look for "this" in the current environment
        Token thisToken = new Token(TokenType.IDENTIFIER, "this", null, expr.keyword().line);
        Object thisObj;
        
        try
        {
            thisObj = environment.get(thisToken);
        }
        catch (RuntimeException e)
        {
            throw new RuntimeException("'ক্লাসের' can only be used inside class methods. No 'this' reference found.");
        }
        
        if (thisObj instanceof ClassInstance)
        {
            ClassInstance instance = (ClassInstance) thisObj;
            
            // Check if the field exists in the class definition
            ClassDefinition classDef = instance.getClassDefinition();
            String fieldName = expr.keyword().lexeme;
            
            if (!classDef.hasField(fieldName))
            {
                throw new RuntimeException("In class scope, no field found named '" + fieldName + "'");
            }
            
            // Get the field from the class instance
            return instance.get(expr.keyword());
        }
        
        throw new RuntimeException("'ক্লাসের' can only be used inside class methods");
    }
       
    @Override
    public Object visitClassSelfAssignment(ClassSelfAssignment expr)
    {
        // Look for "this" in the current environment
        Token thisToken = new Token(TokenType.IDENTIFIER, "this", null, expr.fieldName().line);
        Object thisObj;
        
        try
        {
            thisObj = environment.get(thisToken);
        }
        catch (RuntimeException e)
        {
            throw new RuntimeException("'ক্লাসের' assignment can only be used inside class methods. No 'this' reference found.");
        }
        
        if (thisObj instanceof ClassInstance)
        {
            ClassInstance instance = (ClassInstance) thisObj;
            
            // Check if the field exists in the class definition
            ClassDefinition classDef = instance.getClassDefinition();
            String fieldName = expr.fieldName().lexeme;
            
            if (!classDef.hasField(fieldName))
            {
                throw new RuntimeException("In class scope, no field found named '" + fieldName + "'");
            }
            
            Object value = evaluate(expr.value());
            
            // Set the field value on the class instance
            instance.set(expr.fieldName(), value);
            return value;
        }
        
        throw new RuntimeException("'ক্লাসের' assignment can only be used inside class methods");
    }

    @Override
    public Object visitClassSelfMethodCall(ClassSelfMethodCall expr)
    {
        // Look for "this" in the current environment
        try
        {
            Token thisToken = new Token(TokenType.IDENTIFIER, "this", null, expr.methodName().line);
            Object thisObj = environment.get(thisToken);
            
            if (thisObj instanceof ClassInstance)
            {
                ClassInstance instance = (ClassInstance) thisObj;
                
                // Get the method from the class instance
                Object method = instance.get(expr.methodName());
                
                if (!(method instanceof Function))
                {
                    throw new RuntimeException("'" + expr.methodName().lexeme + "' is not a method in class");
                }
                
                Function function = (Function) method;
                List<Object> arguments = new Vector<>();
                
                // Evaluate arguments
                for (Expr argument : expr.arguments())
                {
                    arguments.add(evaluate(argument));
                }
                
                // Validate argument count
                if (arguments.size() != function.parameters().size())
                {
                    throw new RuntimeException("Expected " + function.parameters().size() + 
                                             " arguments but got " + arguments.size() + 
                                             " for method '" + expr.methodName().lexeme + "'");
                }
                
                // Call the method with the bound environment
                Environment previous = this.environment;
                try
                {
                    // Use the function's bound environment (which includes 'this')
                    this.environment = function.environment();
                    
                    // Set up parameters in the environment
                    for (int i = 0; i < function.parameters().size(); i++)
                    {
                        Token param = function.parameters().get(i);
                        Object value = arguments.get(i);
                        
                        // Convert value to the correct parameter type
                        value = ClassInstance.convertToType(value, param.type);
                        this.environment.define(param.lexeme, value);
                    }
                    
                    executeBlock(function.body(), this.environment);
                    return null;
                } catch (ReturnException returnValue)
                {
                    return returnValue.value;
                } finally
                {
                    this.environment = previous;
                }
            }
            
            throw new RuntimeException("'ক্লাসের' can only be used inside class methods");
        } catch (RuntimeException e)
        {
            throw new RuntimeException("'ক্লাসের' can only be used inside class methods. No 'this' reference found.");
        }
    }
    @Override
    public Void visitFunctionStmt(Function stmt)
    {
        // Store the function with its parameter types
        environment.defineFunction(stmt.name().lexeme, stmt);
        // If it's a temporary function, we don't need to do anything special here
        // The cleanup will happen in visitCallExpr after the function is called
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

    public Object callFunction(Function function, List<Object> arguments)
    {
        // Get the global environment
        Environment globalEnv = getGlobalEnvironment();
        
        // Create function environment that chains to global scope
        Environment functionEnv = new Environment(globalEnv);
        
        // Copy the function's bound environment (which includes 'this' for methods)
        if (function.environment() != null)
        {
            for (Map.Entry<String, Object> entry : function.environment().values.entrySet())
            {
                functionEnv.define(entry.getKey(), entry.getValue());
            }
            for (Map.Entry<String, Object[]> entry : function.environment().arrays.entrySet())
            {
                functionEnv.defineArray(entry.getKey(), function.environment().getArrayType(entry.getKey()), entry.getValue());
            }
        }
        
        // Set up parameters
        for (int i = 0; i < function.parameters().size(); i++)
         {
            Token param = function.parameters().get(i);
            Object value = arguments.get(i);
            value = ClassInstance.convertToType(value, param.type);
            functionEnv.define(param.lexeme, value);
        }
        
        Environment previous = this.environment;
        try {
            this.environment = functionEnv;
            executeBlock(function.body(), this.environment);
            
            if (function.returnType().type != TokenType.VOID)
            {
                throw new RuntimeException("Function '" + function.name().lexeme + "' must return a value");
            }
            return null;
        } catch (ReturnException returnValue) {
            if (function.returnType().type != TokenType.VOID) {
                if (returnValue.value == null) {
                    throw new RuntimeException("Function must return a value");
                }
                return convertToExpectedType(returnValue.value, function.returnType().type);
            }
            return returnValue.value;
        } finally {
            this.environment = previous;
            
            // Remove temporary function after execution
            if (function.isTemporary())
            {
                Environment env = this.environment;
                while (env != null)
                 {
                    if (env.functions.containsKey(function.name().lexeme)) {
                        env.functions.remove(function.name().lexeme);
                        break;
                    }
                    env = env.enclosing;
                }
            }
        }
    }

/*
    public Object callFunction(Function function, List<Object> arguments)
    {
        // Handle default parameters with safe scope check
        List<Object> finalArguments = new Vector<>();
        boolean useDefaults = this.inSafeScope;
        
        for (int i = 0; i < function.parameters().size(); i++) {
            if (i < arguments.size()) {
                // Use provided argument
                finalArguments.add(arguments.get(i));
            } else if (function.hasDefaultValue(i)) {
                // Use default value (if available)
                if (useDefaults) {
                    // In safe scope - use default silently
                    Object defaultValue = evaluate(function.defaultValues().get(i));
                    finalArguments.add(defaultValue);
                } else {
                    // Outside safe scope - use default with warning
                    System.err.println("Warning: Using default value for parameter '" + 
                                     function.parameters().get(i).lexeme + 
                                     "' in function '" + function.name().lexeme + 
                                     "' outside safe scope");
                    Object defaultValue = evaluate(function.defaultValues().get(i));
                    finalArguments.add(defaultValue);
                }
            } else {
                // No argument and no default value - error
                throw new RuntimeException("Function '" + function.name().lexeme + 
                                         "' expects " + function.parameters().size() + 
                                         " arguments but got " + arguments.size());
            }
        }
        
        // Use the same pattern as in visitCallExpr
        Environment functionEnv = new Environment(function.environment());
        
        // Set up parameters with final arguments (including defaults)
        for (int i = 0; i < function.parameters().size(); i++)
        {
            Token param = function.parameters().get(i);
            Object value = finalArguments.get(i);
            
            // Type conversion
            value = convertToExpectedType(value, param.type);
            
            // Handle array parameters specially
            switch (param.type)
            {
                case INTEGER_ARRAY:
                case FLOAT_ARRAY:
                case STRING_ARRAY:
                case BOOLEAN_ARRAY:
                    functionEnv.defineArray(param.lexeme, param.type, (Object[])value);
                    break;
                default:
                    functionEnv.define(param.lexeme, value);
            }
        }
        
        Environment previous = this.environment;
        try
        {
            this.environment = functionEnv;
            executeBlock(function.body(), this.environment);
            
            if (function.returnType().type != TokenType.VOID)
            {
                throw new RuntimeException("Function '" + function.name().lexeme + "' must return a value");
            }
            return null;
        } catch (ReturnException returnValue)
        {
            // Handle return type checking
            if (function.returnType().type != TokenType.VOID)
            {
                if (returnValue.value == null)
                {
                    throw new RuntimeException("Function must return a value");
                }
                // Convert return value based on declared return type
                return convertToExpectedType(returnValue.value, function.returnType().type);
            }
            return returnValue.value;
        } finally
        {
            this.environment = previous;
            
            // Remove temporary function after execution
            if (function.isTemporary())
            {
                Environment env = this.environment;
                while (env != null)
                {
                    if (env.functions.containsKey(function.name().lexeme))
                    {
                        env.functions.remove(function.name().lexeme);
                        break;
                    }
                    env = env.enclosing;
                }
            }
        }
    }
*/
    @Override
    public Void visitSafeScopeStmt(SafeScope stmt)
    {
        boolean previousSafeScope = this.inSafeScope;
        this.inSafeScope = true;
        try {
            execute(stmt.body());
        } finally {
            this.inSafeScope = previousSafeScope;
        }
        return null;
    }
    @Override
    public Object visitStreamExpr(StreamExpr expr)
    {
        Object listObj = evaluate(expr.list());
        if (listObj instanceof KalpanaList)return ((KalpanaList)listObj).স্ট্রিমে(this);
        throw new RuntimeException("স্ট্রিম can only be applied to lists");
    }
    
    // Method to copy complete global state to thread interpreter
    private void copyCompleteGlobalState(Interpreter source, Interpreter target) {
        // Get the global environment from source
        Environment sourceGlobal = source.getGlobalEnvironment();
        Environment targetGlobal = target.getGlobalEnvironment();
        
        // Copy all variables
        for (Map.Entry<String, Object> entry : sourceGlobal.values.entrySet()) {
            Object value = entry.getValue();
            
            // SPECIAL HANDLING FOR FILE HANDLES
            if (value instanceof String && source.fileHandles.containsKey(value)) {
                // This is a file handle - copy the FileHandle object to target interpreter
                String handleName = (String) value;
                FileHandle originalHandle = source.fileHandles.get(handleName);
                
                try {
                    // Create a new FileHandle with the same properties
                    FileHandle copiedHandle = new FileHandle(originalHandle.path, originalHandle.mode);
                    target.fileHandles.put(handleName, copiedHandle);
                } catch (IOException e) {
                    throw new RuntimeException("Failed to copy file handle '" + handleName + "': " + e.getMessage());
                }
            }
            
            // SPECIAL HANDLING FOR CLASS DEFINITIONS
            if (entry.getKey().endsWith("_class") && value instanceof ClassDefinition) {
                // Copy class definitions
                targetGlobal.values.put(entry.getKey(), value);
            }
            // SPECIAL HANDLING FOR CLASS INSTANCES
            else if (value instanceof ClassInstance) {
                // For class instances, we need to create a deep copy
                ClassInstance originalInstance = (ClassInstance) value;
                ClassDefinition classDef = originalInstance.getClassDefinition();
                
                // Copy the field values
                Map<String, Object> copiedFields = new LinkedHashMap<>();
                // You'll need to implement a way to access the instance's fields
                // This might require adding a method to ClassInstance to get all fields
                
                // For now, we'll just share the instance (not thread-safe but works)
                targetGlobal.values.put(entry.getKey(), value);
            }
            else {
                targetGlobal.values.put(entry.getKey(), deepCopyObject(value));
            }
        }
        
        // Copy all arrays
        for (Map.Entry<String, Object[]> entry : sourceGlobal.arrays.entrySet()) {
            targetGlobal.arrays.put(entry.getKey(), deepCopyArray(entry.getValue()));
        }
        
        // Copy all functions with REBINDING to target environment
        for (Map.Entry<String, Function> entry : sourceGlobal.functions.entrySet()) {
            Function originalFunc = entry.getValue();
            
            // Create a new function with the same definition but bound to target environment
            Function copiedFunc = new Function(
                originalFunc.name(),
                originalFunc.returnType(),
                originalFunc.parameters(),
                originalFunc.body(),
                originalFunc.isTemporary(),
                targetGlobal,  // Bind to target environment
                originalFunc.defaultValues()
            );
            
            targetGlobal.functions.put(entry.getKey(), copiedFunc);
        }
        
        // Copy variable types
        targetGlobal.variableTypes.putAll(sourceGlobal.variableTypes);
        
        // Copy array types
        targetGlobal.arrayTypes.putAll(sourceGlobal.arrayTypes);
    }
    
    // Deep copy objects for thread safety
    private Object deepCopyObject(Object obj) {
        if (obj == null) return null;
        if (obj instanceof BigDecimal) return obj; // BigDecimal is immutable
        if (obj instanceof String) return obj;     // String is immutable
        if (obj instanceof Boolean) return obj;    // Boolean is immutable
        if (obj instanceof KalpanaList) return ((KalpanaList)obj).copy();
        // Add other types as needed
        return obj; // For unknown types, return as-is (risk of mutation)
    }
    
    // Deep copy arrays
    private Object[] deepCopyArray(Object[] array) {
        if (array == null) return null;
        Object[] copy = new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = deepCopyObject(array[i]);
        }
        return copy;
    }

    @Override
    public Object visitCallExpr(Call expr)
    {
        // Handle built-in functions
        if (expr.callee() instanceof Variable)
        {
            String functionName = ((Variable)expr.callee()).name().lexeme;

            if (functionName.equals("স্ট্রিমে"))
            {
                if (expr.arguments().size() != 1)throw new RuntimeException("স্ট্রিমে function expects 1 argument (list)");
                Object listObj = evaluate(expr.arguments().get(0));
                if (listObj instanceof KalpanaList)
                {
                    return ((KalpanaList)listObj).স্ট্রিমে(this);
                }
                throw new RuntimeException("স্ট্রিমে argument must be a list");
            }
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
                System.gc();
                System.exit(code);
                return null;
            }
            if (functionName.equals("নির্ণয়"))
            {
                if (expr.arguments().size() != 1)
                {
                    throw new RuntimeException("'নির্ণয়' expects exactly 1 argument (code to evaluate)");
                }
                
                Object codeObj = evaluate(expr.arguments().get(0));
                if (!(codeObj instanceof String))
                {
                    throw new RuntimeException("নির্ণয়() argument must be a string");
                }
                
                String code = (String)codeObj;
                
                // Store current environment
                Environment originalEnv = this.environment;
                
                try
                {
                    // Create completely isolated sandbox environment
                    Environment sandboxEnv = new Environment();
                    this.environment = sandboxEnv;
                    
                    // Translate and parse the code
                    String translatedCode = LanguageTranslator.translateToBangla(code);
                    Lexer lexer = new Lexer(translatedCode);
                    List<Token> tokens = lexer.scanTokens();
                    
                    // SIMPLIFIED APPROACH: Just try to parse as expression first
                    // If it fails, then parse as statements
                    boolean isPureExpression = false;
                    Object expressionResult = null;
                    
                    // Try as expression first
                    try
                    {
                        Parser exprParser = new Parser(new ArrayList<>(tokens));
                        Expr expression = exprParser.expression();
                        expressionResult = evaluate(expression);
                        isPureExpression = true;
                    }
                    catch (RuntimeException e)
                    {
                        // Not a pure expression, continue to statement parsing
                        isPureExpression = false;
                    }
                    
                    if (isPureExpression)
                    {
                        this.environment = originalEnv; // Restore environment
                        return expressionResult;
                    }
                    
                    // Parse as statements (for code like "print(\"Hello\");")
                    Parser stmtParser = new Parser(tokens);
                    List<Stmt> statements = stmtParser.parse();
                    
                    Object lastResult = null;
                    for (Stmt stmt : statements)
                    {
                        if (stmt instanceof Expression)
                        {
                            // Capture result of expression statements
                            lastResult = evaluate(((Expression)stmt).expression());
                        }
                        else if (stmt instanceof Return)
                        {
                            // Handle return statements
                            Return returnStmt = (Return)stmt;
                            if (returnStmt.value() != null)
                            {
                                lastResult = evaluate(returnStmt.value());
                            }
                            break;
                        }
                        else
                        {
                            // Execute other statements (print, variable declarations, etc.)
                            execute(stmt);
                        }
                    }
                    
                    this.environment = originalEnv; // Restore environment
                    return lastResult;
                    
                }
                catch (Exception e)
                {
                    // Ensure environment is restored even if error occurs
                    this.environment = originalEnv;
                    throw new RuntimeException("নির্ণয়() failed: " + e.getMessage());
                }
            }
            if (functionName.equals("ইউনিক্স_সময়"))
            {
                if (!expr.arguments().isEmpty())
                {
                    throw new RuntimeException("'ইউনিক্স_সময়' takes no arguments");
                }
                
                // Return current Unix time in milliseconds with decimal precision
                long currentTimeMillis = System.currentTimeMillis();
                long seconds = currentTimeMillis / 1000;
                long milliseconds = currentTimeMillis % 1000;
                
                // Create BigDecimal with seconds.milliseconds format
                return new BigDecimal(seconds + "." + String.format("%03d", milliseconds));
            }

            if (functionName.equals("থ্রেড"))
            {
                if (expr.arguments().isEmpty())
                {
                    throw new RuntimeException("'থ্রেড' expects at least 1 function to execute");
                }
                
                List<Thread> threads = new CopyOnWriteArrayList<>();
                List<Object> results = new CopyOnWriteArrayList<>();
                
                for (int i = 0; i < expr.arguments().size(); i++)
                {
                    results.add(null);
                }
                
                // Validate that all arguments are callable expressions
                for (int i = 0; i < expr.arguments().size(); i++)
                {
                    final Expr arg = expr.arguments().get(i);
                    
                    // Check if it's any type of callable expression
                    boolean isValidCall = (arg instanceof Call) || 
                                         (arg instanceof MethodCallExpr) ||
                                         (arg instanceof ClassSelfMethodCall) ||
                                         (arg instanceof ListMethodCall);  // ADD THIS LINE
                    
                    if (!isValidCall)
                    {
                        throw new RuntimeException("থ্রেড() requires function calls or method calls with parentheses. " +
                                                 "Got: " + arg.getClass().getSimpleName());
                    }
                }
                
                // Create a completely fresh interpreter that shares NOTHING
                for (int i = 0; i < expr.arguments().size(); i++)
                {
                    final Expr arg = expr.arguments().get(i);
                    final int index = i;
                    
                    Runnable threadTask = () ->
                    {
                        try
                        {
                            // Create COMPLETELY fresh interpreter
                            Interpreter threadInterpreter = new Interpreter();
                            
                            // Manually copy ALL global data by re-evaluating the entire program state
                            copyCompleteGlobalState(this, threadInterpreter);
                            
                            // Execute in the fresh environment
                            Object result = threadInterpreter.evaluate(arg);
                            results.set(index, result);
                        }
                        catch (Exception e)
                        {
                            System.err.println("থ্রেড error in function " + index + ": " + e.getMessage());
                            results.set(index, null);
                        }
                    };
                    
                    Thread thread;
                    if (expr.arguments().size() > 10)
                    {
                        thread = Thread.ofVirtual().name("kalpana-thread-" + index).start(threadTask);
                    }
                    else
                    {
                        thread = new Thread(threadTask, "kalpana-thread-" + index);
                        thread.start();
                    }
                    
                    threads.add(thread);
                }
                
                // Wait for completion
                for (Thread thread : threads)
                {
                    try
                    {
                        thread.join();
                    }
                    catch (InterruptedException e)
                    {
                        Thread.currentThread().interrupt();
                    }
                }
                
                return results.toArray();
            }
            if (functionName.equals("ইউনিকোড") || functionName.equals("unicode")) {
                if (expr.arguments().size() != 1) {
                    throw new RuntimeException("ইউনিকোড() function expects 1 argument (code point, character, or list)");
                }
                
                Object inputObj = evaluate(expr.arguments().get(0));
                
                // CASE 1: Input is NUMBER → Convert to character
                if (inputObj instanceof BigDecimal) {
                    BigDecimal codePointBD = (BigDecimal)inputObj;
                    
                    // Check if it's an integer
                    if (codePointBD.scale() > 0) {
                        throw new RuntimeException("ইউনিকোড() number argument must be an integer, got: " + codePointBD);
                    }
                    
                    int codePoint = codePointBD.intValue();
                    
                    // Validate code point range (Unicode range: 0 to 0x10FFFF)
                    if (codePoint < 0) {
                        throw new RuntimeException("Unicode code point cannot be negative: " + codePoint);
                    }
                    if (codePoint > 0x10FFFF) {
                        throw new RuntimeException("Unicode code point too large: " + codePoint + 
                            ". Maximum allowed: 1114111");
                    }
                    
                    // Check if it's a valid Unicode character
                    if (!Character.isValidCodePoint(codePoint)) {
                        throw new RuntimeException("Invalid Unicode code point: " + codePoint);
                    }
                    
                    // Check for surrogate characters (invalid standalone)
                    if (Character.isSurrogate((char)codePoint)) {
                        throw new RuntimeException("Invalid Unicode code point (surrogate): " + codePoint);
                    }
                    
                    try {
                        // Convert code point to character
                        String unicodeChar = new String(Character.toChars(codePoint));
                        return unicodeChar;
                    } catch (IllegalArgumentException e) {
                        throw new RuntimeException("Invalid Unicode code point: " + codePoint);
                    }
                }
                // CASE 2: Input is STRING → Convert to Unicode value(s) with grapheme clustering
                else if (inputObj instanceof String) {
                    String inputStr = (String)inputObj;
                    
                    if (inputStr.length() == 0) {
                        throw new RuntimeException("ইউনিকোড() string argument cannot be empty");
                    }
                    
                    // If single character, return single number
                    if (inputStr.length() == 1) {
                        int codePoint = inputStr.codePointAt(0);
                        return new BigDecimal(codePoint);
                    }
                    // If multiple characters, return list with grapheme clustering
                    else {
                        KalpanaList result = new KalpanaList();
                        
                        // Use BreakIterator to find grapheme boundaries
                        java.text.BreakIterator breakIterator = java.text.BreakIterator.getCharacterInstance();
                        breakIterator.setText(inputStr);
                        
                        int start = breakIterator.first();
                        int end = breakIterator.next();
                        
                        while (end != java.text.BreakIterator.DONE) {
                            String grapheme = inputStr.substring(start, end);
                            
                            // If grapheme is a single code point, add as number
                            if (grapheme.codePointCount(0, grapheme.length()) == 1) {
                                int codePoint = grapheme.codePointAt(0);
                                result.add(new BigDecimal(codePoint));
                            }
                            // If grapheme has multiple code points (like emoji with modifiers), add as list
                            else {
                                KalpanaList graphemeCodes = new KalpanaList();
                                
                                // Add all code points for this grapheme cluster
                                for (int i = 0; i < grapheme.length(); ) {
                                    int codePoint = grapheme.codePointAt(i);
                                    graphemeCodes.add(new BigDecimal(codePoint));
                                    i += Character.charCount(codePoint);
                                }
                                
                                result.add(graphemeCodes);
                            }
                            
                            start = end;
                            end = breakIterator.next();
                        }
                        
                        return result;
                    }
                }
                // CASE 3: Input is LIST → Combine code points back to string
                else if (inputObj instanceof KalpanaList) {
                    KalpanaList inputList = (KalpanaList)inputObj;
                    StringBuilder result = new StringBuilder();
                    
                    for (int i = 0; i < inputList.size(); i++) {
                        Object item = inputList.get(i + 1);
                        
                        if (item instanceof BigDecimal) {
                            // Single code point
                            BigDecimal codePointBD = (BigDecimal)item;
                            
                            // Validate
                            if (codePointBD.scale() > 0) {
                                throw new RuntimeException("Unicode code point must be integer, got: " + codePointBD);
                            }
                            
                            int codePoint = codePointBD.intValue();
                            
                            if (!Character.isValidCodePoint(codePoint)) {
                                throw new RuntimeException("Invalid Unicode code point in list: " + codePoint);
                            }
                            
                            try {
                                String unicodeChar = new String(Character.toChars(codePoint));
                                result.append(unicodeChar);
                            } catch (IllegalArgumentException e) {
                                throw new RuntimeException("Invalid Unicode code point in list: " + codePoint);
                            }
                        }
                        else if (item instanceof KalpanaList) {
                            // Grapheme cluster - multiple code points
                            KalpanaList cluster = (KalpanaList)item;
                            
                            for (int j = 0; j < cluster.size(); j++) {
                                Object codePointObj = cluster.get(j + 1);
                                
                                if (!(codePointObj instanceof BigDecimal)) {
                                    throw new RuntimeException("Grapheme cluster must contain numbers, got: " + 
                                        (codePointObj == null ? "null" : codePointObj.getClass().getSimpleName()));
                                }
                                
                                BigDecimal codePointBD = (BigDecimal)codePointObj;
                                
                                // Validate
                                if (codePointBD.scale() > 0) {
                                    throw new RuntimeException("Unicode code point must be integer, got: " + codePointBD);
                                }
                                
                                int codePoint = codePointBD.intValue();
                                
                                if (!Character.isValidCodePoint(codePoint)) {
                                    throw new RuntimeException("Invalid Unicode code point in grapheme cluster: " + codePoint);
                                }
                                
                                try {
                                    String unicodeChar = new String(Character.toChars(codePoint));
                                    result.append(unicodeChar);
                                } catch (IllegalArgumentException e) {
                                    throw new RuntimeException("Invalid Unicode code point in grapheme cluster: " + codePoint);
                                }
                            }
                        }
                        else {
                            throw new RuntimeException("Unicode list must contain numbers or lists, got: " + 
                                (item == null ? "null" : item.getClass().getSimpleName()));
                        }
                    }
                    
                    return result.toString();
                }
                else {
                    throw new RuntimeException("ইউনিকোড() argument must be a number, string, or list, got: " + 
                        (inputObj == null ? "null" : inputObj.getClass().getSimpleName()));
                }
            }
            if (functionName.equals("খোলো"))
            {
                if (expr.arguments().size() < 1 || expr.arguments().size() > 2)
                {
                    throw new RuntimeException("'খোলো' expects 1-2 arguments (path, [mode])");
                }
                
                Object pathObj = evaluate(expr.arguments().get(0));
                if (!(pathObj instanceof String))
                {
                    throw new RuntimeException("File path must be a string");
                }
                
                FileMode mode = FileMode.WRITE; // Default mode
                if (expr.arguments().size() == 2)
                {
                    Object modeObj = evaluate(expr.arguments().get(1));
                    if (modeObj instanceof String)
                    {
                        mode = FileMode.fromString((String)modeObj);
                    }
                }
                
                try
                {
                    // Generate a unique handle name
                    String handleName = "file_" + System.nanoTime() + "_" + (int)(Math.random() * 1000);
                    FileHandle handle = new FileHandle((String)pathObj, mode);
                    fileHandles.put(handleName, handle);
                    
                    // Return the handle name as string
                    return handleName;
                } catch (IOException e)
                {
                    throw new RuntimeException("File operation failed: " + e.getMessage());
                }
            }


            // Handle ধরণ function
            if (functionName.equals("ধরণ"))
            {
                if (expr.arguments().isEmpty())
                {
                    throw new RuntimeException("'ধরণ' expects at least 1 argument");
                }
                
                if (expr.arguments().size() == 1)
                {
                    // Single argument - return string as before
                    Object value = evaluate(expr.arguments().get(0));
                    
                    // Check for file handles first
                    if (value instanceof String && fileHandles.containsKey(value)) return "file";
                    
                    // Existing type checks
                    if (value == null) return "null";
                    if (value instanceof BigDecimal)
                    {
                        return ((BigDecimal)value).scale() <= 0 ? "int" : "float";
                    }
                    if (value instanceof String) return "string";
                    if (value instanceof Boolean) return "boolean";
                    if (value instanceof Object[])
                    {
                        Object[] array = (Object[])value;
                        if (array.length == 0) return "array:empty";
                        Object first = array[0];
                        if (first instanceof BigDecimal)
                        {
                            return ((BigDecimal)first).scale() <= 0 ? "array:int" : "array:float";
                        }
                        if (first instanceof String) return "array:string";
                        if (first instanceof Boolean) return "array:boolean";
                        return "array";
                    }
                    if (value instanceof ClassInstance) return "object";
                    return "unknown";
                }
                else
                {
                    // Multiple arguments - return array of types
                    String[] typeArray = new String[expr.arguments().size()];
                    for (int i = 0; i < expr.arguments().size(); i++)
                    {
                        Object value = evaluate(expr.arguments().get(i));
                        
                        // Check for file handles first
                        if (value instanceof String && fileHandles.containsKey(value)) 
                        {
                            typeArray[i] = "file";
                            continue;
                        }
                        
                        // Existing type checks
                        if (value == null) 
                        {
                            typeArray[i] = "null";
                            continue;
                        }
                        if (value instanceof BigDecimal)
                        {
                            typeArray[i] = ((BigDecimal)value).scale() <= 0 ? "int" : "float";
                            continue;
                        }
                        if (value instanceof String) 
                        {
                            typeArray[i] = "string";
                            continue;
                        }
                        if (value instanceof Boolean) 
                        {
                            typeArray[i] = "boolean";
                            continue;
                        }
                        if (value instanceof Object[])
                        {
                            Object[] array = (Object[])value;
                            if (array.length == 0) 
                            {
                                typeArray[i] = "array:empty";
                                continue;
                            }
                            Object first = array[0];
                            if (first instanceof BigDecimal)
                            {
                                typeArray[i] = ((BigDecimal)first).scale() <= 0 ? "array:int" : "array:float";
                                continue;
                            }
                            if (first instanceof String) 
                            {
                                typeArray[i] = "array:string";
                                continue;
                            }
                            if (first instanceof Boolean) 
                            {
                                typeArray[i] = "array:boolean";
                                continue;
                            }
                            typeArray[i] = "array";
                            continue;
                        }
                        if (value instanceof ClassInstance) 
                        {
                            typeArray[i] = "object";
                            continue;
                        }
                        typeArray[i] = "unknown";
                    }
                    return typeArray;
                }
            }

            // Handle কার_অবজেক্ট function
            if (functionName.equals("কার_অবজেক্ট"))
            {
                if (expr.arguments().size() != 1)
                {
                    throw new RuntimeException("'কার_অবজেক্ট' expects exactly 1 argument (object)");
                }
                
                Object obj = evaluate(expr.arguments().get(0));
                
                // Return null for primitives (they aren't objects of any class)
                if (obj == null || 
                    obj instanceof BigDecimal || 
                    obj instanceof String || 
                    obj instanceof Boolean || 
                    obj instanceof Object[])
                {
                    return null;
                }
                
                // Return class name for ClassInstance objects
                if (obj instanceof ClassInstance)
                {
                    ClassInstance instance = (ClassInstance)obj;
                    return instance.getClassName();
                }
                
                // Return null for any other unknown types
                return null;
            }
    
            // Handle argument function
            if (functionName.equals("আর্গুমেন্ট"))
            {
                if (!expr.arguments().isEmpty())
                {
                    throw new RuntimeException("'আর্গুমেন্ট' function takes no arguments");
                }
                return Main.commandLineArgs.toArray(new String[0]);
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
    

            if (functionName.equals("অ্যারে_জেনারেটর"))
            {
                if (expr.arguments().size() < 2 || expr.arguments().size() > 3)
                {
                    throw new RuntimeException("'অ্যারে_জেনারেটর' expects 2-3 arguments (start, end, [filter])");
                }
                
                Object startObj = evaluate(expr.arguments().get(0));
                Object endObj = evaluate(expr.arguments().get(1));
                
                if (!(startObj instanceof BigDecimal) || !(endObj instanceof BigDecimal))
                {
                    throw new RuntimeException("First two arguments must be numbers");
                }
                
                BigDecimal start = (BigDecimal)startObj;
                BigDecimal end = (BigDecimal)endObj;
                
                if (start.compareTo(end) > 0)
                {
                    throw new RuntimeException("Start cannot be greater than end");
                }
                
                // If filter expression provided
                Object filterObj = null;
                String filterExpr = null;
                String paramName = "_";
                boolean isLambdaStyle = false;
                boolean isFunctionCall = false;
                boolean isDirectBoolean = false;
                Object directBooleanValue = null;
            
                // Cache for compiled expressions
                Expr cachedExpression = null;
                boolean useCachedExpression = false;
                
                // Cache specifically for lambda expressions
                Expr cachedLambdaExpression = null;
                String cachedLambdaParamName = null;
            
                if (expr.arguments().size() == 3)
                {
                    filterObj = evaluate(expr.arguments().get(2));
                    
                    // Check the type of filter object
                    if (filterObj instanceof String) {
                        // String expression (existing behavior)
                        filterExpr = (String)filterObj;
                        
                        // Check if it's lambda-style: "(n) => n % 2 == 0"
                        Pattern lambdaPattern = Pattern.compile("\\(\\s*(\\w+)\\s*\\)\\s*=>\\s*(.+)");
                        Matcher matcher = lambdaPattern.matcher(filterExpr);
                        
                        if (matcher.matches())
                        {
                            isLambdaStyle = true;
                            paramName = matcher.group(1);
                            filterExpr = matcher.group(2);
                            
                            // OPTIMIZATION: Pre-compile lambda expression once
                            try {
                                Lexer lexer = new Lexer(filterExpr);
                                List<Token> tokens = lexer.scanTokens();
                                Parser parser = new Parser(tokens);
                                cachedLambdaExpression = parser.expression();
                                cachedLambdaParamName = paramName;
                            } catch (Exception e) {
                                throw new RuntimeException("Invalid lambda expression: " + e.getMessage());
                            }
                        }
                        else
                        {
                            // OPTIMIZATION: Pre-compile regular string expressions
                            try
                            {
                                // Compile the original expression with _ as is
                                Lexer lexer = new Lexer(filterExpr);
                                List<Token> tokens = lexer.scanTokens();
                                Parser parser = new Parser(tokens);
                                cachedExpression = parser.expression();
                                useCachedExpression = true;
                            }
                            catch (Exception e)
                            {
                                throw new RuntimeException("Invalid filter expression: " + e.getMessage());
                            }
                        }
                    }
                    else if (filterObj instanceof Boolean)
                    {
                        // Direct boolean value
                        isDirectBoolean = true;
                        directBooleanValue = filterObj;
                    }
                    else if (filterObj instanceof Function)
                    {
                        // Function reference
                        isFunctionCall = true;
                    }
                    // Numbers: 0 = false, non-zero = true (C-style logic)
                    else if (filterObj instanceof BigDecimal)
                    {
                        isDirectBoolean = true;
                        directBooleanValue = !((BigDecimal)filterObj).equals(BigDecimal.ZERO);
                    }
                }
                
                List<BigDecimal> result = new ArrayList<>();
                BigDecimal current = start;
                
                // Use BigDecimal comparison and arithmetic
                while (current.compareTo(end) <= 0)
                {
                    boolean shouldInclude = true;
                    
                    if (filterObj != null)
                    {
                        if (isDirectBoolean)
                        {
                            // Direct boolean: include all if true, include none if false
                            shouldInclude = (Boolean)directBooleanValue;
                        }
                        else if (isFunctionCall)
                        {
                            // Function call: call the function with current value
                            Function function = (Function)filterObj;
                            
                            // Create temporary environment for function call
                            Environment tempEnv = new Environment(environment);
                            tempEnv.define("_", current);
                            
                            Environment previousEnv = this.environment;
                            try
                            {
                                this.environment = tempEnv;
                                
                                // Call the function with current value as argument
                                List<Object> args = Collections.singletonList(current);
                                Object functionResult = callFunction(function, args);
                                
                                // Convert result to boolean (C-style: 0=false, non-zero=true)
                                if (functionResult instanceof Boolean)
                                {
                                    shouldInclude = (Boolean)functionResult;
                                } else if (functionResult instanceof BigDecimal)
                                {
                                    shouldInclude = !((BigDecimal)functionResult).equals(BigDecimal.ZERO);
                                } else
                                {
                                    shouldInclude = isTruthy(functionResult);
                                }
                            } finally
                            {
                                this.environment = previousEnv;
                            }
                        }
                        else if (isLambdaStyle)
                        {
                            // OPTIMIZED LAMBDA: Use pre-compiled expression
                            Environment tempEnv = new Environment(environment);
                            tempEnv.define(cachedLambdaParamName, current);
                            
                            Environment previousEnv = this.environment;
                            try
                            {
                                this.environment = tempEnv;
                                Object filterResult = evaluate(cachedLambdaExpression);
                                shouldInclude = isTruthy(filterResult);
                            }
                            finally
                            {
                                this.environment = previousEnv;
                            }
                        }
                        else if (useCachedExpression)
                        {
                            // OPTIMIZED: Use pre-compiled expression with _ variable
                            Environment tempEnv = new Environment(environment);
                            tempEnv.define("_", current);
                            
                            Environment previousEnv = this.environment;
                            try
                            {
                                this.environment = tempEnv;
                                Object filterResult = evaluate(cachedExpression);
                                shouldInclude = isTruthy(filterResult);
                            }
                            finally
                            {
                                this.environment = previousEnv;
                            }
                        }
                        else
                        {
                            // Simple string replacement style (fallback for non-cached)
                            String exprWithValue = filterExpr.replace("_", current.toString());
                            try
                            {
                                Lexer lexer = new Lexer(exprWithValue);
                                List<Token> tokens = lexer.scanTokens();
                                Parser parser = new Parser(tokens);
                                Expr expression = parser.expression();
                                Object filterResult = evaluate(expression);
                                
                                shouldInclude = isTruthy(filterResult);
                            } catch (Exception e)
                            {
                                throw new RuntimeException("Invalid filter expression: " + e.getMessage());
                            }
                        }
                    }
                    
                    if (shouldInclude)
                    {
                        result.add(current);
                    }
                    
                    // Move to next number using BigDecimal arithmetic
                    current = current.add(BigDecimal.ONE);
                }
                
                return result.toArray(new BigDecimal[0]);
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
    
            // Handle বাক্যের_আকার function
            if (functionName.equals("বাক্যের_দৈর্ঘ্য"))
            {
                if (expr.arguments().size() != 1)
                {
                    throw new RuntimeException("'বাক্যের_দৈর্ঘ্য' expects exactly 1 argument (string)");
                }
                
                Object str = evaluate(expr.arguments().get(0));
                if (!(str instanceof String))
                {
                    throw new RuntimeException("Argument must be a string");
                }
                
                return new BigDecimal(((String)str).length());
            }
            
            // Handle ফাইল_হ্যাশ function
            if (functionName.equals("ফাইল_হ্যাশ"))
            {
                if (expr.arguments().size() < 1 || expr.arguments().size() > 2)
                {
                    throw new RuntimeException("'ফাইল_হ্যাশ' expects 1-2 arguments (file, [algorithm])");
                }
                
                Object fileInput = evaluate(expr.arguments().get(0));
                
                // Default to SHA-256 if no algorithm specified or empty string
                String algorithm = "SHA-256";
                if (expr.arguments().size() == 2)
                {
                    Object algoObj = evaluate(expr.arguments().get(1));
                    if (algoObj instanceof String && !((String)algoObj).trim().isEmpty())
                    {
                        algorithm = ((String)algoObj).trim().toUpperCase(Locale.ROOT);
                        
                        // Normalize algorithm names (accept both "MD5" and "MD-5" formats)
                        algorithm = algorithm.replace("-", "");
                        
                        // Map to standard algorithm names
                        switch (algorithm)
                        {
                            case "MD5":
                                algorithm = "MD5";
                                break;
                            case "SHA1":
                                algorithm = "SHA-1";
                                break;
                            case "SHA256":
                                algorithm = "SHA-256";
                                break;
                            case "SHA512":
                                algorithm = "SHA-512";
                                break;
                            case "SHA384":
                                algorithm = "SHA-384";
                                break;
                            default:
                                throw new RuntimeException("Unsupported hash algorithm: " + algorithm + 
                                    ". Supported: MD5, SHA-1, SHA-256, SHA-384, SHA-512");
                        }
                    }
                }
                
                try
                {
                    // Handle both file paths and file handles
                    String filePath;
                    if (fileInput instanceof String)
                    {
                        // It's either a direct path or a file handle name
                        String inputStr = (String)fileInput;
                        if (fileHandles.containsKey(inputStr))
                        {
                            // It's a file handle - get the actual path
                            FileHandle handle = fileHandles.get(inputStr);
                            filePath = handle.path;
                        } else
                        {
                            // It's a direct file path
                            filePath = inputStr;
                        }
                    } else
                    {
                        throw new RuntimeException("File reference must be a string (path or handle)");
                    }
                    // Calculating hash
                    MessageDigest md = MessageDigest.getInstance(algorithm);
                    try (InputStream is = Files.newInputStream(Paths.get(filePath)))
                    {
                        byte[] buffer = new byte[8192];  //2¹³ is perfect for me.
                        int read;
                        while ((read = is.read(buffer)) > 0)
                        {
                            md.update(buffer, 0, read);
                        }
                    }
                    
                    // Convert to hex string
                    byte[] digest = md.digest();
                    StringBuffer hexString = new StringBuffer();
                    for (byte b : digest)
                    {
                        hexString.append(String.format("%02x", b));
                    }
                    
                    return hexString.toString();
                } catch (Exception e)
                {
                    throw new RuntimeException("Error calculating file hash: " + e.getMessage());
                }
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
    
        // Enhanced argument count validation with default parameter support
        int providedArgs = expr.arguments().size();
        int totalParams = function.parameters().size();
    
        // Calculate minimum required arguments (parameters without defaults)
        int minRequiredArgs = totalParams;
        if (function.defaultValues() != null) {
            for (int i = 0; i < totalParams; i++) {
                if (function.hasDefaultValue(i)) {
                    minRequiredArgs = i;
                    break;
                }
            }
        }
    
        //  Better error messages with default parameter support
        if (providedArgs < minRequiredArgs) {
            throw new RuntimeException("Function '" + function.name().lexeme + 
                                     "' requires at least " + minRequiredArgs + 
                                     " arguments but got " + providedArgs + ".");
        }
    
        if (providedArgs > totalParams) {
            throw new RuntimeException("Function '" + function.name().lexeme + 
                                     "' expects at most " + totalParams + 
                                     " arguments but got " + providedArgs + ".");
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
                case ALL:
                    break;
                case INTEGER:
                    if (value instanceof BigDecimal)
                    {
                        // Automatically truncate decimal places for integers
                        value = ((BigDecimal)value).setScale(0, RoundingMode.DOWN);
                    } else if (value instanceof Integer || value instanceof Double)
                    {
                        value = new BigDecimal(value.toString()).setScale(0, RoundingMode.DOWN);
                    } else
                    {
                        throw new RuntimeException("Parameter " + (i+1) + " must be a number");
                    }
                    break;
    
                case FLOAT:
                    if (value instanceof BigDecimal)
                    {
                        // Keep as is
                    } else if (value instanceof Integer || value instanceof Double)
                    {
                        value = new BigDecimal(value.toString());
                    } else
                    {
                        throw new RuntimeException("Parameter " + (i+1) + " must be a number");
                    }
                    break;
    
                case STRING:
                    if (!(value instanceof String))
                    {
                        throw new RuntimeException("Parameter " + (i+1) + " must be a string");
                    }
                    break;
    
                case BOOLEAN:
                    if (value instanceof BigDecimal)
                    {
                        // C-style boolean conversion for parameters
                        value = !((BigDecimal)value).equals(BigDecimal.ZERO);
                    } else if (!(value instanceof Boolean))
                    {
                        throw new RuntimeException("Parameter " + (i+1) + " must be a boolean or number");
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
                            throw new RuntimeException("All elements in integer array must be numbers");
                        }
                        element = ((BigDecimal)element).setScale(0, RoundingMode.DOWN);
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
    
        //  Use the updated callFunction method with default parameter support
        return callFunction(function, arguments);
    }

    // Helper method to copy environment data
    private void copyEnvironment(Environment source, Environment target) {
        // Copy all variables
        target.values.putAll(source.values);
        
        // Copy all arrays
        target.arrays.putAll(source.arrays);
        
        // Copy all functions
        target.functions.putAll(source.functions);
        
        // Copy all variable types
        target.variableTypes.putAll(source.variableTypes);
        
        // Copy all array types
        target.arrayTypes.putAll(source.arrayTypes);
        
        // Copy unlimited arrays info
        for (String key : source.arrays.keySet()) {
            if (source.isArrayUnlimited(key)) {
                target.unlimitedArrays.put(key, true);
            }
        }
    }
    
    private Object resizeArray(Object array, int additionalSize)
    {
        Object[] oldArray = (Object[])array;
        int oldSize = oldArray.length;
        int newSize = oldSize + additionalSize;

        // Create new array of the same type
        Object[] newArray = (Object[])java.lang.reflect.Array.newInstance(oldArray.getClass().getComponentType(), newSize);

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
            return null;
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
    public Object visitSetLiteralExpr(SetLiteral expr)
    {
        List<Object> elements = new Vector<>();
        for (Expr elementExpr : expr.elements())
        {
            elements.add(evaluate(elementExpr));
        }
        return new KalpanaSet(elements);
    }
    @Override
    public Object visitListLiteralExpr(ListLiteral expr)
    {
        List<Object> elements = new Vector<>();
        for (Expr elementExpr : expr.elements())
        {
            elements.add(evaluate(elementExpr));
        }
        return new KalpanaList(elements);
    }

    @Override
    public Object visitListAccessExpr(ListAccess expr)
    {
        Object listObj = evaluate(expr.list());
        Object indexObj = evaluate(expr.index());
        
        if (!(indexObj instanceof BigDecimal))
        {
            throw new RuntimeException("List index must be an integer");
        }
        
        int index = ((BigDecimal)indexObj).intValue();
        
        if (listObj instanceof KalpanaList)
        {
            KalpanaList list = (KalpanaList)listObj;
            
            // This will now auto-grow the list if needed
            Object element = list.get(index);
            
            // Return the element - it could be another list, number, string, etc.
            return element;
        }
        else if (listObj instanceof Object[])
        {
            // Allow ¥ operator on arrays too (arrays don't auto-grow)
            Object[] array = (Object[])listObj;
            if (index < 1 || index > array.length)
            {
                throw new RuntimeException("Array index out of bounds: " + index);
            }
            return array[index - 1];
        }
        else
        {
            String typeName = "unknown";
            if (listObj instanceof BigDecimal) typeName = "number";
            else if (listObj instanceof String) typeName = "string";
            else if (listObj instanceof Boolean) typeName = "boolean";
            else if (listObj == null) typeName = "null";
            
            throw new RuntimeException("Cannot use '¥' on " + typeName + " value: " + stringify(listObj));
        }
    }

// Helper methods for file operations
private String readEntireFile(FileHandle handle) throws IOException {
    StringBuilder content = new StringBuilder();
    
    if (handle.reader != null) {
        // BufferedReader mode
        String line;
        while ((line = handle.reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        // Reset reader
        handle.reader.close();
        handle.reader = new BufferedReader(new InputStreamReader(
            new FileInputStream(handle.path), handle.charset));
    } else if (handle.raf != null) {
        // RandomAccessFile mode
        handle.raf.seek(0);
        String line;
        while ((line = handle.raf.readLine()) != null) {
            content.append(new String(line.getBytes(StandardCharsets.ISO_8859_1), 
                handle.charset)).append("\n");
        }
        // Reset position
        if (handle.mode == FileMode.APPEND || handle.mode == FileMode.APPEND_READ) {
            handle.raf.seek(handle.raf.length());
        } else {
            handle.raf.seek(0);
        }
    }
    
    return content.toString().trim();
}

private String readFileLines(FileHandle handle, int startLine, int endLine) throws IOException {
    StringBuilder content = new StringBuilder();
    int currentLine = 0;
    
    if (handle.reader != null) {
        String line;
        while ((line = handle.reader.readLine()) != null) {
            currentLine++;
            if (currentLine >= startLine && currentLine <= endLine) {
                content.append(line).append("\n");
            }
            if (currentLine > endLine) break;
        }
        // Reset reader
        handle.reader.close();
        handle.reader = new BufferedReader(new InputStreamReader(
            new FileInputStream(handle.path), handle.charset));
    } else if (handle.raf != null) {
        handle.raf.seek(0);
        String line;
        while ((line = handle.raf.readLine()) != null) {
            currentLine++;
            if (currentLine >= startLine && currentLine <= endLine) {
                content.append(new String(line.getBytes(StandardCharsets.ISO_8859_1), 
                    handle.charset)).append("\n");
            }
            if (currentLine > endLine) break;
        }
        // Reset position
        if (handle.mode == FileMode.APPEND || handle.mode == FileMode.APPEND_READ) {
            handle.raf.seek(handle.raf.length());
        } else {
            handle.raf.seek(0);
        }
    }
    
    return content.toString().trim();
}
    @Override
    public Object visitListMethodCallExpr(ListMethodCall expr) {
        Object target = evaluate(expr.list());
        

        // Handle class instances FIRST (for backward compatibility)
        if (target instanceof ClassInstance) {
            // Delegate to existing class method handling
            return visitMethodCallExpr(new MethodCallExpr(expr.list(), expr.method(), expr.arguments()));
        }
        //Fine handler
        if (target instanceof String && fileHandles.containsKey(target)) {
            String fileHandle = (String) target;
            FileHandle file = fileHandles.get(fileHandle);
            String methodName = expr.method().lexeme;
            
            // Evaluate arguments
            List<Object> arguments = new Vector<>();
            for (Expr argExpr : expr.arguments()) {
                arguments.add(evaluate(argExpr));
            }
            
            // Handle file methods
            switch (methodName) {
                case "লিখো":
                case "লিখ":
                case "write":
                    if (arguments.size() != 1) throw new RuntimeException("লিখো() expects 1 argument (content)");
                    try {
                        String content = stringify(arguments.get(0));
                        file.write(content);
                        return null;
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to write to file: " + e.getMessage());
                    }

                case "হ্যাশ":
                case "hash":
                    if (arguments.size() > 1) throw new RuntimeException("হ্যাশ() expects 1 argument (Algorithm)");

                    try {
                        String algorithm = "";
                        if (arguments.size() == 0) //if passed no argument, set SHA-256.
                        {
                                algorithm = "SHA-256";
                         }
                        else if (arguments.size() == 1) //if passed any argument set that.
                        {
                                algorithm = stringify(arguments.get(0));
                        }
                        return file.fileHash(algorithm);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to get hash: " + e.getMessage());
                    }
                     
                case "ফাইল_বন্ধ":
                    if (!arguments.isEmpty()) throw new RuntimeException("বন্ধ() takes no arguments");
                    try {
                        file.close();
                        fileHandles.remove(fileHandle);
                        return null;
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to close file: " + e.getMessage());
                    }
                    
                case "পড়ো":
                case "পড়":
                case "read":
                    if (arguments.size() > 2) throw new RuntimeException("পড়ো() expects 0-2 arguments ([startLine, endLine])");
                    try {
                        if (arguments.isEmpty()) {
                            // Read entire file
                            return visitFileReadExpr(new FileReadExpr(new Literal(fileHandle), new Vector<>()));
                        } else if (arguments.size() == 1) {
                            // Read first N lines
                            List<Expr> args = Collections.singletonList(new Literal(arguments.get(0)));
                            return visitFileReadExpr(new FileReadExpr(new Literal(fileHandle), args));
                        } else {
                            // Read line range
                            List<Expr> args = Arrays.asList(new Literal(arguments.get(0)), new Literal(arguments.get(1)));
                            return visitFileReadExpr(new FileReadExpr(new Literal(fileHandle), args));
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to read file: " + e.getMessage());
                    }
                    
                case "মুছো":
                case "মুছ":
                case "delete":
                    if (!arguments.isEmpty()) throw new RuntimeException("মুছো() takes no arguments");
                    try {
                        file.delete();
                        fileHandles.remove(fileHandle);
                        return null;
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to delete file: " + e.getMessage());
                    }
                    
                case "অবস্থান":
                case "position":
                    if (!arguments.isEmpty()) throw new RuntimeException("অবস্থান() takes no arguments");
                    try {
                        long position = file.getPosition();
                        return new BigDecimal(position);
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to get file position: " + e.getMessage());
                    }
                    
                case "আকার":
                case "size":
                    if (!arguments.isEmpty()) throw new RuntimeException("আকার() takes no arguments");
                    try {
                        long size = file.getSize();
                        return new BigDecimal(size);
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to get file size: " + e.getMessage());
                    }
                    
                // ========== BINARY FILE METHODS ==========
                case "বাইনারি_লিখো":
                case "বাইনারি_লিখ":
                case "binary_write":
                    if (arguments.size() < 1 || arguments.size() > 3) 
                        throw new RuntimeException("বাইনারি_লিখো() expects 1-3 arguments (data, [offset, length])");
                    try {
                        Object data = arguments.get(0);
                        byte[] byteData;
                        
                        // Convert data to byte array
                        if (data instanceof KalpanaList) {
                            KalpanaList dataList = (KalpanaList) data;
                            byteData = new byte[dataList.size()];
                            for (int i = 0; i < dataList.size(); i++) {
                                Object element = dataList.get(i + 1);
                                if (!(element instanceof BigDecimal)) {
                                    throw new RuntimeException("Byte list must contain numbers (0-255)");
                                }
                                int byteValue = ((BigDecimal)element).intValue();
                                if (byteValue < 0 || byteValue > 255) {
                                    throw new RuntimeException("Byte value must be between 0 and 255");
                                }
                                byteData[i] = (byte)byteValue;
                            }
                        } else if (data instanceof Object[]) {
                            Object[] dataArray = (Object[]) data;
                            byteData = new byte[dataArray.length];
                            for (int i = 0; i < dataArray.length; i++) {
                                if (!(dataArray[i] instanceof BigDecimal)) {
                                    throw new RuntimeException("Byte array must contain numbers (0-255)");
                                }
                                int byteValue = ((BigDecimal)dataArray[i]).intValue();
                                if (byteValue < 0 || byteValue > 255) {
                                    throw new RuntimeException("Byte value must be between 0 and 255");
                                }
                                byteData[i] = (byte)byteValue;
                            }
                        } else {
                            throw new RuntimeException("বাইনারি_লিখো() data must be a byte array or list");
                        }
                        
                        if (arguments.size() == 1) {
                            file.writeBinary(byteData);
                        } else if (arguments.size() == 3) {
                            if (!(arguments.get(1) instanceof BigDecimal) || !(arguments.get(2) instanceof BigDecimal)) {
                                throw new RuntimeException("Offset and length must be integers");
                            }
                            int offset = ((BigDecimal)arguments.get(1)).intValue();
                            int length = ((BigDecimal)arguments.get(2)).intValue();
                            file.writeBinary(byteData, offset, length);
                        }
                        return null;
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to write binary file: " + e.getMessage());
                    }
                    
                case "বাইনারি_পড়ো":
                case "বাইনারি_পড়":
                case "binary_read":
                    if (arguments.size() > 1) throw new RuntimeException("বাইনারি_পড়ো() expects 0-1 arguments ([bytesToRead])");
                    try {
                        byte[] byteData;
                        if (arguments.isEmpty()) {
                            // Read all binary data
                            byteData = file.readAllBinary();
                        } else {
                            // Read specific number of bytes
                            if (!(arguments.get(0) instanceof BigDecimal)) {
                                throw new RuntimeException("Bytes to read must be an integer");
                            }
                            int bytesToRead = ((BigDecimal)arguments.get(0)).intValue();
                            byteData = file.readBinary(bytesToRead);
                        }
                        
                        // Convert byte array to KalpanaList
                        KalpanaList resultList = new KalpanaList();
                        for (byte b : byteData) {
                            int unsignedByte = b & 0xFF;
                            resultList.add(new BigDecimal(unsignedByte));
                        }
                        return resultList;
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to read binary file: " + e.getMessage());
                    }
                    
                case "সিক":
                case "seek":
                    if (arguments.size() != 1) throw new RuntimeException("সিক() expects 1 argument (position)");
                    try {
                        if (!(arguments.get(0) instanceof BigDecimal)) {
                            throw new RuntimeException("Position must be an integer");
                        }
                        long position = ((BigDecimal)arguments.get(0)).longValue();
                        file.seek(position);
                        return null;
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to seek in file: " + e.getMessage());
                    }
                    
                case "সিক_শুরু":
                case "seek_start":
                    if (!arguments.isEmpty()) throw new RuntimeException("সিক_শুরু() takes no arguments");
                    try {
                        file.seek(0);
                        return null;
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to seek to start: " + e.getMessage());
                    }
                    
                case "সিক_শেষ":
                case "seek_end":
                    if (!arguments.isEmpty()) throw new RuntimeException("সিক_শেষ() takes no arguments");
                    try {
                        long size = file.getSize();
                        file.seek(size);
                        return null;
                    } catch (IOException e) {
                        throw new RuntimeException("Failed to seek to end: " + e.getMessage());
                    }
                    
                case "ফ্লাশ":
                case "flush":
                    // Note: This might need to be implemented in FileHandle class
                    if (!arguments.isEmpty()) throw new RuntimeException("ফ্লাশ() takes no arguments");
                    try {
                        // If your FileHandle has flush capability, call it here
                        // file.flush();
                        return null;
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to flush file: " + e.getMessage());
                    }
                    
                // ========== FILE PROPERTIES ==========
                case "পথ":
                case "path":
                    if (!arguments.isEmpty()) throw new RuntimeException("পথ takes no arguments");
                    return file.path;
                    
                case "মোড":
                case "mode":
                    if (!arguments.isEmpty()) throw new RuntimeException("মোড takes no arguments");
                    return file.mode.toString();
                    
                case "খোলা":
                case "is_open":
                    if (!arguments.isEmpty()) throw new RuntimeException("খোলা takes no arguments");
                    try {
                        file.getPosition(); // This will throw if file is closed
                        return true;
                    } catch (IOException e) {
                        return false;
                    }
                    
                case "বাইনারি_মোড":
                case "is_binary":
                    if (!arguments.isEmpty()) throw new RuntimeException("বাইনারি_মোড takes no arguments");
                    return file.mode.isBinary();
                    
                default:
                    throw new RuntimeException("Unknown file method: '" + methodName + "'");
            }
        }
    
        // Handle KalpanaStream
        if (target instanceof KalpanaStream) {
            KalpanaStream stream = (KalpanaStream) target;
            String methodName = expr.method().lexeme;
            
            // Evaluate arguments with type conversion
            List<Object> arguments = new Vector<>();
            for (Expr argExpr : expr.arguments()) {
                Object argValue = evaluate(argExpr);
                
                // SPECIAL HANDLING: Convert string type names to TokenType
                if (argValue instanceof String) {
                    String stringValue = (String) argValue;
                    
                    // Check if this string matches any type token
                    for (TokenType type : TokenType.values()) {
                        if (type.bangla != null && type.bangla.equals(stringValue)) {
                            argValue = type;
                            break;
                        }
                        // Also check English type names
                        if (type.name().equals(stringValue.toUpperCase())) {
                            argValue = type;
                            break;
                        }
                    }
                }
                
                arguments.add(argValue);
            }

        
        // Handle stream methods
        switch (methodName) {
            case "ফিল্টার":
            case "filter":
                if (arguments.size() != 1) {
                    throw new RuntimeException("ফিল্টার() method expects 1 argument (predicate)");
                }
                return stream.ফিল্টার(arguments.get(0));
                
            case "ফিল্টার_টাইপ":
            case "filterType":
                if (arguments.size() != 1) {
                    throw new RuntimeException("ফিল্টার_টাইপ() expects 1 argument (type)");
                }
                if (!(arguments.get(0) instanceof TokenType)) {
                    throw new RuntimeException("ফিল্টার_টাইপ() argument must be a type (পূর্ণসংখ্যা, ভগ্নাংশ, etc.)");
                }
                return stream.ফিল্টার_টাইপ((TokenType) arguments.get(0));

            case "ম্যাপ":
            case "map":
                if (arguments.size() != 1) {
                    throw new RuntimeException("ম্যাপ() method expects 1 argument (mapper)");
                }
                return stream.ম্যাপ(arguments.get(0));
        
            case "সীমা":
            case "limit":
                if (arguments.size() != 1) {
                    throw new RuntimeException("সীমা() method expects 1 argument (limit)");
                }
                if (!(arguments.get(0) instanceof BigDecimal)) {
                    throw new RuntimeException("সীমা() argument must be an integer");
                }
                return stream.সীমা(((BigDecimal) arguments.get(0)).intValue());
                
            case "লিস্টে":
            case "list":
                if (!arguments.isEmpty()) {
                    throw new RuntimeException("লিস্টে() method takes no arguments");
                }
                return stream.লিস্টে();
                
            case "গণনা":
            case "count":
                if (!arguments.isEmpty()) {
                    throw new RuntimeException("গণনা() method takes no arguments");
                }
                return stream.গণনা();
        
            case "এড়িয়ে":
            case "skip":
                if (arguments.size() != 1) throw new RuntimeException("এড়িয়ে() expects 1 argument (skip)");
                if (!(arguments.get(0) instanceof BigDecimal)) throw new RuntimeException("এড়িয়ে() argument must be integer");
                return stream.এড়িয়ে(((BigDecimal) arguments.get(0)).intValue());
            
            case "অনন্য":
            case "distinct":
                if (!arguments.isEmpty()) throw new RuntimeException("অনন্য() takes no arguments");
                return stream.অনন্য();
            
            case "উল্টাও":
            case "reverse":
                if (!arguments.isEmpty()) throw new RuntimeException("উল্টাও() takes no arguments");
                return stream.উল্টাও();
            
            case "পাতানো":
            case "takeWhile":
                if (arguments.size() != 1) throw new RuntimeException("পাতানো() expects 1 argument (condition)");
                if (!(arguments.get(0) instanceof String) && !(arguments.get(0) instanceof Function)) {
                    throw new RuntimeException("পাতানো() argument must be string expression or function reference");
                }
                return stream.পাতানো(arguments.get(0));
            
            case "বাদদেওয়া":
            case "dropWhile":
                if (arguments.size() != 1) throw new RuntimeException("বাদদেওয়া() expects 1 argument (condition)");
                if (!(arguments.get(0) instanceof String) && !(arguments.get(0) instanceof Function)) {
                    throw new RuntimeException("বাদদেওয়া() argument must be string expression or function reference");
                }
                return stream.বাদদেওয়া(arguments.get(0));
            
            case "সমতল":
            case "flatMap":
                if (!arguments.isEmpty()) throw new RuntimeException("সমতল() takes no arguments");
                return stream.সমতল();
            
            case "যোগফল":
            case "sum":
                if (!arguments.isEmpty()) throw new RuntimeException("যোগফল() takes no arguments");
                return stream.যোগফল();
            
            case "গড়":
            case "average":
                if (!arguments.isEmpty()) throw new RuntimeException("গড়() takes no arguments");
                return stream.গড়();
            
            case "ন্যূনতম":
            case "min":
                if (!arguments.isEmpty()) throw new RuntimeException("ন্যূনতম() takes no arguments");
                return stream.ন্যূনতম();
            
            case "সর্বোচ্চ":
            case "max":
                if (!arguments.isEmpty()) throw new RuntimeException("সর্বোচ্চ() takes no arguments");
                return stream.সর্বোচ্চ();
            
            case "প্রথম":
            case "first":
                if (!arguments.isEmpty()) throw new RuntimeException("প্রথম() takes no arguments");
                return stream.প্রথম();
            
            case "শেষ":
            case "last":
                if (!arguments.isEmpty()) throw new RuntimeException("শেষ() takes no arguments");
                return stream.শেষ();
            
            case "যেকোনো":
            case "any":
                if (!arguments.isEmpty()) throw new RuntimeException("যেকোনো() takes no arguments");
                return stream.যেকোনো();
            
            case "যেকোনো_মিল":
            case "anyMatch":
                if (arguments.size() != 1) throw new RuntimeException("যেকোনো_মিল() expects 1 argument (predicate)");
                if (!(arguments.get(0) instanceof String) && !(arguments.get(0) instanceof Function)) {
                    throw new RuntimeException("যেকোনো_মিল() argument must be string expression or function reference");
                }
                return stream.যেকোনো_মিল(arguments.get(0));
            
            case "সব_মিল":
            case "allMatch":
                if (arguments.size() != 1) throw new RuntimeException("সব_মিল() expects 1 argument (predicate)");
                if (!(arguments.get(0) instanceof String) && !(arguments.get(0) instanceof Function)) {
                    throw new RuntimeException("সব_মিল() argument must be string expression or function reference");
                }
                return stream.সব_মিল(arguments.get(0));
            
            case "কোনটাই_মিলেনা":
            case "noneMatch":
                if (arguments.size() != 1) throw new RuntimeException("কোনটাই_মিলেনা() expects 1 argument (predicate)");
                if (!(arguments.get(0) instanceof String) && !(arguments.get(0) instanceof Function)) {
                    throw new RuntimeException("কোনটাই_মিলেনা() argument must be string expression or function reference");
                }
                return stream.কোনটাই_মিলেনা(arguments.get(0));
            
            case "খুঁজ":
            case "find":
            case "খুঁজ_প্রথম":
            case "findFirst":
                if (arguments.size() != 1) throw new RuntimeException("খুঁজ() expects 1 argument (predicate)");
                if (!(arguments.get(0) instanceof String) && !(arguments.get(0) instanceof Function)) {
                    throw new RuntimeException("খুঁজ() argument must be string expression or function reference");
                }
                return stream.খুঁজ(arguments.get(0));
            
            case "একত্রিত":
            case "join":
                if (arguments.isEmpty()) {
                    return stream.একত্রিত();
                } else if (arguments.size() == 1 && arguments.get(0) instanceof String) {
                    return stream.একত্রিত((String) arguments.get(0));
                } else {
                    throw new RuntimeException("একত্রিত() takes 0 or 1 argument (separator)");
                }
        
            case "সাজানো":
            case "sort":
                if (arguments.isEmpty()) {
                    // Default sort
                    return stream.সাজানো(null);
                } else if (arguments.size() == 1) {
                    if (!(arguments.get(0) instanceof String) && !(arguments.get(0) instanceof Function)) {
                        throw new RuntimeException("সাজানো() argument must be string expression or function reference");
                    }
                    return stream.সাজানো(arguments.get(0));
                } else {
                    throw new RuntimeException("সাজানো() takes 0 or 1 argument (comparator)");
                }
            
           
            case "সংগ্রহ_সেট":
            case "collect_set":
                if (!arguments.isEmpty()) throw new RuntimeException("সংগ্রহ_সেট() takes no arguments");
                return stream.সংগ্রহ_সেট();
            
            case "সংগ্রহ_লিস্ট":
            case "collect_list":
                if (!arguments.isEmpty()) throw new RuntimeException("সংগ্রহ_লিস্ট() takes no arguments");
                return stream.সংগ্রহ_লিস্ট();
            
            case "সংগ্রহ_অনন্য":
            case "collect_distinct":
                if (!arguments.isEmpty()) throw new RuntimeException("সংগ্রহ_অনন্য() takes no arguments");
                return stream.সংগ্রহ_অনন্য();
            
            case "হ্রাস":
            case "reduce":
                if (arguments.size() == 1) {
                    if (!(arguments.get(0) instanceof String)) throw new RuntimeException("হ্রাস() argument must be string");
                    return stream.হ্রাস((String) arguments.get(0));
                } else if (arguments.size() == 2) {
                    if (!(arguments.get(0) instanceof String)) throw new RuntimeException("হ্রাস() first argument must be string");
                    return stream.হ্রাস((String) arguments.get(0), arguments.get(1));
                } else {
                    throw new RuntimeException("হ্রাস() expects 1 or 2 arguments (reducer, [initialValue])");
                }
            
            case "ফাঁকা_কী":
            case "isEmpty":
                if (!arguments.isEmpty()) throw new RuntimeException("ফাঁকা_কী() takes no arguments");
                return stream.খালি();
            
            default:
                throw new RuntimeException("Unknown stream method: '" + methodName + "'");
        }
                }


        if (target instanceof KalpanaSet) {
            KalpanaSet set = (KalpanaSet) target;
            String methodName = expr.method().lexeme;
            
            // Evaluate arguments
            List<Object> arguments = new Vector<>();
            for (Expr argExpr : expr.arguments()) {
                arguments.add(evaluate(argExpr));
            }
            
            // Handle set-specific methods
            switch (methodName) {
                // Basic utility methods (inherited from KalpanaList)
                case "যোগ":
                case "add":
                    if (arguments.size() != 1) throw new RuntimeException("যোগ() expects 1 argument (element)");
                    set.add(arguments.get(0));
                    return null;
                    
                case "মুছ":
                case "remove":
                    if (arguments.size() != 1) throw new RuntimeException("মুছ() expects 1 argument (element)");
                    return set.remove(arguments.get(0));
                    
                case "সাফাও":
                case "clear":
                    if (!arguments.isEmpty()) throw new RuntimeException("সাফাও() takes no arguments");
                    set.clear();
                    return null;

                case "উল্টাও":
                case "reverse":
                    if (!arguments.isEmpty()) throw new RuntimeException("উল্টাও() takes no arguments");
                    set.reverse();
                    return null;
                    
                case "অন্তর্ভুক্ত":
                case "contains":
                    if (arguments.size() != 1) throw new RuntimeException("অন্তর্ভুক্ত() expects 1 argument (element)");
                    return set.contains(arguments.get(0));
                    
                case "দৈর্ঘ্য":
                case "size":
                    if (!arguments.isEmpty()) throw new RuntimeException("দৈর্ঘ্য() takes no arguments");
                    return new BigDecimal(set.size());
                    
                case "ফাঁকা_কী":
                case "isEmpty":
                    if (!arguments.isEmpty()) throw new RuntimeException("ফাঁকা_কী() takes no arguments");
                    return set.isEmpty();
                    
                case "কপি":
                case "copy":
                    if (!arguments.isEmpty()) throw new RuntimeException("কপি() takes no arguments");
                    return set.copy();
                    
                case "অবস্থান":
                case "indexOf":
                    if (arguments.size() != 1) throw new RuntimeException("অবস্থান() expects 1 argument (element)");
                    return new BigDecimal(set.indexOf(arguments.get(0)));
                    
                case "স্ট্রিমে":
                case "toStream":
                    if (!arguments.isEmpty()) throw new RuntimeException("স্ট্রিম() method takes no arguments");
                    return set.স্ট্রিমে(this);
        
                // Set operations
                case "union":
                case "ইউনিয়ন":
                    if (arguments.size() != 1) throw new RuntimeException("union() expects 1 argument (other set)");
                    if (!(arguments.get(0) instanceof KalpanaSet)) throw new RuntimeException("union() argument must be a set");
                    return set.union((KalpanaSet) arguments.get(0));
                    
                case "intersection":
                case "ইন্টারসেকশন":
                    if (arguments.size() != 1) throw new RuntimeException("intersection() expects 1 argument (other set)");
                    if (!(arguments.get(0) instanceof KalpanaSet)) throw new RuntimeException("intersection() argument must be a set");
                    return set.intersection((KalpanaSet) arguments.get(0));
                    
                case "difference":
                case "পার্থক্য":
                    if (arguments.size() != 1) throw new RuntimeException("difference() expects 1 argument (other set)");
                    if (!(arguments.get(0) instanceof KalpanaSet)) throw new RuntimeException("difference() argument must be a set");
                    return set.difference((KalpanaSet) arguments.get(0));
                    
                case "isSubset":
                case "সাবসেট_কী":
                    if (arguments.size() != 1) throw new RuntimeException("isSubset() expects 1 argument (other set)");
                    if (!(arguments.get(0) instanceof KalpanaSet)) throw new RuntimeException("isSubset() argument must be a set");
                    return set.isSubset((KalpanaSet) arguments.get(0));
                    
                case "isSuperset":
                case "সুপারসেট_কী":
                    if (arguments.size() != 1) throw new RuntimeException("isSuperset() expects 1 argument (other set)");
                    if (!(arguments.get(0) instanceof KalpanaSet)) throw new RuntimeException("isSuperset() argument must be a set");
                    return set.isSuperset((KalpanaSet) arguments.get(0));
                    
                case "isDisjoint":
                case "নিঃছেদ_কী":
                    if (arguments.size() != 1) throw new RuntimeException("isDisjoint() expects 1 argument (other set)");
                    if (!(arguments.get(0) instanceof KalpanaSet)) throw new RuntimeException("isDisjoint() argument must be a set");
                    return set.isDisjoint((KalpanaSet) arguments.get(0));
                    
                case "symmetricDifference":
                case "সমমিত_পার্থক্য":
                    if (arguments.size() != 1) throw new RuntimeException("symmetricDifference() expects 1 argument (other set)");
                    if (!(arguments.get(0) instanceof KalpanaSet)) throw new RuntimeException("symmetricDifference() argument must be a set");
                    return set.symmetricDifference((KalpanaSet) arguments.get(0));
                    
                default:
                    throw new RuntimeException("Unknown set method: '" + expr.method().lexeme + "'");
            }
        }
    
        // Handle lists and arrays
        KalpanaList list;
        if (target instanceof KalpanaList) {
            list = (KalpanaList) target;
        } 
       else if (target instanceof Object[]) {
            // Convert array to KalpanaList for method operations
            Object[] array = (Object[]) target;
            list = new KalpanaList();
            for (Object element : array) {
                list.add(element);
            }
            // Note: The original array won't be modified, we're working on a copy
        } else {
            throw new RuntimeException("Method calls can only be used on class instances, lists, or arrays. Got: " + 
                (target == null ? "null" : target.getClass().getSimpleName()));
        }
        
        String methodName = expr.method().lexeme;
        
        // Evaluate arguments
        List<Object> arguments = new Vector<>();
        for (Expr argExpr : expr.arguments()) {
            arguments.add(evaluate(argExpr));
        }
        
        // Handle different list methods
        switch (methodName) {
            case "স্ট্রিমে":
            case "toStream":
                if (!arguments.isEmpty()) {
                    throw new RuntimeException("স্ট্রিম() method takes no arguments");
                }
                return list.স্ট্রিমে(this);
            case "যোগ": // add
                return listAdd(list, arguments);
            case "পাও": // get
                return listGet(list, arguments);
            case "সর্ট": // sort
                return listSort(list, arguments);
            case "উল্টাও": // reverse
                return listReverse(list, arguments);
            case "সাফাও": // clear
                return listClear(list, arguments);
            case "অন্তর্ভুক্ত": // contains
                return listContains(list, arguments);
            case "অবস্থান": // indexOf
                return listIndexOf(list, arguments);
            case "দৈর্ঘ্য": // length/size
                return listSize(list, arguments);
            case "ফাঁকা_কী": // isEmpty
                return listIsEmpty(list, arguments);
            case "কপি": // copy
                return listCopy(list, arguments);
            case "টুকরো": // slice
                return listSlice(list, arguments);
            case "বিস্তার": // extend
                return listExtend(list, arguments);
            case "সন্নিবেশ": // insert
                return listInsert(list, arguments);
            case "মুছ": // remove at index
                return listRemoveAt(list, arguments);
            case "প্রথম": // get first
                return listFirst(list, arguments);
            case "শেষ": // get last
                return listLast(list, arguments);
            default:
                throw new RuntimeException("Unknown list method: '" + methodName + "'");
        }
    }
    
    
    // List method implementations
    private Object listAdd(KalpanaList list, List<Object> arguments) {
        if (arguments.size() != 1) {
            throw new RuntimeException("যোগ() method expects 1 argument (element)");
        }
        list.add(arguments.get(0));
        return null;
    }

    private Object listGet(KalpanaList list, List<Object> arguments) {
        if (arguments.size() != 1) {
            throw new RuntimeException("পাও() method expects 1 argument (index)");
        }
        
        Object indexObj = arguments.get(0);
        if (!(indexObj instanceof BigDecimal)) {
            throw new RuntimeException("পাও() argument must be an integer");
        }
        
        int index = ((BigDecimal)indexObj).intValue();
        return list.get(index);
    }
    
    private Object listSort(KalpanaList list, List<Object> arguments) {
        if (arguments.size() > 0) {
            throw new RuntimeException("সর্ট() method takes no arguments");
        }
        list.sort();
        return null;
    }
    
    private Object listReverse(KalpanaList list, List<Object> arguments) {
        if (arguments.size() > 0) {
            throw new RuntimeException("উল্টাও() method takes no arguments");
        }
        list.reverse();
        return null;
    }
    
    private Object listClear(KalpanaList list, List<Object> arguments) {
        if (arguments.size() > 0) {
            throw new RuntimeException("সাফাও() method takes no arguments");
        }
        list.clear();
        return null;
    }
    
    private Object listContains(KalpanaList list, List<Object> arguments) {
        if (arguments.size() != 1) {
            throw new RuntimeException("অন্তর্ভুক্ত() method expects 1 argument (element)");
        }
        return list.contains(arguments.get(0));
    }
    
    private Object listIndexOf(KalpanaList list, List<Object> arguments) {
        if (arguments.size() != 1) {
            throw new RuntimeException("অবস্থান() method expects 1 argument (element)");
        }
        int index = list.indexOf(arguments.get(0));
        return new BigDecimal(index);
    }
    
    private Object listSize(KalpanaList list, List<Object> arguments) {
        if (arguments.size() > 0) {
            throw new RuntimeException("দৈর্ঘ্য() method takes no arguments");
        }
        return new BigDecimal(list.size());
    }
    
    private Object listIsEmpty(KalpanaList list, List<Object> arguments) {
        if (arguments.size() > 0) {
            throw new RuntimeException("ফাঁকা_কী() method takes no arguments");
        }
        return list.isEmpty();
    }
    
    private Object listCopy(KalpanaList list, List<Object> arguments) {
        if (arguments.size() > 0) {
            throw new RuntimeException("কপি() method takes no arguments");
        }
        return list.copy();
    }
    
    private Object listSlice(KalpanaList list, List<Object> arguments) {
        if (arguments.size() != 2) {
            throw new RuntimeException("টুকরো() method expects 2 arguments (start, end)");
        }
        if (!(arguments.get(0) instanceof BigDecimal) || !(arguments.get(1) instanceof BigDecimal)) {
            throw new RuntimeException("টুকরো() arguments must be integers");
        }
        int start = ((BigDecimal)arguments.get(0)).intValue();
        int end = ((BigDecimal)arguments.get(1)).intValue();
        return list.slice(start, end);
    }
    
    private Object listExtend(KalpanaList list, List<Object> arguments) {
        if (arguments.size() != 1) {
            throw new RuntimeException("বিস্তার() method expects 1 argument (other_list)");
        }
        Object otherObj = arguments.get(0);
        if (!(otherObj instanceof KalpanaList)) {
            throw new RuntimeException("বিস্তার() argument must be a list");
        }
        list.extend((KalpanaList)otherObj);
        return null;
    }
    
    private Object listInsert(KalpanaList list, List<Object> arguments) {
        if (arguments.size() != 2) {
            throw new RuntimeException("সন্নিবেশ() method expects 2 arguments (index, element)");
        }
        if (!(arguments.get(0) instanceof BigDecimal)) {
            throw new RuntimeException("সন্নিবেশ() first argument must be an integer");
        }
        int index = ((BigDecimal)arguments.get(0)).intValue();
        list.add(index, arguments.get(1));
        return null;
    }
    
    private Object listRemoveAt(KalpanaList list, List<Object> arguments) {
        if (arguments.isEmpty()) {
            // No arguments - remove and return last element
            if (list.isEmpty()) {
                throw new RuntimeException("Cannot remove from empty list");
            }
            Object lastElement = list.get(list.size());
            list.remove(list.size());
            return lastElement;
        } else if (arguments.size() == 1) {
            // One argument - remove at specific index
            if (!(arguments.get(0) instanceof BigDecimal)) {
                throw new RuntimeException("মুছ() argument must be an integer");
            }
            int index = ((BigDecimal)arguments.get(0)).intValue();
            
            // Validate index
            if (index < 1 || index > list.size()) {
                throw new RuntimeException("List index out of bounds: " + index + " (size: " + list.size() + ")");
            }
            
            Object removedElement = list.get(index);
            list.remove(index);
            return removedElement;
        } else {
            throw new RuntimeException("মুছ() expects 0 or 1 argument");
        }
    }
    
    private Object listFirst(KalpanaList list, List<Object> arguments) {
        if (arguments.size() > 0) {
            throw new RuntimeException("প্রথম() method takes no arguments");
        }
        if (list.isEmpty()) {
            throw new RuntimeException("List is empty, cannot get first element");
        }
        return list.get(1); // 1-based indexing
    }
    
    private Object listLast(KalpanaList list, List<Object> arguments) {
        if (arguments.size() > 0) {
            throw new RuntimeException("শেষ() method takes no arguments");
        }
        if (list.isEmpty()) {
            throw new RuntimeException("List is empty, cannot get last element");
        }
        return list.get(list.size()); // 1-based indexing
    }
   
    @Override
    public Object visitMultiDimAccessExpr(MultiDimAccess expr)
    {
        Object current = evaluate(expr.array());
        
        for (Expr indexExpr : expr.indices())
        {
            Object indexObj = evaluate(indexExpr);
            
            if (!(indexObj instanceof BigDecimal))
            {
                throw new RuntimeException("Array index must be an integer");
            }
            
            int index = ((BigDecimal)indexObj).intValue();
            current = accessElement(current, index);
        }
        
        return current;
    }
    @Override
    public Void visitWhileStmt(While stmt)
    {
        if (isOptimizableLoop(stmt))
        {
            optimizeLoop(stmt);
            return null;
        }
        executeLoopNormally(stmt);
        return null;
    }
    
    private boolean isOptimizableLoop(While stmt)
    {
        return canOptimizeWhileLoop(stmt.condition(), stmt.body(), stmt.increment());
    }
    
    private boolean canOptimizeWhileLoop(Expr condition, Stmt body, Expr increment)
    {
        ConditionAnalysis condAnalysis = analyzeWhileCondition(condition);
        if (condAnalysis == null)
        {
            return false;
        }
        
        BodyAnalysis bodyAnalysis = analyzeWhileBody(body, condAnalysis.variableName.lexeme);
        if (bodyAnalysis == null || !bodyAnalysis.hasOnlyCompatibleOperations)
        {
            return false;
        }
        
        // Additional check: ensure step size is constant if present
        if (increment != null)
        {
            try
            {
                BigDecimal stepSize = extractStepSize(increment, condAnalysis.variableName.lexeme);
                // If we can extract a constant step size, it's optimizable
                return true;
            }
            catch (Exception e)
            {
                // Step size is not constant - cannot optimize
                return false;
            }
        }
        
        return true;
    }
        
    private ConditionAnalysis analyzeWhileCondition(Expr condition)
    {
        if (condition instanceof Binary)
        {
            Binary binary = (Binary)condition;
            
            // Check both sides for variable vs literal/expression patterns
            Expr variableSide = null;
            Expr boundSide = null;
            boolean isVariableOnLeft = false;
            
            if (binary.left() instanceof Variable)
            {
                variableSide = binary.left();
                boundSide = binary.right();
                isVariableOnLeft = true;
            }
            else if (binary.right() instanceof Variable)
            {
                variableSide = binary.right();
                boundSide = binary.left();
                isVariableOnLeft = false;
            }
            
            if (variableSide != null)
            {
                // Evaluate the bound side to get its value
                Object boundValue = evaluateBoundExpression(boundSide);
                if (boundValue instanceof BigDecimal)
                {
                    ConditionAnalysis analysis = new ConditionAnalysis();
                    analysis.variableName = ((Variable)variableSide).name();
                    analysis.boundValue = boundValue;
                    analysis.isVariableOnLeft = isVariableOnLeft;
                    analysis.operator = binary.operator().type;
                    return analysis;
                }
            }
        }
        return null;
    }
    
    private Object evaluateBoundExpression(Expr boundExpr)
    {
        try
        {
            // Create a temporary environment for evaluation (to avoid side effects)
            Environment tempEnv = new Environment(environment);
            Interpreter tempInterpreter = new Interpreter();
            tempInterpreter.environment = tempEnv;
            
            return tempInterpreter.evaluate(boundExpr);
        }
        catch (Exception e)
        {
            // If evaluation fails, return null (can't optimize)
            return null;
        }
    }
    
    private BodyAnalysis analyzeWhileBody(Stmt body, String loopVariable)
    {
        BodyAnalysis analysis = new BodyAnalysis();
        analysis.isEmpty = false;
        analysis.hasOnlyCompatibleOperations = true;
        analysis.variableOperations = new java.util.HashMap<>();
        
        if (body instanceof Block)
        {
            Block block = (Block)body;
            if (block.statements().isEmpty())
            {
                analysis.isEmpty = true;
                return analysis;
            }
            
            for (Stmt stmt : block.statements())
            {
                if (!analyzeStatementForOptimization(stmt, loopVariable, analysis))
                {
                    analysis.hasOnlyCompatibleOperations = false;
                    return analysis;
                }
            }
        }
        else if (body instanceof Expression)
        {
            if (!analyzeExpressionForOptimization(((Expression)body).expression(), loopVariable, analysis))
            {
                analysis.hasOnlyCompatibleOperations = false;
                return analysis;
            }
        }
        else
        {
            analysis.hasOnlyCompatibleOperations = false;
        }
        
        return analysis;
    }
    
    private boolean analyzeStatementForOptimization(Stmt stmt, String loopVariable, BodyAnalysis analysis)
    {
        if (stmt instanceof Expression)
        {
            return analyzeExpressionForOptimization(((Expression)stmt).expression(), loopVariable, analysis);
        }
        return false;
    }
    
    private boolean analyzeExpressionForOptimization(Expr expr, String loopVariable, BodyAnalysis analysis)
    {
        // Check for increment/decrement operations on ANY variable
        if (expr instanceof Unary)
        {
            Unary unary = (Unary)expr;
            if ((unary.operator().type == TokenType.INCREMENT || unary.operator().type == TokenType.DECREMENT) &&
                unary.right() instanceof Variable)
            {
                Variable var = (Variable)unary.right();
                String op = unary.operator().type == TokenType.INCREMENT ? "++" : "--";
                analysis.variableOperations.put(var.name().lexeme, op);
                return true;
            }
        }
        
        // Check for assignment operations like y = y - 1
        if (expr instanceof Binary && ((Binary)expr).operator().type == TokenType.ASSIGN &&
            ((Binary)expr).left() instanceof Variable)
        {
            Variable leftVar = (Variable)((Binary)expr).left();
            return analyzeAssignmentForOptimization(((Binary)expr).right(), leftVar.name().lexeme, analysis);
        }
        
        // Handle ClassSelfAssignment: ক্লাসের(x) = value
        if (expr instanceof ClassSelfAssignment)
        {
            return analyzeClassSelfAssignmentForOptimization((ClassSelfAssignment)expr, loopVariable, analysis);
        }
        
        return false;
    }
    private boolean analyzeClassSelfAssignmentForOptimization(ClassSelfAssignment expr, String loopVariable, BodyAnalysis analysis)
    {
        String fieldName = expr.fieldName().lexeme;
        
        // Check if the right side is a binary operation like ক্লাসের(x) + 1
        if (expr.value() instanceof Binary)
        {
            Binary binary = (Binary)expr.value();
            
            // Check if it's of the form: ক্লাসের(x) + 1 or ক্লাসের(x) - 1
            if ((binary.operator().type == TokenType.PLUS || binary.operator().type == TokenType.MINUS) &&
                binary.right() instanceof Literal)
            {
                Object literalValue = ((Literal)binary.right()).value();
                
                // Check if left side is the same field
                if (binary.left() instanceof ClassSelfExpr)
                {
                    ClassSelfExpr leftField = (ClassSelfExpr)binary.left();
                    if (leftField.keyword().lexeme.equals(fieldName))
                    {
                        if (literalValue instanceof BigDecimal && ((BigDecimal)literalValue).equals(BigDecimal.ONE))
                        {
                            String op = binary.operator().type == TokenType.PLUS ? "++" : "--";
                            analysis.variableOperations.put(fieldName, op);
                            return true;
                        }
                    }
                }
            }
        }
        
        return false;
    }
        
    private boolean analyzeAssignmentForOptimization(Expr right, String varName, BodyAnalysis analysis)
    {
        if (right instanceof Binary)
        {
            Binary binary = (Binary)right;
            if (binary.left() instanceof Variable && 
                ((Variable)binary.left()).name().lexeme.equals(varName) && 
                binary.right() instanceof Literal)
            {
                Object literalValue = ((Literal)binary.right()).value();
                if (literalValue instanceof BigDecimal && ((BigDecimal)literalValue).equals(BigDecimal.ONE))
                {
                    if (binary.operator().type == TokenType.MINUS)
                    {
                        analysis.variableOperations.put(varName, "--");
                        return true;
                    }
                    else if (binary.operator().type == TokenType.PLUS)
                    {
                        analysis.variableOperations.put(varName, "++");
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private void optimizeLoop(While stmt)
    {
        try
        {
            ConditionAnalysis condAnalysis = analyzeWhileCondition(stmt.condition());
            if (condAnalysis == null)
            {
                System.err.println("Optimization failed: Could not analyze condition");
                executeLoopNormally(stmt);
                return;
            }
            
            BodyAnalysis bodyAnalysis = analyzeWhileBody(stmt.body(), condAnalysis.variableName.lexeme);
            if (bodyAnalysis == null || !bodyAnalysis.hasOnlyCompatibleOperations)
            {
                System.err.println("Optimization failed: Body not optimizable");
                executeLoopNormally(stmt);
                return;
            }
            
            Object currentValue = environment.get(condAnalysis.variableName);
            if (!(currentValue instanceof BigDecimal))
            {
                System.err.println("Optimization failed: Loop variable not numeric");
                executeLoopNormally(stmt);
                return;
            }
            
            BigDecimal current = (BigDecimal)currentValue;
            BigDecimal bound = (BigDecimal)condAnalysis.boundValue;
            
            // Get the step size from the increment expression
            BigDecimal stepSize = BigDecimal.ONE; // Default step size is 1
            if (stmt.increment() != null)
            {
                stepSize = extractStepSize(stmt.increment(), condAnalysis.variableName.lexeme);
                if (stepSize.equals(BigDecimal.ZERO))
                {
                    System.err.println("Optimization failed: Step size cannot be zero");
                    executeLoopNormally(stmt);
                    return;
                }
            }
            
            // Check if the loop will actually terminate with this step size
            if (!willLoopTerminate(current, bound, condAnalysis.operator, stepSize))
            {
                System.err.println("Optimization failed: Loop may not terminate with step size " + stepSize);
                executeLoopNormally(stmt);
                return;
            }
            
            //System.err.println("Optimizing loop: " + condAnalysis.variableName.lexeme + " from " + current + " to bound " + bound + " with step " + stepSize);
            //System.err.println("Variable operations: " + bodyAnalysis.variableOperations);
            
            BigDecimal finalValue = calculateWhileLoopFinalValue(current, bound, condAnalysis, bodyAnalysis, stepSize);
            environment.assign(condAnalysis.variableName, finalValue);
            updateOtherVariables(bodyAnalysis, condAnalysis.variableName.lexeme, current, finalValue, stepSize);
            
            //System.err.println("Loop optimization successful!");
        }
        catch (Exception e)
        {
            System.err.println("Optimization failed with error: " + e.getMessage());
            e.printStackTrace();
            executeLoopNormally(stmt);
        }
    }
    
    // Method to extract step size from increment expression
    private BigDecimal extractStepSize(Expr increment, String loopVariable)
    {
        if (increment instanceof Binary && ((Binary)increment).operator().type == TokenType.ASSIGN)
        {
            Binary assignment = (Binary)increment;
            if (assignment.left() instanceof Variable && 
                ((Variable)assignment.left()).name().lexeme.equals(loopVariable))
            {
                Expr right = assignment.right();
                if (right instanceof Binary)
                {
                    Binary binaryRight = (Binary)right;
                    if (binaryRight.left() instanceof Variable &&
                        ((Variable)binaryRight.left()).name().lexeme.equals(loopVariable))
                    {
                        if (binaryRight.operator().type == TokenType.PLUS)
                        {
                            if (binaryRight.right() instanceof Literal)
                            {
                                Object stepValue = ((Literal)binaryRight.right()).value();
                                if (stepValue instanceof BigDecimal)
                                {
                                    return (BigDecimal)stepValue;
                                }
                            }
                            else
                            {
                                // Step size is not a literal constant - cannot optimize
                                throw new RuntimeException("Step size must be constant for optimization");
                            }
                        }
                        else if (binaryRight.operator().type == TokenType.MINUS)
                        {
                            if (binaryRight.right() instanceof Literal)
                            {
                                Object stepValue = ((Literal)binaryRight.right()).value();
                                if (stepValue instanceof BigDecimal)
                                {
                                    return ((BigDecimal)stepValue).negate();
                                }
                            }
                            else
                            {
                                // Step size is not a literal constant - cannot optimize
                                throw new RuntimeException("Step size must be constant for optimization");
                            }
                        }
                    }
                }
                else if (right instanceof Unary)
                {
                    Unary unaryRight = (Unary)right;
                    if (unaryRight.right() instanceof Variable &&
                        ((Variable)unaryRight.right()).name().lexeme.equals(loopVariable))
                    {
                        if (unaryRight.operator().type == TokenType.INCREMENT)
                        {
                            return BigDecimal.ONE;
                        }
                        else if (unaryRight.operator().type == TokenType.DECREMENT)
                        {
                            return new BigDecimal(-1);
                        }
                    }
                }
            }
        }
        return BigDecimal.ONE; // Default to step size 1 for i++ or i--
    }
    
    // Check if the loop will terminate with given step size
    private boolean willLoopTerminate(BigDecimal current, BigDecimal bound, TokenType operator, BigDecimal stepSize)
    {
        if (stepSize.compareTo(BigDecimal.ZERO) > 0)
        {
            // Positive step size
            switch (operator)
            {
                case LESS:
                case LESS_EQUAL:
                    return current.compareTo(bound) <= 0;
                case GREATER:
                case GREATER_EQUAL:
                    return current.compareTo(bound) >= 0;
            }
        }
        else if (stepSize.compareTo(BigDecimal.ZERO) < 0)
        {
            // Negative step size
            switch (operator)
            {
                case LESS:
                case LESS_EQUAL:
                    return current.compareTo(bound) >= 0;
                case GREATER:
                case GREATER_EQUAL:
                    return current.compareTo(bound) <= 0;
            }
        }
        
        return true; // Default to true for unknown cases
    }
    
    // Calculate final value with step size
    private BigDecimal calculateWhileLoopFinalValue(BigDecimal current, BigDecimal bound, 
                                                  ConditionAnalysis condAnalysis, BodyAnalysis bodyAnalysis,
                                                  BigDecimal stepSize)
    {
        String operation = bodyAnalysis.variableOperations.get(condAnalysis.variableName.lexeme);
        
        if (operation == null)
        {
            return calculateFinalValueFromCondition(current, bound, condAnalysis, stepSize);
        }
        
        BigDecimal iterations = calculateIterationCount(current, bound, condAnalysis, operation, stepSize);
        return applyOperationMultipleTimes(current, operation, iterations, stepSize);
    }
    
    // Calculate final value from condition with step size
    private BigDecimal calculateFinalValueFromCondition(BigDecimal current, BigDecimal bound, 
                                                       ConditionAnalysis condAnalysis, BigDecimal stepSize)
    {
        // For simple loops without body operations, calculate based on condition and step
        if (stepSize.compareTo(BigDecimal.ZERO) > 0)
        {
            // Positive step
            switch (condAnalysis.operator)
            {
                case LESS_EQUAL:
                    return bound;
                case LESS:
                    return bound.subtract(BigDecimal.ONE);
                case GREATER_EQUAL:
                    return current; // Won't enter loop
                case GREATER:
                    return current; // Won't enter loop
            }
        }
        else
        {
            // Negative step
            switch (condAnalysis.operator)
            {
                case GREATER_EQUAL:
                    return bound;
                case GREATER:
                    return bound.add(BigDecimal.ONE);
                case LESS_EQUAL:
                    return current; // Won't enter loop
                case LESS:
                    return current; // Won't enter loop
            }
        }
        return current;
    }
    
    // Calculate iteration count with step size
    private BigDecimal calculateIterationCount(BigDecimal current, BigDecimal bound, 
                                           ConditionAnalysis condAnalysis, String operation, BigDecimal stepSize)
    {
        try
        {
            if (stepSize.equals(BigDecimal.ZERO))
            {
                throw new RuntimeException("Step size cannot be zero");
            }
            
            // For positive step size
            if (stepSize.compareTo(BigDecimal.ZERO) > 0)
            {
                switch (condAnalysis.operator)
                {
                    case LESS_EQUAL:
                        if (operation.equals("++"))
                        {
                            BigDecimal difference = bound.subtract(current);
                            return difference.divide(stepSize, 0, RoundingMode.CEILING).add(BigDecimal.ONE);
                        }
                        break;
                    case LESS:
                        if (operation.equals("++"))
                        {
                            BigDecimal difference = bound.subtract(current).subtract(BigDecimal.ONE);
                            return difference.divide(stepSize, 0, RoundingMode.CEILING).add(BigDecimal.ONE);
                        }
                        break;
                    case GREATER_EQUAL:
                        if (operation.equals("--"))
                        {
                            BigDecimal difference = current.subtract(bound);
                            return difference.divide(stepSize, 0, RoundingMode.CEILING).add(BigDecimal.ONE);
                        }
                        break;
                    case GREATER:
                        if (operation.equals("--"))
                        {
                            BigDecimal difference = current.subtract(bound).subtract(BigDecimal.ONE);
                            return difference.divide(stepSize, 0, RoundingMode.CEILING).add(BigDecimal.ONE);
                        }
                        break;
                }
            }
            // For negative step size
            else
            {
                switch (condAnalysis.operator)
                {
                    case GREATER_EQUAL:
                        if (operation.equals("++")) // Actually decreasing with negative step
                        {
                            BigDecimal difference = current.subtract(bound);
                            return difference.divide(stepSize.abs(), 0, RoundingMode.CEILING).add(BigDecimal.ONE);
                        }
                        break;
                    case GREATER:
                        if (operation.equals("++")) // Actually decreasing with negative step
                        {
                            BigDecimal difference = current.subtract(bound).subtract(BigDecimal.ONE);
                            return difference.divide(stepSize.abs(), 0, RoundingMode.CEILING).add(BigDecimal.ONE);
                        }
                        break;
                    case LESS_EQUAL:
                        if (operation.equals("--")) // Actually increasing with negative step
                        {
                            BigDecimal difference = bound.subtract(current);
                            return difference.divide(stepSize.abs(), 0, RoundingMode.CEILING).add(BigDecimal.ONE);
                        }
                        break;
                    case LESS:
                        if (operation.equals("--")) // Actually increasing with negative step
                        {
                            BigDecimal difference = bound.subtract(current).subtract(BigDecimal.ONE);
                            return difference.divide(stepSize.abs(), 0, RoundingMode.CEILING).add(BigDecimal.ONE);
                        }
                        break;
                }
            }
        }
        catch (Exception e)
        {
            System.err.println("Error calculating iterations: " + e.getMessage());
        }
        return BigDecimal.ZERO;
    }
    
    // Apply operation with step size
    private BigDecimal applyOperationMultipleTimes(BigDecimal value, String operation, BigDecimal times, BigDecimal stepSize)
    {
        if (operation.equals("++"))
        {
            return value.add(times.multiply(stepSize));
        }
        if (operation.equals("--"))
        {
            return value.subtract(times.multiply(stepSize));
        }
        return value;
    }
        
        // Update other variables with step size
    private void updateOtherVariables(BodyAnalysis bodyAnalysis, String loopVariable, 
                                     BigDecimal initialValue, BigDecimal finalValue, BigDecimal stepSize)
    {
        // Calculate actual number of iterations
        BigDecimal iterations = BigDecimal.ZERO;
        if (!stepSize.equals(BigDecimal.ZERO))
        {
            iterations = finalValue.subtract(initialValue).divide(stepSize, 0, RoundingMode.CEILING).abs();
        }
        
        for (java.util.Map.Entry<String, String> entry : bodyAnalysis.variableOperations.entrySet())
        {
            String varName = entry.getKey();
            String operation = entry.getValue();
            
            if (varName.equals(loopVariable))
            {
                continue;
            }
            
            try
            {
                // Try to get as regular variable first
                Object currentVal = environment.get(new Token(TokenType.IDENTIFIER, varName, null, 0));
                
                if (currentVal instanceof BigDecimal)
                {
                    BigDecimal current = (BigDecimal)currentVal;
                    BigDecimal newValue = applyOperationMultipleTimes(current, operation, iterations, BigDecimal.ONE);
                    environment.assign(new Token(TokenType.IDENTIFIER, varName, null, 0), newValue);
                }
            }
            catch (RuntimeException e)
            {
                // If not found as regular variable, try as class field
                try
                {
                    Token thisToken = new Token(TokenType.IDENTIFIER, "this", null, 0);
                    Object thisObj = environment.get(thisToken);
                    
                    if (thisObj instanceof ClassInstance)
                    {
                        ClassInstance instance = (ClassInstance)thisObj;
                        Object currentVal = instance.get(new Token(TokenType.IDENTIFIER, varName, null, 0));
                        
                        if (currentVal instanceof BigDecimal)
                        {
                            BigDecimal current = (BigDecimal)currentVal;
                            BigDecimal newValue = applyOperationMultipleTimes(current, operation, iterations, BigDecimal.ONE);
                            instance.set(new Token(TokenType.IDENTIFIER, varName, null, 0), newValue);
                        }
                    }
                }
                catch (Exception ex)
                {
                    System.err.println("Warning: Could not optimize variable " + varName + ": " + ex.getMessage());
                }
            }
        }
    }
    
    private void executeLoopNormally(While stmt)
    {
        while (isTruthy(evaluate(stmt.condition())))
        {
            try
            {
                execute(stmt.body());
            }
            catch (BreakException e)
            {
                break;
            }
            catch (ContinueException e)
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
    }
    
    private static class ConditionAnalysis
    {
        Token variableName;
        Object boundValue;
        TokenType operator;
        boolean isVariableOnLeft;
    }
    
    private static class BodyAnalysis
    {
        boolean isEmpty;
        boolean hasOnlyCompatibleOperations;
        java.util.Map<String, String> variableOperations;
    }
        
    @Override
    public Void visitVarStmt(Var stmt)
    {
        Object value = null;
        
        // Process initializer if present
        if (stmt.initializer() != null)
        {
            value = evaluate(stmt.initializer());
    
            // TYPE VALIDATION FOR SET
            if (stmt.name().type == TokenType.SET) {
                if (!(value instanceof KalpanaSet)) {
                    // Allow conversion from list to set (removing duplicates)
                    if (value instanceof KalpanaList) {
                        KalpanaList list = (KalpanaList) value;
                        KalpanaSet set = new KalpanaSet();
                        for (int i = 0; i < list.size(); i++) {
                            set.add(list.get(i + 1));
                        }
                        value = set;
                    } else if (value == null) {
                        // Create empty set for null initialization
                        value = new KalpanaSet();
                    } else {
                        throw new RuntimeException("SET variable '" + stmt.name().lexeme + "' can only hold set values.");
                    }
                }
            }

            // TYPE VALIDATION FOR LIST
            if (stmt.name().type == TokenType.LIST)
            {
                if (!(value instanceof KalpanaList))
                {
                    // Allow conversion from array to list
                    if (value instanceof Object[])
                    {
                        Object[] array = (Object[])value;
                        KalpanaList list = new KalpanaList();
                        for (Object element : array)
                        {
                            list.add(element);
                        }
                        value = list;
                    }
                    else
                    {
                        throw new RuntimeException("LIST variable '" + stmt.name().lexeme + "' can only hold list values.");
                    }
                }
            }
            else if (stmt.name().type == TokenType.STREAM)
            {
                if (!(value instanceof KalpanaStream))
                {
                                    // Allow conversion from list to stream
                    if (value instanceof KalpanaList)
                    {
                        value = ((KalpanaList)value).স্ট্রিমে(this);
                    }
                    else if (value == null)
                    {
                        // Create empty stream for null initialization
                        value = new KalpanaList().স্ট্রিমে(this);
                    }
                    else
                    {
                        throw new RuntimeException("STREAM variable '" + stmt.name().lexeme + "' can only hold stream values. Got: " + stringify(value));
                    }
                }
            }
                
            // ====================================================================
            // PRIMARY TYPE VALIDATION CHECKS
            // ====================================================================
            
            // CHECK 1: Prevent file handles in primitive variables (early check)
            // This catches file handles (strings from file operations) being assigned to wrong types
            // Needed to prevent: int x = খোলো("file.txt");
            if (value instanceof String && fileHandles.containsKey(value) && 
                stmt.name().type != TokenType.FILE && stmt.name().type != TokenType.ALL) 
            {
                throw new RuntimeException(stmt.name().type.bangla + " variable '" + stmt.name().lexeme + 
                                         "' cannot hold file references. Use 'ফাইল' type for files or 'সব' for any type.");
            }
            
            // ====================================================================
            // FILE TYPE SPECIFIC VALIDATION
            // ====================================================================
            if (stmt.name().type == TokenType.FILE)
            {
                // Valid: file handle from file operation
                if (value instanceof String && fileHandles.containsKey(value))
                {
                    environment.define(stmt.name().lexeme, value);
                    environment.defineVariableType(stmt.name().lexeme, stmt.name().type);
                    return null;
                }
                // Valid: null initialization
                else if (value == null)
                {
                    environment.define(stmt.name().lexeme, null);
                    environment.defineVariableType(stmt.name().lexeme, stmt.name().type);
                    return null;
                }
                // Invalid: objects assigned to file variables
                // Needed to prevent: ফাইল f = @Math;
                else if (value instanceof ClassInstance)
                {
                    throw new RuntimeException(stmt.name().type.bangla + " variable '" + stmt.name().lexeme + 
                                             "' cannot hold object references. Use 'অবজেক্ট' type for objects or 'সব' for any type.");
                }
                // Invalid: primitive values assigned to file variables
                // Needed to prevent: ফাইল f = 123;
                else
                {
                    String valueType = "unknown";
                    if (value instanceof BigDecimal) valueType = "number";
                    else if (value instanceof Boolean) valueType = "boolean";
                    else if (value instanceof Object[]) valueType = "array";
                    
                    throw new RuntimeException("File variable '" + stmt.name().lexeme + 
                                             "' cannot be assigned a " + valueType + " value (" + 
                                             stringify(value) + "). Use 'খোলো(\"file_path\")' to open a file.");
                }
            }
            
            // ====================================================================
            // SECONDARY VALIDATION CHECKS (for non-FILE types)
            // ====================================================================
            
            // CHECK 2: Additional file handle validation for other types
            // This is a redundant safety check to catch any missed file handle assignments
            else if (stmt.name().type != TokenType.ALL && stmt.name().type != TokenType.FILE && 
                     value instanceof String && fileHandles.containsKey(value))
            {
                throw new RuntimeException(stmt.name().type.bangla + " variable '" + stmt.name().lexeme + 
                                         "' cannot hold file references. Use 'ফাইল' type for files or 'সব' for any type.");
            }
            
            // CHECK 3: Object type validation - only allow ClassInstance or null
            // Needed to prevent: অবজেক্ট o = 123; or অবজেক্ট o = "hello";
            else if (stmt.name().type == TokenType.OBJECT)
            {
                if (!(value instanceof ClassInstance) && value != null)
                {
                    throw new RuntimeException("Object variable '" + stmt.name().lexeme + 
                                             "' can only hold class references, not primitive values like " + 
                                             stringify(value));
                }
            }
            // CHECK 4: Prevent objects in primitive variables
            // Needed to prevent: int x = @Math; or string s = @Math;
            else if (stmt.name().type != TokenType.ALL && 
                     stmt.name().type != TokenType.OBJECT &&
                     value instanceof ClassInstance)
            {
                throw new RuntimeException(stmt.name().type.bangla + " variable '" + stmt.name().lexeme + 
                                         "' cannot hold object references. Use 'অবজেক্ট' type for objects or 'সব' for any type.");
            }
            
            // ====================================================================
            // TYPE CHECKING + AUTO CONVERSION FOR PRIMITIVE TYPES
            // ====================================================================
            else if (stmt.name().type == TokenType.INTEGER)
            {
                // INTEGER: ONLY allow numbers - NO string conversion
                if (value instanceof BigDecimal || value instanceof Integer || value instanceof Double)
                {
                    // Auto-convert to integer by truncating decimals
                    value = convertToBigDecimal(value).setScale(0, RoundingMode.DOWN);
                }
                else if (value instanceof String)
                {
                    // STRICT: No string to number conversion - "3" is a string, not a number!
                    throw new RuntimeException("INTEGER variable '" + stmt.name().lexeme + 
                                             "' cannot be assigned string value: " + value);
                }
                else
                {
                    throw new RuntimeException("INTEGER variable '" + stmt.name().lexeme + 
                                             "' cannot be assigned " + getTypeName(value) + " value: " + stringify(value));
                }
            }
            else if (stmt.name().type == TokenType.FLOAT)
            {
                // FLOAT: ONLY allow numbers - NO string conversion
                if (value instanceof BigDecimal || value instanceof Integer || value instanceof Double)
                {
                    // Ensure float representation for numbers without decimals
                    BigDecimal bd = convertToBigDecimal(value);
                    if (bd.scale() <= 0)
                    {
                        value = new BigDecimal(bd.toString() + ".0");
                    }
                    else
                    {
                        value = bd;
                    }
                }
                else if (value instanceof String)
                {
                    // STRICT: No string to number conversion
                    throw new RuntimeException("FLOAT variable '" + stmt.name().lexeme + 
                                             "' cannot be assigned string value: " + value);
                }
                else
                {
                    throw new RuntimeException("FLOAT variable '" + stmt.name().lexeme + 
                                             "' cannot be assigned " + getTypeName(value) + " value: " + stringify(value));
                }
            }
            else if (stmt.name().type == TokenType.STRING)
            {
                // STRING: only allow strings - no auto-conversion
                if (!(value instanceof String))
                {
                    throw new RuntimeException("STRING variable '" + stmt.name().lexeme + 
                                             "' cannot be assigned " + getTypeName(value) + " value: " + stringify(value));
                }
            }
            else if (stmt.name().type == TokenType.BOOLEAN)
            {
                // BOOLEAN: ONLY allow booleans and numbers - NO string conversion
                if (value instanceof Boolean)
                {
                    // Already boolean, keep as is
                }
                else if (value instanceof BigDecimal || value instanceof Integer || value instanceof Double)
                {
                    // C-style boolean conversion: 0 = false, non-zero = true
                    value = !convertToBigDecimal(value).equals(BigDecimal.ZERO);
                }
                else if (value instanceof String)
                {
                    // STRICT: No string to boolean conversion
                    throw new RuntimeException("BOOLEAN variable '" + stmt.name().lexeme + 
                                             "' cannot be assigned string value: " + value);
                }
                else
                {
                    throw new RuntimeException("BOOLEAN variable '" + stmt.name().lexeme + 
                                             "' cannot be assigned " + getTypeName(value) + " value: " + stringify(value));
                }
            }
            // For ALL type, no conversion needed - accept anything
        }
        
        // ====================================================================
        // DEFAULT VALUE INITIALIZATION
        // ====================================================================
        if (value == null)
        {
            switch (stmt.name().type)
            {
                case INTEGER:
                    value = BigDecimal.ZERO.setScale(0, RoundingMode.DOWN);
                    break;
                case FLOAT:
                    value = new BigDecimal("0.0");
                    break;
                case STRING:
                    value = "";
                    break;
                case LIST:
                    value = new KalpanaList(); // Empty list
                    break;
                case BOOLEAN:
                    value = false;
                    break;
                case OBJECT:
                    value = null; // Objects default to null
                    break;
                case STREAM:
                    value = new KalpanaList().স্ট্রিমে(this); // Empty stream
                    break;
                case SET:
                    value = new KalpanaSet(); // Empty set
                    break;
                case FILE:
                    value = null; // Files default to null
                    break;
                case ALL:
                    value = null; // ALL type can be null by default
                    break;
            }
        }
        
        // Store the variable and its type in environment
        environment.define(stmt.name().lexeme, value);
        environment.defineVariableType(stmt.name().lexeme, stmt.name().type);
        return null;
    }
    
    // Add these helper methods
    private String getTypeName(Object value)
    {
        if (value == null) return "null";
        if (value instanceof BigDecimal) return "number";
        if (value instanceof String) return "string";
        if (value instanceof Boolean) return "boolean";
        if (value instanceof Object[]) return "array";
        if (value instanceof KalpanaList) return "list";
        if (value instanceof ClassInstance) return "object";
        return value.getClass().getSimpleName().toLowerCase();
    }
    
    private BigDecimal convertToBigDecimal(Object value)
    {
        if (value instanceof BigDecimal) return (BigDecimal)value;
        if (value instanceof Integer) return new BigDecimal((Integer)value);
        if (value instanceof Double) return BigDecimal.valueOf((Double)value);
        throw new RuntimeException("Cannot convert to BigDecimal: " + value);
    }
    
    @Override
    public Void visitArrayStmt(ArrayStmt stmt)
    {
        Object[] array = null;
        int size = 0;
        boolean isArgumentFunction = false;
        int declaredSize = -1; // -1 means no size declared (unlimited)
    
        // Check if initializer is আর্গুমেন্ট() function call
        if (!stmt.initialValues().isEmpty() &&
                stmt.initialValues().size() == 1 &&
                stmt.initialValues().get(0) instanceof Call)
        {
            Call call = (Call)stmt.initialValues().get(0);
            if (call.callee() instanceof Variable)
            {
                Variable callee = (Variable)call.callee();
                if (callee.name().lexeme.equals("আর্গুমেন্ট"))
                {
                    isArgumentFunction = true;
                    
                    // Get command line arguments
                    String[] argsArray = Main.commandLineArgs.toArray(new String[0]);
                    int argsCount = argsArray.length;
                    
                    // VALIDATION: Check if command line arguments exceed declared array size
                    if (stmt.size() != null)
                    {
                        Object sizeValue = evaluate(stmt.size());
                        if (!(sizeValue instanceof BigDecimal))
                        {
                            throw new RuntimeException("Array size must be an integer");
                        }
                        declaredSize = ((BigDecimal)sizeValue).intValue();
                        
                        if (declaredSize > 0 && argsCount > declaredSize)
                        {
                            throw new RuntimeException("Command line has " + argsCount + 
                                                     " arguments but array size is " + declaredSize);
                        }
                        
                        size = declaredSize;
                        
                        // Create array with declared size, copy only what fits
                        array = new String[declaredSize];
                        int copyCount = Math.min(argsCount, declaredSize);
                        System.arraycopy(argsArray, 0, array, 0, copyCount);
                        
                        // Fill remaining elements with empty strings
                        for (int i = copyCount; i < declaredSize; i++)
                        {
                            array[i] = "";
                        }
                    }
                    else
                    {
                        // No size declared - use all arguments
                        array = argsArray;
                        size = argsCount;
                    }
                }
            }
        }
    
        // Handle array size if specified and not already handled by আর্গুমেন্ট()
        if (stmt.size() != null && !isArgumentFunction)
        {
            Object sizeValue = evaluate(stmt.size());
            if (!(sizeValue instanceof BigDecimal))
            {
                throw new RuntimeException("Array size must be an integer");
            }
            declaredSize = ((BigDecimal)sizeValue).intValue();
            if (declaredSize <= 0)
            {
                throw new RuntimeException("Array size must be positive");
            }
            size = declaredSize;
            
            // VALIDATION: Check if initial values exceed declared size
            if (!stmt.initialValues().isEmpty() && stmt.initialValues().size() > declaredSize)
            {
                throw new RuntimeException("Array initialization has " + stmt.initialValues().size() + 
                                         " elements but declared size is " + declaredSize);
            }
        }
        // Handle initial values if not আর্গুমেন্ট() and no size specified
        else if (!stmt.initialValues().isEmpty() && !isArgumentFunction)
        {
            // Special case: if the initializer returns an array, use it directly
            if (stmt.initialValues().size() == 1)
            {
                Object initValue = evaluate(stmt.initialValues().get(0));
                if (initValue instanceof Object[])
                {
                    array = (Object[])initValue;
                    size = array.length;
                }
                else
                {
                    size = 1;
                }
            }
            else
            {
                size = stmt.initialValues().size();
            }
        }
        // If no size or initial values provided, create empty array (unlimited)
        else if (!isArgumentFunction)
        {
            size = 0; // Start with empty array that will grow as needed
        }
    
        // Initialize array if not already initialized by আর্গুমেন্ট()
        if (array == null && !isArgumentFunction)
        {
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
                    boolean showedWarning = false;
                    
                    for (int i = 0; i < size; i++)
                    {
                        if (i < stmt.initialValues().size())
                        {
                            Object val = evaluate(stmt.initialValues().get(i));
                            
                            if (val instanceof BigDecimal)
                            {
                                if (!showedWarning)
                                {
                                    System.out.println(Main.YELLOW + "Warning: Auto-converting numbers to booleans (0=false, non-zero=true)" + Main.RESET);
                                    showedWarning = true;
                                }
                                array[i] = !((BigDecimal)val).equals(BigDecimal.ZERO);
                            } 
                            else if (val instanceof Boolean)
                            {
                                array[i] = (Boolean)val;
                            }
                            else if (val instanceof String)
                            {
                                throw new RuntimeException("Cannot convert string to boolean in array");
                            }
                            else
                            {
                                throw new RuntimeException("Boolean array elements must be numbers or booleans");
                            }
                        }
                        else
                        {
                            array[i] = null; // Default value for boolean array
                        }
                    }
                    break;
                default:
                    throw new RuntimeException("Unknown array type");
            }
        }
    
        // Apply initial values if not আর্গুমেন্ট() and not direct array assignment
        boolean isDirectArrayAssignment = stmt.initialValues().size() == 1 && 
                                          evaluate(stmt.initialValues().get(0)) instanceof Object[];
        
        if (!isArgumentFunction && !isDirectArrayAssignment)
        {
            for (int i = 0; i < stmt.initialValues().size(); i++)
            {
                if (i >= array.length)
                {
                    // For unlimited arrays, resize when needed
                    int newSize = Math.max(array.length * 2, i + 1);
                    Object[] newArray = (Object[])java.lang.reflect.Array.newInstance(
                                        array.getClass().getComponentType(), newSize);
                    System.arraycopy(array, 0, newArray, 0, array.length);
                    
                    // Initialize new elements with default values
                    Object defaultValue = getDefaultValue(array.getClass().getComponentType());
                    for (int j = array.length; j < newSize; j++)
                    {
                        newArray[j] = defaultValue;
                    }
                    
                    array = newArray;
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
                        }
                        else if (value instanceof Integer || value instanceof Double)
                        {
                            BigDecimal bd = new BigDecimal(value.toString());
                            array[i] = bd.setScale(0, RoundingMode.DOWN);
                        }
                        else
                        {
                            throw new RuntimeException("Integer array can only contain numbers");
                        }
                        break;
                    case FLOAT_ARRAY:
                        if (value instanceof BigDecimal)
                        {
                            array[i] = (BigDecimal)value;
                        }
                        else if (value instanceof Number)
                        {
                            array[i] = new BigDecimal(value.toString());
                        }
                        else
                        {
                            throw new RuntimeException("Float array can only contain numbers");
                        }
                        break;
                    case STRING_ARRAY:
                        // STRICT VALIDATION: Only allow strings in string array
                        if (!(value instanceof String))
                        {
                            throw new RuntimeException("String array can only contain strings. Found: " + 
                                                     stringify(value) + " of type " + 
                                                     (value == null ? "null" : value.getClass().getSimpleName()));
                        }
                        array[i] = (String)value;
                        break;
                }
            }
        }
    
        if (stmt.initialValues().size() == 1 && stmt.initialValues().get(0) instanceof Call)
        {
            Call call = (Call) stmt.initialValues().get(0);
            if (call.callee() instanceof Variable)
            {
                Variable callee = (Variable)call.callee();
                if (callee.name().lexeme.equals("অ্যারে_জেনারেটর"))
                {
                    // Evaluate the array generator
                    Object generatedArray = evaluate(call);
                    
                    if (generatedArray instanceof Object[])
                    {
                        Object[] genArray = (Object[])generatedArray;
                        int generatedSize = genArray.length;
                        
                        // Check if declared size can hold generated array
                        if (stmt.size() != null)
                        {
                            Object declaredSizeObj = evaluate(stmt.size());
                            if (declaredSizeObj instanceof BigDecimal)
                            {
                                int actualDeclaredSize = ((BigDecimal)declaredSizeObj).intValue();
                                
                                if (generatedSize > actualDeclaredSize)
                                {
                                    throw new RuntimeException(
                                        "Array generator produced " + generatedSize + 
                                        " elements but array '" + stmt.name().lexeme + 
                                        "' can only hold " + actualDeclaredSize + " elements."
                                    );
                                }
                            }
                        }
                        
                        // Use the generated array
                        array = genArray;
                    }
                }
            }
        }
        // Store the array with size information
        environment.defineArray(stmt.name().lexeme, stmt.type(), array, declaredSize == -1);
        return null;
    }

    @Override
    public Object visitArraySizeExpr(ArraySize expr)
    {
        Object array = evaluate(expr.array());
    
        if (array instanceof Object[])
        {
            int size = ((Object[])array).length;
            // Return as BigDecimal to match your number system, or as Integer
            return new BigDecimal(size);
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
                String input = new String(scanner.nextLine().trim());

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
    
        // ====================================================================
        // ASSIGNMENT OPERATION HANDLING
        // ====================================================================
        if (expr.operator().type == TokenType.ASSIGN && expr.left() instanceof Variable)
        {
            Token name = ((Variable)expr.left()).name();
            
            // TYPE CHECKING FOR REASSIGNMENT
            TokenType variableType = environment.getVariableType(name.lexeme);
            if (variableType == null)
            {
                throw new RuntimeException("Undefined variable '" + name.lexeme + "'");
            }
            
            // ====================================================================
            // TYPE VALIDATION CHECKS FOR REASSIGNMENT
            // ====================================================================
            
            // CHECK 1: OBJECT TYPE VALIDATION
            // Needed to prevent: অবজেক্ট m = খোলো("file.txt"); or অবজেক্ট m = 123;
            if (variableType == TokenType.OBJECT)
            {
                // Allow only object assignments (ClassInstance) or null
                if (!(right instanceof ClassInstance) && right != null)
                {
                    // Check if it's a file handle first - show consistent error message
                    // Needed to prevent: অবজেক্ট m = খোলো("file.txt");
                    if (right instanceof String && fileHandles.containsKey(right))
                    {
                        throw new RuntimeException(variableType.bangla + " variable '" + name.lexeme + 
                                                 "' cannot hold file references. Use 'ফাইল' type for files or 'সব' for any type.");
                    }
                    
                    // General primitive value error for objects
                    // Needed to prevent: অবজেক্ট m = 123; or অবজেক্ট m = "hello";
                    throw new RuntimeException("Object variable '" + name.lexeme + 
                                             "' can only hold class references, not primitive values like " + 
                                             stringify(right));
                }
                
                environment.assign(name, right);
                return right;
            }
            
            //I added this type checking to prevent reassignment list by other values without list
            if(variableType == TokenType.LIST && !(right instanceof KalpanaList))
            {
                throw new RuntimeException("List cannot hold any primitive value or object or anything except list.");
             }
             //I added this type checking to prevent reassignment Stream by other values without Stream
            if(variableType == TokenType.STREAM && !(right instanceof KalpanaStream))
            {
                throw new RuntimeException("STREAM variable \'" + name.lexeme + "\' can only hold stream values. Got: " + stringify(right));
             }
            // CHECK 2: Prevent objects in primitive variables
            // Needed to prevent: int x = @Math; or string s = @Math;
            if (variableType != TokenType.ALL && 
                variableType != TokenType.OBJECT &&
                right instanceof ClassInstance)
            {
                throw new RuntimeException(variableType.bangla + " variable '" + name.lexeme + 
                                         "' cannot hold object references. Use 'অবজেক্ট' type for objects or 'সব' for any type.");
            }
            
            // 
             if (variableType == TokenType.SET) {
                if (!(right instanceof KalpanaSet)) {
                    // Allow conversion from list to set
                    if (right instanceof KalpanaList) {
                        KalpanaList list = (KalpanaList) right;
                        KalpanaSet set = new KalpanaSet();
                        for (int i = 0; i < list.size(); i++) {
                            set.add(list.get(i + 1));
                        }
                        right = set;
                    } else {
                        throw new RuntimeException("SET variable '" + name.lexeme + "' can only hold set values.");
                    }
                }
            }
            // CHECK 3: Prevent file handles in primitive variables
            // Needed to prevent: int x = খোলো("file.txt"); or string s = খোলো("file.txt");
            if (variableType != TokenType.ALL && 
                variableType != TokenType.FILE &&
                right instanceof String && fileHandles.containsKey(right))
            {
                throw new RuntimeException(variableType.bangla + " variable '" + name.lexeme + 
                                         "' cannot hold file references. Use 'ফাইল' type for files or 'সব' for any type.");
            }
            
            // NEW CHECK: Prevent ANY strings in FILE variables during reassignment
            // Needed to prevent: ফাইল ff = "Hello"; (already handled in visitVarStmt) 
            // and ফাইল ff; ff = "Hello"; (this is the bug!)
            if (variableType == TokenType.FILE && right instanceof String && !fileHandles.containsKey(right))
            {
                throw new RuntimeException("File variable '" + name.lexeme + 
                                         "' cannot be assigned a string value (" + stringify(right) + 
                                         "). Use 'খোলো(\"file_path\")' to open a file.");
            }
    
            // For other types, using existing conversion logic
            Object convertedValue = convertToExpectedType(right, variableType);
            environment.assign(name, convertedValue);
            return convertedValue;
        }
    
        // ====================================================================
        // TYPE NORMALIZATION FOR MATHEMATICAL OPERATIONS
        // ====================================================================
        // Convert Java primitives to BigDecimal for consistent mathematical operations
        if (left instanceof Integer) left = new BigDecimal((Integer)left);
        if (right instanceof Integer) right = new BigDecimal((Integer)right);
        if (left instanceof Double) left = BigDecimal.valueOf((Double)left);
        if (right instanceof Double) right = BigDecimal.valueOf((Double)right);
    
        // ====================================================================
        // BINARY OPERATOR IMPLEMENTATION
        // ====================================================================
        switch (expr.operator().type)
        {
            // ARITHMETIC OPERATIONS
            case PLUS:
                // String concatenation or numeric addition
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
                // Numeric subtraction
                if (left instanceof BigDecimal && right instanceof BigDecimal)
                {
                    return ((BigDecimal)left).subtract((BigDecimal)right);
                }
                throw new RuntimeException("Operands must be numbers");
    
            case MULTIPLY:
                // Numeric multiplication
                if (left instanceof BigDecimal && right instanceof BigDecimal)
                {
                    return ((BigDecimal)left).multiply((BigDecimal)right);
                }
                throw new RuntimeException("Operands must be numbers");
    
            case DIVIDE:
                // Numeric division with dynamic precision handling
                if (left instanceof BigDecimal && right instanceof BigDecimal)
                {
                    BigDecimal leftBD = (BigDecimal)left;
                    BigDecimal rightBD = (BigDecimal)right;
                    
                    // Simple dynamic scale: based on input precision + safety margin
                    int dynamicScale = Math.max(leftBD.precision(), rightBD.precision()) + 50;
                    dynamicScale = Math.min(dynamicScale, 1000); // Cap at 1000
                    
                    try
                    {
                        BigDecimal result = leftBD.divide(rightBD, dynamicScale, RoundingMode.HALF_UP);
                        return result;
                    } 
                    catch (ArithmeticException e)
                    {
                        // Fallback with MathContext
                        MathContext mc = new MathContext(dynamicScale, RoundingMode.HALF_UP);
                        return leftBD.divide(rightBD, mc);
                    }
                }
                throw new RuntimeException("Operands must be numbers");
    
            /*
            //My ultimate solution
            case DIVIDE:
                if (left instanceof BigDecimal && right instanceof BigDecimal)
                {
                    try
                    {
                        BigDecimal result = ((BigDecimal)left).divide((BigDecimal)right, 1000, RoundingMode.HALF_UP);
                            System.out.println("Ans from visitBinExpr: " + result);
                        
                        // Convert to plain string representation immediately to avoid scientific notation issues
                        // But still return as BigDecimal for mathematical operations
                        String plainResult = result.toPlainString();
                        BigDecimal plainDecimal = new BigDecimal(plainResult);
                        
                        return plainDecimal;
                    } catch (ArithmeticException e)
                    {
                        BigDecimal result = ((BigDecimal)left).divide((BigDecimal)right, MathContext.DECIMAL128);
                        String plainResult = result.toPlainString();
                        BigDecimal plainDecimal = new BigDecimal(plainResult);
                        return plainDecimal;
                    }
                }
                throw new RuntimeException("Operands must be numbers");
            */
    
            case MODULO:
                // Numeric modulus operation
                if (left instanceof BigDecimal && right instanceof BigDecimal)
                {
                    return ((BigDecimal)left).remainder((BigDecimal)right);
                }
                throw new RuntimeException("Operands must be numbers");
    
            // COMPARISON OPERATIONS
            case EQUAL_EQUAL:
                if (left instanceof ClassInstance && right instanceof ClassInstance) {
                    // Compare objects by their hash
                    return ((ClassInstance)left).equals((ClassInstance)right);
                }
                return isEqual(left, right);
            
            case BANG_EQUAL:
                if (left instanceof ClassInstance && right instanceof ClassInstance) {
                    // Compare objects by their hash
                    return !((ClassInstance)left).equals((ClassInstance)right);
                }
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
    
            // LOGICAL OPERATIONS
            case AND:
                return isTruthy(left) && isTruthy(right);
            case OR:
                return isTruthy(left) || isTruthy(right);
    
            // BITWISE OPERATIONS
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
    
            // ====================================================================
            // COMPLEX ASSIGNMENT CASES (Array and Object field assignment)
            // ====================================================================
            case ASSIGN:
                if (expr.left() instanceof Variable)
                {
                    // Already handled above - this case should not be reached
                    throw new RuntimeException("Variable assignment should be handled above");
                }
                else if (expr.left() instanceof ArrayAccess)
                {
                    // Handle array element assignment: arr[index] = value
                    ArrayAccess access = (ArrayAccess)expr.left();
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
            
                        // Get array type for type checking
                        TokenType arrayType = null;
                        if (access.array() instanceof Variable)
                        {
                            Token arrayName = ((Variable)access.array()).name();
                            arrayType = environment.getArrayType(arrayName.lexeme);
                        }
                        
                        // Convert value based on array type
                        Object convertedValue = convertArrayValue(right, arrayType, arr);
                        arr[index - 1] = convertedValue;
                        return convertedValue;
                    }
                    throw new RuntimeException("Variable is not an array");
                }
                else if (expr.left() instanceof DotExpr)
                {
                    // Handle object field assignment: obj.field = value
                    DotExpr dotExpr = (DotExpr)expr.left();
                    Object object = evaluate(dotExpr.object());
                    
                    if (object instanceof ClassInstance)
                    {
                        ClassInstance instance = (ClassInstance)object;
                        ClassDefinition classDef = instance.getClassDefinition();
                        String fieldName = dotExpr.name().lexeme;
                        
                        // Check if field exists
                        if (!classDef.hasField(fieldName))
                        {
                            throw new RuntimeException("Undefined field '" + fieldName + "' in class '" + classDef.name + "'");
                        }
                        
                        // Get the expected field type
                        TokenType expectedType = classDef.getFieldType(fieldName);
                        
                        // STRICT TYPE CHECKING FOR OBJECT FIELD
                        Object convertedValue = validateAndConvertObjectFieldType(right, expectedType, fieldName, classDef.name);
                        
                        // Set the field value on the class instance
                        instance.set(dotExpr.name(), convertedValue);
                        return convertedValue;
                    }
                    throw new RuntimeException("Left side of assignment must be a class instance");
                }
            
                            throw new RuntimeException("Invalid assignment target.");
                    }
                    
                    throw new RuntimeException("Unknown operator");
        }
                
// Add this method for object field type validation
    private Object validateAndConvertObjectFieldType(Object value, TokenType expectedType, String fieldName, String className)
    {
        if (value == null && expectedType != TokenType.OBJECT && expectedType != TokenType.ALL)
        {
            throw new RuntimeException("Field '" + fieldName + "' in class '" + className + "' cannot be assigned null");
        }
        
        switch (expectedType)
        {
            case INTEGER:
                if (value instanceof BigDecimal || value instanceof Integer || value instanceof Double)
                {
                    // Auto-convert to integer by truncating decimals
                    return convertToBigDecimal(value).setScale(0, RoundingMode.DOWN);
                }
               throw new RuntimeException("INTEGER field '" + fieldName + "' in class '" + className + "' cannot be assigned " + getTypeName(value) + " value: " + stringify(value));
                
            case FLOAT:
                if (value instanceof BigDecimal || value instanceof Integer || value instanceof Double)
                {
                    // Ensure float representation for numbers without decimals
                    BigDecimal bd = convertToBigDecimal(value);
                    if (bd.scale() <= 0)
                    {
                        return new BigDecimal(bd.toString() + ".0");
                    }
                    return bd;
                }
                throw new RuntimeException("FLOAT field '" + fieldName + "' in class '" + className + 
                                         "' cannot be assigned " + getTypeName(value) + " value: " + stringify(value));
                
            case STRING:
                if (!(value instanceof String))
                {
                    throw new RuntimeException("STRING field '" + fieldName + "' in class '" + className + 
                                             "' cannot be assigned " + getTypeName(value) + " value: " + stringify(value));
                }
                return value;
                
            case BOOLEAN:
                if (value instanceof Boolean)
                {
                    return value;
                }
                else if (value instanceof BigDecimal || value instanceof Integer || value instanceof Double)
                {
                    // C-style boolean conversion: 0 = false, non-zero = true
                    return !convertToBigDecimal(value).equals(BigDecimal.ZERO);
                }
                throw new RuntimeException("BOOLEAN field '" + fieldName + "' in class '" + className + 
                                         "' cannot be assigned " + getTypeName(value) + " value: " + stringify(value));
                
            case LIST:
                if (value instanceof KalpanaList)
                {
                    return value;
                }
                // Allow conversion from array to list
                if (value instanceof Object[])
                {
                    Object[] array = (Object[])value;
                    KalpanaList list = new KalpanaList();
                    for (Object element : array)
                    {
                        list.add(element);
                    }
                    return list;
                }
                throw new RuntimeException("LIST field '" + fieldName + "' in class '" + className + 
                                         "' cannot be assigned " + getTypeName(value) + " value: " + stringify(value));
                
            case OBJECT:
                if (value instanceof ClassInstance || value == null)
                {
                    return value;
                }
                throw new RuntimeException("OBJECT field '" + fieldName + "' in class '" + className + 
                                         "' cannot be assigned " + getTypeName(value) + " value: " + stringify(value));
                
            case ALL:
                return value;
                
            default:
                return value;
        }
    }
    // Helper method to convert value to expected type
    private Object convertToExpectedType(Object value, TokenType expectedType)
    {
        if (value == null) 
        {
            return getDefaultValueForType(expectedType);
        }
        
        switch (expectedType)
        {
            case INTEGER:
                if (value instanceof BigDecimal)
                {
                    return ((BigDecimal)value).setScale(0, RoundingMode.DOWN);
                }
                else if (value instanceof Number)
                {
                    return new BigDecimal(value.toString()).setScale(0, RoundingMode.DOWN);
                }
                else if (value instanceof String)
                {
                    try
                    {
                        return new BigDecimal((String)value).setScale(0, RoundingMode.DOWN);
                    }
                    catch (NumberFormatException e)
                    {
                        throw new RuntimeException("Cannot assign string '" + value + "' to integer variable");
                    }
                }
                else if (value instanceof Boolean)
                {
                    return ((Boolean)value) ? BigDecimal.ONE : BigDecimal.ZERO;
                }
                throw new RuntimeException("Cannot assign " + value.getClass().getSimpleName() + " to integer variable");
                
            case ALL:
                   return value;
            case FLOAT:
                if (value instanceof BigDecimal)
                {
                    return value;
                }
                else if (value instanceof Number)
                {
                    return new BigDecimal(value.toString());
                }
                else if (value instanceof String)
                {
                    try
                    {
                        return new BigDecimal((String)value);
                    }
                    catch (NumberFormatException e)
                    {
                        throw new RuntimeException("Cannot assign string '" + value + "' to float variable");
                    }
                }
                else if (value instanceof Boolean)
                {
                    return ((Boolean)value) ? BigDecimal.ONE : BigDecimal.ZERO;
                }
                throw new RuntimeException("Cannot assign " + value.getClass().getSimpleName() + " to float variable");
                
            case STRING:
                return stringify(value);
                
            case BOOLEAN:
                if (value instanceof Boolean)
                {
                    return value;
                }
                else if (value instanceof BigDecimal)
                {
                    return !((BigDecimal)value).equals(BigDecimal.ZERO);
                }
                else if (value instanceof Number)
                {
                    return ((Number)value).doubleValue() != 0;
                }
                else if (value instanceof String)
                {
                    String str = ((String)value).toLowerCase();
                    if (str.equals("true") || str.equals("সত্য"))
                    {
                        return true;
                    }
                    else if (str.equals("false") || str.equals("মিথ্যা"))
                    {
                        return false;
                    }
                    throw new RuntimeException("Cannot convert string '" + value + "' to boolean");
                }
                throw new RuntimeException("Cannot assign " + value.getClass().getSimpleName() + " to boolean variable");
                
            default:
                return value;
        }
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

        case TO_INT:
            return convertToInt(right);
        case TO_FLOAT:
            return convertToFloat(right);
        case TO_STRING:
            return convertToString(right);
        case TO_BOOLEAN:
                    return convertToBoolean(right);
    
        default:
            throw new RuntimeException("Unknown operator");
        }
    }
    private BigDecimal convertToInt(Object value)
    {
        if (value instanceof BigDecimal)
        {
            return ((BigDecimal)value).setScale(0, RoundingMode.DOWN);
        }
        if (value instanceof String)
        {
            try
            {
                String s = ((String)value).trim();
                if (s.contains("."))
                {
                    return new BigDecimal(s).setScale(0, RoundingMode.DOWN);
                }
                return new BigDecimal(s);
            } catch (NumberFormatException e)
            {
                throw new RuntimeException("Cannot convert string '" + value + "' to integer");
            }
        }
        if (value instanceof Boolean)
        {
            return (Boolean)value ? BigDecimal.ONE : BigDecimal.ZERO;
        }
        throw new RuntimeException("Cannot convert value to integer");
    }

    private BigDecimal convertToFloat(Object value)
    {

        if (value instanceof BigDecimal)
        {
            return (BigDecimal)value;
        }
        if (value instanceof String)
        {
            try
            {
                String s = ((String)value).trim();
                // If string doesn't contain decimal point, add .0 to force float conversion
                if (!s.contains(".") && !s.contains("e") && !s.contains("E"))
                {
                    s = s.concat(".0");
                }
                return new BigDecimal(s);
            } catch (NumberFormatException e)
            {
                throw new RuntimeException("Cannot convert string '" + value + "' to float");
            }
        }
        if (value instanceof Boolean)
        {
            return (Boolean)value ? BigDecimal.ONE : BigDecimal.ZERO;
        }
        throw new RuntimeException("Cannot convert value to float");
    }

    private Boolean convertToBoolean(Object value)
    {
        if (value instanceof BigDecimal)
        {
            return (Boolean)(value.equals( BigDecimal.ZERO) || value.equals( new BigDecimal("0.0")));
        }
        if (value instanceof String)
        {
           String s = ((String)value).trim();
            if(s.equalsIgnoreCase("true") || s.equalsIgnoreCase("সত্য") || s.equalsIgnoreCase("সত্যি"))
             {
                 return true;}
            if(s.equalsIgnoreCase("false") || s.equalsIgnoreCase("মিথ্যা") || s.equalsIgnoreCase("মিথ্যাে"))
            {
                return false;}
        }
        if (value instanceof Boolean)
        {
             return (Boolean)value;
        }
        throw new RuntimeException("Cannot convert value to boolean.");
    }
    private String convertToString(Object value)
    {
        if (value == null) return "null";
        if (value instanceof BigDecimal)
        {
            BigDecimal bd = (BigDecimal)value;
            // Remove .0 for integer values
            if (bd.scale() <= 0 || bd.stripTrailingZeros().scale() <= 0)
            {
                return bd.toBigInteger().toString();
            }
            return bd.stripTrailingZeros().toPlainString();
        }
        return value.toString();
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
            
            // CHECK FOR FIXED-SIZE ARRAY BOUNDS
            if (expr.array() instanceof Variable)
            {
                Token arrayName = ((Variable)expr.array()).name();
                boolean isUnlimited = environment.isArrayUnlimited(arrayName.lexeme);
                
                // For fixed-size arrays, enforce bounds strictly
                if (!isUnlimited && (index < 1 || index > arr.length))
                {
                    throw new RuntimeException("Array index " + index + " out of bounds for fixed-size array of length " + arr.length);
                }
            }
            
            // Handle unlimited array size - return default value if index exceeds current size
            if (index > arr.length)
            {
                // For class fields, we need to handle this differently
                if (expr.array() instanceof ClassSelfExpr)
                {
                    ClassSelfExpr classSelfExpr = (ClassSelfExpr) expr.array();
                    Token arrayName = classSelfExpr.keyword();
                    
                    // Look for "this" to get the class instance
                    Token thisToken = new Token(TokenType.IDENTIFIER, "this", null, arrayName.line);
                    Object thisObj = environment.get(thisToken);
                    
                    if (thisObj instanceof ClassInstance)
                    {
                        ClassInstance instance = (ClassInstance) thisObj;
                        ClassDefinition classDef = instance.getClassDefinition();
                        
                        // Check if the array field exists
                        if (!classDef.hasField(arrayName.lexeme))
                        {
                            throw new RuntimeException("In class scope, no field found named '" + arrayName.lexeme + "'");
                        }
                        
                        TokenType arrayType = classDef.getFieldType(arrayName.lexeme);
                        
                        // Return appropriate default value
                        switch (arrayType)
                        {
                            case INTEGER_ARRAY:
                            case FLOAT_ARRAY:
                                return BigDecimal.ZERO;
                            case STRING_ARRAY:
                                return "";
                            case BOOLEAN_ARRAY:
                                return null;
                            default:
                                return null;
                        }
                    }
                }
                throw new RuntimeException("Array index out of bounds");
            }
            
            if (index < 1)
            {
                throw new RuntimeException("Array index must be positive (minimum 1)");
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

    else if (array instanceof KalpanaList)
    {
        KalpanaList list = (KalpanaList)array;
        return list.get(index); // KalpanaList already uses 1-based indexing
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
        
        // Handle MultiDimAccess assignment (comma syntax)
        if (expr.array() instanceof MultiDimAccess)
        {
            MultiDimAccess multiAccess = (MultiDimAccess)expr.array();
            return handleMultiDimAssignment(multiAccess, value);
        }
        // Handle ListAccess assignment (¥ syntax)
        else if (expr.array() instanceof ListAccess)
        {
            ListAccess listAccess = (ListAccess)expr.array();
            Object listObj = evaluate(listAccess.list());
            Object indexObjOfList = evaluate(listAccess.index());
            
            if (!(indexObjOfList instanceof BigDecimal))
            {
                throw new RuntimeException("List index must be an integer");
            }
            
            int indexOfList = ((BigDecimal)indexObjOfList).intValue();
            
            if (listObj instanceof KalpanaList)
            {
                KalpanaList list = (KalpanaList)listObj;
                list.set(indexOfList, value);
                return value;
            }
            else
            {
                throw new RuntimeException("Left side of assignment must be a list");
            }
        }
        // Handle KalpanaList assignment
        else if (array instanceof KalpanaList)
        {
            KalpanaList list = (KalpanaList)array;
            
            // This will now auto-grow the list if needed
            list.set(index, value);
            return value;
        }
        // Handle regular array assignment
        else if (array instanceof Object[])
        {
            Object[] arr = (Object[])array;
            
            // CHECK FOR FIXED-SIZE ARRAY BOUNDS
            boolean isUnlimited = false;
            if (expr.array() instanceof Variable)
            {
                Token arrayName = ((Variable)expr.array()).name();
                isUnlimited = environment.isArrayUnlimited(arrayName.lexeme);
                
                // For fixed-size arrays, enforce bounds strictly
                if (!isUnlimited && (index < 1 || index > arr.length))
                {
                    throw new RuntimeException("Array index " + index + " out of bounds for fixed-size array of length " + arr.length);
                }
            }
            else if (expr.array() instanceof ClassSelfExpr)
            {
                // Class arrays are always fixed-size (defined in class definition)
                if (index < 1 || index > arr.length)
                {
                    throw new RuntimeException("Array index " + index + " out of bounds for class array of length " + arr.length);
                }
            }
            
            // Handle unlimited array size - resize if needed (only for unlimited arrays)
            if (index > arr.length && isUnlimited && !(expr.array() instanceof ClassSelfExpr))
            {
                // Calculate new size (double current size or index, whichever is larger)
                int newSize = Math.max(arr.length * 2, index);
                
                // Resize the array
                Object[] newArr = (Object[])java.lang.reflect.Array.newInstance(
                                    arr.getClass().getComponentType(), newSize);
                
                // Copy old elements
                System.arraycopy(arr, 0, newArr, 0, arr.length);
                
                // Initialize new elements with default values
                Object defaultValue = getDefaultValue(arr.getClass().getComponentType());
                for (int i = arr.length; i < newSize; i++)
                {
                    newArr[i] = defaultValue;
                }
                
                // Update the array in environment (only for unlimited arrays)
                if (expr.array() instanceof Variable)
                {
                    Token arrayName = ((Variable)expr.array()).name();
                    Environment env = environment;
                    while (env != null)
                    {
                        if (env.arrays.containsKey(arrayName.lexeme))
                        {
                            env.arrays.put(arrayName.lexeme, newArr);
                            break;
                        }
                        env = env.enclosing;
                    }
                }
                
                arr = newArr;
            }
            else if (index > arr.length && !isUnlimited)
            {
                // Fixed-size array - don't allow resizing
                throw new RuntimeException("Array index " + index + " out of bounds for fixed-size array of length " + arr.length);
            }
            
            // Check bounds (minimum index is still 1)
            if (index < 1)
            {
                throw new RuntimeException("Array index must be positive (minimum 1)");
            }
            
            // Get array type
            TokenType arrayType = null;
            if (expr.array() instanceof Variable)
            {
                Token arrayName = ((Variable)expr.array()).name();
                arrayType = environment.getArrayType(arrayName.lexeme);
            }
            else if (expr.array() instanceof ClassSelfExpr)
            {
                ClassSelfExpr classSelfExpr = (ClassSelfExpr) expr.array();
                Token arrayName = classSelfExpr.keyword();
                
                // Look for "this" to get the class instance and its definition
                Token thisToken = new Token(TokenType.IDENTIFIER, "this", null, arrayName.line);
                Object thisObj = environment.get(thisToken);
                
                if (thisObj instanceof ClassInstance)
                {
                    ClassInstance instance = (ClassInstance) thisObj;
                    arrayType = instance.getClassDefinition().getFieldType(arrayName.lexeme);
                }
            }
            
            // Convert value based on array type
            Object convertedValue = convertArrayValue(value, arrayType, arr);
            
            // Store the converted value
            arr[index - 1] = convertedValue;
            
            return convertedValue;
        }
        else
        {
            throw new RuntimeException("Variable is not an array or list");
        }
    }
    
    // Helper method for multi-dimensional assignment
    private Object handleMultiDimAssignment(MultiDimAccess multiAccess, Object value)
    {
        // Navigate to the second-to-last container
        Object current = evaluate(multiAccess.array());
        List<Expr> indices = multiAccess.indices();
        
        for (int i = 0; i < indices.size() - 1; i++)
        {
            Object indexObj = evaluate(indices.get(i));
            if (!(indexObj instanceof BigDecimal))
            {
                throw new RuntimeException("Array index must be an integer");
            }
            int index = ((BigDecimal)indexObj).intValue();
            current = accessElement(current, index);
        }
        
        // Set the final element
        Object lastIndexObj = evaluate(indices.get(indices.size() - 1));
        if (!(lastIndexObj instanceof BigDecimal))
        {
            throw new RuntimeException("Array index must be an integer");
        }
        int lastIndex = ((BigDecimal)lastIndexObj).intValue();
        
        if (current instanceof KalpanaList)
        {
            KalpanaList list = (KalpanaList)current;
            list.set(lastIndex, value);
        }
        else if (current instanceof Object[])
        {
            Object[] array = (Object[])current;
            if (lastIndex < 1 || lastIndex > array.length)
            {
                throw new RuntimeException("Array index out of bounds: " + lastIndex);
            }
            array[lastIndex - 1] = value;
        }
        else
        {
            throw new RuntimeException("Cannot assign to element of: " + current.getClass().getSimpleName());
        }
        
        return value;
    }
    
    // Helper method for element access
    private Object accessElement(Object container, int index)
    {
        if (container instanceof KalpanaList)
        {
            KalpanaList list = (KalpanaList)container;
            return list.get(index);
        }
        else if (container instanceof Object[])
        {
            Object[] array = (Object[])container;
            if (index < 1 || index > array.length)
            {
                throw new RuntimeException("Array index out of bounds: " + index);
            }
            return array[index - 1];
        }
        else if (container instanceof String)
        {
            String str = (String)container;
            if (index < 1 || index > str.length())
            {
                throw new RuntimeException("String index out of bounds: " + index);
            }
            return String.valueOf(str.charAt(index - 1));
        }
        else
        {
            throw new RuntimeException("Cannot access element of: " + 
                (container == null ? "null" : container.getClass().getSimpleName()));
        }
    }
    // Helper method to convert array values based on type
    private Object convertArrayValue(Object value, TokenType arrayType, Object[] arr)
    {
        Object convertedValue = value;
        
        if (arr instanceof BigDecimal[])
        {
            // Handle numeric arrays (both integer and float)
            if (value instanceof BigDecimal)
            {
                convertedValue = value;
            } 
            else if (value instanceof Integer)
            {
                convertedValue = new BigDecimal((Integer)value);
            } 
            else if (value instanceof Double)
            {
                convertedValue = BigDecimal.valueOf((Double)value);
            } 
            else
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
            // Handle boolean array assignment with automatic conversion
            if (value instanceof BigDecimal)
            {
                BigDecimal bd = (BigDecimal)value;
                convertedValue = !bd.equals(BigDecimal.ZERO);
            } 
            else if (value instanceof Boolean)
            {
                convertedValue = value;
            }
            else
            {
                throw new RuntimeException("Boolean array can only contain numbers or booleans");
            }
        }
        else
        {
            throw new RuntimeException("Unknown array type");
        }
        
        return convertedValue;
    }

    protected Object evaluate(Expr expr)
    {
        return expr.accept(this);
    }

    protected String stringify(Object object)
    {
        if (object == null) return "null";
        if (object instanceof KalpanaList)
        {
            return object.toString();
        }
        if (object instanceof BigDecimal)
        {
            BigDecimal bd = (BigDecimal)object;
            
            // ALWAYS use toPlainString() to avoid scientific notation
            String plainString = bd.toPlainString();
            
            // Check if this is a float variable
            boolean isFloat = bd.scale() > 0 || 
                (object instanceof Variable && object instanceof Variable && ((Variable)object).name().type == TokenType.FLOAT);
    
            if (isFloat)
            {
                // For floats, always show decimal part
                String str = bd.stripTrailingZeros().toPlainString();
                if (!str.contains("."))
                {
                    str += ".0";
                }
                return str;
            } else
            {
                // For integers, remove decimal part using toPlainString()
                return bd.toBigInteger().toString();
            }
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
class KalpanaList implements Comparable<KalpanaList>
{
    private Vector<Object> elements;
    
    public KalpanaList()
    {
        this.elements = new Vector<>();
    }
    
    public KalpanaList(List<Object> initialElements)
    {
        this.elements = new Vector<>(initialElements);
    }
    
    protected Vector<Object> getElements()
    {
        return this.elements;
    }
    
    protected void setElements(Vector<Object> elements)
    {
        this.elements = elements;
    }
    // Basic operations
    public void add(Object element)
    {
        elements.add(element);
    }
    
    public void add(int index, Object element)
    {
        validateIndexForInsert(index);
        elements.add(index - 1, element); // Convert to 0-based
    }
    
    public Object get(int index)
    {
        validateIndex(index);
        
        // Auto-grow list if index is beyond current size
        if (index > elements.size())
        {
            // Fill with null values up to the requested index
            for (int i = elements.size(); i < index; i++)
            {
                elements.add(null);
            }
        }
        
        return elements.get(index - 1); // Convert to 0-based
    }
    
    public void set(int index, Object element)
    {
        validateIndex(index);
        
        // Auto-grow list if index is beyond current size
        if (index > elements.size())
        {
            // Fill with null values up to the requested index
            for (int i = elements.size(); i < index - 1; i++)
            {
                elements.add(null);
            }
            elements.add(element); // Add the new element at the end
        }
        else
        {
            elements.set(index - 1, element); // Convert to 0-based
        }
    }
    
    public Object remove(int index)
    {
        validateIndex(index);
        return elements.remove(index - 1); // Convert to 0-based
    }
    
    public boolean remove(Object element)
    {
        return elements.remove(element);
    }
    
    public void clear()
    {
        elements.clear();
    }
    
    public int size()
    {
        return elements.size();
    }
    
    public boolean contains(Object element)
    {
        return elements.contains(element);
    }
    
    public int indexOf(Object element)
    {
        int index = elements.indexOf(element);
        return index >= 0 ? index + 1 : -1; // Convert to 1-based
    }
    
    // Utility methods
    public KalpanaList slice(int start, int end)
    {
        validateSliceRange(start, end);
        return new KalpanaList(elements.subList(start - 1, end)); // Convert to 0-based
    }
    
    public void extend(KalpanaList other)
    {
        elements.addAll(other.elements);
    }
    
    public void encreaseSize(int additionalSize, Object defaultValue) 
    {
        if (additionalSize < 0)throw new RuntimeException("Cannot increase list size by negative number: " + additionalSize);
        
        int currentSize = elements.size();
        int targetSize = currentSize + additionalSize;
        for (int i = currentSize; i < targetSize; i++)
        {
            elements.add(defaultValue);
        }
    }
    
    public void encreaseSize(int additionalSize) 
    {
        encreaseSize(additionalSize, null);
    }
    public void reverse()
    {
        Collections.reverse(elements);
    }
    
    public void sort()
    {
        try
        {
            elements.sort(this::compareElements);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Cannot sort list with incompatible types");
        }
    }
    
    public KalpanaList copy()
    {
        return new KalpanaList(new Vector<>(elements));
    }
    
    public boolean isEmpty()
    {
        return elements.isEmpty();
    }
    
    public Object[] toArray()
    {
        return elements.toArray();
    }
    
    // Validation methods
    private void validateIndex(int index)
    {
        if (index < 1)
        {
            throw new RuntimeException("List index must be positive (minimum 1)");
        }
        // No upper bound check - lists grow automatically
    }
    
    private void validateIndexForInsert(int index)
    {
        if (index < 1 || index > elements.size() + 1)
        {
            throw new RuntimeException("List insert index out of bounds: " + index + " (size: " + elements.size() + ")");
        }
    }
    private void validateSliceRange(int start, int end)
    {
        if (start < 1 || end > elements.size() + 1 || start > end)
        {
            throw new RuntimeException("Invalid slice range: " + start + " to " + end + " (size: " + elements.size() + ")");
        }
    }

    public Vector<Object> elements()
    {
        return this.elements;
    }
    
    // Comparison for sorting
    private int compareElements(Object a, Object b)
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
        else if (a instanceof KalpanaList && b instanceof KalpanaList)
        {
            return ((KalpanaList)a).compareTo((KalpanaList)b);
        }
        else
        {
            // Compare by string representation as fallback
            return a.toString().compareTo(b.toString());
        }
    }
    
    public KalpanaStream স্ট্রিমে(Interpreter interpreter)
    {
        return new KalpanaStream(this, interpreter);
    }
    @Override
    public int compareTo(KalpanaList other)
    {
        // Compare lists lexicographically
        int minSize = Math.min(this.elements.size(), other.elements.size());
        for (int i = 0; i < minSize; i++)
        {
            int comparison = compareElements(this.elements.get(i), other.elements.get(i));
            if (comparison != 0) return comparison;
        }
        return Integer.compare(this.elements.size(), other.elements.size());
    }
    
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < elements.size(); i++)
        {
            if (i > 0) sb.append(", ");
            Object element = elements.get(i);
            if (element instanceof String)
            {
                sb.append("\"").append(element).append("\"");
            }
            else
            {
                sb.append(element);
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (!(obj instanceof KalpanaList)) return false;
        KalpanaList other = (KalpanaList)obj;
        return elements.equals(other.elements);
    }
    
    @Override
    public int hashCode()
    {
        return elements.hashCode();
    }
}
class KalpanaSet extends KalpanaList {
    
    public KalpanaSet() {
        super();
    }
    
    public KalpanaSet(List<Object> initialElements) {
        super();
        if (initialElements != null) {
            for (Object element : initialElements) {
                add(element); // Using my overridden add method to prevent duplicates
            }
        }
    }
    
    @Override
    public void add(Object element) {
        if (!contains(element)) {
            super.add(element);
        }
    }
    
    @Override
    public void add(int index, Object element) {
        if (!contains(element)) {
            super.add(index, element);
        }
    }
    
    @Override
    public void set(int index, Object element) {
        // Check if element already exists at different position
        int existingIndex = indexOf(element);
        if (existingIndex == -1 || existingIndex == index) {
            super.set(index, element);
        } else {
            throw new RuntimeException("Cannot set duplicate element in set: " + element);
        }
    }
    
    @Override
    public void extend(KalpanaList other) {
        for (int i = 0; i < other.size(); i++) {
            Object element = other.get(i + 1);
            if (!contains(element)) {
                super.add(element);
            }
        }
    }
    
    // Override methods that could create duplicates
    @Override
    public KalpanaList slice(int start, int end) {
        // Return regular list for slice operations
        return super.slice(start, end);
    }
    
    @Override
    public KalpanaList copy() {
        // Return a new KalpanaSet for copy
        Vector<Object> elementsCopy = new Vector<>(this.getElements());
        return new KalpanaSet(elementsCopy);
    }

    @Override
    public void reverse()
    {
        super.reverse();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        Vector<Object> elements = this.getElements();
        for (int i = 0; i < elements.size(); i++) {
            if (i > 0) sb.append(", ");
            Object element = elements.get(i);
            if (element instanceof String) {
                sb.append("\"").append(element).append("\"");
            } else {
                sb.append(element);
            }
        }
        sb.append("#");
        return sb.toString();
    }
    
    // Set-specific operations
    public KalpanaSet union(KalpanaSet other) {
        KalpanaSet result = new KalpanaSet();
        result.extend(this);
        result.extend(other);
        return result;
    }
    
    public KalpanaSet intersection(KalpanaSet other) {
        KalpanaSet result = new KalpanaSet();
        for (int i = 0; i < this.size(); i++) {
            Object element = this.get(i + 1);
            if (other.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
    
    public KalpanaSet difference(KalpanaSet other) {
        KalpanaSet result = new KalpanaSet();
        for (int i = 0; i < this.size(); i++) {
            Object element = this.get(i + 1);
            if (!other.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
    
    public Boolean isSubset(KalpanaSet other) {
        for (int i = 0; i < other.size(); i++) {
            Object element = other.get(i + 1);
            if (!this.contains(element)) {
                return false;
            }
        }
        return true;
    }

    public Boolean isSuperset(KalpanaSet other) {
        return other.isSubset(this);
    }
    
    public Boolean isDisjoint(KalpanaSet other) {
        return this.intersection(other).isEmpty();
    }
    
    public KalpanaSet symmetricDifference(KalpanaSet other) {
        KalpanaSet union = this.union(other);
        KalpanaSet intersection = this.intersection(other);
        return union.difference(intersection);
    }
    
    // Stream support
    public KalpanaStream স্ট্রিমে(Interpreter interpreter) {
        return new KalpanaStream(this, interpreter);
    }
}
public class Main
{
    // ANSI escape codes for foreground colors
    public static String RESET = new String("\u001b[0m"), RED = new String("\u001b[31m"), GREEN = new String("\u001b[32m"),  BLUE = new String("\u001b[34m"), YELLOW = new String("\u001b[33m"), CLEAR_SCREEN =  new String("\033[2J"), currentVersion = new String(), BUILD_DATE = new String(), OS_NAME = new String();
    public static List<String> commandLineArgs = new Vector<>();
    static
    {
        System.setProperty("file.encoding", "UTF-8");
        Locale.setDefault(Locale.US);
        currentVersion = new String("1.5");
        BUILD_DATE = new String(__COMPILE_TIMESTAMP__);
        OS_NAME = new String(System.getProperty("os.name"));
        try
        {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
            System.setErr(new PrintStream(System.err, true, "UTF-8"));
       } catch (Exception e)
       {
            System.err.println(RED + "Warning: Could not set UTF-8 encoding for console" +RESET);
       }
    }
    private enum TimeUnit
    {
        AUTO, S, MS, NS, JSON
    }
    public static void main(String[] args)
    {
        String filename = "";
        boolean fileExecuted = false;
        Instant start = null;
        Runtime runtime = Runtime.getRuntime();
        long memBefore = 0;
        boolean showTime = false;
        boolean showMem = false;
        TimeUnit timeUnit = TimeUnit.AUTO;
        try
        {
            // First pass: Process all interpreter flags
            int i;
            for (i = 0; i < args.length; i++)
            {
                String arg = new String(args[i]);
    
                if (arg.startsWith("-"))
                {
                    switch (arg.toLowerCase())
                    {
                    case "-help":
                        printUsage();
                        System.gc();
                        System.exit(0);
                    case "-clear":
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
                        continue;
    
                    case "-version":
                    case "-v":
                        System.out.println("KalpanaLang version " + currentVersion + "\nCompiled date: " + BUILD_DATE);
                        System.gc();
                        System.exit(0);
    
                    case "-about":
                    case "-a":
                        System.out.println(YELLOW + "        ==========About KalpanaLang==========\nKalpanaLang is a mainly Bangla based interpreted programming language.Syntax is similar to C/C++ & Java.By adding language pack, a user can write program in his own native language.Current version supports Bangla, English,Rush(Cyrillic) & Hindi. KalpanaLang\'s very first version built by Hasin Israk Toaha with his high-school & childhood friends.\nIt was his dream project.Users can learn programming concept by KalpanaLang.\nOk, enjoy KalpanaLang!\n\n•Main contributors are:\n\n- Hasin Israk Toaha.\n- Fabiha Islam (Deeba).\n- Hafsa Akter.\n- Ritu Moni.\n- Akash Mitro (Nill).\n- Sifat Hossen.\n- Sojib Islam (Akash).\n- Lamia Akter.\n- Sarmin Akter.\n- Siam Hossen.\n- Sahanaj Mim.\n- Avijit Dewry.\n\n•Contact to us:\nE-Mail: toaha.banaripara@gmail.com\nGithub: https://www.github.com/toaha63/KalpanaLang/\nPhone: +8801317936503\n\n•Specifications: \n- Interpreter Version: " +currentVersion + "\n- OS Name: " + OS_NAME +"\n- Build date: " +BUILD_DATE + RESET);
                        
                        System.gc();
                        System.exit(0);
    
                    case "-contributors":
                    case "-helper":
                    case "-helpers":
                        System.out.println(YELLOW + "•Main contributors are: \n\n- Hasin Israk Toaha.\n- Fabiha Islam (Deeba).\n- Hafsa Akter.\n- Ritu Moni.\n- Akash Mitro (Nill).\n- Sifat Hossen.\n- Sojib Islam (Akash).\n- Lamia Akter.\n- Sarmin Akter.\n- Siam Hossen.\n- Sahanaj Mim.\n- Avijit Dewry." + RESET);
                        System.gc();
                        System.exit(0);
    
                    case "-time":
                        showTime = true;
                        timeUnit = TimeUnit.AUTO;
                        continue;
    
                    case "-time:s":
                        showTime = true;
                        timeUnit = TimeUnit.S;
                        continue;
    
                    case "-time:ms":
                        showTime = true;
                        timeUnit = TimeUnit.MS;
                        continue;
    
                    case "-time:ns":
                        showTime = true;
                        timeUnit = TimeUnit.NS;
                        continue;
    
                    case "-time:json":
                        showTime = true;
                        timeUnit = TimeUnit.JSON;
                        continue;
    
                    case "-mem":
                        showMem = true;
                        continue;
    
                    default:
                        System.err.println(RED + "Error: Unknown option '" + arg + "'" + RESET);
                        printUsage();
                        System.gc();
                        System.exit(1);
                    }
                }
                else if (arg.endsWith(".kls"))
                {
                    filename = arg;
                    break; // Exit flag processing loop
                }
                else
                {
                    System.err.println(RED + "Error: Flags must come before source file. Found '" + arg + "' before source file" + RESET);
                    printUsage();
                    System.gc();
                    System.exit(1);
                }
            }
    
            // If we found a source file, collect remaining args as script arguments
            if (!filename.isEmpty())
            {
                for (int j = i + 1; j < args.length; j++)
                {
                    commandLineArgs.add(args[j]);
                }
    
                // Execute the file
                start = Instant.now();
                memBefore = runtime.totalMemory() - runtime.freeMemory();
    
                try
                {
                    Path path = Paths.get(filename);
                    if (!Files.exists(path))
                    {
                        throw new RuntimeException(RED+"File not found: " + filename + RESET);
                    }
    
                    String source = Files.readString(path, StandardCharsets.UTF_8);
                    List<String> libraryImports = extractLibraryImports(source);
                    Interpreter interpreter = new Interpreter();

                     // My library consumption model is, load library. Then execute & share environment.
                    // Process libraries first (environment sharing approach)
                    for (String libPath : libraryImports)
                    {
                        processLibraryFile(libPath, interpreter);
                    }
    
                    // Process main file - use the same interpreter (shared environment)
                    String cleanedSource = removeLibraryImports(source);
                    String translatedSource = LanguageTranslator.translateToBangla(cleanedSource);
    
                    // Execution
                    Lexer lexer = new Lexer(translatedSource);
                    List<Token> tokens = lexer.scanTokens();
                    Parser parser = new Parser(tokens);
                    List<Stmt> statements = parser.parse();
                    interpreter.interpret(statements);
    
                    fileExecuted = true;
                }
                catch (Exception e)
                {
                    System.err.println(RED + "Error executing file: " + e.getMessage() + RESET);
                    System.exit(1);
                }
            }
            else if (args.length == 0)
            {
                printUsage();
                System.gc();
                System.exit(1);
            }
    
            // Show performance metrics if requested
            if (fileExecuted)
            {
                Duration elapsed = Duration.between(start, Instant.now());
                long memAfter = runtime.totalMemory() - runtime.freeMemory();
    
                if (showTime)
                {
                    if (timeUnit == TimeUnit.JSON)
                    {
                        System.out.println(formatAsJson(elapsed, memBefore, memAfter));
                    }
                    else
                    {
                        System.out.println("Execution time: " + formatDuration(elapsed, timeUnit));
                    }
                }
    
                if (showMem)
                {
                    System.out.printf("Memory used: %.3f MB\n", (memAfter - memBefore) / (Math.pow(1024.00,2.00)));
                }
            }
        }
        finally
        {
            System.gc();
        }
    }

    private static String formatDuration(Duration duration, TimeUnit unit)
    {
        switch (unit)
        {
        case S:
            return String.format("%.4fs", duration.toNanos() / 1_000_000_000.0);
        case MS:
            return String.format("%.2fms", duration.toNanos() / 1_000_000.0);
        case NS:
            return duration.toNanos() + "ns";
        case AUTO:
        default:
            if (duration.toMillis() < 1) return duration.toNanos() + "ns";
            if (duration.toSeconds() < 1) return String.format("%.2fms", duration.toNanos() / 1_000_000.0);
            return String.format("%.4fs", duration.toNanos() / 1_000_000_000.0);
        }
    }

    private static String formatAsJson(Duration elapsed, long memBefore, long memAfter)
    {
        return String.format("{\"time\": %.6f, \"unit\": \"s\", \"memory_mb\": %.2f}",elapsed.toNanos() / 1_000_000_000.0, (memAfter - memBefore) / Math.pow(1024.0, 2.0));
    }

    private static void printUsage()
    {
        System.out.println(BLUE + "Usage: kalpana [options] <file.kls>" + RESET);
        System.out.println("Options:");
        System.out.println("  -time           Show execution time (auto units).");
        System.out.println("  -time:s         Show time in seconds.");
        System.out.println("  -time:ms        Show time in milliseconds.");
        System.out.println("  -time:ns        Show time in nanoseconds.");
        System.out.println("  -time:json      Show metrics as JSON.");
        System.out.println("  -mem            Show memory usage.");
        System.out.println("  -contributors   Show contributors list.");
        System.out.println("  -helpers        Alias for -contributors.");
        System.out.println("  -help           Open help pad.");
        System.out.println("  -v              Print version number.");
        System.out.println("  -about          About KalpanaLang.");
    }

    // Helper method to extract library imports
    private static List<String> extractLibraryImports(String source)
    {
        List<String> imports = new Vector<>();
        String[] lines = source.split("\\r?\\n");

        for (String line : lines)
        {
            Matcher matcher = Pattern.compile("^\\s*লাইব্রের[ীি]\\s*\"([^\"]+\\.klm)\"\\s*;\\s*$",Pattern.UNICODE_CASE).matcher(line);
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
        }
        catch (Exception e)
        {
            // Fallback to current directory if there's any error
            return Paths.get("").toAbsolutePath();
        }
    }

    // Helper method to remove library imports from source
    private static String removeLibraryImports(String source)
    {
        String[] lines = source.split("\\r?\\n");
        StringBuilder cleaned = new StringBuilder();
        boolean importsEnded = false;

        for (String line : lines)
        {
            if (!importsEnded && Pattern.compile("^\\s*লাইব্রের[ীি]\\s*\"([^\"]+\\.klm)\"\\s*;\\s*$",Pattern.UNICODE_CASE).matcher(line).matches())
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
    
        // Interpret the library using the same interpreter (environment sharing)
        interpreter.interpret(statements);
    }
}

//Package make: jpackage --type app-image -n KalpanaLang  --input "/storage/F717-19EC/InterpreterBackup" --main-jar KalpanaLang.jar --main-class Main  --runtime-image /data/data/com.termux/files/usr/lib/jvm/java-21-openjdk/  --dest ~

//Jar make: jar --create -e Main --file KalpanaLang.jar *.class && jarsigner -keystore kalpanaKeystore.jks -storepass ,aajja000 -keypass ,aajja000 KalpanaLang.jar kalpanaKey

//Run: clear&&mkdir -p temp && cp Main.java temp/ && cd temp &&TIMESTAMP=$(date | awk '{split($4, t, ":");h = $4 + 0; ap = (h >= 12) ? "PM" : "AM"; h12 = (h > 12) ? h - 12 : h;h12 = (h12 == 0) ? 12 : h12;month_num =(index("JanFebMarAprMayJunJulAugSepOctNovDec", $2)+ 2) / 3;printf "%02d.%02d.%s, %02d:%s:%s %s (GMT%s)", $3, month_num, $6, h12, t[2], t[3], ap, $5}') && sed -i "s|__COMPILE_TIMESTAMP__|\"$TIMESTAMP\"|" Main.java && javac -d .. Main.java && cd .. && rm -rf temp     