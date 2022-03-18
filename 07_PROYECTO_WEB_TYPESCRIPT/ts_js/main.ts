import{Equipo} from './equipo.js'
import{Jugador} from './jugador.js'
import{Historial} from './historial.js'

var historialJ1 = new Historial(0,3,2,1);
var historialJ2 = new Historial(1,3,0,2);
var historialJ3 = new Historial(3,3,0,3);
var historialJ4 = new Historial(4,2,0,4);
var historialJ5 = new Historial(0,3,0,5);
var historialJ6 = new Historial(15,0,0,6);
var historialJ7 = new Historial(12,3,0,7);

var j1 = new Jugador("Courtois",27,"Bélgica",historialJ1,"../public/img/Courtois.jpg",1);
var j2 = new Jugador("Alaba",28,"Austria",historialJ2,"../public/img/Alaba.jpg",2);
var j3 = new Jugador("Militao",23,"Brasil",historialJ3,"../public/img/Militao.jpg",3);
var j4 = new Jugador("Modric",34,"Croacia",historialJ4,"../public/img/Modric.jpg",4);
var j5 = new Jugador("Camavinga",21,"Francia",historialJ5,"../public/img/Camavinga.jpg",5);
var j6= new Jugador("Benzema",33,"Francia",historialJ6,"../public/img/Benzema.jpg",6);
var j7= new Jugador("Vinicius",23,"Brasil",historialJ7,"../public/img/ViniJr.jpg",7);
var j8= new Jugador("Benzema",33,"Francia",historialJ6,"../public/img/Benzema.jpg",8);
var j9= new Jugador("Benzema",33,"Francia",historialJ6,"../public/img/Benzema.jpg",9);
var j10= new Jugador("Benzema",33,"Francia",historialJ6,"../public/img/Benzema.jpg",10);
var j11= new Jugador("Benzema",33,"Francia",historialJ6,"../public/img/Benzema.jpg",11);

var arrayJug : Array<Jugador>= [];
arrayJug.push(j1,j2,j3,j4,j5,j6,j7,j8,j9,j10,j11)

var realMadrid = new Equipo("RealMadrid","1902",arrayJug,1);


for(let i in realMadrid.getJugadores()){
    let numberId : number = parseInt(i) +1;
    let stringId= "j" + (numberId);
    console.log(numberId);
    (document.getElementById(stringId) as HTMLInputElement).src =realMadrid.getJugadores()[i].getUrlImg();
}