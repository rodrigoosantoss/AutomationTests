package builders;

import entidades.Usuario;

public class UsuarioBuilder {

    private Usuario usuario;

    /*ficou privado pra evitar de qquer um criar uma nova instancia do builder
    externamente ao proprio Builder*/
    private UsuarioBuilder() {}

    /*para que possa ser acessado externamente sem a necessidade de instancia*
    Será porta de entrada
    este metodo esta criando a instancia do Builder
    inicializando a construção do usuário
     */
    public static UsuarioBuilder umUsuario(){
        UsuarioBuilder builder = new UsuarioBuilder();
        builder.usuario = new Usuario();
        builder.usuario.setNome("Usuario 1");
        return builder;
    }
    public Usuario agora(){
        return usuario;
    }

}
