package br.com.prefeitura.entidade;

/**
 *
 * @author William Bigas Mauro
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
