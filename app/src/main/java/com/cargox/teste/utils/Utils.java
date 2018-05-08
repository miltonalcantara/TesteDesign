package com.cargox.teste.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cargox.teste.R;

public class Utils {

    private Context context;

    public Utils(Context context) {
        this.context = context;
    }

    public void showDialogCustom(String texto, int imagem) {
        final Dialog DialogCustom = new Dialog(context);
        DialogCustom.requestWindowFeature(Window.FEATURE_NO_TITLE);
        DialogCustom.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        DialogCustom.setContentView(R.layout.dialogcustom);
        DialogCustom.setCancelable(true);

        TextView mensagem = DialogCustom.findViewById(R.id.tvTextoDialog);
        mensagem.setText(texto);

        ImageView desenho = DialogCustom.findViewById(R.id.ivDialog);
        desenho.setImageResource(imagem);

        DialogCustom.findViewById(R.id.ibClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Fechar", Toast.LENGTH_SHORT).show();
                DialogCustom.dismiss();
            }
        });

        DialogCustom.findViewById(R.id.btnEntendi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Entendi", Toast.LENGTH_SHORT).show();
                DialogCustom.dismiss();
            }
        });

        DialogCustom.show();
    }

    public void showDialogContato() {
        final Dialog DialogCustom = new Dialog(context);
        DialogCustom.requestWindowFeature(Window.FEATURE_NO_TITLE);
        DialogCustom.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        DialogCustom.setContentView(R.layout.dialogcontacts);
        DialogCustom.setCancelable(true);

        DialogCustom.findViewById(R.id.btnLigarCargoX).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Ligar CargoX", Toast.LENGTH_SHORT).show();
                DialogCustom.dismiss();
            }
        });

        DialogCustom.findViewById(R.id.btnChat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Chat CargoX", Toast.LENGTH_SHORT).show();
                DialogCustom.dismiss();
            }
        });

        DialogCustom.show();
    }
}
