package test;

import Control.RecordyAction;
import Model.Recordy;

public class TestRecordsAction {
    public static void main(String[] args) throws Exception {
        RecordyAction recordyAction = new RecordyAction();

        /*查询
        List<Record> records = recordAction.query();

        for (int i = 0; i < records.size(); i++) {
            System.out.println(records.get(i).getGame_ID() + "" +
                    records.get(i).getGame_user1name());
        }*/

        /*增加
        Recordy re=new Recordy();
        re.setGame_ID(3);
        re.setGame_user1name("zhao");
        re.setGame_user2name("wang");
        re.setGame_winner_name("wang");
        re.setGame_user1cards("heart3,club4");
        re.setGame_user2cards("diamondA,club6");
        re.setGame_max_user1cards("club4");
        re.setGame_max_user2cards("diamondA");
        recordyAction.add(re);*/

        /*修改
        Recordy r=new Recordy();
        r.setGame_ID(3);
        r.setGame_user1name("zhou");
        r.setGame_user2name("yu");
        r.setGame_winner_name("yu");
        r.setGame_user1cards("t8,t6");
        r.setGame_user2cards("emm,mmm");
        r.setGame_max_user1cards("t6");
        r.setGame_max_user2cards("mmm");
        recordyAction.edit(r);*/

        /*删除
        Recordy recordy=new Recordy();
        recordy.getGame_ID();
        recordyAction.del(3);*/

        /*单个查询
        Recordy rec=new Recordy();
        rec=recordyAction.get(1);
        System.out.println(rec.toString());
         */
    }
}
