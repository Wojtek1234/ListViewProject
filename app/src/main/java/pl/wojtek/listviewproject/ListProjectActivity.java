package pl.wojtek.listviewproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ListProjectActivity extends Activity {
    private ArrayAdapter<MyCustomListObject> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_project);
        initListView();
    }

    private void initListView() {
        ListView listView=(ListView)findViewById(R.id.listView);
        this.adapter=new MyObjectAdapter(this,R.layout.item_row, MyCustomListObject.generateList());
        listView.setAdapter( this.adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    MyCustomListObject object=(MyCustomListObject)parent.getAdapter().getItem(position);
                    Toast.makeText(ListProjectActivity.this,"Clicked"+object.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }


}
