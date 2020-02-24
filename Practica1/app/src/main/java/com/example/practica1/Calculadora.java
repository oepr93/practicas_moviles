package com.example.practica1;
import java.util.Stack;

public class Calculadora {
    public static double calculator(String[] strArr) {
        Stack<Double> operands = new Stack<Double>();
        double value = 0;
        for(String str : strArr) {
            if (str.trim().equals("")) {
                continue;
            }

            switch (str) {
                case "+":
                case "-":
                case "*":
                case "^":
                case "%":
                case "/":
                    double elemento_derecha = operands.pop();
                    double elemento_izq = operands.pop();
                    switch(str) {
                        case "+":
                            value = elemento_izq + elemento_derecha;
                            break;
                        case "-":
                            value = elemento_izq - elemento_derecha;
                            break;
                        case "*":
                            value = elemento_izq * elemento_derecha;
                            break;
                        case "/":
                            value = elemento_izq / elemento_derecha;
                            break;
                        case "\\":
                            value = Math.round(elemento_izq/elemento_derecha);
                            break;
                        case "^":
                            value = Math.pow(elemento_izq, elemento_derecha);
                            break;
                        case "%":
                            value = elemento_izq % elemento_derecha;
                        default:
                            break;
                    }
                    operands.push(value);
                    break;
                case "$":
                case "#":
                case "!":
                case "?":
                case "&":
                case "@":
                    double elemento = operands.pop();
                    double b = Math.toRadians(elemento);
                    switch (str){
                        case "&":
                            value = Math.sin(b);
                            break;
                        case "#":
                            value = Math.cos(b);
                            break;
                        case "$":
                            value = Math.tan(b);
                            break;
                        case "?":
                            value = Math.sinh(b);
                            break;
                        case "!":
                            value = Math.cosh(b);
                            break;
                        case "@":
                            value = Math.tanh(b);
                            break;
                            default:
                                break;
                    }
                    operands.push(value);
                    break;
                default:
                    operands.push(Double.parseDouble(str));
                    break;
            }
        }
        return operands.pop();
    }
}
