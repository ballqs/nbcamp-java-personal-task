package calculator;

import calculator.exception.CalculatorException;
import java.util.ArrayList;

// 2-7 외부에서 접근 불가라는 뜻을 클래스 전체에 적용하는건가? 싶어서 public -> default로 변경
class Calculator {
    static final double PI = 3.14;
    private ArrayList<Double> result;

    // 2-8 사칙연산 , 원의넓이를 같은 곳에서 사용하기 위함
    Calculator(ArrayList<Double> result) {
        this.result = result;   // 사칙연산값을 저장하는 곳
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

    // 2-8.저장값 get
    public ArrayList<Double> getResult() {
        return result;
    }

    // 2-8.저장값 set
    public void setResult(ArrayList<Double> result) {
        this.result = result;
    }
}
