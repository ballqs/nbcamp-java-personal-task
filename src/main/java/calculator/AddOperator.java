package calculator;

// 더하기
public class AddOperator implements OperatorInterface {
    @Override
    public double operate(double num1, double num2) {
        return num1 + num2;
    }
}
