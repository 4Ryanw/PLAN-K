package service;

import bean.Info;
import dao.JdbcConnection;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImportExcel {

    /**

     * 查询指定目录中电子表格中所有的数据
     * @param file
     * 文件完整路径
     * @return
     */
    public static List<Info> getAllByExcel(String file) {
        List<Info> list = new ArrayList<Info>();
        try {
            Workbook rwb = Workbook.getWorkbook(new File(file));
            Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
            int rows = rs.getRows();// 得到所有的行
            System.out.println(" 行数 :" + rows);
            for (int i = 1; i < rows; i++) {
                    String name = rs.getCell(4, i).getContents();
                    String photo = rs.getCell(11, i).getContents();
                    Info info = new Info(name,photo);
                    list.add(info);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void importMysql(String fileUrl) throws SQLException {
        //得到表格中所有的数据
        List<Info> listExcel = getAllByExcel(fileUrl);

        Connection conn = JdbcConnection.getconnection();//获取连接

        for (Info info : listExcel) {
                String sql = "INSERT INTO t_daily VALUES (NULL,?,?,CURRENT_DATE)";
                String[] str = new String[]{info.getName(), info.getPhoto()};
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                if (str != null) {
                    for (int i = 0; i < str.length; i++) {
                        pst.setString(i + 1, str[i]);
                    }
                }
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                return;
            }
        }

        //关闭连接
        JdbcConnection.close(conn);
    }
}
