package ar.pablitar.arkanoid.components

import ar.pablitar.vainilla.commons.components.SpeedyComponent
import ar.pablitar.arkanoid.ArkanoidLevelScene
import com.uqbar.vainilla.appearances.Circle
import java.awt.Color

/**
 * @author pablitar
 */
class Pelota extends SpeedyComponent[ArkanoidLevelScene] {
  
  val radius = 30.0
  
  this.setAppearance(new Circle(Color.RED, radius.toInt))
  
  speed = (0, 100)
  
  override def onSceneActivated = {
    this.alignHorizontalCenterTo(this.getGame.getDisplayWidth / 2)
  }
}