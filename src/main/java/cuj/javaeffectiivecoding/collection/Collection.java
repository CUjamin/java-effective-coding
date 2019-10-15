package cuj.javaeffectiivecoding.collection;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @Author: cujamin
 * @ProjectName: javaeffectivecoding
 * @Date: 2019/10/15 9:46 PM
 * @Description: ${description}
 */
public class Collection {

    public static void main(String[] args) {
        testSubList();
    }

    public static void testSubList(){
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        try{
            List<String> errorList =  (ArrayList)list.subList(0,4);
        }catch (ClassCastException cce){
            cce.printStackTrace();
        }


        List<String> newList =  list.subList(0,4);
        list.remove("4");
        try{
            System.out.println("newList:"+newList);
        }catch (ConcurrentModificationException cme){
            cme.printStackTrace();
        }


        try{
            String[] strs = (String[]) list.toArray();
        }catch (ClassCastException cce){
            cce.printStackTrace();
        }


        String[] strs = new String[]{"1","2"};
        List<String> strList = Arrays.asList(strs);
        try{
            strList.add("3");
        }catch (UnsupportedOperationException uoe){
            uoe.printStackTrace();
        }
        System.out.println("strList:"+strList);
        strs[0]="11111";
        System.out.println("strList:"+strList);


        list = new ArrayList<>();
        Iterator iterator = list.iterator();
        iterator.hasNext();
        list.add("1");
        list.add("2");
        for(String item:list){
            System.out.println(item);
            if("2".equals(item)){
                try {
                    list.remove(item);
                }catch (ConcurrentModificationException cme){
                    cme.printStackTrace();
                }
            }
        }
    }



}
