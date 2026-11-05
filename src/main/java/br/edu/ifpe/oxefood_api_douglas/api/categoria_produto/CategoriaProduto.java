package br.edu.ifpe.oxefood_api_douglas.api.categoria_produto;

import org.hibernate.annotations.SQLRestriction;

import br.edu.ifpe.oxefood_api_douglas.util.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CategoriaProduto")
@SQLRestriction("habilitado = true")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaProduto extends EntidadeAuditavel {
    @Column 
    private String descricao;
}
