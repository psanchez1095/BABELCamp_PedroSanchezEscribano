//alert("Bienvenido al repositorio Ws_Javascript");
console.log("Probando la consola")

let arrayNumbers = []//array vacio

function validatePush(){

    let n = document.getElementById("num").value;

    if(!isNaN(n) && n != "") {
        arrayNumbers.push()
    }
    else{
        document.getElementById("error").style.visibility="visible";
        setTimeout( error, 2000);
    }
   
}

function error() {
    document.getElementById("error").style.visibility="hidden";
  }