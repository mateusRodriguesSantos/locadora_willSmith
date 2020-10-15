<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Will Smith</title>
</head>
<body>
    <form action="PaginaInicialServlet" method="GET">
        <p>O que vo?? precisa?</p>
        <input type="checkbox" value="Venda" name="disponibilidade" id="Venda">
        <label for="scales">Venda</label>
        <input type="checkbox" value="Aluguel" name="disponibilidade" id="Aluguel">
        <label for="scales">Aluguel</label>

        <p>Qual tipo?</p>
        <select name="tipo">
            <option value="Privado">Privado</option>
            <option value="Comercial">Comercial</option>
         </select>
        <input type="submit" value="Buscar">
    </form>

    
</body>
</html>