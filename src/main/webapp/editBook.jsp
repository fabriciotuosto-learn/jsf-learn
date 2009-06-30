<html
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
	<head>
		<title>Edit Book</title>
	</head>
	<body>
		<h1>Edit Book</h1>
		<f:view>
			<h:form>
				<h:panelGrid binding="${crudbean.editPanel}"/>
				<h:commandButton action="${crudbean.save}"/>
				<h:commandButton action="${crudbean.back}" />
			</h:form>
		</f:view>
	</body>
</html>