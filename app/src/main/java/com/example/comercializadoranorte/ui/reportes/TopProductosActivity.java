package com.example.comercializadoranorte.ui.reportes;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.comercializadoranorte.R;
import com.example.comercializadoranorte.data.model.ProductoRanking;
import java.util.List;

public class TopProductosActivity extends AppCompatActivity {
    private TextView tvTotalGlobal, tvNombreTop1, tvCategoriaTop1, tvUnidadesTop1;
    private ProgressBar pbTop1;
    private RecyclerView rvProductos;
    private ProductoRankingViewModel viewModel;
    private ProductosRankingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_productos);

        viewModel = new ViewModelProvider(this).get(ProductoRankingViewModel.class);

        initViews();
        setupObservers();

        viewModel.cargarProductos();
    }

    private void initViews() {
        tvTotalGlobal = findViewById(R.id.tv_ventas_totales);
        tvNombreTop1 = findViewById(R.id.tv_nombre_top1);
        tvCategoriaTop1 = findViewById(R.id.tv_categoria_top1);
        tvUnidadesTop1 = findViewById(R.id.tv_unidades_top1);
        pbTop1 = findViewById(R.id.pb_top1);
        rvProductos = findViewById(R.id.rv_top_productos);

        rvProductos.setLayoutManager(new LinearLayoutManager(this));
        rvProductos.setNestedScrollingEnabled(false);
        if (findViewById(R.id.btn_back) != null) {
            findViewById(R.id.btn_back).setOnClickListener(v -> onBackPressed());
        }
    }

    private void setupObservers() {
        viewModel.totalVentasGlobal.observe(this, total -> tvTotalGlobal.setText(total));

        viewModel.productosRanking.observe(this, lista -> {
            if (lista != null && !lista.isEmpty()) {
                ProductoRanking top1 = lista.get(0);
                tvNombreTop1.setText(top1.getProducto().getNombre());
                if (tvCategoriaTop1 != null) {
                    tvCategoriaTop1.setText(top1.getProducto().getCategoria());
                }
                tvUnidadesTop1.setText(String.format("%,d", top1.getUnidadesVendidas()));
                pbTop1.setProgress(top1.getPorcentaje());

                if (lista.size() > 1) {
                    List<ProductoRanking> secundarios = lista.subList(1, lista.size());
                    adapter = new ProductosRankingAdapter(secundarios);
                    rvProductos.setAdapter(adapter);
                }
            }
        });
    }
}