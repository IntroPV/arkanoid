package ar.pablitar.arkanoid

import ar.pablitar.arkanoid.components.Paleta
import ar.pablitar.arkanoid.components.Pelota
import scala.collection.mutable.ArrayBuffer
import ar.pablitar.arkanoid.components.Ladrillo
import ar.pablitar.arkanoid.levels.Level1
import ar.pablitar.arkanoid.components.ScoreDisplay
import com.uqbar.vainilla.GameScene
import ar.pablitar.arkanoid.components.PlainBackground
import java.awt.Color
import ar.pablitar.arkanoid.components.VidasDisplay

/**
 * @author pablitar
 */
class ArkanoidLevelScene extends GameScene {
	val paleta = new Paleta
  val pelotas = ArrayBuffer.empty[Pelota]
  
  this.addComponent(new PlainBackground(new Color(40,40,40)))

  this.addComponent(paleta)
  this.addPelota()
  
  this.addEditor()
  
  Level1.loadToScene(this)
  
  this.addScore()
  this.addVidas()
 
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
	  Jugador.uno.vidas -= 1
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

  def addEditor() = {
	  this.addComponent(new Editor)
	}

  def addScore() = {
	  this.addComponent(new ScoreDisplay(Jugador.uno))
	}

  def addVidas() = {
	  this.addComponent(new VidasDisplay(Jugador.uno))
	}
}