package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculator calculator = new Calculator();

        ArrayList<Integer> result = calculator.getResult();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char sign = sc.next().charAt(0);

            // 이거 2-1에 추가하는줄 알고 넣었는데 2-2로 커밋하기 위해 다시 구조 바꾸겠습니다.
            int calc = calculator.calculate(num1 , num2 , sign);
            result.add(calc);

            System.out.println("결과: " + result.get(result.size() - 1));

            /**
             * 사용자가 콘솔창에 값을 입력 후 enter를 누르는데 이때 개행문자는 제거하지 않은 채 그대로 남겨두기에
             * 남겨진 개행문자가 다음 sc.nextLine() 입력으로 처리되어 곧바로 다음 라인으로 넘어가기에 추가함
             * */
            sc.nextLine();

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            System.out.print(" >> ");
            String remove_confirm = sc.nextLine();
            if (remove_confirm.equals("remove")) {
                // 여기서 삭제한 값이 위에 선언된 result에 적용되는 이유는
                // 같은 인스턴스 주소인 calculator에서 받아왔기 때문이다.
                calculator.removeResult();
            }

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            System.out.print(" >> ");
            String select_confirm = sc.nextLine();
            if (select_confirm.equals("inquiry")) {
                for (int i = 0; i < result.size(); i++) {
                    System.out.println((i + 1) + "번째 숫자 : " + result.get(i));
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            System.out.print(" >> ");
            String confirm = sc.nextLine();
            if (confirm.equals("exit")) {
                calculator.setResult(result);
                break;
            }
        }
    }
}
