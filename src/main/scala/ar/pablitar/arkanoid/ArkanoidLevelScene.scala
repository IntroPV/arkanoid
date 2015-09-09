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
  
  def paredes = {
   List(
        Pared((0, 0), (1, 0)),
        Pared((0, 0),(0, 1)),
        Pared((getGame.getDisplayWidth, 0),(-1, 0))
   )
  }
}