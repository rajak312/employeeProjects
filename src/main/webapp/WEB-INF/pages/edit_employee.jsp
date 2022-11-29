<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link rel="stylesheet"  href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css">

<script type="text/javascript" src="js/validation.js"></script>

<div class="container-fluid">
      <noscript>
        <p class="text-center text-warning m-2 p-2">Please unable javaScript for Better Experience</p>
     </noscript>
     <div class="d-flex justify-content-center text-align-center">
     
         <form:form modelAttribute="emp" class="m-3 p-4 border border-2 rounded ounded-2" onsubmit="return validate(this)">
             <label>Employee No</label>
             <form:input path="empno" readonly="true" class="form-control"/><br>
             <label>Name</label>
             <form:input path="ename" class="form-control"/><form:errors path="ename" cssClass="text-danger mb-2"/><span class="text-warning" id="enameErr"></span><br>
             <label>Job</label>
             <form:input path="job" class="form-control"/><form:errors path="job" cssClass="text-danger mb-2"/><span class="text-warning" id="jobErr"></span><br>
             <label>Salary</label>
             <form:input path="sal" class="form-control"/><form:errors path="sal" cssClass="text-danger mb-2"/><span class="text-warning" id="salErr"></span><br>
             
             <button class="btn btn-primary">Submit</button>
             <form:hidden path="vflag"/>
         </form:form>
     </div>
</div>