package ar.pablitar.arkanoid

import com.uqbar.vainilla.GameScene
import ar.pablitar.arkanoid.components.Paleta
import ar.pablitar.arkanoid.components.Pelota
import scala.collection.mutable.ArrayBuffer
import ar.pablitar.arkanoid.components.Ladrillo
import ar.pablitar.arkanoid.levels.Level1

/**
 * @author pablitar
 */
class ArkanoidLevelScene extends GameScene {
	val paleta = new Paleta
  val pelotas = ArrayBuffer.empty[Pelota]

  this.addComponent(paleta)
  this.addPelota()
  
  Level1.loadToScene(this)
  
  var vidas = 3
  
  def paredes = {
   List(
        Pared((0, 0), (1, 0)),
        Pared((0, 0),(0, 1)),
        Pared((getGame.getDisplayWidth, 0),(-1, 0))
   )
  }
  
  
  def seFuePelota(pelota: Pelota) {
    this.perdioVida()
  }

  def perdioVida() = {
	  vidas -= 1
    reiniciarEscena()
	}

  def reiniciarEscena() = {
    paleta.onSceneActivated()
    this.addPelota().onSceneActivated()
  }

  def addPelota() = {
    val pelota = new Pelota
    this.addComponent(pelota)
    this.pelotas += pelota
    pelota
  }
}