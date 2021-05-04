package mx.tecnm.tepic.ladm_u2_practica_juegotopos

import android.graphics.*
import android.view.MotionEvent
import android.view.View

class Lienzo(p:MainActivity) : View(p) {
    var activar=true
    var tiempo =" "
    var pantalla = 0
    var fondo1 = Imagen(this, R.drawable.campotopo2, 0f, 0f)
    var arbolito = Imagen(this, R.drawable.arbol, 80f, 400f)
    var nube1 = Imagen(this, R.drawable.nube, 150f, 150f)
    var nube2 = Imagen(this, R.drawable.nube, 450f, 220f)
    var nube3 = Imagen(this, R.drawable.nube, 750f, 150f)
    var ave = Imagen(this, R.drawable.aguila, 650f, 235f)
    var conejo = Imagen(this, R.drawable.conejo, 250f, 1600f)
    var planta = Imagen(this, R.drawable.cesped2, 110f, 1000f)
    var flor = Imagen(this, R.drawable.lavanda1, 750f, 1550f)

    var entrar1 = Imagen(this, R.drawable.play1, 350f, 1100f)
    var entrar2 = Imagen(this, R.drawable.btnplay, 350f, 800f)
    var contadorTiempo = 0
    var topoap = false
    var puntuacion = 0
    var nivel = 1

    var topo1 = Imagen (this, R.drawable.topo, 200f, 700f)
    var topo2 = Imagen (this, R.drawable.topo, 500f, 800f)
    var topo3 = Imagen (this, R.drawable.topo, 800f, 700f)
    var topo4 = Imagen (this, R.drawable.topo, 320f, 1200f)
    var topo5 = Imagen (this, R.drawable.topo, 650f, 1200f)

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()

        invalidate()

        when (pantalla) {
            0 -> {
                p.color = Color.WHITE
                fondo1.pintar(c)
                p.textSize = 150f
                c.drawText("TOPOS", 300f, 650f, p)
                entrar1.pintar(c)

                invalidate()
            }
            1 -> {
                    var hilopo3 = Hilo(this)
                    if (activar) {
                        hilopo3.start()

                    }

                c.drawColor(Color.CYAN)
                p.textSize = 40f
                c.drawText("Tiempo ${contadorTiempo}", 400f, 50f, p)
                p.color = Color.BLACK
                c.drawText("Puntuación: ${puntuacion}", 50f, 50f, p)
                c.drawText("Nivel: ${nivel}", 800f, 50f, p)

                p.color = Color.rgb(39, 174, 96 )
                c.drawCircle(500f, 1700f, 1200f, p)

                p.color = Color.rgb(161, 136, 127)
                c.drawOval(160f,890f,420f,840f,p)//1
                c.drawOval(460f,990f,720f,940f,p)//2
                c.drawOval(760f,890f,1020f,840f,p)//3
                c.drawOval(260f,1390f,520f,1340f,p)//4
                c.drawOval(600f,1390f,860f,1340f,p)//5

                arbolito.pintar(c)
                nube1.pintar(c)
                nube2.pintar(c)
                nube3.pintar(c)
                ave.pintar(c)
                conejo.pintar(c)
                planta.pintar(c)
                flor.pintar(c)

                //------------------------------------------------------------------------------------------------------aparecer topo en...
                if (contadorTiempo in 4..5 || contadorTiempo in 19..20 || contadorTiempo in 33..34) {//topo1
                    topo1.pintar(c)}

                if(contadorTiempo in 25..26 || contadorTiempo in 11..12 || contadorTiempo in 41..42 || contadorTiempo in 65..68){topo2
                    topo2.pintar(c)}

                if(contadorTiempo in 14..15 || contadorTiempo in 35..36|| contadorTiempo in 46..47){//topo3
                    topo3.pintar(c)}

                if(contadorTiempo in 51..52|| contadorTiempo in  31..32|| contadorTiempo in 29..28 || contadorTiempo in 22..23){//topo4
                    topo4.pintar(c)}

                if(contadorTiempo in 55..56  || contadorTiempo in 61..62){//topo5
                    topo5.pintar(c)}

                //------------------------------------------------------------------------------------------------------cambiar topo despues de aplastar

                if(topoap == true && (contadorTiempo==6 || contadorTiempo ==21 || contadorTiempo ==35)){//topo1
                    topo1.imagen = BitmapFactory.decodeResource(resources,R.drawable.topo)
                    topoap=false
                    puntuacion=puntuacion+1
                }
                if(topoap == true && (contadorTiempo==27 || contadorTiempo ==13 || contadorTiempo ==43 || contadorTiempo==69)){//topo2
                    topo2.imagen = BitmapFactory.decodeResource(resources,R.drawable.topo)
                    topoap=false
                    puntuacion=puntuacion+1
                }
                if(topoap == true && (contadorTiempo==16 || contadorTiempo ==37 || contadorTiempo ==48)){//topo3
                    topo3.imagen = BitmapFactory.decodeResource(resources,R.drawable.topo)
                    topoap=false
                    puntuacion=puntuacion+1
                }
                if(topoap == true && (contadorTiempo==53 || contadorTiempo ==33 || contadorTiempo ==29 || contadorTiempo ==24)){//topo4
                    topo4.imagen = BitmapFactory.decodeResource(resources,R.drawable.topo)
                    topoap=false
                    puntuacion=puntuacion+1
                }
                if(topoap == true && (contadorTiempo==57  || contadorTiempo ==63)){//topo5
                    topo5.imagen = BitmapFactory.decodeResource(resources,R.drawable.topo)
                    topoap=false
                    puntuacion=puntuacion+1
                }
                if(contadorTiempo==70&&nivel==1){
                    nivel=2
                    contadorTiempo=0
                }
                if(contadorTiempo==70&&nivel==2){
                    nivel=3
                    contadorTiempo=0
                }
                if(contadorTiempo==70&&nivel==3){
                    nivel=1
                    contadorTiempo=0
                   // puntuacion=0
                    pantalla=2
                }

                invalidate()
            }

            2->{
                c.drawColor(Color.rgb(225, 190, 231))
                p.color = Color.BLACK
                p.textSize = 60f
                c.drawText("Puntuación final: ${puntuacion}", 300f, 500f, p)
                c.drawText("¿Quieres seguir jugando?", 200f, 650f, p)
                entrar2.pintar(c)
                invalidate()
            }
        }

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when(event.action) {
            MotionEvent.ACTION_DOWN -> {
                //----------------------------------------------------------------------------------aplastar topo
                if (topo1.estaEnArea(event.x, event.y)) {
                    topo1.imagen = BitmapFactory.decodeResource(resources,R.drawable.topoaplastado)//topo1
                    topoap=true
                }
                if (topo2.estaEnArea(event.x, event.y)) {
                    topo2.imagen = BitmapFactory.decodeResource(resources,R.drawable.topoaplastado)//topo2
                    topoap=true
                }
                if (topo3.estaEnArea(event.x, event.y)) {
                    topo3.imagen = BitmapFactory.decodeResource(resources,R.drawable.topoaplastado)//topo3
                    topoap=true
                }
                if (topo4.estaEnArea(event.x, event.y)) {
                    topo4.imagen = BitmapFactory.decodeResource(resources,R.drawable.topoaplastado)//topo4
                    topoap=true
                }
                if (topo5.estaEnArea(event.x, event.y)) {
                    topo5.imagen = BitmapFactory.decodeResource(resources,R.drawable.topoaplastado)//topo5
                    topoap=true
                }

                if (entrar2.estaEnArea(event.x, event.y)&& pantalla==2) {
                        pantalla = 0
                }
            }
        }
        super.onTouchEvent(event)
        if (entrar1.estaEnArea(event.x, event.y)&&pantalla==0) {
            pantalla = 1
            contadorTiempo=0
            puntuacion=0
        }
        invalidate()
        return true
    }
}

class Hilo(act: Lienzo) : Thread() {
    var et = act
    override fun run() {
        super.run()
        et.activar=false
        while (true) {
               if (true) {
                       when (et.nivel) {
                           1 -> {
                               sleep(900)
                               et.contadorTiempo = et.contadorTiempo + 1
                               et.tiempo = et.contadorTiempo.toString()
                           }
                           2 -> {
                               sleep(650)
                               et.contadorTiempo = et.contadorTiempo + 1
                               et.tiempo = et.contadorTiempo.toString()
                           }
                           3 -> {
                               sleep(400)
                               et.contadorTiempo = et.contadorTiempo + 1
                               et.tiempo = et.contadorTiempo.toString()
                           }
                       }
                }
            }
        sleep(1000)
    }
}
