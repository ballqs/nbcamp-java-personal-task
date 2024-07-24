package calculator;

// 나머지
public class RemainOperator implements OperatorInterface {
    @Override
    public double operate(double num1, double num2) {
        return num1 % num2;
    }
}
