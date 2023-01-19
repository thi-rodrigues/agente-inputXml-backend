# agente-inputXml-backend

# inputXml-backend

### Script banco de dados:

CREATE DATABASE ewave;


CREATE TABLE ccee.dbo.Agente ( <br>
	id bigint IDENTITY(1,1) NOT NULL, <br>
  codigo bigint NULL, <br>
	compra numeric(19,3) NULL, <br>
  [data] datetime2 NULL, <br>
  geracao numeric(19,3) NULL, <br>
  preco_medio numeric(19,3) NULL, <br>
  regiao varchar(255) COLLATE Latin1_General_CI_AS NULL, <br>
	CONSTRAINT PK__agente__3213E83F05198C6C PRIMARY KEY (id) <br>
);


------------
End-point
#### Buscar regiões
GET - http://localhost:8080/agentes/buscarPorRegiao/{regiao}

#### Inputar Notas
POST - http://localhost:8080/agentes/inputarNotas

Body: form-data
  - KEY:file 
  - VALUE: exemplo_01.xml
