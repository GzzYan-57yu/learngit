package Model;

import java.sql.Timestamp;

public class Recordy {
    private int game_ID;
    private Timestamp game_begintime;
    private Timestamp game_exittime;
    private String game_user1name;
    private String game_user2name;
    private String game_winner_name;
    private String game_user1cards;
    private String game_user2cards;
    private String game_max_user1cards;
    private String game_max_user2cards;


    public int getGame_ID() {
        return game_ID;
    }

    public void setGame_ID(int game_ID) {
        this.game_ID = game_ID;
    }

    public Timestamp getGame_begintime() {
        return game_begintime;
    }

    public Timestamp getGame_exittime() {
        return game_exittime;
    }

    public String getGame_user1name() {
        return game_user1name;
    }

    public void setGame_user1name(String game_user1name) {
        this.game_user1name = game_user1name;
    }

    public String getGame_user2name() {
        return game_user2name;
    }

    public void setGame_user2name(String game_user2name) {
        this.game_user2name = game_user2name;
    }

    public String getGame_winner_name() {
        return game_winner_name;
    }

    public void setGame_winner_name(String game_winner_name) {
        this.game_winner_name = game_winner_name;
    }

    public String getGame_user1cards() {
        return game_user1cards;
    }

    public void setGame_user1cards(String game_user1cards) {
        this.game_user1cards = game_user1cards;
    }

    public String getGame_user2cards() {
        return game_user2cards;
    }

    public void setGame_user2cards(String game_user2cards) {
        this.game_user2cards = game_user2cards;
    }

    public String getGame_max_user1cards() {
        return game_max_user1cards;
    }

    public void setGame_max_user1cards(String game_max_user1cards) {
        this.game_max_user1cards = game_max_user1cards;
    }

    public String getGame_max_user2cards() {
        return game_max_user2cards;
    }

    public void setGame_max_user2cards(String game_max_user2cards) {
        this.game_max_user2cards = game_max_user2cards;
    }

    @Override
    public String toString(){
        return "Recordy "+" game_ID= "+ game_ID+" game_begintime= "+game_begintime+" game_exittime = "+game_exittime+
                " game_user1name= "+game_user1name+" game_user2name= "+game_user2name+
                " game_winner_name= "+game_winner_name+
                " game_user1cards= "+game_user1cards+" game_user2cards= "+
                " game_max_user1cards= "+game_max_user1cards+" game_max_user2cards= "+game_max_user2cards;
    }

    public void setGame_begintime(java.sql.Timestamp game_begintime) {
    }

    public void setGame_exittime(java.sql.Timestamp game_exittime) {
    }
}

