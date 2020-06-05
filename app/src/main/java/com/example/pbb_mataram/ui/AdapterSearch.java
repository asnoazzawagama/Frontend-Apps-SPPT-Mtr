package com.example.pbb_mataram.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pbb_mataram.R;

import java.util.List;

public class AdapterSearch extends RecyclerView.Adapter<AdapterSearch.ViewHolder> {
    LayoutInflater inflater;
    private List<SearchItem> searchList;
    public AdapterSearch(List<SearchItem> searchList) {
        this.searchList = searchList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_search,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.wp_nama.setText("NAMA  :"+searchList.get(position).getWpNama());
        holder.tahun.setText("Tahun :"+searchList.get(position).getSpptTahunPajak());
//        Picasso.get().load(songs.get(position).getCoverImage()).into(holder.songCoverImage);
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        TextView tahun,wp_nama;
//        ImageView songCoverImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tahun = itemView.findViewById(R.id.tahun);
            wp_nama = itemView.findViewById(R.id.wp_nama);
//            songCoverImage = itemView.findViewById(R.id.coverImage);

            // handle onClick

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Do Something With this Click", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}

