<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">
      <script language="javascript" src="js/validation.js"></script>
      
 
</head>
<body>
   <div class="container-fluid">
    <noscript>
        <p class="text-center text-warning">Please unable javaScript for Better Experience</p>
     </noscript>
  
     <div class="d-flex justify-content-center text-align-center m-2 p-2 ">
     
       <form:form  modelAttribute="emp"  onsubmit="return validate(this)" cssClass="border border-3 border-secondary rounded rounded-4 m-3 p-4 ">
<%--            <p class="text-center text-danger m-3 w-100"><form:errors path="*"/></p>
 --%>         
          <label>Name</label>
          <form:input path="ename" cssClass="form-control"/><form:errors path="ename" cssClass="text-danger mb-2"/><span class="text-warning" id="enameErr"></span><br>
          <label>Job</label>
          <form:input path="job" cssClass="form-control"/><form:errors path="job" cssClass="text-danger mb-2"/><span class="text-warning" id="jobErr"></span>
          <br><label>Salary</label>
          <form:input path="sal" cssClass="form-control"/><form:errors path="sal" cssClass="text-danger mb-2"/><span class="text-warning" id="salErr"></span><br>
          <button class="btn btn-center btn-primary w-100  p-2">Submit</button><br>
           <a href="./">Home Page</a>
           
           <form:hidden path="vflag"/>
       </form:form>
      
     </div>
   </div>
</body>
</html>