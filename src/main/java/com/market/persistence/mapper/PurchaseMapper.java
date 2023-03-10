package com.market.persistence.mapper;

import com.market.domain.Purchase;
import com.market.persistence.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring",uses = {PurchaseitemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "idCompra",target = "purchaseId"),
            @Mapping(source = "idCliente",target = "clientId"),
            @Mapping(source = "fecha",target = "date"),
            @Mapping(source = "medioPago",target = "paymentMethod"),
            @Mapping(source = "comentario",target = "comment"),
            @Mapping(source = "estado",target = "state"),
            @Mapping(source = "compraProducto",target = "item")
    })
    Purchase toPurchase(Compra compra);

    List<Purchase> toPurchaseList(List<Compra> compraList);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "cliente",ignore = true),
    })
    Compra toCompra(Purchase purchase);
}
