<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Product</title>
</head>
<body>
<h1>Prodotti</h1>
<table>
	<tr>
		<th>Nome</th>
		<th>Prezzo</th>
	</tr>
	<c:forEach var="prodotto" items="${prodotti}">
		<tr>
			<td><a href="<c:url value="/controller/product.get?id=${prodotto.prezzo}" />">${prodotto.nome}</a></td>
			<td>${prodotto.prezzo}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>