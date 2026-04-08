package com.example.comercializadoranorte.ui.reportes;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.comercializadoranorte.R;
import com.example.comercializadoranorte.data.model.Cliente;
import com.example.comercializadoranorte.data.model.RankingItem;
import java.util.ArrayList;
import java.util.List;

public class RankingClientesActivity extends AppCompatActivity {
    private TextView tvNombreTop1, tvMontoTop1;
    private ProgressBar pbTop1;
    private RecyclerView rvRanking;
    private RankingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_clientes);

        tvNombreTop1 = findViewById(R.id.tv_nombre_top_1);
        tvMontoTop1 = findViewById(R.id.tv_monto_top_1);
        pbTop1 = findViewById(R.id.pb_top_1);
        rvRanking = findViewById(R.id.rv_ranking_clientes);
        ImageButton btnBack = findViewById(R.id.btn_back);

        rvRanking.setLayoutManager(new LinearLayoutManager(this));
        rvRanking.setNestedScrollingEnabled(false);

        btnBack.setOnClickListener(v -> onBackPressed());

        List<RankingItem> datosRanking = generarDatosPrueba();

        if (!datosRanking.isEmpty()) {
            RankingItem top1 = datosRanking.get(0);
            tvNombreTop1.setText(top1.getNombreCliente());
            tvMontoTop1.setText(String.format("$%,.2f", top1.getMontoTotal()));
            pbTop1.setProgress(top1.getPorcentaje());

            if (datosRanking.size() > 1) {
                List<RankingItem> listaSecundaria = datosRanking.subList(1, datosRanking.size());
                adapter = new RankingAdapter(listaSecundaria);
                rvRanking.setAdapter(adapter);
            }
        }
    }

    private List<RankingItem> generarDatosPrueba() {
        List<RankingItem> lista = new ArrayList<>();
        lista.add(new RankingItem(new Cliente("1", "Construcciones del Norte S.A.", "", "", "", "", "", true), 250500.00, 100));
        lista.add(new RankingItem(new Cliente("2", "Ferretería Central", "", "", "", "", "", true), 180200.50, 72));
        lista.add(new RankingItem(new Cliente("3", "Ingeniería Aplicada", "", "", "", "", "", true), 120000.00, 48));
        lista.add(new RankingItem(new Cliente("4", "Metales Industriales", "", "", "", "", "", true), 95400.00, 38));
        lista.add(new RankingItem(new Cliente("5", "Suministros Monterrey", "", "", "", "", "", true), 45000.00, 18));

        return lista;
    }
}