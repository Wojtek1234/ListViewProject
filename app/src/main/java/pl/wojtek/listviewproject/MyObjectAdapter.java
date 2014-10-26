package pl.wojtek.listviewproject;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by user on 2014-10-26.
 */
public class MyObjectAdapter extends ArrayAdapter<MyCustomListObject> {

    private final List<MyCustomListObject> list;
    private Activity context;

    public MyObjectAdapter(Activity context, int resource, List<MyCustomListObject> objects) {
        super(context, resource, objects);
        this.context=context;
        this.list=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=context.getLayoutInflater();
        View view= layoutInflater.inflate(R.layout.item_row,null);

        TextView textView=(TextView)view.findViewById(R.id.nameTextView);
        textView.setText(this.list.get(position).getName());

        return view;
    }
}
