<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${titulo}</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/webjars/bootstrap/5.3.2/css/bootstrap.min.css">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Gestor de Cursos</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/cursos/listar">Cursos</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <h1 class="mb-4">${titulo}</h1>

    <div class="card mb-4">
        <div class="card-header">Búsqueda de Cursos</div>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/cursos/buscar" method="post" class="row g-3">
                <div class="col-auto">
                    <label for="nombre" class="visually-hidden">Buscar por nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Nombre del curso">
                </div>
                <div class="col-auto">
                    <button type="submit" class="btn btn-primary">Buscar</button>
                </div>
            </form>
        </div>
    </div>

    <c:if test="${not empty cursos}">
        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead class="table-dark">
                <tr>
                    <th>Id</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Instructor</th>
                    <th>Duración (horas)</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cursos}" var="curso">
                    <tr>
                        <td>${curso.id}</td>
                        <td>${curso.nombre}</td>
                        <td>${curso.descripcion}</td>
                        <td>${curso.instructor}</td>
                        <td>${curso.duracion}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </c:if>

    <c:if test="${empty cursos}">
        <div class="alert alert-info" role="alert">
            No se encontraron cursos.
        </div>
    </c:if>

    <a href="${pageContext.request.contextPath}/cursos/listar" class="btn btn-secondary mt-3">Volver al listado completo</a>

</div>
</body>
</html>