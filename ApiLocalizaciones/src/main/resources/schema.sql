CREATE TABLE Pais (
    codigo CHAR(2) PRIMARY KEY NOT NULL,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE Ciudad (
    id IDENTITY PRIMARY KEY NOT NULL,
    nombre VARCHAR(150) NOT NULL,
    codigoPais CHAR(2) NOT NULL,
    FOREIGN KEY (codigoPais) REFERENCES Pais(codigo)
);