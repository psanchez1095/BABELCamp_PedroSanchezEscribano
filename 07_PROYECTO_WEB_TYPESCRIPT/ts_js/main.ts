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

var j1 = new Jugador("Courtois",27,"Bélgica",historialJ1,1);
var j2 = new Jugador("Alaba",28,"Austria",historialJ2,2);
var j3 = new Jugador("Brasil",23,"Militao",historialJ3,3);
var j4 = new Jugador("Modric",34,"Croacia",historialJ4,4);
var j5 = new Jugador("Camavinga",21,"Francia",historialJ5,5);
var j6= new Jugador("Benzema",33,"Francia",historialJ6,6);
var j7= new Jugador("Vinicius",23,"Brasil",historialJ7,7);

var arrayJug : Array<Jugador>= [];
arrayJug.push(j1,j2,j3,j4,j5,j6,j7)

var realMadrid = new Equipo("RealMadrid","1902",arrayJug,1)