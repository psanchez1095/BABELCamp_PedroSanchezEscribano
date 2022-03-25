import{Equipo} from './equipo.js'
import{Jugador} from './jugador.js'
import{Historial} from './historial.js'

var arrayJug : Array<Jugador>= [];

var historialJ1 = new Historial(0,3,2,1);
var j1 = new Jugador("Courtois",27,"Bélgica",historialJ1,"../public/img/Courtois.jpg",1);
arrayJug.push(j1)

historialJ1 = new Historial(1,3,0,2);
j1= new Jugador("Mendy",33,"Francia",historialJ1,"../public/img/Mendy.jpg",2);
arrayJug.push(j1)

historialJ1 = new Historial(1,3,0,2);
j1 = new Jugador("Alaba",28,"Austria",historialJ1,"../public/img/Alaba.jpg",3);
arrayJug.push(j1)

historialJ1 = new Historial(3,3,0,3);
j1 = new Jugador("Militao",23,"Brasil",historialJ1,"../public/img/Militao.jpg",4);
arrayJug.push(j1)

historialJ1 = new Historial(4,2,0,4);
j1= new Jugador("Valverde",25,"Uruguay",historialJ1,"../public/img/Valverde.jpg",5);
arrayJug.push(j1)

historialJ1 = new Historial(12,3,0,7);
j1= new Jugador("Vinicius",23,"Brasil",historialJ1,"../public/img/ViniJr.jpg",6);
arrayJug.push(j1)

j1 = new Jugador("Modric",34,"Croacia",historialJ1,"../public/img/Modric.jpg",7);
arrayJug.push(j1)

historialJ1 = new Historial(0,3,0,5);
j1 = new Jugador("Camavinga",21,"Francia",historialJ1,"../public/img/Camavinga.jpg",8);
arrayJug.push(j1)

j1= new Jugador("Rodrygo",33,"Brasil",historialJ1,"../public/img/Rodrygo.jpg",9);
arrayJug.push(j1)

historialJ1 = new Historial(15,0,0,6);
j1= new Jugador("Benzema",33,"Francia",historialJ1,"../public/img/Benzema.jpg",10);
arrayJug.push(j1)

j1= new Jugador("Bale",31,"Gales",historialJ1,"../public/img/Bale.jpg",11);
arrayJug.push(j1)

var realMadrid = new Equipo("RealMadrid","1902",arrayJug,1);

for(let i in realMadrid.getJugadores()){

    let numberId : number = parseInt(i) +1;
    let stringId= "j" + (numberId);

    (document.getElementById(stringId) as HTMLInputElement).src =realMadrid.getJugadores()[i].getUrlImg();
}
