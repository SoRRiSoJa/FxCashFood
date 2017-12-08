/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.cashf.model.banco.Banco;
import com.cashf.model.cidade.Cidade;
import com.cashf.model.estado.Estado;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joao
 */
public class BDInsert {

    public static List<Estado> estados = new ArrayList<>();
    public static List<Cidade> cidades = new ArrayList<>();
    public static List<Banco> bancos = new ArrayList<>();

    public void inserData() {
        estados.add(new Estado("AC", "Acre"));
        estados.add(new Estado("AL", "Alagoas"));
        estados.add(new Estado("AM", "Amazonas"));
        estados.add(new Estado("AP", "Amapá"));
        estados.add(new Estado("BA", "Bahia"));
        estados.add(new Estado("CE", "Ceará"));
        estados.add(new Estado("DF", "Distrito Federal"));
        estados.add(new Estado("ES", "Espírito Santo"));
        estados.add(new Estado("GO", "Goiás"));
        estados.add(new Estado("MA", "Maranhão"));
        estados.add(new Estado("MG", "Minas Gerais"));
        estados.add(new Estado("MS", "Mato Grosso do Sul"));
        estados.add(new Estado("MT", "Mato Grosso"));
        estados.add(new Estado("PA", "Pará"));
        estados.add(new Estado("PB", "Paraíba"));
        estados.add(new Estado("PE", "Pernambuco"));
        estados.add(new Estado("PI", "Piauí"));
        estados.add(new Estado("PR", "Paraná"));
        estados.add(new Estado("RJ", "Rio de Janeiro"));
        estados.add(new Estado("RN", "Rio Grande do Norte"));
        estados.add(new Estado("RO", "Rondônia"));
        estados.add(new Estado("RR", "Roraima"));
        estados.add(new Estado("RS", "Rio Grande do Sul"));
        estados.add(new Estado("SC", "Santa Catarina"));
        estados.add(new Estado("SE", "Sergipe"));
        estados.add(new Estado("SP", "São Paulo"));
        estados.add(new Estado("TO", "Tocantins"));
        cidades.add(new Cidade("Presidente Prudente", new Estado("SP", "São Paulo")));
        cidades.add(new Cidade("Marilia", new Estado("SP", "São Paulo")));
        cidades.add(new Cidade("Presidente Epitacio", new Estado("SP", "São Paulo")));
        cidades.add(new Cidade("Presidente Venceslau", new Estado("SP", "São Paulo")));
        cidades.add(new Cidade("São Paulo", new Estado("SP", "São Paulo")));
        cidades.add(new Cidade("Piracicaba", new Estado("SP", "São Paulo")));
        cidades.add(new Cidade("Campinas", new Estado("SP", "São Paulo")));
        cidades.add(new Cidade("Americana", new Estado("SP", "São Paulo")));
        cidades.add(new Cidade("Rio de Janeiro", new Estado("RJ", "Rio de Janeiro")));
    }

}
