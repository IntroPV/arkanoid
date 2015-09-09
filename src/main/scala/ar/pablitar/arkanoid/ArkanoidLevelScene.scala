package ar.pablitar.arkanoid

import com.uqbar.vainilla.GameScene
import ar.pablitar.arkanoid.components.Paleta
import ar.pablitar.arkanoid.components.Pelota

/**
 * @author pablitar
 */
class ArkanoidLevelScene extends GameScene {
	val paleta = new Paleta

  this.addComponent(paleta)
  this.addComponent(new Pelota)
  
  var vidas = 3
  
  def paredes = {
   List(
        Pared((0, 0), (1, 0)),
        Pared((getGame.getDisplayWidth/2, 0),(1, 2)),
        Pared((getGame.getDisplayWidth/2, 0),(-1, 2)),
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
    val pelota = new Pelota
    this.addComponent(pelota)
    pelota.onSceneActivated()
  }
}