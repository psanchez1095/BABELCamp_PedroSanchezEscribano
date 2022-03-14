//alert("Bienvenido al repositorio Ws_Javascript");
console.log("Probando la consola")

let arrayNumbers = []//array vacio

function validatePush(){

    let n = document.getElementById("num").value;

    if(!isNaN(n) && n != "") {
        arrayNumbers.push(n);
        document.getElementById("num").value=""
    
    }
    else{
        document.getElementById("textError").innerHTML ="Error. Debe añadir números"
        document.getElementById("error").style.visibility="visible";
        setTimeout( error, 2000);
    }
   
}

function extractRandom(){

    if(arrayNumbers.length != 0){

    let indexRandom = getRandomInt(0,arrayNumbers.length);
    document.getElementById("numExtract").value = arrayNumbers[indexRandom];

    }
    else {
        document.getElementById("textError").innerHTML ="Error. El array se encuentra vacio"
        document.getElementById("error").style.visibility="visible";
        setTimeout( error, 2000);
    }
}

function error() {
    document.getElementById("error").style.visibility="hidden";
  }


  // Retorna un número aleatorio entre min (incluido) y max (excluido)
function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min)) + min;
  }