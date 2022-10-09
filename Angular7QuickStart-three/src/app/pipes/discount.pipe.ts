import { Pipe, PipeTransform } from '@angular/core';
import { CurrencyPipe } from '@angular/common';

@Pipe({
  name: 'discount'
})
export class DiscountPipe implements PipeTransform {

  constructor( private currency: CurrencyPipe  ) {}

  transform(price: number, discountPct: number, symbol = 'USD' ): any {

    let newPrice = price - (price * discountPct / 100);
    let newPriceWithCurrency = this.currency.transform(newPrice, symbol);
    let priceWithCurrency = this.currency.transform(price, symbol);

    return `Actual price ${priceWithCurrency}, after ${discountPct}% discount ${newPriceWithCurrency}`;
    //return newPrice;
  }

}
