package com.deajun.project;
import java.sql.*;

public class SqlTest {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://bihf2.c7bp8tticjxg.ap-northeast-2.rds.amazonaws.com:3306/bihf?serverTimezone=UTC";

    static final String USERNAME = "bihf";
    static final String PASSWORD = "bihf0119";
    
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            System.out.println("\n- MySQL Connection");
            stmt = conn.createStatement();
            System.out.println("zz");
            String sql;
            sql = "SELECT count(*) 'aa' FROM board";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                String groupName = rs.getString("aa");

                System.out.print("\n** Group : " + groupName);
            }
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se1){
            se1.printStackTrace();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("\n\n- MySQL Connection Close");
    }
}
