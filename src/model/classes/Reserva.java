/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.classes;

import java.sql.Timestamp;
/**
 *
 * @author Arthur
 */
public class Reserva {
    private int idReserva;
    private Timestamp dtFinal;
    private Timestamp dtDevolucao;
    private Timestamp dtEntrada;
    private Timestamp dtInicio;
    private int idPessoa;
    private int idVeiculo;
    private int idMulta;

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Timestamp getDtFinal() {
        return dtFinal;
    }

    public void setDtFinal(Timestamp dtFinal) {
        this.dtFinal = dtFinal;
    }

    public Timestamp getDtDevolucao() {
        return dtDevolucao;
    }

    public void setDtDevolucao(Timestamp dtDevolucao) {
        this.dtDevolucao = dtDevolucao;
    }

    public Timestamp getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(Timestamp dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public Timestamp getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Timestamp dtInicio) {
        this.dtInicio = dtInicio;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
    }
    
    
    
    
}
