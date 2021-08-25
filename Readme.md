# Servicios Mercado de valores
[![Heroku](https://www.herokucdn.com/deploy/button.png)](https://serviciomercadovalores.herokuapp.com/)
### Daniel Santiago Ducuara Ardila
### 24/08/2021

## Resumen
Este repositorio consiste en la elaboración de una aplicación para consultar el mercado de valores de las acciones negociadas en la Bolsa.
La aplicación recibirá el identificador de una acción, por ejemplo “MSFT” para Microsoft  y deberá mostrar el histórico de la valoración intra-día, diaria, semanal y mensual. 

## Ejecución localmente 
Para ejecutar la aplicación localmente mediante java es necesario iniciar la clase App y en el navegador colocar http://localhost:4567/
De esta manera iniciara el cliente en javascript, para iniciarlo en java es necesario colocar por ejemplo http://localhost:4567/getData?st=GOOG
indicando de que compañía se desea observar el contenido.

## Ejecución en Heroku

En heroku el link lleva directamente a la página y solo es necesario colocar el identificador.

## Diagrama de clases
En el diseño se encuentra la clase principal App que se desarrolla con spark web, esta clase se encarga de retornar la cadena
que recibe de la url indicada por el usuario, la clase currentServiceInstance utiliza un patrón Singleton y se encarga de crear 
una instancia de la clase y de retornar que servicio se está usando,la clase HttpStockService se encarga de la conexión con la url 
y si se logra realizar la conexión le retorna a App el objeto JSON en forma de cadena, la cadena la obtiene de AlphaHttpStockService
y IEXHttpStockService que son clases heredadad de HttpStockService, en estas dos clases se encuentra el link con el cual se puede
conectar cada una con la API externa y así lograr la conexión para obtener el archivo JSON.
Esta aplicación podría ser extendida para que la API externa pueda ser obtenida sin necesidad de cambiar el servicio.
![Design services](images/diagram.PNG "Services")<br>


