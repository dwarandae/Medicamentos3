<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../resources/template/semantic.min.css">
        <script type="text/javascript" src="../resources/template/jquery.min.js"></script>
        <script type="text/javascript" src="../resources/template/semantic.min.js"></script>
        <title>Compra</title>
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
                                        <div class="item">Cerrar sesión</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>                    
                </div>
            </div>
            <div class="row" style="height: 100%; background-color: #F3F5F8">
                <div class="ui center aligned padded four column grid" style="padding-top: 4rem">
                    <div class="row">
                        <div class="ui segment">
                            <div class="left aligned four wide column">
                                <h2 style="margin-bottom: 3rem">Hubo un error mientras procesábamos tu compra, vuelve a intentarlo.</h2>                                
                            </div>
                        </div>                                                
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>