package br.edu.ifpe.oxefood_api_douglas.api.empresa;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresa")
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) { this.empresaService = empresaService; }

    @PostMapping
    public ResponseEntity<Empresa> cadastrar(@RequestBody EmpresaDTO dto) {
        Empresa empresaCadastrado = empresaService.cadastrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaCadastrado);
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> listar() {

        return ResponseEntity.ok(empresaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empresa> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(empresaService.buscarPorId(id));
    }

    @PutMapping
    public ResponseEntity<Empresa> atualizar(@RequestBody EmpresaDTO dto) {

        Empresa empresaAtualizado = empresaService.atualizar(dto);
        return ResponseEntity.ok(empresaAtualizado);
    }
    
    @DeleteMapping("/{id}")
   public ResponseEntity<Void> remover(@PathVariable Long id) {
        empresaService.remover(id);
        return ResponseEntity.noContent().build();
   }
}
