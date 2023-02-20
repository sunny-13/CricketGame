package org.example.classes;

import java.util.List;

public class Player {

    private String _id;
    private String playerName;
    private String teamId;


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }


    public Player(String _id, String playerName, String teamId) {
        this._id = _id;
        this.playerName = playerName;
        this.teamId = teamId;
    }

    public  Player(){

    }
}
