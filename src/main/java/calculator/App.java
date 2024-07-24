package calculator;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> result = new ArrayList<>();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int num1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int num2 = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char sign = sc.next().charAt(0);

            switch (sign) {
                case '+' :
                    result.add(num1 + num2);
                    break;
                case '-' :
                    result.add(num1 - num2);
                    break;
                case '*' :
                    result.add(num1 * num2);
                    break;
                case '/' :
                    if (num2 == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다. ");
                    }else {
                        result.add(num1 / num2);
                    }
                    break;
                case '%' :
                    result.add(num1 % num2);
                    break;
            }

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
                result.remove(0);
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            System.out.print(" >> ");
            String confirm = sc.nextLine();
            if (confirm.equals("exit")) {
                break;
            }
        }
    }
}
