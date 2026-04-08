package com.example.comercializadoranorte.ui.reportes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.comercializadoranorte.R;
import com.example.comercializadoranorte.data.model.ProductoRanking;
import java.util.List;
import java.util.Locale;

public class ProductosRankingAdapter extends RecyclerView.Adapter<ProductosRankingAdapter.ViewHolder> {

    private List<ProductoRanking> items;

    public ProductosRankingAdapter(List<ProductoRanking> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_producto_ranking, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductoRanking item = items.get(position);

        holder.tvNombre.setText(item.getProducto().getNombre());
        holder.tvCategoria.setText(item.getProducto().getCategoria());

        holder.tvUnidades.setText(String.format(Locale.getDefault(), "%,d", item.getUnidadesVendidas()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre, tvCategoria, tvUnidades;
        ImageView ivProducto;

        public ViewHolder(@NonNull View v) {
            super(v);
            tvNombre = v.findViewById(R.id.tv_nombre_prod);
            tvCategoria = v.findViewById(R.id.tv_categoria);
            tvUnidades = v.findViewById(R.id.tv_unidades);
            ivProducto = v.findViewById(R.id.iv_producto);
        }
    }
}