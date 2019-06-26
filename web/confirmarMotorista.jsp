<%-- 
    Document   : cadastrarMotorista
    Created on : 26/05/2019, 16:03:52
    Author     : Thaís
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>

        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Confirmar Motorista</title>
        <!-- plugins:css -->
        <link rel="stylesheet" href="bootstrap/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="bootstrap/vendors/iconfonts/ionicons/css/ionicons.css">
        <link rel="stylesheet" href="bootstrap/vendors/iconfonts/typicons/src/font/typicons.css">
        <link rel="stylesheet" href="bootstrap/vendors/iconfonts/flag-icon-css/css/flag-icon.min.css">
        <link rel="stylesheet" href="bootstrap/vendors/css/vendor.bundle.base.css">
        <link rel="stylesheet" href="bootstrap/vendors/css/vendor.bundle.addons.css">

        <link rel="stylesheet" href="bootstrap/css/shared/style.css">
        <link rel="stylesheet" href="bootstrap/css/demo_1/style.css">
        <link rel="shortcut icon" href="bootstrap/images/favicon.png" />
    </head>
    <body>
        <%if (session.getAttribute("userLogado") == null) {
                response.sendRedirect("entrar.jsp");
            }%>

        <c:if test="${listaMotorista == null}">
            <jsp:include page="/BuscaMotorista" flush="true"/>
        </c:if>
        <c:if test="${listaEspera == null}">
            <jsp:include page="/buscaMotoristaEmEspera" flush="true"/>
        </c:if>
        <%@include file="barraMenu.jsp" %>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <!-- Page Title Header Starts-->
                <div class="row page-title-header">
                    <div class="col-md-12">
                        <div class="page-header-toolbar">
                            <div class="sort-wrapper">
                                &nbsp; &nbsp;&nbsp; <button type="button" class="btn btn-primary toolbar-item">Atualizar</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12 stretch-card">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Confirmação de Motorista</h4>
                            <p class="card-description">Motorista</p>
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th> # </th>
                                        <th>ID</th>
                                        <th>CNH</th>
                                        <th>Nome</th>
                                        <th>Email</th>
                                        <th>Telefone</th>
                                        <th>Status</th>
                                        <th>Confirma</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="pass" items="${listaEspera}">

                                        <tr class="table-primary">
                                            <th> # </th>
                                            <th>${pass.id}</th>
                                            <th>${pass.cnh}</th>
                                            <th>${pass.nome}</th>
                                            <th>${pass.email}</th>
                                            <th>${pass.fone}</th>
                                            <th>${pass.status}</th>
                                            <td><a href='<c:url value="/validaMotorista?idMotorista=${pass.id}"/>'<b>Confirmar</b></a></td>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="col-lg-12 stretch-card py-3">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Tabela de Motorista</h4>
                            <p class="card-description">Motorista</p>
                            <table class="table table-bordered">
                                <thead>
                                    <tr>
                                        <th> # </th>
                                        <th>ID</th>
                                        <th>CNH</th>
                                        <th>Nome</th>
                                        <th>Email</th>
                                        <th>Telefone</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="pass" items="${listaMotorista}">

                                        <tr class="table-primary">
                                            <th> # </th>
                                            <th>${pass.id}</th>
                                            <th>${pass.cnh}</th>
                                            <th>${pass.nome}</th>
                                            <th>${pass.email}</th>
                                            <th>${pass.fone}</th>
                                            <th>${pass.status}</th>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:partials/_footer.html -->
            <footer class="footer">
                <div class="container-fluid clearfix">
                    <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © 2019 <a href="index.html" target="_blank">Núcleo de Informatica Campus Urutaí</a>. Todos direitos reservados.</span>
                    <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center">Sistemas de Informação <i class="mdi mdi-heart text-danger"></i>
                    </span>
                </div>
            </footer>
            <!-- partial -->
        </div>

        <!-- container-scroller -->
        <!-- plugins:js -->
        <script src="bootstrap/vendors/js/vendor.bundle.base.js"></script>
        <script src="bootstrap/vendors/js/vendor.bundle.addons.js"></script>
        <!-- endinject -->
        <!-- Plugin js for this page-->
        <!-- End plugin js for this page-->
        <!-- inject:js -->
        <script src="bootstrap/js/shared/off-canvas.js"></script>
        <script src="bootstrap/js/shared/misc.js"></script>
        <!-- endinject -->
        <!-- Custom js for this page-->
        <script src="bootstrap/js/demo_1/dashboard.js"></script>
        <!-- End custom js for this page-->
    </body>
</html>
