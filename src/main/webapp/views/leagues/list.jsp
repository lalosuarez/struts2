<!DOCTYPE html PUBLIC 
    "-//W3C//DTD XHTML 1.1 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Leagues</title>
    <s:head />  
</head>
<body>
    <div>

        <div class="page-header"><h1>Leagues</h1></div>
        <div class="btn-toolbar">
            <a href="add" class="btn btn-success">Add</a>
        </div><br>

        <s:if test="leagues.isEmpty()">
            <h3>There are no leagues</h3>
        </s:if>
        <s:else>
            <table class="table">
                <thead>
                    <tr>
                        <th>League</th>
                        <th>Logo</th>
                        <th>Status</th>
                        <th>Activities</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="leagues" var="league">
                    <tr>
                        <td><s:property value="#league.name"/></td>
                        <td>
                            <s:if test="#league.logo == null">none</s:if>
                            <s:else><s:property value="#league.logo"/></s:else>
                        </td>
                        <td>
                            <s:if test="#league.active"><span class="label label-primary">Enabled</span></s:if>
                            <s:else><span class="label label-danger">Disabled</span></s:else>
                        </td>
                        <td>
                            <a href="edit?league.id=<s:property value='#league.id'/>" class="btn btn-default btn-xs">Edit</a>
                            <s:if test="#league.active">
                                <a href="activate?league.id=<s:property value='#league.id'/>" class="btn btn-danger btn-xs">Disable</a>                            
                            </s:if>
                            <s:else>
                                <a href="activate?league.id=<s:property value='#league.id'/>" class="btn btn-primary btn-xs">Enable</a>                                
                            </s:else>
                        </td>
                    </tr>
                    </s:iterator>
                </tbody>
            </table>    
        </s:else>         
    </div>     
</body>
</html>