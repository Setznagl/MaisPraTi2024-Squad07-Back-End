(PT-BR)
Para executar a imagem Docker referente ao banco de dados do projeto é necessário:

1- Possuir o Docker instalado na máquina com virtualização ativa na BIOS

2- Acessar a pasta "Alucar_Production"

3- Acessando a partir da pasta acima abrir o terminal de comando CMD, Powershell ou similares via botão direito do mouse;

4- Executar o comando "  docker-compose up -d   " para subir a imagem do container que emula o banco MySQL;

OBS: A imagem permanece ativa até que seja pausada ou deletada, mesmo quando a aplicação Spring já foi encerrada.

Esse procedimento é fundamental para que exista um banco de dados ativo com qual a aplicação back-end possa se conectar.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

(EN)
To run the Docker image for the project's database, you need to:

Have Docker installed on your machine with virtualization enabled in the BIOS.

Access the "Alucar_Production" folder.

From the folder above, open the command terminal (CMD, Powershell, or similar) by right-clicking.

Execute the command "docker-compose up -d" to start the container image that emulates the MySQL database.

Note: The image remains active until it is paused or deleted, even if the Spring application has already been closed.

This procedure is essential to have an active database with which the back-end application can connect.