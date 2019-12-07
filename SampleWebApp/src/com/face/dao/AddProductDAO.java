package com.face.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.face.bo.Product;
import com.face.utility.MySQLConnUtils;

public class AddProductDAO {
    public static boolean storeProduct(String pname, String qty, String price) throws ClassNotFoundException, IOException, SQLException {
        // TODO Auto-generated method stub
        Connection con = null;
		try {
			con = MySQLConnUtils.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Statement st1 = con.createStatement();
        String s="INSERT INTO product(pname, qty, price) VALUES ('"+pname+"','"+qty+"','"+price+"')";
        System.out.println(s);
        int rs=st1.executeUpdate(s);
        if(rs==1)
            return true;
        else
            return false;
    }
    public static ArrayList<Product> getAllDetails() throws ClassNotFoundException, SQLException, IOException {
   
          Connection con = null;
		try {
			con = MySQLConnUtils.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
            Statement st = con.createStatement();
          ResultSet rs = st.executeQuery("SELECT * FROM product");
          ArrayList<Product> list=new ArrayList<Product>();
           
          Product p[] = new Product[100];
          int i=0;
            while(rs.next())
            {
                p[i] = new Product();
                p[i].setPid(rs.getInt("pid"));
                p[i].setPname(rs.getString("pname"));
                p[i].setPrice(rs.getInt("price"));
                p[i].setQty(rs.getInt("qty"));
                list.add(p[i]);
                i++;
//                   list.set(0,rs.getInt("pid"));
//                 list.add(rs.getString("pname"));
//                 list.add(rs.getString("qty"));
//                 list.add(rs.getString("price"));
//                
//        
               
                }
            System.out.println(list);
         
            return list;
    }
public static Product editProduct(String id) throws ClassNotFoundException, IOException, SQLException {
Connection con = null;
try {
	con = MySQLConnUtils.getConnection();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
        Statement st = con.createStatement();
      ResultSet rs = st.executeQuery("select * from product where pid='"+id+"'");
      Product p= new Product();
      while(rs.next())
      {
     p.setPid(rs.getInt("pid"));
     p.setPname(rs.getString("pname"));
     System.out.println(rs.getString("pname"));
     p.setPrice(rs.getInt("price"));
     p.setQty(rs.getInt("qty"));
      }
return p;
}
public static Boolean updateProduct(String pid, String pname, String qty, String price) throws ClassNotFoundException, IOException, SQLException {
// TODO Auto-generated method stub
Connection con = null;
try {
	con = MySQLConnUtils.getConnection();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
        Statement st = con.createStatement();
        String s="update product set pname='"+pname+"',qty='"+qty+"',price='"+price+"' where pid='"+pid+"'";
        System.out.println(s);
        int rs = st.executeUpdate(s);
        System.out.println(rs);
        if(rs==1)
        {
        return true;
        }

        else
        {
        return false;
        }
}
public static boolean deleteProduct(String id) throws ClassNotFoundException, IOException, SQLException {
// TODO Auto-generated method stub

Connection con = null;
try {
	con = MySQLConnUtils.getConnection();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
        Statement st = con.createStatement();
        String s="delete from product where pid='"+id+"'";
        int rs = st.executeUpdate(s);
        if(rs==1)
        {
        return true;
        }

        else
        {
        return false;
        }
}
}
