<%-- 
    Document   : index
    Created on : 26/05/2019, 16:07:43
    Author     : Thaís
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Menu</title>
        <!-- plugins:css -->
        <link rel="stylesheet" href="bootstrap/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
        <link rel="stylesheet" href="bootstrap/vendors/iconfonts/ionicons/css/ionicons.css">
        <link rel="stylesheet" href="bootstrap/vendors/iconfonts/typicons/src/font/typicons.css">
        <link rel="stylesheet" href="bootstrap/vendors/iconfonts/flag-icon-css/css/flag-icon.min.css">
        <link rel="stylesheet" href="bootstrap/vendors/css/vendor.bundle.base.css">
        <link rel="stylesheet" href="bootstrap/vendors/css/vendor.bundle.addons.css">

        <link rel="stylesheet" href="../../bootstrap/css/shared/style.css">
        <link rel="stylesheet" href="../../bootstrap/css/demo_1/style.css">
        <link rel="shortcut icon" href="../../bootstrap/images/favicon.png" />

    </head>
     
    <body>
        <div class="container-scroller">

            <!-- partial:partials/_navbar.html -->
            
            <nav class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
                
                <div class="text-center navbar-brand-wrapper d-flex align-items-top justify-content-center">

                    <img src="logo.png" alt="logo" />
                </div>
                <div class="navbar-menu-wrapper d-flex align-items-center">
                    <ul class="navbar-nav">
                        <li class="nav-item font-weight-semibold d-none d-lg-block">Sistema de Informação 1ª Turma</li>
                    </ul>
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item dropdown d-none d-xl-inline-block user-dropdown">
                            <a class="nav-link dropdown-toggle" id="UserDropdown" href="index.jsp" data-toggle="dropdown" aria-expanded="false">
                                <img class="img-xs rounded-circle" src="${userLogado.foto}" alt="Profile image"> </a>
                            <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="UserDropdown">
                                <div class="dropdown-header text-center">
                                    <img class="img-md rounded-circle" src="${userLogado.foto}" alt="Profile image">
                                    <p class="mb-1 mt-3 font-weight-semibold">${userLogado.nome}</p>
                                    <p class="font-weight-light text-muted mb-0">${userLogado.email}</p>
                                </div>
                                <form action="sair" method="post">&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" class="btn btn-primary toolbar-item">Sair</button></form>
                            </div>
                        </li>
                    </ul>
                    <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
                        <span class="mdi mdi-menu"></span>
                    </button>
                </div>
            </nav>
            <!-- partial -->
            <div class="container-fluid page-body-wrapper">
                <!-- partial:partials/_sidebar.html -->
                <nav class="sidebar sidebar-offcanvas" id="sidebar">
                    <ul class="nav">
                        <li class="nav-item nav-profile">
                            <a href="#" class="nav-link">
                                <div class="profile-image">
                                    <img class="img-xs rounded-circle" src="${userLogado.foto}" alt="profile image">
                                    <br/>
                                    <br/>
                                    <div class="dot-indicator bg-success"></div>
                                </div>
                                <div class="text-wrapper">
                                    <br/>
                                    <br/>
                                    <p class="designation">${userLogado.nome}</p>
                                    <p class="profile-name">Online</p>

                                </div>
                            </a>
                        </li>
                        <li class="nav-item nav-category">Main Menu</li>
                        <li class="nav-item">
                            <a class="nav-link" href="index.jsp">
                                <i class="menu-icon typcn typcn-document-text"></i>
                                <span class="menu-title">Minhas Info</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="confirmarMotorista.jsp">
                                <i class="menu-icon typcn typcn-shopping-bag"></i>
                                <span class="menu-title">Confirmar Motorista</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="graficos.jsp">
                                <i class="menu-icon typcn typcn-th-large-outline"></i>
                                <span class="menu-title">Gráficos</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="passageiros.jsp">
                                <i class="menu-icon typcn typcn-bell"></i>
                                <span class="menu-title">Passageiros</span>
                            </a>
                        </li>
                    </ul>
                </nav>
                <!-- partial -->
                </body>
                </html>
