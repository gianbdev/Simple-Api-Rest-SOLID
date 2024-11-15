package gestion_vendedor.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion_vendedor.entities.Vendedor;
import gestion_vendedor.interfaceService.IvendedorService;
import gestion_vendedor.repository.VendedorRepository;

@Service
public class VendedorService implements IvendedorService {
	@Autowired
	private final VendedorRepository vendedorRepository;
	
    @Autowired
    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }
	
    @Override
	public List<Vendedor> getAllVendedores(){
		return vendedorRepository.findAll();
	}
	
    @Override
	public Optional<Vendedor> getVendedorById(int id) {
        return vendedorRepository.findById(id);
	}
	
    @Override
	public Vendedor saveVendedor(Vendedor vendedor) {
		Vendedor newVendedor = vendedorRepository.save(vendedor);
		return newVendedor;
	}

	@Override
	public Vendedor updateVendedor(int id, Vendedor vendedor) {
		  return vendedorRepository.findById(id)
	                .map(existingVendedor -> {
	                    existingVendedor.setNombre(vendedor.getNombre());
	                    existingVendedor.setApellido(vendedor.getApellido());
	                    existingVendedor.setCorreo(vendedor.getCorreo());
	                    existingVendedor.setCelular(vendedor.getCelular());  // Cambié a 'setCelular'
	                    existingVendedor.setEstado(vendedor.getEstado()); 
	                    return vendedorRepository.save(existingVendedor);
	                })
	                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
	}

	@Override
	public void deleteVendedor(int id) {
        vendedorRepository.deleteById(id);
	}
}
