package calculator;

import java.util.ArrayList;

// 원의 넓이
public class CircleCalculator extends Calculator{
    CircleCalculator(ArrayList<Double> result2) {
        super(result2);
    }

    // 원의넓이 계산
    public double calculate(double radius) {
        return 2 * radius * Calculator.PI;
    }
}
