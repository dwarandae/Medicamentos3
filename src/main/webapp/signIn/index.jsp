<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="../resources/template/semantic.min.css">
        <script type="text/javascript" src="../resources/template/semantic.min.js"></script>
        <title>Ingresar</title>
    <head>
    <body>
        <div class="ui equal width center aligned padded grid" style="height: 100%">
            <div class="black row">
                <div class="left floated two wide column">
                    <s:url id="index" namespace='/' action='index'/>
                    <s:a href="%{index}">
                        <button class="ui inverted blue basic button">PideFarm</button>
                    </s:a>
                </div>
                <div class="right floated two wide column">
                    <div class="ui two column grid">
                        <div class="column">
                            <s:url id="signUp" namespace='/signUp' action='indexSignUp'/>
                            <s:a href="%{signUp}">
                                <button class="ui inverted red basic button">Regístrate</button>
                            </s:a>
                        </div>
                        <div class="column">
                            <s:url id="signIn" namespace='/signIn' action='indexSignIn'/>
                            <s:a href="%{signIn}">
                                <button class="ui inverted red basic button">Ingresa</button>
                            </s:a>
                        </div>
                    </div>                    
                </div>
            </div>
            <div class="row" style="height: 100%; background-color: #F3F5F8">
                <div class="ui center aligned padded four column grid" style="padding-top: 4rem">
                    <div class="row">
                        <div class="left aligned four wide column">
                            <h1 style="margin-bottom: 3rem">Registro</h1> 
                            <s:form cssClass="ui form" action="signIn" namespace="/signIn" theme = "simple">
                                <div class="field">
                                    <label>Nombre de usuario</label>
                                    <s:textfield name="username" id="userName"/>
                                </div>
                                <div class="field">
                                    <label>Contraseña</label>
                                    <s:password name="password" id="password"/>
                                </div>
                                <s:submit type="button" cssClass="ui inverted red button" value="Ingresar"/>                         
                            </s:form>
                        </div>                        
                    </div>
                </div>
            </div>
        </div>        
    </h:body>
</html>
