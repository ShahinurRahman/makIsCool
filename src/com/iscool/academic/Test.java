package com.iscool.academic;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: lenovo_pc
 * Date: 3/17/15
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Test {

    public static void main(String[] args) {
        List<Object> list =  new ArrayList<Object>();

        list.add("Hi");

        Date d  = new Date();
        list.add(d);

        Map<String, Object> mmm = new HashMap<String, Object>();
        mmm.put("abc", "This is MMM's fisrt Value of abc");
        mmm.put("mak", "This is MAK");
        list.add(mmm);

        //System.out.println(list.size());

        Map m1 = new HashMap();
        m1.put("Date", new Date());
        m1.put("List", list);
        m1.put("Intt", 23);
        //System.out.print("\t" +(List) m1.get("List").get );

        List<Object> myList = (List) m1.get("List");
        Map<String, Object> myMap = (Map<String, Object>) myList.get(2);
        System.out.println(myMap.get("mak"));
    }


}
