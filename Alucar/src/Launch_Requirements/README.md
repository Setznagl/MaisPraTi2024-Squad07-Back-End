Para executar a imagem Docker referente ao banco de dados do projeto é necessário:

1- Possuir o Docker instalado na máquina com virtualização ativa na BIOS

2- Acessar a pasta "Alucar_Production"

3- Acessando a partir da pasta acima abrir o terminal de comando CMD, Powershell ou similares via botão direito do mouse;

4- Executar o comando "  docker-compose up -d   " para subir a imagem do container que emula o banco MySQL;

OBS: A imagem permanece ativa até que seja pausada ou deletada, mesmo quando a aplicação Spring já foi encerrada.

Esse procedimento é fundamental para que exista um banco de dados ativo com qual a aplicação back-end possa se conectar.