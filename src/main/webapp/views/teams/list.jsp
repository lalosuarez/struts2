<!DOCTYPE html PUBLIC 
    "-//W3C//DTD XHTML 1.1 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Teams</title>
    <s:head />  
</head>
<body>

    <div class="page-header"><h1>Teams</h1></div>
    <div class="btn-toolbar">
        <a href="add" class="btn btn-success">Add</a>
    </div><br>

    <s:if test="teams.isEmpty()">
        <h3>There are no teams</h3>
    </s:if>
    <s:else>
        <table class="table">
            <thead>
                <tr>
                    <th>Team</th>
                    <th>ISO Name</th>
                    <th>Logo</th>
                    <th>League</th>
                    <th>Status</th>
                    <th>Activities</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="teams" var="team">
                <tr>
                    <td><s:property value="#team.name"/></td>
                    <td><s:property value="#team.iso"/></td>
                    <td>
                        <s:if test="#team.logo == null">none</s:if>
                        <s:else><s:property value="#team.logo"/></s:else>
                    </td>
                    <td><s:property value="#team.league.name"/></td>
                    <td>
                        <s:if test="#team.active"><span class="label label-primary">Enabled</span></s:if>
                        <s:else><span class="label label-danger">Disabled</span></s:else>
                    </td>
                    <td>
                        <a href="edit?team.id=<s:property value='#team.id'/>" class="btn btn-default btn-xs">Edit</a>
                        <s:if test="#team.active">
                            <a href="activate?team.id=<s:property value='#team.id'/>" class="btn btn-danger btn-xs">Disable</a>                            
                        </s:if>
                        <s:else>
                            <a href="activate?team.id=<s:property value='#team.id'/>" class="btn btn-primary btn-xs">Enable</a>                                
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