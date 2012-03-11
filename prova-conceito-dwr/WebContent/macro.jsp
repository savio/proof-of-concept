<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prova de conceito - Macro sala de disputa</title>

<script type='text/javascript' src='/prova-conceito-dwr/dwr/engine.js'></script>
<script type='text/javascript' src='/prova-conceito-dwr/dwr/interface/SalaDisputaAjax.js'></script>
<script type='text/javascript' src='/prova-conceito-dwr/dwr/util.js'></script>

<script type="text/javascript">
	dwr.engine.setActiveReverseAjax(true);

	var loteId = '${param.loteId}';
	SalaDisputaAjax.execute(loteId);

	function sendMessage() {
		SalaDisputaAjax.addMessage(loteId, dwr.util.getValue("text"));
  	}

	function changeSituacao(intSituacao) {
		SalaDisputaAjax.changeSituacao(loteId, intSituacao);
  	}
  
</script>

</head>
<body>
	Prova de conceito - Macro sala de disputa - Lote ${param.loteId}
	<br>
	<br> ----
	<p>Situação:
	<div id="lt_situacao"></div>
	</p>
	<p>Meu Lance: <div id="lt_meuLance"></div></p>
	
	<p>Melhor Lance: <div id="lt_melhorLance"></div> </p>
	
	<input type="button" value="update 1" onclick="changeSituacao(1)"/><br>
	<input type="button" value="update 2" onclick="changeSituacao(2)"/><br>
	<input type="button" value="update 3" onclick="changeSituacao(4)"/><br>
	
	----	
	<br>
	----
	
	<!-- CHAT -->
	
	<p>
      Sua mensagem:
      <input id="text" onkeypress="dwr.util.onReturn(event, sendMessage)"/>
      <input type="button" value="Send" onclick="sendMessage()"/>
    </p>
    <hr/>
    
	<ul id="chatlog" style="list-style-type:none;"> </ul>
		
</body>
</html>