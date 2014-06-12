<@mac.header >
	<script>
		$('document').ready(function(){
			$("#add").click(function(){
				openNewWindow("/Przychodnia/room/edit", "short");
			});
			$(".edit-button").click(function(){
				openNewWindow("/Przychodnia/room/edit?id="+$(this).data("id"), "short");
			});
			$(".remove-button").click(function(){
				if(confirm('Czy na pewno chcesz usunąć pokój?'))
					sendPost("", {id: $(this).data("id"), remove: "remove"});
			});
			
		})
	</script>
	
</@mac.header>
	<h1><b>Lista Pokoi</b></h1>
	<@mac.form>
		<@mac.buttonGroup classes="pull-right">
			<@mac.addButton id="add" value="Dodaj nowy Pokój" />
		</@mac.buttonGroup>
	</@mac.form>
	
	<#if rooms??>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th></th>
						<th>Nazwa</th>
						<th>Numer</th>
						<th>Opis</th>
						<th></th>
					</tr>	
				</thead>
				<tbody>
					<#list rooms as room>
						<tr>
							<td style="padding: 0; width: 40px" ><@mac.editButton classes="edit-button" additional="data-id='"+room.id+"'"/></td>
							<td>${room.name}</td>
							<td>${room.number}</td>
							<td>${room.description!}</td>
							<td style="padding: 0; width: 40px"><@mac.removeButton classes="remove-button" additional="data-id='"+room.id+"'"/></td>
						</tr>
					</#list>
				</tbody>
			</table>	
	</#if>
<@mac.footer />
