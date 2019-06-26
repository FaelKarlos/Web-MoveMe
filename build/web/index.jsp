<%-- 
    Document   : index
    Created on : 26/05/2019, 16:07:43
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
        <title>Inicio</title>
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
        <%@include file="barraMenu.jsp" %>

        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="col-12 grid-margin">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Informações</h4>
                            <c:if test="${msg != null}">
                                <p style="color: red">${msg}</p>
                            </c:if>
                                <form class="form-sample" action="alterarAdmin" method="post">
                                <p class="card-description">Informações Pessoais</p>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group row">
                                            <label class="col-sm-3 col-form-label">Nome</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" value="${userLogado.nome}" name="nome"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group row">
                                            <label class="col-sm-3 col-form-label">Email</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" value="${userLogado.email}" disabled="disabled"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group row">
                                            <label class="col-sm-3 col-form-label">id</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" value="${String.valueOf(userLogado.id)}" name="id" readonly="readonly"/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <br/>
                                <button type="submit" class="btn btn-primary toolbar-item">Alterar</button> &nbsp;&nbsp;&nbsp;
                                <a href="redefinirsenha.jsp"><button type="button" class="btn btn-primary toolbar-item">Redefinir Senha</button></a>
                                &nbsp;&nbsp;&nbsp;
                                <a href="registrar.jsp"><button type="button" class="btn btn-primary toolbar-item">Novo Funcionário</button></a>
                            </form>
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
        <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
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
