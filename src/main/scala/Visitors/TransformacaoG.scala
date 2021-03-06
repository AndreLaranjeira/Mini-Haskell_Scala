package Visitors

import Tipos._

/**
  * Classe abstrata com a implementacao de um MHSVisitor
  * para transformacoes que preservam a AST. Classes concretas
  * desta classe abstrata prcisam redefinir apenas os metodos
  * de interesse.
  */

trait TransformacaoG extends MHSVisitor[Expressao] {
  override def visitar(e : Aplicacao) : Expressao = new Aplicacao(e.nome, e.args.map(exp => exp.aceitar(this)) : _*)
  override def visitar(e : ExpressaoAnd) : Expressao = new ExpressaoAnd(e.lhs.aceitar(this),e.rhs.aceitar(this))
  override def visitar(e : ExpressaoFuncao): Expressao = new ExpressaoFuncao(e.expFuncao, e.argFuncao.map(e => e.aceitar(this)): _*)
  override def visitar(e : ExpressaoITE) : Expressao = new ExpressaoITE(e.condicao.aceitar(this), e.clausulaThen.aceitar(this), e.clausulaElse.aceitar(this))
  override def visitar(e : ExpressaoLet) : Expressao = new ExpressaoLet(e.id, e.expNomeada.aceitar(this), e.corpo.aceitar(this))
  override def visitar(e : ExpressaoNot) : Expressao = new ExpressaoNot(e.exp.aceitar(this))
  override def visitar(e : ExpressaoOr) : Expressao = new ExpressaoOr(e.lhs.aceitar(this),e.rhs.aceitar(this))
  override def visitar(e : ExpressaoSoma) : Expressao = new ExpressaoSoma(e.lhs.aceitar(this),e.rhs.aceitar(this))
  override def visitar(e : Referencia) : Expressao = e
  override def visitar(vb : ValorBooleano) : Expressao =  vb
  override def visitar(e : ValorErro) : Expressao = e
  override def visitar(e : ValorFuncao) : Expressao = e
  override def visitar(vi : ValorInteiro) : Expressao =  vi
  override def visitar(vn : ValorNome) : Expressao =  vn
}
