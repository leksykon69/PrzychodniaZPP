<@mac.header />
	<@mac.panel title='Edycja Pokoju'>
		<@mac.form>
			<@mac.input path="room.name" label="Nazwa" />
			<@mac.input path="room.number" label="Numer" />
			<@mac.textarea path="room.description" label="Opis" />
			<@mac.buttonGroup classes="pull-right">
				<@mac.saveButton value="Zapisz" id="save" name="save" submit=true />
				<@mac.closeButton />
			</@mac.buttonGroup>
		</@mac.form>
	</@mac.panel>
<@mac.footer />
