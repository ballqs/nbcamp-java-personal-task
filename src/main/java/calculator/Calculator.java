package calculator;

import calculator.exception.CalculatorException;
import java.util.ArrayList;

public class Calculator {
    private ArrayList<Integer> result = new ArrayList<>();

    public int calculate(int num1 , int num2 , char sign) {
        int result = 0;
        try {
            switch (sign) {
                case '+' :
                    result = num1 + num2;
                    break;
                case '-' :
                    result = num1 - num2;
                    break;
                case '*' :
                    result = num1 * num2;
                    break;
                case '/' :
                    result = num1 / num2;
                    break;
                case '%' :
                    result = num1 % num2;
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

    // 2-4 삭제 메서드 구현
    public void removeResult() {
        result.remove(0);
    }

    public ArrayList<Integer> getResult() {
        return result;
    }

    public void setResult(ArrayList<Integer> result) {
        this.result = result;
    }
}
