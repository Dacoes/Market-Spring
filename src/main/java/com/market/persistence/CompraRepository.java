package com.market.persistence;

import com.market.domain.Purchase;
import com.market.domain.repository.PurchaseRepository;
import com.market.persistence.CRUD.CompraCrudRepository;
import com.market.persistence.entity.Compra;
import com.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository repository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchaseList((List<Compra>) repository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return repository.findByIdCliente(clientId).map(
                compras -> mapper.toPurchaseList(compras)
                );
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getCompraProducto().forEach(
                producto -> producto.setCompra(compra)
        );
        return mapper.toPurchase(repository.save(compra));
    }
}
