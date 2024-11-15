package gestion_vendedor.controller;

import gestion_vendedor.entities.Vendedor;
import gestion_vendedor.interfaceService.IvendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Vendedores")
public class VendedorController {

    private final IvendedorService vendedorService;

    @Autowired
    public VendedorController(IvendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    // Obtener todos los vendedores
    @GetMapping
    public ResponseEntity<List<Vendedor>> getAllVendedores() {
        List<Vendedor> vendedores = vendedorService.getAllVendedores();
        return new ResponseEntity<>(vendedores, HttpStatus.OK);
    }

    // Obtener un vendedor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> getVendedorById(@PathVariable int id) {
        Optional<Vendedor> vendedor = vendedorService.getVendedorById(id);
        if (vendedor.isPresent()) {
            return new ResponseEntity<>(vendedor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Guardar un nuevo vendedor
    @PostMapping
    public ResponseEntity<?> saveVendedor(@RequestBody Vendedor vendedor) {
        // Validación simple para asegurar que el correo no sea nulo o vacío
        if (vendedor.getCorreo() == null || vendedor.getCorreo().isEmpty()) {
            return new ResponseEntity<>("El campo 'correo' no puede estar vacío.", HttpStatus.BAD_REQUEST);
        }

        Vendedor newVendedor = vendedorService.saveVendedor(vendedor);
        return new ResponseEntity<>(newVendedor, HttpStatus.CREATED);
    }

    // Actualizar un vendedor (solo los campos enviados)
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVendedor(@PathVariable int id, @RequestBody Vendedor vendedor) {
        Optional<Vendedor> vendedorExistente = vendedorService.getVendedorById(id);

        if (!vendedorExistente.isPresent()) {
            // Responder con un mensaje de error en formato String
            return new ResponseEntity<>("Vendedor no encontrado.", HttpStatus.NOT_FOUND);
        }

        Vendedor vendedorActualizado = vendedorExistente.get();

        // Actualizar solo los campos que han sido enviados en la solicitud
        if (vendedor.getNombre() != null) {
            vendedorActualizado.setNombre(vendedor.getNombre());
        }
        if (vendedor.getApellido() != null) {
            vendedorActualizado.setApellido(vendedor.getApellido());
        }
        if (vendedor.getCorreo() != null) {
            vendedorActualizado.setCorreo(vendedor.getCorreo());
        }
        if (vendedor.getCelular() != null) {
            vendedorActualizado.setCelular(vendedor.getCelular());
        }
        if (vendedor.getEstado() != null) {
            vendedorActualizado.setEstado(vendedor.getEstado());
        }

        // Guardar los cambios
        Vendedor updatedVendedor = vendedorService.saveVendedor(vendedorActualizado);

        return new ResponseEntity<>(updatedVendedor, HttpStatus.OK);
    }

    // Eliminar un vendedor
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVendedor(@PathVariable int id) {
        vendedorService.deleteVendedor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
