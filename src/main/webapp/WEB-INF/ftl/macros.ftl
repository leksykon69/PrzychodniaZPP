<!--
SPIS MAKR:

*** Jeśli macie własne propozycje makr to mówcie

TODO #2 Należy przenieść z headera skrypty i style do odrębnych plików
TODO #3 Skrypt do closeButton
TODO #4 Walidacja
TODO #5 StackTrace w Źródle strony

Słowo #NESTED po nazwie makra oznacza, że pomiędzy znacznikami danego makra można wprowadzić własny tekst 

** header #NESTED - nagłówek strony

** footer #NESTED - Stopka strony

** panel #NESTED - tworzy panel do formularza
* @classes
* @titleClasses
* @title

** row #NESTED - wiersz kontrolek na panelu

** rowElement #NESTED - element wiersza kontrolek

** form #NESTED - formularz
* @classes

** input - zwykły texbox
* @path
* @id
* @label
* @classes
* @placeholder - ta wartość wyświetli się jeśli nic nie będzie wpisane w polu
* @password - true jeśli chcesz aby zamiast literek pojawiały się kropki

** checkbox
* @path
* @id
* @label
* @classes

** checkbox2 - brzydsza ale zajmująca mniej miejsca wersja
* @path
* @id
* @label
* @classes

** select
* @path
* @id
* @label
* @classes
* @options - oczywiście najbezpieczniej jest użyć mapy stringów
* @multiple

** datepicker
* @path
* @id
* @label

** timepicker
* @path
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
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<link rel="Stylesheet" type="text/css" href="/Przychodnia/css/bootstrap-theme.min.css" />
		<link rel="Stylesheet" type="text/css" href="/Przychodnia/css/bootstrap.min.css" />
		<link rel="Stylesheet" type="text/css" href="/Przychodnia/css/bootstrap-timepicker.min.css" />
		<link rel="Stylesheet" type="text/css" href="/Przychodnia/css/datepicker3.css" />
		
		<script type="text/javascript" src="/Przychodnia/js/jquery.min.js"></script>		
		<script type="text/javascript" src="/Przychodnia/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/Przychodnia/js/bootstrap-datepicker.js"></script>
		<script type="text/javascript" src="/Przychodnia/js/bootstrap-timepicker.min.js"></script>
		<script type="text/javascript" src="/Przychodnia/js/bootstrap-datepicker.pl.js"></script>

		<style>
			body {  
				min-width: ${windowWidth.minWindowWidth}; 
			}		
		
			*.container{
				width: ${windowWidth.contentWidth};
			}
		</style>
		
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
			
			div.row-element{
				float: left;
				width: 360px;
				position: relative;
				padding-left: 15px;
			}
			
			*.no-padding{
				padding: 0px;
			}
		</style>
		
		<script>
			$('document').ready(function(){
				$('.input-group.date').datepicker({
					format: "d MM yyyy",
					language: "pl",
					weekStart: 1,
				    todayBtn: "linked",
				    todayHighlight: true,
			    	autoclose: true,
				});
				$(".bootstrap-timepicker input[type=text]").timepicker({
					minuteStep: 5,
					showSeconds: false,
					showMeridian: false,
					defaultTime: '00:00'
				});
        
				$('.close-message').click(function(){
					$('.message').slideUp();
				});
			});
			
			
			function openNewWindow(url, type){
				var height, width, fullscreen;
				switch(type){
					case 'long':
						width= "1300px";
						fullscreen ="yes";
						break;
					case 'medium':
						width= "900px";
						fullscreen = "no";
						break;
					case 'short':
						height= "600px";
						fullscreen = "no";
						break;	
				}
				height= "600px";
				window.open(url, "_blank","width="+width+",height="+height)
			}
		</script>
		<#nested />
	</head>
	<body>
		<#if showMenu>
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
		</#if>
		<div class="container">
		<#if message??>
		<div class="panel panel-default message">
			<div class="panel-body ${message.type.backgroundColor}" style="padding: 10px 15px;">
				<i class="glyphicon glyphicon-${message.type.iconName}"></i> <b>${message.message}</b><button type="button" class="close close-message" aria-hidden="true">&times;</button>	
			</div>
		</div>
		</#if>
		
		
</#macro>

<#macro footer>
		</div>
	</body>
</html>
</#macro>

<#macro panel title="" classes="" titleClasses="" contentClasses="">
	<div class="panel panel-default ${classes}">
		<#if title!="">
			<div class="panel-heading ${titleClasses}">${title}</div>
		</#if>	
		<div class="panel-body ${contentClasses}}">
			<div class="container-fluid">
			<#nested />
			</div>	
		</div>
	</div>
</#macro>

<#macro row>
	<div class="row">
		<#nested />
	</div>	
</#macro>

<#macro rowElement>
	<div class="row-element">
		<#nested />
	</div>
</#macro>

<#macro form classes="">
	<form role="form" method="post" class=" ${classes}">
		<#nested />
	</form>
</#macro>

<#macro input path="" id="" label="" classes="" placeholder="" password=false>
	<div class="form-group">
		<#if label!="">
			
			<div class="input-panel input-label">
				<label>${label}</label>
			</div>
		</#if>
		<div class="input-panel">
			<#if path!="">
				<@spring.bind path/>	
				<input id="${id}" name="${spring.status.expression}" value="${spring.status.value?default("")}" type="<#if password>password<#else>text</#if>" class="form-control input-sm ${classes}" placeholder="${placeholder}"/>
			<#else>
				<input id="${id}" type="<#if password>password<#else>text</#if>" class="form-control input-sm ${classes}" placeholder="${placeholder}"/>
			</#if>
		</div>
	</div>
</#macro>

<#macro checkbox2 label="" path="" id="" classes="">
	<div class="checkbox">
	<#if path!="">
		<@spring.bind path/>
		<input id="${id}" name="${spring.status.expression}" checked="${spring.status.value}" type="checkbox" class="${classes}"/><b>${label}</b>
	<#else>
		<input id="${id}" type="checkbox" class="${classes}"/><b>${label}</b>
	</#if>	
	</div>
</#macro>

<#macro checkbox label="" path="" id="" classes=""> 
	<div class="form-group">
		<#if label!="">
			<div class="input-panel input-label">
				<label>${label}</label>
			</div>
		</#if>
		<div class="input-panel input-checkbox-panel">	
			<#if path!="">
				<@spring.bind path/>
				<input id="${id}" name="${spring.status.expression}" <#if spring.status.value=="true" >checked </#if> type="checkbox" class="${classes}"/>
				<input type="hidden" value="on" name="_${spring.status.expression}"/>
			<#else>
				<input id="${id}" type="checkbox" class="${classes}"/>
			</#if>	
		</div>
	</div>
</#macro>

<#macro select label="" multiple=false path="" id="" classes="" options="">
	<div class="form-group">
		<#if label!="">
			<div class="input-panel input-label" <#if multiple>style="position: relative; bottom: 54px;"</#if>>
				<label>${label}</label>
			</div>
		</#if>
		<div class="input-panel">
		<#if path!="">
			<@spring.bind path/>
			<select id="${id}" name="${spring.status.expression}" <#if multiple>multiple </#if>class="form-control input-sm ${classes}">
				<#if options?? && options?is_hash>
					<#list options?keys as option>
						<option value="${option}" <#if option == spring.status.value>selected</#if>>${options[option]}</option>
					</#list>
				</#if>
			</select>
		<#else>
			<select id="${id}" <#if multiple>multiple </#if>class="form-control input-sm ${classes}">
				<#if options?? && options?is_hash>
					<#list options?keys as option>
						<option value="${option}">${options[option]}</option>
					</#list>
				</#if>
			</select>
		</#if>	
		</div>
	</div>	
</#macro>

<#macro datepicker path="" id="" label="" >
	<div class="form-group" style="margin-bottom: 5px">
		<#if label!="">
			<div class="input-panel input-label" style="position: relative; bottom: 10px;" >
				<label>${label}</label>
			</div>
		</#if>
		<div class="input-panel">
			<div class="input-group date">
			<#if path!="">	
				<@spring.bind path/>				
				<input id="${id}" name="${spring.status.expression}" type="text" class="form-control input-sm" value="${spring.status.value}" readonly>
			<#else>
				<input id="${id}" type="text" class="form-control input-sm" readonly>
			</#if>	
				<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
			</div>
		</div>
	</div>	
</#macro>

<#macro timepicker path="" id="" label="" >
	<div class="form-group" style="margin-bottom: 5px">
		<#if label!="">
			<div class="input-panel input-label" style="position: relative; bottom: 10px;" >
				<label>${label}</label>
			</div>
		</#if>
		<div class="input-panel">
			<div class="input-group bootstrap-timepicker">
			<#if path!="">	
				<@spring.bind path/>
				<input id="${id}" name="${spring.status.expression}" value="${spring.status.value}" type="text" class="form-control input-sm" readonly>
			<#else>	
				<input id="${id}" type="text" class="form-control input-sm" readonly>
			</#if>
				<span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>    
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
	<button name="${name}" id="${id}" <#if submit>type="submit"<#else>type="button"</#if> class="btn btn-default ${classes}">${value}</button>
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

<#macro editButton value="" classes="" id="" name="" submit=false>
	<@button value= "<i class='glyphicon glyphicon-pencil'></i> " + value classes="btn-success	 " + classes id=id name=name submit=submit />
</#macro>


<#macro closeButton value="" classes="" id="" name="" submit=false>
	<#if value==""><#assign resultValue="Zamknij" /><#else><#assign resultValue=value /></#if>
	<@button value=resultValue  classes="btn-primary " + classes id=id name=name submit=submit />
</#macro>