package com.example.pbb_mataram.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pbb_mataram.BayarActivity;
import com.example.pbb_mataram.PembayaranActivity;
import com.example.pbb_mataram.R;

import java.io.Serializable;
import java.util.List;

public class AdapterPembayaran extends RecyclerView.Adapter<AdapterPembayaran.ViewHolder> {
    LayoutInflater inflater;
    String tahun;
    private List<SearchItem> searchList;
    public AdapterPembayaran(List<SearchItem> searchList) {
        this.searchList = searchList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_pembayaran,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.wp_nama.setText(searchList.get(position).getWpNama());
        holder.tahun.setText(searchList.get(position).getSpptTahunPajak());
        holder.nop.setText(searchList.get(position).getNop());

        holder.btn_bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent i=new Intent(context,BayarActivity.class);
//                final String thn = tahun.getText().toString();

                //ADD DATA TO OUR INTENT
                i.putExtra("tahun",searchList.get(position).getSpptTahunPajak());
                i.putExtra("nop",searchList.get(position).getNop());
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
        TextView tahun,wp_nama,tagihan,nop;
        Button btn_bayar;

        private Context context;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            context = itemView.getContext();
//            final Bundle extras = new Bundle();

            tahun = itemView.findViewById(R.id.tahun);

//            extras.putString("tahun", String.valueOf(tahun));

            wp_nama = itemView.findViewById(R.id.wp_nama);
            nop = itemView.findViewById(R.id.nop);
            btn_bayar = itemView.findViewById(R.id.btn_bayar);
//            btn_bayar.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
////                    Intent intent = new Intent();
////                    intent = new Intent(context, BayarActivity.class);
//                    Intent intent = new Intent(context, BayarActivity.class);
//                    intent.putExtra("tahun", thn);
//                    context.startActivity(intent);
//                }
//            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Do Something With this Click", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
