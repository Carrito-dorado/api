package com.example.carritodorado.service;

import com.example.carritodorado.model.Carrito;
import com.example.carritodorado.model.DetalleCarrito;
import com.example.carritodorado.model.Producto;
import com.example.carritodorado.model.Usuario;
import com.example.carritodorado.repository.CarritoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarritoServiceImpl implements CarritoService {

    private final CarritoRepository carritoRepository;

    private final UsuarioService usuarioService;

    private final ProductoService productoService;

    @Override
    public Carrito create(Carrito carrito) {

        Usuario usuario = usuarioService.findById(carrito.getUsuario().getId());
        double total =0;
        for(DetalleCarrito line: carrito.getDetallesCarrito()) {
            Producto product= productoService.findById(line.getProducto().getId());
            line.setPrecio(product.getPrecio());
            line.setTotal(product.getPrecio() * line.getCantidad());
            line.setProducto(product);
            total+= line.getTotal();

        }
        carrito.setTotal(total);
        carrito.getDetallesCarrito().forEach(line-> line.setCarrito(carrito));

        if (carrito.getId() == null) {
            carrito.setUsuario(usuario);

            return carritoRepository.save(carrito);

        }

        return carritoRepository.save(carrito);
    }
}
