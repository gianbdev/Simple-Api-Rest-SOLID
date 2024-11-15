package gestion_vendedor.interfaceService;
import java.util.*;

import gestion_vendedor.entities.Vendedor;

public interface IvendedorService {
    List<Vendedor> getAllVendedores();

    Optional<Vendedor> getVendedorById(int id);

    Vendedor saveVendedor(Vendedor vendedor);

    Vendedor updateVendedor(int id, Vendedor vendedor);

    void deleteVendedor(int id);
}
