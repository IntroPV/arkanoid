package ar.pablitar.arkanoid.components

import com.uqbar.vainilla.GameComponent
import java.awt.Color
import com.uqbar.vainilla.appearances.Rectangle
import com.uqbar.vainilla.GameScene

class PlainBackground(val color: Color) extends GameComponent[GameScene] {

  this.setZ(-10)
  
  override def onSceneActivated() = {
    this.setAppearance(new Rectangle(color, this.getGame().getDisplayWidth(), this.getGame().getDisplayHeight()))
  }

}