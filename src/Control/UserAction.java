package Control;

import Dao.UserDao;
import Model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author gzz
 */
public class UserAction {

    public void add(User user) throws Exception {
        UserDao dao=new UserDao();
        user.setPlayer_username(user.getPlayer_username());
        user.setPlayer_password(user.getPlayer_password());
        dao.addUser(user);
    }

    public void edit(User user) throws Exception {
        UserDao dao=new UserDao();
        dao.updateUser(user);
    }

    public void del(String player_username) throws SQLException {
        UserDao dao=new UserDao();
        dao.delUser(player_username);

    }

    public List<User> query() throws Exception {
        UserDao dao=new UserDao();
        return dao.Query();
    }

    public User get(String play_username,String player_password) throws Exception {
        UserDao dao=new UserDao();
        return dao.get(play_username,player_password);
    }
}
