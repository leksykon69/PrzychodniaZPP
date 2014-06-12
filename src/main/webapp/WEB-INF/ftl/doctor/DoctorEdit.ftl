<@mac.header />
	<h1><b>Edycja Lekarza</b></h1>
	<@mac.form>
		<@mac.panel title="Dane Osobowe">
			<@mac.row>
				<@mac.rowElement>
					<@mac.input path="doctor.name" label="Imię" />
				</@mac.rowElement>
				<@mac.rowElement>
					<@mac.input path="doctor.surname" label="Nazwisko" />
				</@mac.rowElement>
			</@mac.row>
			<@mac.row>
				<@mac.rowElement>
					<@mac.input path="doctor.login" label="Login" />
				</@mac.rowElement>
				<@mac.rowElement>
					<@mac.input path="doctor.password" label="Hasło" />
				</@mac.rowElement>
			</@mac.row>
		</@mac.panel>
		<@mac.panel title="Kontakt">
			<@mac.row>
				<@mac.rowElement>
					<@mac.input path="doctor.email" label="e-mail" />
				</@mac.rowElement>
			</@mac.row>
		</@mac.panel>
		<@mac.buttonGroup classes="pull-right">
			<@mac.saveButton value="Zapisz" id="save" name="save" submit=true />
			<@mac.closeButton />
		</@mac.buttonGroup>
	</@mac.form>
<@mac.footer />
