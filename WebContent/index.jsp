 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="US-ASCII">
<title>Esame-SIW-2015-LQ</title>
</head>
<body>
<h1>E-commerce LQ</h1>
<ul>
<li><a href="<c:url value="/newProdotto.jsp" />">Inserisci un Nuovo Prodotto</a></li>
<li><a href="<c:url value="/controller/prodotto.list" />">Mostra tutti i Prodotti</a></li>
</ul>
${action}
</body>
</html>