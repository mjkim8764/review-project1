package view;

import model.dto.Book;
import model.dto.OrderList;

import java.util.ArrayList;

public class EndView {

    // 메뉴 출력
    public static void menuView(){
        System.out.println();
        System.out.println(" 메뉴를 선택해주세요");
        System.out.println(" 1. 모든 책 리스트 보기");
        System.out.println(" 2. 책 검색");
        System.out.println(" 3. 장바구니 보기");
        System.out.println(" 4. 장바구니 넣기");
        System.out.println(" 5. 장바구니 빼기");
        System.out.println(" 6. 장바구니 가격 순으로 정렬(오름차순)");
        System.out.println(" 7. 주문하기");
        System.out.println(" 8. 나가기");
        System.out.print("> ");
    }

    // 책 리스트 출력
    public static void showAllBook(ArrayList<Book> books){
        for(Book book : books) {
            System.out.println(book);
        }
    }


    // 검색한 책 출력
    public static void showBook(Book book){
        System.out.println(book);
    }


    // 장바구니 리스트 출력
    public static void allOrderView(ArrayList<OrderList> orderLists) {

        for(OrderList orderList : orderLists) {
            System.out.println(orderList);
        }

    }


    // 성공 메세지
    public static void successView(String msg){
        System.out.println(msg);
    }


    // 실패 메세지
    public static void failView(String msg){
        System.out.println(msg);
    }

}