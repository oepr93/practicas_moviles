package com.example.practica1;
import java.util.Stack;


public class Convertir {
    static int Prec(char ch) {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
            case '\\':
                return 2;

            case '^':
            case '%':
                return 3;
            case '$':
            case '#':
            case '!':
            case '?':
            case '&':
            case '@':
                return 4;
        }
        return -1;
    }

    static String infixToPostfix(String exp) {
        // initializing empty String for result
        String result = new String("");
        char anterior = 'z';

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i){
            char c = exp.charAt(i);

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c)){
                if (anterior == 'z') {
                    result += c;
                }
                else if(anterior == '.')
                    result += c;
                else{
                    if(Character.isLetterOrDigit(anterior)){
                        result += c;
                    }
                    else{
                        result += " "+c;
                    }
                }
            }
            else if(c == '.'){
                result += c;
            }
            // If the scanned character is an '(', push it to the stack.
            else if (c == '(')
                stack.push(c);
                //  If the scanned character is an ')', pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')'){
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += " "+stack.pop();

                if (!stack.isEmpty() && stack.peek() != '(')
                    return "Syntax error"; // invalid expression
                else
                    stack.pop();
            }
            else{
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
                    if(stack.peek() == '(')
                        return "Syntax error";
                    result += " "+stack.pop();
                }
                stack.push(c);
            }
            anterior = c;
        }
        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return "Syntax error";
            result += " "+stack.pop();
        }
        return result;
    }
    /*
        String exp = "(10.5+5)*3";
		String postfija = infixToPostfix(exp);
		System.out.println("Postfija: "+ postfija);
		PostfixEvaluation calc = new PostfixEvaluation();
		String[] strArr = postfija.split(" ");
		System.out.println("Calculo: "+ calc.calculator(strArr));
     */
}
