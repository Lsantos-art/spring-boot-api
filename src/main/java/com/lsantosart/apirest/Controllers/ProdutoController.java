package com.lsantosart.apirest.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.lsantosart.apirest.Models.Produto;
import com.lsantosart.apirest.Repositories.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value = "API Rest - Produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {
    
    @Autowired
    ProdutoRepository produtoCrud;

	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna uma lista de produtos")
	public List<Produto> listaProdutos(){
		return produtoCrud.findAll();
	}
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna uma produto pelo ID")
	public Produto listaProdutoUnico(@PathVariable(value="id") long id){
		return produtoCrud.findById(id);
	}
	
	@PostMapping("/produto")
	@ApiOperation(value = "Insere um produto no banco de dados")
	public Produto salvaProduto(@RequestBody @Valid Produto produto) {
		return produtoCrud.save(produto);
	}

	@DeleteMapping("/produto")
	@ApiOperation(value = "Deleta um produto pelo ID")
	public void deletaProduto(@RequestBody @Valid Produto produto) {
		produtoCrud.delete(produto);
	}
	
	@PutMapping("/produto")
	@ApiOperation(value = "Atualiza um produto")
	public Produto atualizaProduto(@RequestBody @Valid Produto produto) {
		return produtoCrud.save(produto);
	}

}
