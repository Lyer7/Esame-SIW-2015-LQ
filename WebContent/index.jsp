 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Esame-SIW-2015-LQ</title>
<style>
body {
	background-image: url("imgs/siw-ecommlq-background.png");
}

h1 {
	font-size: 250%;
	text-align: center;
	color: #FFFF00;
}

li {
	margin-left: auto;
	margin-right: auto;
	text-align: center;
	font-size: 200%;
	color: rgb(255, 0, 0);
}

/* unvisited link */
a:link {
	text-align: center;
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
<h1>E-commerce LQ HOME</h1>
<ul>
<li><a href="<c:url value="/newProdotto.jsp" />">Login</a></li>
<li><a href="<c:url value="/newProdotto.jsp" />">Inserisci un Nuovo Prodotto</a></li>
<li><a href="<c:url value="/newProdotto.jsp" />">I Miei Ordini</a></li>
<li><a href="<c:url value="/controller/prodotto.list" />">Consulta il Catalogo dei Prodotti Disponibili</a></li>
</ul>
${action}
</body>
</html>

