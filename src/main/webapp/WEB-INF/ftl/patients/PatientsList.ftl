<@mac.header />
	<h1><b>Lista Pacjentów</b></h1>
	<@mac.panel>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th></th>
					<th>Imię</th>
					<th>Nazwisko</th>
					<th>PESEL</th>
					<th>E-mail</th>
					<th></th>
				</tr>	
			</thead>
			<tbody>
				<#list patients as patient>
					<tr>
						<td style="padding: 0; width: 40px" ><@mac.editButton classes="edit-button" additional="data-id='"+patient.id+"'"/></td>
						<td>${patient.name}</td>
						<td>${patient.surname}</td>
						<td><#if patient.pesel??>${patient.pesel}</#if></td>
						<td><#if patient.email??>${patient.email}</#if></td>
						<td style="padding: 0; width: 40px"><@mac.removeButton classes="remove-button" additional="data-id='"+patient.id+"'"/></td>
					</tr>
				</#list>
			</tbody>
		</table>
	</@mac.panel>
<@mac.footer />