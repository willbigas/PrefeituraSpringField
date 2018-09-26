/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

/**
 *
 * @author William
 */
public class Residencia extends TerrenoEdificado {

    private Integer numeroMoradores;

    public Integer getNumeroMoradores() {
        return numeroMoradores;
    }

    public void setNumeroMoradores(Integer numeroMoradores) {
        this.numeroMoradores = numeroMoradores;
    }

    @Override
    public Double calcularImpostoEdificacao() {
        Double impostoEdificado = (this.getAreaEdificada() * this.getValorPorMetroQuadrado()) * 0.2;
        return impostoEdificado;
    }

    @Override
    public Double calculaIptu() {
        Double valorIptu = (this.getArea() * this.getValorPorMetroQuadrado()) * 0.1;
        return valorIptu;

    }

    @Override
    public String toString() {
        return super.toString() + "Residencia{" + "numeroMoradores=" + numeroMoradores + '}';
    }

}
