package com.example.comercializadoranorte.ui.reportes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.comercializadoranorte.R;
import com.example.comercializadoranorte.data.model.RankingItem;
import java.util.List;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {

    private List<RankingItem> items;

    public RankingAdapter(List<RankingItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ranking_secundario, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RankingItem item = items.get(position);

        holder.tvPos.setText(String.valueOf(position + 2));
        holder.tvNombre.setText(item.getNombreCliente());
        holder.tvMonto.setText(String.format("$%,.2f", item.getMontoTotal()));
        holder.pb.setProgress(item.getPorcentaje());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvPos, tvNombre, tvMonto;
        ProgressBar pb;

        public ViewHolder(@NonNull View v) {
            super(v);
            tvPos = v.findViewById(R.id.tv_ranking_pos);
            tvNombre = v.findViewById(R.id.tv_nombre_cliente);
            tvMonto = v.findViewById(R.id.tv_monto_cliente);
            pb = v.findViewById(R.id.pb_ranking);
        }
    }
}