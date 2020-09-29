import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.junit.runners.MethodSorters;

import java.lang.annotation.Target;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrdemTest {

    public static int contador = 0;

    @Test
    public void firstTest(){
    contador = 1;
    }

    @Test
    public void secondTest(){
        Assert.assertEquals(1, contador);
    }

    /*@Test UMA POSSIBILIDADE DE ORDENAR OS TESTES, MAS NÃO É A MELHOR...
    public void TestGeral(){
        inicia();
        verifica();
    }*/
}
