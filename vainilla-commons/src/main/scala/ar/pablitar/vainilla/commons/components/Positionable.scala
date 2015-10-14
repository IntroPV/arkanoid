package ar.pablitar.vainilla.commons.components

import ar.pablitar.vainilla.commons.math.Vector2D

trait Positionable {
  def position: Vector2D
  def position_=(p: Vector2D):Unit
  
  def toLocalFromWorld(v: Vector2D) = v - position
}