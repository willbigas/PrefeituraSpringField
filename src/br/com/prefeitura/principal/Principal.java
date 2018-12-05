package br.com.prefeitura.principal;

import br.com.prefeitura.negocio.ManterPrefeituraNegocio;
import br.com.prefeitura.entidade.Comercio;
import br.com.prefeitura.entidade.Residencia;
import br.com.prefeitura.entidade.TerrenoVazio;
import br.com.prefeitura.entidade.Imovel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William
 */
public class Principal {

    public static List<Imovel> IMOVELS = new ArrayList<>();

    public static List<Comercio> COMERCIALS = new ArrayList<>();
    public static List<Residencia> RESIDENCIALS = new ArrayList<>();
    public static List<TerrenoVazio> VAZIOS = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        List<String> linhasC = new ArrayList<>();
        List<String> linhasR = new ArrayList<>();
        List<String> linhasV = new ArrayList<>();
        List<String> linhas = br.com.prefeitura.util.UtilArquivo.lerArqArrayList("dados_prefeitura.txt");

        ManterPrefeituraNegocio.lendoLinhasArquivo(linhas, linhasC, linhasR, linhasV);

        ManterPrefeituraNegocio.criandoComercio(linhasC);
        ManterPrefeituraNegocio.criandoResidencia(linhasR);
        ManterPrefeituraNegocio.criandoTerrenosVazios(linhasV);

        ManterPrefeituraNegocio.atribuindoImoveis();
        ManterPrefeituraNegocio.imprimindoResultado();

    }

}
