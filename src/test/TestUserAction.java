package test;

import Control.UserAction;
import Model.User;

public class TestUserAction {
    public static void main(String[] args) throws Exception {
        UserAction userAction=new UserAction();

        /*查询
        List<User> users=userAction.query();

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getId()+"|"+
                    users.get(i).getPlayer_username()+"|"+
                    users.get(i).getPlayer_password()+"|"+
                    users.get(i).getPlay_createtime());
        }*/

        /*增加
        User us=new User();
        us.setId(2);
        us.setPlayer_username("zhao");
        us.setPlayer_password("qqqwwww");
        userAction.add(us);*/

        /*修改
        User u=new User();
        u.setId(2);
        u.setPlayer_username("zhou");
        u.setPlayer_password("emmmmm");
        userAction.edit(u);
         */

        /*删除
        User user=new User();
        user.getId();
        userAction.del(2);
        */

        /*单个查询
        User use=new User();
        use=userAction.get(4);
        System.out.println(use.toString());*/
    }
}
