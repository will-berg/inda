/**
 * The Postfix class implements an evaluator for integer postfix expressions.
 *
 * Postfix notation is a simple way to define and write arithmetic expressions
 * without the need for parentheses or priority rules. For example, the postfix
 * expression "1 2 - 3 4 + *" corresponds to the ordinary infix expression
 * "(1 - 2) * (3 + 4)". The expressions may contain decimal 32-bit integer
 * operands and the four operators +, -, *, and /. Operators and operands must
 * be separated by whitespace.
 *
 * @author  William Berg
 * @version 2020-01-29
 */
public class Postfix {
    public static class ExpressionException extends Exception {
        public ExpressionException(String message) {
            super(message);
        }
    }

    /**
     * Evaluates the given postfix expression.
     *
     * @param expr  Arithmetic expression in postfix notation
     * @return      The value of the evaluated expression
     * @throws      ExpressionException if the expression is wrong
     */
    public static int evaluate(String expr) throws ExpressionException {
        if (expr.equals("")) {
            throw new ExpressionException("Array contains nothing");
        }
        LinkedList<Integer> stack = new LinkedList<>();
        String [] stringChars = expr.trim().split("\\s+");
        for (String stringChar: stringChars) {
            if (isInteger(stringChar)) {
                if (stringChar.matches("^(0|-0)\\d+$")) {
                    throw new ExpressionException("invalid integer");
                }
                stack.push(Integer.parseInt(stringChar));
            } else if (isOperator(stringChar)) {
                if (stack.isEmpty() || stack.size() < 2) {
                    throw new ExpressionException("Stack is empty or there are too few operands");
                } else if (stringChar.equals("+")) {
                    stack.push(stack.pop() + stack.pop());
                } else if (stringChar.equals("*")) {
                    stack.push(stack.pop() * stack.pop());
                } else if (stringChar.equals("-")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                } else if (stringChar.equals("/")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    if (a == 0) {
                        throw new ExpressionException("Math error");
                    }
                    stack.push(b / a);
                }
            } else throw new ExpressionException("illegal characters");
        }
		if (stack.size() > 1) {
			throw new ExpressionException("too many operands");
		}
		return stack.top();
    }

    /**
     * Returns true if s is an operator.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * An operator is one of '+', '-', '*', '/'.
     */
    private static boolean isOperator(String s) {
        return s.matches("[-+/*]");
    }

    /**
     * Returns true if s is an integer.
     *
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     *
     * We accept two types of integers:
     *
     * - the first type consists of an optional '-'
     *   followed by a non-zero digit
     *   followed by zero or more digits,
     *
     * - the second type consists of an optional '-'
     *   followed by a single '0'.
     */
    private static boolean isInteger(String s) {
        return s.matches("-?\\d+");
    }
}