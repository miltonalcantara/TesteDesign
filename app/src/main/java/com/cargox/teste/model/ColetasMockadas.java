package com.cargox.teste.model;

import com.cargox.teste.utils.AppConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * Criado por Milton Alcântara 05/05/18.
 */

public class ColetasMockadas {

    public List<Coletas> getColetas() {
        List<Coletas> listAux = new ArrayList<>();

        //Adicionando coletas novas no sistema
        listAux.add(new Coletas("24/03/17", "10:00", "Francisco de Medeiros - 296", "São Paulo - SP", "Reverendo Amazonas - 402", "Espirito Santo - ES", "","","Carreta Sider", "Bebidas em geral", "24.000"));
        listAux.add(new Coletas("22/03/17", "15:00", "Paulo de Medeiros - 297", "Florianopolis - SC", "Magnanimo Amazonas - 404", "Maceio - AL", "","", "Carreta Up", "Alimentos em geral", "13.000"));
        listAux.add(new Coletas("21/03/17", "12:00", "Pedro de Medeiros - 294", "Curitiba - PR", "Tirano Amazonas - 408", "Fortaleza - MA", "", "","Carreta Down", "Eletrônicos em geral", "56.000"));

        //Adicionando coletas em transito
        listAux.add(new Coletas("10/03/17", "08:00", "José de Medeiros - 291", "Maceio - AL", "Reverendo Amazonas - 402", "Florianopolis - SC", "18/03/17", "08:00", "Carreta Sider", "Bebidas em geral", "24.000", AppConstant.EM_TRANSITO));
        listAux.add(new Coletas("03/03/17", "17:00", "Milton de Medeiros - 295", "Fortaleza - MA", "Magnanimo Amazonas - 404", "Curitiba - PR", "15/03/17", "17:00", "Carreta Up", "Alimentos em geral", "13.000", AppConstant.EM_TRANSITO));

        return listAux;
    }


}
