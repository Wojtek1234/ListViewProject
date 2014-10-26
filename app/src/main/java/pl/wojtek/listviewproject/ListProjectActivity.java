package pl.wojtek.listviewproject;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;


public class ListProjectActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_project);
        initListView();
    }

    private void initListView() {
        ListView listView=(ListView)findViewById(R.id.listView);

        listView.setAdapter(new MyObjectAdapter(this,R.layout.item_row, MyCustomListObject.generateList()));
    }


}
