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
                    <h2>Reports List</h2>
                    <table class="table table-bordered">
                        <thead>
                            <tr> 
                                <th class="text-center">Reports</th>
                            </tr>
                        </thead>
                    </table>
                </div>

                <!-- Contenido principal -->
                <div class="col-md-9">
                    <br>
                    <h2>Add Report</h2>
                    <form action="procesarIngreso.jsp" method="post">
                        <div class="form-group">
                            <label for="userId">User Id:</label>
                            <input type="text" class="form-control" id="userId" name="userId" required style="width: 250px;">
                        </div>
                        <div class="form-group">
                            <label for="projectId">Project Id:</label>
                            <input type="text" class="form-control" id="projectId" name="projectId" required style="width: 250px;">
                        </div>
                        <div class="form-group">
                            <label for="date">Date:</label>
                            <input type="text" class="form-control" id="date" name="date" required style="width: 250px;">
                        </div>
                        <div class="form-group">
                            <label for="description">Description:</label>
                            <input type="text" class="form-control" id="description" name="description" required style="width: 250px;">
                        </div>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </form>

                    <hr>

                    <h2>Delete Reports</h2>
                    <form action="procesarEliminacion.jsp" method="post">
                        <div class="form-group">
                            <label for="usuarioEliminar">Id of the project:</label>
                            <input type="text" class="form-control" id="usuarioEliminar" name="usuarioEliminar" required style="width: 250px;">
                        </div>
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

