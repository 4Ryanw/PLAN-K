package service;

import bean.Result;
import dao.JdbcConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StasticData {
    //获取结果集合
    public List<Result> getList() throws SQLException {
        //获取数据连接
        Connection conn = JdbcConnection.getconnection();
        //预编译sql
        String sql = "SELECT\n" +
                "IF\n" +
                "\t( b.region IS NULL, '无匹配', b.region ) region,\n" +
                "IF\n" +
                "\t( b.opCenter IS NULL, '无匹配', b.opCenter ) opCenter,\n" +
                "\tSUM(\n" +
                "\tIF\n" +
                "\t( d.photo = '', 0, 1 )) AS count,\n" +
                "\tcount( 1 ) AS total \n" +
                "FROM\n" +
                "\tt_daily d\n" +
                "\tLEFT JOIN t_base b ON d.`name` = b.`name` \n" +
                "GROUP BY\n" +
                "\tb.region,\n" +
                "\tb.opCenter UNION\n" +
                "SELECT\n" +
                "\tc.region,\n" +
                "\t'合计' AS opCenter,\n" +
                "\tSUM( c.count ) AS count,\n" +
                "\tSUM( c.total ) AS total \n" +
                "FROM\n" +
                "\t(\n" +
                "\tSELECT\n" +
                "\tIF\n" +
                "\t\t( b.region IS NULL, '无匹配', b.region ) region,\n" +
                "\tIF\n" +
                "\t\t( b.opCenter IS NULL, '无匹配', b.opCenter ) opCenter,\n" +
                "\t\tSUM(\n" +
                "\t\tIF\n" +
                "\t\t( d.photo = '', 0, 1 )) AS count,\n" +
                "\t\tcount( 1 ) AS total \n" +
                "\tFROM\n" +
                "\t\tt_daily d\n" +
                "\t\tLEFT JOIN t_base b ON d.`name` = b.`name` \n" +
                "\tGROUP BY\n" +
                "\t\tb.region,\n" +
                "\t\tb.opCenter \n" +
                "\t) c \n" +
                "GROUP BY\n" +
                "\tc.region \n" +
                "ORDER BY\n" +
                "\tregion,(\n" +
                "\tCASE\n" +
                "\t\t\topCenter \n" +
                "\t\t\tWHEN '合计' THEN\n" +
                "\t\t\t2 ELSE 1 \n" +
                "\tEND \n" +
                "\t) ASC";

        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        // 处理结果集
        List<Result> resultList = new ArrayList<>();
        while (rs.next()) {
            Result result = new Result(rs.getString("region"),rs.getString("opcenter"),rs.getInt("total"),rs.getInt("count"));
            resultList.add(result);
        }
        // 释放资源
        rs.close();
        statement.close();
        JdbcConnection.close(conn);
     return resultList;
    }
}
