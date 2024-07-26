package calculator;

// 3-3. 람다식을 어떻게 적용할까 고민하다가 찾은 어노테이션 FunctionalInterface 이다.
//      인터페이스에 하나의 추상메소드만 둘수 있다. 그리고 그 추상메소드를 람다식으로 접근 가능해진다.
@FunctionalInterface
public interface OperatorInterface<T> {
    double operate(T num1 , T num2);
}
