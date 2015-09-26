package ar.pablitar.arkanoid.components

import com.uqbar.vainilla.GameComponent
import ar.pablitar.arkanoid.Jugador
import ar.pablitar.arkanoid.ArkanoidLevelScene
import com.uqbar.vainilla.appearances.Label
import java.awt.Font
import java.awt.Color
import ar.pablitar.arkanoid.misc.Styles
import com.uqbar.vainilla.DeltaState

/**
 * @author pablitar
 */
class ScoreDisplay(j: Jugador) extends Display{
  this.alignVerticalCenterTo(20)
  this.alignLeftTo(10)
  
  def textGetter = {
    "Score: " + j.score.toString
  }
  
}

