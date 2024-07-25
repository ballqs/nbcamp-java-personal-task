package calculator;

import calculator.exception.CalculatorException;

import java.util.ArrayList;

// 사칙연산
public class ArithmeticCalculator extends Calculator<OperatorInterface , Character>{

    @Override
    public OperatorInterface calculate(Character sign) {
        try {
            switch (sign) {
                case '+' :
                    return new AddOperator();
                case '-' :
                    return new SubtractOperator();
                case '*' :
                    return new MultiplyOperator();
                case '/' :
                    return new DivideOperator();
                case '%' :
                    return new ModOperator();
                default:
                    throw new CalculatorException();
            }
        } catch (ArithmeticException e) { // 나눗셈 연산에 분모(두번째 정수)에 0이 오면 예외처리
            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. ");
        } catch (CalculatorException e) { // 적합한 예외처리가 뭔지 몰라 작성함
            System.out.println(e.getMessage());
        }
        return null;
    }
}
