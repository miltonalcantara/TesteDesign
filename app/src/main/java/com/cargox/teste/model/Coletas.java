package com.cargox.teste.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Criado por Milton Alcântara on 03/05/2018.
 */
public class Coletas implements Parcelable, Serializable {
    private String data;
    private String hora;
    private String coletaRuaNumero;
    private String coletaCidadeEstadoZip;
    private String entregarEmRuaNumero;
    private String entregarEmCidadeEstadoZip;
    private String previsaoData;
    private String previsaoHora;
    private String veiculos;
    private String produtos;
    private String peso;
    private int statusEntrega = 0;

    public Coletas() {
    }

    public Coletas(String data, String hora, String coletaRuaNumero, String coletaCidadeEstadoZip, String entregarEmRuaNumero, String entregarEmCidadeEstadoZip, String previsaoData, String previsaoHora, String veiculos, String produtos, String peso) {
        this.data = data;
        this.hora = hora;
        this.coletaRuaNumero = coletaRuaNumero;
        this.coletaCidadeEstadoZip = coletaCidadeEstadoZip;
        this.entregarEmRuaNumero = entregarEmRuaNumero;
        this.entregarEmCidadeEstadoZip = entregarEmCidadeEstadoZip;
        this.previsaoData = previsaoData;
        this.previsaoHora = previsaoHora;
        this.veiculos = veiculos;
        this.produtos = produtos;
        this.peso = peso;
    }

    public Coletas(String data, String hora, String coletaRuaNumero, String coletaCidadeEstadoZip, String entregarEmRuaNumero, String entregarEmCidadeEstadoZip, String previsaoData, String previsaoHora, String veiculos, String produtos, String peso, int statusEntrega) {
        this.data = data;
        this.hora = hora;
        this.coletaRuaNumero = coletaRuaNumero;
        this.coletaCidadeEstadoZip = coletaCidadeEstadoZip;
        this.entregarEmRuaNumero = entregarEmRuaNumero;
        this.entregarEmCidadeEstadoZip = entregarEmCidadeEstadoZip;
        this.previsaoData = previsaoData;
        this.previsaoHora = previsaoHora;
        this.veiculos = veiculos;
        this.produtos = produtos;
        this.peso = peso;
        this.statusEntrega = statusEntrega;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getColetaRuaNumero() {
        return coletaRuaNumero;
    }

    public void setColetaRuaNumero(String ruaNumero) {
        this.coletaRuaNumero = coletaRuaNumero;
    }

    public String getColetaCidadeEstadoZip() {
        return coletaCidadeEstadoZip;
    }

    public void setColetaCidadeEstadoZip(String coletaCidadeEstadoZip) {
        coletaCidadeEstadoZip = coletaCidadeEstadoZip;
    }

    public String getEntregarEmRuaNumero() {
        return entregarEmRuaNumero;
    }

    public void setEntregarEmRuaNumero(String entregarEm) {
        this.entregarEmRuaNumero = entregarEmRuaNumero;
    }

    public String getEntregarEmCidadeEstadoZip() {
        return entregarEmCidadeEstadoZip;
    }

    public void setEntregarEmCidadeEstadoZip(String entregarEmCidadeEstadoZip) {
        this.entregarEmCidadeEstadoZip = entregarEmCidadeEstadoZip;
    }

    public String getPrevisaoData() {
        return previsaoData;
    }

    public void setPrevisaoData(String previsaoData) {
        this.previsaoData = previsaoData;
    }

    public String getPrevisaoHora() {
        return previsaoHora;
    }

    public void setPrevisaoHora(String previsaoHora) {
        this.previsaoHora = previsaoHora;
    }

    public String getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(String veiculos) {
        this.veiculos = veiculos;
    }

    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String produtos) {
        this.produtos = produtos;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public int getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(int statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public Coletas(Parcel in) {
        readFromParcel(in);
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(data);
        dest.writeString(hora);
        dest.writeString(coletaRuaNumero);
        dest.writeString(coletaCidadeEstadoZip);
        dest.writeString(entregarEmRuaNumero);
        dest.writeString(entregarEmCidadeEstadoZip);
        dest.writeString(previsaoData);
        dest.writeString(previsaoHora);
        dest.writeString(veiculos);
        dest.writeString(produtos);
        dest.writeString(peso);
        dest.writeInt(statusEntrega);
    }

    private void readFromParcel(Parcel in) {
        data = in.readString();
        hora = in.readString();
        coletaRuaNumero = in.readString();
        coletaCidadeEstadoZip = in.readString();
        entregarEmRuaNumero = in.readString();
        entregarEmCidadeEstadoZip = in.readString();
        previsaoData = in.readString();
        previsaoHora = in.readString();
        veiculos = in.readString();
        produtos = in.readString();
        peso = in.readString();
        statusEntrega = in.readInt();
    }

    public static final Creator<Coletas> CREATOR = new Creator<Coletas>() {

        @Override
        public Coletas createFromParcel(Parcel source) {
            return new Coletas(source);
        }

        @Override
        public Coletas[] newArray(int size) {
            return new Coletas[size];
        }
    };
}
