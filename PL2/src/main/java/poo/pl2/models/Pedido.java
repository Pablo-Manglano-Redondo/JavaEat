package poo.pl2.models;

public class Pedido {
    
}

/*
Para poder comprar las comidas ofrecidas por los restaurantes, los usuarios podrán utilizar
una herramienta de búsqueda. Cuando el usuario vaya a realizar un pedido consultaremos
su código postal, y a continuación se le mostrarán los restaurantes que haya cerca de su
vivienda o empresa. Para determinar si un restaurante está cerca de la vivienda o empresa
de un cliente consideraremos que tienen que coincidir los 4 primeros dígitos del CP.
Se podrá hacer un filtrado de los restaurantes por especialidad.
Para presentar el listado de los restaurantes, el usuario puede seleccionar distintas
opciones de ordenación:
• Por relevancia (se muestran los restaurantes con la mejor calificación).
• Por tiempo medio de envío.
• Servicio de catering disponible o no.
A continuación, el cliente seleccionará un restaurante y se le presentará un listado con las
comidas que ofrece. El cliente selecionará las comidas que desea y la cantidad, y éstas se
introducirán en el “carrito de la compra”. Una vez finalizado el proceso se procederá al
pago. Las empresas que realizan pedidos tendrán un 10% de descuento. En el caso de que
una empresa necesite un servicio de catering, podrá seleccionar la comida y servicios
deseados.
Una vez confirmado el pago, la aplicación guardará la venta realizando automáticamente
las siguientes operaciones:
• Generar una factura de venta en un fichero de texto: Deberá incluir la fecha de
venta, los datos del restaurante y las comidas compradas, su cantidad y datos del
cliente.
• Almacenar los datos de la venta: Fecha de la venta, los datos del restaurante y las
comidas compradas, su cantidad y datos del cliente.
*/