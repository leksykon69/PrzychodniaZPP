<@mac.header />
	<@mac.panel title='Edycja Wizyty'>
		<@mac.form>
			<@mac.row>
				<@mac.rowElement>
					<@mac.input path="visitEditForm.date" label="Data" readonly=true/>
				</@mac.rowElement>
				<@mac.rowElement>
					<@mac.select path="visitEditForm.visit.doctor" options=doctors label="Lekarz" readonly=true/>
				</@mac.rowElement>
			</@mac.row>
			<@mac.row>
				<@mac.rowElement>
					<@mac.input path="visitEditForm.startHour" label="Godzina od" readonly=true/>
				</@mac.rowElement>
				<@mac.rowElement>
					<@mac.input path="visitEditForm.endHour" label="Godzina do" readonly=true/>
				</@mac.rowElement>
			</@mac.row>
			<@mac.row>
				<@mac.rowElement>
					<@mac.select path="visitEditForm.visit.patient" options=patients label="Pacjent" />
				</@mac.rowElement>
				<@mac.rowElement>
					<@mac.select path="visitEditForm.visit.room" options=rooms label="Pokój" readonly=true />
				</@mac.rowElement>
			</@mac.row>
			<@mac.textarea path="visitEditForm.visit.description"label="Opis wizyty" />
			<@mac.buttonGroup classes="pull-right">
				<@mac.saveButton value="Zapisz" id="save" name="save" submit=true />
				<@mac.closeButton />
			</@mac.buttonGroup>
		</@mac.form>
	</@mac.panel>
<@mac.footer />
