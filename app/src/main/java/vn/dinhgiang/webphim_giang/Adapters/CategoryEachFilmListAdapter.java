package vn.dinhgiang.webphim_giang.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.dinhgiang.webphim_giang.Domain.GenresItem;
import vn.dinhgiang.webphim_giang.R;

public class CategoryEachFilmListAdapter extends RecyclerView.Adapter<CategoryEachFilmListAdapter.ViewHolder> {
    List<String> items;
    Context context;

    public CategoryEachFilmListAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CategoryEachFilmListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context=parent.getContext();
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category,parent,false);
        return new ViewHolder(inflate);

    }

    @Override
    public void onBindViewHolder(@NonNull CategoryEachFilmListAdapter.ViewHolder holder, int position) {
        holder.titleTxt.setText(items.get(position));

        holder.itemView.setOnClickListener(v -> {


        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titleTxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt=itemView.findViewById(R.id.TitleTxt);

        }
    }
}
