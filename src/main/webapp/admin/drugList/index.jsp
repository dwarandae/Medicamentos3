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
                <div class="ui center aligned padded eight column grid" style="padding-top: 4rem">
                    <div class="row">
                        <h1>Medicamentos en registrados</h1>                        
                    </div>
                    <!-- Add option to create drug -->
                    <div class="row">
                        <s:url id="addDrug" namespace='/addDrug' action='indexAddDrug'/>
                        <s:a href="%{addDrug}">
                            <i class="huge add circle icon"></i>
                        </s:a>
                    </div>
                    <div class="row">                        
                        <div class="ui yellow segment" style="width: 70%">
                            <s:form action="modifyDrug" namespace="/adminDrugList" theme="simple">                                
                                <div class="ui celled relaxed selection list">
                                    <s:iterator value="drugs" status="stat">
                                        <div class="item">
                                            <div class="right floated content">
                                                <s:submit type="button" theme="simple" cssClass="ui inverted orange button" value="%{drugId}" id="item%{drugId}" name="drugIdToModify">
                                                    Modificar
                                                </s:submit>
                                                <s:submit type="button" theme="simple" cssClass="ui inverted red button" value="%{drugId}" id="item%{drugId}" name="drugIdToDelete">
                                                    Eliminar
                                                </s:submit>
                                            </div>
                                            <i class="eyedropper icon"></i>
                                            <div class="content">
                                                <div class="header"><s:property value="brandName"/></div>
                                                <div class="description">
                                                    Precio: $<s:property value="price"/>. 
                                                    Descripción:
                                                    <s:property value="chemicalName"/> - 
                                                    <s:property value="pharmaceuticalName"/>
                                                </div>
                                            </div>
                                        </div>
                                    </s:iterator>                                    
                                </div>
                            </s:form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
