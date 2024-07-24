package calculator;

// 나누기
public class DivideOperator implements OperatorInterface {
    @Override
    public double operate(double num1, double num2) {
        return num1 / num2;
    }
}
