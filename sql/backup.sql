CREATE TABLE contatos
(
	id SERIAL, 
	nome text NOT NULL, 
	telefone text NOT NULL, 
	email TEXT 
);

insert into contatos (nome, telefone, email) values('teste', '6211221541', 'email@gmail.com1');

select * from contatos;
