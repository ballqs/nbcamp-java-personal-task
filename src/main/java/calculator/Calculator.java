package calculator;

import java.util.ArrayList;
import java.util.List;

// 2-7 외부에서 접근 불가라는 뜻을 클래스 전체에 적용하는건가? 싶어서 public -> default로 변경
abstract class Calculator<T , U> {
    static final double PI = 3.14;
    private List<Double> result;

    // 2-8 사칙연산 , 원의넓이를 같은 곳에서 사용하기 위함
    Calculator() {
        this.result = new ArrayList<>();   // 사칙연산값을 저장하는 곳
    }

    // 2-4 삭제 메서드 구현
    public void removeResult() {
        this.result = result.stream().skip(1).toList();

//        result.remove(0);
    }

    // 2-5 조회 메서드 구현
    public void inquiryResults() {
        result.forEach(System.out::println);
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println((i + 1) + "번째 숫자 : " + result.get(i));
//        }
    }

    // 2-8.저장값 get
    public List<Double> getResult() {
        return result;
    }

    // 2-8.저장값 set
    public void setResult(List<Double> result) {
        this.result = result;
    }

    abstract T calculate(U u);
}
