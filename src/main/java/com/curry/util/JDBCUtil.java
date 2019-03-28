package com.curry.util;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/13 0013.
 */
public class JDBCUtil {
    //加载驱动
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //连接数据库
    static String url = "jdbc:mysql://192.168.80.143:3306/db3?useUnicode=true&characterEncoding=utf8";
    static String user = "root";
    static String password = "hy960103";
    public static Connection getConnection(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
    // 关闭
    public static void close(Connection con, PreparedStatement pstmt,ResultSet rs){
        try {
            if(rs!=null)
                rs.close();
            if(pstmt!=null)
                pstmt.close();
            if(con!=null)
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //增删改封装，传sql语句
    public static int executeUpdate(String sql,Object... params){
        int result = 0;
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement(sql);
            if(params!=null){
                for(int i=0;i<params.length;i++)
                    pstmt.setObject(i+1,params[i]);
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(con,pstmt,null);
        }
        return result;
    }
    //查封装
    public static <T>List<T> executeQuery(String sql,Class<T> clz,Object... params){
        List<T> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = con.prepareStatement(sql);
            if(params!=null){
                for(int i=0;i<params.length;i++)
                    pstmt.setObject(i+1,params[i]);
            }
            rs = pstmt.executeQuery();
            while(rs.next()){
                T t = clz.newInstance();
                Field[] fields = clz.getDeclaredFields();
                for(Field field : fields){
                    field.setAccessible(true);
                    field.set(t,rs.getObject(field.getName()));
                }
                list.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }finally {
            close(con,pstmt,rs);
        }
        return list;
    }
}
