package testes;

import numeros.Numeros;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumerosTest {

    @Test
    public void testValidarSeUmNumeroEUmaUnidade(){
        Numeros numeros = new Numeros();
        boolean eUnidade = numeros.eUmaUnidade(9);
        Assert.assertTrue(eUnidade);
    }

    @Test
    public void testValidarSeuNumeroNaoEUmaUnidade(){
        //vou utiilzar o método eUmaUnidade passando o valor 10
        Numeros numeros = new Numeros();
        boolean eUnidade = numeros.eUmaUnidade(10);

        //Vou validar que a resposta é falsa
        Assert.assertFalse(eUnidade);
    }

}


