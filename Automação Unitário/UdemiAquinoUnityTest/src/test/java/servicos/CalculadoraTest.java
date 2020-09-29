package servicos;

import exceptions.NaoPodeDividirPorZeroException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import servicos.Calculadora;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class CalculadoraTest {

    //deixar a calculadora global
    private Calculadora calc;

    //instanciamos na anotação antes de execução
    @Before
    public void setup() {
        calc = new Calculadora();
    }

    @Test
    public void deveSomarDoisValores() {
        //cenario
        int a = 5;
        int b = 3;


        //ação
        int resultado = calc.somar(a, b);

        //test
        Assert.assertEquals(8, resultado);
    }

    @Test
    public void deveSubtrairDoisValores() {
        //cenario
        int a = 10;
        int b = 2;


        //ação
        int resultado = calc.subtrair(a, b);

        //teste
        Assert.assertEquals(8, resultado);
    }

    @Test
    public void deveDividirDoisValores() throws NaoPodeDividirPorZeroException {
        //cenario
        int a = 10;
        int b = 2;

        //ação
        int resultado = calc.dividir(a, b);

        //Test
        Assert.assertEquals(5, resultado);
    }

    @Test(expected = NaoPodeDividirPorZeroException.class)
    public void deveLancarExcecaoAoDividirPorZero() throws NaoPodeDividirPorZeroException {
        //cenario
        int a = 10;
        int b = 0;

        //ação
        int resultado = calc.dividir(a, b);

    }

}