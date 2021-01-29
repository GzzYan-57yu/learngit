package Model;

public class Poker {
    private String pokerKinds;
    private String pokerNumber;

    public Poker(String pokerKinds, String pokerNumber) {
        this.pokerKinds=pokerKinds;
        this.pokerNumber=pokerNumber;
    }

    public String getPokerKinds() {
        return pokerKinds;
    }

    public void setPokerKinds(String pokerKinds) {
        this.pokerKinds = pokerKinds;
    }

    public String getPokerNumber() {
        return pokerNumber;
    }

    public void setPokerNumber(String pokerNumber) {
        this.pokerNumber = pokerNumber;
    }

    @Override
    public String toString(){
        return "pokers"+" 扑克牌为= "+"PokerKinds+PokerNumber="+pokerKinds+pokerNumber;
    }
}
