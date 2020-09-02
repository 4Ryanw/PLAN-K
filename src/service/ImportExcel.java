package service;

import bean.Info;

import java.util.List;

public class ImportExcel {
    public static void main(String[] args) {

    }

    /*public static void importMysql(String[] args) {
        //得到表格中所有的数据
        List<Info> listExcel = UserService.getAllByExcel("d://book.xls");
        //获取连接
        DBhepler db = new DBhepler();
        for (Info info : listExcel) {
            int id = userInfo.getUserId();
            if (id == 0 || !UserService.isExist(id)) {
                //不存在就添加
                String sql = "insert into user_info (user_name,email,mobile,password,create_time,update_time) values(?,?,?,?,now(),now())";
                String[] str = new String[]{userInfo.getUserName(), userInfo.getEmail(), userInfo.getMobile(), userInfo.getPassword()};
                db.AddU(sql, str);
            } else {
                //存在就更新
                String sql = "update user_info set user_name=?,email=?,mobile=?,password=?,update_time=now() where user_id=?";
                String[] str = new String[]{userInfo.getUserName(), userInfo.getEmail(), userInfo.getMobile(), userInfo.getPassword(), id + ""};
                db.AddU(sql, str);
            }
        }
    }*/
}
