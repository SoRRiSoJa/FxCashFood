/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import java.math.BigDecimal;

/**
 *
 * @author joao
 */
public class ProdCalcUtil {

    public static BigDecimal valorPorcao(Produto prod, UnidadeMedida uIn, BigDecimal qtde) {
        try {
            if (prod.getUnidadeMedida().equals(uIn)) {
                return (qtde.multiply(prod.getPreco_custo())).divide(prod.getQtdeProduto());
            } else {
                return (UnitConverter.convertTo(uIn, prod.getUnidadeMedida(), qtde).multiply(prod.getPreco_custo())).divide(prod.getQtdeProduto());
            }
        } catch (Exception ex) {
            System.out.println("Erro ao calcular---------->>>>>>>>" + ex);
            return BigDecimal.ZERO;
        }

    }
}
