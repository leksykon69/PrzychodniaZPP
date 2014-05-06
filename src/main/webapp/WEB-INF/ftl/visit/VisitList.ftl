<@mac.header >
	<script>
		$('document').ready(function(){
			$("#generateNewVisits").click(function(){
				openNewWindow("/Przychodnia/visit/generator", "medium");
			});
			$("#addNewVisit").click(function(){
				openNewWindow("/Przychodnia/visit/edit", "short");
			});
			$(".edit-button").click(function(){
				openNewWindow("/Przychodnia/visit/edit?id="+$(this).data("id"), "short");
			});
			$(".remove-button").click(function(){
				if(confirm('Czy na pewno chcesz usunąć wizytę?'))
					sendPost("", {id: $(this).data("id"), remove: "remove"});
			});
			
		})
	</script>
	
</@mac.header>
	<h1><b>Lista Wizyt</b></h1>
	<@mac.panel titleClasses="no-padding" title='
			<ul class="nav nav-tabs">
			<li class="active"><a href="#main" data-toggle="tab">Ogólne</a></li>
			<li><a href="#daysOfWeek" data-toggle="tab">Dni Tygodnia</a></li>
			<li><a href="#hours" data-toggle="tab">Godziny</a></li>
		</ul>
	'>
	<@mac.form>

		<div class="tab-content">
			<div class="tab-pane active" id="main">
				<@mac.row>
					<@mac.rowElement>
						<@mac.datepicker path="visitListForm.dateFrom" label="Data od" />
					</@mac.rowElement>
					<@mac.rowElement>
						<@mac.datepicker path="visitListForm.dateTo" label="Data do" />
					</@mac.rowElement>
					<@mac.rowElement>	
					</@mac.rowElement>
				</@mac.row>
				<@mac.row>
					<@mac.rowElement>
						<@mac.select path="visitListForm.doctor" options=doctors label="Lekarz" combobox=true/>
					</@mac.rowElement>
					<@mac.rowElement>
						<@mac.select path="visitListForm.patient" options=patients label="Pacjent" combobox=true />
					</@mac.rowElement>
					<@mac.rowElement>
						<@mac.select path="visitListForm.room" options=rooms label="Pokój" combobox=true/>	
					</@mac.rowElement>
				</@mac.row>
			</div>
			<div class="tab-pane" id="daysOfWeek">
				<@mac.checkbox path="visitListForm.monday" label="Poniedziałek" />
				<@mac.checkbox path="visitListForm.tuesday" label="Wtorek" />
				<@mac.checkbox path="visitListForm.wednesday" label="Środa" />
				<@mac.checkbox path="visitListForm.thursday" label="Czwartek" />
				<@mac.checkbox path="visitListForm.friday" label="Piątek" />
				<@mac.checkbox path="visitListForm.saturday" label="Sobota" />
				<@mac.checkbox path="visitListForm.sunday" label="Niedziela" />			
			</div>	
			<div class="tab-pane" id="hours">
				<@mac.row>	
					<@mac.rowElement>	
						<@mac.timepicker path="visitListForm.startTime" label="Godzina od" />
					</@mac.rowElement>
					<@mac.rowElement>	
						<@mac.timepicker path="visitListForm.endTime" label="Godzina do" />
					</@mac.rowElement>
					<@mac.rowElement>	
					</@mac.rowElement>
				</@mac.row>
			</div>
		</div>
		<@mac.buttonGroup classes="pull-right">
			<@mac.addButton id="addNewVisit" value="Dodaj nową wizytę" />
			<@mac.button id="generateNewVisits" value="Wygeneruj nowe wizyty" />
			<@mac.button value="Pokaż" id="show" name="show" submit=true />
		</@mac.buttonGroup>
	</@mac.form>
	</@mac.panel>
	
	<#if visits??>
		<#list visits?keys as key>
			<@mac.panel title=key>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th></th>
						<th>Od</th>
						<th>Do</th>
						<th>Lekarz</th>
						<th>Pacjent</th>
						<th>Pokój</th>
						<th></th>
					</tr>	
				</thead>
				<tbody>
					<#list visits[key] as visit>
						<tr <#if visit.actual>class="success"<#elseif visit.archive> class="active"</#if>>
							<td style="padding: 0; width: 40px" ><@mac.editButton classes="edit-button" additional="data-id='"+visit.id+"'"/></td>
							<td>${visit.startHour}</td>
							<td>${visit.endHour}</td>
							<td><#if visit.doctor??>${visit.doctor.fullName}</#if></td>
							<td><#if visit.patient??>${visit.patient.fullName}</#if></td>
							<td><#if visit.room??>${visit.room.fullName}</#if></td>
							<td style="padding: 0; width: 40px"><@mac.removeButton classes="remove-button" additional="data-id='"+visit.id+"'"/></td>
						</tr>
					</#list>
				</tbody>
			</table>	
		</@mac.panel>
	</#list>
	</#if>
<@mac.footer />
