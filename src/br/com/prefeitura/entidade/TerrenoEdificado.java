package br.com.prefeitura.entidade;

/**
 *
 * @author William Bigas Mauro
 */
public class TerrenoEdificado extends Imovel {

    protected Double areaEdificada;
    protected Integer numeroPavimentos;

    public Double getAreaEdificada() {
        return areaEdificada;
    }

    public void setAreaEdificada(Double areaEdificada) {
        this.areaEdificada = areaEdificada;
    }

    public Integer getNumeroPavimentos() {
        return numeroPavimentos;
    }

    public void setNumeroPavimentos(Integer numeroPavimentos) {
        this.numeroPavimentos = numeroPavimentos;
    }

    public Double calcularImpostoEdificacao() {
        Double impostoEdificado = (this.getAreaEdificada() * this.getValorPorMetroQuadrado()) * 0.2;
        return impostoEdificado;
    }

    @Override
    public void status() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
