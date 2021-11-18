package bluebank.rest.api.controller;

import bluebank.rest.api.model.ClienteModel;
import bluebank.rest.api.repository.ClienteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST bluebank")
@CrossOrigin(origins = "*")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @GetMapping("/api/cliente")
    @ApiOperation(value = "Retorna uma lista de clientes")
    public List<ClienteModel> getAllClienteModel() {
        return (List<ClienteModel>) repository.findAll();
    }

    @GetMapping(path = "/api/cliente/{codigo}")
    @ApiOperation(value = "Retorna um cliente selecionado pelo codigo")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
        return repository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/api/cliente/salvar")
    @ApiOperation(value = "Salva um novo cliente")
    public ClienteModel salvar(@RequestBody ClienteModel cliente) {
        return repository.save(cliente);
    }

   @DeleteMapping(path = "api/cliente/{codigo}")
   @ApiOperation(value = "Deleta um cliente")
   public void deleteClienteModel(@PathVariable Integer codigo) {
        repository.deleteById(codigo);
  }

    @PutMapping(path = "api/cliente/atualizar")
    @ApiOperation(value = "atualiza os dados do cliente")
    public ClienteModel atualizar(@RequestBody ClienteModel cliente) {
        return repository.save(cliente);
    }
}
