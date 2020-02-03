package com.example.newmyproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.ViewHolder> {
private Context mCtx;
private List<Area> areaList;
    public AreaAdapter(Context mCtx,List<Area> areaList)
    {
        this.mCtx= mCtx;
        this.areaList = areaList;

    }

    @NonNull
    @Override
    public AreaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.area_list,parent,false);

        return new AreaAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AreaAdapter.ViewHolder holder, final int position) {

        Glide.with(mCtx).load(areaList.get(position).getImage()).into(holder.imageView);
        holder.name.setText(areaList.get(position).getName());
//        holder.info.setText(areaList.get(position).getInfo());
        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mCtx,RegencyDetailPage.class);
                intent.putExtra("name",areaList.get(position).getName());
                intent.putExtra("info",areaList.get(position).getInfo());
                intent.putExtra("image",areaList.get(position).getImage());
                mCtx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return areaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView info;
        public ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.textViewName);
//            info=(TextView)itemView.findViewById(R.id.textViewInfo);
            imageView=(ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
