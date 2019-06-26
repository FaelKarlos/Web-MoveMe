<%-- 
    Document   : registrar
    Created on : 26/05/2019, 16:08:45
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
        <title>Recuperação de Senha - Confirma</title>
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
        <div class="container-scroller">
            <div class="container-fluid page-body-wrapper full-page-wrapper">
                <div class="content-wrapper d-flex align-items-center auth register-bg-1 theme-one">
                    <div class="row w-100">
                        <div class="col-lg-4 mx-auto">
                            <h2 class="text-center mb-4">Redefinir Senha</h2>
                            <div class="auto-form-wrapper">
                                <c:if test="${msg != null}">
                                    <p style="color: red">${msg}</p>
                                </c:if>
                                <form action="recuperaSenha" method="post">
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="password" class="form-control" placeholder="Nova Senha" name="novaSenha1">
                                            <div class="input-group-append">
                                                <span class="input-group-text">
                                                    <i class="mdi mdi-check-circle-outline"></i>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="password" class="form-control" placeholder="Confirmar Senha" name="novaSenha2" >
                                            <div class="input-group-append">
                                                <span class="input-group-text">
                                                    <i class="mdi mdi-check-circle-outline"></i>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="number" class="form-control" placeholder="id" value="${usuario_atual.id}" readonly="readonly" name="id">
                                            <div class="input-group-append">
                                                <span class="input-group-text">
                                                    <i class="mdi mdi-check-circle-outline"></i>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group d-flex justify-content-center">
                                    </div>
                                    <div class="form-group">
                                        <!--  <a href="redefinirsenha.jsp"><button type="button" class="btn btn-primary toolbar-item">Redefinir Senha</button></a> -->

                                    </div>
                                            <button type="submit" class="btn btn-primary toolbar-item">Recuperar</button>
                                </form>
                                
                            </div>
                        </div>
                    </div>
                </div>
                <!-- content-wrapper ends -->
            </div>
            <!-- page-body-wrapper ends -->
        </div>
        <!-- container-scroller -->
        <!-- plugins:js -->
        <script src="bootstrap/vendors/js/vendor.bundle.base.js"></script>
        <script src="bootstrap/vendors/js/vendor.bundle.addons.js"></script>
        <!-- endinject -->
        <!-- inject:js -->
        <script src="bootstrap/js/shared/off-canvas.js"></script>
        <script src="bootstrap/js/shared/misc.js"></script>
        <!-- endinject -->
    </body>
</html>