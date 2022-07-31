DROP TABLE IF EXISTS CARTOES;
CREATE TABLE CARTOES (
    ID INT PRIMARY KEY AUTO_INCREMENT, 
    numero CHAR(19),
    nomeUsuario VARCHAR(255),
    codigoSeguranca CHAR(3),
    dataValidade DATE
);
INSERT INTO CARTOES (numero, nomeUsuario, codigoSeguranca, dataValidade) VALUES ('0123-4567-8901-2345',  'Fulano da Silva', '678', PARSEDATETIME('31/12/2029','dd/MM/yyyy'));
INSERT INTO CARTOES  (numero, nomeUsuario, codigoSeguranca, dataValidade) VALUES('6789-0123-4567-8901', 'Ciclano de Souza', '234', PARSEDATETIME('31/07/2028', 'dd/MM/yyyy'));

SELECT * FROM CARTOES ORDER BY ID;

SELECT TIMESTAMPADD(DAY, -DAY(TIMESTAMPADD(MONTH,1,GETDATE())), TIMESTAMPADD(MONTH,1,GETDATE()));