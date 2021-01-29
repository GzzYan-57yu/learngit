package Control;

import Dao.GameDao;
import Dao.RecordyDao;
import Dao.UserDao;
import Model.Poker;
import view.View;
import Model.User;
import Model.Recordy;


import java.util.ArrayList;
import java.util.List;

public class GameAction {
    private String game_user1name;
    private String game_winner_name;
    private String game_user1cards;
    private String game_user2cards;

    public List<Poker> create(){
        GameDao dao=new GameDao();
        List<Poker> pokers=dao.CreatePoker();
        for (int i = 0; i < pokers.size(); i++) {
                System.out.println(pokers.get(i).toString());
        }
        return  pokers;
    }

    public List<Poker> shuttle() throws Exception {
        GameDao dao=new GameDao();
        List<Poker> pokerList=dao.ShuttlePoker();
        for (int i = 0; i < pokerList.size(); i++) {
            System.out.println(pokerList.get(i).toString());
        }
        return pokerList;
    }

    public List<Poker> deal(){
        GameDao dao=new GameDao();
        List<Poker> pokerList=new ArrayList<>();
        List<Poker> poker=new ArrayList<>();
        System.out.println("玩家"+game_user1name+"拿牌"+
                "玩家"+"wang"+"拿牌"+"玩家"+game_user1name+"拿牌"+"玩家"+"wang"+"拿牌"+"");
        poker.add(pokerList.get(0));
        poker.add(pokerList.get(1));
        poker.add(pokerList.get(2));
        poker.add(pokerList.get(3));
        return poker;
    }

    public void compare(){
        GameDao dao=new GameDao();
        Poker game_user1cards = null;
        Poker game_user2cards = null;
        dao.CompareNumber(game_user1cards,game_user2cards);
        if(game_user1cards.getPokerNumber()==game_user2cards.getPokerNumber()){
            dao.CompareKinds(game_user1cards,game_user2cards);
        }
        Poker game_max_user1cards=game_user1cards;
        Poker game_max_user2cards=game_user2cards;
        System.out.println("玩家："+game_user1name+"的最大手牌为"+"game_max_user1cards");
        System.out.println("玩家："+"wang"+"的最大手牌为"+"game_max_user2cards");
        dao.CompareNumber(game_max_user1cards,game_max_user2cards);
        if(game_max_user1cards.getPokerNumber()==game_max_user2cards.getPokerKinds()){
            dao.CompareKinds(game_max_user1cards,game_max_user2cards);
        }
        System.out.println("玩家："+game_winner_name+"获胜");
        System.out.println("玩家"+game_user1name+" 的手牌为"+game_user1cards);
        System.out.println("玩家"+"wang"+" 的手牌为"+game_user2cards);
    }

    /*public Poker comNums(Poker poker1,Poker poker2){
        GameDao dao=new GameDao();
        Poker game_max_user1cards=new Poker(poker1.getPokerNumber(), poker2.getPokerNumber());
        dao.CompareNumber(poker1,poker2);
        if(poker1.getPokerNumber()==poker2.getPokerNumber()){
            dao.CompareKinds(poker1,poker2);
        }
        return game_max_user1cards;
    }

    public Poker comKinds(Poker poker1, Poker poker2){
        Poker game_max_user2cards=new Poker(poker1.getPokerKinds(), poker2.getPokerKinds());
        GameDao dao=new GameDao();
        dao.CompareKinds(poker1,poker2);
        return game_max_user2cards;
    }*/
}
