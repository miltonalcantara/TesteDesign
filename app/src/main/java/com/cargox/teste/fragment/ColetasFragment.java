package com.cargox.teste.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cargox.teste.MainActivity;
import com.cargox.teste.R;
import com.cargox.teste.adapter.ColetasAdapter;
import com.cargox.teste.model.Coletas;
import com.cargox.teste.model.ColetasMockadas;

import java.util.List;

/**
 * Criado por Milton Alcântara em 05/05/2018.
 */
public class ColetasFragment extends Fragment {

    private int auxCount;
    private int auxTotal;
    private int auxVisible;

    int aux;
    boolean notificou = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_coletas, container, false);

        final RecyclerView mRecyclerView = view.findViewById(R.id.rv_list);
        mRecyclerView.setHasFixedSize(true); //dizendo que o tamanho do RecyclerView não vai mudar, otimizando mais ainda.

        final LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        ColetasAdapter adapter;

        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(llm);

        ColetasMockadas eventos = new ColetasMockadas(); //Pegando lista de clientes
        final List<Coletas> mList = eventos.getColetas();

        adapter = new ColetasAdapter(getActivity(), mList);
        mRecyclerView.setAdapter(adapter);

        RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView rv, int dx, int dy) {
                auxCount = mRecyclerView.getChildCount();
                auxTotal = llm.getItemCount();
                auxVisible = llm.findFirstVisibleItemPosition();

                aux = mList.get(auxVisible).getStatusEntrega();

                if (aux == 0 && !notificou) {
                    ((MainActivity) getActivity()).mTitle.setText(R.string.menu_coletas);
                    notificou = true;
                } else if (aux == 2 && notificou) {
                    ((MainActivity) getActivity()).mTitle.setText(R.string.em_rota);
                    notificou = false;
                }
            }
        };
        mRecyclerView.addOnScrollListener(mScrollListener);

        return view;
    }

    @Override
    public void onResume() {
        ((MainActivity) getActivity()).fab.setVisibility(View.VISIBLE);
        super.onResume();
    }
}
