package br.com.sistemadegestao;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.sistemadegestao.model.Compra;
import br.com.sistemadegestao.model.CompraId;
import br.com.sistemadegestao.model.ContaaPagar;
import br.com.sistemadegestao.model.Fornecedor;
import br.com.sistemadegestao.model.ItensCompras;
import br.com.sistemadegestao.model.Produto;
import br.com.sistemadegestao.model.StatusConta;
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
public class ComoraTest {

	@Autowired
	private FornecedorRepositroy fornecao;
	@Autowired
	private CompraRepository compadao;
	@Autowired
	private CondicaoPagamentoRepository condicaodao;
	@Autowired
	private FormadePagmantoReposytory formadao;
	@Autowired
	CidadesReposytory cidadao;
	@Autowired
	private ItemCommpraRepository itemdao;
	@Autowired
	CompraRepository compradao;
	
	@Autowired
	private MarcaReposytory marcado;
	@Autowired
	private CategoriaReposytory catdao;
	@Autowired
	private ProdutoReposytory produtodao;
	@Test
	void salvarcompra() {
		
		Compra compra = new Compra();
		Optional<Produto> produto = produtodao.findById(2l);
				///produtodao.findById(1l);
		ItensCompras itenCompras = new ItensCompras();
		Optional<Fornecedor> forneOptional = fornecao.findById(1l);
	//	forneOptional.get().setCodigo(1l);
        produto.get().setCusto(new BigDecimal(85.58d));
        produto.get().setDataultimacompra(LocalDate.now());
        produto.get().setPrecoultimacompa(new BigDecimal(0.00d));
        itenCompras.setQtde(new BigDecimal(150d));
        produto.get().setQte(itenCompras.getQtde().add(produto.get().getQte()));
        compra.setNumerodaNota(11l);
        itenCompras.setCompra(compra);
        CompraId compraId =new CompraId(forneOptional.get().getCodigo(),compra.getNumerodaNota());
		compra.setFornecedor(forneOptional.get());
		itenCompras.setId(compraId);
		
		
		itenCompras.setSubtotal(itenCompras.getQtde().multiply(produto.get().getCusto()));
	
        
		compra.setOutradespeszas(new BigDecimal("15.00"));
		compra.setValordofrete(new BigDecimal("80.00"));
		compra.setSeguro(new BigDecimal("50.00"));
		compra.setDesconto(new BigDecimal(45.00d));
		compra.setDataCompra(LocalDate.now());
		compra.setFornecedor(forneOptional.get());
		compra.setTotalproduto(itenCompras.getSubtotal());
	   	compra.setTotalnota(compra.getOutradespeszas().add(compra.getSeguro().add(compra.getValordofrete().add(itenCompras.getSubtotal()))));
	 //    compra.setMarkqup('1.70');
         produto.get().setPrecovenda((compra.getTotalnota().divide(itenCompras.getQtde(), 4,
					RoundingMode.HALF_DOWN).multiply(new BigDecimal(1.7d))));
///		 produto.get().setPrecovenda(produto.get().getPrecovenda().multiply(new BigDecimal(1.7d)));
         itenCompras.setProduto(produto.get());
		 compra.getItemcompras().add(itenCompras);
		 
		 System.out.println(compra.getTotalnota());
		 System.out.println(produto.get().getQte());
		 System.out.println(produto.get().getNomeroduto());
		 System.out.println(produto.get().getPrecovenda());
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
			////	produto.get().getItems().add(itenCompras);
					valorparcela = compra.getTotalnota().multiply(forneOptional.get().getCondicaoPagamento().getParcelas().get(0).getPercentual().divide(forneOptional.get().getCondicaoPagamento().getParcelas().get(0).getPercentual()));
					contaaPagar.setValoparcela(valorparcela);
				compra.getContasApagar().add(contaaPagar); 
				System.out.println(valorparcela);
				itenCompras.setProduto(produto.get());
				for  ( ItensCompras x : compra.getItemcompras()){
					   System.out.println(x.getProduto().getNomeroduto());
				}
				compadao.save(compra);
	         
				System.out.println("salvo com sucesso ");

	}

}
