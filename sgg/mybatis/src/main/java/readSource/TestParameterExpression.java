package readSource;

public class TestParameterExpression {
    public static void main(String[] args) {
        expression("ab(a(cds)d)",3);
    }

    public static void expression(String expression, int left) {
        int match = 1;
        int right = left + 1;
        while (match > 0) {
            if (expression.charAt(right) == ')') {
                match--;
            } else if (expression.charAt(right) == '(') {
                match++;
            }
            right++;
        }
        System.out.println(expression.substring(left, right - 1));
    }
}
