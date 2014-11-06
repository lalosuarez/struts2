<!DOCTYPE html PUBLIC 
    "-//W3C//DTD XHTML 1.1 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Tournaments</title>
    <s:head />  
</head>
<body>

    <div class="page-header"><h1>Tournaments</h1></div>
    
    <div class="btn-toolbar">
        <a href="add" class="btn btn-success">Add</a>
    </div><br>
	
	<s:if test="!tournaments.isEmpty()">
		<s:form action="search" theme="simple" cssClass="navbar-form navbar-left">
			<div class="form-group">
		    	<s:textfield name="searchParameter" cssClass="form-control"/>
		  	</div>
		  	<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
		</s:form>
	</s:if>
    <s:if test="search">
        <br><a href="list?search=false&searchParameter=&listOfResultsLoaded=false" class="btn btn-primary btn-xs">View general list</a>
    </s:if>
    		
    <s:if test="tournaments.isEmpty()">
        <br><br><br><h3>There are no tournaments</h3>
    </s:if>
    <s:else>
        <table class="table">
            <thead>
                <tr>
                    <th>Tournament</th>
                    <th>Logo</th>
                    <th>Type</th>
                    <th>Status</th>
                    <th>Activities</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="tournaments" var="tournament">
                <tr>
                    <td><s:property value="#tournament.name"/></td>
                    <td>
                    	<s:if test="#tournament.logo == null">none</s:if>
                        <s:else><s:property value="#tournament.logo"/></s:else>
                    </td>
                    <td><s:property value="#tournament.type"/></td>
                    <td>
                        <s:if test="#tournament.enabled"><span class="label label-primary">Enabled</span></s:if>
                        <s:else><span class="label label-danger">Disabled</span></s:else>
                    </td>
                    <td>
                        <a href="edit?tournament.id=<s:property value='#tournament.id'/>" class="btn btn-default btn-xs">Edit</a>
                        <s:if test="#tournament.enabled">
                            <a href="activate?tournament.id=<s:property value='#tournament.id'/>" class="btn btn-danger btn-xs">Disable</a>                            
                        </s:if>
                        <s:else>
                            <a href="activate?tournament.id=<s:property value='#tournament.id'/>" class="btn btn-primary btn-xs">Enable</a>                                
                        </s:else>
                    </td>
                </tr>
                </s:iterator>
            </tbody>
        </table>
        
		<jsp:include page="../pagination/paginator.jsp" />
		            
    </s:else>      
</body>
</html>