package br.com.prefeitura.entidade;

/**
 *
 * @author William Bigas Mauro
 */
public class TerrenoVazio extends Imovel {

    @Override
    public void status() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString() + "TerrenoVazio{" + '}';
    }

}
