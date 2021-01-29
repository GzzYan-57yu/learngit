package Control;

import Dao.RecordyDao;
import Model.Recordy;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author gzz
 */
public class RecordyAction {

    public void add(Recordy recordy) throws Exception {
        RecordyDao dao = new RecordyDao();
        dao.addRecordy(recordy);
    }

    public void edit(Recordy record) throws SQLException {
        RecordyDao dao = new RecordyDao();
        dao.updateRecordy(record);
    }

    public void del(String game_user1name) throws SQLException {
        RecordyDao dao = new RecordyDao();
        dao.delRecordy(game_user1name);
    }

    public List<Recordy> query() throws Exception {
        RecordyDao dao = new RecordyDao();
        return dao.Query();
    }

    public List<Recordy> query(String game_user1name) throws Exception {
        RecordyDao dao = new RecordyDao();
        return dao.Query();
    }

    public List<Recordy> query(Timestamp game_begintime, Timestamp game_exittime) throws Exception {
        RecordyDao dao = new RecordyDao();
        return dao.Query();
    }

    public Recordy get(Integer game_ID) throws SQLException {
        RecordyDao dao = new RecordyDao();
        return dao.get(game_ID);
    }
}