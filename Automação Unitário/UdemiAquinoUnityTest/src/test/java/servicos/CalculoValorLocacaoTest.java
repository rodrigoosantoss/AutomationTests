package servicos;

import builders.FilmeBuilder;
import builders.UsuarioBuilder;
import entidades.Filme;
import entidades.Locacao;
import entidades.Usuario;
import exceptions.FilmeSemEstoqueException;
import exceptions.LocadoraException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import servicos.LocacaoService;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

// DataDrivenTest - Qtde de testes executados foi exatamente o mesmo nro de linhas de dados informados

@RunWith(Parameterized.class)
public class CalculoValorLocacaoTest {
    private LocacaoService service;

    //parametro de valor 0
    @Parameterized.Parameter
    public List<Filme> filmes;

    //parametro de valor 1
    @Parameterized.Parameter(value = 1)
    public Double valorLocacao;

    //parametro de valor 2
    @Parameterized.Parameter(value = 2)
    public String cenario;

    @Before
    public void setup(){
        service = new LocacaoService();
    }

    //List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 2, 5.0)); Susbtituido pelo Builder debaixo
    //List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilme().agora());

    /*Substituido pelo Builder abaixo
    private static Filme filme1 = new Filme("Filme1", 2, 4.0);*/
    private static Filme filme1 = FilmeBuilder.umFilme().agora();
    private static Filme filme2 = FilmeBuilder.umFilme().agora();
    private static Filme filme3 = FilmeBuilder.umFilme().agora();
    private static Filme filme4 = FilmeBuilder.umFilme().agora();
    private static Filme filme5 = FilmeBuilder.umFilme().agora();
    private static Filme filme6 = FilmeBuilder.umFilme().agora();

    //conjunto de dados que deverá ser testado (por isso que o método deve ser estático
    //como referencia a ser impresso no resultado do teste aparecerá o "cenario" = parametro #2
    @Parameterized.Parameters (name = "{2}")
    public static Collection<Object[]> getParametros(){
        return Arrays.asList(new Object[][]{
                //linha #1
            {Arrays.asList(filme1, filme2, filme3), 11.0, "3 Filmes 25%"},
                //linha #2
                {Arrays.asList(filme1, filme2, filme3, filme4), 13.0, "4 Filmes 50%"},
                //linha #3
                {Arrays.asList(filme1, filme2, filme3, filme4, filme5), 14.0, "5 Filmes 75%"},
                //linha #4
                {Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6), 14.0, "6 Filmes 100%"}
        });

    }

    @Test
    public void deveCalcularValorDaLocacaoConsiderandoDescontos() throws FilmeSemEstoqueException, LocadoraException {
        //cenario
        Usuario usuario = UsuarioBuilder.umUsuario().agora();
        //Usuario usuario = new Usuario("Usuario 1"); substituido pelo builder

        //ação
        Locacao resultado = service.alugarFilme(usuario, filmes);

        //verificação
        Assert.assertThat(resultado.getValor(), is(valorLocacao));
    }

    @Test
    public void imprimeValorLocacao(){
        System.out.println(valorLocacao);
    }

}
