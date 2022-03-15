//REFERENTE AL CALCULO DE NOTAS 
let arrayAlumnos = [];

let al1 = {
    nombre: 'Steve',
    cal1: 6,
    cal2: 1.99,
    cal3: 6,
    calTrabajo: 5,
    calEx:5.25
  }

  let al2 = {
    nombre: 'John',
    cal1: 6,
    cal2: 1.99,
    cal3: 4,
    calTrabajo: 5,
    calEx:6.25
  }


arrayAlumnos.push(al1,al2)

document.getElementById("divIzq").setAttribute("style", "font-family: 'Aladin', cursive;");

document.getElementById("calculo_ts").innerHTML ="Nota del Alumno " + al1.nombre + "( alumno creado en main.ts ) ponderada: " + calcularNota(al1);

function calcularNota(alumno : any): number {
    console.log(alumno.cal1);
    return (((alumno.cal1+alumno.cal2+alumno.cal3)/3)*0.55 + 0.3*alumno.calEx + 0.15*alumno.calTrabajo)
}

function calcularNotaHtml() {
    console.log("perra tu")
    let p1 = (document.getElementById("p1") as HTMLInputElement).value;
    let p2 = (document.getElementById("p2") as HTMLInputElement).value;
    let p3 = (document.getElementById("p3") as HTMLInputElement).value;
    let tr = (document.getElementById("tr") as HTMLInputElement).value;
    let ex = (document.getElementById("ex") as HTMLInputElement).value;
    let numberP1 = parseInt(p1);
    let numberP2 = parseInt(p2);
    let numberP3 = parseInt(p3);
    let numberTr = parseInt(tr);
    let numberEx = parseInt(ex);
    (document.getElementById("resultado") as HTMLInputElement).value = ( ((numberP1 +numberP2 +numberP3 )/3)*0.55 + 0.3*numberEx + 0.15*numberTr).toString()
}

//REFERENTE AL ARRAY VIDEOJUEGOS
let arrJuegos: Array<string> = [];

arrJuegos.push("Stardew Valley","The Legend of Zelda","Mario Kart","FIFA22","Super Mario Bros","Skyrim","Minecraf Dungeons","Loop Hero","Terraria","Super Mario Odyssey")


function notMarioGames( juegos : Array<string>){


    for(let i in juegos){
        
        if(!juegos[i].includes('Mario')){
            let game = document.createElement("p");
            game.id="pJuego"

            game.innerHTML = juegos[i];
            document.getElementById("pArrJuegos").appendChild(game);
           
        }
    }

}

notMarioGames(arrJuegos);