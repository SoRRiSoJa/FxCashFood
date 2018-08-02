/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.cashf.dao.banco.BancoDAO;
import com.cashf.dao.cidade.CidadeDAO;
import com.cashf.dao.estado.EstadoDAO;
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

    private List<Estado> estados = new ArrayList<>();
    private List<Cidade> cidades = new ArrayList<>();
    private List<Banco> bancos = new ArrayList<>();
    private final EstadoDAO estadoDAO;
    private final CidadeDAO cidadeDAO;
    private final BancoDAO bancoDAO;

    public BDInsert() {
        this.estados = new ArrayList<>();
        this.cidades = new ArrayList<>();
        this.bancos = new ArrayList<>();
        this.estadoDAO = new EstadoDAO(Estado.class);
        this.cidadeDAO = new CidadeDAO(Cidade.class);
        this.bancoDAO = new BancoDAO(Banco.class);
    }

    private void loadLists() {
        createInstanceBancos();
        createInstanceEstados();
        createInstanceCidades();
    }

    public void insertData() {
        loadLists();
        estados.forEach((est) -> {
            estadoDAO.save(est);
        });
        cidades.forEach((cid) -> {
            cidadeDAO.save(cid);
        });
        bancos.forEach((bac) -> {
            bancoDAO.save(bac);
        });
    }

    private void createInstanceEstados() {
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
    }

    private void createInstanceCidades() {
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

    private void createInstanceBancos() {
        bancos.add(new Banco(1l, "Banco do Brasil"));
        bancos.add(new Banco(2l, "Banco Central do Brasil"));
        bancos.add(new Banco(3l, "Banco da Amazônia"));
        bancos.add(new Banco(4l, "Banco do Nordeste do Brasil"));
        bancos.add(new Banco(7l, "Banco Nacional de Desenvolvimento Econômico e Social"));
        bancos.add(new Banco(104l, "Caixa Econômica Federal"));
        bancos.add(new Banco(46l, "Banco Regional de Desenvolvimento do Extremo Sul"));
        bancos.add(new Banco(23l, "Banco de Desenvolvimento de Minas Gerais"));
        bancos.add(new Banco(70l, "Banco de Brasília"));
        bancos.add(new Banco(47l, "Banco do Estado de Sergipe"));
        bancos.add(new Banco(21l, "Banco do Estado do Espírito Santo"));
        bancos.add(new Banco(37l, "Banco do Estado do Pará"));
        bancos.add(new Banco(41l, "Banco do Estado do Rio Grande do Sul"));
        bancos.add(new Banco(75l, "Banco ABN Amro S.A."));
        bancos.add(new Banco(25l, "Banco Alfa"));
        bancos.add(new Banco(719l, "Banco Banif"));
        bancos.add(new Banco(107l, "Banco BBM"));
        bancos.add(new Banco(318l, "Banco BMG"));
        bancos.add(new Banco(218l, "Banco Bonsucesso"));
        bancos.add(new Banco(208l, "Banco BTG Pactual"));
        bancos.add(new Banco(263l, "Banco Cacique"));
        bancos.add(new Banco(473l, "Banco Caixa Geral - Brasil"));
        bancos.add(new Banco(745l, "Banco Citibank"));
        bancos.add(new Banco(721l, "Banco Credibel"));
        bancos.add(new Banco(505l, "Banco Credit Suisse"));
        bancos.add(new Banco(707l, "Banco Daycoval"));
        bancos.add(new Banco(265l, "Banco Fator"));
        bancos.add(new Banco(224l, "Banco Fibra"));
        bancos.add(new Banco(121l, "Banco Gerador"));
        bancos.add(new Banco(612l, "Banco Guanabara"));
        bancos.add(new Banco(604l, "Banco Industrial do Brasil"));
        bancos.add(new Banco(320l, "Banco Industrial e Comercial"));
        bancos.add(new Banco(653l, "Banco Indusval"));
        bancos.add(new Banco(77l, "Banco Intermedium"));
        bancos.add(new Banco(184l, "Banco Itaú BBA"));
        bancos.add(new Banco(479l, "Banco ItaúBank"));
        bancos.add(new Banco(389l, "Banco Mercantil do Brasil"));
        bancos.add(new Banco(746l, "Banco Modal"));
        bancos.add(new Banco(738l, "Banco Morada"));
        bancos.add(new Banco(623l, "Banco Pan"));
        bancos.add(new Banco(611l, "Banco Paulista"));
        bancos.add(new Banco(643l, "Banco Pine"));
        bancos.add(new Banco(654l, "Banco Renner"));
        bancos.add(new Banco(741l, "Banco Ribeirão Preto"));
        bancos.add(new Banco(422l, "Banco Safra"));
        bancos.add(new Banco(33l, "Banco Santander"));
        bancos.add(new Banco(637l, "Banco Sofisa"));
        bancos.add(new Banco(82l, "Banco Topázio"));
        bancos.add(new Banco(655l, "Banco Votorantim"));
        bancos.add(new Banco(237l, "Bradesco"));
        bancos.add(new Banco(341l, "Itaú Unibanco"));
        bancos.add(new Banco(756l, "Banco Cooperativo do Brasil - BANCOOB"));
        bancos.add(new Banco(748l, "Banco Cooperativo Sicredi - BANSICREDI"));
    }
}
