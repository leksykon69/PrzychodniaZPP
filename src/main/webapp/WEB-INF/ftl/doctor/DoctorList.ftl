<@mac.header >
	<script>
		$('document').ready(function(){
			$("#add").click(function(){
				openNewWindow("/Przychodnia/doctor/edit", "short");
			});
			$(".edit-button").click(function(){
				openNewWindow("/Przychodnia/doctor/edit?id="+$(this).data("id"), "short");
			});
			$(".remove-button").click(function(){
				if(confirm('Czy na pewno chcesz usunąć lekarza?'))
					sendPost("", {id: $(this).data("id"), remove: "remove"});
			});
			
		})
	</script>
	
</@mac.header>
	<h1><b>Lista Lekarzy</b></h1>
	<@mac.form>
		<@mac.buttonGroup classes="pull-right">
			<@mac.addButton id="add" value="Dodaj nowego Lekarza" />
		</@mac.buttonGroup>
	</@mac.form>
	
	<#if doctors??>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th></th>
					<th>Imię</th>
					<th>Nazwisko</th>
					<th>E-mail</th>
					<th></th>
				</tr>	
			</thead>
			<tbody>
				<#list doctors as doctor>
					<tr>
						<td style="padding: 0; width: 40px" ><@mac.editButton classes="edit-button" additional="data-id='"+doctor.id+"'"/></td>
						<td>${doctor.name}</td>
						<td>${doctor.surname}</td>
						<td>${doctor.email!}</td>
						<td style="padding: 0; width: 40px"><@mac.removeButton classes="remove-button" additional="data-id='"+doctor.id+"'"/></td>
					</tr>
				</#list>
			</tbody>
		</table>	
	</#if>
<@mac.footer />
