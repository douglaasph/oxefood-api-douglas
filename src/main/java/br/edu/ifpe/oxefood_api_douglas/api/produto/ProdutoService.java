package br.edu.ifpe.oxefood_api_douglas.api.produto;

import java.util.List;

import br.edu.ifpe.oxefood_api_douglas.api.categoria_produto.CategoriaProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifpe.oxefood_api_douglas.exception.ProdutoException;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    private final CategoriaProdutoRepository categoriaProdutoRepository;

    public ProdutoService(ProdutoRepository repository, CategoriaProdutoRepository categoriaProdutoRepository) {
        this.repository = repository;
        this.categoriaProdutoRepository = categoriaProdutoRepository;
    }

    public Produto build(ProdutoDTO dto) {
        Produto produto = new Produto();

        if (dto.getId() != null) {
            produto = repository.findById(dto.getId()).get();
        }

        produto.setCategoria(categoriaProdutoRepository.findById(dto.getIdCategoria()).get());
        produto.setCodigo(dto.getCodigo());
        produto.setTitulo(dto.getTitulo());
        produto.setDescricao(dto.getDescricao());
        produto.setValorUnitario(dto.getValorUnitario());
        produto.setTempoEntregaMinimo(dto.getTempoEntregaMinimo());
        produto.setTempoEntregaMaximo(dto.getTempoEntregaMaximo());

        return produto;
    }

    @Transactional
    public Produto cadastrar(ProdutoDTO dto) {
        Produto produto = build(dto);

        if (produto.getValorUnitario() < 10) {
            throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO_PRODUTO);
        }
        return repository.save(produto);
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id).get();
    }

    @Transactional 
    public Produto atualizar(ProdutoDTO dto) {
        Produto produto = build(dto);
        return repository.save(produto);
    }

    @Transactional
    public void remover(Long id) {
        
        Produto produto = repository.findById(id).get();
        produto.setHabilitado(false);

        repository.save(produto);
   }

}
