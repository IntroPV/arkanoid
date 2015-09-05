package ar.pablitar.arkanoid

import com.uqbar.vainilla.GameScene
import ar.pablitar.arkanoid.components.Paleta
import ar.pablitar.arkanoid.components.Pelota

/**
 * @author pablitar
 */
class ArkanoidLevelScene extends GameScene {
  this.addComponent(new Paleta)
  this.addComponent(new Pelota)
}