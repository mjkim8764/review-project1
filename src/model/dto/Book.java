package model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Book {

    // 책 ID
    private String bId;

    // 책 이름
    private String bName;

    // 책 분야
    private String bType;

    // 책 가격
    private int bPrice;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("책 번호 : ")
                .append(bId)
                .append(", 책 이름 : ")
                .append(bName)
                .append(", 책 분야 : ")
                .append(bType)
                .append(", 책 가격 : ")
                .append(bPrice);
        return builder.toString();
    }
}