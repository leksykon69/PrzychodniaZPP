<!--
SPIS MAKR:

*** Jeśli macie własne propozycje makr to mówcie

TODO #1 Makra nie są jeszcze bindowane do springa
TODO #2 Należy przenieść z headera skrypty i style do odrębnych plików
TODO #3 Skrypt do closeButton
TODO #4 Walidacja
TODO #5 StackTrace w Źródle strony

Słowo #NESTED po nazwie makra oznacza, że pomiędzy znacznikami danego makra można wprowadzić własny tekst 

** header #NESTED - nagłówek strony

** footer #NESTED - Stopka strony

** panel #NESTED - tworzy panel do formularza
* @classes
* @title

** form #NESTED - formularz
* @classes

** input - zwykły texbox
* @name
* @id
* @label
* @classes
* @placeholder - ta wartość wyświetli się jeśli nic nie będzie wpisane w polu
* @password - true jeśli chcesz aby zamiast literek pojawiały się kropki

** checkbox
* @name
* @id
* @label
* @classes

** checkbox2 - brzydsza ale zajmująca mniej miejsca wersja
* @name
* @id
* @label
* @classes

** select
* @name
* @id
* @label
* @classes
* @options - oczywiście najbezpieczniej jest użyć mapy stringów
* @multiple

** datepicker
* @name
* @id
* @label

** buttonGroup #NESTED - grupuje przyciski w jeden pasek
* @classes

** button - przycisk
* @name
* @id
* @label
* @classes
*** wersje buttona :
** saveButton - zielony przycisk z dyskietką
** addButton - zielony przycisk z plusem
** okButton - zielony przycisk z ptaszkiem
** removeButton - czerwony przycisk z krzyżykiem
** closeButton - niebieski przycisk, jesli nie podasz value wstawi automatycznie slowo "Zamknij"



-->

<#macro header>
<!DOCTYPE html>
<html lang="pl">
	<head>
		<title>${pageTitle!}</title>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="Stylesheet" type="text/css" href="./css/bootstrap-theme.min.css" />
		<link rel="Stylesheet" type="text/css" href="./css/bootstrap.min.css" />
		<link rel="Stylesheet" type="text/css" href="./css/datepicker3.css" />
		
		<script type="text/javascript" src="./js/jquery.min.js"></script>		
		<script type="text/javascript" src="./js/bootstrap.min.js"></script>
		<script type="text/javascript" src="./js/bootstrap-datepicker.js"></script>
		<script type="text/javascript" src="./js/bootstrap-datepicker.pl.js"></script>
		
		<style>
			h7.menu-element{
				border-right: 1px solid #bbbbbb;
				border-left: 1px solid transparent;
				height: 100%;
				width: 192px;
				padding: 12px;
				padding-right: 20px;
				word-spacing: 0;
				cursor: pointer;
			}
			
			a.menu-element{
				text-decoration: none;
				color: inherit;
			}
			
			h7.menu-element:hover{
				background-image: linear-gradient(to bottom,#fefefe 0,#f1f1f1 100%);
			}
			
			div.menu{
				word-spacing: -4px;
				padding-left: 0;
				padding-right: 0;
			}
			
			div.input-panel{
				display: inline-block;
				width: 200px;
			}
			
			div.input-label{
				width: 120px;
			}
			
			div.input-checkbox-panel{
				text-align: center;
			}
		</style>
		
		<script>
			$('document').ready(function(){
				$('.input-group.date').datepicker({
					format: "yyyy-mm-dd",
					language: "pl",
					weekStart: 1,
				    todayBtn: "linked",
				    todayHighlight: true,
			    	autoclose: true,
				});
				
				$('.close-message').click(function(){
					$('.message').slideUp();
				});
			})
			
		</script>
		<#nested />
	</head>
	<body>
		<div class="panel panel-default">
			<div class="panel-heading menu">
				
				<a href="/Przychodnia/" class="menu-element"><h7 class="menu-element"><b>Przychodnia</b></h7></a>
			<#if menu??>
				<#list menu as menuElement>
				<a class="menu-element" href="${menuElement.url}"><h7 class="menu-element"><b>${menuElement.title}</b></h7></a>
				</#list>
			</#if>
			</div>
		</div>
		<div class="container">
		
		<div class="panel panel-default message">
			<div class="panel-body bg-success" style="padding: 10px 15px;">
				POMYŚLNY KOMUNIKAT ZE STRONY<button type="button" class="close close-message" aria-hidden="true">&times;</button>	
			</div>
		</div>
		
		<div class="panel panel-default message">
			<div class="panel-body bg-info" style="padding: 10px 15px;">
				INFORMACJA <button type="button" class="close close-message" aria-hidden="true">&times;</button>	
			</div>
		</div>
		
		<div class="panel panel-default message">
			<div class="panel-body bg-warning" style="padding: 10px 15px;">
				OSTRZEŻENIE <button type="button" class="close close-message" aria-hidden="true">&times;</button>	
			</div>
		</div>
		
		<div class="panel panel-default message">
			<div class="panel-body bg-danger" style="padding: 10px 15px;">
				BŁĄD <button type="button" class="close close-message" aria-hidden="true">&times;</button>	
			</div>
		</div>
		
</#macro>

<#macro footer>
		</div>
	</body>
</html>
</#macro>

<#macro panel title="" classes="">
	<div class="panel panel-default ${classes}">
		<#if title!="">
			<div class="panel-heading">${title}</div>
		</#if>	
		<div class="panel-body">
			<#nested />
		</div>
	</div>
</#macro>

<#macro form classes="">
	<form role="form" class=" ${classes}">
		<#nested />
	</form>
</#macro>

<#macro input name="" id="" label="" classes="" placeholder="" password=false>
	<div class="form-group">
		<#if label!="">
			<div class="input-panel input-label">
				<label>${label}</label>
			</div>
		</#if>
		<div class="input-panel">	
			<input type="<#if password>password<#else>text</#if>" class="form-control input-sm ${classes}" placeholder="${placeholder}"/>
		</div>
	</div>
</#macro>

<#macro checkbox2 label="" name="" id="" classes=""> 
	<div class="checkbox">
		<input type="checkbox" class="${classes}"/><b>${label}</b>
	</div>
</#macro>

<#macro checkbox label="" name="" id="" classes=""> 
	<div class="form-group">
		<#if label!="">
			<div class="input-panel input-label">
				<label>${label}</label>
			</div>
		</#if>
		<div class="input-panel input-checkbox-panel">	
			<input type="checkbox" class="${classes}"/>
		</div>
	</div>
</#macro>

<#macro select label="" multiple=false name="" id="" classes="" options="">
	<div class="form-group">
		<#if label!="">
			<div class="input-panel input-label" <#if multiple>style="position: relative; bottom: 54px;"</#if>>
				<label>${label}</label>
			</div>
		</#if>
		<div class="input-panel">
			<select <#if multiple>multiple </#if>class="form-control input-sm ${classes}">
				<#if options?? >
					<#list options?keys as option>
						<option value="${option}">${options[option]}</option>
					</#list>
				</#if>
			</select>
		</div>
	</div>	
</#macro>

<#macro datepicker name="" id="" label="" >
	<div class="form-group" style="margin-bottom: 5px">
		<#if label!="">
			<div class="input-panel input-label" style="position: relative; bottom: 10px;" >
				<label>${label}</label>
			</div>
		</#if>
		<div class="input-panel">
			<div class="input-group date">
				<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
				<input type="text" class="form-control input-sm">
			</div>
		</div>
	</div>	
</#macro>

<#macro buttonGroup classes="">
	<div class="btn-group ${classes}">
		<#nested />
	</div>
</#macro>

<#macro button value="" classes="" id="" name="" submit=false>
	<button <#if submit>type="submit"<#else>type="button"</#if> class="btn btn-default ${classes}">${value}</button>
</#macro>

<#macro saveButton value="" classes="" id="" name="" submit=false>
	<@button value= "<i class='glyphicon glyphicon-floppy-disk'></i> " + value classes="btn-success " + classes id=id name=name submit=submit />
</#macro>

<#macro addButton value="" classes="" id="" name="" submit=false>
	<@button value= "<i class='glyphicon glyphicon-plus'></i> " + value classes="btn-success " + classes id=id name=name submit=submit />
</#macro>

<#macro okButton value="" classes="" id="" name="" submit=false>
	<@button value= "<i class='glyphicon glyphicon-ok'></i> " + value classes="btn-success " + classes id=id name=name submit=submit />
</#macro>

<#macro removeButton value="" classes="" id="" name="" submit=false>
	<@button value= "<i class='glyphicon glyphicon-remove'></i> " + value classes="btn-danger " + classes id=id name=name submit=submit />
</#macro>

<#macro closeButton value="" classes="" id="" name="" submit=false>
	<#if value==""><#assign resultValue="Zamknij" /><#else><#assign resultValue=value /></#if>
	<@button value=resultValue  classes="btn-primary " + classes id=id name=name submit=submit />
</#macro>