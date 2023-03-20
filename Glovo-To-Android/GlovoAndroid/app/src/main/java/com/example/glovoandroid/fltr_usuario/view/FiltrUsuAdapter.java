package com.example.glovoandroid.fltr_usuario.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.glovoandroid.R;
import com.example.glovoandroid.entities.Restaurante;
import com.example.glovoandroid.ver_ficha.view.VerFichaActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FiltrUsuAdapter extends RecyclerView.Adapter<FiltrUsuAdapter.ViewHolder> {
    private ArrayList<Restaurante> dataset;
    private Context mContext;

    public FiltrUsuAdapter(Context mContext, ArrayList<Restaurante> lstRestaurantes){
        this.dataset = lstRestaurantes;
        this.mContext = mContext;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_restaurant_filtr,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Restaurante r = dataset.get(position);

        //holder.idRestaurante.setText(String.valueOf(r.getID_RESTAURANTE()));
        holder.nombreRestaurante.setText(r.getNOMBRE());
        holder.tipoRestaurante.setText(r.getTIPO());
        holder.ventasRestaurante.setText(String.valueOf(r.getVENTAS()));
        holder.puntuacionRestaurante.setText(String.valueOf(r.getPUNTUACION()));
        Picasso.get().load(r.getIMAGEN()).into(holder.imagenRestaurante);
        holder.bt1n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent miIntent= new Intent(view.getContext() , VerFichaActivity.class);
                miIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                miIntent.putExtra("nombreRestaurante",holder.nombreRestaurante.getText());
                view.getContext().startActivity(miIntent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView idRestaurante;
        private TextView nombreRestaurante;
        private TextView tipoRestaurante;
        private TextView ventasRestaurante;
        private TextView puntuacionRestaurante;
        private ImageView imagenRestaurante;

        private Button bt1n;



        public ViewHolder(View itemView) {
            super(itemView);


            //idRestaurante = itemView.findViewById(R.id.ID_RESTAURANTE);
            nombreRestaurante = itemView.findViewById(R.id.NOMBRE2);
            tipoRestaurante = itemView.findViewById(R.id.TIPO2);
            ventasRestaurante = itemView.findViewById(R.id.VENTAS2);
            puntuacionRestaurante = itemView.findViewById(R.id.PUNTUACION2);
            bt1n=(Button) itemView.findViewById(R.id.btnProbar);
            imagenRestaurante = (ImageView) itemView.findViewById(R.id.IMAGEN);
        }
    }
    public void adicionarListaRestaurante(ArrayList<Restaurante> lstRestaurant) {
        //dataset.addAll(lstRestaurant);
        //notifyDataSetChanged();
    }

}
