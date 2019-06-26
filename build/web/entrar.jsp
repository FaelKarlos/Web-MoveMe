<%-- 
    Document   : entrar
    Created on : 26/05/2019, 16:06:05
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
        <title>Entrar</title>
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
        <br/>
        <br/>

        <div class="container-scroller">
            <div class="container-fluid page-body-wrapper full-page-wrapper">
                <div class="content-wrapper d-flex align-items-center auth auth-bg-1 theme-one">
                    <div class="row w-100">
                        <div class="col-lg-4 mx-auto">
                            <div class="auto-form-wrapper">

                                <c:if test="${msg != null}">
                                    <p style="color: red">${msg}</p>
                                </c:if>
                                
                                <br/>
                                <form action="validarAdministrador" method="post">
                                    <div class="form-group">
                                        <label class="label">Usuário</label>
                                        <div class="input-group">
                                            <input type="email" class="form-control" placeholder="Username" name="email">
                                            <div class="input-group-append">
                                                <span class="input-group-text">
                                                    <i class="mdi mdi-check-circle-outline"></i>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="label">Senha</label>
                                        <div class="input-group">
                                            <input type="password" class="form-control" placeholder="*********" name="senha">
                                            <div class="input-group-append">
                                                <span class="input-group-text">
                                                    <i class="mdi mdi-check-circle-outline"></i>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <button type="submit" class="btn btn-primary submit-btn btn-block">Login</button>
                                    </div>
                                    <div class="form-group d-flex justify-content-between">
                                        <div class="form-check form-check-flat mt-0">
                                            <label class="form-check-label">
                                                <input type="checkbox" class="form-check-input" checked> Keep me signed in </label>
                                        </div>
                                        <a href="esqueceuSenhaEmail.jsp" class="text-small forgot-password text-black">Esqueceu a senha ?</a>
                                    </div>
                                  <!--  <div class="text-block text-center my-3">
                                        <span class="text-small font-weight-semibold">Não é Membro?</span>
                                        <a href="registrar.jsp" class="text-black text-small">Criar conta</a>
                                    </div> -->
                                </form>
                            </div>
                            <p class="footer-text text-center">copyright © 2019</p>
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
