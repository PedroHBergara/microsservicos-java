package br.com.fiap.microsservicos.catalogo_service.controller;

import br.com.fiap.microsservicos.catalogo_service.model.Produto;
import br.com.fiap.microsservicos.catalogo_service.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalogo/produtos")
public class ProdutoController {
    private final ProdutoRepository produtoRepository;
    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;

    }

    @GetMapping
    public List<Produto>listarProdutos(){
        return produtoRepository.findAll();
    }

    @GetMapping
    public ResponseEntity<Produto> buscarProdutoPorID(@PathVariable Long id){
        return produtoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto){
        Produto novoProduto = produtoRepository.save(produto);
        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id")
    public ResponseEntity deletarProduto(@PathVariable Long id){
        produtoRepository.deleteById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


}
