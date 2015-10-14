package ar.pablitar.vainilla.appearances

import com.uqbar.vainilla.appearances.Sprite
import ar.pablitar.vainilla.appearances.worldspace.WorldSpaceSimpleAppearance

case class TileSet(sp: Sprite, tileHSize: Int, tileVSize: Int, tileMargin: Int = 0) {
  def getTile(i: Int, j: Int) = {
    WorldSpaceSimpleAppearance(sp.crop(pixelBySize(i, tileHSize), pixelBySize(j, tileVSize), tileHSize, tileVSize))
  }

  def pixelBySize(coordinate: Int, tileSize: Int) = {
    tileMargin * (coordinate + 1) + tileSize * coordinate + 1
  }

  def toPartialFunction:PartialFunction[(Int,Int), WorldSpaceAppearance] = {
    { case (i: Int, j:Int) => getTile(i, j)}
  }
}

object TileSet {

  def fromFile(file: String, tileHSize: Int, tileVSize: Int, tileMargin: Int = 0) = {
    new TileSet(Sprite.fromImage(file), tileHSize, tileVSize, tileMargin)
  }
}