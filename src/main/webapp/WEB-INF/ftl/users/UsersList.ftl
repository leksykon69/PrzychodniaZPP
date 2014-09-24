<@mac.header>
<script>
		$('document').ready(function(){
			$(".remove-button").click(function(){
				if(confirm('Czy na pewno chcesz usunąć wizytę?'))
					sendPost("", {id: $(this).data("id"), remove: "remove"});
			});
			$(".edit-button").click(function(){
				openNewWindow("/Przychodnia/users/edit?id="+$(this).data("id"), "short");
			});
			$("#addNewUser").click(function(){
				openNewWindow("/Przychodnia/users/edit", "short");
			});
			
		})
	</script>
</@mac.header>
<h1><b>Lista użytkowników</b></h1>

<@mac.form>
		<@mac.select path="usersListForm.role" options=roles label="Rola" combobox=true/>
		<@mac.buttonGroup classes="pull-right">
			<@mac.addButton id="addNewUser" value="Dodaj nowego użytkownika" />
			<@mac.button value="Pokaż" id="show" name="show" submit=true />
		</@mac.buttonGroup>
</@mac.form>

<table class="table table-striped">
			<thead>
				<tr>
					<th></th>
					<th>lp.</th>
					<th>login</th>
					<th>Imię</th>
					<th>Nazwisko</th>
					<th>E-mail</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<#list userList as user>
						<tr>
							<td><@mac.editButton classes="edit-button" additional="data-id='"+user.id+"'"/></td>
							<td>${user.id}</td>
							<td>${user.login}</td>
							<td>${user.name}</td>
							<td>${user.surname}</td>
							<td>${user.email}</td>
							<td><@mac.removeButton classes="remove-button" additional="data-id='"+user.id+"'"/></td>
						</tr>
				</#list>
			</tbody>
		</table>


<@mac.footer />