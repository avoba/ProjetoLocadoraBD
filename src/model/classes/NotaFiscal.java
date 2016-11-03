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
public class NotaFiscal {
    private int idNotaFiscal;
    private float vlrFinal;
    private Timestamp dtEmissao;
    private int idReserva;

    public int getIdNotaFiscal() {
        return idNotaFiscal;
    }

    public void setIdNotaFiscal(int idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    public float getVlrFinal() {
        return vlrFinal;
    }

    public void setVlrFinal(float vlrFinal) {
        this.vlrFinal = vlrFinal;
    }

    public Timestamp getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(Timestamp dtEmissao) {
        this.dtEmissao = dtEmissao;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
    
    
    
}
