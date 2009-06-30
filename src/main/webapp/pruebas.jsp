<html
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html">
	<head>
		<title>Hello World</title>
	</head>
	<body>
		<f:view>
			<h:form>
				<h:dataTable value="${pruebaBean.books}" var="book">
					<h:column>
						<f:facet name="header">
							<h:outputText value="ISBN" />
						</f:facet>
						<h:outputText value="${book.isbn}"/>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Title" />
						</f:facet>
						<h:outputText value="${book.title}"/>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Author" />
						</f:facet>
						<h:outputText value="${book.author}"/>
					</h:column>	
					<h:column>
						<h:commandLink value="remove" action="${pruebaBean.remove}"/> 					
					</h:column>							
				</h:dataTable>
			</h:form>
		</f:view>
	</body>
</html>