package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import service.OrderService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private SaleState state;

    @Temporal(TemporalType.DATE)
    private Date dateSale = new Date();

    private String ordersToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Order order : orders) {
            sb.append("{").append(order.toString()).append("}, ");
        }
        if (!orders.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", client=" + client.getName() + " " + client.getEmail() +
                ", state=" + state +
                ","+ordersToString()+
                ", dateSale=" + dateSale.toString() +
                '}';
    }
}
