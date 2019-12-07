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
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet("/UpdateProduct")
public class UpdateProductServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
}

/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
        String pid=request.getParameter("id");
        String pname = request.getParameter("pname");
        String qty = request.getParameter("qty");
        String price = request.getParameter("price");
        System.out.println(pid);
 try {
     Boolean rs= AddProductDAO.updateProduct(pid,pname,qty,price);
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
 }
}

}
