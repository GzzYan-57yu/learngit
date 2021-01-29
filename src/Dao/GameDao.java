package Dao;

import Model.Poker;
import view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameDao {
    private String PokerNumber;
    private String PokerKinds;
    //private String game_user1name;
    private String game_winner_name;

    List<Poker> pokers=new ArrayList<>();
    List<Poker> pokerList=null;
    List<Poker> poker=null;
    Poker game_max_user1cards;
    Poker game_max_user2cards;
    public List<Poker> CreatePoker() {
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    PokerKinds = "黑桃";
                    break;
                case 1:
                    PokerKinds = "红桃";
                    break;
                case 2:
                    PokerKinds = "梅花";
                    break;
                case 3:
                    PokerKinds = "方片";
                    break;
                default:
                    System.out.println("不存在这种扑克花色");
            }
            for (int j = 1; j < 14; j++) {
                switch (j) {
                    case 13:
                        PokerNumber = "A";
                        break;
                    case 12:
                        PokerNumber = "K";
                        break;
                    case 11:
                        PokerNumber = "Q";
                        break;
                    case 10:
                        PokerNumber = "J";
                        break;
                    case 9:
                        PokerNumber = "10";
                        break;
                    case 8:
                        PokerNumber = "9";
                        break;
                    case 7:
                        PokerNumber = "8";
                        break;
                    case 6:
                        PokerNumber = "7";
                        break;
                    case 5:
                        PokerNumber = "6";
                        break;
                    case 4:
                        PokerNumber = "5";
                        break;
                    case 3:
                        PokerNumber = "4";
                        break;
                    case 2:
                        PokerNumber = "3";
                        break;
                    case 1:
                        PokerNumber = "2";
                        break;
                    default:
                        System.out.println("不存在这种扑克数字");
                        break;
                }
                pokers.add(new Poker(PokerKinds, PokerNumber));
            }
            for (int k = 0; k < pokers.size(); k++) {
                System.out.println(pokers.get(k).toString());
            }
        }
        return  pokers;
    }

    public List<Poker> ShuttlePoker() {
        pokerList=new ArrayList<>();
        Collections.shuffle(pokers);
        for (int i = 0; i < pokers.size(); i++) {
            pokerList.add(pokers.get(i));
            System.out.println("add success!");
        }
        for (int i = 0; i < pokerList.size(); i++) {
            System.out.println(pokerList.get(i).toString());
        }
        return pokerList;
    }

    public List<Poker> deal() {
        poker=new ArrayList<>();
        if (pokerList != null) {
            for (int i = 0; i < 4; i++) {
                poker.add(pokerList.get(i));
                System.out.println("add success!");
                for (int k = 0; k < poker.size(); k++) {
                    System.out.println(poker.get(k).toString());
                }
            }
        }else {
            System.out.println("empty!");
        }
        return poker;
    }

    public void compare() {
        GameDao dao = new GameDao();
        if (poker != null) {
            dao.CompareNumber(poker.get(0), poker.get(2));
            if (poker.get(0).getPokerNumber() == poker.get(2).getPokerNumber()) {
                dao.CompareKinds(poker.get(0), poker.get(2));
            }
            dao.CompareNumber(poker.get(1), poker.get(3));
            if (poker.get(1).getPokerNumber() == poker.get(3).getPokerNumber()) {
                dao.CompareKinds(poker.get(1), poker.get(3));
            }
            dao.CompareNumber(game_max_user1cards, game_max_user2cards);
            if (game_max_user1cards.getPokerNumber() == game_max_user2cards.getPokerKinds()) {
                dao.CompareKinds(game_max_user1cards, game_max_user2cards);
            }
            System.out.println("手牌1:"+poker.get(0)+poker.get(2));
            System.out.println("手牌2:" + poker.get(1)+poker.get(3));
        }else {
            System.out.println("empty!");
        }
    }


    public Poker CompareNumber(Poker game_user1cards,Poker game_user2cards){
        Poker game_max_user2cards=new Poker(PokerKinds,PokerNumber);
        int num1=0,num2 = 0;
        switch (poker.get(0).getPokerNumber()){
            case "A":
                num1=13;
                break;
            case "K":
                num1=12;
                break;
            case "Q":
                num1=11;
                break;
            case "J":
                num1=10;
                break;
            case "10":
                num1=9;
                break;
            case "9":
                num1=8;
                break;
            case "8":
                num1=7;
                break;
            case "7":
                num1=6;
                break;
            case "6":
                num1=5;
                break;
            case "5":
                num1=4;
                break;
            case "4":
                num1=3;
                break;
            case "3":
                num1=2;
                break;
            case "2":
                num1=1;
                break;
            default:
                System.out.println("扑克出错");
        }

        switch (poker.get(2).getPokerNumber()){
            case "A":
                num2=13;
                break;
            case "K":
                num2=12;
                break;
            case "Q":
                num2=11;
                break;
            case "J":
                num2=10;
                break;
            case "10":
                num2=9;
                break;
            case "9":
                num2=8;
                break;
            case "8":
                num2=7;
                break;
            case "7":
                num2=6;
                break;
            case "6":
                num2=5;
                break;
            case "5":
                num2=4;
                break;
            case "4":
                num2=3;
                break;
            case "3":
                num2=2;
                break;
            case "2":
                num2=1;
                break;
            default:
                System.out.println("扑克出错");
                break;
        }
        if(num1>num2){
            game_max_user2cards=poker.get(0);
            game_winner_name="你";
        }
        if (num1<num2){
            game_max_user2cards=poker.get(2);
            game_winner_name="wang";
        }
        return game_max_user2cards;
    }
    public Poker CompareKinds(Poker game_user1cards,Poker game_user2cards) {
        Poker game_max_user1cards = new Poker(PokerKinds, PokerNumber);
        int num1 = 0, num2 = 0;
        switch (poker.get(0).getPokerKinds()) {
            case "黑桃":
                num1 = 4;
                break;
            case "红桃":
                num1 = 3;
                break;
            case "梅花":
                num1 = 2;
                break;
            case "方片":
                num1 = 1;
                break;
            default:
                System.out.println("扑克出错");
                break;
        }

        switch (poker.get(2).getPokerKinds()) {
            case "黑桃":
                num2 = 4;
                break;
            case "红桃":
                num2 = 3;
                break;
            case "梅花":
                num2 = 2;
                break;
            case "方片":
                num2 = 1;
                break;
            default:
                System.out.println("扑克出错");
                break;
        }

        if (num1 > num2) {
            game_max_user1cards = game_user1cards;
            game_winner_name = "你";
        } else if (num1 < num2) {
            game_max_user1cards = game_user2cards;
            game_winner_name = "wang";
        } else {
            System.out.println("wrong!扑克牌不存在");
        }
        return game_max_user1cards;
    }
}
