package controller;

import exception.BookNotFoundException;
import exception.UserNotFoundException;
import model.dto.Book;
import model.dto.Customer;
import service.OrderService;
import view.EndView;

public class OrderController {

    private static OrderController instance = new OrderController();

    private OrderController() {
    }

    public static OrderController getInstance() {
        return instance;
    }

    private OrderService service = OrderService.getInstance();


    /*
    회원 정보 Insert
    논리적으론 Order와 맞지 않지만 가상의 DB 생성을 위한 메서드
    */
    public void customerInsert(Customer customer) {
        service.customerInsert(customer);
    }


    /*
    책 정보 Insert
    논리적으론 Order와 맞지 않지만 가상의 DB 생성을 위한 메서드
    */
    public void bookInsert(Book book) {
        service.bookInsert(book);
    }


    /*
    ID, PW 체크
     */
    public boolean customerCheck(String id, String pw) {
        try {
            service.customerCheck(id, pw);
        } catch (UserNotFoundException e) {
            // e.printStackTrace();
            EndView.failView(e.getMessage());
            return false;
        }
        return true;
    }

    // 1. 모든 책 리스트 보기
    public void showAllBooks() {
        service.showAllBooks();
    }

    // 2. 책 검색
    public void showBook(String bName) {
        try {
            service.showBook(bName);
        } catch (BookNotFoundException e) {
            // e.printStackTrace();
            EndView.failView(e.getMessage());
        }
    }

    // 3. 장바구니 보기
    public void showAllOrders() {
        service.showAllOrders();
    }


    // 4. 장바구니 넣기
    public void orderInsert(String bName) {
        try {
            service.orderInsert(bName);
        } catch (BookNotFoundException e) {
            e.printStackTrace();
            EndView.failView(e.getMessage());
        }
    }


    // 5. 장바구니 빼기
    public void orderDelete(String bName) {
        service.orderDelete(bName);
    }


    // 6. 장바구니 가격 순으로 정렬(오름차순)
    public void orderSort(){
        service.orderSort();
    }


    // 7. 주문하기
    public void buyOrder(){
        service.buyOrder();
    }

}