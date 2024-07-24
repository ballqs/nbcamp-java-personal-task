package calculator;

import calculator.exception.CalculatorException;
import java.util.ArrayList;

// 2-7 외부에서 접근 불가라는 뜻을 클래스 전체에 적용하는건가? 싶어서 public -> default로 변경
class Calculator {
    private ArrayList<Integer> result;

    // 2-7. 변하지 않아야하는 상수값이어야하고 final를! 3.14라서 double형을 사용합니다.
    final double PI = 3.14;
    private ArrayList<Double> result2;

    // 2-6 Calculator 인스턴스를 생성할 때 생성자를 통해 연산 결과를 저장하고 있는 필드 초기화
    Calculator(ArrayList<Integer> result , ArrayList<Double> result2) {
        this.result = result;   // 사칙연산값을 저장하는 곳
        this.result2 = result2; // 원의넓이값을 저장하는 곳
    }

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

    // 2-5 조회 메서드 구현
    public void inquiryResults() {
        for (int i = 0; i < result.size(); i++) {
            System.out.println((i + 1) + "번째 숫자 : " + result.get(i));
        }
    }

    // 2-7 원의 넓이를 구하는 메서드
    public double calculateCircleArea(double radius) {
        return 2 * radius * PI;
    }

    // 사칙연산 저장값 get
    public ArrayList<Integer> getResult() {
        return result;
    }

    // 사칙연산 저장값 set
    public void setResult(ArrayList<Integer> result) {
        this.result = result;
    }

    // 원의넓이 저장값 get
    public ArrayList<Double> getResult2() {
        return result2;
    }

    // 원의넓이 저장값 set
    public void setResult2(ArrayList<Double> result2) {
        this.result2 = result2;
    }
}
