package ar.pablitar.arkanoid.components

import com.uqbar.vainilla.GameComponent
import ar.pablitar.arkanoid.misc.Styles
import com.uqbar.vainilla.DeltaState
import ar.pablitar.arkanoid.Jugador

/**
 * @author pablitar
 */
class VidasDisplay(j: Jugador) extends Display {

  def textGetter = {
    j.vidas.toString + " Vidas Restantes"
  }

  override def onSceneActivated() = {
    this.alignVerticalCenterTo(20)
    this.alignRightTo(this.getGame.getDisplayWidth - 10)
  }
}