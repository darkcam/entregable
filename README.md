# entregable
prueba de conocimiento
REQUERIMIENTOS DE IMPLEMENTACION

1.	Instlar IDE(IntelliJ)
2.	Instalar Mysql (Xammp, Laragon . etc)
3.	Archivos del sistema(BankSsy,db_crud_bank.sql)

INSTRUCIONES 
1.	Descomprimir el archivo .zip del sistema en una ubicación de preferencia

2.	Abrir el IDE de preferencia en este caso se utilizará Intellij vamos a menú File después click en la Open para abrir el archivo del sistema.

3.	Buscamos la ubicación del archivo, seleccionas el archivo y damos en el botón OK.

4.	Esperamos a que el IDE cargue el sistema y las dependencias del mismo.

5.	Vamos a la carpeta src/main/resources y abrimos el archivo application.propierties

6.	En el archivo application.propiertes vemos la propiedad de la aplicación como es el puerto donde se ejecuta el sistema, la conexión de la base de datos y el tipo de base de datos y demás configuración necesarias, tener el cuenta el puerto donde se ejecutará el aplicativo.

7.	Vamos ahora a importar la base de datos a mysql con phpmyadmin para ello debemos tener ejecutando el servicio esto lo hacemos si estas en Windows con xampp, laragon etc.

8.	Ya ejecutado el servicio de mysql vamos al navegador e ingresamos a localhost/phpmyadmin si esta por defecto este te solicitar un usuario y contraseña el cual será root para usuario y la contraseña se deja vació ya que esta por defecto si has cambio esto le colocas la contraseña que haya configurado.

9.	Vamos a crear una nueva base de datos a la cual se vamos a exportar las tablas y datos del sistema en este caso vamos a crear la base de datos db_crud_bank.

10.	Ya creada la base de datos vamos a la opción importar y buscamos la base de datos con el mismo nombre que está dentro del archivo que se descomprimido que es db_crud_bank.sql ya seleccionado de damos en el botón importa en la parte inferior, esperamos a que realice la importación.

11.	Ya importado la base de datos volvemos al IDE y verificamos en el archivo de application.propiertes que es configurado correctamente la conexión hacia la base de datos.

12.	Vamos a arrancar el aplicativo esto lo podemos hacer de la siguiente manera buscamos en la parte derecha un icono o nombre Maven este nos abre una pestaña.

13.	Buscamos la carpeta plugins la desplegamos y vamos a spring-boot también la desplegamos y buscamos spring-boot:run y de damos doble click esto hará que se ejecute y compile el aplicativo, esperamos a que finalice.

14.	Si todo esta bien vamos al navegador web de tu preferencia ingresamos la siguiente url localhost:8081 con esto lo despliega el sistema.

