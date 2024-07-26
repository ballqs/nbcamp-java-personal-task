package calculator;

import calculator.exception.CalculatorException;

import java.util.ArrayList;

// 사칙연산
public class ArithmeticCalculator<T extends Number> extends Calculator<OperatorInterface<T> , Character>{
    @Override
    public OperatorInterface<T> calculate(Character sign) {
        try {
            switch (SignReplace(sign).name()) {
                case "PLUS" :
                    return (num1, num2) -> num1.doubleValue() + num2.doubleValue();
                case "MINUS" :
                    return (num1, num2) -> num1.doubleValue() - num2.doubleValue();
                case "MULTI" :
                    return (num1, num2) -> num1.doubleValue() * num2.doubleValue();
                case "DIVIDE" :
                    return (num1, num2) -> {
                        // 3-3. 두번째 숫자가 0으로 들어오면 에러 발생
                        if (num2.doubleValue() == 0) {
                            throw new ArithmeticException();
                        }
                        return num1.doubleValue() / num2.doubleValue();
                    };
                case "MOD" :
                    return (num1, num2) -> {
                        // 3-3. 두번째 숫자가 0으로 들어오면 에러 발생
                        if (num2.doubleValue() == 0) {
                            throw new ArithmeticException();
                        }
                        return num1.doubleValue() % num2.doubleValue();
                    };
                default:
                    throw new CalculatorException();
            }
        } catch (ArithmeticException e) { // 나눗셈 연산에 분모(두번째 숫자)에 0이 오면 예외처리
            // 위에 방식으로 처리하니 여기로 안들어오는 듯하다...
            System.out.println("나눗셈 연산에서 분모(두번째 숫자)에 0이 입력될 수 없습니다.");
        } catch (CalculatorException e) { // 적합한 예외처리가 뭔지 몰라 작성함
            System.out.println(e.getMessage());
        }
        return null;
    }

    // 기존 사칙연산에서 사용중이던 기호를 버리고 문자열로 받을까?
    // 고민하다가 그냥 아래와 같이 처리
    public SignType SignReplace(Character sign) {
        switch (sign) {
            case '+' :
                return SignType.PLUS;
            case '-' :
                return SignType.MINUS;
            case '*' :
                return SignType.MULTI;
            case '/' :
                return SignType.DIVIDE;
            case '%' :
                return SignType.MOD;
        }
        return null;
    }
}
