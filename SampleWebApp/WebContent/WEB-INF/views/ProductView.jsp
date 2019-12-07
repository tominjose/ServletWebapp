<%@page import="com.face.bo.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   <%@page import="java.util.Iterator"%>
   <%@page import="java.util.ArrayList"%>
   <%@page import="com.face.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="container-fluid">
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_menu.jsp"></jsp:include>
<div class="container-fluid" align="center" style="margin-top: 5em; min-height: 200%;">
<%if(request.getAttribute("data")!=null)
{
Product pd=(Product)request.getAttribute("data");%>
    <form action="${pageContext.request.contextPath }/UpdateProduct" method="post" style="width:50%;">
 <div class="form-group row">
   <label for="inputEmail3" class="col-sm-2 col-form-label">Product</label>
   <div class="col-sm-10">
     <input type="text" autocomplete="off"  value="<%=pd.getPname() %>" autofocus="autofocus" name="pname" class="form-control" >
   </div>
 </div>
 <div class="form-group row">
   <label for="inputEmail3" class="col-sm-2 col-form-label" >Quantity</label>
   <div class="col-sm-4">
     <input type="number" name="qty" class="form-control" id="inputEmail3" value="<%=pd.getQty()%>">
   </div>
       <label for="inputEmail3" class="col-sm-2 col-form-label">Price</label>
   <div class="col-sm-4">
     <input type="number" name="price" value="<%=pd.getPrice() %>" class="form-control" id="inputEmail3" >
     <input type="text" name="id" hidden="hidden" value="<%=pd.getPid() %>">
   </div>
 </div>
</br>
</br>
 <div class="form-group row">
   <div class="col-sm-10">
     <button type="submit" class="btn btn-primary">Update</button>
     <a href="${pageContext.request.contextPath}/">Cancel</a>
   </div>
 </div>
 
 
 <%} else
{%>
<form action="${pageContext.request.contextPath }/AddProduct" method="post" style="width:50%;">
 <div class="form-group row">
   <label for="inputEmail3" class="col-sm-2 col-form-label">Product</label>
   <div class="col-sm-10">
     <input type="text" autocomplete="off" autofocus="autofocus" name="pname" class="form-control" id="inputEmail3" placeholder="Product Name">
   </div>
 </div>
 <div class="form-group row">
   <label for="inputEmail3" class="col-sm-2 col-form-label">Quantity</label>
   <div class="col-sm-4">
     <input type="number" name="qty" class="form-control" id="inputEmail3" placeholder="0">
   </div>
       <label for="inputEmail3" class="col-sm-2 col-form-label">Price</label>
   <div class="col-sm-4">
     <input type="number" name="price" class="form-control" id="inputEmail3" placeholder="0">
   </div>
 </div>
</br>
</br>
 <div class="form-group row">
   <div class="col-sm-10">
     <button type="submit" class="btn btn-primary">Add</button>
     <a href="${pageContext.request.contextPath}/">Cancel</a>
   </div>
 </div>
</form>
<%} %>
    <%  ArrayList<Product> p = (ArrayList<Product>)request.getAttribute("product");%>
<table class="table table-condensed table-dark table-hover ">
 <thead class="white">
   <tr class="">
     <th scope="col">#</th>
     <th scope="col">Name</th>
     <th scope="col">Qty</th>
     <th scope="col">Price</th>
     <th scope="col">Edit</th>
     <th scope="col">Delete</th>
   </tr>
 </thead>
 <tbody>
 <%  for(Product ps : p){ %>
   <tr>
     <th scope="row"> <%=ps.getPid() %></th>
     <td> <%=ps.getPname() %></td>
         <td><%=ps.getQty() %></td>
     <td><%=ps.getPrice()%></td>
     <td>
     <form method="post" action="${pageContext.request.contextPath}/EditProduct">
     
     <input type="text" hidden="hidden" name="pid" value="<%= ps.getPid() %>">
     <button type="submit" name="edit" value="edit" style="background-color: white;border:none;" ><i class="fa fa-edit" ></i></button>
     </form></td>
     <td>
     
     <form method="post" action="${pageContext.request.contextPath}/DeleteProduct">
     <input type="text" hidden="hidden" name="pid" value="<%= ps.getPid() %>">
     <button type="submit" name="" value="delete" style="background-color: white;border:none;" ><i class="fa fa-trash"  ></i></button>
     </form>
     </td>
     
     
     
   </tr>
   <%} %>
 </tbody>
</table>
</div>
<jsp:include page="_footer.jsp"></jsp:include>
</div>
</body>
</html>
