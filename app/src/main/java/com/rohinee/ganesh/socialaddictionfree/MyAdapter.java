package com.rohinee.ganesh.socialaddictionfree;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<ApplicationList> list;
    private  PackageManager packageManager;

    public MyAdapter(Context context, List<ApplicationList> list) {
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder listViewHolder;

        if(convertView==null){
            listViewHolder = new ViewHolder();
            convertView=layoutInflater.inflate(R.layout.listitem,parent,false);
            listViewHolder.textInListView=(TextView)convertView.findViewById(R.id.textView1);
            listViewHolder.imageInListView=(ImageView)convertView.findViewById(R.id.imageView1);
            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.textInListView.setText(list.get(position).getName());
        listViewHolder.imageInListView.setImageDrawable(list.get(position).getIcon());
        convertView.setOnClickListener(onClickListener(position));
        return convertView;
    }

    private View.OnClickListener onClickListener(final int position) {
        return  new View.OnClickListener(){

            @Override
            public void onClick(View v) {
             //   ApplicationList  app=list.get(position);
                try{


                    packageManager=v.getContext().getPackageManager();
                    Log.i("pk",""+v.getContext().getPackageManager().toString());
                    Intent it= packageManager.getLaunchIntentForPackage(list.get(position).getName());
                    Log.i("pk2",""+packageManager.getLaunchIntentForPackage(list.get(position).getName()).toString());
                    v.getContext().startActivity(it);
                    if(null!=it){
                        v.getContext().startActivity(it);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        };
    }

    static class ViewHolder{

        TextView textInListView;
        ImageView imageInListView;
    }
}
