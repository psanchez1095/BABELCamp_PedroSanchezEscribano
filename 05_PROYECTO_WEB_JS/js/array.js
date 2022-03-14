//alert("Bienvenido al repositorio Ws_Javascript");
console.log("Probando la consola")

let arrayNumbers = [] //array vacio
document.getElementById("numExtract").disabled = true; 

function validatePush() {

    // n se inicializa con el valor de elemento html con identificador "num"
    let n = document.getElementById("num").value;

    // Si n es un numero y no esta vacio
    if (!isNaN(n) && n != "") {
        arrayNumbers.push(n);
        document.getElementById("num").value = ""
        updateArrayHtml(n);
        document.getElementById("textMensaje").innerHTML = "Número " + n + " añadido al array."
        document.getElementById("mensaje").style.color = "darkgreen"
        document.getElementById("mensaje").style.visibility = "visible"
        setTimeout(hideMessage, 1500);
    } 
    // Si n no es numero o esta vacio
    else {
        document.getElementById("textMensaje").innerHTML = "Error. Debe añadir un número."
        document.getElementById("mensaje").style.color = "red"
        document.getElementById("mensaje").style.visibility = "visible"
        setTimeout(hideMessage, 2000);
    }

}

// Función que se encarga de sacar un numero del array y mostrarlo en la pagina html
function extractRandom() {

    //Si el array no esta vacio se muestra un elemento aleatorio del array en la pagina html
    if (arrayNumbers.length != 0) {
        let indexRandom = getRandomInt(0, arrayNumbers.length)
        document.getElementById("numExtract").style.border = "4px solid black"
        document.getElementById("numExtract").style.textAlign = "center"
        document.getElementById("numExtract").value = arrayNumbers[indexRandom]
        
        setInterval(hideBorder, 2000)
    } 
     //Si el array esta vacio se muestra un mensaje de error en la pagina html
    else {
        document.getElementById("textMensaje").innerHTML = "Error. El array se encuentra vacio."
        document.getElementById("mensaje").style.visibility = "visible"
        document.getElementById("mensaje").style.color = "red"
        setTimeout(hideMessage, 2000)
    }
}

// Función que se encarga de esconder el elemento con el id "mensaje" en la pagina html (Esconde mensajes de exito/error)
function hideMessage() {
    document.getElementById("mensaje").style.visibility = "hidden"
}
// Función que se encarga de quitar el border al elemento con el id "numExtract" en la pagina html (Quita el borde del )
function hideBorder() {
    document.getElementById("numExtract").style.border = "none"
}

// Retorna un número entero aleatorio entre min (incluido) y max (excluido)
function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}

function updateArrayHtml(nAñadido) {

    if (arrayNumbers.length == 1) document.getElementById("pArrayValue").innerHTML += " " + nAñadido + " ";
    else document.getElementById("pArrayValue").innerHTML += ", " + nAñadido + " ";

}