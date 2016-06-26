package com.tutorials.hp.swiperefreshlistviewexample;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Oclemmy on 3/30/2016 for ProgrammingWizards Channel.
 */
public class MyViewHolder implements View.OnClickListener {

    ImageView img;
    TextView nameTxt;
    ItemClickListener itemClickListener;

    public MyViewHolder(View v) {
        img= (ImageView) v.findViewById(R.id.movieImage);
        nameTxt= (TextView) v.findViewById(R.id.nameTxt);

        v.setOnClickListener(this);

    }

    public  void setItemClickListener(ItemClickListener ic)
    {
        this.itemClickListener=ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick();
    }
}
