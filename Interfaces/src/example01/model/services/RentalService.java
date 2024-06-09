package example01.model.services;

import java.time.Duration;

import example01.model.entities.CarRental;
import example01.model.entities.Invoice;

public class RentalService {
  private TaxService taxService;

  private Double pricePerHour;
  private Double pricePerDay;

  public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
    this.pricePerHour = pricePerHour;
    this.pricePerDay = pricePerDay;
    this.taxService = taxService;
  }

  public void processInvoice(CarRental carRental) {
    double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
    double hours = minutes / 60.0;

    double basicPayment;

    if (hours <= 12.0) {
      basicPayment = pricePerHour * Math.ceil(hours);
    } else {
      basicPayment = pricePerDay * Math.ceil(hours / 24.0);
    }

    double tax = taxService.tax(basicPayment);

    carRental.setInvoice(new Invoice(basicPayment, tax));
  }
}