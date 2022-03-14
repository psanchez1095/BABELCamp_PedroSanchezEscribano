//alert("Bienvenido al repositorio Ws_Javascript");
console.log("Probando la consola")

let arrayNumbers = []//array vacio

function add(){

    let n = document.getElementById("n1").value
    let n2 = document.getElementById("n2").value

    if(!isNaN(n) && n != "" && !isNaN(n2) && n2 != "" ) {
        document.getElementById("inputScreenCalculator").value = parseInt(n)+parseInt(n2)
        document.getElementById("n1").value=""
        document.getElementById("n2").value=""
    }
    else{
        document.getElementById("textMensaje").innerHTML = "Error. Debe añadir dos números."
        document.getElementById("mensaje").style.color = "red"
        document.getElementById("mensaje").style.visibility = "visible"
        setInterval( error, 2000)
    }
   
}

function division(){

    let n = document.getElementById("n1").value
    let n2 = document.getElementById("n2").value

    if(!isNaN(n) && n != "" && !isNaN(n2) && n2 != "" ) {
        document.getElementById("inputScreenCalculator").value = parseInt(n)/parseInt(n2)
        document.getElementById("n1").value=""
        document.getElementById("n2").value=""
    }
    else{
        document.getElementById("textMensaje").innerHTML = "Error. Debe añadir dos números."
        document.getElementById("mensaje").style.color = "red"
        document.getElementById("mensaje").style.visibility = "visible"
        setInterval( error, 2000)
    }
   
}

function subtraction(){

    let n = document.getElementById("n1").value
    let n2 = document.getElementById("n2").value

    if(!isNaN(n) && n != "" && !isNaN(n2) && n2 != "" ) {
        document.getElementById("inputScreenCalculator").value = parseInt(n)-parseInt(n2)
        document.getElementById("n1").value=""
        document.getElementById("n2").value=""
    }
    else{
        document.getElementById("textMensaje").innerHTML = "Error. Debe añadir dos números."
        document.getElementById("mensaje").style.color = "red"
        document.getElementById("mensaje").style.visibility = "visible"
        setInterval( error, 2000)
    }
   
}

function multiplication(){

    let n = document.getElementById("n1").value
    let n2 = document.getElementById("n2").value

    if(!isNaN(n) && n != "" && !isNaN(n2) && n2 != "" ) {
        document.getElementById("inputScreenCalculator").value = parseInt(n)*parseInt(n2)
        document.getElementById("n1").value=""
        document.getElementById("n2").value=""
    }
    else{
        document.getElementById("textMensaje").innerHTML = "Error. Debe añadir dos números."
        document.getElementById("mensaje").style.color = "red"
        document.getElementById("mensaje").style.visibility = "visible"
        setInterval( error, 2000)
    }
   
}

function hideBorder() {
    document.getElementById("numExtract").style.border = "none"
}

function error() {
    document.getElementById("error").style.visibility="hidden"
  }