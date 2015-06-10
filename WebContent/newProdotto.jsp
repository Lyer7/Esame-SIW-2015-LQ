<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1" />
	<title>Nuovo Prodotto</title>
	<style>
body {
	background-image: url("imgs/siw-ecommlq-background.png");
}

div {
	text-align: center;
	font-size: 200%;
	color: rgb(255, 0, 0);
}
</style>
</head>
<body>
	<form action="<c:url value="/controller/product.create" />" method="get">
	<div>Nome: <input type="text" name="nome" value="${param.nome}"/> ${nomeErr}</div>
	<div>Codice: <input type="text" name="codice" value="${param.codice}"/> ${codiceErr}</div>
	<div>Prezzo: <input type="text" name="prezzo" value="${param.prezzo}"/> ${prezzoErr}</div>
	<div>Descrizione: <textarea rows="4" cols="50" name="descrizione">${param.descrizione}</textarea></div>
	<div><input type="submit" name="submit" value="invia" /></div>
	</form>
</body>
</html>
