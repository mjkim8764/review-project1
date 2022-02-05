package model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderList {

    // 주문번호
    private String listNo;

    // 주문한 책
    private Book book;

    @Override
    public String toString(){
        return " ";
    }
}