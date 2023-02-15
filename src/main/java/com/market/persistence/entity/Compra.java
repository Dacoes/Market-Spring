package com.market.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Compras")
@Getter @Setter
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;
    private String estado;


    @ManyToOne
    @JoinColumn(name = "id_cliente",updatable = false,insertable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "compra")
    private List<CompraProducto> compraProducto;






}
