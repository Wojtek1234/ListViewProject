package pl.wojtek.listviewproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2014-10-26.
 */
public class MyCustomListObject {



    private String name;




    public MyCustomListObject(String name) {
        this.name = name;
    }

    public static List<MyCustomListObject> generateList(){
        List<MyCustomListObject> result=new ArrayList<MyCustomListObject>();

        for(int i=0;i<20;i++){
            MyCustomListObject myCustomListObject=new MyCustomListObject("Name" +i);

            result.add(myCustomListObject);
        }
        return result;
    }

    public String getName() {
        return name;
    }
}
