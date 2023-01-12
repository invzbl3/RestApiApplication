<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.test.application.data.models.ProjectCategory"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" import="com.test.application.data.models.Project"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@include file="../includes/head.jsp"%>
</head>
<body style="background-color: #f8f9fa !important;">
<%@include file="../includes/header.jsp"%>
<main role="main" class="container">
    <%@include file="../includes/msg.jsp"%>
    <div class="card">
        <c:set var="action" value="/admin/project/add"/>
        <c:set var="title" value="Add Project"/>
        <c:if test="${command.projectId > 0}">
            <c:set var="action" value="/admin/project/update"/>
            <c:set var="title" value="Update Project"/>
        </c:if>
        <div class="card-header text-white shadow bg-dark">
            <h2 class="float-left">${title}</h2>
        </div>
        <div class="card-body">
            <form:form action="${action}" method="post">
                <form:input type="hidden" path="projectId"/>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <div class="form-group">
                    <label for="projectName" class="control-label">Project Name</label>
                    <form:input type="text" path="projectName" id="projectName" cssClass="form-control" required="required"/>
                    <small class="form-text text-muted"><font color="red"><form:errors path="projectName"></form:errors></font></small>
                </div>
                <div class="form-group">
                    <label for="projectPrice" class="control-label">Project Price</label>
                    <form:input type="text" path="projectPrice" id="projectPrice" cssClass="form-control" required="required"/>
                    <small class="form-text text-muted"><font color="red"><form:errors path="projectPrice"></form:errors></font></small>
                </div>
                <div class="form-group">
                    <label for="projectCategory" class="control-label">Project Category</label>
                    <form:select path="category.id" id="projectCategory" cssClass="form-control">
                        <c:forEach items="${projectCategory}" var="category">
                            <form:option value="${category.id}">${category.name}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-success btn-lg btn-block" value="${title}">
                </div>
            </form:form>
        </div>
    </div>
</main>

<br><br><br>

<%@include file="../includes/footer.jsp"%>
</body>
</html>