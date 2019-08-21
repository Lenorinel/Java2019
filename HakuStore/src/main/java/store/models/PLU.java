package store.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.lang.reflect.Type;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "plu_tab")
public class PLU {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private СlothesType type;

    @Enumerated (value = EnumType.STRING)
    private  PLUSize size;

    @Column(name = "first_price")
    private Double firstPrice;

    @Column(name = "sell_price")
    private Double sellPrice;

    // Дата добавления в базу, фактически дата покупки
    private Date addingDate;
    //в наличие
    private Boolean status;

    //Это при добавлении товара в базу
    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
    //Как это будет работать поочередно? И нормально ли, что у добавленного товара уже будет колонка
    // с транзакшн_ид? или создать доп таблицу? типа два?? праймери кея на товар + транзу
    //Это при продаже, добавление в таблицу транзакций
    @ManyToOne
    @JoinColumn (name = "transaction_id")
    private Transaction transaction;

}
