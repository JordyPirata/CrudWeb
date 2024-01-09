<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CRUD</title>
    </head>
    <body>
        <!-- NavBar -->
        <%@ include file="navbar.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <!-- Menú lateral -->
                <div class="col-md-3">
                    <br>
                    <h2>Users List</h2>
                    <table class="table table-bordered">
                        <thead>
                            <tr> 
                                <th class="text-center">Users</th>
                            </tr>
                        </thead>
                    </table>
                </div>

                <!-- Contenido principal -->
                <div class="col-md-9">
                    <br>
                    <h2>Add User</h2>
                    <form action="SvUser" method="post">
                        <div class="form-group">
                            <label for="userName">User:</label>
                            <input type="text" class="form-control" id="userName" name="userName" required style="width: 250px;">
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="text" class="form-control" id="password" name="password" required style="width: 250px;">
                        </div>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </form>

                    <hr>
                    
                    <!-- Checaaar los for de esteeee -->
                    <h2>Delete User</h2>
                    <form action="SvUser" method="post">
                        <div class="form-group">
                            <label for="usuarioEliminar">Name of user to delete:</label>
                            <input type="text" class="form-control" id="usuarioEliminar" name="usuarioEliminar" required style="width: 250px;">
                        </div>
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
