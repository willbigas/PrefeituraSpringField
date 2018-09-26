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
public abstract class Imovel {

    protected String endereco;
    protected Double valorPorMetroQuadrado;
    protected String proprietario;
    protected Double area;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getValorPorMetroQuadrado() {
        return valorPorMetroQuadrado;
    }

    public void setValorPorMetroQuadrado(Double valorPorMetroQuadrado) {
        this.valorPorMetroQuadrado = valorPorMetroQuadrado;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double calculaIptu() {
        Double valorIptu = (this.getArea() * this.getValorPorMetroQuadrado()) * 0.1;
        return valorIptu;
        
    }
    
    public abstract void status();

    @Override
    public String toString() {
        return "Imovel{" + "endereco=" + endereco + ", valorPorMetroQuadrado=" + valorPorMetroQuadrado + ", proprietario=" + proprietario + ", area=" + area + '}';
    }
    
    
    

}
