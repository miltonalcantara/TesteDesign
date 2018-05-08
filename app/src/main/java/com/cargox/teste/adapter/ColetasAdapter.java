package com.cargox.teste.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cargox.teste.MainActivity;
import com.cargox.teste.R;
import com.cargox.teste.fragment.DetalhesColetasFragment;
import com.cargox.teste.model.Coletas;
import com.cargox.teste.utils.AppConstant;
import com.cargox.teste.utils.Utils;

import java.util.List;

public class ColetasAdapter extends RecyclerView.Adapter<ColetasAdapter.MultipleRowViewHolder> {

    private Context context;
    private LayoutInflater inflater = null;
    private List<Coletas> multipleRowModelList;
    private List<Coletas> mList;

    public ColetasAdapter(Context context, List<Coletas> multipleRowModelList) {
        this.context = context;
        mList = multipleRowModelList;
        this.multipleRowModelList = multipleRowModelList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MultipleRowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;

        if (viewType == AppConstant.COLETAS)
            view = inflater.inflate(R.layout.card_coletar_em, parent, false);
        else if (viewType == AppConstant.COLETADAS)
            view = inflater.inflate(R.layout.card_coletar_em, parent, false);
        else if (viewType == AppConstant.EM_TRANSITO)
            view = inflater.inflate(R.layout.card_entregar_em, parent, false);

        return new MultipleRowViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(final MultipleRowViewHolder myViewHolder, final int position) {

        if (position == 0) {
            myViewHolder.tvDeslizar.setVisibility(View.VISIBLE);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(32, 0, 8, 0);
            myViewHolder.llContainer.setLayoutParams(params);
        }

        myViewHolder.cdCTe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Utils(context).showDialogCustom(context.getString(R.string.texto_dialog_cte), R.drawable.img_cte);
            }
        });

        myViewHolder.cdAdiant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Utils(context).showDialogCustom(context.getString(R.string.texto_dialog_adiant), R.drawable.img_payment);
            }
        });

        myViewHolder.tvVerDetalhes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DetalhesColetasFragment detalhesColetasFragment = new DetalhesColetasFragment();
                FragmentTransaction fragmentTransaction = ((MainActivity) context).getSupportFragmentManager().beginTransaction();

                Bundle bundle = new Bundle();
                Coletas coletas = mList.get(position);
                bundle.putSerializable("coleta", coletas);
                detalhesColetasFragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.frame, detalhesColetasFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        if (getItemViewType(position) == AppConstant.COLETAS) { //Itens novos para serem coletados

            String dataHora = mList.get(position).getData() + " - " + mList.get(position).getHora();
            myViewHolder.tvDataHora.setText(dataHora);

            myViewHolder.tvRuaNumero.setText(mList.get(position).getColetaRuaNumero());
            myViewHolder.tvCidadeEstadoZip.setText(mList.get(position).getColetaCidadeEstadoZip());

            myViewHolder.btnColetar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Btn Coletar", Toast.LENGTH_SHORT).show();
                }
            });

        }

        if (getItemViewType(position) == AppConstant.EM_TRANSITO) { // Itens que já estão a caminho

            myViewHolder.tvOrdemColeta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Ver ordem de coleta", Toast.LENGTH_SHORT).show();
                }
            });

            myViewHolder.btnDescarregar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Btn Descarregar", Toast.LENGTH_SHORT).show();
                }
            });

            String dataHoraChegada = mList.get(position).getPrevisaoData() + " - " + mList.get(position).getPrevisaoHora();
            myViewHolder.tvDataHora.setText(dataHoraChegada);

            myViewHolder.tvRuaNumero.setText(mList.get(position).getEntregarEmRuaNumero());
            myViewHolder.tvCidadeEstadoZip.setText(mList.get(position).getEntregarEmCidadeEstadoZip());

        }

    }

    @Override
    public int getItemCount() {
        return (multipleRowModelList != null && multipleRowModelList.size() > 0) ? multipleRowModelList.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {

        Coletas multipleRowModel = multipleRowModelList.get(position);

        if (multipleRowModel != null) {
            return multipleRowModel.getStatusEntrega();
        }
        return super.getItemViewType(position);
    }

    class MultipleRowViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDataHora;

        private TextView tvRuaNumero;
        private TextView tvCidadeEstadoZip;

        private CardView cdCTe;
        private CardView cdAdiant;

        private TextView tvDeslizar;

        private TextView tvVerDetalhes;
        private TextView tvOrdemColeta;

        private Button btnColetar;
        private Button btnDescarregar;

        private LinearLayout llContainer;

        private MultipleRowViewHolder(View itemView, int type) {
            super(itemView);

            tvDataHora = itemView.findViewById(R.id.tvDataHora);

            tvRuaNumero = itemView.findViewById(R.id.tvRuaNumero);
            tvCidadeEstadoZip = itemView.findViewById(R.id.tvCidadeEstadoZip);

            cdCTe = itemView.findViewById(R.id.cdCTe);
            cdAdiant = itemView.findViewById(R.id.cdAdiant);

            tvVerDetalhes = itemView.findViewById(R.id.tvVerDetalhes);

            tvDeslizar = itemView.findViewById(R.id.tvDeslizar);

            llContainer = itemView.findViewById(R.id.llContainer);

            if (type == AppConstant.COLETAS) {

                btnColetar = itemView.findViewById(R.id.btnColetar);

            } else if (type == AppConstant.COLETADAS) {


            } else if (type == AppConstant.EM_TRANSITO) {

                btnDescarregar = itemView.findViewById(R.id.btnDescarregar);
                tvOrdemColeta = itemView.findViewById(R.id.tvOrdemColeta);
            }

        }
    }

}
