<@mac.header>
	<style>
		div.graph-bar{
			border: solid 1px gray;
			height: 24px;
			border-radius: 4px;
		}
	</style>
</@mac.header>
	<h1><b>Statystyki</b></h1>
	<#assign menuTabs = "<ul class=\"nav nav-tabs\"><li" />
	<#if activeTab=="main"><#assign menuTabs = menuTabs + " class=\"active\"" /></#if>
	<#assign menuTabs = menuTabs +"><a href=\"#main\" data-toggle=\"tab\">Ogólne</a></li><li" />
	<#if activeTab=="doctor"><#assign menuTabs = menuTabs + " class=\"active\"" /></#if>
	<#assign menuTabs = menuTabs +"><a href=\"#doctor\" data-toggle=\"tab\">Lekarze</a></li><li" />
	<#if activeTab=="patient"><#assign menuTabs = menuTabs + " class=\"active\"" /></#if>
	<#assign menuTabs = menuTabs +"><a href=\"#patient\" data-toggle=\"tab\">Pacjenci</a></li><li" />
	<#if activeTab=="room"><#assign menuTabs = menuTabs + " class=\"active\"" /></#if>
	<#assign menuTabs = menuTabs +"><a href=\"#room\" data-toggle=\"tab\">Pokoje</a></li></ul>" />
	<@mac.panel titleClasses="no-padding" title=menuTabs >
	<@mac.form>

		<div class="tab-content">
			<div class="tab-pane <#if activeTab = "main">active</#if>" id="main">
				<p>Liczba użytkowników: ${userCount}</p>
				<p>Liczba pacjentów: ${patientCount}</p>
				<p>Liczba lekarzy: ${doctorCount}</p>
				<p>Liczba pomieszczeń: ${roomCount}</p>
				<p>Liczba wizyt: ${visitCount}</p>
			</div>
			<div class="tab-pane <#if activeTab = "doctor">active</#if>" id="doctor">
				<@mac.select path="statForm.doctor" options=doctors label="Lekarz" combobox=true />
				<@mac.button submit=true name="showDoctor" value="Pokaż" classes="pull-right"/>
			</div>
			<div class="tab-pane <#if activeTab = "patient">active</#if>" id="patient">
				<@mac.select path="statForm.patient" options=patients label="Pacjent" combobox=true />
				<@mac.button submit=true name="showPatient" value="Pokaż" classes="pull-right"/>
			</div>
			<div class="tab-pane <#if activeTab = "room">active</#if>" id="room">
				<@mac.select path="statForm.room" options=rooms label="Pokój" combobox=true />
				<@mac.button submit=true name="showRoom" value="Pokaż" classes="pull-right"/>
			</div>
		</div>
	</@mac.form>
	</@mac.panel>
	
	<#if statData??>
		<#if statData.hasDataToShow>
			<@statsPanel dataMap=statData.visitCountByDates maxCount=statData.maxVisitCount firstColumnHeader="Data" panelTitle= statData.entityName + " - liczba wizyt w poszczególnych dniach"/>
			<#if statData.doctorCount??><@statsPanel dataMap=statData.doctorCount maxCount=statData.maxDoctorCount firstColumnHeader="Lekarz" panelTitle= statData.entityName + " - liczba wizyt przeprowadzonych przez Lekarzy" /></#if>
			<#if statData.patientCount??><@statsPanel dataMap=statData.patientCount maxCount=statData.maxPatientCount firstColumnHeader="Pacjent" panelTitle= statData.entityName + " - liczba wizyt poszczególnych Pacjentów" /></#if>
			<#if statData.roomCount??><@statsPanel dataMap=statData.roomCount maxCount=statData.maxRoomCount firstColumnHeader="Pokój" panelTitle= statData.entityName + " - liczba wizyt w poszczególnych pomieszczeniach" /></#if>
		<#else>
			<@mac.panel>
				Brak danych do wyświetlenia.
			</@mac.panel>
		</#if>
	</#if>
	
<@mac.footer />

<#macro statsPanel dataMap maxCount firstColumnHeader panelTitle>
	<@mac.panel title=panelTitle>
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>${firstColumnHeader}</th>
					<th></th>
					<th>Ilość wizyt</th>
				</tr>
			</thead>
			<tbody>
				<#assign sum = 0 />
				<#list dataMap? keys as key>	
					<tr>
						<td style="width: 200px">${key}</td>
						<td><div class="graph-bar btn-success" style="width: ${((dataMap[key]/maxCount)*750)?round}px"></div></td>
						<td>${dataMap[key]}</td>
						<#assign sum = sum + dataMap[key] />
					</tr>
				</#list>
					<tr>
						<td colspan="2" style="text-align: right">Suma:</td>
						<td>${sum}</td>
					</tr>
			</tbody>
		</table>
	</@mac.panel>
</#macro>