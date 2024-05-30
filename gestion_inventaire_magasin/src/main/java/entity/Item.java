package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private CategoryItem category;
    private SizeItem size;
    private double price;
    private int quantity;

    @OneToMany(mappedBy = "item")
    private List<Order> orders = new ArrayList<>();
    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", size=" + size +
                ", price=" + price +
                ", quantity="+ quantity +
                "}\n";
    }
}
