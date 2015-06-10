<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Product</title>
<style>
body {
	background-color: #000000;
}

h1 {
    font-size:250%;
	text-align: center;
	color: #FFFF00;
}

table {
    font-size:200%;
    color: rgb(255,0,0);
}

/* unvisited link */
a:link {
    color: #FF0000;
}

/* visited link */
a:visited {
    color: #00FF00;
}

/* mouse over link */
a:hover {
    color: #FF00FF;
}

/* selected link */
a:active {
    color: #0000FF;
}

</style>
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