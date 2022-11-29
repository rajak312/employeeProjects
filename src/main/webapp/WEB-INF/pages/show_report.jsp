<%@ page isELIgnored="false"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
</head>
<body class="container-fluid">
  <div class="p-4 m-4">
  
  <c:if test="${!empty msg }">
     <h3 class="text-center text-succeess"> ${msg }</h3>
  </c:if>
 
      <c:choose>
           <c:when test="${!empty empList}">
         <table class="table table-hover table-striped">
            <tr class="table- text-success bg-secondary">
               <th>Employee No</th>
               <th>Name</th>
               <th>Job</th>
               <th>Salary</th>
               <th>Edit</th>
               <th>Delete</th>
            </tr>
            <c:forEach var="empList" items="${empList }">
               <tr>
                  <td>${empList.empno}</td>
                  <td>${empList.ename }</td>
                  <td>${empList.job }</td>
                  <td>${empList.sal }</td>
                  <td><a href="edit?empno=${empList.empno }"><img src="images/edit.jpg" width="50" height="50"></a></td>
                  <td><a href="delete?empno=${empList.empno }" onclick="return confirm('Are you sure to delete?')"><img src="images/delete.jpg"  width="50" height="50"></a></td>
               </tr>
            
            </c:forEach>
         </table>
        </c:when>
        <c:otherwise>
         <h4 class="text-center text-warning">No Record Found</h4>
         </c:otherwise>
      </c:choose>
      
      
     <br><br><hr>
     <div class="d-flex justify-content-center text-align-center">
       <div>
           <a href="add"><button style="background-image: url('images/add.jpg');" class="btn btn-primary  h-100 text-danger">Add Employee</button></a>
           
       </div>
     </div>
  </div>
</body>
</html>