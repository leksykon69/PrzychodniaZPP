<#import "spring.ftl" as spring />

<@mac.header />

<@mac.form>
	<@mac.panel title="Podstawowe Kontrolki">
		<@mac.input label = "TextInput" placeholder="Wpisz coś"/>
		<@mac.input label = "Password" placeholder="Wpisz hasło" password=true />
		<@mac.select label = "Select" options=SampleCombobox />
		<@mac.select label = "MultiSelect" multiple=true options=SampleCombobox />
		<@mac.datepicker label="DatePicker" />
		<@mac.checkbox label = "CheckBox" />
		<@mac.buttonGroup classes="pull-right">	
			<@mac.button value="Zwykły Button" />
			<@mac.saveButton value="Save Button" />
			<@mac.addButton value="Add Button" />
			<@mac.okButton value="OK Button" />
			<@mac.removeButton value="Remove Button" />
			<@mac.closeButton />
		</@mac.buttonGroup>	
		
		<@mac.saveButton />
		<@mac.addButton />
		<@mac.okButton />
		<@mac.removeButton />
	</@mac.panel>
	
	<@mac.panel title="Ulożenie komponentów">
		Cooming soon...
	</@mac.panel>
	
	<@mac.panel title="Tabele">
		Cooming soon...
	</@mac.panel>			
</@mac.form>

<@mac.footer />
