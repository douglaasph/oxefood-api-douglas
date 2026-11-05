package br.edu.ifpe.oxefood_api_douglas.api.produto;

import br.edu.ifpe.oxefood_api_douglas.api.categoria_produto.CategoriaProduto;
import br.edu.ifpe.oxefood_api_douglas.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends EntidadeAuditavel {
    @ManyToOne
   private CategoriaProduto categoria;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column
    private String codigo;

    @Column
    private String titulo;

    @Column
    private String descricao;

    @Column
    private Double valorUnitario;

    @Column
    private Integer tempoEntregaMinimo;

    @Column
    private Integer tempoEntregaMaximo;
}
