<!DOCTYPE html>
<html>

  <head>
    <title>Usu�rio</title>
  </head>

  <body>
    <h1><a href="usuario">Usu�rio</a></h1>
    <form>
      <table>
        <tr>
          <td>C�digo</td>
          <td><input name="codigo"></td>
        </tr>
        <tr>
          <td>Nome:</td>
          <td><input name="nome"></td>
        </tr>
        <tr>
          <td>Login:</td>
          <td><input name="login"></td>
        </tr>
        <tr>
          <td>Senha:</td>
          <td><input type="password" name="senha"></td>
        </tr>
      </table>
      <button name="operacao" value="incluir">Incluir</button>
      <button name="operacao" value="excluir">Excluir</button>
      <button name="operacao" value="alterar">Alterar</button>
    </form>
    <b>${msg}</b>
  </body>

</html>