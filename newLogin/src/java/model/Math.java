/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 *
 * @author Admin
 */
public class Math implements Serializable {

    private String num1 = "", num2 = "", op = "";

    public Math() {
    }

    public String getNum1() {
        return num1;
    }

    public void setNum1(String num1) {
        this.num1 = num1;
    }

    public String getNum2() {
        return num2;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getResult() {
        String result = "";
        double a, b;
        try {
            a = Double.parseDouble(num1);
            b = Double.parseDouble(num2);
            switch(op){
                case "+":
                    result+= "Tong: "+(a+b);
                    break;
                case "-":
                    result+= "Hieu: "+(a-b);
                    break;
                case "*":
                    result+= "Tich: "+(a*b);
                    break;
                case "/":
                    if(b==0){
                        result+="Kong duoc chia cho 0";
                    }else{
                        result+="Thuong: "+(a/b);
                    }
                    break;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}
