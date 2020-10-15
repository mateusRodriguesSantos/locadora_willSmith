<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Will Smith</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
    <form action="PaginaInicialServlet" method="GET">
        <p>O que voçê precisa?</p>
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

    <div id="Anuncio" class="">
        <div id="Conteudo">
            <c:forEach items="${list}" var="list">
                <div id="Imagem">
                    <img src="${list.imagePath}" alt="">
                </div>
                <ul>
                    <li>Descrição: <c:out value="${list.descricao}"></c:out></li>
                    <li>Disponibilidade: <c:out value="${list.disponibilidade}"></c:out></li>
                    <li>Tipo: <c:out value="${list.tipo}"></c:out></li>
                    <li>Área: <c:out value="${list.area}"></c:out></li>
                    <li>Quartos: <c:out value="${list.quartos}"></c:out></li>
                    <li>Banheiros: <c:out value="${list.banheiros}"></c:out></li>
                    <li>Vagas: <c:out value="${list.vagas}"></c:out></li>
                </ul>
                <form action="DetalheAnuncioServlet" method="GET">
                    <input type="hidden" value="${list.idImovel}" name="idImovel">
                    <input type="submit" value="Visitar">
                </form>
            </c:forEach>
        </div>
    </div>


</body>
</html>