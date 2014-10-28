<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>User</title>
	<s:head/>
</head>
<body>
	<div class="content">
		<div class="page-header"><h1>User</h1></div>
		<s:form action="save" role="form" theme="simple" cssClass="col-md-4 form form-horizontal">
			
		    <div class="form-group">    
		        <label class="col-sm-3 control-label">Username:</label>
		        <div class="col-sm-9">
			       <s:textfield name="user.username" cssClass="form-control"/>
		        </div>
		    </div>	
			
		    <div class="form-group">    
		        <label class="col-sm-3 control-label">Password:</label>
		        <div class="col-sm-9">
					<s:password name="user.password" cssClass="form-control"/>
		        </div>
		    </div>
    
		    <div class="form-group">    
		        <label class="col-sm-3 control-label">Role:</label>
		        <div class="col-sm-9">
					<s:select
					       list="rolesCollection"
					       name="role.roleId"
					       value="user.role.roleId"
					       required="true"
					       cssClass="form-control"/>
		        </div>
		    </div>

		    <div class="btn-toolbar">
		        <s:submit cssClass="btn btn-primary pull-right" value="Save"/>
		    </div><br><br><br><br><br><br><br><br>
		</s:form>
	</div>
</body>
</html>