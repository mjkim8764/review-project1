package model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Customer {

    // 고객 넘버
    private String cNumber;

    // 고객 아이디
    private String cId;

    // 고객 패스워드
    private String cPw;

    //고객 이름
    private String cName;

    // 고객 잔금
    private int cMoney;

    @Override
    public String toString(){
        return " ";
    }

}