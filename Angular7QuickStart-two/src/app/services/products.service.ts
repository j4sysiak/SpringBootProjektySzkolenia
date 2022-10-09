import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductsService {

  products: Array<any>;

  constructor() {

    this.products = [
      {
        "ID": 1,
        "NAME": "Onion",
        "CATEGORY_NAME": "Vegitables",
        "BRAND_NAME": "Fresho",
        "DESCRIPTION": "Onion - Medium",
        "QUANTITY_PER_UNIT": "1 KG, approx. 10 to 12 nos",
        "UNIT_PRICE": 45,
        "PICTURE": "http://kvinod.com/resources/product-images/10000148_13-fresho-onion-medium.jpg",
        "DISCOUNT": 22
      } ,
      {
        "ID": 2,
        "NAME": "Potato",
        "CATEGORY_NAME": "Vegitables",
        "BRAND_NAME": "Fresho",
        "DESCRIPTION": "Potato",
        "QUANTITY_PER_UNIT": "1 KG, approx. 9 to 10 nos",
        "UNIT_PRICE": 25,
        "PICTURE": "http://kvinod.com/resources/product-images/10000159_14-fresho-potato.jpg",
        "DISCOUNT": 2
      },
      {
        "ID": 3,
        "NAME": "Tomato",
        "CATEGORY_NAME": "Vegitables",
        "BRAND_NAME": "Malnad",
        "DESCRIPTION": "Hybrid tomato",
        "QUANTITY_PER_UNIT": "500 GM, approx. 6 to 7 nos",
        "UNIT_PRICE": 28,
        "PICTURE": "http://kvinod.com/resources/product-images/10000201_12-fresho-tomato-hybrid.jpg",
        "DISCOUNT": 12
      }
    ];

   }


   getAllProducts(): Array<any> {
     return this.products;
   }

   getProductById(id: number): any {
     return this.products.find(p=>p.ID===id);
   }

}
