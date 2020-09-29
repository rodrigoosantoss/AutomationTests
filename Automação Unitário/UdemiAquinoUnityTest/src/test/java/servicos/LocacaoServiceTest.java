package servicos;

import builders.FilmeBuilder;
import builders.UsuarioBuilder;
import entidades.Filme;
import entidades.Locacao;
import entidades.Usuario;
import exceptions.FilmeSemEstoqueException;
import exceptions.LocadoraException;
import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;
import servicos.LocacaoService;
import servicos.matchers.DiaSemanaMatcher;
import servicos.matchers.MatchersProprios;
import utils.DataUtils;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static utils.DataUtils.isMesmaData;
import static utils.DataUtils.obterDataComDiferencaDias;

public class LocacaoServiceTest {

    private LocacaoService service; //transformando o método em global pra que o Before e After funcionem

    private static int contador;

    public static final int getContador(){
        return contador;
    }

    public static final void incrementador(){
        contador++;
    }

    @Rule
    public ErrorCollector erro = new ErrorCollector();

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void setup(){
        System.out.println("Inicializando... a instância...");
        /*ao inicializar o Junit zera os valores das variáveis
        a forma existente do JUnit nao zerar os valores das variáveis é determinar que ela é
        static*/
        service = new LocacaoService();
        incrementador();
        System.out.println("Mais um contador"); //Todas estas impressões são desnecessárias no Junit
    }

    @After
    public void tearDown(){
        System.out.println("After");//Todas estas impressões são desnecessárias no Junit
    }

    @BeforeClass
    public static void setupClass(){
        System.out.println("Inicializando... a instância...BeforeClass");

   }

    @AfterClass
    public static void tearDownClass(){
        System.out.println("AfterClass");
        System.out.println("Qtde dos contador = "+contador);
    }

    @Test
    public void deveAlugarFilme() throws Exception {
        Assume.assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY) );

        //cenario

        Usuario usuario = UsuarioBuilder.umUsuario().agora();
        //Usuario usuario = new Usuario("Usuario 1"); substituido pelo builder
        //List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0)); Susbtituido pelo Builder debaixo
        List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilme().comValor(5.0).agora());
        System.out.println("Teste1 - executou");//Todas estas impressões são desnecessárias no Junit

        //acao
        Locacao locacao = service.alugarFilme(usuario, filmes);


            //verificacao
            //System.out.println(locacao.getValor()); //Este método não é auto verificável por isso criamos a segunda linha
            //System.out.println(locacao.getValor() == 5.0);
            //Assert.assertTrue(locacao.getValor()==5.0);
            //Assert.assertThat(locacao.getValor(), CoreMatchers.is(5.0));
            erro.checkThat(locacao.getValor(), is(5.0));
            erro.checkThat(locacao.getDataRetorno(), MatchersProprios.ehHojeComDiferencaDias(1));
//            erro.checkThat(locacao.getDataRetorno(), MatchersProprios.ehHoje());
            System.out.println("Verificou - se o valor da locação é R$ 5,00");//Todas estas impressões são desnecessárias no Junit

            //System.out.println(locacao.getDataLocacao()); //Este método não é auto verificável por isso criamos a segunda linha
            //System.out.println(isMesmaData(locacao.getDataLocacao(), new Date())); com a anotação @Test melhor pratica é assertion
            //Assert.assertTrue(isMesmaData(locacao.getDataLocacao(), new Date()));
            //Assert.assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), CoreMatchers.is(true));
            erro.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
            System.out.println("Verificou se a data da locação é valida");//Todas estas impressões são desnecessárias no Junit

            //System.out.println(locacao.getDataRetorno());//Este método não é auto verificável por isso criamos a segunda linha
            //System.out.println(isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
            //Assert.assertTrue(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)));
            erro.checkThat(isMesmaData(locacao.getDataRetorno(), obterDataComDiferencaDias(1)), is(true));
            System.out.println("Verificou se a data da entrega é valida");//Todas estas impressões são desnecessárias no Junit

        }

            @Test (expected= FilmeSemEstoqueException.class) //funciona qdo apenas a execeção importa
        public void deveLancarExcecaoAoAlugarfilmesSemEstoque() throws Exception{
            //cenario
            /*LocacaoService service = new LocacaoService();
                Filme filme = new Filme("Filme 1", 0, 5.0);*/
                Usuario usuario = UsuarioBuilder.umUsuario().agora();
                //Usuario usuario = new Usuario("Usuario 1"); substituido pelo builder
                //List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0)); Susbtituido pelo Builder debaixo
                List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilmeSemEstoque().agora());

            //ação
            service.alugarFilme(usuario, filmes);
        }

        @Test//se precisar da mensagem vai precisar da forma robusta de construção da exception
        public void testLocacao_filmesSemEstoque2() {
            //cenario
            LocacaoService service = new LocacaoService();
            Usuario usuario = UsuarioBuilder.umUsuario().agora();
            //Usuario usuario = new Usuario("Usuario 1"); substituido pelo builder
            //Filme filmes = new Filme("Filme 1", 0, 5.0);
            //List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0)); Susbtituido pelo Builder debaixo
            List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilmeSemEstoque().agora());
            try {
               /* service.alugarFilme(usuario, filmes);
                service.alugarFilme(null, filmes);*/
                service.alugarFilme(usuario, filmes);
            } catch (LocadoraException | FilmeSemEstoqueException e) {
               // Assert.assertThat(e.getMessage(), null);
               // Assert.assertThat(e.getMessage(), null);
            }
        }

        @Test
        public void testLocacao_filmesSemEstoque3() throws Exception{
            //cenario
            LocacaoService service = new LocacaoService();
            Usuario usuario = UsuarioBuilder.umUsuario().agora();
            //Usuario usuario = new Usuario("Usuario 1"); substituido pelo builder
            //List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0)); Susbtituido pelo Builder debaixo
            List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilme().semEstoque().agora());
            //Filme filme = new Filme("Filme 1", 0, 5.0);

            exception.expect(Exception.class);
            //exception.expectMessage(null);
            //exception.expectMessage("Filme sem estoque test2");

            //ação
            service.alugarFilme(usuario, filmes);
        }

        @Test
        public void deveAlugarFilmeSomenteEspecificandoUsuario() throws FilmeSemEstoqueException {
            //cenario
            //LocacaoService service = new LocacaoService(); Levado para instanciar de forma global e unico no before
            //List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0)); Susbtituido pelo Builder debaixo
            List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilme().agora());
            //Usuario usuario = new Usuario("Usuario 1"); teste simulará usuário vazio


            //ação
            try {
                service.alugarFilme(null, filmes);
                Assert.fail();

            } catch (LocadoraException e) {
               Assert.assertThat(e.getMessage(), is("Campo usuário vazio"));
            }

            System.out.println("executou Forma robusta");//Todas estas impressões são desnecessárias no Junit
            System.out.println("Verificou comportamento do usuário nulo");//Todas estas impressões são desnecessárias no Junit
        }

        @Test //JUnir faz os tratamentos das Exceptions
        public void testLocacao_filmeVazio() throws FilmeSemEstoqueException, LocadoraException {
            //cenario
            //LocacaoService service = new LocacaoService(); levamos pra instanciar de forma global e no Before
            Usuario usuario = UsuarioBuilder.umUsuario().agora();
            //Usuario usuario = new Usuario("Usuario 1"); substituido pelo builder
            //Filme filme = new Filme (null, 1, 4.0)

            exception.expect(LocadoraException.class);
            exception.expectMessage("Campo filme vazio");
            //acao
            service.alugarFilme(usuario, null);

            System.out.println("executou Forma nova");//Todas estas impressões são desnecessárias no Junit
            System.out.println("Verificou comportamento do campo filem vazio");//Todas estas impressões são desnecessárias no Junit
        }

        @Test
        public void devePagar75PcNoFilme3() throws FilmeSemEstoqueException, LocadoraException {
        //cenario
            Usuario usuario = UsuarioBuilder.umUsuario().agora();
            //Usuario usuario = new Usuario("Usuario 1"); substituido pelo builder

        List<Filme> filmes = Arrays.asList(new Filme("Filme1", 2, 4.0), new Filme("Filme2", 2, 4.0), new Filme("Filme3", 2, 4.0));

        //ação
        Locacao resultado = service.alugarFilme(usuario, filmes);

        //verificação
            Assert.assertThat(resultado.getValor(), is((11.0)));
        }

    @Test
    public void devePagar50PcNoFilme4() throws FilmeSemEstoqueException, LocadoraException {
        //cenario
        Usuario usuario = UsuarioBuilder.umUsuario().agora();
        //Usuario usuario = new Usuario("Usuario 1"); substituido pelo builder
        List<Filme> filmes = Arrays.asList(new Filme("Filme1", 2, 4.0), new Filme("Filme2", 2, 4.0), new Filme("Filme3", 2, 4.0), new Filme("Filme4", 2, 4.0));

        //ação
        Locacao resultado = service.alugarFilme(usuario, filmes);

        //verificação
        Assert.assertThat(resultado.getValor(), is((13.0)));
    }

    @Test
    public void devePagar25PcNoFilme5() throws FilmeSemEstoqueException, LocadoraException {
        //cenario
        //4+4+3+2+1=
        Usuario usuario = UsuarioBuilder.umUsuario().agora();
        //Usuario usuario = new Usuario("Usuario 1"); substituido pelo builder
        List<Filme> filmes = Arrays.asList(new Filme("Filme1", 2, 4.0),
                new Filme("Filme2", 2, 4.0),
                new Filme("Filme3", 2, 4.0),
                new Filme("Filme4", 2, 4.0),
                new Filme("Filme5", 2, 4.0));

        //ação
        Locacao resultado = service.alugarFilme(usuario, filmes);

        //verificação
        Assert.assertThat(resultado.getValor(), is((14.0)));
    }
    @Test
    public void devePagarZeroNoFilme6() throws FilmeSemEstoqueException, LocadoraException {
        //cenario
        //4+4+3+2+1+0=14
        Usuario usuario = UsuarioBuilder.umUsuario().agora();
        //Usuario usuario = new Usuario("Usuario 1"); substituido pelo builder
        List<Filme> filmes = Arrays.asList(new Filme("Filme1", 2, 4.0),
                new Filme("Filme2", 2, 4.0),
                new Filme("Filme3", 2, 4.0),
                new Filme("Filme4", 2, 4.0),
                new Filme("Filme5", 2, 4.0),
                new Filme("Filme6", 2, 4.0));

        //ação
        Locacao resultado = service.alugarFilme(usuario, filmes);

        //verificação
        Assert.assertThat(resultado.getValor(), is((14.0)));
    }

    @Test
    public void deveDevolverFilmeNaSegundaAoAlugarNoSabado() throws FilmeSemEstoqueException, LocadoraException {
        Assume.assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));


        //cenario
        Usuario usuario = UsuarioBuilder.umUsuario().agora();
        //Usuario usuario = new Usuario("Usuario 1"); substituido pelo builder
        List<Filme> filmes = Arrays.asList(new Filme("Filme1", 1, 5.0));

        //ação
        Locacao retorno = service.alugarFilme(usuario, filmes);

        //verificação
        boolean ehsegunda = DataUtils.verificarDiaSemana(retorno.getDataRetorno(), Calendar.MONDAY);
        Assert.assertTrue(ehsegunda);
        Assert.assertThat(retorno.getDataRetorno(), new DiaSemanaMatcher(Calendar.MONDAY));
    }
/*
    public static void main(String[] args) {
        new BuilderMaster().gerarCodigoClasse(Locacao.class);
    }*/

}

