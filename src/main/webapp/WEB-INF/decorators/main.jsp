<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>
<%@taglib prefix="s" uri="/struts-tags" %>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
	<title><decorator:title default="myapp"/></title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script src="//ajax.googleapis.com/ajax/libs/angularjs/1.2.23/angular.min.js"></script>
    <script type="text/javascript" src="../../js/app.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>    
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="../../css/style.css">
    <decorator:head/>
</head>
<body id="page-home" ng-app="app">
    <div id="page" class="content">

		<s:if test="#session.username != null">
        <nav class="navbar navbar-default">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#main-menu">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">AdminLiveBlogging</a>
            </div>


            <div class="collapse navbar-collapse" id="main-menu">
                <ul class="nav navbar-nav">
                    <li><a href="../leagues/list">Leagues</a></li>
                </ul>
                <ul class="nav navbar-nav">
                    <li><a href="../teams/list">Teams</a></li>
                </ul>         
                <ul class="nav navbar-nav">
                    <li><a href="../tournaments/list">Tournaments</a></li>
                </ul>        

                <s:if test="#session.role == 'ROLE_ADMIN'">
                    <ul class="nav navbar-nav">
                        <li><a href="../users/list">Users</a></li>
                    </ul>
                </s:if>

                 <ul class="nav navbar-nav">
                    <li>
                        <a href="../../j_spring_security_logout" style="color:blue;">
                            <b class="glyphicon glyphicon-log-out"></b>         Log out (<s:property value="#session.username"/>)
                        </a>
                    </li>
                </ul>
                                                                                       
            </div>

        </nav>
        </s:if>

        <div id="content">
            <div id="main">
            	<decorator:body/>
                <hr />
            </div>
            
        </div>
        
        <div id="footer">
        </div>
        
    </div>
</body>
</html>
