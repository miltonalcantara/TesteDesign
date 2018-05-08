package com.cargox.teste.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cargox.teste.MainActivity;
import com.cargox.teste.R;
import com.cargox.teste.model.Coletas;
import com.cargox.teste.utils.AppConstant;
import com.cargox.teste.utils.Utils;

/**
 * Criado por Milton Alcântara em 08/05/2018.
 */
public class DetalhesColetasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_coletar_em_completo, container, false);

        ((MainActivity) getActivity()).fab.setVisibility(View.GONE);

        Bundle bundle = getArguments();
        Coletas coletas = (Coletas) bundle.getSerializable("coleta");

        //Data e Hora
        TextView tvDataHora = view.findViewById(R.id.tvDataHora);
        tvDataHora.setText(coletas.getData() + " - " + coletas.getHora());

        //Rua e Numero Coleta
        TextView tvRuaNumero = view.findViewById(R.id.tvRuaNumero);
        tvRuaNumero.setText(coletas.getColetaRuaNumero());

        //Cidade Estado Zip
        TextView tvCidadeEstadoZip = view.findViewById(R.id.tvCidadeEstadoZip);
        tvCidadeEstadoZip.setText(coletas.getColetaCidadeEstadoZip());

        //Entregar Em Rua Numero
        TextView tvEntregarEmRuaNumero = view.findViewById(R.id.tvEntregarEmRuaNumero);
        tvEntregarEmRuaNumero.setText(coletas.getEntregarEmRuaNumero());

        //Entregar Cidade Estado Zip
        TextView tvEntregarEmCidadeEstadoZip = view.findViewById(R.id.tvEntregarEmCidadeEstadoZip);
        tvEntregarEmCidadeEstadoZip.setText(coletas.getEntregarEmCidadeEstadoZip());

        //Veiculo
        TextView tvVeiculo = view.findViewById(R.id.tvVeiculo);
        tvVeiculo.setText(coletas.getVeiculos());

        //Produtos
        TextView tvProdutos = view.findViewById(R.id.tvProdutos);
        tvProdutos.setText(coletas.getProdutos());

        //Peso
        TextView tvPeso = view.findViewById(R.id.tvPeso);
        tvPeso.setText("" + coletas.getPeso() + " kg");

        RelativeLayout rlColetarEm = view.findViewById(R.id.rlColetarEm);

        //Adaptando o card de detalhes para coletar e em rota
        RelativeLayout rlEmTransito = view.findViewById(R.id.rlEmTransito);
        if (coletas.getStatusEntrega() == AppConstant.EM_TRANSITO) {
            tvDataHora.setText(coletas.getPrevisaoData() + " - " + coletas.getPrevisaoHora());
            rlColetarEm.setVisibility(View.GONE);
            rlEmTransito.setVisibility(View.VISIBLE);
            TextView tvTituloCard = view.findViewById(R.id.tvTituloCard);
            tvTituloCard.setText(R.string.titulo_previsao_chegada);
        } else if (coletas.getStatusEntrega() == AppConstant.COLETAS) {
            tvDataHora.setText(coletas.getData() + " - " + coletas.getHora());
            TextView tvVerMenosEmRota = view.findViewById(R.id.tvVerMenosEmRota);
            tvVerMenosEmRota.setVisibility(View.GONE);
            rlColetarEm.setVisibility(View.VISIBLE);

            rlEmTransito.setVisibility(View.GONE);
        }

        view.findViewById(R.id.cdCTe).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Utils(getContext()).showDialogCustom(getContext().getString(R.string.texto_dialog_cte), R.drawable.img_cte);
            }
        });

        view.findViewById(R.id.cdAdiant).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Utils(getContext()).showDialogCustom(getContext().getString(R.string.texto_dialog_adiant), R.drawable.img_payment);
            }
        });

        view.findViewById(R.id.tvVerMenos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fecharDetalhes();
            }
        });

        view.findViewById(R.id.tvVerMenosEmRota).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fecharDetalhes();
            }
        });

        view.findViewById(R.id.tvOrdemColeta).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), R.string.ver_ordem_coleta, Toast.LENGTH_SHORT).show();
                ;
            }
        });

        view.findViewById(R.id.btnColetar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), R.string.vou_coletar, Toast.LENGTH_SHORT).show();
                ;
            }
        });

        return view;
    }

    public void fecharDetalhes(){
        getFragmentManager().popBackStack();
    }

}
