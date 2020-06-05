package com.example.pbb_mataram.ui;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pbb_mataram.BayarActivity;
import com.example.pbb_mataram.PenyampaianSPPTActivity;
import com.example.pbb_mataram.R;
import com.example.pbb_mataram.SendPenyampaianActivity;

import java.util.List;

public class AdapterPenyampaian extends RecyclerView.Adapter<AdapterPenyampaian.ViewHolder> {
    LayoutInflater inflater;
    private List<SearchItem> searchList;
    public AdapterPenyampaian(List<SearchItem> searchList) {
        this.searchList = searchList;
    }
    @NonNull
    @Override
    public AdapterPenyampaian.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_penyampaian,parent,false);
        return new AdapterPenyampaian.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPenyampaian.ViewHolder holder, final int position) {
        holder.wp_nama.setText(searchList.get(position).getWpNama());
        holder.tahun.setText(searchList.get(position).getSpptTahunPajak());
        holder.tagihan.setText(searchList.get(position).getSpptPbbHarusDibayar());
        holder.alamat.setText(searchList.get(position).getWpAlamat());
        holder.nop.setText(searchList.get(position).getNop());

        holder.penyampaian_sppt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent i=new Intent(context,SendPenyampaianActivity.class);
//                final String thn = tahun.getText().toString();

                //ADD DATA TO OUR INTENT
//                i.putExtra("tahun",searchList.get(position).getSpptTahunPajak());
                i.putExtra("nop",searchList.get(position).getNop());
                i.putExtra("nama",searchList.get(position).getWpNama());
                i.putExtra("tahun",searchList.get(position).getSpptTahunPajak());
                i.putExtra("alamat",searchList.get(position).getWpAlamat());
                //START DETAIL ACTIVITY
                context.startActivity(i);

//                Toast.makeText(context,"DATAAAA",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder{
        TextView nop,tahun,wp_nama,alamat,tagihan;
        Button penyampaian_sppt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nop = itemView.findViewById(R.id.nop);
            tahun = itemView.findViewById(R.id.tahun);
            wp_nama = itemView.findViewById(R.id.wp_nama);
            tagihan = itemView.findViewById(R.id.tagihan);
            alamat = itemView.findViewById(R.id.alamat);
            penyampaian_sppt = itemView.findViewById(R.id.btn_status);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Do Something With this Click", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
