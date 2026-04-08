package com.example.comercializadoranorte.ui.reportes;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.comercializadoranorte.R;
import com.google.android.material.card.MaterialCardView;

public class ReportesFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reportes, container, false);

        MaterialCardView cardRanking = view.findViewById(R.id.card_ranking);
        cardRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RankingClientesActivity.class);
                startActivity(intent);
            }
        });

        MaterialCardView cardProductos = view.findViewById(R.id.card_productos);
        cardProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TopProductosActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
