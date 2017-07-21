package com.woojin0417.retrofit.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.woojin0417.retrofit.R;
import com.woojin0417.retrofit.controller.DetailActivity;
import com.woojin0417.retrofit.model.Item;

import java.util.List;


public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {
    private List<Item> items;
    private Context context;

    public ItemAdapter(Context applicationContext, List<Item> itemArrayList){
        this.context=applicationContext;
        this.items=itemArrayList;
    }

    @Override
    public ItemAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_user,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemAdapter.ViewHolder viewHolder, int i) {
        //Appcase appcase=mAppcases.get(i);
        viewHolder.txtRank.setText(items.get(i).getRank());
        viewHolder.txtNm.setText(items.get(i).getNm());
        Picasso.with(context).load(items.get(i).getUrl()).placeholder(R.drawable.load).into(viewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtRank, txtNm;
        private ImageView imageView;

    public ViewHolder(View view) {
        super(view);
        txtRank = (TextView) view.findViewById(R.id.txtRank);
        txtNm = (TextView) view.findViewById(R.id.txtNm);
        imageView = (ImageView) view.findViewById(R.id.cover);
        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int pos = getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    Item clickedDataItem = items.get(pos);
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra("rank", items.get(pos).getRank());
                    intent.putExtra("Nm", items.get(pos).getNm());
                    intent.putExtra("url", items.get(pos).getUrl());
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                    Toast.makeText(view.getContext(), "선택 " + clickedDataItem.getRank(), Toast.LENGTH_SHORT).show();

                }

                //Log.v("errrrdf",getAppcase(pos)..getNm());
            }

        });
    }
    }

}
