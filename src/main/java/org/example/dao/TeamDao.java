package org.example.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.example.classes.Team;

import static com.mongodb.client.model.Filters.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


public class TeamDao {
    private MongoCollection<Document> teamCollection;
    private ObjectMapper mapper;

    public TeamDao(MongoCollection<Document> team){
        this.teamCollection= team;
        mapper = new ObjectMapper();
    }

    public void push(String teamName){
        try{
            InsertOneResult result = teamCollection.insertOne(new Document()
                    .append("_id", UUID.randomUUID().toString())
                    .append("teamName",teamName)
                    .append("wins",0)
                    .append("playerList", Arrays.asList(new String[]{}))
                    .append("matchList", Arrays.asList(new String[]{}))
            );

            System.out.println("the id of the inserted team is: "+ result.getInsertedId());

        }catch(Exception e){
            e.printStackTrace();
        }

        //add players manually
    }

    public String getIdByName(String teamName){

        try{
            Document doc = teamCollection.find(eq("teamName",teamName)).first();
            if(doc==null) return "NULL";
            Team team = mapper.readValue(doc.toJson(),Team.class);
            return team.get_id();

        }catch(Exception e){
            e.printStackTrace();
        }
        return "NULL";
    }

    public void updateMatchList(String _id, String matchId){
        try{
            Document doc = teamCollection.find(eq("_id",_id)).first();
            Team team = mapper.readValue(doc.toJson(),Team.class);

            List<String> matchList = team.getMatchList();
            matchList.add(matchId);
            Bson updates = Updates.combine(
                    Updates.set("matchList",matchList)
            );

            UpdateResult result = teamCollection.updateOne(doc,updates);
            System.out.println("documents updated: ?  "+result.getModifiedCount());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
