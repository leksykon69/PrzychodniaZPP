<#import "spring.ftl" as spring />
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />


<@mac.headerBezMenu />


<div style="margin-top:80px; "></div>
	<@mac.panel title='Logowanie'>
<form name='f' action="<c:url value='j_spring_security_check' />" method='POST'>
<div style="width: 400px; float:left" >
<div style="margin-top:80px; "></div>
<@mac.row>
			<@mac.rowElement>
				<@mac.input label = "Login" placeholder="Wpisz nazwę użytkownika"/>
			</@mac.rowElement>
		
</@mac.row>

<@mac.row>
			<@mac.rowElement>
				<@mac.input label = "Hasło" placeholder="Wpisz hasło" password=true />
			</@mac.rowElement>
		
			
</@mac.row>

<@mac.row>
			<@mac.rowElement>
			</@mac.rowElement>
			<@mac.rowElement>
			
			<@mac.okButton value="Zaloguj" />
			</@mac.rowElement>
		
			
</@mac.row>

</div>

<div style="float:left">
<img src="/Przychodnia/img/lekarz1.jpg" alt=" Przychodnia"  />
</div>
<div style="clear:both"></div>
		</form>
	</@mac.panel>
	
	<@mac.footer />
	