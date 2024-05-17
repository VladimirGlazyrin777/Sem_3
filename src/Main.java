import java.util.Deque;
import java.util.ArrayDeque;

class Calculator {
    private Deque<Double> stack = new ArrayDeque<>();

    public double calculate(char op, double a, double b) {
        double result = 0;

        switch (op) {
            case '+':
                result = a + b;
                stack.push(result);
                break;
            case '-':
                result = a - b;
                stack.push(result);
                break;
            case '*':
                result = a * b;
                stack.push(result);
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                    stack.push(result);
                } else {
                    System.out.println("Error: Division by zero!");
                }
                break;
            case '<':
                if (stack.size() >= 2) {
                    stack.pop(); // Убираем последний результат
                    result = stack.peek(); // Получаем предпоследний результат
                } else {
                    System.out.println("Error: Not enough operations to undo!");
                }
                break;
            default:
                System.out.println("Error: Invalid operator!");
        }

        return result;
    }
}

// Не удаляйте этот класс - он нужен для вывода результатов на экран и проверки
 class Printer {
    public static void main(String[] args) {
        double a, b, c, d;
        char op, op2, undo;

        if (args.length == 0) {
            // При отправке кода на Выполнение, Вы можете варьировать эти параметры
            a = 3.0;
            op = '+';
            b = 7.0;
            c = 4.0;
            op2 = '+';
            d = 7.0;
            undo = '<';
        } else {
            a = Double.parseDouble(args[0]);
            op = args[1].charAt(0);
            b = Double.parseDouble(args[2]);
            c = Double.parseDouble(args[3]);
            op2 = args[4].charAt(0);
            d = Double.parseDouble(args[5]);
            undo = args[6].charAt(0);
        }

        Calculator calculator = new Calculator();
        double result = calculator.calculate(op, a, b);
        System.out.println(result);
        double result2 = calculator.calculate(op2, c, d);
        System.out.println(result2);
        double prevResult = calculator.calculate(undo, 0, 0);
        System.out.println(prevResult);
    }
}