<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <div class="container-fluid">
            
            <div class="row">
                <!-- Menú lateral -->
                <div class="col-md-3">
                    <br>
                    <h2>Usuarios</h2>
                    <select class="form-control" id="listaUsuarios" name="listaUsuarios">
                        <!-- Aquí se cargarán dinámicamente los usuarios -->
                    </select>
                </div>

                <!-- Contenido principal -->
                <div class="col-md-9">
                    <br>
                    <h2>Ingresar Usuario</h2>
                    <form action="procesarIngreso.jsp" method="post">
                        <div class="form-group">
                            <label for="usuario">Usuario:</label>
                            <input type="text" class="form-control" id="usuario" name="usuario" required>
                        </div>
                        <div class="form-group">
                            <label for="contrasena">Contraseña:</label>
                            <input type="password" class="form-control" id="contrasena" name="contrasena" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Ingresar</button>
                    </form>

                    <hr>

                    <h2>Eliminar Usuario</h2>
                    <form action="procesarEliminacion.jsp" method="post">
                        <div class="form-group">
                            <label for="usuarioEliminar">Usuario a eliminar:</label>
                            <input type="text" class="form-control" id="usuarioEliminar" name="usuarioEliminar" required>
                        </div>
                        <button type="submit" class="btn btn-danger">Eliminar</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>