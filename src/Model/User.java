package Model;

import java.security.Timestamp;
import java.util.Date;
public class User {
    private int id;
    private String player_username;
    private String player_password;
    private Timestamp play_createtime;

    public User() {
        this.id=id;
        this.player_password=player_password;
        this.play_createtime=play_createtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayer_username() {
        return player_username;
    }

    public void setPlayer_username(String player_username) {
        this.player_username = player_username;
    }

    public String getPlayer_password() {
        return player_password;
    }

    public void setPlayer_password(String player_password) {
        this.player_password = player_password;
    }

    public Timestamp getPlay_createtime() {
        return play_createtime;
    }

    public void setPlay_createtime(Timestamp play_createtime) {
        this.play_createtime = play_createtime;
    }

    public void setPlay_createtime(java.sql.Timestamp play_createtime) {
    }

    @Override
    public String toString(){
        return "User "+"id="+ id+"  player_username ="+player_username+"  player_password = "+player_password+
                " play_createtime = "+play_createtime;
    }
}
