<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>League</title>
	<s:head />	
</head>
<body>
	<div class="content">
		<div class="page-header"><h1>League</h1></div>
		<s:form action="save" method="POST" enctype="multipart/form-data" role="form" theme="simple" cssClass="col-md-6 form form-horizontal">

			<s:hidden name="league.id"/>

		    <div class="form-group">    
		        <label class="col-sm-3 control-label" for="nombre">Name:</label>
		        <div class="col-sm-9">
					<s:textfield name="league.name" cssClass="form-control"/>
		        </div>
		    </div>

		    <div class="form-group">    
		        <label class="col-sm-3 control-label" for="nombre">Logo:</label>
		        <div class="col-sm-9">
					<s:file name="league.logo" cssClass="form-control"/>
		        </div>
		    </div>

		    <div class="btn-toolbar">
		        <s:submit cssClass="btn btn-primary pull-right" value="Save"/>
		    </div>		
			
		</s:form>
	</div>
</body>
</html>