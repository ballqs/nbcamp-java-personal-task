package calculator;

import java.util.ArrayList;

// 원의 넓이
public class CircleCalculator extends Calculator<Double , Double>{

    // 원의넓이 계산
    @Override
    Double calculate(Double radius) {
        return 2 * radius * Calculator.PI;
    }
}
