<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
	
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title>Team</title>
	<s:head/>
</head>
<body>
	<div class="content" ng-controller="TeamCtrl">
		<div class="page-header"><h1>Team</h1></div>
		<s:form action="save" method="POST" enctype="multipart/form-data" role="form" theme="simple" cssClass="col-md-4 form form-horizontal">
			
	 		<s:hidden name="team.id"/>

		    <div class="form-group">    
		        <label class="col-sm-3 control-label" for="nombre">League:</label>
		        <div class="col-sm-9">
			       <s:hidden name="league.id" id="leagueId"/>
			       <s:textfield name="league.name" id="leagueInput" cssClass="form-control"/>
		        </div>
		    </div>	

		    <div class="form-group">    
		        <label class="col-sm-3 control-label" for="nombre">Name:</label>
		        <div class="col-sm-9">
					<s:textfield name="team.name" cssClass="form-control"/>
		        </div>
		    </div>

		    <div class="form-group">    
		        <label class="col-sm-3 control-label" for="nombre">Iso:</label>
		        <div class="col-sm-9">
					<s:textfield name="team.iso" cssClass="form-control"/>
		        </div>
		    </div>	    

		    <div class="form-group">    
		        <label class="col-sm-3 control-label" for="nombre">Logo:</label>
		        <div class="col-sm-9">
					<s:file name="team.logo" cssClass="form-control"/>
		        </div>
		    </div>

		    <div class="btn-toolbar">
		        <s:submit cssClass="btn btn-primary pull-right" value="Save"/>
		    </div><br><br><br><br><br><br><br><br>
		</s:form>
	</div>

</body>
</html>