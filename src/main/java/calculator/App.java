package calculator;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App app = new App();
        Scanner sc = new Scanner(System.in);

        // ★★★★★★★메모 => List 를 앞에두고 뒤에 new ArrayList로 선언하는 것
        List<Double> result;

        // 2-7. 숫자로 분기하는게 편해서 숫자로 진행했습니다.
        System.out.println("(1)사칙연산 , (2)원의넓이 중 고르세요!");
        System.out.print(" >> ");
        int bifurcation = sc.nextInt();

        if (bifurcation == 1) {

            // 3-2. 조건문을 통해서 byte short int long float double 타입별로 설정할수 있지만
            //      그러면 줄도 길어지고 보는 사람도 힘들것같고 이를 어떻게 하나로 처리해야할지 감이 안잡혀
            //      대표적으로 double Type으로 남겨두려고 합니다.
            ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>();
            result = arithmeticCalculator.getResult();

            while (true) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double num1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                double num2 = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char sign = sc.next().charAt(0);

                // 다형성 추가
                double calc = arithmeticCalculator.calculate(sign).operate(num1 , num2);
                result.add(calc);

                // 3-2 int로 처리할때는 아래와 같이 작성하면 동작됩니다. 다만 int이기에 소수점은 없습니다.
//                int calc = (int) arithmeticCalculator.calculate(sign).operate(num1 , num2);
//                result.add((double) calc);

                System.out.println("결과: " + result.get(result.size() - 1));

                /**
                 * 사용자가 콘솔창에 값을 입력 후 enter를 누르는데 이때 개행문자는 제거하지 않은 채 그대로 남겨두기에
                 * 남겨진 개행문자가 다음 sc.nextLine() 입력으로 처리되어 곧바로 다음 라인으로 넘어가기에 추가함
                 * */
                sc.nextLine();
                if (app.confirm(sc , "가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)" , "remove")) {
                    // 여기서 삭제한 값이 위에 선언된 result에 적용되는 이유는
                    // 같은 인스턴스 주소인 calculator에서 받아왔기 때문이다.
                    arithmeticCalculator.removeResult();
                }
                if (app.confirm(sc , "저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)" , "inquiry")) {
                    arithmeticCalculator.inquiryResults();
                }
                if (app.confirm(sc , "더 계산하시겠습니까? (exit 입력 시 종료)" , "exit")) {
                    arithmeticCalculator.setResult(result);
                    break;
                }
            }

        } else {
            CircleCalculator circleCalculator = new CircleCalculator();
            result = circleCalculator.getResult();

            while (true) {
                System.out.print("반지름 길이를 입력하세요: ");
                double radius = sc.nextDouble();

                // 원의 넓이 결과값
                result.add(circleCalculator.calculate(radius));
                System.out.println("결과: " + result.get(result.size() - 1));

                sc.nextLine();
                if (app.confirm(sc , "가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)" , "remove")) {
                    circleCalculator.removeResult();
                }
                if (app.confirm(sc , "저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)" , "inquiry")) {
                    circleCalculator.inquiryResults();
                }
                if (app.confirm(sc , "더 계산하시겠습니까? (exit 입력 시 종료)" , "exit")) {
                    circleCalculator.setResult(result);
                    break;
                }
            }
        }
    }

    // 중복 출력값 묶는 작업?
    public boolean confirm(Scanner sc , String str , String compare) {
        System.out.println(str);
        System.out.print(" >> ");
        String confirm = sc.nextLine();
        return confirm.equals(compare);
    }
}
