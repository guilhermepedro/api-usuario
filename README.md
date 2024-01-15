# Documentação da API de gerenciamento de cadastros de médicos e pacientes

## Visão Geral

Esta API fornece operações e funcionalidades para cadastros de pacientes e médicos em uma clínica médica.

## Base URL

`http://localhost:8080/paciente` para pacientes
`http://localhost:8080/medico` para médicos

## Endpoints Disponíveis

### Cadastrar Paciente

**Endpoint:** POST /paciente

**Descrição:**
Cadastra um novo paciente no sistema.

**Parâmetros de Entrada:**
- `nome` (string): Nome do paciente.
- `cpf` (number): CPF do paciente.
- `endereco` (string): Endereço do paciente.
- `dtCriacao` (number): Data de criação do cadastro do paciente.
- `telefone` (string): Telefone do paciente.
- `dtNascimento` (string): Telefone do paciente.

**Exemplo de body:**
json
{
  "nome": "Getúlio Santos Souza",
  "cpf": "11111111111",
  "dtCriacao": "01/01/2021",
  "telefone": "38999820252",
  "dtNascimento": "01/01/1998",
  "endereco": "Rua Argemiro Santana, 523, São Paulo"
}

### Listar Paciente

**Endpoint:** GET /paciente

**Descrição:**
Listar os pacientes cadastrados no sistema.

### Editar Paciente

**Endpoint:** PUT /paciente

**Descrição:**
Edita qualquer paciente cadastrado no sistema.

### Deletar Paciente

**Endpoint:** DELETE /paciente

**Descrição:**
Deleta quqlquer paciente cadastrado no sistema.

## Endpoints Disponíveis

### Cadastrar Médico

**Endpoint:** POST /medico

**Descrição:**
Cadastra um novo médico no sistema.

**Parâmetros de Entrada:**
- `nome` (string): Nome do médico.
- `endereco` (string): Endereço do médico.
- `numeroCRM` (number): Número do CRM do médico.
- `especializacao` (string): Telefone do paciente.

**Exemplo de body:**
json
{
  "nome": "guilherme",
  "numeroCRM": "3752",
  "endereco": "centro, 852, pirapora MG",
  "especializacao": "pediatria"
}

### Listar Médico

**Endpoint:** GET /medico

**Descrição:**
Listar os médicos cadastrados no sistema.

### Editar Médico

**Endpoint:** PUT /medico

**Descrição:**
Edita qualquer médico cadastrado no sistema.

### Deletar Médico

**Endpoint:** DELETE /medico

**Descrição:**
Deleta quqlquer médico cadastrado no sistema.



