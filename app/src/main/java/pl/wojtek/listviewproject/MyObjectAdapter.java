package pl.wojtek.listviewproject;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
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


        View view=convertView;
        ViewHolder viewHolder;
        if(convertView==null){
            LayoutInflater layoutInflater=context.getLayoutInflater();
            view= layoutInflater.inflate(R.layout.item_row,null);
            viewHolder=new ViewHolder();
            viewHolder.textView=(TextView)view.findViewById(R.id.nameTextView);
            viewHolder.checkBox=(CheckBox)view.findViewById(R.id.selectCheckBox);
            viewHolder.imageView=(ImageView)view.findViewById(R.id.imageView);
            view.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }

        final MyCustomListObject myCustomObject=this.list.get(position);

        TextView textView=viewHolder.textView;
        textView.setText(this.list.get(position).getName());
        ImageView iv= viewHolder.imageView;
        iv.setImageDrawable(context.getResources().getDrawable(R.drawable.mordka));

        CheckBox checkBox= viewHolder.checkBox;
       /* checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });*/
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkbox=(CheckBox)v.findViewById(R.id.selectCheckBox);
                myCustomObject .setChecked(checkbox.isChecked());
            }
        });
        checkBox.setChecked(myCustomObject.isChecked());
        return view;
    }

    class ViewHolder{
        TextView textView;
        ImageView imageView;
        CheckBox checkBox;
    }
}
