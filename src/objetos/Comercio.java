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
public class Comercio extends TerrenoEdificado {

    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Double calculaIptu() {
        if (this.getTipo().equals("Indutria")) {
            Double valorIptu = (this.getArea() * this.getValorPorMetroQuadrado()) * 0.025;
            return valorIptu;
        } else {
            Double valorIptu = (this.getArea() * this.getValorPorMetroQuadrado()) * 0.015;
            return valorIptu;
        }

    }

    @Override
    public Double calcularImpostoEdificacao() {
        Double impostoEdificado = (this.getAreaEdificada() * this.getValorPorMetroQuadrado()) * 0.2;
        return impostoEdificado;
    }

    @Override
    public String toString() {
        return super.toString() + "Comercio{" + "tipo=" + tipo + '}';
    }

}
