package calculator;

// 더하기
public class AddOperator<T extends Number> implements OperatorInterface<T> {
    @Override
    public double operate(T num1, T num2) {
        // 3-2. 기존 방식은 num1 + num2 였는데 [Operator '+' cannot be applied to 'T', 'T'] 라는 에러때매 진행이 안됩니다.
        // 알아본 결과 <T extends Number> 으로 Number Type으로 제한 걸어놓고 숫자 Data Type중 가장 높은 Double로 해두었습니다.
        return num1.doubleValue() + num2.doubleValue();
    }


//    3-2. 진행 도중 여기저기 알아보았는데 아래와 같은 방법이 있었습니다.
//         이는 보기가 어렵다고 판단되었고 3-3 진행하는데 장벽이 될것같았습니다.
//         위 코드도 어렵긴하지만 밑에 코드는 불가능에 가까워보여서 이런 방법도 있구나 해서 주석처리해둡니다.
//    @Override
//    public T operate(T num1, T num2) {
//        if (num1 instanceof Integer && num2 instanceof Integer) {
//            return (T) Integer.valueOf(num1.intValue() + num2.intValue());
//        } else if (num1 instanceof Double && num2 instanceof Double) {
//            return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue());
//        } else if (num1 instanceof Float && num2 instanceof Float) {
//            return (T) Float.valueOf(num1.floatValue() + num2.floatValue());
//        } else if (num1 instanceof Long && num2 instanceof Long) {
//            return (T) Long.valueOf(num1.longValue() + num2.longValue());
//        } else {
//            throw new UnsupportedOperationException("Operation not supported for this type");
//        }
//    }
}
