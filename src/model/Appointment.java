package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import stock.Artical;

import java.time.LocalDateTime;
import java.util.ArrayList;


@Getter
@Setter
@NoArgsConstructor
public class Appointment {

    private Pet pet;
    private LocalDateTime date;

    private Bill bill;


    public boolean isUpcoming() {
        return date != null && date.isAfter(LocalDateTime.now());
    }

    public boolean isPast() {
        return date != null && date.isBefore(LocalDateTime.now());
    }

    public void assignBill(Bill bill) {
        this.bill = bill;
    }


    @Getter
    @Setter
    @NoArgsConstructor
    public static class Bill{


        private double amount;
        private ArrayList<Artical>  articalsUsed;


        public double calculateTotal() {
            double medsTotal = 0;

            if (articalsUsed != null) {
                medsTotal = articalsUsed.stream()
                        .mapToDouble(Artical::getPrice)
                        .sum();
            }

            return medsTotal + amount;
        }

        public void addArtical(Artical artical) {
            if (articalsUsed == null) {
                articalsUsed = new ArrayList<>();
            }
            articalsUsed.add(artical);
        }

        public void removeArtical(Artical artical) {
            if (articalsUsed != null) {
                articalsUsed.remove(artical);
            }
        }

        public void clear() {
            if (articalsUsed != null) {
                articalsUsed.clear();
            }
        }

        public int getTotalItems() {
            return articalsUsed != null ? articalsUsed.size() : 0;
        }
    }
}
