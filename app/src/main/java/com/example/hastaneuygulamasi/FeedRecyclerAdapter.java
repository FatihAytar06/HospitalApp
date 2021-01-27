package com.example.hastaneuygulamasi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FeedRecyclerAdapter extends RecyclerView.Adapter<FeedRecyclerAdapter.RowHolder> {

    List<String> doctorNameList;
    Context context;
    Activity activity;

    public FeedRecyclerAdapter(List<String> doctorNameList, Context context, Activity activity) {
        this.doctorNameList = doctorNameList;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FeedRecyclerAdapter.RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeedRecyclerAdapter.RowHolder holder, int position) {

        holder.doctorName.setText(doctorNameList.get(position).toString());
        holder.userAnaLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Intent intent=new Intent(activity, ChatActivity.class);
                intent.putExtra("username",userName);
                intent.putExtra("othername",list.get(position).toString());
                activity.startActivity(intent);

                 */
            }
        });
    }
    @Override
    public int getItemCount() {
        return doctorNameList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder{
        TextView doctorName;
        LinearLayout userAnaLayout;
        public RowHolder(View itemView) {
            super(itemView);
            doctorName=itemView.findViewById(R.id.doctorNameTextView);
            userAnaLayout=itemView.findViewById(R.id.ana_layout);
        }
    }
}