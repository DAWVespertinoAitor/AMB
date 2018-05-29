<%-- 
    Document   : index
    Created on : 29-may-2018, 11:51:02
    Author     : aitor
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>AMB - Inicio</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css" media="screen" />
        <script src="http://code.jquery.com/jquery-latest.js">
        </script>
    </head>
    <body>

        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar" style="color: white; margin-top: 15px;">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" href="#" style="margin-bottom: 25px;"><img src="IMG/Pagina/3_Flat_logo_on_transparent_95x122.png" height="52px"/></a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar"  style="margin-top: 15px; margin-bottom: 15px;">
                    <ul class="nav navbar-nav">
                        <li><input type="text" style="margin-top: 10px; height: 35px; max-width: 200px;" class="btn" id="buscador" placeholder="Buscar productos..." title="Busca un producto"></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">

                        <li><a href="#"><span class="glyphicon glyphicon-user"></span> Mi Cuenta</a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Carrito</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container-fluid">
            <div class="row content">
                <div class="col-sm-3 sidenav hidden-xs">
                    <button id="categorias" class="btn dropdown-toggle" style="background-color: #5d202a; color: white; margin-top: 10px;" type="button" data-toggle="dropdown">
                        <!--<img src="./IMG/Pagina/menu-icon.png" width="20px"/>--> Categorias
                        <span class="caret"></span>
                    </button>
                    <div id="listaCate">
                        <c:if test="${sessionScope.categoriasSesion != null}">
                            <ul class='nav nav-stacked'>
                                <c:forEach var="cate" items="${sessionScope.categoriasSesion}">
                                    <%System.out.println("eeeeeeeeeeee");%>
                                    <li><a href=\"Controlador?cate="${cate.nombre}><c:out value="${cate.nombre}"/></a></li>
                                    </c:forEach>
                            </ul>
                        </c:if>
                    </div>
                </div>
                <br>

                <div class="col-sm-9">
                    <div class="row">
                        <div class="col-sm-3">
                            <div class="panel panel-primary" style="border-color: #5d202a;">
                                <div class="panel-heading"  style="background-color: #5d202a; border-bottom-color: #5d202a;">ARTICULO 1</div>
                                <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                                <div class="panel-footer">Breve descripción</div>
                            </div>
                        </div>
                        <div class="col-sm-3"> 
                            <div class="panel panel-primary"  style="border-color: #5d202a;">
                                <div class="panel-heading" style="background-color: #5d202a; border-bottom-color: #5d202a;">ARTICULO 2</div>
                                <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                                <div class="panel-footer">Breve descripción</div>
                            </div>
                        </div>
                        <div class="col-sm-3"> 
                            <div class="panel panel-primary"  style="border-color: #5d202a;">
                                <div class="panel-heading" style="background-color: #5d202a; border-bottom-color: #5d202a;">ARTICULO 3</div>
                                <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                                <div class="panel-footer">Breve descripción </div>
                            </div>
                        </div> 
                    </div>    
                    <div class="row">
                        <div class="col-sm-3">
                            <div class="panel panel-primary" style="border-color: #5d202a;">
                                <div class="panel-heading"  style="background-color: #5d202a; border-bottom-color: #5d202a;">ARTICULO 4</div>
                                <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                                <div class="panel-footer">Breve descripción</div>
                            </div>
                        </div>
                        <div class="col-sm-3"> 
                            <div class="panel panel-primary"  style="border-color: #5d202a;">
                                <div class="panel-heading" style="background-color: #5d202a; border-bottom-color: #5d202a;">ARTICULO 5</div>
                                <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                                <div class="panel-footer">Breve descripción</div>
                            </div>
                        </div>
                        <div class="col-sm-3"> 
                            <div class="panel panel-primary"  style="border-color: #5d202a;">
                                <div class="panel-heading" style="background-color: #5d202a; border-bottom-color: #5d202a;">ARTICULO 6</div>
                                <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
                                <div class="panel-footer">Breve descripción </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br><br>
        <footer class="container-fluid text-center">
            <p>Footer Text</p>
        </footer>
    </body>
    <script>
        <c:if test="${sessionScope.categoriasSesion == null}">
        $(document).ready(function () {
            $.post('Categorias', {

            }, function (responseText) {
                $('#listaCate').html(responseText);
            });
        });
        </c:if>
    </script>    
</html>
