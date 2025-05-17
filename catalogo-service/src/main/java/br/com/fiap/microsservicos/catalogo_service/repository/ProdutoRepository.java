package br.com.fiap.microsservicos.catalogo_service.repository;
import br.com.fiap.microsservicos.catalogo_service.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
