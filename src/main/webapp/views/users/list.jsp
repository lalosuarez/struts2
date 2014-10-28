<!DOCTYPE html PUBLIC 
    "-//W3C//DTD XHTML 1.1 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
    
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Users</title>
    <s:head />  
</head>
<body>

    <div class="page-header"><h1>Users</h1></div>
    <div class="btn-toolbar">
        <a href="add" class="btn btn-success">Add</a>
    </div><br>

    <s:if test="users.isEmpty()">
        <h3>There are no users</h3>
    </s:if>
    <s:else>
        <table class="table">
            <thead>
                <tr>
                    <th>User</th>
                    <th>Password</th>
                    <th>Role</th>
                    <th>Status</th>
                    <th>Activities</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="users" var="user">
                <tr>
                    <td><s:property value="#user.username"/></td>
                    <td><s:property value="#user.password"/></td>
                    <td><s:property value="#user.role.role"/></td>
                    <td>
                        <s:if test="#user.enabled"><span class="label label-primary">Enabled</span></s:if>
                        <s:else><span class="label label-danger">Disabled</span></s:else>
                    </td>
                    <td>
                        <a href="edit?id=<s:property value='#user.username'/>" class="btn btn-default btn-xs">Edit</a>
                        <s:if test="#user.enabled">
                            <a href="activate?id=<s:property value='#user.username'/>" class="btn btn-danger btn-xs">Disable</a>                            
                        </s:if>
                        <s:else>
                            <a href="activate?id=<s:property value='#user.username'/>" class="btn btn-primary btn-xs">Enable</a>                                
                        </s:else>
                    </td>
                </tr>
                </s:iterator>
            </tbody>
        </table>    
    </s:else>      
</body>
</html>