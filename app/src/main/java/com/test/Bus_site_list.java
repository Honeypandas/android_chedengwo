package com.test;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Bus_site_list extends ListActivity {
    String lineinfo;
    String[] name;
    TextView textView=null;
    String inflater = Context.LAYOUT_INFLATER_SERVICE;
    LayoutInflater layoutInflater;
    private RatingAdapter raAdapter;

    class RatingAdapter extends BaseAdapter
    {
        private Context context;
        //构造函数
        public RatingAdapter(Context context)
        {
            this.context = context;
            layoutInflater = (LayoutInflater) context
                    .getSystemService(inflater);
        }

        //@Override
        public int getCount()
        {
            return name.length;
        }

        // @Override
        public Object getItem(int position)
        {
            return name[position];
        }

        // @Override
        public long getItemId(int position)
        {
            return position;
        }

       /* public void setRating(int position, float rating)
        {
           distance[position] = rating;
            //在adapter的数据发生变化以后通知UI主线程根据新的数据重新画图
            notifyDataSetChanged();
        }*/

        // @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            //对listview布局
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(
                    R.layout.station_list, null);
            //分别得到3个组件

            TextView Name = ((TextView) linearLayout
                    .findViewById(R.id.station_list_tv));

            //3个组件分别得到内容

            Name.setText(name[position]);


            return linearLayout;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_site_list);

        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        name=bundle.getStringArray("bus_station");
        lineinfo=bundle.getString("lineInfo");
        textView= (TextView) findViewById(R.id.Bus_site_list_info);
        textView.setText(lineinfo);
        Log.e("size:",name.length+"");


        List<View> viewList = new ArrayList<View>();

        viewList.add(getLayoutInflater().inflate(R.layout.activity_bus_site_list, null));
        raAdapter = new RatingAdapter(this);
        setListAdapter(raAdapter);




    }


    public void bus_site_list_back(View view) {
        finish();
    }
}
