<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Login</title>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">	
	<s:head />	
</head>
<body>
	<h3 class="center">Welcome</h3>

	<s:if test="%{#parameters.error}">
	   <div class="alert alert-danger">Bad Credentials.</div><br>
	</s:if>

 	<form action="j_spring_security_check" class="form" method="POST">
		<div class="form-group">
			<input type="text" name="userName" class="form-control" placeholder="Username"/>
  		</div>

		<div class="form-group">
			<input type="password" name="password" class="form-control" placeholder="Password"/>
		</div>
		
		<div class="form-group">
			<input type="submit" class="btn btn-primary" value="Log in" />
		</div>
	</form>	
</body>
</html>
	