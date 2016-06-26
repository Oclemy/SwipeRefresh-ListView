package com.tutorials.hp.swiperefreshlistviewexample;

import android.content.Context;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Oclemmy on 3/30/2016 for ProgrammingWizards Channel.
 */
public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Movie> movies;
    SwipeRefreshLayout swipe;

    LayoutInflater inflater;

    public CustomAdapter(Context c, ArrayList<Movie> movies,SwipeRefreshLayout swipe) {
        this.c = c;
        this.movies = movies;
        this.swipe=swipe;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(inflater==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.model,parent,false);
        }

        MyViewHolder holder=new MyViewHolder(convertView);
        holder.nameTxt.setText(movies.get(position).getName());
        holder.img.setImageResource(movies.get(position).getImage());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick() {
                Toast.makeText(c, movies.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh();
            }
        });

        return convertView;
    }

    private void refresh()
    {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                movies.add(0,movies.get(new Random().nextInt(movies.size())));

                CustomAdapter.this.notifyDataSetChanged();

                swipe.setRefreshing(false);

            }
        },3000);
    }


}











