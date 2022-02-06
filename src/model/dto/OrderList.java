package model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderList implements Comparable<OrderList> {

    // 주문번호
    private int listNo;

    // 주문한 책
    private Book book;

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("주문 번호 : ")
                .append(listNo)
                .append("\n");
        return builder.toString() + book.toString();
    }

    @Override
    public int compareTo(OrderList orderList) {
        return this.getBook().getBPrice() - orderList.getBook().getBPrice();
    }
}