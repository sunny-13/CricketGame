package org.example.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;

import java.util.UUID;

import static com.mongodb.client.model.Filters.*;

public class PlayerDao {

    private MongoCollection<Document> playerCollection;
    private ObjectMapper mapper;
    public PlayerDao(MongoCollection<Document> player){
        this.playerCollection = player;
        mapper = new ObjectMapper();
    }

    public void push(String playerName, String teamId){
        try{
            InsertOneResult result = playerCollection.insertOne(new Document()
                    .append("_id", UUID.randomUUID().toString())
                    .append("playerName",playerName)
                    .append("teamId",teamId));
            System.out.println("player added with id: "+result.getInsertedId());
        }catch(Exception e){
            e.printStackTrace();
        }


    }

    public String getIdByName(String playerName){

        try{
            Document doc = playerCollection.find(eq("playerName",playerName)).first();
            if(doc==null) return "NULL";
            org.example.classes.Player p = mapper.readValue(doc.toJson(),org.example.classes.Player.class);
            return p.get_id();


        }catch(Exception e){
            e.printStackTrace();
        }
        return "NULL";
    }

}
