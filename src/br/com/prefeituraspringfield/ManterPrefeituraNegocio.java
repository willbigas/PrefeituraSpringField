/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.prefeituraspringfield;

import objetos.Comercio;
import objetos.Residencia;
import objetos.TerrenoVazio;
import static br.com.prefeituraspringfield.Principal.COMERCIALS;
import static br.com.prefeituraspringfield.Principal.IMOVELS;
import static br.com.prefeituraspringfield.Principal.RESIDENCIALS;
import static br.com.prefeituraspringfield.Principal.VAZIOS;
import java.util.List;

/**
 *
 * @author WILL
 */
public class ManterPrefeituraNegocio {

    public static void imprimindoResultado() {
        System.out.println("NOME ||               ENDERECO              ||  IPTU || VALOR IMOVEL || IMP EDIFICACAO || SOMA IMPOSTOS || TOTAL A PAGAR ");

        for (int i = 0; i < IMOVELS.size(); i++) {
            Double somaImpostos = 0.0;
            Double valorImovel = 0.0;
            Double valorEdificacao = 0.0;
            Double valorTotal = 0.0;

            if (IMOVELS.get(i) instanceof Comercio) {
                Comercio aux = (Comercio) IMOVELS.get(i);
                valorEdificacao = aux.calcularImpostoEdificacao();
                somaImpostos = aux.calculaIptu() + valorEdificacao;
                valorImovel = aux.getValorPorMetroQuadrado() * aux.getArea();
                valorTotal = valorImovel + somaImpostos;

                System.out.println(aux.getProprietario() + " - " + aux.getEndereco() + " - "
                        + UtilPacket.UtilFormat.decFormatR$(aux.calculaIptu()) + " - " + UtilPacket.UtilFormat.decFormatR$(valorImovel) + " - "
                        + UtilPacket.UtilFormat.decFormatR$(valorEdificacao) + " - " + UtilPacket.UtilFormat.decFormatR$(somaImpostos) + " - "
                        + UtilPacket.UtilFormat.decFormatR$(valorTotal));
            }

            if (IMOVELS.get(i) instanceof Residencia) {
                Residencia aux = (Residencia) IMOVELS.get(i);
                valorEdificacao = aux.calcularImpostoEdificacao();
                somaImpostos = aux.calculaIptu() + valorEdificacao;
                valorImovel = aux.getValorPorMetroQuadrado() * aux.getArea();
                valorTotal = valorImovel + somaImpostos;

                System.out.println(aux.getProprietario() + " - " + aux.getEndereco() + " - "
                        + UtilPacket.UtilFormat.decFormatR$(aux.calculaIptu()) + " - " + UtilPacket.UtilFormat.decFormatR$(valorImovel) + " - "
                        + UtilPacket.UtilFormat.decFormatR$(valorEdificacao) + " - " + UtilPacket.UtilFormat.decFormatR$(somaImpostos) + " - "
                        + UtilPacket.UtilFormat.decFormatR$(valorTotal));
            }

            if (IMOVELS.get(i) instanceof TerrenoVazio) {
                TerrenoVazio aux = (TerrenoVazio) IMOVELS.get(i);
                somaImpostos = aux.calculaIptu() + valorEdificacao;
                valorImovel = aux.getValorPorMetroQuadrado() * aux.getArea();
                valorTotal = valorImovel + somaImpostos;

                System.out.println(aux.getProprietario() + " - " + aux.getEndereco() + " - "
                        + UtilPacket.UtilFormat.decFormatR$(aux.calculaIptu()) + " - " + UtilPacket.UtilFormat.decFormatR$(valorImovel) + " - "
                        + UtilPacket.UtilFormat.decFormatR$(valorEdificacao) + " - " + UtilPacket.UtilFormat.decFormatR$(somaImpostos) + " - "
                        + UtilPacket.UtilFormat.decFormatR$(valorTotal));
            }

        }
    }

    public static void atribuindoImoveis() {
        IMOVELS.addAll(COMERCIALS);
        IMOVELS.addAll(RESIDENCIALS);
        IMOVELS.addAll(VAZIOS);
    }

    public static void criandoTerrenosVazios(List<String> linhasV) throws NumberFormatException {
        for (int i = 0; i < linhasV.size(); i++) { // Atribuindo Comercio
            String get[] = linhasV.get(i).split(";");

            VAZIOS.add(new TerrenoVazio());
            VAZIOS.get(i).setEndereco(get[1]);
            VAZIOS.get(i).setProprietario(get[2]);
            VAZIOS.get(i).setArea(Double.valueOf(get[3]));
            VAZIOS.get(i).setValorPorMetroQuadrado(5.00);
        }
    }

    public static void criandoResidencia(List<String> linhasR) throws NumberFormatException {
        for (int i = 0; i < linhasR.size(); i++) { // Atribuindo Comercio
            String get[] = linhasR.get(i).split(";");

            RESIDENCIALS.add(new Residencia());
            RESIDENCIALS.get(i).setEndereco(get[1]);
            RESIDENCIALS.get(i).setProprietario(get[2]);
            RESIDENCIALS.get(i).setArea(Double.valueOf(get[3]));
            RESIDENCIALS.get(i).setAreaEdificada(Double.valueOf(get[4]));
            RESIDENCIALS.get(i).setNumeroPavimentos(Integer.valueOf(get[5]));
            RESIDENCIALS.get(i).setNumeroMoradores(Integer.valueOf(get[6]));
            RESIDENCIALS.get(i).setValorPorMetroQuadrado(10.00);
        }
    }

    public static void criandoComercio(List<String> linhasC) throws NumberFormatException {
        for (int i = 0; i < linhasC.size(); i++) { // Atribuindo Comercio
            String get[] = linhasC.get(i).split(";");

            COMERCIALS.add(new Comercio());
            COMERCIALS.get(i).setEndereco(get[1]);
            COMERCIALS.get(i).setProprietario(get[2]);
            COMERCIALS.get(i).setArea(Double.valueOf(get[3]));
            COMERCIALS.get(i).setAreaEdificada(Double.valueOf(get[4]));
            COMERCIALS.get(i).setNumeroPavimentos(Integer.valueOf(get[5]));
            COMERCIALS.get(i).setTipo(get[7]);
            COMERCIALS.get(i).setValorPorMetroQuadrado(25.00);
        }
    }

    public static void lendoLinhasArquivo(List<String> linhas, List<String> linhasC, List<String> linhasR, List<String> linhasV) {
        //  tipo imovel;endereco;proprietario;area_terreno;area_construida;pavimentos;quantidade_moradores;tipo edificacao //
        //   Comercial;RUA LAERCIO LOURENCO - JD. ALVINOPOLIS;JOAO;125;80;1;VAZIO;Comercio //
        for (int i = 0; i < linhas.size(); i++) { // Separando Tipos
            if (linhas.get(i).startsWith("Comercial")) {
                linhasC.add(linhas.get(i));
            }
            if (linhas.get(i).startsWith("Residencial")) {
                linhasR.add(linhas.get(i));
            }
            if (linhas.get(i).startsWith("Vago")) {
                linhasV.add(linhas.get(i));
            }
        }
    }

}
