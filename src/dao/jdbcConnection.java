package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcConnection {
    public static void main(String[] args) throws SQLException {

        Connection conn = getconnection();
        Statement s = conn.createStatement();
        // 准备sql语句
        String sql = "INSERT INTO t_daily VALUES (NULL,'xx经销商','kkkkppp',CURRENT_DATE)";
        s.execute(sql);
        System.out.println("执行插入语句成功");
        close(conn);
    }

    //获取连接方法封装
    public static Connection  getconnection(){
        Connection conn = null;
        //加载JDBC类
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //建立获取连接
        String url = "jdbc:mysql://149.129.48.96:3306/PLAN-K?characterEncoding=UTF-8";
        String user = "root";
        String pwd = "Aa@314184417";
        try{
            System.out.println("创建数据库连接...");
            System.out.println("url:"+url);
            conn = DriverManager.getConnection(url, user, pwd);
            System.out.println("创建连接成功！");
        }catch (SQLException e){
            System.out.println("连接SQLException异常...");
        }
        return  conn;
    }
    //关闭连接方法封装
    public static void close(Connection conn){
        if(conn != null){
            try {
                conn.close();
                System.out.println("关闭连接成功");
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }

}
