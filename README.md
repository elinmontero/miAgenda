## FUNCIONALIDAD DE LA APLICACIÓN

<p>
MI AGENDA, es una aplicacion que va a permitir al usuario gestionar  registros relacionados a las actividades realizadas en el dia a dia.
Para esto implementamos una base de datos (SQLite) para almacenar los datos introducidos por el usuario.
</p>
<p>
Posee las siguientes funcionalidades:
</p>
<ul>
<li>Pantalla de Inicio con tres opciones</li>
<li>Agregar Actividad: esto va a desplegar un formulario que le permitira al usuario agregar una nueva actividad con un titulo y una descripción. </li>
<li>Ver Actividades: al seleccionar esta opción se muestra un listado con todas las actividades que ha agregado el usuario</li>
<li>Editar Actividad: una vez seleccionada , el usuario puede ver una lista de todas las actividades que ha agregado, dar click sobre cualquiera de ellas y tener la opción de editar o eliminar el registro.</li>
</ul>


### IMPLEMENTACIÓN DE SQLITE
<p>
Básicamente estos fueron los pasos para implementar SQLite en el proyecto: 
</p>
<ul>
<li>Crear una clase de ayuda de SQLite, indispensable para abrir, crear y actualizar la base de datos. </li>
<li>Utilizar una clase que herede del SqlHelper, a partir del cual se crean todos los metodos que nos van a permitir manipular la base de datos. </li>
<li>Crear una clase entidad, en este caso Actividad, con todos los atributos de la misma.  </li>

</ul>


