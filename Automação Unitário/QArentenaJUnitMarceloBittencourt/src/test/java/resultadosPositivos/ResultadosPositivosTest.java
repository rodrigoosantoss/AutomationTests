package resultadosPositivos;

import dto.Calculadora;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ResultadosPositivosTest {

    static Calculadora calc;

    @BeforeAll
    static void inicializaCalculadora(){
        calc = new Calculadora();
        System.out.println("Instanciou Calculadora");
    }


    @Test
    @DisplayName("Soma positivo e negativo")
    @Order(2)
    void testSomaPositivoENegativo(){
        assertThat("Resultado soma Positivo e Negativo", calc.soma(5, -2), is(3));
        System.out.println("Executou Soma Positivo e Negativo - teste #2");

    }

    @Test
    @DisplayName("Teste Soma Positivos")
    @Order(1)
    void testSomaPositivos(){
        Calculadora calc = new Calculadora();
//        System.out.println(calc.soma(2, 3));
        Assertions.assertEquals(5, calc.soma(2, 3), "Resultado da soma Junit");
        assertThat("Resultado da soma JHamcresthew", calc.soma(2, 3), is(5));
        System.out.println("Executou Soma de Positivo - teste #1");
    }

    int v1, v2, r;

    @ParameterizedTest
    @CsvFileSource(resources = "/dados.csv", numLinesToSkip = 1, delimiter = ';')
    void testSomaViaMassaArquivoCSV(String valor1, String valor2, String resultado){
        v1 = Integer.parseInt(valor1);
        v2 = Integer.parseInt(valor2);
        r = Integer.parseInt(resultado);
        System.out.println("TESTE - CSV --> ["+v1+"] - ["+v2+"] - ["+r+"]");
        assertThat(calc.soma(v1, v2), is(r));

    }
}
