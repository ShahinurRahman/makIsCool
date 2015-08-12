package com.iscool.admin.test;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 3/22/15
 * Time: 12:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyArray {
    public static void main(String[] args) {
        String[] arr = {"Good", "Bad", "Excellent"};
        int[] myarr = {4, 5, 66, 876};


        String abc = "Good,Bad,Excellent";
        String[] abcArr = abc.split(",");

        System.out.println( abcArr[0]);
        System.out.println( arr[2]);
        System.out.println( myarr[3]);

        //a(2.5);
    }


    static void a(){
       //a(34);
    }
    void a(int i){

    }
    void a(double d){
        a(34);
        a();
    }

}
