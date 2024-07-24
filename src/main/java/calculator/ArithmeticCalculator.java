package calculator;

import calculator.exception.CalculatorException;

import java.util.ArrayList;

// 사칙연산
public class ArithmeticCalculator extends Calculator{
    ArithmeticCalculator(ArrayList<Double> result) {
        super(result);
    }

    // 사칙연산 계산
    public double calculate(double num1 , double num2 , char sign) {
        double result = 0;
        try {
            switch (sign) {
                case '+' :
                    result = addOperator.operate(num1 , num2);
                    break;
                case '-' :
                    result = subtractOperator.operate(num1 , num2);
                    break;
                case '*' :
                    result = multiplyOperator.operate(num1 , num2);
                    break;
                case '/' :
                    result = divideOperator.operate(num1 , num2);
                    break;
                case '%' :
                    result = remainOperator.operate(num1 , num2);
                    break;
                default:
                    throw new CalculatorException();
            }
        } catch (ArithmeticException e) { // 나눗셈 연산에 분모(두번째 정수)에 0이 오면 예외처리
            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. ");
        } catch (CalculatorException e) { // 적합한 예외처리가 뭔지 몰라 작성함
            System.out.println(e.getMessage());
        }
        return result;
    }
}
