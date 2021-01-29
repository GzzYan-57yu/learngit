package view;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Control.GameAction;
import Control.RecordyAction;
import Control.UserAction;
import Dao.GameDao;
import Model.Poker;
import Model.Recordy;
import Model.User;

public class View {

    private static final String CONTEXT = "欢迎进入扑克牌游戏\n" +
            "请选择注册或登录：\n" +
            "[ADD/A]注册sign out\n" +
            "[COMPARE/C]登录sign in\n";
    private static final String CONTEXT2 = "欢迎注册登录" +
            "请选择你想要实使用的功能（新用户不要着急的查看对战记录哟~）\n" +
            "[SEARCH/S]根据用户名搜索其它用户的信息\n" +
            "[START/T]开始对战\n" +
            "[QUERY/Q]查看所有对战记录和对战获胜率\n" +
            "[SEEK/K]查看某时间段内的对战记录\n" +
            "[EXIT/E]退出登录log out\n" +
            "[DELETE/D]注销账户close account\n"+
            "[BREAK/B]返回主菜单main menu\n";


    private static final String OPTION_ADD = "ADD";
    private static final String OPTION_COMPARE = "COMPARE";
    private static final String OPTION_QUERY = "QUERY";
    private static final String OPTION_SEARCH = "SEARCH";
    private static final String OPTION_SEEK = "SEEK";
    private static final String OPTION_EXIT = "EXIT";
    private static final String OPTION_DELETE = "DELETE";
    private static final String OPTION_START = "START";
    private static final String OPTION_BREAK = "BREAK";

    private static int id;
    private static String player_username;
    private static String player_password;
    private static Timestamp play_createtime;
    private static int game_ID;
    private static Timestamp game_begintime;
    private static Timestamp game_exittime;
    private static String game_user1name;
    private static String game_winner_name;
    private static String game_user1cards;
    private static String game_user2cards;
    private static String game_max_user1cards;
    private static String game_max_user2cards;


    public static void main(String[] args) throws Exception {

        //Main main = new Main();

        Scanner sc = new Scanner(System.in);
        System.out.println(CONTEXT);

        User user = new User();
        Recordy recordy = new Recordy();
        Poker poker = new Poker(game_user1cards, game_user2cards);
        UserAction userAction = new UserAction();
        RecordyAction recordyAction = new RecordyAction();
        GameDao gameDao=new GameDao();
        String prenious = null;
        Integer step = 1;

        //实现注册方法
        while (sc.hasNext()) {
            String str = sc.next();
            if (OPTION_ADD.equalsIgnoreCase(str) || OPTION_ADD.equals(str) ||
                    OPTION_ADD.substring(0, 1).equals(str.toUpperCase()) || OPTION_ADD.equals(prenious)) {
                prenious = OPTION_ADD;
                if (1 == step) {
                    System.out.println("请输入您的［姓名］作为玩家用户名");
                } else if (2 == step) {
                    user.setPlayer_username(str);
                    System.out.println("请输入您的[密码],注意妥善保存噢");
                } else if (3 == step) {
                    user.setPlayer_password(str);
                    try {
                        userAction.add(user);
                        System.out.println("新增用户信息成功，感谢您的注册");
                        System.out.println("请输入compare或c以登录！");
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("新增用户信息失败，请您稍后再来");
                    }
                }
                if (OPTION_ADD.equals(prenious)) {
                    step++;
                }
            }

            if (OPTION_COMPARE.equalsIgnoreCase(str) || OPTION_COMPARE.equals(str) ||
                    OPTION_COMPARE.substring(0, 1).equals(str.toUpperCase()) || OPTION_COMPARE.equals(prenious)) {
                prenious = OPTION_COMPARE;
                int id1=0;
                int stepp = 1;
                if (1 == stepp) {
                    System.out.println("请输入您的[用户名]以登录");
                } else if (2 == stepp) {
                    user.setPlayer_username(str);
                    try {
                        userAction.query();
                        System.out.println(id);
                        id1 = id;
                        System.out.println("请输入您的[密码]以验证登录");
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("您输入的用户名不存在");
                    }
                } else if (3 == stepp) {
                    user.setPlayer_password(str);
                    userAction.query();
                    System.out.println(id);
                    int id2 = id;
                    if (id1 == id2) {
                        System.out.println("登录成功！");
                    } else {
                        System.out.println("您输入的用户名和密码不匹配，请检查后重新输入");
                        step = 0;
                    }
                }
                if (OPTION_COMPARE.equals(prenious)) {
                    stepp++;
                }
                System.out.println(CONTEXT2);
                while (sc.hasNext()) {
                    String in = sc.next();
                    if (OPTION_SEARCH.equalsIgnoreCase(in) || OPTION_SEARCH.equals(in) ||
                            OPTION_SEARCH.substring(0, 1).equals(in.toUpperCase())) {
                        System.out.println("请输入你知道的相似用户名：");
                        recordy.setGame_user1name(in);
                        List<Recordy> records = recordyAction.query(game_user1name);
                        for (int i = 0; i < records.size(); i++) {
                            System.out.println(records.get(i).getGame_ID() + "" + records.get(i).getGame_begintime() +
                                    records.get(i).getGame_exittime() + records.get(i).getGame_user1name() +
                                    records.get(i).getGame_user2name() + records.get(i).getGame_winner_name() +
                                    records.get(i).getGame_user1cards() + records.get(i).getGame_user2cards() +
                                    records.get(i).getGame_max_user1cards() + records.get(i).getGame_max_user2cards() + "");

                        }
                    } else if (OPTION_QUERY.equalsIgnoreCase(in) || OPTION_QUERY.equals(in) || OPTION_QUERY.substring(0, 1).equals(in.toUpperCase())) {
                        System.out.println("please input your username sothat we can cal the turn out");
                        recordy.setGame_user1name(in);
                        System.out.println("please input your username sothat we can cal the turn out");
                        recordy.setGame_winner_name(in);
                        List<Recordy> records = recordyAction.query();
                        for (int i = 0; i < records.size(); i++) {
                            System.out.println(records.get(i).getGame_ID() + "" + records.get(i).getGame_begintime() +
                                    records.get(i).getGame_exittime() + records.get(i).getGame_user1name() +
                                    records.get(i).getGame_user2name() + records.get(i).getGame_winner_name() +
                                    records.get(i).getGame_user1cards() + records.get(i).getGame_user2cards() +
                                    records.get(i).getGame_max_user1cards() + records.get(i).getGame_max_user2cards() + "");
                        }
                        //计算获胜率并给出
                        System.out.println("please input your username sothat we can cal the turn out");
                        recordy.setGame_user1name(in);
                        System.out.println("please input your username sothat we can cal the turn out");
                        recordy.setGame_winner_name(in);
                        int count1 = 0, count2 = 0, turn ;
                        String sql = "" + "select count (*) into count1 from " + " record " + " where game_user1name= ? ";
                        System.out.println("总比赛场数：" + count1);
                        String sqlm = "" + "select count (*) into count2 from " + " record " + " where game_winner_name= ? ";
                        System.out.println("获胜比赛场数：" + count2);
                        if (count1 != 0) {
                            if (count2 != 0) {
                                turn = count2 / count1;
                                System.out.println("胜率为:"+turn);
                            } else {
                                System.out.println("胜率为0");
                            }
                        } else {
                            System.out.println("先开始玩游戏再看胜率呀小可爱！");
                        }
                    } else if (OPTION_SEEK.equalsIgnoreCase(in) || OPTION_SEEK.equals(in) ||
                            OPTION_SEEK.substring(0, 1).equals(in.toUpperCase())) {
                        System.out.println("请输入你想要查看对战记录的时间范围：");
                        recordy.setGame_begintime(Timestamp.valueOf(in));
                        recordy.setGame_exittime(Timestamp.valueOf(in));
                        List<Recordy> records = recordyAction.query();
                        for (int i = 0; i < records.size(); i++) {
                            System.out.println(records.get(i).getGame_ID() + "" + records.get(i).getGame_begintime() +
                                    records.get(i).getGame_exittime() + records.get(i).getGame_user1name() +
                                    records.get(i).getGame_user2name() + records.get(i).getGame_winner_name() +
                                    records.get(i).getGame_user1cards() + records.get(i).getGame_user2cards() +
                                    records.get(i).getGame_max_user1cards() + records.get(i).getGame_max_user2cards() + "");
                        }

                    } else if (OPTION_DELETE.equalsIgnoreCase(in) || OPTION_DELETE.equals(in) ||
                            OPTION_DELETE.substring(0, 1).equals(in.toUpperCase())) {
                        System.out.println("请输入你的用户名以便我们能够彻底的清除数据：");
                        recordyAction.del(game_user1name);
                        System.out.println("您的对战数据已清除完毕");
                        userAction.del(player_username);

                    } else if (OPTION_START.equalsIgnoreCase(in) || OPTION_START.equals(in) ||
                            OPTION_START.substring(0, 1).equals(in.toUpperCase())) {
                        System.out.println("创建扑克牌");
                        System.out.println("扑克牌创建成功");
                        gameDao.CreatePoker();
                        System.out.println("开始洗牌");
                        gameDao.ShuttlePoker();
                        System.out.println("洗牌结束");
                        System.out.println("创建玩家");
                        System.out.println("请输入玩家一的姓名");
                        String ini=sc.next();
                        user.setPlayer_username(ini);
                        recordy.setGame_user1name(ini);
                        System.out.println("欢迎玩家一：" + ini);
                        System.out.println("欢迎玩家二：wang");
                        System.out.println("开始发牌");
                        game_user1name=ini;
                        System.out.println("玩家"+game_user1name+"拿牌");
                        System.out.println("玩家"+"wang"+"拿牌");
                        System.out.println("玩家"+game_user1name+"拿牌");
                        System.out.println("玩家"+"wang"+"拿牌");
                        gameDao.deal();
                        System.out.println("发牌结束");
                        System.out.println("开始游戏");
                        gameDao.compare();
                        System.out.println("玩家：" + game_user1name + "的最大手牌为" + game_max_user1cards);
                        System.out.println("玩家：" + "wang" + "的最大手牌为" + game_max_user2cards);
                        System.out.println("游戏结束");
                        System.out.println("玩家：" + game_winner_name + "获胜");
                        System.out.println("玩家" + game_user1name + " 的手牌为");
                        System.out.println("玩家" + "wang" + " 的手牌为");
                    } else if (OPTION_EXIT.equalsIgnoreCase(in) || OPTION_EXIT.equals(in) ||
                            OPTION_EXIT.substring(0, 1).equals(in.toUpperCase())) {
                        System.out.println("您已成功退出登录！");
                        break;
                    } else if (OPTION_DELETE.equalsIgnoreCase(in) || OPTION_DELETE.equals(in) ||
                            OPTION_DELETE.substring(0, 1).equals(in.toUpperCase())) {
                        System.out.println("请输入你的用户名以便我们能够彻底的清除数据：");
                        recordyAction.del(game_user1name);
                        System.out.println("您的对战数据已清除完毕");
                        userAction.del(player_username);
                    }
                }
            } else {
                System.out.println("您输入的值为：" + str);
            }
        }
    }

}
