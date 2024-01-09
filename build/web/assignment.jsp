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
                    <h2>Assignments List</h2>
                    <table class="table table-bordered">
                        <thead>
                            <tr> 
                                <th class="text-center">Assignments</th>
                            </tr>
                        </thead>
                    </table>
                </div>

                <!-- Contenido principal -->
                <div class="col-md-9">
                    <br>
                    <h2>Add Assignments</h2>
                    <form action="procesarIngreso.jsp" method="post">
                        <div class="form-group">
                            <label for="">Assignment Name:</label>
                            <input type="text" class="form-control" id="" name="" required style="width: 250px;">
                        </div>
                        <div class="form-group">
                            <label for="projectId">Project Id:</label>
                            <input type="text" class="form-control" id="userId" name="userId" required style="width: 250px;">
                        </div>
                        <div class="form-group">
                            <label for="AssignedHours">Full name:</label>
                            <input type="text" class="form-control" id="AssignedHours" name="AssignedHours" required style="width: 250px;">
                        </div>
                        <div class="form-group">
                            <label for="bonus">Bonus:</label>
                            <input type="text" class="form-control" id="bonus" name="bonus" required style="width: 250px;">
                        </div>
                        <div class="form-group">
                            <label for="assign">Description:</label>
                            <input type="text" class="form-control" id="assign" name="assign" required style="width: 250px;">
                        </div>
                        <div class="form-group">
                            <label for="start">Time:</label>
                            <input type="text" class="form-control" id="bonus" name="bonus" required style="width: 250px;">
                        </div>
                        
                        <button type="submit" class="btn btn-primary">Add</button>
                    </form>

                    <hr>

                    <h2>Delete Assignments</h2>
                    <form action="procesarEliminacion.jsp" method="post">
                        <div class="form-group">
                            <label for="usuarioEliminar">Project Id:</label>
                            <input type="text" class="form-control" id="usuarioEliminar" name="usuarioEliminar" required style="width: 250px;">
                        </div>
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

