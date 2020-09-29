package suites;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import servicos.CalculadoraTest;
import servicos.CalculoValorLocacaoTest;
import servicos.LocacaoServiceTest;

//Suites de testes de uma forma geral não é uma boa prática
//haja visto que migraremos para uma esteira de testes
//sendo que neste caso a esteira executarria duas vezes a mesma
//bateria de testes

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CalculadoraTest.class,
        CalculoValorLocacaoTest.class,
        LocacaoServiceTest.class
})
public class SuitesExecucao {

    @BeforeClass
    public static void before(){
        System.out.println("BeforClass Suite");
    }

    @AfterClass
    public static void after(){
        System.out.println("AfterClass Suite");
    }
}
