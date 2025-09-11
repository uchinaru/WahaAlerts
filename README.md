# WahaAlerts - Api para envio de mensagens via WhatsApp 

> Projeto para desafio pessoal e estudo.

## ⚙️ Tecnologias e Ferramentas Utilizadas

- **Spring Boot** - Framework para construção da API REST
- **MySQL** - Banco de dados relacional
- **Docker** - Containerização do ambiente
- **Ngrok** - Túnel para expor localmente a porta 8080 via HTTPS
- **Waha API** - Plataforma intermediadora para envio de mensagens via WhatsApp

## 📦 Pré-requisitos
Antes de iniciar o projeto, certifique-se de ter instalado em sua máquina:
- [Waha API](https://waha.devlike.pro/docs/overview/quick-start/)
- [Docker](https://www.docker.com/)
- [Ngrok](https://ngrok.com/)

## ⚙️ Configurando
#### Waha API
- Faça o Get Stared da api em: https://waha.devlike.pro/
- Configure o Docker na porta 3000 de start.
- `http://localhost:3000/dashboard/` configure o QRCODE do WhatsApp na session default.

#### Ngrok
O Ngrok vai server para facilitar a utilização do webhook que ira observar as mensagens em nossos endpoints.
- Logar e baixar o SW do Ngrok: https://ngrok.com/
- Iniciar o Ngrok observando a porta 8080 `ngrok.exe http 8080`

### Informações adicionais ⚙️
- O Waha possui muitos metodos desativados, com bug ou disponiveis somente na versão paga, fique de olho.