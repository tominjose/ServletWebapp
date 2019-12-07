package com.face.controller;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.face.bo.Product;
import com.face.dao.AddProductDAO;
/**
* Servlet implementation class AddProductServlet
*/
@WebServlet(urlPatterns= {"/AddProduct"})
public class AddProductServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
  /**
   * @see HttpServlet#HttpServlet()
   */
  public AddProductServlet() {
      super();
      // TODO Auto-generated constructor stub
  }
   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // TODO Auto-generated method stub
         ArrayList<Product> Productlist;
       try {
           Productlist = AddProductDAO.getAllDetails();
            request.setAttribute("product", Productlist);
       } catch (ClassNotFoundException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (SQLException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       } catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
          RequestDispatcher dispatcher //
         = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ProductView.jsp");
 dispatcher.forward(request, response);
   }
   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // TODO Auto-generated method stub
          String pname = request.getParameter("pname");
          String qty = request.getParameter("qty");
          String price = request.getParameter("price");
   try {
       Boolean rs= AddProductDAO.storeProduct(pname,qty,price);
       if(rs==true)
       {
             ArrayList<Product> Productlist=AddProductDAO.getAllDetails();
             request.setAttribute("product", Productlist);
             RequestDispatcher dispatcher //
              = this.getServletContext().getRequestDispatcher("/WEB-INF/views/ProductView.jsp");
      dispatcher.forward(request, response);
       }
   } catch (ClassNotFoundException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
   } catch (SQLException e) {
       // TODO Auto-generated catch block
       e.printStackTrace();
   } catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
   }
}
