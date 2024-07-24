package calculator;

// 곱하기
public class MultiplyOperator implements OperatorInterface {
    @Override
    public double operate(double num1, double num2) {
        return num1 * num2;
    }
}
