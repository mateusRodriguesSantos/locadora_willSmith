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

                <!--
                    <form action="DetalheAnuncioServlet" method="GET">
                        <input type="hidden" value="${list.idImovel}" name="idImovel">
                        <input type="submit" value="Visitar">
                    </form>
                -->
        </div>
    </div>
</body>
</html>