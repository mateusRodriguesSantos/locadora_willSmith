<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet" href="CSS/detalhe_anuncio.css">
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

    <title>Will Smith</title>
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
                <div  id="QualTipo">
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
        <div class="Anuncio w3-container w3-round-xlarge" >
            <div id="Conteudo">
                <div id="Imagem">
                    <img src="${imovel.imagePath}" alt="">
                </div>
                <ul>
                    <li>Descrição: <c:out value="${imovel.descricao}"></c:out></li>
                    <li>Disponibilidade: <c:out value="${imovel.disponibilidade}"></c:out></li>
                    <li>Tipo: <c:out value="${imovel.tipo}"></c:out></li>
                    <li>Área: <c:out value="${imovel.area}"></c:out></li>
                    <li>Quartos: <c:out value="${imovel.quartos}"></c:out></li>
                    <li>Banheiros: <c:out value="${imovel.banheiros}"></c:out></li>
                    <li>Vagas: <c:out value="${imovel.vagas}"></c:out></li>
                </ul>
                <div id="Anunciante">
                    <h2>Anunciante</h2>
                    <p>Nome: <c:out value="${anunciante.nome}"></c:out></p>
                    <p>Telefone: <c:out value="${anunciante.telefone}"></c:out></p>
                </div>
                <div id="Endereco">
                    <h3>Endereco</h3>
                    <p>Rua: <c:out value="${endereco.rua}"></c:out></p>
                    <p>Bairro: <c:out value="${endereco.bairro}"></c:out></p>
                    <p>Cidade: <c:out value="${endereco.cidade}"></c:out></p>
                    <p>Numero: <c:out value="${endereco.numero}"></c:out></p>
                    <p>CEP: <c:out value="${endereco.cep}"></c:out></p>
                </div> 
            </div>
    </div>
</body>

</html>