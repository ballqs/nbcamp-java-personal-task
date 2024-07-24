package calculator.exception;

public class CalculatorException extends Exception{
    public CalculatorException() {
        super("입력하신 기호는 사칙연산이 없는 기호입니다.");
    }
}
