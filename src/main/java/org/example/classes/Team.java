package org.example.classes;

import org.example.classes.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private String _id;
    private String teamName;

    private int wins;

    private List<String> playerList;

    private List<String> matchList;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public List<String> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<String> playerList) {
        this.playerList = playerList;
    }

    public List<String> getMatchList() {
        return matchList;
    }

    public void setMatchList(List<String> matchList) {
        this.matchList = matchList;
    }


    public Team(String _id, String teamName) {
        this._id = _id;
        this.teamName = teamName;
    }
}
