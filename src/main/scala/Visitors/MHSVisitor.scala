package Visitors

import Tipos._

/**
  * Define a hierarquia de classes visitors.
  * Precisa ter um metodo aceitar para cada
  * classe concreta.
  */

trait MHSVisitor[+T] {
  def visitar(e : Aplicacao)     : T
  def visitar(e : ExpressaoAnd)  : T
  def visitar(e : ExpressaoFuncao) : T
  def visitar(e : ExpressaoITE)  : T
  def visitar(e : ExpressaoLet)  : T
  def visitar(e : ExpressaoOr)   : T
  def visitar(e : ExpressaoNot)   : T
  def visitar(e : ExpressaoSoma) : T
  def visitar(e : Referencia)    : T
  def visitar(e : ValorBooleano) : T
  def visitar(e:  ValorErro)     : T
  def visitar(e : ValorFuncao) : T
  def visitar(e : ValorInteiro)  : T
  def visitar(e : ValorNome)  : T
}
