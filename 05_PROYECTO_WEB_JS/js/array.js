//alert("Bienvenido al repositorio Ws_Javascript");
console.log("Probando la consola")

let arrayNumbers = [] //array vacio

function validatePush() {

    let n = document.getElementById("num").value;

    if (!isNaN(n) && n != "") {
        arrayNumbers.push(n);
        document.getElementById("num").value = ""
        updateArrayHtml(n);
        document.getElementById("textMensaje").innerHTML = "Número " + n + " añadido al array"
        document.getElementById("mensaje").style.color = "darkgreen"
        document.getElementById("mensaje").style.visibility = "visible"
        setTimeout(hideMessage, 1500);
    } else {
        document.getElementById("textMensaje").innerHTML = "Error. Debe añadir números"
        document.getElementById("mensaje").style.color = "red"
        document.getElementById("mensaje").style.visibility = "visible"
        setTimeout(hideMessage, 2000);
    }

}

function extractRandom() {

    if (arrayNumbers.length != 0) {
        let indexRandom = getRandomInt(0, arrayNumbers.length)
        document.getElementById("numExtract").value = arrayNumbers[indexRandom]

    } else {
        document.getElementById("textMensaje").innerHTML = "Error. El array se encuentra vacio"
        document.getElementById("mensaje").style.visibility = "visible"
        document.getElementById("mensaje").style.color = "red"
        setTimeout(hideMessage, 2000)
    }
}

function hideMessage() {
    document.getElementById("mensaje").style.visibility = "hidden"
}


// Retorna un número entero aleatorio entre min (incluido) y max (excluido)
function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
}

function updateArrayHtml(nAñadido){

    if (arrayNumbers.length==1) document.getElementById("pArrayValue").innerHTML +=" " + nAñadido + " " ;
    else document.getElementById("pArrayValue").innerHTML += ", " + nAñadido + " " ;

}