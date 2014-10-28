<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Tournament</title>
	<s:head/>
</head>
<body>
	<div class="content">
		<div class="page-header"><h1>Tournament</h1></div>
			
		<s:form action="save" method="POST" enctype="multipart/form-data" role="form" theme="simple" cssClass="col-md-4 form form-horizontal">
			
	 		<s:hidden name="tournament.id"/>

		    <div class="form-group">    
		        <label class="col-sm-3 control-label">Name:</label>
		        <div class="col-sm-9">
					<s:textfield name="tournament.name" cssClass="form-control"/>
		        </div>
		    </div>

		    <div class="form-group">    
		        <label class="col-sm-3 control-label">Type:</label>
		        <div class="col-sm-9">
					<s:select
					       list="#{'CUP':'CUP', 'LEAGUE':'LEAGUE'}"
					       name="tournament.type"
					       
					       required="true"
					       cssClass="form-control"/>
		        </div>
		    </div>	    

		    <div class="form-group">    
		        <label class="col-sm-3 control-label">Participant leagues:</label>
		        <div class="col-sm-9">
					<s:checkboxlist
					       list="leagues"
					       name="tournamentLeaguesIds"
					       cssClass="checkBox"/>    
		        </div>
		    </div>	   
		    
		    <div class="form-group">    
		        <label class="col-sm-3 control-label">Logo:</label>
		        <div class="col-sm-9">
					<s:file name="tournament.logo" cssClass="form-control"/>
		        </div>
		    </div>

		    <div class="btn-toolbar">
		        <s:submit cssClass="btn btn-primary pull-right" value="Save"/>
		    </div><br><br><br><br><br><br><br><br>
		</s:form>
	</div>
</body>
</html>