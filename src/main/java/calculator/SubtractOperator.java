package calculator;

// 빼기
public class SubtractOperator implements OperatorInterface {
    @Override
    public double operate(double num1, double num2) {
        return num1 - num2;
    }
}
