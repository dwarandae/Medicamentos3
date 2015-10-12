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
                                <h1 style="margin-bottom: 3rem">Carrito de compras</h1>
                                <s:form action="doPurchase" namespace="/purchase" theme="simple" validate="true">
                                    <table class="ui blue definition striped selectable table">
                                        <tbody>
                                            <tr class="top aligned">
                                                <td>Items:</td>
                                                <td>
                                                    <!-- Iter sobre los items del carrito de compras -->
                                                    <s:iterator value="purchase.purchaseItems" status="stat">
                                                        <div class="ui list">
                                                            <div class="item">
                                                                <i class="eyedropper icon"></i>                                                        
                                                                <div class="content" style="width: 100%">
                                                                    <div class="header">
                                                                        <s:property value="drug.brandName"/>
                                                                        <div class="right floated content">
                                                                            <s:submit type="button" theme="simple" cssClass="mini circular ui icon basic red button" name="itemIdToDelete[%{#stat.index}]" id="item%{purchaseItemId}" value="%{purchaseItemId}">
                                                                                <i class='remove icon'></i>
                                                                            </s:submit>
                                                                        </div>
                                                                    </div>
                                                                    <div class="description">
                                                                        <div class="ui list">
                                                                            <div class="fluid item">
                                                                                <div class="right floated content">
                                                                                    <s:textfield value="%{amount}" name="amounts[%{#stat.index}]" id="itemAmount%{#stat.index}" theme="simple" cssClass="ui mini input" style="text-align: right" size="10" required="true"/>
                                                                                </div>
                                                                                Cantidad:
                                                                            </div>
                                                                            <div class="item">
                                                                                <div class="right floated content"><s:property value="price"/></div>
                                                                                $/u:
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </s:iterator>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>Total:</td>
                                                <td class="right aligned"><s:property value="purchase.totalPrice"/></td>
                                            </tr>
                                            <tr>
                                                <td>Forma de pago:</td>
                                                <td class="right aligned">
                                                    <s:select list="paymentMethods" name="selectedPaymentMethod" theme="simple"/>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                    <s:submit theme="simple" cssClass="ui inverted green button" value="Comprar" id="submit"/>
                                    <s:fielderror theme="simple" cssClass="ui list"/>
                                </s:form>                                
                            </div>
                        </div>                                                
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>