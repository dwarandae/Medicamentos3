<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>  
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" href="resources/template/semantic.min.css">
        <script type="text/javascript" src="resources/template/semantic.min.js"></script>
        <title>PideFarm</title>
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
            <div class="row" style="height: 100%; background-color: #21B7D0; color: #FFFFFF">
                <div class="ui center aligned padded four column grid" style="padding-top: 4rem">
                    <div class="row">
                        <img class="ui lmedium circular image" src="resources/template/images/logo.png" />
                    </div>
                    <div class="row">
                        <h1 style="font-size: 5rem">¡Bienvenido a PideFarm!</h1>
                    </div>
                    <div class="row">
                        <div class="ten wide column">
                            <div class="ui horizontal divider" style="color: #FFFFFF">Siempre precios bajos</div>
                        </div>                        
                    </div>                    
                    <div class="row">
                        <div class="column">
                            <s:url id="signUp" namespace='/signUp' action='indexSignUp'/>
                            <s:a href="%{signUp}">
                                <button class="huge ui inverted button">Regístrate</button>
                            </s:a>
                        </div>
                        <div class="column">
                            <s:url id="signIn" namespace='/signIn' action='indexSignIn'/>
                            <s:a href="%{signIn}">
                                <button class="huge ui inverted button">Ingresa</button>
                            </s:a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </h:body>
</html>
