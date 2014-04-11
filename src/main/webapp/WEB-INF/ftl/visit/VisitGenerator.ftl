<@mac.header />
	<@mac.panel title="Automatyczny Kreator Terminów Wizyt">
		<@mac.form>
			<@mac.select path="generateVisitsForm.doctor" options=doctors label="Lekarz" />
			<@mac.select path="generateVisitsForm.room" options=rooms label="Pokój" />
			<@mac.row>
				<@mac.rowElement>
					<@mac.datepicker path="generateVisitsForm.dateFrom" label="Data od" />
				</@mac.rowElement>
				<@mac.rowElement>
					<@mac.datepicker path="generateVisitsForm.dateTo" label="Data do" />
				</@mac.rowElement>
			</@mac.row>	
			<@mac.row>	
				<@mac.rowElement>
					<@mac.timepicker path="generateVisitsForm.startTime" label="Godzina od" />
				</@mac.rowElement>
				<@mac.rowElement>
					<@mac.timepicker path="generateVisitsForm.endTime" label="Godzina do" />
				</@mac.rowElement>
			</@mac.row>
			<@mac.checkbox path="generateVisitsForm.monday" label="Poniedziałek" />
			<@mac.checkbox path="generateVisitsForm.tuesday" label="Wtorek" />
			<@mac.checkbox path="generateVisitsForm.wednesday" label="Środa" />
			<@mac.checkbox path="generateVisitsForm.thursday" label="Czwartek" />
			<@mac.checkbox path="generateVisitsForm.friday" label="Piątek" />
			<@mac.checkbox path="generateVisitsForm.saturday" label="Sobota" />
			<@mac.checkbox path="generateVisitsForm.sunday" label="Niedziela" />
			<@mac.input path="generateVisitsForm.duration" label="Czas trwania wizyty(w min.)" />
			<@mac.saveButton name="generate" classes="pull-right" value="Generuj" submit=true />	
		</@mac.form>
	</@mac.panel>
<@mac.footer />