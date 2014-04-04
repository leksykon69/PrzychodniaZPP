<#macro header>
<!DOCTYPE html>
<html lang="pl">
	<head>
		<title>${pageTitle!}</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="Stylesheet" type="text/css" href="./css/bootstrap-theme.min.css" />
		<link rel="Stylesheet" type="text/css" href="./css/bootstrap.min.css" />
		
		<script type="text/javascript" src="./js/jquery.min.js"></script>		
		<script type="text/javascript" src="./js/bootstrap.min.js"></script>
		<#nested />
	</head>
	<body>
	<div class="container">
</#macro>

<#macro footer>
	</div>
	</body>
</html>
</#macro>

<#macro panel title="">
	<div class="panel panel-default">
		<#if title!="">
			<div class="panel-heading">${title}</div>
		</#if>	
		<div class="panel-body">
			<#nested />
		</div>
	</div>
</#macro>

<#macro form inline=true>
	<form role="form" class="<#if inline>form-inline</#if>">
		<#nested />
	</form>
</#macro>

<#macro input name="" id="" label="" classes="">
	<div class="form-group">
		<label>DUPA</label>
		<input type="text" class="form-control" placeholder="Wpisz cos tutaj"/>
	</div>
</#macro>