<%-- 
    Document   : registrar
    Created on : 26/05/2019, 16:08:45
    Author     : Thaís
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Registro - 2</title>
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
                            <h2 class="text-center mb-4">Registrar</h2>
                            <div class="auto-form-wrapper">

                                <c:if test="${msg != null}">
                                    <p style="color: red">${msg}</p>
                                </c:if>

                                <form action="upload" method="post" enctype="multipart/form-data">

                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="text" class="form-control" value="${admin.nome}">
                                            <div class="input-group-append">
                                                <span class="input-group-text">
                                                    <i class="mdi mdi-check-circle-outline"></i>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                            <input type="email" class="form-control" value="${admin.email}">
                                            <div class="input-group-append">
                                                <span class="input-group-text">
                                                    <i class="mdi mdi-check-circle-outline"></i>
                                                </span>
                                            </div>
                                        </div>
                                        <br/>
                                        <input type="file" name="file" id="file" accept=".png, .jpg, .jpeg"/> 
                                    </div>

                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary submit-btn btn-block">Registrar</button>
                                    </div>
                                    <div class="text-block text-center my-3">
                                        <span class="text-small font-weight-semibold">Já tem e conta?</span>
                                        <a href="entrar.jsp" class="text-black text-small">Entrar</a>
                                    </div>

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