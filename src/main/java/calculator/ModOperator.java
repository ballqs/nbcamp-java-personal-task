package calculator;

// 나머지
public class ModOperator<T extends Number> implements OperatorInterface<T> {
    @Override
    public double operate(T num1, T num2) {
        return num1.doubleValue() % num2.doubleValue();
    }
}
