package core;

import io.restassured.http.ContentType;

/**
 * Utilizei esta Interface para definir informaçoes e valores
 * que nortearão o projeto
 *
 */
public interface Constants {

	
	/**
	 * Defino o tipo de formato que utilizarei
	 */
	public static ContentType API_CONTENT_TYPE = ContentType.JSON;
	
	/**
	 * Seto o tempo maximo de espera de cada requisição
	 */
	public static Long MAX_TIME_OUT = 5000L;
	
}