package util;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.Map;

import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoDBConnection {

	private static CodecRegistry pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
			fromProviders(PojoCodecProvider.builder().automatic(true).build()));

	//TODO: modificar URI para api da HOMOLOGAÇÃO
	public static MongoClient makeConnection() {
		MongoClient client = new MongoClient(new MongoClientURI("mongodb://localhost:27017/"));
		return client;
	}

	public static MongoDatabase connectToDatabase(String databaseName) {
		MongoDatabase database = makeConnection().getDatabase(databaseName);
		database.withCodecRegistry(pojoCodecRegistry);
		return database;
	}
	
	public static void closeConnection() {
		if(makeConnection() != null) {
			makeConnection().close();
		}
	}
	
	public static void insertPojo(String dbName,String collectionName, Map<String, Object> mapper) {
		try {
			Document document = new Document(mapper);
			MongoDatabase db = connectToDatabase(dbName);
			MongoCollection<Document> collection = db.getCollection(collectionName).withCodecRegistry(pojoCodecRegistry);					
		
			collection.insertOne(document);
			System.out.println("Documento inserido no Banco de Dados com êxito!");
		} catch (Exception e) {
			System.err.println("Erro ao inserir documento no Banco de dados.\n"
					+ "Causa: "+e.getCause().getMessage());
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}

	public static void readAllDocuments(String dbName, String collectionName){
		try {
			MongoDatabase db = connectToDatabase(dbName);
			db.getCollection(collectionName).find();

			//TODO: finalizar operação de leitura do banco de dados (get all)
		}catch (Exception e){
			Report.logFail("Falhou ao obter dados do Banco de dados.");
			e.printStackTrace();
		}
	}

	public static void readDocument(String dbName, String collectionName){
		try {
			MongoDatabase db = connectToDatabase(dbName);
			db.getCollection(collectionName);

			//TODO: finalizar operação de leitura do banco de dados (por filtro)
		}catch (Exception e){
			Report.logFail("Falha ao obter dados do Banco de Dados.");
			e.printStackTrace();
		}
	}

}
