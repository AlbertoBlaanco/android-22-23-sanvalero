package com.example.glovoandroid.hst_compras.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Pedido;
import com.example.glovoandroid.entities.Plato;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.ver_ficha.view.VerFichaActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HstComprasAdapter extends RecyclerView.Adapter<HstComprasAdapter.ViewHolder> {
    private ArrayList<Pedido> dataset;
    private Context mContext;

    public HstComprasAdapter(Context mContext, ArrayList<Pedido> lstPedidos){
        this.dataset = lstPedidos;
        this.mContext = mContext;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_nuevo_historico,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Pedido r = dataset.get(position);
        holder.fecha.setText(r.getFecha());
        holder.precio_total.setText(r.getPrecio_total() + "€");
        holder.idPedido.setText(String.valueOf(r.getId_pedido()));
        Picasso.get().load(R.drawable.shopping_bag).into(holder.imagen);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView fecha,precio_total,idPedido;
        private ImageView imagen;

        public ViewHolder(View itemView) {
            super(itemView);
            idPedido = itemView.findViewById(R.id.idPedido);
            fecha = itemView.findViewById(R.id.FECHA);
            precio_total = itemView.findViewById(R.id.PRECIO_TOTAL);
            imagen = itemView.findViewById(R.id.IMAGEN);

        }
    }
}
