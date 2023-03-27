package test;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    List<String> stringList = new ArrayList<String>();

    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        listTest.setStringList();
    }
    public void setStringList() {
        stringList.add( "111" );
        stringList.add( "222" );
        stringList.add( "333" );
        stringList.add( "444" );
        for (String list: stringList){
            System.out.println(list);
        }
    }
}
