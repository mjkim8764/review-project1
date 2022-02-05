package view;

import model.dto.Book;
import model.dto.Customer;
import controller.OrderController;

import java.util.Scanner;

public class StartView {

    public static void main(String[] args) {

        // 책의 정보
        // 책 식별번호, 제목, 타입, 가격
        Book book1 = new Book("01", "Do it! 자바 프로그래밍 입문", "IT", 30000);
        Book book2 = new Book("02", "이것이 MySQL이다", "IT", 20000);
        Book book3 = new Book("03", "자바의 정석", "IT", 30000);
        Book book4 = new Book("04", "HTTP 완벽 가이드", "IT", 35000);
        Book book5 = new Book("05", "객체지향 소프트웨어 공학", "IT", 20000);
        Book book6 = new Book("06", "해커스 토익 LISTENING", "ENGLISH", 30000);
        Book book7 = new Book("07", "해커스 토익 READING", "ENGLISH", 25000);

        // 고객의 정보
        // 고객 식별번호, 아이디, 패스워드, 이름, 잔금
        Customer customer1 = new Customer("01", "mjKim", "aaaa", "김민준", 100000);
        Customer customer2 = new Customer("02", "csLee", "bbbb", "이철수", 150000);
        Customer customer3 = new Customer("03", "khPark", "cccc", "박경희", 200000);
        Customer customer4 = new Customer("04", "yhJang", "dddd", "장영희", 130000);
        Customer customer5 = new Customer("05", "ysLee", "eeee", "이영수", 80000);
        Customer customer6 = new Customer("06", "msKim", "ffff", "김민수", 40000);
        Customer customer7 = new Customer("07", "jvKim", "gggg", "김자바", 110000);

        OrderController orderController = OrderController.getInstance();

        // 가상의 고객 DB 생성
        orderController.customerInsert(customer1);
        orderController.customerInsert(customer2);
        orderController.customerInsert(customer3);
        orderController.customerInsert(customer4);
        orderController.customerInsert(customer5);
        orderController.customerInsert(customer6);
        orderController.customerInsert(customer7);

        // 가상의 책 DB 생성
        orderController.bookInsert(book1);
        orderController.bookInsert(book2);
        orderController.bookInsert(book3);
        orderController.bookInsert(book4);
        orderController.bookInsert(book5);
        orderController.bookInsert(book6);
        orderController.bookInsert(book7);


        // 로그인
        System.out.println(" 책 주문 서비스입니다.");

        boolean logincheck = false;
        Scanner scanner = new Scanner(System.in);

        while(!logincheck) {
            System.out.println(" ID와 PW를 입력해주세요");
            System.out.print("ID : ");
            String id = scanner.nextLine();
            System.out.print("PW : ");
            String pw = scanner.nextLine();

            logincheck = orderController.customerCheck(id, pw);
        }


        // 메뉴 안내
        String choice = "-1";
        String bName;
        while(!choice.equals("8")) {
            EndView.menuView();
            choice = scanner.nextLine();

            switch(choice) {
                case "1":        // 1. 모든 책 리스트 보기
                    orderController.showAllBooks();
                    break;
                case "2":        // 2. 책 검색
                    System.out.print("책 이름을 입력해주세요 : ");
                    bName = scanner.nextLine();
                    orderController.showBook(bName);
                    break;
                case "3":        // 3. 장바구니 보기
                    orderController.showAllOrders();
                    break;
                case "4":        // 4. 장바구니 넣기
                    System.out.print("책 이름을 입력해주세요 : ");
                    bName = scanner.nextLine();
                    orderController.orderInsert(bName);
                    break;
                case "5":        // 5. 장바구니 빼기
                    System.out.print("책 이름을 입력해주세요 : ");
                    bName = scanner.nextLine();
                    orderController.orderDelete(bName);
                    break;
                case "6":        // 6. 장바구니 가격 순으로 정렬(오름차순)
                    break;
                case "7":        // 7. 주문하기
                    break;
            }
        }
    }
}
