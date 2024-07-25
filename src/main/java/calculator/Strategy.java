package calculator;

import java.util.ArrayList;

// 전략 패턴 기반 사용해볼까 생각해서 추가 했으나 실패함...
// 공부의 기록으로 남기려고 합니다.
// https://inpa.tistory.com/entry/GOF-%F0%9F%92%A0-%EC%A0%84%EB%9E%B5Strategy-%ED%8C%A8%ED%84%B4-%EC%A0%9C%EB%8C%80%EB%A1%9C-%EB%B0%B0%EC%9B%8C%EB%B3%B4%EC%9E%90
public class Strategy {
    Calculator calculator;

    void setStrategy(Calculator calculator) {
        this.calculator = calculator;
    }

    // 전략 실행 메소드
    void removeResult() {
        this.calculator.removeResult();
    }

    void inquiryResults() {
        this.calculator.inquiryResults();
    }

    void setResult(ArrayList<Double> result) {
        this.calculator.setResult(result);
    }
}
