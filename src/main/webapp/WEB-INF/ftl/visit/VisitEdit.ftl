<@mac.header />
	<@mac.panel title='Edycja Wizyty'>
		<@mac.form>
			<@mac.datepicker path="visitEditForm.date" label="Data" />
			<@mac.timepicker path="visitEditForm.startHour" label="Godzina od" />
			<@mac.timepicker path="visitEditForm.endHour" label="Godzina do" />
			<@mac.select path="visitEditForm.visit.doctor" options=doctors label="Lekarz" />
			<@mac.select path="visitEditForm.visit.patient" options=patients label="Pacjent" combobox=true />
			<@mac.select path="visitEditForm.visit.room" options=rooms label="Pokój" />	
			<@mac.buttonGroup classes="pull-right">
				<@mac.saveButton value="Zapisz" id="save" name="save" submit=true />
				<@mac.closeButton />
			</@mac.buttonGroup>
		</@mac.form>
	</@mac.panel>
<@mac.footer />
