<#import "spring.ftl" as spring />

<@mac.header />

<@mac.form>
	<@mac.panel title="Podstawowe Kontrolki">
		<@mac.input label = "TextInput" placeholder="Wpisz coś"/>
		<@mac.input label = "Password" placeholder="Wpisz hasło" password=true />
		<@mac.select label = "Select" options=SampleCombobox />
		<@mac.select label = "MultiSelect" multiple=true options=SampleCombobox />
		<@mac.datepicker label="DatePicker" />
		<@mac.timepicker label="TimePicker" />
		<@mac.checkbox label = "CheckBox" />
		<@mac.buttonGroup classes="pull-right">	
			<@mac.button value="Zwykły Button" />
			<@mac.saveButton value="Save Button" />
			<@mac.addButton value="Add Button" />
			<@mac.okButton value="OK Button" />
			<@mac.editButton value="Edit Button" />
			<@mac.removeButton value="Remove Button" />
			<@mac.closeButton />
		</@mac.buttonGroup>	
		<@mac.saveButton />
		<@mac.editButton />
		<@mac.addButton />
		<@mac.okButton />
		<@mac.removeButton />
	</@mac.panel>
	
	<@mac.panel title="Ulożenie komponentów">
		<@mac.row>
			<@mac.rowElement>
				<@mac.datepicker label="Data od" />
			</@mac.rowElement>
			<@mac.rowElement>
				<@mac.datepicker label="Data do" />
			</@mac.rowElement>
			<@mac.rowElement>
				<@mac.datepicker label="Data inna" />
			</@mac.rowElement>
		</@mac.row>
	</@mac.panel>
	
	<@mac.panel title="Tabele">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>lp.</th>
					<th>Imię</th>
					<th>Nazwisko</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Anna</td>
					<td>Nowak</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Jan</td>
					<td>Kowalski</td>
				</tr>
				<tr>
					<td>3</td>
					<td>Krzysztof</td>
					<td>Wiśniewski</td>
				</tr>
			<tbody>
		</table>
	</@mac.panel>			
</@mac.form>

<@mac.footer />
