package org.example.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import org.example.classes.ScoreCard;
import org.bson.Document;
import static com.mongodb.client.model.Filters.*;


import java.util.ArrayList;
import java.util.List;


public class ScoreCardDao {
    private MongoCollection<Document> scoreCardCollection;
    private ObjectMapper mapper;

    public ScoreCardDao(MongoCollection<Document> scoreCardCollection){
        this.scoreCardCollection = scoreCardCollection;
        mapper = new ObjectMapper();
    }

    public void addScoreCard(ScoreCard scoreCard){

        try{
            InsertOneResult result = scoreCardCollection.insertOne(new Document()
                    .append("_id",scoreCard.get_id())
                    .append("teamId",scoreCard.getTeamId())
                    .append("matchId",scoreCard.getMatchId())
                    .append("wicketsDown",scoreCard.getWicketsDown())
                    .append("totalRuns",scoreCard.getTotalRuns())
                    .append("runScored", scoreCard.getRunScored())
                    .append("win",scoreCard.isWin()));

            System.out.println("ScoredCard inserted with id: "+result.getInsertedId());

        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public ScoreCard getScoreCardByMatchIdTeamId(String matchId, String teamId){

        try{
            Document doc = scoreCardCollection.find(and(eq("teamId",teamId),eq("matchId",matchId))).first();
            ScoreCard scoreCard = mapper.readValue(doc.toJson(),ScoreCard.class);
            return scoreCard;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public List<ScoreCard> getAllScoreCardsByTeamId(String teamId){
        List<ScoreCard> result = new ArrayList<>();

        try {
            FindIterable<Document> listDocument = scoreCardCollection.find(eq("teamId",teamId));
            for(Document doc : listDocument){
                result.add(mapper.readValue(doc.toJson(),ScoreCard.class));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
