<@mac.header />
	<@mac.panel title='Edycja danych użytkownika'>
		<@mac.form>
						<@mac.select path="userEditForm.user.role" options=roles label="Rola" combobox=true/>
						<@mac.input label = "Imię" path="userEditForm.user.name"/>
						<@mac.input label = "Nazwisko" path="userEditForm.user.surname"/>
						<@mac.input label = "Login" path="userEditForm.user.login"/>
						<@mac.input label = "Hasło" path="userEditForm.user.password" password=true />
						<@mac.input label = "E-mail" path="userEditForm.user.email"/>
						
				<@mac.buttonGroup classes="pull-right">
					<@mac.saveButton value="Zapisz" id="save" name="save" submit=true />
					<@mac.closeButton />
				</@mac.buttonGroup>
		</@mac.form>
	</@mac.panel>
<@mac.footer />
