/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.cashf.model.produto.UnidadeMedida;
import java.math.BigDecimal;

/**
 *
 * @author joao
 */
public class UnitConverter {

    public static BigDecimal convertTo(UnidadeMedida uIn, UnidadeMedida uOut, BigDecimal valIn) {
        switch (uIn) {
            case l:
                if (uOut.equals(UnidadeMedida.ml)) {
                    return valIn.multiply(BigDecimal.valueOf(1000));
                }
                break;
            case ml:
                if (uOut.equals(UnidadeMedida.l)) {
                    return valIn.divide(BigDecimal.valueOf(1000));
                }
                break;
            case Kg:
                if (uOut.equals(UnidadeMedida.g)) {
                    return valIn.multiply(BigDecimal.valueOf(1000));
                }
                break;
            case g:
                if (uOut.equals(UnidadeMedida.mg)) {
                    return valIn.multiply(BigDecimal.valueOf(1000));
                } else if (uOut.equals(UnidadeMedida.Kg)) {
                    return valIn.divide(BigDecimal.valueOf(1000));
                }
                break;
            case mg:
                if (uOut.equals(UnidadeMedida.g)) {
                    return valIn.divide(BigDecimal.valueOf(1000));
                }
                break;
            case UN:
                if (uOut.equals(UnidadeMedida.UN)) {
                    return valIn.multiply(BigDecimal.ONE);
                }
                break;

        }
        return null;
    }
}
