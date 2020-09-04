package br.com.sistemadegestao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer.FromDecimalArguments;

import br.com.sistemadegestao.model.Categoria;
import br.com.sistemadegestao.model.Cidade;
import br.com.sistemadegestao.model.Compra;
import br.com.sistemadegestao.model.CompraId;
import br.com.sistemadegestao.model.CondicaoPagamento;
import br.com.sistemadegestao.model.ContaaPagar;
import br.com.sistemadegestao.model.Endereco;
import br.com.sistemadegestao.model.FormadePagmento;
import br.com.sistemadegestao.model.Fornecedor;
import br.com.sistemadegestao.model.ItensCompras;
import br.com.sistemadegestao.model.Marca;
import br.com.sistemadegestao.model.Parcelas;
import br.com.sistemadegestao.model.Produto;
import br.com.sistemadegestao.model.StatusConta;
import br.com.sistemadegestao.model.TipoPessoa;
import br.com.sistemadegestao.raposytory.CategoriaReposytory;
import br.com.sistemadegestao.raposytory.CidadesReposytory;
import br.com.sistemadegestao.raposytory.CompraRepository;
import br.com.sistemadegestao.raposytory.CondicaoPagamentoRepository;
import br.com.sistemadegestao.raposytory.FormadePagmantoReposytory;
import br.com.sistemadegestao.raposytory.FornecedorRepositroy;
import br.com.sistemadegestao.raposytory.ItemCommpraRepository;
import br.com.sistemadegestao.raposytory.MarcaReposytory;
import br.com.sistemadegestao.raposytory.ProdutoReposytory;

@SpringBootTest
class SistemadeGestaoApplicationTests {
	@Autowired
  private FornecedorRepositroy fornecao;
	@Autowired
	private CompraRepository compadao;
	@Autowired
	private CondicaoPagamentoRepository condicaodao;
	@Autowired
	 private  FormadePagmantoReposytory formadao;
	@Autowired
	CidadesReposytory cidadao;
	@Autowired
private	ItemCommpraRepository itemdao;
	 @Autowired
	CompraRepository compradao;
	@Autowired 
private	 ProdutoReposytory produtodao;
	@Autowired
private	MarcaReposytory marcado;
	@Autowired
	private CategoriaReposytory catdao;

	@Test
	void salvarproduto() {
	Produto produto = new Produto();
Optional<	Marca> marca = marcado.findById(1l);
	
Optional<	Categoria >cate= catdao.findById(1l);
	
	produto.setMarca(marca.get());
	produto.setAtivo(true);
	produto.setNomeroduto("BOLA DE FUTELBOL");
	produto.setCategoria(cate.get());
	produtodao.save(produto);
	 System.out.println("salvo com sucesso"+produto.getMarca().getNomemarca());
	}

	void contextLoads() {
		Fornecedor forneceoor = new Fornecedor();
		forneceoor.setAtivo(true);
		Optional<CondicaoPagamento >condiOptional= condicaodao.findById(1l);
		forneceoor.setCondicaoPagamento(condiOptional.get());
		forneceoor.setCelular("9999999");
		forneceoor.setCpfoucnpj("90196814000136");
		Endereco end = new Endereco();
		end.setLogradouro("AV BRASIL");
		Optional<Cidade> cidade = cidadao.findById(100l);
		end.setCidade(cidade.get());
		System.out.println(cidade.get().getCidadenome());
		end.setCep("12554554");
		end.setBairro("Cntro");
		end.setComplento("sala 208 segundo andar");
		end.setNumero(2500);
		forneceoor.setEndereco(end);
		forneceoor.setNomeourazao("XING LING CORP LTDA");
		forneceoor.setTelefone("352645457");
		forneceoor.setTipopessoa(1);
		forneceoor.setDatafundacaoouniver(LocalDate.now());
	    fornecao.save(forneceoor);
	    System.out.println("salvo com sucesso");
	
	}

	public void salvarCondicao() {
		CondicaoPagamento condicaoPagamento = new CondicaoPagamento();
		condicaoPagamento.setDescricao("30 DIA BOLETO BANCÁRIO");
		condicaoPagamento.setQtdeparcelas(1);
	    Optional<FormadePagmento> forma = formadao.findById(1l);
	    BigDecimal percedutal = new BigDecimal(100d);
		Parcelas parcela = new Parcelas();
		parcela.setFormadePagamento(forma.get());
		parcela.setDia(30);
		parcela.setPercentual(percedutal);
		parcela.setNumeroparcela(1);
		parcela.setCondicaopagamento(condicaoPagamento);
		condicaoPagamento.getParcelas().add(parcela);
		condicaodao.save(condicaoPagamento);
		System.out.println("salvo com sucesso");
		
	}

	//@Test
 void salvarcompra() {
		Compra compra = new Compra();
	Optional<Produto> produto = produtodao.findById(1l);
	    ItensCompras itenCompras = new ItensCompras();
		Optional< Fornecedor>forneOptional = fornecao.findById(1l);
	forneOptional.get().setCodigo(1l);
	
	compra.setFornecedor(forneOptional.get());
   compra.setNumerodaNota(2l);
//produto.setCodigo(16l);

//	compra.setComprapk(new CompraPk(195	, fornecedor.getCodigo(), 1));

	Optional<CondicaoPagamento> condicao = condicaodao.findById(1l);
//	System.out.println("Condcao" + condicao.get().getParcelas().get(0).getNumeroparcela());
  
	produto.get().setCusto(new BigDecimal("60.00"));
	BigDecimal qtde = new BigDecimal(20d);
	itenCompras.setQtde(qtde);

	itenCompras.setCompra(compra);
//	CompraId compraId =new CompraId(forneOptional.get().getCodigo(),compra.getNumerodaNota());
///	itenCompras.setId(com);
	itenCompras.setSubtotal  (produto.get().getCusto().multiply(itenCompras.getQtde()));
	if (produto.get().getQte() == null) {
		produto.get().setQte(new BigDecimal(0d));
	}
 
	BigDecimal qtdeest = produto.get().getQte().add(itenCompras.getQtde());
	produto.get().setQte(qtdeest);

	compra.setOutradespeszas(new BigDecimal("15.00"));
	compra.setValordofrete(new BigDecimal("80.00"));
	compra.setSeguro(new BigDecimal("50.00"));
	compra.setDataCompra(LocalDate.now());
     compra.setTotalproduto(itenCompras.getSubtotal());
	BigDecimal total = itenCompras.getSubtotal()
			.add(compra.getSeguro().add(compra.getOutradespeszas().add(compra.getValordofrete())));
	

	BigDecimal customdio = new BigDecimal("0.00");
//	customdio = total.divide(new BigDecimal(itenCompras.getQtde()), BigDecimal.ROUND_UP);
	BigDecimal percetual = customdio.multiply(new BigDecimal(1.7));
	percetual.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	compra.setTotalnota(total);
//	produto.setCustomedio(customdio);
	
	produto.get().setPrecovenda(produto.get().getCusto().multiply(new BigDecimal(1.7d)));
	//produto.setValordaultimacompra(produto.getCusto());
	System.out.println("custo medio " + customdio);
	BigDecimal percentual2 = new BigDecimal(0.00d);
	itenCompras.setProduto(produto.get());
	System.out.println("total" + itenCompras.getProduto().getNomeroduto());
	compra.getItemcompras().add(itenCompras);
//percentual2	= condicao.get().getParcelas().get(0).getPercentual();
//	BigDecimal precovenda = total.divide(new BigDecimal(itenCompras.getQtde()));
	///produto.setCustomedio(precovenda);
//	System.out.println("Estoque" + produto.getQtdeestoque());
///System.out.println("Percentual " + percentual2);
//	compra.getItemcompras().add(itenCompras);
   itenCompras.setCompra(compra);
//	Integer numparcela = 0;
//    for (int pos = 0; pos < forneOptional.get().getCondicaoPagamento().getParcelas().size(); pos++) {
//		
//		numparcela = numparcela + 1;
//		BigDecimal valorparcela = new BigDecimal(0.00d);
//		BigDecimal percentual = new BigDecimal(0.00d);
//		ContaaPagar contaaPagar = new ContaaPagar();
//	percentual = condicao.get().getParcelas().get(pos).getPercentual();
//	percentual = percentual.divide(new BigDecimal(100d));
///////		ContaaPk contaaPk = new ContaaPk();
//	//	contaaPk.setCodigofornecedor(fornecedor.getCodigo());
//	//	contaaPk.setNumtitulo(195);
//     System.out.println(condicao.get().getQtdeparcelas());
////		contaaPk.setNumparcela(numparcela);
/////	contaaPagar.setContaaPk(contaaPk);
//		contaaPagar.setCompra(compra);
//		contaaPagar.setFormadepagamento(forneOptional.get().getCondicaoPagamento(). getParcelas().get(0).getFormadePagamento());
//	contaaPagar.setCondicaoPagamento(forneOptional.get().getCondicaoPagamento());
//		contaaPagar.setFornecedor(forneOptional.get());
//	contaaPagar.setNumerodaparcela(forneOptional.get().getCondicaoPagamento().getQtdeparcelas());
//		contaaPagar.setStatusconta(StatusConta.Aberto);
//		LocalDate hoje = LocalDate.now();
//	LocalDate amanha = hoje.plusDays(0);
//	Calendar c = Calendar.getInstance();
//
//		Date data = new Date();
//		c.setTime(data);
//		c.add(Calendar.DATE, 0);
//	data = c.getTime();
//		System.out.println(amanha);
//	contaaPagar.setDatavencimento(data);
//		System.out.println(total);
//		valorparcela = total.multiply(forneOptional.get().getCondicaoPagamento().getParcelas().get(0).getPercentual().divide(forneOptional.get().getCondicaoPagamento().getParcelas().get(0).getPercentual()));
//		contaaPagar.setValoparcela(valorparcela);
//	compra.getContasApagar().add(contaaPagar);
//	System.out.println(contaaPagar.getValoparcela());
//	}

    compradao.save(compra);
/// itemdao.save(itenCompras);
  }
///	@Test
	 void inserircompra() {
		
		Compra compra = new Compra();
		Optional<Produto> produto = produtodao.findById(1l);
		    ItensCompras itenCompras = new ItensCompras();
			Optional< Fornecedor>forneOptional = fornecao.findById(1l);
		forneOptional.get().setCodigo(1l);
		
		compra.setFornecedor(forneOptional.get());
	   compra.setNumerodaNota(2l);
	   produto.get().setCusto(new BigDecimal("95.00"));
		BigDecimal qtde = new BigDecimal(20d);
		itenCompras.setQtde(qtde);

		itenCompras.setCompra(compra);
//		CompraId compraId =new CompraId(forneOptional.get().getCodigo(),compra.getNumerodaNota());
	///	itenCompras.setId(com);
		itenCompras.setSubtotal  (produto.get().getCusto().multiply(itenCompras.getQtde()));
		if (produto.get().getQte() == null) {
			produto.get().setQte(new BigDecimal(0d));
		}

		BigDecimal qtdeest = produto.get().getQte().add(itenCompras.getQtde());
		produto.get().setQte(qtdeest);

		compra.setOutradespeszas(new BigDecimal("15.00"));
		compra.setValordofrete(new BigDecimal("80.00"));
		compra.setSeguro(new BigDecimal("50.00"));
		compra.setDataCompra(LocalDate.now());
	     compra.setTotalproduto(itenCompras.getSubtotal());
		BigDecimal total = itenCompras.getSubtotal()
				.add(compra.getSeguro().add(compra.getOutradespeszas().add(compra.getValordofrete())));
		compra.setTotalnota(total);

		itenCompras.setProduto(produto.get());
		produto.get().setPrecovenda(produto.get().getCusto().multiply(new BigDecimal(1.7d)));
	
		

		compra.getItemcompras().add(itenCompras);

		for  ( ItensCompras x : compra.getItemcompras()){
		   System.out.println(x.getProduto().getNomeroduto());
	   }
	  
	
	
	
	for  ( Parcelas x : forneOptional.get().getCondicaoPagamento().getParcelas()){
		   System.out.println(x.getCondicaopagamento().getDescricao());
	   }
	
	Integer numparcela = 0;
  //  for (int pos = 0; pos < forneOptional.get().getCondicaoPagamento().getParcelas().size(); pos++) {
    	ContaaPagar contaaPagar = new ContaaPagar();
		numparcela = numparcela + 1;
		contaaPagar.setCompra(compra);
		contaaPagar.setFormadepagamento(forneOptional.get().getCondicaoPagamento(). getParcelas().get(0).getFormadePagamento());
	contaaPagar.setCondicaoPagamento(forneOptional.get().getCondicaoPagamento());
		contaaPagar.setFornecedor(forneOptional.get());
	contaaPagar.setNumerodaparcela(forneOptional.get().getCondicaoPagamento().getQtdeparcelas());
		contaaPagar.setStatusconta(StatusConta.Aberto);
		contaaPagar.setNumerodaparcela(numparcela);
		   System.out.println(contaaPagar.getStatusconta());
		   LocalDate hoje = LocalDate.now();
			LocalDate amanha = hoje.plusDays(0);
			Calendar c = Calendar.getInstance();
			BigDecimal valorparcela = new BigDecimal(0.00d);
				Date data = new Date();
				c.setTime(data);
				c.add(Calendar.DATE, 0);
			data = c.getTime();
				System.out.println(amanha);
			contaaPagar.setDatavencimento(data);
				System.out.println(total);
				valorparcela = total.multiply(forneOptional.get().getCondicaoPagamento().getParcelas().get(0).getPercentual().divide(forneOptional.get().getCondicaoPagamento().getParcelas().get(0).getPercentual()));
				contaaPagar.setValoparcela(valorparcela);
			compra.getContasApagar().add(contaaPagar);
			System.out.println(compra.getClass());
	  
 //   }

   compadao.save(compra);
    System.out.println("Salvo com sucesso");
	}
}
	  

