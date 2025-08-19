# Conversor-de-Monedas
App en java que utiliza la API de exchangerate para hacer conversiones de moneda entre las 10 monedas mas populares  de america, europa y asia.
Esta app utiliza un archivo formato Json para mantener una historial de las consultas mas recientes, asi como tambien te permite ver la conversion de la moneda a tu eleccion con su valor en el mercado de forma actual.  
## Como usar la aplicacion:
Lo primero que tienes que tener en cuenta es que la aplicacion utiliza recursos de la API exchange por lo que necesitaras una clave para poder usarla.  
¿Como consigo mi llave en caso de que la que esta implementada en el codigo este expirada?  
<img width="270" height="38" alt="image" src="https://github.com/user-attachments/assets/1e201c9e-0175-489b-81e4-ee83e67f1f10" />  
- Lo unico que tienes que hacer es es entrar al sitio oficial de [ExchangeRate](https://www.exchangerate-api.com) y en el primer recuado que se muestra poner el correo electronico en el cual se enviara tu clave para usar la API.  
<img width="527" height="404" alt="image" src="https://github.com/user-attachments/assets/c613b04c-c14e-4dab-afe2-a0956338fc41" />


- ¡Listo! tu API key se vera algo asi *https://v6.exchangerate-api.com/v6/YOUR-API-KEY/latest/USD*.  
Solo necesitaremos los digitos que estan señalados en el codigo de arriba

- Despues solo agregala al codigo dedicado a comunicarce a la API, mas especificamente la clase llamada clienteAPI <img width="251" height="70" alt="image" src="https://github.com/user-attachments/assets/60e14818-7954-4860-896c-2f5f1da16522" />
- Dentro de esta clase encontraras una variable llamada *llaveApi* en donde solo necesitaras ingresar la llave que se envio a tu correo.<img width="313" height="113" alt="image" src="https://github.com/user-attachments/assets/296fe494-4dbe-42b0-811c-7393fee0f992" />  


## ¿Como funciona este programa?
Al ejecutarlo este programa arrojara un menu que contendra 5 opciones:
- Consultar el valor de una moneda en otras monedas.  
Esta opcion te dice el valor de una moneda contra las 9 restantes señaladas en la consola.  
- Realizar la conversion entre dos monedas.  
Esta opcion te permite hacer la convercion de un monto entre las dos monedas a tener a eleccion.  
- Consultar la equivalencia de una moneda con todas las disponibles en la API.  
Esta opcion te permite ver el valor de una de las 10 monedas disponibles frente a todas las monedas disponibles en la API.  
- Ver el historial de consultas (si existen).  
Dentro de tu historial se guardaran todas las consultas realizadas en la opcion *1 y 2* para que puedas comparar el valor de futuras consultas.  
- Salir.  
Para la ejecucion del programa.  

Como puedes ver este programa te ofrece una gran cantidad de opciones para hacer pero queda una cosa a tener en cuenta...

## ¿Que monedas hay disponibles?  
Las monedas disponibles para esta aplicacion son las siguientes:  
                -Dólar (USD)  
                -Peso Mexicano (MXN)  
                -Real Brasileño (BRL)  
                -Peso Argentino (ARS)  
                -Peso Colombiano (COP)  
                -Euro (EUR)  
                -Yen Japonés (JPY)  
                -Libra Esterlina (GBP)  
                -Franco Suizo (CHF)  
                -Dólar Canadiense (CAD)  

### Ten en cuenta que las monedas se encuentran con su codigo ISO (El que se encuentra dentro de parentesis).  
Nota: para mejorar la fucionalidad del programa algunas monedas fueron mapeadas con varios seudonimos asi que puede que te la reconozca sin introducir el codigo ISO, asi que porque no intentas descubrir que seudonimos estan disponibles.  
Un ejemplo podria ser peso = mxn.
