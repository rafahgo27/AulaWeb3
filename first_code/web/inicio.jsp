<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Inicial</title>
    </head>
    <body>
        <h1>Seja Bem-Vindo <%=request.getAttribute("nomeDoUsuario")%>!</h1>
    </body>
</html>
