package service;

import exception.BookNotFoundException;
import exception.UserNotFoundException;
import model.dto.Book;
import model.dto.Customer;
import model.dto.OrderList;
import view.EndView;

import java.util.ArrayList;
import java.util.Collections;

public class OrderService {

    private static OrderService instance = new OrderService();

    private OrderService() {
    }

    public static OrderService getInstance() {
        return instance;
    }

    private int cIndex = -1;
    private int orderTotalPrice = 0;

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
                cIndex = customers.indexOf(customer);
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
            EndView.showBook(book);
        }
    }


    // 2. 책 검색
    public void showBook(String bName) throws BookNotFoundException{
        for(Book book : books) {
            if(book.getBName().equals(bName)) {
                EndView.showBook(book);
                return;
            }
        }
        throw new BookNotFoundException("제목을 다시 입력해주세요 !");
    }


    // 3. 장바구니 보기
    public void showAllOrders(){
        if(orderLists.size() == 0) {
            EndView.failView("장바구니에 책이 없어요 !");
        }
        else {
            EndView.allOrderView(orderLists);
            orderTotalPrice = 0;
            for(OrderList orderList : orderLists) {
                orderTotalPrice += orderList.getBook().getBPrice();
            }
            EndView.printMoney(customers.get(cIndex).getCMoney(), orderTotalPrice);
        }
    }


    // 4. 장바구니 넣기
    public void orderInsert(String bName) throws BookNotFoundException {

        for(Book book : books) {
            if(book.getBName().equals(bName)) {
                int cnt = orderLists.size();
                orderLists.add(new OrderList(cnt + 1, book));
                EndView.successView("장바구니에 책이 추가되었습니다.");
                return;
            }
        }
        throw new BookNotFoundException("없는 책이에요 !");

    }


    // 5. 장바구니 빼기
    public void orderDelete(String bName) throws BookNotFoundException {

        if(orderLists.size() == 0) {
            EndView.failView("장바구니에 책이 없어요 !");
            return;
        }
        else {
            for(OrderList orderList : orderLists) {
                if(orderList.getBook().getBName().equals(bName)) {
                    int index = orderLists.indexOf(orderList);
                    orderLists.remove(index);
                    EndView.successView(bName + " 이 장바구니에서 삭제됐어요 !");
                    return;
                }
            }
        }

        throw new BookNotFoundException("없는 책이에요 !");
    }


    // 6. 장바구니 가격 순으로 정렬(오름차순)
    public void orderSort(){

        if(orderLists.size() == 0) {
            EndView.failView("장바구니에 책이 없어요 !");
            return;
        }
        else {
            Collections.sort(orderLists);
            EndView.successView("가격 순으로 정렬되었습니다 !");
        }

    }


    // 7. 주문하기
    public void buyOrder(){
        orderLists.removeAll(orderLists);
    }

}