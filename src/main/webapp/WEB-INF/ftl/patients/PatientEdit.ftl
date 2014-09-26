<@mac.header />
	<h1><b>Edycja Pacjenta</b></h1>
	<@mac.form>
		<@mac.panel title="Dane Osobowe">
			<@mac.row>
				<@mac.rowElement>
					<@mac.input path="patient.name" label="Imię" />
				</@mac.rowElement>
				<@mac.rowElement>
					<@mac.input path="patient.surname" label="Nazwisko" />
				</@mac.rowElement>
			</@mac.row>
			<@mac.row>
				<@mac.rowElement>
					<@mac.input path="patient.login" label="Login" />
				</@mac.rowElement>
				<@mac.rowElement>
					<@mac.input path="patient.password" label="Hasło" password=true/>
				</@mac.rowElement>
			</@mac.row>
			<@mac.row>
				<@mac.rowElement>
					<@mac.input path="patient.pesel" label="PESEL" />
				</@mac.rowElement>
				<@mac.rowElement>
				</@mac.rowElement>
			</@mac.row>
		</@mac.panel>
		<@mac.panel title="Kontakt">
			<@mac.row>
				<@mac.rowElement>
					<@mac.input path="patient.email" label="e-mail" />
				</@mac.rowElement>
				<@mac.rowElement>
				</@mac.rowElement>
			</@mac.row>
		</@mac.panel>
		<@mac.buttonGroup classes="pull-right">
			<@mac.saveButton value="Zapisz" id="save" name="save" submit=true />
			<@mac.closeButton />
		</@mac.buttonGroup>
	</@mac.form>
<@mac.footer />