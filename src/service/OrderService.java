package service;

import exception.UserNotFoundException;
import model.dto.Book;
import model.dto.Customer;
import model.dto.OrderList;
import view.EndView;

import java.util.ArrayList;

public class OrderService {

    private static OrderService instance = new OrderService();

    private OrderService() {
    }

    public static OrderService getInstance() {
        return instance;
    }

    public ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<OrderList> orderLists = new ArrayList<>();

    /*
    회원 정보 Insert
    논리적으론 로그인과 맞지 않지만 가상의 DB 생성을 위한 메서드
    */
    public void customerInsert(Customer customer) {
        customers.add(customer);
    }


    /*
    ID, PW 체크
    */
    public void customerCheck(String id, String pw) throws UserNotFoundException {
        for (Customer customer : customers) {
            if(customer.getCId().equals(id) && customer.getCPw().equals(pw)) {
                return;
            }
        }
        throw new UserNotFoundException("잘못된 아이디 또는 패스워드입니다.");
    }


    /*
    책 정보 Insert
    논리적으론 로그인과 맞지 않지만 가상의 DB 생성을 위한 메서드
    */
    public void bookInsert(Book book) {
        books.add(book);
    }


    // 1. 모든 책 리스트 보기
    public void showAllBooks(){
        for(Book book : books){
            EndView.bookView(book);
        }
    }


    // 2. 책 검색
    public void showBook(String bName){
    }


    // 3. 장바구니 보기
    public void showAllOrders(){
        EndView.allOrderView(orderLists);
    }


    // 4. 장바구니 넣기
    public void orderInsert(String bName) {
    }


    // 5. 장바구니 빼기
    public void orderDelete(String bName) {
    }

    // 6. 장바구니 가격 순으로 정렬(오름차순)
    public void orderSort(){
    }

    // 7. 주문하기
    public void buyOrder(){
        orderLists.removeAll(orderLists);
    }

}