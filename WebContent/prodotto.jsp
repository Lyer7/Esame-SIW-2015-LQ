<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Prodotto Inserito</title>
<style>
body {
	background-color: #000000;
}

h1, h2 {
    font-size:250%;
	text-align: center;
	color: #FFFF00;
}

div {
	text-align: center;
    font-size:200%;
    color: rgb(255,0,0);
}

li {
	text-align: center;
    font-size:200%;
    color: rgb(255,0,0);
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

<h1>${prodotto.nome}</h1>
<h2>Dettagli</h2>
<div>Codice: ${prodotto.codice}</div>
<div>Prezzo: ${prodotto.prezzo}</div>
<div>Descrizione: ${prodotto.descrizione}</div>
<ul>
<li><a href="http://localhost:8080/Esame-SIW-2015-LQ">Torna alla Home</a></li>
</ul>
</body>
</html>