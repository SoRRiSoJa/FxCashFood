/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.cashf.model.produto.Produto;
import com.cashf.model.produto.UnidadeMedida;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author joao
 */

public class ProdCalcUtil {
    
    /**
     * Calcula e retorna o valor de uma quantidade porcionada em uma dada 
     * UnidadeMedida de um objeto Produto.
     * @param prod Objeto Produto o qual se deseja o valor porcionado
     * @param uIn UnidadeMedida em que a quantidade da porção foi informada
     * @param qtde Quantidade da porção do Produto
     * @return  Retorna o valor da da porção informada para este Produto
 */
    public static BigDecimal valorPorcao(Produto prod, UnidadeMedida uIn, BigDecimal qtde) {
        try {
            if (prod.getUnidadeMedida().equals(uIn)) {
                return (qtde.multiply(prod.getPreco_custo())).divide(prod.getQtdeEmbalagem(), RoundingMode.HALF_EVEN);
            } else {
                return (UnitConverter.convertTo(uIn, prod.getUnidadeMedida(), qtde).multiply(prod.getPreco_custo())).divide(prod.getQtdeEmbalagem(),RoundingMode.HALF_EVEN);
            }
        } catch (Exception ex) {
            System.out.println("Erro ao calcular---------->>>>>>>>" + ex);
            return BigDecimal.ZERO;
        }
    }
}
