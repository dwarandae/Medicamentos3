<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../resources/template/semantic.min.css">
        <script type="text/javascript" src="../resources/template/jquery.min.js"></script>
        <script type="text/javascript" src="../resources/template/semantic.min.js"></script>
        <title>Medicamentos</title>
    </head>
    <body>
        <div class="ui equal width center aligned grid" style="height: 100%">
            <div class="black row" style="padding-top: 25px; padding-bottom: 10px">
                <div class="left floated two wide column">
                    <s:url id="index" namespace='/' action='index'/>
                    <s:a href="%{index}">
                        <button class="ui inverted blue basic button">PideFarm</button>
                    </s:a>
                </div>
                <div class="right floated two wide column">
                    <div class="ui grid">
                        <div class="column">
                            <div class="ui inverted compact menu">
                                <div class="ui simple dropdown item">
                                    <s:property value="#session.username"/>
                                    <i class="dropdown icon"></i>
                                    <div class="menu">
                                        <s:url id="signOut" namespace='/signOut' action='indexSignOut'/>
                                        <s:a href="%{signOut}">
                                            <div class="item" style="color: #000000">Cerrar sesión</div>
                                        </s:a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>                    
                </div>
            </div>
            <div class="row" style="height: 100%; background-color: #F3F5F8">
                <div class="ui center aligned padded six column grid" style="padding-top: 4rem">
                    <div class="row">
                        <h1>Agregar medicamento</h1>                        
                    </div>
                    <div class="row">                        
                        No se pudo agregar el medicamento. Por favor, vuelva a intentar.
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
