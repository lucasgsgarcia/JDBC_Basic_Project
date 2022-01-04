CREATE TABLE disciplina(
    codigo integer primary key,
    nome varchar(55),
    descricao varchar(100)
);

insert into disciplina values (1, 'Redes', 'Redes de Computadores');

insert into disciplina values (2, 'Sitios web 4', 'Disciplina para prog back-end');

insert into disciplina values (3, 'POO2', 'Disciplina para eng software');

CREATE TABLE turma (
    codigoDisciplina integer references disciplina(codigo),
    professor varchar(55),
    sessao varchar(55),
    primary key (codigoDisciplina, professor)
);


insert into turma values (1, 'Huff', '0');

insert into turma values (2, 'Roberto', '99');

insert into turma values (3, 'Huff', '666');

CREATE TABLE aluno(
    codigo integer primary key,
    nome varchar(55),
    dataNasc varchar(100)
);

CREATE TABLE alunoTurma(
    codigoAluno integer,
    codigoDisciplina integer,
    professor varchar(55),
    foreign key (codigoDisciplina, professor) REFERENCES turma(codigoDisciplina, professor),
    primary key (codigoAluno, codigoDisciplina, professor)
);

insert into aluno values (1, 'Lucas', '04/01/2002');
insert into aluno values (2, 'Jose', '14/02/2012');
insert into aluno values (3, 'João', '31/07/2007');
insert into aluno values (4, 'Beatriz', '12/12/2006');
insert into aluno values (5, 'Laura', '24/08/1999');
insert into aluno values (6, 'Leticia', '20/11/1982');

insert into alunoTurma values (1, 1, 'Huff');
insert into alunoTurma values (2, 2, 'Roberto');
insert into alunoTurma values (3, 2, 'Roberto');
insert into alunoTurma values (4, 3, 'Huff');
insert into alunoTurma values (5, 3, 'Huff');
insert into alunoTurma values (6, 3, 'Huff');


