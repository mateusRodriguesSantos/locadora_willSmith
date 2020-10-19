<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="CSS/index.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
        integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
        crossorigin="anonymous"></script>
    <meta charset="utf-8" />
    <title>WillSmith</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body>
    <div class="Conteudo w3-container w3-blue w3-round-xlarge" >
        <form class="Form form-group w3-center" style="margin-top: 10vh;" action="PaginaInicialServlet" method="GET">
            <div class="Elementos">
                <div id="OquePrecisa" >
                    <p>O que voçê precisa?</p>
                    <select name="disponibilidade" class="form-group w3-round-large">
                        <option value="Venda">Venda</option>
                        <option value="Aluguel">Aluguel</option>
                    </select>
                </div>
                <div id="QualTipo">
                    <p>Qual tipo?</p>
                    <select name="tipo" class="form-group w3-round-large">
                        <option value="Privado">Privado</option>
                        <option value="Comercial">Comercial</option>
                    </select>
                </div>
                <input id="Butao" class="w3-green w3-round-xlarge" type="submit" value="Buscar">
            </div>
        </form>
    </div>
</body>

</html>